package beepbeep.constraintsetstudy

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 1. Inflate the TextView row & add the the TextView
        val textViewRow = LayoutInflater.from(this).inflate(R.layout.text_view_row, constraintLayout, false)
        constraintLayout.addView(textViewRow)

        // 2. Clone the constraints into ConstraintSet
        val set = ConstraintSet()
        set.clone(constraintLayout)

        // 3. Connect TextView row with ConstraintLayout
        set.connect(textViewRow.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        set.connect(textViewRow.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        set.connect(textViewRow.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

        // 4. applying the constraint
        set.applyTo(constraintLayout)
    }
}

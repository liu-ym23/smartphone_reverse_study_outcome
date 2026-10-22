package stepos.support.v7.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.D;

/* loaded from: classes.dex */
public class CenterIfNeedTextView extends D {
    public CenterIfNeedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.D, android.widget.TextView, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        Layout layout = getLayout();
        if (layout != null) {
            if (layout.getLineCount() == 1) {
                setGravity(17);
            } else {
                setGravity(8388611);
            }
            super.onMeasure(i5, i6);
        }
    }
}

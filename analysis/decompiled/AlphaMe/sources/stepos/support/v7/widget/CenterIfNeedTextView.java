package stepos.support.v7.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.C0200f0;

/* loaded from: classes2.dex */
public class CenterIfNeedTextView extends C0200f0 {
    public CenterIfNeedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.C0200f0, android.widget.TextView, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        Layout layout = getLayout();
        if (layout != null) {
            if (layout.getLineCount() == 1) {
                setGravity(17);
            } else {
                setGravity(8388611);
            }
            super.onMeasure(i4, i5);
        }
    }
}

package stepos.support.v7.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes5.dex */
public class CenterIfNeedTextView extends AppCompatTextView {
    public CenterIfNeedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        Layout layout = getLayout();
        if (layout != null) {
            if (layout.getLineCount() == 1) {
                setGravity(17);
            } else {
                setGravity(8388611);
            }
            super.onMeasure(i10, i11);
        }
    }
}

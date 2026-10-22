package stepos.support.v7.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.GravityCompat;

/* loaded from: classes4.dex */
public class CenterIfNeedTextView extends AppCompatTextView {
    public CenterIfNeedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i6) {
        super.onMeasure(i, i6);
        Layout layout = getLayout();
        if (layout != null) {
            if (layout.getLineCount() == 1) {
                setGravity(17);
            } else {
                setGravity(GravityCompat.START);
            }
            super.onMeasure(i, i6);
        }
    }
}

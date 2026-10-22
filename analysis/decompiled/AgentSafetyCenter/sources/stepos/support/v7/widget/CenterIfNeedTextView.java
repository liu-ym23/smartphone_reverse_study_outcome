package stepos.support.v7.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class CenterIfNeedTextView extends m.v0 {
    public CenterIfNeedTextView(Context context) {
        super(context, null);
    }

    @Override // m.v0, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i3) {
        super.onMeasure(i, i3);
        Layout layout = getLayout();
        if (layout != null) {
            if (layout.getLineCount() == 1) {
                setGravity(17);
            } else {
                setGravity(8388611);
            }
            super.onMeasure(i, i3);
        }
    }

    public CenterIfNeedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CenterIfNeedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class LitePopupContentFrameLayout extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public int f12611c;

    public LitePopupContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12611c = -1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        if (this.f12611c == -1) {
            super.onMeasure(i, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.f12611c, mode));
        if (mode == 1073741824) {
            setMeasuredDimension(getMeasuredWidth(), size);
        }
    }

    public void setLimitHeight(int i) {
        this.f12611c = i;
    }

    public LitePopupContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LitePopupContentFrameLayout(Context context) {
        this(context, null);
    }
}

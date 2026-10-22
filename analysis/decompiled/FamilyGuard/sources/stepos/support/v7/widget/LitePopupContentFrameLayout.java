package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class LitePopupContentFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f21570a;

    public LitePopupContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        if (this.f21570a == -1) {
            super.onMeasure(i5, i6);
            return;
        }
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec(this.f21570a, mode));
        if (mode == 1073741824) {
            setMeasuredDimension(getMeasuredWidth(), size);
        }
    }

    public void setLimitHeight(int i5) {
        this.f21570a = i5;
    }

    public LitePopupContentFrameLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f21570a = -1;
    }
}

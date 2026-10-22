package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes5.dex */
public class LitePopupContentFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public int f41224a;

    public LitePopupContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f41224a == -1) {
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(this.f41224a, mode));
        if (mode == 1073741824) {
            setMeasuredDimension(getMeasuredWidth(), size);
        }
    }

    public void setLimitHeight(int i10) {
        this.f41224a = i10;
    }

    public LitePopupContentFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41224a = -1;
    }
}

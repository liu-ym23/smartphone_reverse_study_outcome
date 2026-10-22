package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class LitePopupContentFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public int f12540a;

    public LitePopupContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f12540a = -1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        if (this.f12540a == -1) {
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(this.f12540a, mode));
        if (mode == 1073741824) {
            setMeasuredDimension(getMeasuredWidth(), size);
        }
    }

    public void setLimitHeight(int i10) {
        this.f12540a = i10;
    }
}

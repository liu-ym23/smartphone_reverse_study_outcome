package A2;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import g2.C0737g;

/* loaded from: classes.dex */
public class D extends HistogramView {

    /* renamed from: h0, reason: collision with root package name */
    private int f82h0;

    public D(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getTopSpace() {
        return this.f82h0;
    }

    @Override // y2.AbstractC1325f, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        int i9 = i7 - i5;
        int i10 = i8 - i6;
        AbstractC0264c backgroundLayer = getBackgroundLayer();
        if (backgroundLayer != null && backgroundLayer.e()) {
            backgroundLayer.l(this, z5, 0, getTopSpace(), i9, i10);
        }
        y2.h dataLayer = getDataLayer();
        if (dataLayer != null && dataLayer.e()) {
            if (backgroundLayer != null) {
                Rect rectM = backgroundLayer.m();
                dataLayer.l(this, z5, rectM.left, rectM.top, rectM.right, rectM.bottom);
            } else {
                dataLayer.l(this, z5, 0, getTopSpace(), i9, i10);
            }
        }
        y2.i foregroundLayer = getForegroundLayer();
        if (foregroundLayer == null || !foregroundLayer.e()) {
            return;
        }
        foregroundLayer.l(this, z5, 0, 0, i9, i10);
    }

    @Override // y2.AbstractC1325f, android.view.View
    protected void onMeasure(int i5, int i6) {
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        View.MeasureSpec.getMode(i5);
        int mode = View.MeasureSpec.getMode(i6);
        int iMax = size2 - this.f82h0;
        super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec(iMax, mode));
        if (getForegroundLayer() != null) {
            int[] iArrJ = getForegroundLayer().j(this, i5, i6);
            int iMax2 = Math.max(iArrJ[0], getMeasuredWidth());
            iMax = Math.max(iArrJ[1], getMeasuredHeight());
            size = iMax2;
        }
        setMeasuredDimension(View.resolveSize(size, i5), View.resolveSize(iMax, i6));
    }

    public void setTopSpace(int i5) {
        this.f82h0 = i5;
    }

    public D(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public D(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        Resources.Theme theme = context.getTheme();
        context.getResources();
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, C0737g.f17348S4, i5, i6);
        this.f82h0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
    }
}

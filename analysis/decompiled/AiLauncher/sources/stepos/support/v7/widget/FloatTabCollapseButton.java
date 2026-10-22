package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import stepos.support.v7.appcompat.R$attr;

/* loaded from: classes5.dex */
public class FloatTabCollapseButton extends u {

    /* renamed from: g, reason: collision with root package name */
    public static final Interpolator f41221g = D0.a.a(0.18f, 0.236f, 0.1f, 1.0f);

    /* renamed from: e, reason: collision with root package name */
    public int f41222e;

    /* renamed from: f, reason: collision with root package name */
    public final float f41223f;

    public FloatTabCollapseButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.steposFloatTabContainerCollapseButtonStyle);
    }

    @Override // stepos.support.v7.widget.u
    public i.h g(boolean z10) {
        return super.g(z10);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(this.f41222e, 1073741824));
    }

    public FloatTabCollapseButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41222e = Ic.a.b(context).h();
        setVisibility(8);
        this.f41223f = getResources().getDisplayMetrics().density * 8.0f;
        setBackgroundDrawable(null);
    }
}

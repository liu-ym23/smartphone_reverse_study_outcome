package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public class FloatTabCollapseButton extends y {

    /* renamed from: j, reason: collision with root package name */
    private static final Interpolator f21567j = androidx.core.view.animation.a.a(0.18f, 0.236f, 0.1f, 1.0f);

    /* renamed from: h, reason: collision with root package name */
    private int f21568h;

    /* renamed from: i, reason: collision with root package name */
    private final float f21569i;

    public FloatTabCollapseButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X4.a.f5845u);
    }

    @Override // stepos.support.v7.widget.y
    protected androidx.appcompat.view.h g(boolean z5) {
        return super.g(z5);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec(this.f21568h, 1073741824));
    }

    public FloatTabCollapseButton(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f21568h = b5.a.b(context).h();
        setVisibility(8);
        this.f21569i = getResources().getDisplayMetrics().density * 8.0f;
        setBackgroundDrawable(null);
    }
}

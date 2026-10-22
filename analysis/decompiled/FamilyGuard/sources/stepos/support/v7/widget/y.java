package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.core.view.H;
import androidx.core.view.S;
import androidx.core.view.T;

/* loaded from: classes.dex */
public class y extends androidx.appcompat.widget.r implements T {

    /* renamed from: g, reason: collision with root package name */
    private static final Interpolator f22284g = androidx.core.view.animation.a.a(0.18f, 0.367f, 0.0f, 1.0f);

    /* renamed from: d, reason: collision with root package name */
    private boolean f22285d;

    /* renamed from: e, reason: collision with root package name */
    private androidx.appcompat.view.h f22286e;

    /* renamed from: f, reason: collision with root package name */
    private Matrix f22287f;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            y.this.h();
        }
    }

    public interface b {
    }

    public y(Context context) {
        this(context, null);
    }

    private void f(boolean z5) {
        androidx.appcompat.view.h hVar = this.f22286e;
        if (hVar != null) {
            hVar.a();
        }
        androidx.appcompat.view.h hVarG = g(z5);
        this.f22286e = hVarG;
        hVarG.h();
    }

    @Override // androidx.core.view.T
    public void c(View view) {
    }

    @Override // androidx.core.view.T
    public void d(View view) {
        if (this.f22285d) {
            H.y0(this, 0.0f);
        }
    }

    @Override // androidx.core.view.T
    public void e(View view) {
    }

    protected androidx.appcompat.view.h g(boolean z5) {
        S sE;
        androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
        if (z5) {
            H.y0(this, 180.0f);
            sE = H.d(this).e(360.0f);
        } else {
            H.y0(this, 0.0f);
            sE = H.d(this).e(180.0f);
        }
        sE.i(f22284g);
        sE.h(350L);
        hVar.c(sE);
        hVar.g(this);
        return hVar;
    }

    protected void h() {
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        setPivotX(getMeasuredWidth() / 2);
        setPivotY(getMeasuredHeight() / 2);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        return true;
    }

    public void setCollapsed(boolean z5) {
        if (this.f22285d != z5) {
            this.f22285d = z5;
            f(z5);
        }
    }

    public void setOnTabCollapseButtonClickListener(b bVar) {
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        if (getScaleType() == ImageView.ScaleType.MATRIX && this.f22287f == null) {
            this.f22287f = new Matrix();
        }
    }

    public y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X4.a.f5848x);
    }

    public y(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f22285d = true;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnClickListener(new a());
        setBackgroundDrawable(null);
    }
}

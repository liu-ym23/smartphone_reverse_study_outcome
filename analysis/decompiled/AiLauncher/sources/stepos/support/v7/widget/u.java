package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.N;
import androidx.core.view.U;
import androidx.core.view.V;
import stepos.support.v7.appcompat.R$attr;

/* loaded from: classes5.dex */
public class u extends AppCompatImageView implements V {

    /* renamed from: d, reason: collision with root package name */
    public static final Interpolator f41733d = D0.a.a(0.18f, 0.367f, 0.0f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public boolean f41734a;

    /* renamed from: b, reason: collision with root package name */
    public i.h f41735b;

    /* renamed from: c, reason: collision with root package name */
    public Matrix f41736c;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            u.this.h();
        }
    }

    public interface b {
    }

    public u(Context context) {
        this(context, null);
    }

    @Override // androidx.core.view.V
    public void c(View view) {
    }

    @Override // androidx.core.view.V
    public void d(View view) {
        if (this.f41734a) {
            N.y0(this, 0.0f);
        }
    }

    @Override // androidx.core.view.V
    public void e(View view) {
    }

    public final void f(boolean z10) {
        i.h hVar = this.f41735b;
        if (hVar != null) {
            hVar.a();
        }
        i.h hVarG = g(z10);
        this.f41735b = hVarG;
        hVarG.h();
    }

    public i.h g(boolean z10) {
        U uE;
        i.h hVar = new i.h();
        if (z10) {
            N.y0(this, 180.0f);
            uE = N.d(this).e(360.0f);
        } else {
            N.y0(this, 0.0f);
            uE = N.d(this).e(180.0f);
        }
        uE.g(f41733d);
        uE.f(350L);
        hVar.c(uE);
        hVar.g(this);
        return hVar;
    }

    public void h() {
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
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

    public void setCollapsed(boolean z10) {
        if (this.f41734a != z10) {
            this.f41734a = z10;
            f(z10);
        }
    }

    public void setOnTabCollapseButtonClickListener(b bVar) {
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        if (getScaleType() == ImageView.ScaleType.MATRIX && this.f41736c == null) {
            this.f41736c = new Matrix();
        }
    }

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.steposTabContainerCollapseButtonStyle);
    }

    public u(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41734a = true;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnClickListener(new a());
        setBackgroundDrawable(null);
    }
}

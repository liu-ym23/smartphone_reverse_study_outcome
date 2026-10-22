package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;
import u0.C5566a;

/* renamed from: androidx.appcompat.widget.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1307u extends C1303p {

    /* renamed from: d, reason: collision with root package name */
    public final SeekBar f9234d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f9235e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f9236f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f9237g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9238h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9239i;

    public C1307u(SeekBar seekBar) {
        super(seekBar);
        this.f9236f = null;
        this.f9237g = null;
        this.f9238h = false;
        this.f9239i = false;
        this.f9234d = seekBar;
    }

    @Override // androidx.appcompat.widget.C1303p
    public void c(AttributeSet attributeSet, int i10) {
        super.c(attributeSet, i10);
        Context context = this.f9234d.getContext();
        int[] iArr = R$styleable.AppCompatSeekBar;
        U uV = U.v(context, attributeSet, iArr, i10, 0);
        SeekBar seekBar = this.f9234d;
        androidx.core.view.N.g0(seekBar, seekBar.getContext(), iArr, attributeSet, uV.r(), i10, 0);
        Drawable drawableH = uV.h(R$styleable.AppCompatSeekBar_android_thumb);
        if (drawableH != null) {
            this.f9234d.setThumb(drawableH);
        }
        j(uV.g(R$styleable.AppCompatSeekBar_tickMark));
        int i11 = R$styleable.AppCompatSeekBar_tickMarkTintMode;
        if (uV.s(i11)) {
            this.f9237g = B.d(uV.k(i11, -1), this.f9237g);
            this.f9239i = true;
        }
        int i12 = R$styleable.AppCompatSeekBar_tickMarkTint;
        if (uV.s(i12)) {
            this.f9236f = uV.c(i12);
            this.f9238h = true;
        }
        uV.x();
        f();
    }

    public final void f() {
        Drawable drawable = this.f9235e;
        if (drawable != null) {
            if (this.f9238h || this.f9239i) {
                Drawable drawableR = C5566a.r(drawable.mutate());
                this.f9235e = drawableR;
                if (this.f9238h) {
                    C5566a.o(drawableR, this.f9236f);
                }
                if (this.f9239i) {
                    C5566a.p(this.f9235e, this.f9237g);
                }
                if (this.f9235e.isStateful()) {
                    this.f9235e.setState(this.f9234d.getDrawableState());
                }
            }
        }
    }

    public void g(Canvas canvas) {
        if (this.f9235e != null) {
            int max = this.f9234d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f9235e.getIntrinsicWidth();
                int intrinsicHeight = this.f9235e.getIntrinsicHeight();
                int i10 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i11 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f9235e.setBounds(-i10, -i11, i10, i11);
                float width = ((this.f9234d.getWidth() - this.f9234d.getPaddingLeft()) - this.f9234d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f9234d.getPaddingLeft(), this.f9234d.getHeight() / 2);
                for (int i12 = 0; i12 <= max; i12++) {
                    this.f9235e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    public void h() {
        Drawable drawable = this.f9235e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f9234d.getDrawableState())) {
            this.f9234d.invalidateDrawable(drawable);
        }
    }

    public void i() {
        Drawable drawable = this.f9235e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void j(Drawable drawable) {
        Drawable drawable2 = this.f9235e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f9235e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f9234d);
            C5566a.m(drawable, this.f9234d.getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(this.f9234d.getDrawableState());
            }
            f();
        }
        this.f9234d.invalidate();
    }
}

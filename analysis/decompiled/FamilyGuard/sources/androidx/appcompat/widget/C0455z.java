package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* renamed from: androidx.appcompat.widget.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0455z extends C0450u {

    /* renamed from: d, reason: collision with root package name */
    private final SeekBar f8618d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f8619e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f8620f;

    /* renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f8621g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8622h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8623i;

    C0455z(SeekBar seekBar) {
        super(seekBar);
        this.f8620f = null;
        this.f8621g = null;
        this.f8622h = false;
        this.f8623i = false;
        this.f8618d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f8619e;
        if (drawable != null) {
            if (this.f8622h || this.f8623i) {
                Drawable drawableR = androidx.core.graphics.drawable.a.r(drawable.mutate());
                this.f8619e = drawableR;
                if (this.f8622h) {
                    androidx.core.graphics.drawable.a.o(drawableR, this.f8620f);
                }
                if (this.f8623i) {
                    androidx.core.graphics.drawable.a.p(this.f8619e, this.f8621g);
                }
                if (this.f8619e.isStateful()) {
                    this.f8619e.setState(this.f8618d.getDrawableState());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.C0450u
    void c(AttributeSet attributeSet, int i5) {
        super.c(attributeSet, i5);
        Context context = this.f8618d.getContext();
        int[] iArr = g.j.f17066T;
        a0 a0VarV = a0.v(context, attributeSet, iArr, i5, 0);
        SeekBar seekBar = this.f8618d;
        androidx.core.view.H.i0(seekBar, seekBar.getContext(), iArr, attributeSet, a0VarV.r(), i5, 0);
        Drawable drawableH = a0VarV.h(g.j.f17070U);
        if (drawableH != null) {
            this.f8618d.setThumb(drawableH);
        }
        j(a0VarV.g(g.j.f17074V));
        int i6 = g.j.f17082X;
        if (a0VarV.s(i6)) {
            this.f8621g = I.d(a0VarV.k(i6, -1), this.f8621g);
            this.f8623i = true;
        }
        int i7 = g.j.f17078W;
        if (a0VarV.s(i7)) {
            this.f8620f = a0VarV.c(i7);
            this.f8622h = true;
        }
        a0VarV.x();
        f();
    }

    void g(Canvas canvas) {
        if (this.f8619e != null) {
            int max = this.f8618d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f8619e.getIntrinsicWidth();
                int intrinsicHeight = this.f8619e.getIntrinsicHeight();
                int i5 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i6 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f8619e.setBounds(-i5, -i6, i5, i6);
                float width = ((this.f8618d.getWidth() - this.f8618d.getPaddingLeft()) - this.f8618d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f8618d.getPaddingLeft(), this.f8618d.getHeight() / 2);
                for (int i7 = 0; i7 <= max; i7++) {
                    this.f8619e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    void h() {
        Drawable drawable = this.f8619e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f8618d.getDrawableState())) {
            this.f8618d.invalidateDrawable(drawable);
        }
    }

    void i() {
        Drawable drawable = this.f8619e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f8619e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f8619e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f8618d);
            androidx.core.graphics.drawable.a.m(drawable, this.f8618d.getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(this.f8618d.getDrawableState());
            }
            f();
        }
        this.f8618d.invalidate();
    }
}

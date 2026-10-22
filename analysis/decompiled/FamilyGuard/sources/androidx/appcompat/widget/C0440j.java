package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import h.C0744a;

/* renamed from: androidx.appcompat.widget.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0440j {

    /* renamed from: a, reason: collision with root package name */
    private final CompoundButton f8566a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f8567b = null;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f8568c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8569d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f8570e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f8571f;

    C0440j(CompoundButton compoundButton) {
        this.f8566a = compoundButton;
    }

    void a() {
        Drawable drawableA = androidx.core.widget.c.a(this.f8566a);
        if (drawableA != null) {
            if (this.f8569d || this.f8570e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawableA).mutate();
                if (this.f8569d) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f8567b);
                }
                if (this.f8570e) {
                    androidx.core.graphics.drawable.a.p(drawableMutate, this.f8568c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f8566a.getDrawableState());
                }
                this.f8566a.setButtonDrawable(drawableMutate);
            }
        }
    }

    ColorStateList b() {
        return this.f8567b;
    }

    PorterDuff.Mode c() {
        return this.f8568c;
    }

    void d(AttributeSet attributeSet, int i5) {
        int iN;
        int iN2;
        Context context = this.f8566a.getContext();
        int[] iArr = g.j.f17071U0;
        a0 a0VarV = a0.v(context, attributeSet, iArr, i5, 0);
        CompoundButton compoundButton = this.f8566a;
        androidx.core.view.H.i0(compoundButton, compoundButton.getContext(), iArr, attributeSet, a0VarV.r(), i5, 0);
        try {
            int i6 = g.j.f17079W0;
            if (!a0VarV.s(i6) || (iN2 = a0VarV.n(i6, 0)) == 0) {
                int i7 = g.j.f17075V0;
                if (a0VarV.s(i7) && (iN = a0VarV.n(i7, 0)) != 0) {
                    CompoundButton compoundButton2 = this.f8566a;
                    compoundButton2.setButtonDrawable(C0744a.b(compoundButton2.getContext(), iN));
                }
            } else {
                try {
                    CompoundButton compoundButton3 = this.f8566a;
                    compoundButton3.setButtonDrawable(C0744a.b(compoundButton3.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                }
            }
            int i8 = g.j.f17083X0;
            if (a0VarV.s(i8)) {
                androidx.core.widget.c.d(this.f8566a, a0VarV.c(i8));
            }
            int i9 = g.j.f17087Y0;
            if (a0VarV.s(i9)) {
                androidx.core.widget.c.e(this.f8566a, I.d(a0VarV.k(i9, -1), null));
            }
            a0VarV.x();
        } catch (Throwable th) {
            a0VarV.x();
            throw th;
        }
    }

    void e() {
        if (this.f8571f) {
            this.f8571f = false;
        } else {
            this.f8571f = true;
            a();
        }
    }

    void f(ColorStateList colorStateList) {
        this.f8567b = colorStateList;
        this.f8569d = true;
        a();
    }

    void g(PorterDuff.Mode mode) {
        this.f8568c = mode;
        this.f8570e = true;
        a();
    }
}

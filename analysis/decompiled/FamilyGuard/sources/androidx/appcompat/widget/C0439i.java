package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import h.C0744a;

/* renamed from: androidx.appcompat.widget.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0439i {

    /* renamed from: a, reason: collision with root package name */
    private final CheckedTextView f8560a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f8561b = null;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f8562c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8563d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f8564e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f8565f;

    C0439i(CheckedTextView checkedTextView) {
        this.f8560a = checkedTextView;
    }

    void a() {
        Drawable drawableA = androidx.core.widget.b.a(this.f8560a);
        if (drawableA != null) {
            if (this.f8563d || this.f8564e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawableA).mutate();
                if (this.f8563d) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f8561b);
                }
                if (this.f8564e) {
                    androidx.core.graphics.drawable.a.p(drawableMutate, this.f8562c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f8560a.getDrawableState());
                }
                this.f8560a.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    ColorStateList b() {
        return this.f8561b;
    }

    PorterDuff.Mode c() {
        return this.f8562c;
    }

    void d(AttributeSet attributeSet, int i5) {
        int iN;
        int iN2;
        Context context = this.f8560a.getContext();
        int[] iArr = g.j.f17051P0;
        a0 a0VarV = a0.v(context, attributeSet, iArr, i5, 0);
        CheckedTextView checkedTextView = this.f8560a;
        androidx.core.view.H.i0(checkedTextView, checkedTextView.getContext(), iArr, attributeSet, a0VarV.r(), i5, 0);
        try {
            int i6 = g.j.f17059R0;
            if (!a0VarV.s(i6) || (iN2 = a0VarV.n(i6, 0)) == 0) {
                int i7 = g.j.f17055Q0;
                if (a0VarV.s(i7) && (iN = a0VarV.n(i7, 0)) != 0) {
                    CheckedTextView checkedTextView2 = this.f8560a;
                    checkedTextView2.setCheckMarkDrawable(C0744a.b(checkedTextView2.getContext(), iN));
                }
            } else {
                try {
                    CheckedTextView checkedTextView3 = this.f8560a;
                    checkedTextView3.setCheckMarkDrawable(C0744a.b(checkedTextView3.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                }
            }
            int i8 = g.j.f17063S0;
            if (a0VarV.s(i8)) {
                androidx.core.widget.b.b(this.f8560a, a0VarV.c(i8));
            }
            int i9 = g.j.f17067T0;
            if (a0VarV.s(i9)) {
                androidx.core.widget.b.c(this.f8560a, I.d(a0VarV.k(i9, -1), null));
            }
            a0VarV.x();
        } catch (Throwable th) {
            a0VarV.x();
            throw th;
        }
    }

    void e() {
        if (this.f8565f) {
            this.f8565f = false;
        } else {
            this.f8565f = true;
            a();
        }
    }

    void f(ColorStateList colorStateList) {
        this.f8561b = colorStateList;
        this.f8563d = true;
        a();
    }

    void g(PorterDuff.Mode mode) {
        this.f8562c = mode;
        this.f8564e = true;
        a();
    }
}

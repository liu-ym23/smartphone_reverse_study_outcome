package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: androidx.appcompat.widget.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0435e {

    /* renamed from: a, reason: collision with root package name */
    private final View f8518a;

    /* renamed from: d, reason: collision with root package name */
    private Y f8521d;

    /* renamed from: e, reason: collision with root package name */
    private Y f8522e;

    /* renamed from: f, reason: collision with root package name */
    private Y f8523f;

    /* renamed from: c, reason: collision with root package name */
    private int f8520c = -1;

    /* renamed from: b, reason: collision with root package name */
    private final C0441k f8519b = C0441k.b();

    C0435e(View view) {
        this.f8518a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f8523f == null) {
            this.f8523f = new Y();
        }
        Y y5 = this.f8523f;
        y5.a();
        ColorStateList colorStateListQ = androidx.core.view.H.q(this.f8518a);
        if (colorStateListQ != null) {
            y5.f8465d = true;
            y5.f8462a = colorStateListQ;
        }
        PorterDuff.Mode modeR = androidx.core.view.H.r(this.f8518a);
        if (modeR != null) {
            y5.f8464c = true;
            y5.f8463b = modeR;
        }
        if (!y5.f8465d && !y5.f8464c) {
            return false;
        }
        C0441k.i(drawable, y5, this.f8518a.getDrawableState());
        return true;
    }

    private boolean k() {
        return this.f8521d != null;
    }

    void b() {
        Drawable background = this.f8518a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            Y y5 = this.f8522e;
            if (y5 != null) {
                C0441k.i(background, y5, this.f8518a.getDrawableState());
                return;
            }
            Y y6 = this.f8521d;
            if (y6 != null) {
                C0441k.i(background, y6, this.f8518a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        Y y5 = this.f8522e;
        if (y5 != null) {
            return y5.f8462a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        Y y5 = this.f8522e;
        if (y5 != null) {
            return y5.f8463b;
        }
        return null;
    }

    void e(AttributeSet attributeSet, int i5) {
        Context context = this.f8518a.getContext();
        int[] iArr = g.j.f16986A3;
        a0 a0VarV = a0.v(context, attributeSet, iArr, i5, 0);
        View view = this.f8518a;
        androidx.core.view.H.i0(view, view.getContext(), iArr, attributeSet, a0VarV.r(), i5, 0);
        try {
            int i6 = g.j.f16991B3;
            if (a0VarV.s(i6)) {
                this.f8520c = a0VarV.n(i6, -1);
                ColorStateList colorStateListF = this.f8519b.f(this.f8518a.getContext(), this.f8520c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            int i7 = g.j.f16996C3;
            if (a0VarV.s(i7)) {
                androidx.core.view.H.p0(this.f8518a, a0VarV.c(i7));
            }
            int i8 = g.j.f17001D3;
            if (a0VarV.s(i8)) {
                androidx.core.view.H.q0(this.f8518a, I.d(a0VarV.k(i8, -1), null));
            }
            a0VarV.x();
        } catch (Throwable th) {
            a0VarV.x();
            throw th;
        }
    }

    void f(Drawable drawable) {
        this.f8520c = -1;
        h(null);
        b();
    }

    void g(int i5) {
        this.f8520c = i5;
        C0441k c0441k = this.f8519b;
        h(c0441k != null ? c0441k.f(this.f8518a.getContext(), i5) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f8521d == null) {
                this.f8521d = new Y();
            }
            Y y5 = this.f8521d;
            y5.f8462a = colorStateList;
            y5.f8465d = true;
        } else {
            this.f8521d = null;
        }
        b();
    }

    void i(ColorStateList colorStateList) {
        if (this.f8522e == null) {
            this.f8522e = new Y();
        }
        Y y5 = this.f8522e;
        y5.f8462a = colorStateList;
        y5.f8465d = true;
        b();
    }

    void j(PorterDuff.Mode mode) {
        if (this.f8522e == null) {
            this.f8522e = new Y();
        }
        Y y5 = this.f8522e;
        y5.f8463b = mode;
        y5.f8464c = true;
        b();
    }
}

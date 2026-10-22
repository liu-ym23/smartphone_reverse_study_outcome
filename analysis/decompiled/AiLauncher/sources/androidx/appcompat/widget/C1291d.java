package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;

/* renamed from: androidx.appcompat.widget.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1291d {

    /* renamed from: a, reason: collision with root package name */
    public final View f9180a;

    /* renamed from: d, reason: collision with root package name */
    public S f9183d;

    /* renamed from: e, reason: collision with root package name */
    public S f9184e;

    /* renamed from: f, reason: collision with root package name */
    public S f9185f;

    /* renamed from: c, reason: collision with root package name */
    public int f9182c = -1;

    /* renamed from: b, reason: collision with root package name */
    public final C1295h f9181b = C1295h.b();

    public C1291d(View view) {
        this.f9180a = view;
    }

    public final boolean a(Drawable drawable) {
        if (this.f9185f == null) {
            this.f9185f = new S();
        }
        S s10 = this.f9185f;
        s10.a();
        ColorStateList colorStateListN = androidx.core.view.N.n(this.f9180a);
        if (colorStateListN != null) {
            s10.f9026d = true;
            s10.f9023a = colorStateListN;
        }
        PorterDuff.Mode modeO = androidx.core.view.N.o(this.f9180a);
        if (modeO != null) {
            s10.f9025c = true;
            s10.f9024b = modeO;
        }
        if (!s10.f9026d && !s10.f9025c) {
            return false;
        }
        C1295h.i(drawable, s10, this.f9180a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.f9180a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            S s10 = this.f9184e;
            if (s10 != null) {
                C1295h.i(background, s10, this.f9180a.getDrawableState());
                return;
            }
            S s11 = this.f9183d;
            if (s11 != null) {
                C1295h.i(background, s11, this.f9180a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        S s10 = this.f9184e;
        if (s10 != null) {
            return s10.f9023a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        S s10 = this.f9184e;
        if (s10 != null) {
            return s10.f9024b;
        }
        return null;
    }

    public void e(AttributeSet attributeSet, int i10) {
        Context context = this.f9180a.getContext();
        int[] iArr = R$styleable.ViewBackgroundHelper;
        U uV = U.v(context, attributeSet, iArr, i10, 0);
        View view = this.f9180a;
        androidx.core.view.N.g0(view, view.getContext(), iArr, attributeSet, uV.r(), i10, 0);
        try {
            int i11 = R$styleable.ViewBackgroundHelper_android_background;
            if (uV.s(i11)) {
                this.f9182c = uV.n(i11, -1);
                ColorStateList colorStateListF = this.f9181b.f(this.f9180a.getContext(), this.f9182c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            int i12 = R$styleable.ViewBackgroundHelper_backgroundTint;
            if (uV.s(i12)) {
                androidx.core.view.N.n0(this.f9180a, uV.c(i12));
            }
            int i13 = R$styleable.ViewBackgroundHelper_backgroundTintMode;
            if (uV.s(i13)) {
                androidx.core.view.N.o0(this.f9180a, B.d(uV.k(i13, -1), null));
            }
            uV.x();
        } catch (Throwable th) {
            uV.x();
            throw th;
        }
    }

    public void f(Drawable drawable) {
        this.f9182c = -1;
        h(null);
        b();
    }

    public void g(int i10) {
        this.f9182c = i10;
        C1295h c1295h = this.f9181b;
        h(c1295h != null ? c1295h.f(this.f9180a.getContext(), i10) : null);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f9183d == null) {
                this.f9183d = new S();
            }
            S s10 = this.f9183d;
            s10.f9023a = colorStateList;
            s10.f9026d = true;
        } else {
            this.f9183d = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.f9184e == null) {
            this.f9184e = new S();
        }
        S s10 = this.f9184e;
        s10.f9023a = colorStateList;
        s10.f9026d = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.f9184e == null) {
            this.f9184e = new S();
        }
        S s10 = this.f9184e;
        s10.f9024b = mode;
        s10.f9025c = true;
        b();
    }

    public final boolean k() {
        return this.f9183d != null;
    }
}

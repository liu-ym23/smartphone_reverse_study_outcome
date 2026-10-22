package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import g.AbstractC0560a;
import java.util.WeakHashMap;

/* renamed from: androidx.appcompat.widget.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0228u {

    /* renamed from: a, reason: collision with root package name */
    public final View f3165a;

    /* renamed from: d, reason: collision with root package name */
    public X0 f3168d;

    /* renamed from: e, reason: collision with root package name */
    public X0 f3169e;

    /* renamed from: f, reason: collision with root package name */
    public X0 f3170f;

    /* renamed from: c, reason: collision with root package name */
    public int f3167c = -1;

    /* renamed from: b, reason: collision with root package name */
    public final A f3166b = A.a();

    public C0228u(View view) {
        this.f3165a = view;
    }

    public final void a() {
        View view = this.f3165a;
        Drawable background = view.getBackground();
        if (background != null) {
            if (this.f3168d != null) {
                if (this.f3170f == null) {
                    this.f3170f = new X0();
                }
                X0 x02 = this.f3170f;
                x02.f3042a = null;
                x02.f3045d = false;
                x02.f3043b = null;
                x02.f3044c = false;
                WeakHashMap weakHashMap = K.S.f939a;
                ColorStateList colorStateListG = K.J.g(view);
                if (colorStateListG != null) {
                    x02.f3045d = true;
                    x02.f3042a = colorStateListG;
                }
                PorterDuff.Mode modeH = K.J.h(view);
                if (modeH != null) {
                    x02.f3044c = true;
                    x02.f3043b = modeH;
                }
                if (x02.f3045d || x02.f3044c) {
                    A.d(background, x02, view.getDrawableState());
                    return;
                }
            }
            X0 x03 = this.f3169e;
            if (x03 != null) {
                A.d(background, x03, view.getDrawableState());
                return;
            }
            X0 x04 = this.f3168d;
            if (x04 != null) {
                A.d(background, x04, view.getDrawableState());
            }
        }
    }

    public final ColorStateList b() {
        X0 x02 = this.f3169e;
        if (x02 != null) {
            return x02.f3042a;
        }
        return null;
    }

    public final PorterDuff.Mode c() {
        X0 x02 = this.f3169e;
        if (x02 != null) {
            return x02.f3043b;
        }
        return null;
    }

    public final void d(AttributeSet attributeSet, int i4) {
        ColorStateList colorStateListH;
        View view = this.f3165a;
        Context context = view.getContext();
        int[] iArr = AbstractC0560a.f12613z;
        android.support.v4.media.session.c cVarY = android.support.v4.media.session.c.y(i4, 0, context, attributeSet, iArr);
        View view2 = this.f3165a;
        Context context2 = view2.getContext();
        TypedArray typedArray = (TypedArray) cVarY.f2365c;
        WeakHashMap weakHashMap = K.S.f939a;
        K.O.d(view2, context2, iArr, attributeSet, typedArray, i4, 0);
        try {
            if (cVarY.v(0)) {
                this.f3167c = cVarY.r(0, -1);
                A a4 = this.f3166b;
                Context context3 = view.getContext();
                int i5 = this.f3167c;
                synchronized (a4) {
                    colorStateListH = a4.f2723a.h(i5, context3);
                }
                if (colorStateListH != null) {
                    g(colorStateListH);
                }
            }
            if (cVarY.v(1)) {
                K.J.q(view, cVarY.h(1));
            }
            if (cVarY.v(2)) {
                K.J.r(view, AbstractC0220p0.b(cVarY.p(2, -1), null));
            }
            cVarY.A();
        } catch (Throwable th) {
            cVarY.A();
            throw th;
        }
    }

    public final void e() {
        this.f3167c = -1;
        g(null);
        a();
    }

    public final void f(int i4) {
        ColorStateList colorStateListH;
        this.f3167c = i4;
        A a4 = this.f3166b;
        if (a4 != null) {
            Context context = this.f3165a.getContext();
            synchronized (a4) {
                colorStateListH = a4.f2723a.h(i4, context);
            }
        } else {
            colorStateListH = null;
        }
        g(colorStateListH);
        a();
    }

    public final void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f3168d == null) {
                this.f3168d = new X0();
            }
            X0 x02 = this.f3168d;
            x02.f3042a = colorStateList;
            x02.f3045d = true;
        } else {
            this.f3168d = null;
        }
        a();
    }

    public final void h(ColorStateList colorStateList) {
        if (this.f3169e == null) {
            this.f3169e = new X0();
        }
        X0 x02 = this.f3169e;
        x02.f3042a = colorStateList;
        x02.f3045d = true;
        a();
    }

    public final void i(PorterDuff.Mode mode) {
        if (this.f3169e == null) {
            this.f3169e = new X0();
        }
        X0 x02 = this.f3169e;
        x02.f3043b = mode;
        x02.f3044c = true;
        a();
    }
}

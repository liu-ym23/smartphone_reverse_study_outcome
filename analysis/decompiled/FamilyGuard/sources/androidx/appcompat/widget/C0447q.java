package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import h.C0744a;

/* renamed from: androidx.appcompat.widget.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0447q {

    /* renamed from: a, reason: collision with root package name */
    private final ImageView f8595a;

    /* renamed from: b, reason: collision with root package name */
    private Y f8596b;

    /* renamed from: c, reason: collision with root package name */
    private Y f8597c;

    /* renamed from: d, reason: collision with root package name */
    private Y f8598d;

    /* renamed from: e, reason: collision with root package name */
    private int f8599e = 0;

    public C0447q(ImageView imageView) {
        this.f8595a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f8598d == null) {
            this.f8598d = new Y();
        }
        Y y5 = this.f8598d;
        y5.a();
        ColorStateList colorStateListA = androidx.core.widget.e.a(this.f8595a);
        if (colorStateListA != null) {
            y5.f8465d = true;
            y5.f8462a = colorStateListA;
        }
        PorterDuff.Mode modeB = androidx.core.widget.e.b(this.f8595a);
        if (modeB != null) {
            y5.f8464c = true;
            y5.f8463b = modeB;
        }
        if (!y5.f8465d && !y5.f8464c) {
            return false;
        }
        C0441k.i(drawable, y5, this.f8595a.getDrawableState());
        return true;
    }

    private boolean l() {
        return this.f8596b != null;
    }

    void b() {
        if (this.f8595a.getDrawable() != null) {
            this.f8595a.getDrawable().setLevel(this.f8599e);
        }
    }

    void c() {
        Drawable drawable = this.f8595a.getDrawable();
        if (drawable != null) {
            I.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            Y y5 = this.f8597c;
            if (y5 != null) {
                C0441k.i(drawable, y5, this.f8595a.getDrawableState());
                return;
            }
            Y y6 = this.f8596b;
            if (y6 != null) {
                C0441k.i(drawable, y6, this.f8595a.getDrawableState());
            }
        }
    }

    ColorStateList d() {
        Y y5 = this.f8597c;
        if (y5 != null) {
            return y5.f8462a;
        }
        return null;
    }

    PorterDuff.Mode e() {
        Y y5 = this.f8597c;
        if (y5 != null) {
            return y5.f8463b;
        }
        return null;
    }

    boolean f() {
        return !(this.f8595a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i5) {
        int iN;
        Context context = this.f8595a.getContext();
        int[] iArr = g.j.f17050P;
        a0 a0VarV = a0.v(context, attributeSet, iArr, i5, 0);
        ImageView imageView = this.f8595a;
        androidx.core.view.H.i0(imageView, imageView.getContext(), iArr, attributeSet, a0VarV.r(), i5, 0);
        try {
            Drawable drawable = this.f8595a.getDrawable();
            if (drawable == null && (iN = a0VarV.n(g.j.f17054Q, -1)) != -1 && (drawable = C0744a.b(this.f8595a.getContext(), iN)) != null) {
                this.f8595a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                I.b(drawable);
            }
            int i6 = g.j.f17058R;
            if (a0VarV.s(i6)) {
                androidx.core.widget.e.c(this.f8595a, a0VarV.c(i6));
            }
            int i7 = g.j.f17062S;
            if (a0VarV.s(i7)) {
                androidx.core.widget.e.d(this.f8595a, I.d(a0VarV.k(i7, -1), null));
            }
            a0VarV.x();
        } catch (Throwable th) {
            a0VarV.x();
            throw th;
        }
    }

    void h(Drawable drawable) {
        this.f8599e = drawable.getLevel();
    }

    public void i(int i5) {
        if (i5 != 0) {
            Drawable drawableB = C0744a.b(this.f8595a.getContext(), i5);
            if (drawableB != null) {
                I.b(drawableB);
            }
            this.f8595a.setImageDrawable(drawableB);
        } else {
            this.f8595a.setImageDrawable(null);
        }
        c();
    }

    void j(ColorStateList colorStateList) {
        if (this.f8597c == null) {
            this.f8597c = new Y();
        }
        Y y5 = this.f8597c;
        y5.f8462a = colorStateList;
        y5.f8465d = true;
        c();
    }

    void k(PorterDuff.Mode mode) {
        if (this.f8597c == null) {
            this.f8597c = new Y();
        }
        Y y5 = this.f8597c;
        y5.f8463b = mode;
        y5.f8464c = true;
        c();
    }
}

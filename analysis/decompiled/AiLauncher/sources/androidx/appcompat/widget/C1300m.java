package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import f.C4027a;

/* renamed from: androidx.appcompat.widget.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1300m {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f9215a;

    /* renamed from: b, reason: collision with root package name */
    public S f9216b;

    /* renamed from: c, reason: collision with root package name */
    public S f9217c;

    /* renamed from: d, reason: collision with root package name */
    public S f9218d;

    /* renamed from: e, reason: collision with root package name */
    public int f9219e = 0;

    public C1300m(ImageView imageView) {
        this.f9215a = imageView;
    }

    public final boolean a(Drawable drawable) {
        if (this.f9218d == null) {
            this.f9218d = new S();
        }
        S s10 = this.f9218d;
        s10.a();
        ColorStateList colorStateListA = androidx.core.widget.e.a(this.f9215a);
        if (colorStateListA != null) {
            s10.f9026d = true;
            s10.f9023a = colorStateListA;
        }
        PorterDuff.Mode modeB = androidx.core.widget.e.b(this.f9215a);
        if (modeB != null) {
            s10.f9025c = true;
            s10.f9024b = modeB;
        }
        if (!s10.f9026d && !s10.f9025c) {
            return false;
        }
        C1295h.i(drawable, s10, this.f9215a.getDrawableState());
        return true;
    }

    public void b() {
        if (this.f9215a.getDrawable() != null) {
            this.f9215a.getDrawable().setLevel(this.f9219e);
        }
    }

    public void c() {
        Drawable drawable = this.f9215a.getDrawable();
        if (drawable != null) {
            B.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            S s10 = this.f9217c;
            if (s10 != null) {
                C1295h.i(drawable, s10, this.f9215a.getDrawableState());
                return;
            }
            S s11 = this.f9216b;
            if (s11 != null) {
                C1295h.i(drawable, s11, this.f9215a.getDrawableState());
            }
        }
    }

    public ColorStateList d() {
        S s10 = this.f9217c;
        if (s10 != null) {
            return s10.f9023a;
        }
        return null;
    }

    public PorterDuff.Mode e() {
        S s10 = this.f9217c;
        if (s10 != null) {
            return s10.f9024b;
        }
        return null;
    }

    public boolean f() {
        return !(this.f9215a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i10) {
        int iN;
        Context context = this.f9215a.getContext();
        int[] iArr = R$styleable.AppCompatImageView;
        U uV = U.v(context, attributeSet, iArr, i10, 0);
        ImageView imageView = this.f9215a;
        androidx.core.view.N.g0(imageView, imageView.getContext(), iArr, attributeSet, uV.r(), i10, 0);
        try {
            Drawable drawable = this.f9215a.getDrawable();
            if (drawable == null && (iN = uV.n(R$styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = C4027a.b(this.f9215a.getContext(), iN)) != null) {
                this.f9215a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                B.b(drawable);
            }
            int i11 = R$styleable.AppCompatImageView_tint;
            if (uV.s(i11)) {
                androidx.core.widget.e.c(this.f9215a, uV.c(i11));
            }
            int i12 = R$styleable.AppCompatImageView_tintMode;
            if (uV.s(i12)) {
                androidx.core.widget.e.d(this.f9215a, B.d(uV.k(i12, -1), null));
            }
            uV.x();
        } catch (Throwable th) {
            uV.x();
            throw th;
        }
    }

    public void h(Drawable drawable) {
        this.f9219e = drawable.getLevel();
    }

    public void i(int i10) {
        if (i10 != 0) {
            Drawable drawableB = C4027a.b(this.f9215a.getContext(), i10);
            if (drawableB != null) {
                B.b(drawableB);
            }
            this.f9215a.setImageDrawable(drawableB);
        } else {
            this.f9215a.setImageDrawable(null);
        }
        c();
    }

    public void j(ColorStateList colorStateList) {
        if (this.f9217c == null) {
            this.f9217c = new S();
        }
        S s10 = this.f9217c;
        s10.f9023a = colorStateList;
        s10.f9026d = true;
        c();
    }

    public void k(PorterDuff.Mode mode) {
        if (this.f9217c == null) {
            this.f9217c = new S();
        }
        S s10 = this.f9217c;
        s10.f9024b = mode;
        s10.f9025c = true;
        c();
    }

    public final boolean l() {
        return this.f9216b != null;
    }
}

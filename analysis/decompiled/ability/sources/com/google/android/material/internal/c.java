package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import c3.C0871a;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: B, reason: collision with root package name */
    public CharSequence f2453B;

    /* renamed from: C, reason: collision with root package name */
    public CharSequence f2454C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f2455D;

    /* renamed from: F, reason: collision with root package name */
    public float f2456F;

    /* renamed from: G, reason: collision with root package name */
    public float f2457G;

    /* renamed from: H, reason: collision with root package name */
    public float f2458H;

    /* renamed from: I, reason: collision with root package name */
    public float f2459I;

    /* renamed from: J, reason: collision with root package name */
    public float f2460J;

    /* renamed from: K, reason: collision with root package name */
    public int f2461K;

    /* renamed from: L, reason: collision with root package name */
    public int f2462L;

    /* renamed from: M, reason: collision with root package name */
    public int[] f2463M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f2464N;

    /* renamed from: O, reason: collision with root package name */
    public final TextPaint f2465O;

    /* renamed from: P, reason: collision with root package name */
    public final TextPaint f2466P;

    /* renamed from: Q, reason: collision with root package name */
    public TimeInterpolator f2467Q;

    /* renamed from: R, reason: collision with root package name */
    public TimeInterpolator f2468R;

    /* renamed from: S, reason: collision with root package name */
    public float f2469S;

    /* renamed from: T, reason: collision with root package name */
    public float f2470T;

    /* renamed from: U, reason: collision with root package name */
    public float f2471U;

    /* renamed from: V, reason: collision with root package name */
    public ColorStateList f2472V;

    /* renamed from: W, reason: collision with root package name */
    public float f2473W;

    /* renamed from: X, reason: collision with root package name */
    public float f2474X;

    /* renamed from: Y, reason: collision with root package name */
    public float f2475Y;

    /* renamed from: Z, reason: collision with root package name */
    public StaticLayout f2476Z;

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f2477a;

    /* renamed from: a0, reason: collision with root package name */
    public float f2478a0;
    public float b;
    public float b0;
    public final Rect c;

    /* renamed from: c0, reason: collision with root package name */
    public float f2479c0;
    public final Rect d;

    /* renamed from: d0, reason: collision with root package name */
    public CharSequence f2480d0;
    public final RectF e;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f2486j;
    public ColorStateList k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f2488k0;
    public int l;
    public float m;
    public float n;
    public float o;
    public float p;

    /* renamed from: q, reason: collision with root package name */
    public float f2489q;

    /* renamed from: r, reason: collision with root package name */
    public float f2490r;

    /* renamed from: s, reason: collision with root package name */
    public Typeface f2491s;

    /* renamed from: t, reason: collision with root package name */
    public Typeface f2492t;
    public Typeface u;

    /* renamed from: v, reason: collision with root package name */
    public Typeface f2493v;

    /* renamed from: w, reason: collision with root package name */
    public Typeface f2494w;

    /* renamed from: x, reason: collision with root package name */
    public Typeface f2495x;
    public Typeface y;

    /* renamed from: z, reason: collision with root package name */
    public C0871a f2496z;
    public int f = 16;
    public int g = 16;
    public float h = 15.0f;
    public float i = 15.0f;

    /* renamed from: A, reason: collision with root package name */
    public final TextUtils.TruncateAt f2452A = TextUtils.TruncateAt.END;
    public final boolean E = true;

    /* renamed from: e0, reason: collision with root package name */
    public int f2481e0 = 1;

    /* renamed from: f0, reason: collision with root package name */
    public int f2482f0 = 1;

    /* renamed from: g0, reason: collision with root package name */
    public final float f2483g0 = 1.0f;

    /* renamed from: h0, reason: collision with root package name */
    public final int f2484h0 = 1;

    /* renamed from: i0, reason: collision with root package name */
    public int f2485i0 = -1;

    /* renamed from: j0, reason: collision with root package name */
    public int f2487j0 = -1;

    public c(TextInputLayout textInputLayout) {
        this.f2477a = textInputLayout;
        TextPaint textPaint = new TextPaint(129);
        this.f2465O = textPaint;
        this.f2466P = new TextPaint(textPaint);
        this.d = new Rect();
        this.c = new Rect();
        this.e = new RectF();
        i(textInputLayout.getContext().getResources().getConfiguration());
    }

    public static int a(int i, int i6, float f) {
        float f7 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(i6) * f) + (Color.alpha(i) * f7)), Math.round((Color.red(i6) * f) + (Color.red(i) * f7)), Math.round((Color.green(i6) * f) + (Color.green(i) * f7)), Math.round((Color.blue(i6) * f) + (Color.blue(i) * f7)));
    }

    public static float h(float f, float f7, float f9, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f9 = timeInterpolator.getInterpolation(f9);
        }
        return Q2.a.a(f, f7, f9);
    }

    public final void b() {
        float f = this.b;
        float f7 = this.c.left;
        Rect rect = this.d;
        float fH = h(f7, rect.left, f, this.f2467Q);
        RectF rectF = this.e;
        rectF.left = fH;
        rectF.top = h(this.m, this.n, f, this.f2467Q);
        rectF.right = h(r1.right, rect.right, f, this.f2467Q);
        rectF.bottom = h(r1.bottom, rect.bottom, f, this.f2467Q);
        this.f2489q = h(this.o, this.p, f, this.f2467Q);
        this.f2490r = h(this.m, this.n, f, this.f2467Q);
        d(f, false);
        TextInputLayout textInputLayout = this.f2477a;
        textInputLayout.postInvalidateOnAnimation();
        FastOutSlowInInterpolator fastOutSlowInInterpolator = Q2.a.b;
        this.b0 = 1.0f - h(0.0f, 1.0f, 1.0f - f, fastOutSlowInInterpolator);
        textInputLayout.postInvalidateOnAnimation();
        this.f2479c0 = h(1.0f, 0.0f, f, fastOutSlowInInterpolator);
        textInputLayout.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.k;
        ColorStateList colorStateList2 = this.f2486j;
        TextPaint textPaint = this.f2465O;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(g(colorStateList2), g(this.k), f));
        } else {
            textPaint.setColor(g(colorStateList));
        }
        float f9 = this.f2473W;
        float f10 = this.f2474X;
        if (f9 != f10) {
            textPaint.setLetterSpacing(h(f10, f9, f, fastOutSlowInInterpolator));
        } else {
            textPaint.setLetterSpacing(f9);
        }
        this.f2458H = Q2.a.a(0.0f, this.f2469S, f);
        this.f2459I = Q2.a.a(0.0f, this.f2470T, f);
        this.f2460J = Q2.a.a(0.0f, this.f2471U, f);
        int iA = a(0, g(this.f2472V), f);
        this.f2461K = iA;
        textPaint.setShadowLayer(this.f2458H, this.f2459I, this.f2460J, iA);
        textInputLayout.postInvalidateOnAnimation();
    }

    public final boolean c(CharSequence charSequence) {
        boolean z10 = this.f2477a.getLayoutDirection() == 1;
        if (this.E) {
            return (z10 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
        }
        return z10;
    }

    public final void d(float f, boolean z10) {
        float f7;
        Typeface typeface;
        float f9;
        if (this.f2453B == null) {
            return;
        }
        float fWidth = this.d.width();
        float fWidth2 = this.c.width();
        if (Math.abs(f - 1.0f) < 1.0E-5f) {
            f7 = o() ? this.i : this.h;
            f9 = o() ? this.f2473W : this.f2474X;
            this.f2456F = o() ? 1.0f : h(this.h, this.i, f, this.f2468R) / this.h;
            if (!o()) {
                fWidth = fWidth2;
            }
            typeface = this.f2491s;
            fWidth2 = fWidth;
        } else {
            f7 = this.h;
            float f10 = this.f2474X;
            typeface = this.f2493v;
            if (Math.abs(f - 0.0f) < 1.0E-5f) {
                this.f2456F = 1.0f;
            } else {
                this.f2456F = h(this.h, this.i, f, this.f2468R) / this.h;
            }
            float f11 = this.i / this.h;
            float f12 = fWidth2 * f11;
            if (!z10 && f12 > fWidth && o()) {
                fWidth2 = Math.min(fWidth / f11, fWidth2);
            }
            f9 = f10;
        }
        int i = f < 0.5f ? this.f2481e0 : this.f2482f0;
        TextPaint textPaint = this.f2465O;
        if (fWidth2 > 0.0f) {
            boolean z11 = this.f2457G != f7;
            boolean z12 = this.f2475Y != f9;
            boolean z13 = this.y != typeface;
            StaticLayout staticLayout = this.f2476Z;
            boolean z14 = z11 || z12 || (staticLayout != null && (fWidth2 > ((float) staticLayout.getWidth()) ? 1 : (fWidth2 == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z13 || (this.f2462L != i) || this.f2464N;
            this.f2457G = f7;
            this.f2475Y = f9;
            this.y = typeface;
            this.f2464N = false;
            this.f2462L = i;
            textPaint.setLinearText(this.f2456F != 1.0f);
            z = z14;
        }
        if (this.f2454C == null || z) {
            textPaint.setTextSize(this.f2457G);
            textPaint.setTypeface(this.y);
            textPaint.setLetterSpacing(this.f2475Y);
            boolean zC = c(this.f2453B);
            this.f2455D = zC;
            StaticLayout staticLayoutE = e(((this.f2481e0 > 1 || this.f2482f0 > 1) && !zC) ? i : 1, textPaint, this.f2453B, fWidth2 * (o() ? 1.0f : this.f2456F), this.f2455D);
            this.f2476Z = staticLayoutE;
            this.f2454C = staticLayoutE.getText();
        }
    }

    public final StaticLayout e(int i, TextPaint textPaint, CharSequence charSequence, float f, boolean z10) {
        Layout.Alignment alignment;
        if (i == 1) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(this.f, this.f2455D ? 1 : 0) & 7;
            alignment = absoluteGravity != 1 ? absoluteGravity != 5 ? this.f2455D ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.f2455D ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
        }
        g gVar = new g(charSequence, textPaint, (int) f);
        gVar.l = this.f2452A;
        gVar.k = z10;
        gVar.e = alignment;
        gVar.f2500j = false;
        gVar.f = i;
        float f7 = this.f2483g0;
        gVar.g = 0.0f;
        gVar.h = f7;
        gVar.i = this.f2484h0;
        gVar.m = null;
        return (StaticLayout) Preconditions.checkNotNull(gVar.a());
    }

    public final float f() {
        int i = this.f2485i0;
        if (i != -1) {
            return i;
        }
        float f = this.i;
        TextPaint textPaint = this.f2466P;
        textPaint.setTextSize(f);
        textPaint.setTypeface(this.f2491s);
        textPaint.setLetterSpacing(this.f2473W);
        return -textPaint.ascent();
    }

    public final int g(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f2463M;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void i(Configuration configuration) {
        Typeface typeface = this.u;
        if (typeface != null) {
            this.f2492t = c3.h.a(configuration, typeface);
        }
        Typeface typeface2 = this.f2495x;
        if (typeface2 != null) {
            this.f2494w = c3.h.a(configuration, typeface2);
        }
        Typeface typeface3 = this.f2492t;
        if (typeface3 == null) {
            typeface3 = this.u;
        }
        this.f2491s = typeface3;
        Typeface typeface4 = this.f2494w;
        if (typeface4 == null) {
            typeface4 = this.f2495x;
        }
        this.f2493v = typeface4;
        j(true);
    }

    public final void j(boolean z10) {
        float fMeasureText;
        TextInputLayout textInputLayout = this.f2477a;
        if ((textInputLayout.getHeight() <= 0 || textInputLayout.getWidth() <= 0) && !z10) {
            return;
        }
        d(1.0f, z10);
        CharSequence charSequence = this.f2454C;
        TextPaint textPaint = this.f2465O;
        if (charSequence != null && this.f2476Z != null) {
            this.f2480d0 = o() ? TextUtils.ellipsize(this.f2454C, textPaint, this.f2476Z.getWidth(), this.f2452A) : this.f2454C;
        }
        CharSequence charSequence2 = this.f2480d0;
        if (charSequence2 != null) {
            this.f2478a0 = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.f2478a0 = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.g, this.f2455D ? 1 : 0);
        int i = absoluteGravity & 112;
        Rect rect = this.d;
        if (i == 48) {
            this.n = rect.top;
        } else if (i != 80) {
            this.n = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.n = textPaint.ascent() + rect.bottom;
        }
        int i6 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i6 == 1) {
            this.p = rect.centerX() - (this.f2478a0 / 2.0f);
        } else if (i6 != 5) {
            this.p = rect.left;
        } else {
            this.p = rect.right - this.f2478a0;
        }
        if (this.f2478a0 <= rect.width()) {
            float f = this.p;
            float fMax = Math.max(0.0f, rect.left - f) + f;
            this.p = fMax;
            this.p = Math.min(0.0f, rect.right - (this.f2478a0 + fMax)) + fMax;
        }
        float f7 = this.i;
        TextPaint textPaint2 = this.f2466P;
        textPaint2.setTextSize(f7);
        textPaint2.setTypeface(this.f2491s);
        textPaint2.setLetterSpacing(this.f2473W);
        if (textPaint2.descent() + (-textPaint2.ascent()) <= rect.height()) {
            float f9 = this.n;
            float fMax2 = Math.max(0.0f, rect.top - f9) + f9;
            this.n = fMax2;
            this.n = Math.min(0.0f, rect.bottom - (f() + fMax2)) + fMax2;
        }
        d(0.0f, z10);
        float height = this.f2476Z != null ? r15.getHeight() : 0.0f;
        StaticLayout staticLayout = this.f2476Z;
        if (staticLayout == null || this.f2481e0 <= 1) {
            CharSequence charSequence3 = this.f2454C;
            fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            fMeasureText = staticLayout.getWidth();
        }
        StaticLayout staticLayout2 = this.f2476Z;
        this.l = staticLayout2 != null ? staticLayout2.getLineCount() : 0;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f, this.f2455D ? 1 : 0);
        int i10 = absoluteGravity2 & 112;
        Rect rect2 = this.c;
        if (i10 == 48) {
            this.m = rect2.top;
        } else if (i10 != 80) {
            this.m = rect2.centerY() - (height / 2.0f);
        } else {
            this.m = (rect2.bottom - height) + (this.f2488k0 ? textPaint.descent() : 0.0f);
        }
        int i11 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i11 == 1) {
            this.o = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i11 != 5) {
            this.o = rect2.left;
        } else {
            this.o = rect2.right - fMeasureText;
        }
        d(this.b, false);
        textInputLayout.postInvalidateOnAnimation();
        b();
    }

    public final void k(ColorStateList colorStateList) {
        if (this.k == colorStateList && this.f2486j == colorStateList) {
            return;
        }
        this.k = colorStateList;
        this.f2486j = colorStateList;
        j(false);
    }

    public final boolean l(Typeface typeface) {
        C0871a c0871a = this.f2496z;
        if (c0871a != null) {
            c0871a.c = true;
        }
        if (this.u == typeface) {
            return false;
        }
        this.u = typeface;
        Typeface typefaceA = c3.h.a(this.f2477a.getContext().getResources().getConfiguration(), typeface);
        this.f2492t = typefaceA;
        if (typefaceA == null) {
            typefaceA = this.u;
        }
        this.f2491s = typefaceA;
        return true;
    }

    public final void m(float f) {
        float fClamp = MathUtils.clamp(f, 0.0f, 1.0f);
        if (fClamp != this.b) {
            this.b = fClamp;
            b();
        }
    }

    public final void n(Typeface typeface) {
        boolean z10;
        boolean zL = l(typeface);
        if (this.f2495x != typeface) {
            this.f2495x = typeface;
            Typeface typefaceA = c3.h.a(this.f2477a.getContext().getResources().getConfiguration(), typeface);
            this.f2494w = typefaceA;
            if (typefaceA == null) {
                typefaceA = this.f2495x;
            }
            this.f2493v = typefaceA;
            z10 = true;
        } else {
            z10 = false;
        }
        if (zL || z10) {
            j(false);
        }
    }

    public final boolean o() {
        return this.f2482f0 == 1;
    }
}

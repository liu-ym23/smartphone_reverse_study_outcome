package com.google.android.material.internal;

import W2.a;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import w0.C5715a;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: A, reason: collision with root package name */
    public Typeface f20996A;

    /* renamed from: B, reason: collision with root package name */
    public Typeface f20997B;

    /* renamed from: C, reason: collision with root package name */
    public Typeface f20998C;

    /* renamed from: D, reason: collision with root package name */
    public Typeface f20999D;

    /* renamed from: E, reason: collision with root package name */
    public W2.a f21000E;

    /* renamed from: F, reason: collision with root package name */
    public W2.a f21001F;

    /* renamed from: H, reason: collision with root package name */
    public CharSequence f21003H;

    /* renamed from: I, reason: collision with root package name */
    public CharSequence f21004I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f21005J;

    /* renamed from: L, reason: collision with root package name */
    public float f21007L;

    /* renamed from: M, reason: collision with root package name */
    public float f21008M;

    /* renamed from: N, reason: collision with root package name */
    public float f21009N;

    /* renamed from: O, reason: collision with root package name */
    public float f21010O;

    /* renamed from: P, reason: collision with root package name */
    public float f21011P;

    /* renamed from: Q, reason: collision with root package name */
    public int f21012Q;

    /* renamed from: R, reason: collision with root package name */
    public int f21013R;

    /* renamed from: S, reason: collision with root package name */
    public int[] f21014S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f21015T;

    /* renamed from: U, reason: collision with root package name */
    public final TextPaint f21016U;

    /* renamed from: V, reason: collision with root package name */
    public final TextPaint f21017V;

    /* renamed from: W, reason: collision with root package name */
    public TimeInterpolator f21018W;

    /* renamed from: X, reason: collision with root package name */
    public TimeInterpolator f21019X;

    /* renamed from: Y, reason: collision with root package name */
    public float f21020Y;

    /* renamed from: Z, reason: collision with root package name */
    public float f21021Z;

    /* renamed from: a, reason: collision with root package name */
    public final View f21022a;

    /* renamed from: a0, reason: collision with root package name */
    public float f21023a0;

    /* renamed from: b, reason: collision with root package name */
    public float f21024b;

    /* renamed from: b0, reason: collision with root package name */
    public ColorStateList f21025b0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f21026c;

    /* renamed from: c0, reason: collision with root package name */
    public float f21027c0;

    /* renamed from: d, reason: collision with root package name */
    public float f21028d;

    /* renamed from: d0, reason: collision with root package name */
    public float f21029d0;

    /* renamed from: e, reason: collision with root package name */
    public float f21030e;

    /* renamed from: e0, reason: collision with root package name */
    public float f21031e0;

    /* renamed from: f, reason: collision with root package name */
    public int f21032f;

    /* renamed from: f0, reason: collision with root package name */
    public ColorStateList f21033f0;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f21034g;

    /* renamed from: g0, reason: collision with root package name */
    public float f21035g0;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f21036h;

    /* renamed from: h0, reason: collision with root package name */
    public float f21037h0;

    /* renamed from: i, reason: collision with root package name */
    public Rect f21038i;

    /* renamed from: i0, reason: collision with root package name */
    public float f21039i0;

    /* renamed from: j, reason: collision with root package name */
    public final RectF f21040j;

    /* renamed from: j0, reason: collision with root package name */
    public StaticLayout f21041j0;

    /* renamed from: k0, reason: collision with root package name */
    public float f21043k0;

    /* renamed from: l0, reason: collision with root package name */
    public float f21045l0;

    /* renamed from: m0, reason: collision with root package name */
    public float f21047m0;

    /* renamed from: n0, reason: collision with root package name */
    public CharSequence f21049n0;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f21050o;

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f21052p;

    /* renamed from: q, reason: collision with root package name */
    public int f21054q;

    /* renamed from: r, reason: collision with root package name */
    public float f21056r;

    /* renamed from: s, reason: collision with root package name */
    public float f21058s;

    /* renamed from: t, reason: collision with root package name */
    public float f21060t;

    /* renamed from: t0, reason: collision with root package name */
    public o f21061t0;

    /* renamed from: u, reason: collision with root package name */
    public float f21062u;

    /* renamed from: v, reason: collision with root package name */
    public float f21064v;

    /* renamed from: w, reason: collision with root package name */
    public float f21066w;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f21067w0;

    /* renamed from: x, reason: collision with root package name */
    public Typeface f21068x;

    /* renamed from: y, reason: collision with root package name */
    public Typeface f21069y;

    /* renamed from: z, reason: collision with root package name */
    public Typeface f21070z;

    /* renamed from: k, reason: collision with root package name */
    public int f21042k = 16;

    /* renamed from: l, reason: collision with root package name */
    public int f21044l = 16;

    /* renamed from: m, reason: collision with root package name */
    public float f21046m = 15.0f;

    /* renamed from: n, reason: collision with root package name */
    public float f21048n = 15.0f;

    /* renamed from: G, reason: collision with root package name */
    public TextUtils.TruncateAt f21002G = TextUtils.TruncateAt.END;

    /* renamed from: K, reason: collision with root package name */
    public boolean f21006K = true;

    /* renamed from: o0, reason: collision with root package name */
    public int f21051o0 = 1;

    /* renamed from: p0, reason: collision with root package name */
    public int f21053p0 = 1;

    /* renamed from: q0, reason: collision with root package name */
    public float f21055q0 = 0.0f;

    /* renamed from: r0, reason: collision with root package name */
    public float f21057r0 = 1.0f;

    /* renamed from: s0, reason: collision with root package name */
    public int f21059s0 = StaticLayoutBuilderCompat.f20980o;

    /* renamed from: u0, reason: collision with root package name */
    public int f21063u0 = -1;

    /* renamed from: v0, reason: collision with root package name */
    public int f21065v0 = -1;

    /* renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    public class C0234a implements a.InterfaceC0114a {
        public C0234a() {
        }

        @Override // W2.a.InterfaceC0114a
        public void a(Typeface typeface) {
            a.this.Y(typeface);
        }
    }

    public a(View view) {
        this.f21022a = view;
        TextPaint textPaint = new TextPaint(129);
        this.f21016U = textPaint;
        this.f21017V = new TextPaint(textPaint);
        this.f21036h = new Rect();
        this.f21034g = new Rect();
        this.f21040j = new RectF();
        this.f21030e = e();
        L(view.getContext().getResources().getConfiguration());
    }

    public static boolean G(float f10, float f11) {
        return Math.abs(f10 - f11) < 1.0E-5f;
    }

    public static float K(float f10, float f11, float f12, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f12 = timeInterpolator.getInterpolation(f12);
        }
        return E2.a.a(f10, f11, f12);
    }

    public static boolean P(Rect rect, int i10, int i11, int i12, int i13) {
        return rect.left == i10 && rect.top == i11 && rect.right == i12 && rect.bottom == i13;
    }

    public static int a(int i10, int i11, float f10) {
        float f11 = 1.0f - f10;
        return Color.argb(Math.round((Color.alpha(i10) * f11) + (Color.alpha(i11) * f10)), Math.round((Color.red(i10) * f11) + (Color.red(i11) * f10)), Math.round((Color.green(i10) * f11) + (Color.green(i11) * f10)), Math.round((Color.blue(i10) * f11) + (Color.blue(i11) * f10)));
    }

    public float A() {
        E(this.f21017V);
        return -this.f21017V.ascent();
    }

    public float B() {
        return this.f21024b;
    }

    public final Layout.Alignment C() {
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f21042k, this.f21005J ? 1 : 0) & 7;
        return absoluteGravity != 1 ? absoluteGravity != 5 ? this.f21005J ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.f21005J ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
    }

    public final void D(TextPaint textPaint) {
        textPaint.setTextSize(this.f21048n);
        textPaint.setTypeface(this.f21068x);
        textPaint.setLetterSpacing(this.f21035g0);
    }

    public final void E(TextPaint textPaint) {
        textPaint.setTextSize(this.f21046m);
        textPaint.setTypeface(this.f20996A);
        textPaint.setLetterSpacing(this.f21037h0);
    }

    public final void F(float f10) {
        if (this.f21026c) {
            this.f21040j.set(f10 < this.f21030e ? this.f21034g : this.f21036h);
            return;
        }
        this.f21040j.left = K(this.f21034g.left, this.f21036h.left, f10, this.f21018W);
        this.f21040j.top = K(this.f21056r, this.f21058s, f10, this.f21018W);
        this.f21040j.right = K(this.f21034g.right, this.f21036h.right, f10, this.f21018W);
        this.f21040j.bottom = K(this.f21034g.bottom, this.f21036h.bottom, f10, this.f21018W);
    }

    public final boolean H() {
        return this.f21022a.getLayoutDirection() == 1;
    }

    public final boolean I() {
        ColorStateList colorStateList = this.f21052p;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f21050o;
        return colorStateList2 != null && colorStateList2.isStateful();
    }

    public final boolean J(CharSequence charSequence, boolean z10) {
        return (z10 ? z0.e.f44554d : z0.e.f44553c).isRtl(charSequence, 0, charSequence.length());
    }

    public void L(Configuration configuration) {
        Typeface typeface = this.f21070z;
        if (typeface != null) {
            this.f21069y = W2.g.b(configuration, typeface);
        }
        Typeface typeface2 = this.f20998C;
        if (typeface2 != null) {
            this.f20997B = W2.g.b(configuration, typeface2);
        }
        Typeface typeface3 = this.f21069y;
        if (typeface3 == null) {
            typeface3 = this.f21070z;
        }
        this.f21068x = typeface3;
        Typeface typeface4 = this.f20997B;
        if (typeface4 == null) {
            typeface4 = this.f20998C;
        }
        this.f20996A = typeface4;
        O(true);
    }

    public final float M(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void N() {
        O(false);
    }

    public void O(boolean z10) {
        if ((this.f21022a.getHeight() <= 0 || this.f21022a.getWidth() <= 0) && !z10) {
            return;
        }
        b(z10);
        c();
    }

    public void Q(ColorStateList colorStateList) {
        if (this.f21052p == colorStateList && this.f21050o == colorStateList) {
            return;
        }
        this.f21052p = colorStateList;
        this.f21050o = colorStateList;
        N();
    }

    public void R(int i10, int i11, int i12, int i13) {
        if (P(this.f21036h, i10, i11, i12, i13)) {
            return;
        }
        this.f21036h.set(i10, i11, i12, i13);
        this.f21015T = true;
    }

    public void S(Rect rect) {
        R(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void T(int i10) {
        if (i10 != this.f21053p0) {
            this.f21053p0 = i10;
            N();
        }
    }

    public void U(int i10) {
        W2.d dVar = new W2.d(this.f21022a.getContext(), i10);
        if (dVar.j() != null) {
            this.f21052p = dVar.j();
        }
        if (dVar.k() != 0.0f) {
            this.f21048n = dVar.k();
        }
        ColorStateList colorStateList = dVar.f6607c;
        if (colorStateList != null) {
            this.f21025b0 = colorStateList;
        }
        this.f21021Z = dVar.f6613i;
        this.f21023a0 = dVar.f6614j;
        this.f21020Y = dVar.f6615k;
        this.f21035g0 = dVar.f6617m;
        W2.a aVar = this.f21001F;
        if (aVar != null) {
            aVar.c();
        }
        this.f21001F = new W2.a(new C0234a(), dVar.e());
        dVar.g(this.f21022a.getContext(), this.f21001F);
        N();
    }

    public final void V(float f10) {
        this.f21045l0 = f10;
        this.f21022a.postInvalidateOnAnimation();
    }

    public void W(ColorStateList colorStateList) {
        if (this.f21052p != colorStateList) {
            this.f21052p = colorStateList;
            N();
        }
    }

    public void X(int i10) {
        if (this.f21044l != i10) {
            this.f21044l = i10;
            N();
        }
    }

    public void Y(Typeface typeface) {
        if (Z(typeface)) {
            N();
        }
    }

    public final boolean Z(Typeface typeface) {
        W2.a aVar = this.f21001F;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f21070z == typeface) {
            return false;
        }
        this.f21070z = typeface;
        Typeface typefaceB = W2.g.b(this.f21022a.getContext().getResources().getConfiguration(), typeface);
        this.f21069y = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.f21070z;
        }
        this.f21068x = typefaceB;
        return true;
    }

    public void a0(int i10, int i11, int i12, int i13) {
        b0(i10, i11, i12, i13, true);
    }

    public final void b(boolean z10) {
        float fM;
        i(1.0f, z10);
        if (this.f21004I != null && this.f21041j0 != null) {
            this.f21049n0 = r0() ? TextUtils.ellipsize(this.f21004I, this.f21016U, this.f21041j0.getWidth(), this.f21002G) : this.f21004I;
        }
        CharSequence charSequence = this.f21049n0;
        if (charSequence != null) {
            this.f21043k0 = M(this.f21016U, charSequence);
        } else {
            this.f21043k0 = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f21044l, this.f21005J ? 1 : 0);
        Rect rect = this.f21038i;
        if (rect == null) {
            rect = this.f21036h;
        }
        int i10 = absoluteGravity & 112;
        if (i10 == 48) {
            this.f21058s = rect.top;
        } else if (i10 != 80) {
            this.f21058s = rect.centerY() - ((this.f21016U.descent() - this.f21016U.ascent()) / 2.0f);
        } else {
            this.f21058s = rect.bottom + this.f21016U.ascent();
        }
        int i11 = absoluteGravity & 8388615;
        if (i11 == 1) {
            this.f21062u = rect.centerX() - (this.f21043k0 / 2.0f);
        } else if (i11 != 5) {
            this.f21062u = rect.left;
        } else {
            this.f21062u = rect.right - this.f21043k0;
        }
        if (this.f21043k0 <= this.f21036h.width()) {
            float f10 = this.f21062u;
            float fMax = f10 + Math.max(0.0f, this.f21036h.left - f10);
            this.f21062u = fMax;
            this.f21062u = fMax + Math.min(0.0f, this.f21036h.right - (this.f21043k0 + fMax));
        }
        if (m() <= this.f21036h.height()) {
            float f11 = this.f21058s;
            float fMax2 = f11 + Math.max(0.0f, this.f21036h.top - f11);
            this.f21058s = fMax2;
            this.f21058s = fMax2 + Math.min(0.0f, this.f21036h.bottom - (q() + fMax2));
        }
        i(0.0f, z10);
        float height = this.f21041j0 != null ? r11.getHeight() : 0.0f;
        StaticLayout staticLayout = this.f21041j0;
        if (staticLayout == null || this.f21051o0 <= 1) {
            CharSequence charSequence2 = this.f21004I;
            fM = charSequence2 != null ? M(this.f21016U, charSequence2) : 0.0f;
        } else {
            fM = staticLayout.getWidth();
        }
        StaticLayout staticLayout2 = this.f21041j0;
        this.f21054q = staticLayout2 != null ? staticLayout2.getLineCount() : 0;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f21042k, this.f21005J ? 1 : 0);
        int i12 = absoluteGravity2 & 112;
        if (i12 == 48) {
            this.f21056r = this.f21034g.top;
        } else if (i12 != 80) {
            this.f21056r = this.f21034g.centerY() - (height / 2.0f);
        } else {
            this.f21056r = (this.f21034g.bottom - height) + (this.f21067w0 ? this.f21016U.descent() : 0.0f);
        }
        int i13 = absoluteGravity2 & 8388615;
        if (i13 == 1) {
            this.f21060t = this.f21034g.centerX() - (fM / 2.0f);
        } else if (i13 != 5) {
            this.f21060t = this.f21034g.left;
        } else {
            this.f21060t = this.f21034g.right - fM;
        }
        k0(this.f21024b);
    }

    public void b0(int i10, int i11, int i12, int i13, boolean z10) {
        if (P(this.f21034g, i10, i11, i12, i13) && z10 == this.f21067w0) {
            return;
        }
        this.f21034g.set(i10, i11, i12, i13);
        this.f21015T = true;
        this.f21067w0 = z10;
    }

    public final void c() {
        g(this.f21024b);
    }

    public void c0(Rect rect) {
        a0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final float d(float f10) {
        float f11 = this.f21030e;
        return f10 <= f11 ? E2.a.b(1.0f, 0.0f, this.f21028d, f11, f10) : E2.a.b(0.0f, 1.0f, f11, 1.0f, f10);
    }

    public void d0(float f10) {
        if (this.f21037h0 != f10) {
            this.f21037h0 = f10;
            N();
        }
    }

    public final float e() {
        float f10 = this.f21028d;
        return f10 + ((1.0f - f10) * 0.5f);
    }

    public void e0(int i10) {
        if (i10 != this.f21051o0) {
            this.f21051o0 = i10;
            N();
        }
    }

    public final boolean f(CharSequence charSequence) {
        boolean zH = H();
        return this.f21006K ? J(charSequence, zH) : zH;
    }

    public final void f0(float f10) {
        this.f21047m0 = f10;
        this.f21022a.postInvalidateOnAnimation();
    }

    public final void g(float f10) {
        float f11;
        F(f10);
        if (!this.f21026c) {
            this.f21064v = K(this.f21060t, this.f21062u, f10, this.f21018W);
            this.f21066w = K(this.f21056r, this.f21058s, f10, this.f21018W);
            k0(f10);
            f11 = f10;
        } else if (f10 < this.f21030e) {
            this.f21064v = this.f21060t;
            this.f21066w = this.f21056r;
            k0(0.0f);
            f11 = 0.0f;
        } else {
            this.f21064v = this.f21062u;
            this.f21066w = this.f21058s - Math.max(0, this.f21032f);
            k0(1.0f);
            f11 = 1.0f;
        }
        TimeInterpolator timeInterpolator = E2.a.f2340b;
        V(1.0f - K(0.0f, 1.0f, 1.0f - f10, timeInterpolator));
        f0(K(1.0f, 0.0f, f10, timeInterpolator));
        if (this.f21052p != this.f21050o) {
            this.f21016U.setColor(a(v(), t(), f11));
        } else {
            this.f21016U.setColor(t());
        }
        float f12 = this.f21035g0;
        float f13 = this.f21037h0;
        if (f12 != f13) {
            this.f21016U.setLetterSpacing(K(f13, f12, f10, timeInterpolator));
        } else {
            this.f21016U.setLetterSpacing(f12);
        }
        this.f21009N = K(this.f21027c0, this.f21020Y, f10, null);
        this.f21010O = K(this.f21029d0, this.f21021Z, f10, null);
        this.f21011P = K(this.f21031e0, this.f21023a0, f10, null);
        int iA = a(u(this.f21033f0), u(this.f21025b0), f10);
        this.f21012Q = iA;
        this.f21016U.setShadowLayer(this.f21009N, this.f21010O, this.f21011P, iA);
        if (this.f21026c) {
            this.f21016U.setAlpha((int) (d(f10) * this.f21016U.getAlpha()));
            TextPaint textPaint = this.f21016U;
            textPaint.setShadowLayer(this.f21009N, this.f21010O, this.f21011P, M2.a.a(this.f21012Q, textPaint.getAlpha()));
        }
        this.f21022a.postInvalidateOnAnimation();
    }

    public void g0(int i10) {
        if (this.f21042k != i10) {
            this.f21042k = i10;
            N();
        }
    }

    public final void h(float f10) {
        i(f10, false);
    }

    public void h0(float f10) {
        if (this.f21046m != f10) {
            this.f21046m = f10;
            N();
        }
    }

    public final void i(float f10, boolean z10) {
        Typeface typeface;
        float f11;
        float f12;
        if (this.f21003H == null) {
            return;
        }
        float fWidth = this.f21036h.width();
        float fWidth2 = this.f21034g.width();
        if (G(f10, 1.0f)) {
            f11 = r0() ? this.f21048n : this.f21046m;
            f12 = r0() ? this.f21035g0 : this.f21037h0;
            this.f21007L = r0() ? 1.0f : K(this.f21046m, this.f21048n, f10, this.f21019X) / this.f21046m;
            if (!r0()) {
                fWidth = fWidth2;
            }
            typeface = this.f21068x;
            fWidth2 = fWidth;
        } else {
            float f13 = this.f21046m;
            float f14 = this.f21037h0;
            typeface = this.f20996A;
            if (G(f10, 0.0f)) {
                this.f21007L = 1.0f;
            } else {
                this.f21007L = K(this.f21046m, this.f21048n, f10, this.f21019X) / this.f21046m;
            }
            float f15 = this.f21048n / this.f21046m;
            float f16 = fWidth2 * f15;
            if (!z10 && !this.f21026c && f16 > fWidth && r0()) {
                fWidth2 = Math.min(fWidth / f15, fWidth2);
            }
            f11 = f13;
            f12 = f14;
        }
        int i10 = f10 < 0.5f ? this.f21051o0 : this.f21053p0;
        if (fWidth2 > 0.0f) {
            boolean z11 = this.f21008M != f11;
            boolean z12 = this.f21039i0 != f12;
            boolean z13 = this.f20999D != typeface;
            StaticLayout staticLayout = this.f21041j0;
            boolean z14 = z11 || z12 || (staticLayout != null && (fWidth2 > ((float) staticLayout.getWidth()) ? 1 : (fWidth2 == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z13 || (this.f21013R != i10) || this.f21015T;
            this.f21008M = f11;
            this.f21039i0 = f12;
            this.f20999D = typeface;
            this.f21015T = false;
            this.f21013R = i10;
            this.f21016U.setLinearText(this.f21007L != 1.0f);
            z = z14;
        }
        if (this.f21004I == null || z) {
            this.f21016U.setTextSize(this.f21008M);
            this.f21016U.setTypeface(this.f20999D);
            this.f21016U.setLetterSpacing(this.f21039i0);
            this.f21005J = f(this.f21003H);
            StaticLayout staticLayoutJ = j(q0() ? i10 : 1, this.f21016U, this.f21003H, fWidth2 * (r0() ? 1.0f : this.f21007L), this.f21005J);
            this.f21041j0 = staticLayoutJ;
            this.f21004I = staticLayoutJ.getText();
        }
    }

    public final boolean i0(Typeface typeface) {
        W2.a aVar = this.f21000E;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f20998C == typeface) {
            return false;
        }
        this.f20998C = typeface;
        Typeface typefaceB = W2.g.b(this.f21022a.getContext().getResources().getConfiguration(), typeface);
        this.f20997B = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.f20998C;
        }
        this.f20996A = typefaceB;
        return true;
    }

    public final StaticLayout j(int i10, TextPaint textPaint, CharSequence charSequence, float f10, boolean z10) {
        return (StaticLayout) B0.h.f(StaticLayoutBuilderCompat.b(charSequence, textPaint, (int) f10).d(this.f21002G).g(z10).c(i10 == 1 ? Layout.Alignment.ALIGN_NORMAL : C()).f(false).i(i10).h(this.f21055q0, this.f21057r0).e(this.f21059s0).j(this.f21061t0).a());
    }

    public void j0(float f10) {
        float fA = C5715a.a(f10, 0.0f, 1.0f);
        if (fA != this.f21024b) {
            this.f21024b = fA;
            c();
        }
    }

    public void k(Canvas canvas) {
        int iSave = canvas.save();
        if (this.f21004I == null || this.f21040j.width() <= 0.0f || this.f21040j.height() <= 0.0f) {
            return;
        }
        this.f21016U.setTextSize(this.f21008M);
        float f10 = this.f21064v;
        float f11 = this.f21066w;
        float f12 = this.f21007L;
        if (f12 != 1.0f && !this.f21026c) {
            canvas.scale(f12, f12, f10, f11);
        }
        if (q0() && r0() && (!this.f21026c || this.f21024b > this.f21030e)) {
            l(canvas, this.f21064v - this.f21041j0.getLineStart(0), f11);
        } else {
            canvas.translate(f10, f11);
            this.f21041j0.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    public final void k0(float f10) {
        h(f10);
        this.f21022a.postInvalidateOnAnimation();
    }

    public final void l(Canvas canvas, float f10, float f11) {
        int alpha = this.f21016U.getAlpha();
        canvas.translate(f10, f11);
        if (!this.f21026c) {
            this.f21016U.setAlpha((int) (this.f21047m0 * alpha));
            TextPaint textPaint = this.f21016U;
            textPaint.setShadowLayer(this.f21009N, this.f21010O, this.f21011P, M2.a.a(this.f21012Q, textPaint.getAlpha()));
            this.f21041j0.draw(canvas);
        }
        if (!this.f21026c) {
            this.f21016U.setAlpha((int) (this.f21045l0 * alpha));
        }
        TextPaint textPaint2 = this.f21016U;
        textPaint2.setShadowLayer(this.f21009N, this.f21010O, this.f21011P, M2.a.a(this.f21012Q, textPaint2.getAlpha()));
        int lineBaseline = this.f21041j0.getLineBaseline(0);
        CharSequence charSequence = this.f21049n0;
        float f12 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f12, this.f21016U);
        this.f21016U.setShadowLayer(this.f21009N, this.f21010O, this.f21011P, this.f21012Q);
        if (this.f21026c) {
            return;
        }
        String strTrim = this.f21049n0.toString().trim();
        if (strTrim.endsWith("…")) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        this.f21016U.setAlpha(alpha);
        canvas.drawText(strTrim, 0, Math.min(this.f21041j0.getLineEnd(0), strTrim.length()), 0.0f, f12, (Paint) this.f21016U);
    }

    public void l0(TimeInterpolator timeInterpolator) {
        this.f21018W = timeInterpolator;
        N();
    }

    public float m() {
        D(this.f21017V);
        return (-this.f21017V.ascent()) + this.f21017V.descent();
    }

    public final boolean m0(int[] iArr) {
        this.f21014S = iArr;
        if (!I()) {
            return false;
        }
        N();
        return true;
    }

    public float n() {
        D(this.f21017V);
        return -this.f21017V.ascent();
    }

    public void n0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.f21003H, charSequence)) {
            this.f21003H = charSequence;
            this.f21004I = null;
            N();
        }
    }

    public void o(RectF rectF, int i10, int i11) {
        this.f21005J = f(this.f21003H);
        rectF.left = Math.max(r(i10, i11), this.f21036h.left);
        rectF.top = this.f21036h.top;
        rectF.right = Math.min(s(rectF, i10, i11), this.f21036h.right);
        rectF.bottom = this.f21036h.top + q();
        if (this.f21041j0 == null || r0()) {
            return;
        }
        float lineWidth = this.f21041j0.getLineWidth(r4.getLineCount() - 1) * (this.f21048n / this.f21046m);
        if (this.f21005J) {
            rectF.left = rectF.right - lineWidth;
        } else {
            rectF.right = rectF.left + lineWidth;
        }
    }

    public void o0(TimeInterpolator timeInterpolator) {
        this.f21019X = timeInterpolator;
        N();
    }

    public ColorStateList p() {
        return this.f21052p;
    }

    public void p0(Typeface typeface) {
        boolean Z10 = Z(typeface);
        boolean zI0 = i0(typeface);
        if (Z10 || zI0) {
            N();
        }
    }

    public float q() {
        int i10 = this.f21063u0;
        return i10 != -1 ? i10 : n();
    }

    public final boolean q0() {
        if (this.f21051o0 > 1 || this.f21053p0 > 1) {
            return !this.f21005J || this.f21026c;
        }
        return false;
    }

    public final float r(int i10, int i11) {
        float f10;
        float f11;
        int i12;
        if (i11 == 17 || (i11 & 7) == 1) {
            f10 = i10 / 2.0f;
            f11 = this.f21043k0 / 2.0f;
        } else if ((i11 & 8388613) == 8388613 || (i11 & 5) == 5) {
            if (this.f21005J) {
                i12 = this.f21036h.left;
                return i12;
            }
            f10 = this.f21036h.right;
            f11 = this.f21043k0;
        } else {
            if (!this.f21005J) {
                i12 = this.f21036h.left;
                return i12;
            }
            f10 = this.f21036h.right;
            f11 = this.f21043k0;
        }
        return f10 - f11;
    }

    public final boolean r0() {
        return this.f21053p0 == 1;
    }

    public final float s(RectF rectF, int i10, int i11) {
        float f10;
        float f11;
        int i12;
        if (i11 == 17 || (i11 & 7) == 1) {
            f10 = i10 / 2.0f;
            f11 = this.f21043k0 / 2.0f;
        } else if ((i11 & 8388613) == 8388613 || (i11 & 5) == 5) {
            if (!this.f21005J) {
                i12 = this.f21036h.right;
                return i12;
            }
            f10 = rectF.left;
            f11 = this.f21043k0;
        } else {
            if (this.f21005J) {
                i12 = this.f21036h.right;
                return i12;
            }
            f10 = rectF.left;
            f11 = this.f21043k0;
        }
        return f10 + f11;
    }

    public void s0(int i10) {
        D(this.f21017V);
        float f10 = i10;
        this.f21063u0 = j(this.f21053p0, this.f21017V, this.f21003H, f10 * (this.f21048n / this.f21046m), this.f21005J).getHeight();
        E(this.f21017V);
        this.f21065v0 = j(this.f21051o0, this.f21017V, this.f21003H, f10, this.f21005J).getHeight();
    }

    public int t() {
        return u(this.f21052p);
    }

    public final int u(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f21014S;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final int v() {
        return u(this.f21050o);
    }

    public int w() {
        return this.f21054q;
    }

    public int x() {
        return this.f21051o0;
    }

    public float y() {
        E(this.f21017V);
        return (-this.f21017V.ascent()) + this.f21017V.descent();
    }

    public float z() {
        int i10 = this.f21065v0;
        return i10 != -1 ? i10 : A();
    }
}

package com.google.android.material.internal;

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
import b1.C0553a;
import j1.C0777a;
import q1.C0979a;
import q1.C0982d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: A, reason: collision with root package name */
    private Typeface f12925A;

    /* renamed from: B, reason: collision with root package name */
    private Typeface f12926B;

    /* renamed from: C, reason: collision with root package name */
    private Typeface f12927C;

    /* renamed from: D, reason: collision with root package name */
    private Typeface f12928D;

    /* renamed from: E, reason: collision with root package name */
    private C0979a f12929E;

    /* renamed from: F, reason: collision with root package name */
    private C0979a f12930F;

    /* renamed from: H, reason: collision with root package name */
    private CharSequence f12932H;

    /* renamed from: I, reason: collision with root package name */
    private CharSequence f12933I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f12934J;

    /* renamed from: L, reason: collision with root package name */
    private float f12936L;

    /* renamed from: M, reason: collision with root package name */
    private float f12937M;

    /* renamed from: N, reason: collision with root package name */
    private float f12938N;

    /* renamed from: O, reason: collision with root package name */
    private float f12939O;

    /* renamed from: P, reason: collision with root package name */
    private float f12940P;

    /* renamed from: Q, reason: collision with root package name */
    private int f12941Q;

    /* renamed from: R, reason: collision with root package name */
    private int f12942R;

    /* renamed from: S, reason: collision with root package name */
    private int[] f12943S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f12944T;

    /* renamed from: U, reason: collision with root package name */
    private final TextPaint f12945U;

    /* renamed from: V, reason: collision with root package name */
    private final TextPaint f12946V;

    /* renamed from: W, reason: collision with root package name */
    private TimeInterpolator f12947W;

    /* renamed from: X, reason: collision with root package name */
    private TimeInterpolator f12948X;

    /* renamed from: Y, reason: collision with root package name */
    private float f12949Y;

    /* renamed from: Z, reason: collision with root package name */
    private float f12950Z;

    /* renamed from: a, reason: collision with root package name */
    private final View f12951a;

    /* renamed from: a0, reason: collision with root package name */
    private float f12952a0;

    /* renamed from: b, reason: collision with root package name */
    private float f12953b;

    /* renamed from: b0, reason: collision with root package name */
    private ColorStateList f12954b0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f12955c;

    /* renamed from: c0, reason: collision with root package name */
    private float f12956c0;

    /* renamed from: d, reason: collision with root package name */
    private float f12957d;

    /* renamed from: d0, reason: collision with root package name */
    private float f12958d0;

    /* renamed from: e, reason: collision with root package name */
    private float f12959e;

    /* renamed from: e0, reason: collision with root package name */
    private float f12960e0;

    /* renamed from: f, reason: collision with root package name */
    private int f12961f;

    /* renamed from: f0, reason: collision with root package name */
    private ColorStateList f12962f0;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f12963g;

    /* renamed from: g0, reason: collision with root package name */
    private float f12964g0;

    /* renamed from: h, reason: collision with root package name */
    private final Rect f12965h;

    /* renamed from: h0, reason: collision with root package name */
    private float f12966h0;

    /* renamed from: i, reason: collision with root package name */
    private Rect f12967i;

    /* renamed from: i0, reason: collision with root package name */
    private float f12968i0;

    /* renamed from: j, reason: collision with root package name */
    private final RectF f12969j;

    /* renamed from: j0, reason: collision with root package name */
    private StaticLayout f12970j0;

    /* renamed from: k0, reason: collision with root package name */
    private float f12972k0;

    /* renamed from: l0, reason: collision with root package name */
    private float f12974l0;

    /* renamed from: m0, reason: collision with root package name */
    private float f12976m0;

    /* renamed from: n0, reason: collision with root package name */
    private CharSequence f12978n0;

    /* renamed from: o, reason: collision with root package name */
    private ColorStateList f12979o;

    /* renamed from: p, reason: collision with root package name */
    private ColorStateList f12981p;

    /* renamed from: q, reason: collision with root package name */
    private int f12983q;

    /* renamed from: r, reason: collision with root package name */
    private float f12985r;

    /* renamed from: s, reason: collision with root package name */
    private float f12987s;

    /* renamed from: t, reason: collision with root package name */
    private float f12989t;

    /* renamed from: t0, reason: collision with root package name */
    private l f12990t0;

    /* renamed from: u, reason: collision with root package name */
    private float f12991u;

    /* renamed from: v, reason: collision with root package name */
    private float f12993v;

    /* renamed from: w, reason: collision with root package name */
    private float f12995w;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f12996w0;

    /* renamed from: x, reason: collision with root package name */
    private Typeface f12997x;

    /* renamed from: y, reason: collision with root package name */
    private Typeface f12998y;

    /* renamed from: z, reason: collision with root package name */
    private Typeface f12999z;

    /* renamed from: k, reason: collision with root package name */
    private int f12971k = 16;

    /* renamed from: l, reason: collision with root package name */
    private int f12973l = 16;

    /* renamed from: m, reason: collision with root package name */
    private float f12975m = 15.0f;

    /* renamed from: n, reason: collision with root package name */
    private float f12977n = 15.0f;

    /* renamed from: G, reason: collision with root package name */
    private TextUtils.TruncateAt f12931G = TextUtils.TruncateAt.END;

    /* renamed from: K, reason: collision with root package name */
    private boolean f12935K = true;

    /* renamed from: o0, reason: collision with root package name */
    private int f12980o0 = 1;

    /* renamed from: p0, reason: collision with root package name */
    private int f12982p0 = 1;

    /* renamed from: q0, reason: collision with root package name */
    private float f12984q0 = 0.0f;

    /* renamed from: r0, reason: collision with root package name */
    private float f12986r0 = 1.0f;

    /* renamed from: s0, reason: collision with root package name */
    private int f12988s0 = k.f13017o;

    /* renamed from: u0, reason: collision with root package name */
    private int f12992u0 = -1;

    /* renamed from: v0, reason: collision with root package name */
    private int f12994v0 = -1;

    /* renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    class C0168a implements C0979a.InterfaceC0236a {
        C0168a() {
        }

        @Override // q1.C0979a.InterfaceC0236a
        public void a(Typeface typeface) {
            a.this.Y(typeface);
        }
    }

    public a(View view) {
        this.f12951a = view;
        TextPaint textPaint = new TextPaint(129);
        this.f12945U = textPaint;
        this.f12946V = new TextPaint(textPaint);
        this.f12965h = new Rect();
        this.f12963g = new Rect();
        this.f12969j = new RectF();
        this.f12959e = e();
        L(view.getContext().getResources().getConfiguration());
    }

    private Layout.Alignment C() {
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f12971k, this.f12934J ? 1 : 0) & 7;
        return absoluteGravity != 1 ? absoluteGravity != 5 ? this.f12934J ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.f12934J ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
    }

    private void D(TextPaint textPaint) {
        textPaint.setTextSize(this.f12977n);
        textPaint.setTypeface(this.f12997x);
        textPaint.setLetterSpacing(this.f12964g0);
    }

    private void E(TextPaint textPaint) {
        textPaint.setTextSize(this.f12975m);
        textPaint.setTypeface(this.f12925A);
        textPaint.setLetterSpacing(this.f12966h0);
    }

    private void F(float f5) {
        if (this.f12955c) {
            this.f12969j.set(f5 < this.f12959e ? this.f12963g : this.f12965h);
            return;
        }
        this.f12969j.left = K(this.f12963g.left, this.f12965h.left, f5, this.f12947W);
        this.f12969j.top = K(this.f12985r, this.f12987s, f5, this.f12947W);
        this.f12969j.right = K(this.f12963g.right, this.f12965h.right, f5, this.f12947W);
        this.f12969j.bottom = K(this.f12963g.bottom, this.f12965h.bottom, f5, this.f12947W);
    }

    private static boolean G(float f5, float f6) {
        return Math.abs(f5 - f6) < 1.0E-5f;
    }

    private boolean H() {
        return this.f12951a.getLayoutDirection() == 1;
    }

    private boolean J(CharSequence charSequence, boolean z5) {
        return (z5 ? androidx.core.text.f.f9704d : androidx.core.text.f.f9703c).isRtl(charSequence, 0, charSequence.length());
    }

    private static float K(float f5, float f6, float f7, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f7 = timeInterpolator.getInterpolation(f7);
        }
        return C0553a.a(f5, f6, f7);
    }

    private float M(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private static boolean P(Rect rect, int i5, int i6, int i7, int i8) {
        return rect.left == i5 && rect.top == i6 && rect.right == i7 && rect.bottom == i8;
    }

    private void V(float f5) {
        this.f12974l0 = f5;
        this.f12951a.postInvalidateOnAnimation();
    }

    private boolean Z(Typeface typeface) {
        C0979a c0979a = this.f12930F;
        if (c0979a != null) {
            c0979a.c();
        }
        if (this.f12999z == typeface) {
            return false;
        }
        this.f12999z = typeface;
        Typeface typefaceB = q1.g.b(this.f12951a.getContext().getResources().getConfiguration(), typeface);
        this.f12998y = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.f12999z;
        }
        this.f12997x = typefaceB;
        return true;
    }

    private static int a(int i5, int i6, float f5) {
        float f6 = 1.0f - f5;
        return Color.argb(Math.round((Color.alpha(i5) * f6) + (Color.alpha(i6) * f5)), Math.round((Color.red(i5) * f6) + (Color.red(i6) * f5)), Math.round((Color.green(i5) * f6) + (Color.green(i6) * f5)), Math.round((Color.blue(i5) * f6) + (Color.blue(i6) * f5)));
    }

    private void b(boolean z5) {
        float fM;
        i(1.0f, z5);
        if (this.f12933I != null && this.f12970j0 != null) {
            this.f12978n0 = r0() ? TextUtils.ellipsize(this.f12933I, this.f12945U, this.f12970j0.getWidth(), this.f12931G) : this.f12933I;
        }
        CharSequence charSequence = this.f12978n0;
        if (charSequence != null) {
            this.f12972k0 = M(this.f12945U, charSequence);
        } else {
            this.f12972k0 = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f12973l, this.f12934J ? 1 : 0);
        Rect rect = this.f12967i;
        if (rect == null) {
            rect = this.f12965h;
        }
        int i5 = absoluteGravity & 112;
        if (i5 == 48) {
            this.f12987s = rect.top;
        } else if (i5 != 80) {
            this.f12987s = rect.centerY() - ((this.f12945U.descent() - this.f12945U.ascent()) / 2.0f);
        } else {
            this.f12987s = rect.bottom + this.f12945U.ascent();
        }
        int i6 = absoluteGravity & 8388615;
        if (i6 == 1) {
            this.f12991u = rect.centerX() - (this.f12972k0 / 2.0f);
        } else if (i6 != 5) {
            this.f12991u = rect.left;
        } else {
            this.f12991u = rect.right - this.f12972k0;
        }
        if (this.f12972k0 <= this.f12965h.width()) {
            float f5 = this.f12991u;
            float fMax = f5 + Math.max(0.0f, this.f12965h.left - f5);
            this.f12991u = fMax;
            this.f12991u = fMax + Math.min(0.0f, this.f12965h.right - (this.f12972k0 + fMax));
        }
        if (m() <= this.f12965h.height()) {
            float f6 = this.f12987s;
            float fMax2 = f6 + Math.max(0.0f, this.f12965h.top - f6);
            this.f12987s = fMax2;
            this.f12987s = fMax2 + Math.min(0.0f, this.f12965h.bottom - (q() + fMax2));
        }
        i(0.0f, z5);
        float height = this.f12970j0 != null ? r11.getHeight() : 0.0f;
        StaticLayout staticLayout = this.f12970j0;
        if (staticLayout == null || this.f12980o0 <= 1) {
            CharSequence charSequence2 = this.f12933I;
            fM = charSequence2 != null ? M(this.f12945U, charSequence2) : 0.0f;
        } else {
            fM = staticLayout.getWidth();
        }
        StaticLayout staticLayout2 = this.f12970j0;
        this.f12983q = staticLayout2 != null ? staticLayout2.getLineCount() : 0;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f12971k, this.f12934J ? 1 : 0);
        int i7 = absoluteGravity2 & 112;
        if (i7 == 48) {
            this.f12985r = this.f12963g.top;
        } else if (i7 != 80) {
            this.f12985r = this.f12963g.centerY() - (height / 2.0f);
        } else {
            this.f12985r = (this.f12963g.bottom - height) + (this.f12996w0 ? this.f12945U.descent() : 0.0f);
        }
        int i8 = absoluteGravity2 & 8388615;
        if (i8 == 1) {
            this.f12989t = this.f12963g.centerX() - (fM / 2.0f);
        } else if (i8 != 5) {
            this.f12989t = this.f12963g.left;
        } else {
            this.f12989t = this.f12963g.right - fM;
        }
        k0(this.f12953b);
    }

    private void c() {
        g(this.f12953b);
    }

    private float d(float f5) {
        float f6 = this.f12959e;
        return f5 <= f6 ? C0553a.b(1.0f, 0.0f, this.f12957d, f6, f5) : C0553a.b(0.0f, 1.0f, f6, 1.0f, f5);
    }

    private float e() {
        float f5 = this.f12957d;
        return f5 + ((1.0f - f5) * 0.5f);
    }

    private boolean f(CharSequence charSequence) {
        boolean zH = H();
        return this.f12935K ? J(charSequence, zH) : zH;
    }

    private void f0(float f5) {
        this.f12976m0 = f5;
        this.f12951a.postInvalidateOnAnimation();
    }

    private void g(float f5) {
        float f6;
        F(f5);
        if (!this.f12955c) {
            this.f12993v = K(this.f12989t, this.f12991u, f5, this.f12947W);
            this.f12995w = K(this.f12985r, this.f12987s, f5, this.f12947W);
            k0(f5);
            f6 = f5;
        } else if (f5 < this.f12959e) {
            this.f12993v = this.f12989t;
            this.f12995w = this.f12985r;
            k0(0.0f);
            f6 = 0.0f;
        } else {
            this.f12993v = this.f12991u;
            this.f12995w = this.f12987s - Math.max(0, this.f12961f);
            k0(1.0f);
            f6 = 1.0f;
        }
        TimeInterpolator timeInterpolator = C0553a.f11784b;
        V(1.0f - K(0.0f, 1.0f, 1.0f - f5, timeInterpolator));
        f0(K(1.0f, 0.0f, f5, timeInterpolator));
        if (this.f12981p != this.f12979o) {
            this.f12945U.setColor(a(v(), t(), f6));
        } else {
            this.f12945U.setColor(t());
        }
        float f7 = this.f12964g0;
        float f8 = this.f12966h0;
        if (f7 != f8) {
            this.f12945U.setLetterSpacing(K(f8, f7, f5, timeInterpolator));
        } else {
            this.f12945U.setLetterSpacing(f7);
        }
        this.f12938N = K(this.f12956c0, this.f12949Y, f5, null);
        this.f12939O = K(this.f12958d0, this.f12950Z, f5, null);
        this.f12940P = K(this.f12960e0, this.f12952a0, f5, null);
        int iA = a(u(this.f12962f0), u(this.f12954b0), f5);
        this.f12941Q = iA;
        this.f12945U.setShadowLayer(this.f12938N, this.f12939O, this.f12940P, iA);
        if (this.f12955c) {
            this.f12945U.setAlpha((int) (d(f5) * this.f12945U.getAlpha()));
            TextPaint textPaint = this.f12945U;
            textPaint.setShadowLayer(this.f12938N, this.f12939O, this.f12940P, C0777a.a(this.f12941Q, textPaint.getAlpha()));
        }
        this.f12951a.postInvalidateOnAnimation();
    }

    private void h(float f5) {
        i(f5, false);
    }

    private void i(float f5, boolean z5) {
        Typeface typeface;
        float f6;
        float f7;
        if (this.f12932H == null) {
            return;
        }
        float fWidth = this.f12965h.width();
        float fWidth2 = this.f12963g.width();
        if (G(f5, 1.0f)) {
            f6 = r0() ? this.f12977n : this.f12975m;
            f7 = r0() ? this.f12964g0 : this.f12966h0;
            this.f12936L = r0() ? 1.0f : K(this.f12975m, this.f12977n, f5, this.f12948X) / this.f12975m;
            if (!r0()) {
                fWidth = fWidth2;
            }
            typeface = this.f12997x;
            fWidth2 = fWidth;
        } else {
            float f8 = this.f12975m;
            float f9 = this.f12966h0;
            typeface = this.f12925A;
            if (G(f5, 0.0f)) {
                this.f12936L = 1.0f;
            } else {
                this.f12936L = K(this.f12975m, this.f12977n, f5, this.f12948X) / this.f12975m;
            }
            float f10 = this.f12977n / this.f12975m;
            float f11 = fWidth2 * f10;
            if (!z5 && !this.f12955c && f11 > fWidth && r0()) {
                fWidth2 = Math.min(fWidth / f10, fWidth2);
            }
            f6 = f8;
            f7 = f9;
        }
        int i5 = f5 < 0.5f ? this.f12980o0 : this.f12982p0;
        if (fWidth2 > 0.0f) {
            boolean z6 = this.f12937M != f6;
            boolean z7 = this.f12968i0 != f7;
            boolean z8 = this.f12928D != typeface;
            StaticLayout staticLayout = this.f12970j0;
            boolean z9 = z6 || z7 || (staticLayout != null && (fWidth2 > ((float) staticLayout.getWidth()) ? 1 : (fWidth2 == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z8 || (this.f12942R != i5) || this.f12944T;
            this.f12937M = f6;
            this.f12968i0 = f7;
            this.f12928D = typeface;
            this.f12944T = false;
            this.f12942R = i5;
            this.f12945U.setLinearText(this.f12936L != 1.0f);
            z = z9;
        }
        if (this.f12933I == null || z) {
            this.f12945U.setTextSize(this.f12937M);
            this.f12945U.setTypeface(this.f12928D);
            this.f12945U.setLetterSpacing(this.f12968i0);
            this.f12934J = f(this.f12932H);
            StaticLayout staticLayoutJ = j(q0() ? i5 : 1, this.f12945U, this.f12932H, fWidth2 * (r0() ? 1.0f : this.f12936L), this.f12934J);
            this.f12970j0 = staticLayoutJ;
            this.f12933I = staticLayoutJ.getText();
        }
    }

    private boolean i0(Typeface typeface) {
        C0979a c0979a = this.f12929E;
        if (c0979a != null) {
            c0979a.c();
        }
        if (this.f12927C == typeface) {
            return false;
        }
        this.f12927C = typeface;
        Typeface typefaceB = q1.g.b(this.f12951a.getContext().getResources().getConfiguration(), typeface);
        this.f12926B = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.f12927C;
        }
        this.f12925A = typefaceB;
        return true;
    }

    private StaticLayout j(int i5, TextPaint textPaint, CharSequence charSequence, float f5, boolean z5) {
        return (StaticLayout) D.h.e(k.b(charSequence, textPaint, (int) f5).d(this.f12931G).g(z5).c(i5 == 1 ? Layout.Alignment.ALIGN_NORMAL : C()).f(false).i(i5).h(this.f12984q0, this.f12986r0).e(this.f12988s0).j(this.f12990t0).a());
    }

    private void k0(float f5) {
        h(f5);
        this.f12951a.postInvalidateOnAnimation();
    }

    private void l(Canvas canvas, float f5, float f6) {
        int alpha = this.f12945U.getAlpha();
        canvas.translate(f5, f6);
        if (!this.f12955c) {
            this.f12945U.setAlpha((int) (this.f12976m0 * alpha));
            TextPaint textPaint = this.f12945U;
            textPaint.setShadowLayer(this.f12938N, this.f12939O, this.f12940P, C0777a.a(this.f12941Q, textPaint.getAlpha()));
            this.f12970j0.draw(canvas);
        }
        if (!this.f12955c) {
            this.f12945U.setAlpha((int) (this.f12974l0 * alpha));
        }
        TextPaint textPaint2 = this.f12945U;
        textPaint2.setShadowLayer(this.f12938N, this.f12939O, this.f12940P, C0777a.a(this.f12941Q, textPaint2.getAlpha()));
        int lineBaseline = this.f12970j0.getLineBaseline(0);
        CharSequence charSequence = this.f12978n0;
        float f7 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f7, this.f12945U);
        this.f12945U.setShadowLayer(this.f12938N, this.f12939O, this.f12940P, this.f12941Q);
        if (this.f12955c) {
            return;
        }
        String strTrim = this.f12978n0.toString().trim();
        if (strTrim.endsWith("…")) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        this.f12945U.setAlpha(alpha);
        canvas.drawText(strTrim, 0, Math.min(this.f12970j0.getLineEnd(0), strTrim.length()), 0.0f, f7, (Paint) this.f12945U);
    }

    private boolean q0() {
        if (this.f12980o0 > 1 || this.f12982p0 > 1) {
            return !this.f12934J || this.f12955c;
        }
        return false;
    }

    private float r(int i5, int i6) {
        float f5;
        float f6;
        int i7;
        if (i6 == 17 || (i6 & 7) == 1) {
            f5 = i5 / 2.0f;
            f6 = this.f12972k0 / 2.0f;
        } else if ((i6 & 8388613) == 8388613 || (i6 & 5) == 5) {
            if (this.f12934J) {
                i7 = this.f12965h.left;
                return i7;
            }
            f5 = this.f12965h.right;
            f6 = this.f12972k0;
        } else {
            if (!this.f12934J) {
                i7 = this.f12965h.left;
                return i7;
            }
            f5 = this.f12965h.right;
            f6 = this.f12972k0;
        }
        return f5 - f6;
    }

    private boolean r0() {
        return this.f12982p0 == 1;
    }

    private float s(RectF rectF, int i5, int i6) {
        float f5;
        float f6;
        int i7;
        if (i6 == 17 || (i6 & 7) == 1) {
            f5 = i5 / 2.0f;
            f6 = this.f12972k0 / 2.0f;
        } else if ((i6 & 8388613) == 8388613 || (i6 & 5) == 5) {
            if (!this.f12934J) {
                i7 = this.f12965h.right;
                return i7;
            }
            f5 = rectF.left;
            f6 = this.f12972k0;
        } else {
            if (this.f12934J) {
                i7 = this.f12965h.right;
                return i7;
            }
            f5 = rectF.left;
            f6 = this.f12972k0;
        }
        return f5 + f6;
    }

    private int u(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f12943S;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    private int v() {
        return u(this.f12979o);
    }

    public float A() {
        E(this.f12946V);
        return -this.f12946V.ascent();
    }

    public float B() {
        return this.f12953b;
    }

    public final boolean I() {
        ColorStateList colorStateList = this.f12981p;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f12979o;
        return colorStateList2 != null && colorStateList2.isStateful();
    }

    public void L(Configuration configuration) {
        Typeface typeface = this.f12999z;
        if (typeface != null) {
            this.f12998y = q1.g.b(configuration, typeface);
        }
        Typeface typeface2 = this.f12927C;
        if (typeface2 != null) {
            this.f12926B = q1.g.b(configuration, typeface2);
        }
        Typeface typeface3 = this.f12998y;
        if (typeface3 == null) {
            typeface3 = this.f12999z;
        }
        this.f12997x = typeface3;
        Typeface typeface4 = this.f12926B;
        if (typeface4 == null) {
            typeface4 = this.f12927C;
        }
        this.f12925A = typeface4;
        O(true);
    }

    public void N() {
        O(false);
    }

    public void O(boolean z5) {
        if ((this.f12951a.getHeight() <= 0 || this.f12951a.getWidth() <= 0) && !z5) {
            return;
        }
        b(z5);
        c();
    }

    public void Q(ColorStateList colorStateList) {
        if (this.f12981p == colorStateList && this.f12979o == colorStateList) {
            return;
        }
        this.f12981p = colorStateList;
        this.f12979o = colorStateList;
        N();
    }

    public void R(int i5, int i6, int i7, int i8) {
        if (P(this.f12965h, i5, i6, i7, i8)) {
            return;
        }
        this.f12965h.set(i5, i6, i7, i8);
        this.f12944T = true;
    }

    public void S(Rect rect) {
        R(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void T(int i5) {
        if (i5 != this.f12982p0) {
            this.f12982p0 = i5;
            N();
        }
    }

    public void U(int i5) {
        C0982d c0982d = new C0982d(this.f12951a.getContext(), i5);
        if (c0982d.j() != null) {
            this.f12981p = c0982d.j();
        }
        if (c0982d.k() != 0.0f) {
            this.f12977n = c0982d.k();
        }
        ColorStateList colorStateList = c0982d.f19887c;
        if (colorStateList != null) {
            this.f12954b0 = colorStateList;
        }
        this.f12950Z = c0982d.f19893i;
        this.f12952a0 = c0982d.f19894j;
        this.f12949Y = c0982d.f19895k;
        this.f12964g0 = c0982d.f19897m;
        C0979a c0979a = this.f12930F;
        if (c0979a != null) {
            c0979a.c();
        }
        this.f12930F = new C0979a(new C0168a(), c0982d.e());
        c0982d.h(this.f12951a.getContext(), this.f12930F);
        N();
    }

    public void W(ColorStateList colorStateList) {
        if (this.f12981p != colorStateList) {
            this.f12981p = colorStateList;
            N();
        }
    }

    public void X(int i5) {
        if (this.f12973l != i5) {
            this.f12973l = i5;
            N();
        }
    }

    public void Y(Typeface typeface) {
        if (Z(typeface)) {
            N();
        }
    }

    public void a0(int i5, int i6, int i7, int i8) {
        b0(i5, i6, i7, i8, true);
    }

    public void b0(int i5, int i6, int i7, int i8, boolean z5) {
        if (P(this.f12963g, i5, i6, i7, i8) && z5 == this.f12996w0) {
            return;
        }
        this.f12963g.set(i5, i6, i7, i8);
        this.f12944T = true;
        this.f12996w0 = z5;
    }

    public void c0(Rect rect) {
        a0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void d0(float f5) {
        if (this.f12966h0 != f5) {
            this.f12966h0 = f5;
            N();
        }
    }

    public void e0(int i5) {
        if (i5 != this.f12980o0) {
            this.f12980o0 = i5;
            N();
        }
    }

    public void g0(int i5) {
        if (this.f12971k != i5) {
            this.f12971k = i5;
            N();
        }
    }

    public void h0(float f5) {
        if (this.f12975m != f5) {
            this.f12975m = f5;
            N();
        }
    }

    public void j0(float f5) {
        float fA = B.a.a(f5, 0.0f, 1.0f);
        if (fA != this.f12953b) {
            this.f12953b = fA;
            c();
        }
    }

    public void k(Canvas canvas) {
        int iSave = canvas.save();
        if (this.f12933I == null || this.f12969j.width() <= 0.0f || this.f12969j.height() <= 0.0f) {
            return;
        }
        this.f12945U.setTextSize(this.f12937M);
        float f5 = this.f12993v;
        float f6 = this.f12995w;
        float f7 = this.f12936L;
        if (f7 != 1.0f && !this.f12955c) {
            canvas.scale(f7, f7, f5, f6);
        }
        if (q0() && r0() && (!this.f12955c || this.f12953b > this.f12959e)) {
            l(canvas, this.f12993v - this.f12970j0.getLineStart(0), f6);
        } else {
            canvas.translate(f5, f6);
            this.f12970j0.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    public void l0(TimeInterpolator timeInterpolator) {
        this.f12947W = timeInterpolator;
        N();
    }

    public float m() {
        D(this.f12946V);
        return (-this.f12946V.ascent()) + this.f12946V.descent();
    }

    public final boolean m0(int[] iArr) {
        this.f12943S = iArr;
        if (!I()) {
            return false;
        }
        N();
        return true;
    }

    public float n() {
        D(this.f12946V);
        return -this.f12946V.ascent();
    }

    public void n0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.f12932H, charSequence)) {
            this.f12932H = charSequence;
            this.f12933I = null;
            N();
        }
    }

    public void o(RectF rectF, int i5, int i6) {
        this.f12934J = f(this.f12932H);
        rectF.left = Math.max(r(i5, i6), this.f12965h.left);
        rectF.top = this.f12965h.top;
        rectF.right = Math.min(s(rectF, i5, i6), this.f12965h.right);
        rectF.bottom = this.f12965h.top + q();
        if (this.f12970j0 == null || r0()) {
            return;
        }
        float lineWidth = this.f12970j0.getLineWidth(r4.getLineCount() - 1) * (this.f12977n / this.f12975m);
        if (this.f12934J) {
            rectF.left = rectF.right - lineWidth;
        } else {
            rectF.right = rectF.left + lineWidth;
        }
    }

    public void o0(TimeInterpolator timeInterpolator) {
        this.f12948X = timeInterpolator;
        N();
    }

    public ColorStateList p() {
        return this.f12981p;
    }

    public void p0(Typeface typeface) {
        boolean Z5 = Z(typeface);
        boolean zI0 = i0(typeface);
        if (Z5 || zI0) {
            N();
        }
    }

    public float q() {
        int i5 = this.f12992u0;
        return i5 != -1 ? i5 : n();
    }

    public void s0(int i5) {
        D(this.f12946V);
        float f5 = i5;
        this.f12992u0 = j(this.f12982p0, this.f12946V, this.f12932H, f5 * (this.f12977n / this.f12975m), this.f12934J).getHeight();
        E(this.f12946V);
        this.f12994v0 = j(this.f12980o0, this.f12946V, this.f12932H, f5, this.f12934J).getHeight();
    }

    public int t() {
        return u(this.f12981p);
    }

    public int w() {
        return this.f12983q;
    }

    public int x() {
        return this.f12980o0;
    }

    public float y() {
        E(this.f12946V);
        return (-this.f12946V.ascent()) + this.f12946V.descent();
    }

    public float z() {
        int i5 = this.f12994v0;
        return i5 != -1 ? i5 : A();
    }
}

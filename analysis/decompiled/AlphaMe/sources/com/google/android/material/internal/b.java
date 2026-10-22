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
import android.view.View;
import c0.C0387b;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import n1.AbstractC0775a;
import w1.C0970a;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: B, reason: collision with root package name */
    public CharSequence f10770B;

    /* renamed from: C, reason: collision with root package name */
    public CharSequence f10771C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f10772D;

    /* renamed from: F, reason: collision with root package name */
    public float f10774F;

    /* renamed from: G, reason: collision with root package name */
    public float f10775G;

    /* renamed from: H, reason: collision with root package name */
    public float f10776H;

    /* renamed from: I, reason: collision with root package name */
    public float f10777I;

    /* renamed from: J, reason: collision with root package name */
    public float f10778J;

    /* renamed from: K, reason: collision with root package name */
    public int f10779K;

    /* renamed from: L, reason: collision with root package name */
    public int f10780L;

    /* renamed from: M, reason: collision with root package name */
    public int[] f10781M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f10782N;

    /* renamed from: O, reason: collision with root package name */
    public final TextPaint f10783O;

    /* renamed from: P, reason: collision with root package name */
    public final TextPaint f10784P;

    /* renamed from: Q, reason: collision with root package name */
    public TimeInterpolator f10785Q;

    /* renamed from: R, reason: collision with root package name */
    public TimeInterpolator f10786R;

    /* renamed from: S, reason: collision with root package name */
    public float f10787S;
    public float T;

    /* renamed from: U, reason: collision with root package name */
    public float f10788U;

    /* renamed from: V, reason: collision with root package name */
    public ColorStateList f10789V;

    /* renamed from: W, reason: collision with root package name */
    public float f10790W;

    /* renamed from: X, reason: collision with root package name */
    public float f10791X;

    /* renamed from: Y, reason: collision with root package name */
    public float f10792Y;

    /* renamed from: Z, reason: collision with root package name */
    public StaticLayout f10793Z;

    /* renamed from: a, reason: collision with root package name */
    public final View f10794a;

    /* renamed from: a0, reason: collision with root package name */
    public float f10795a0;

    /* renamed from: b, reason: collision with root package name */
    public float f10796b;

    /* renamed from: b0, reason: collision with root package name */
    public float f10797b0;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f10798c;

    /* renamed from: c0, reason: collision with root package name */
    public float f10799c0;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f10800d;

    /* renamed from: d0, reason: collision with root package name */
    public CharSequence f10801d0;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f10802e;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f10812j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f10814k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f10815k0;

    /* renamed from: l, reason: collision with root package name */
    public int f10816l;

    /* renamed from: m, reason: collision with root package name */
    public float f10817m;

    /* renamed from: n, reason: collision with root package name */
    public float f10818n;

    /* renamed from: o, reason: collision with root package name */
    public float f10819o;

    /* renamed from: p, reason: collision with root package name */
    public float f10820p;

    /* renamed from: q, reason: collision with root package name */
    public float f10821q;

    /* renamed from: r, reason: collision with root package name */
    public float f10822r;

    /* renamed from: s, reason: collision with root package name */
    public Typeface f10823s;

    /* renamed from: t, reason: collision with root package name */
    public Typeface f10824t;

    /* renamed from: u, reason: collision with root package name */
    public Typeface f10825u;

    /* renamed from: v, reason: collision with root package name */
    public Typeface f10826v;

    /* renamed from: w, reason: collision with root package name */
    public Typeface f10827w;

    /* renamed from: x, reason: collision with root package name */
    public Typeface f10828x;

    /* renamed from: y, reason: collision with root package name */
    public Typeface f10829y;

    /* renamed from: z, reason: collision with root package name */
    public C0970a f10830z;

    /* renamed from: f, reason: collision with root package name */
    public int f10804f = 16;

    /* renamed from: g, reason: collision with root package name */
    public int f10806g = 16;

    /* renamed from: h, reason: collision with root package name */
    public float f10808h = 15.0f;

    /* renamed from: i, reason: collision with root package name */
    public float f10810i = 15.0f;

    /* renamed from: A, reason: collision with root package name */
    public final TextUtils.TruncateAt f10769A = TextUtils.TruncateAt.END;

    /* renamed from: E, reason: collision with root package name */
    public final boolean f10773E = true;

    /* renamed from: e0, reason: collision with root package name */
    public int f10803e0 = 1;

    /* renamed from: f0, reason: collision with root package name */
    public int f10805f0 = 1;

    /* renamed from: g0, reason: collision with root package name */
    public final float f10807g0 = 1.0f;

    /* renamed from: h0, reason: collision with root package name */
    public final int f10809h0 = 1;

    /* renamed from: i0, reason: collision with root package name */
    public int f10811i0 = -1;

    /* renamed from: j0, reason: collision with root package name */
    public int f10813j0 = -1;

    public b(View view) {
        this.f10794a = view;
        TextPaint textPaint = new TextPaint(129);
        this.f10783O = textPaint;
        this.f10784P = new TextPaint(textPaint);
        this.f10800d = new Rect();
        this.f10798c = new Rect();
        this.f10802e = new RectF();
        i(view.getContext().getResources().getConfiguration());
    }

    public static int a(float f4, int i4, int i5) {
        float f5 = 1.0f - f4;
        return Color.argb(Math.round((Color.alpha(i5) * f4) + (Color.alpha(i4) * f5)), Math.round((Color.red(i5) * f4) + (Color.red(i4) * f5)), Math.round((Color.green(i5) * f4) + (Color.green(i4) * f5)), Math.round((Color.blue(i5) * f4) + (Color.blue(i4) * f5)));
    }

    public static float h(float f4, float f5, float f6, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f6 = timeInterpolator.getInterpolation(f6);
        }
        return AbstractC0775a.a(f4, f5, f6);
    }

    public final void b() {
        float f4 = this.f10796b;
        float f5 = this.f10798c.left;
        Rect rect = this.f10800d;
        float fH = h(f5, rect.left, f4, this.f10785Q);
        RectF rectF = this.f10802e;
        rectF.left = fH;
        rectF.top = h(this.f10817m, this.f10818n, f4, this.f10785Q);
        rectF.right = h(r1.right, rect.right, f4, this.f10785Q);
        rectF.bottom = h(r1.bottom, rect.bottom, f4, this.f10785Q);
        this.f10821q = h(this.f10819o, this.f10820p, f4, this.f10785Q);
        this.f10822r = h(this.f10817m, this.f10818n, f4, this.f10785Q);
        d(f4, false);
        View view = this.f10794a;
        view.postInvalidateOnAnimation();
        C0387b c0387b = AbstractC0775a.f13651b;
        this.f10797b0 = 1.0f - h(Property.DEFAULT_FLOAT_VALUE, 1.0f, 1.0f - f4, c0387b);
        view.postInvalidateOnAnimation();
        this.f10799c0 = h(1.0f, Property.DEFAULT_FLOAT_VALUE, f4, c0387b);
        view.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.f10814k;
        ColorStateList colorStateList2 = this.f10812j;
        TextPaint textPaint = this.f10783O;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(f4, g(colorStateList2), g(this.f10814k)));
        } else {
            textPaint.setColor(g(colorStateList));
        }
        float f6 = this.f10790W;
        float f7 = this.f10791X;
        if (f6 != f7) {
            textPaint.setLetterSpacing(h(f7, f6, f4, c0387b));
        } else {
            textPaint.setLetterSpacing(f6);
        }
        this.f10776H = h(Property.DEFAULT_FLOAT_VALUE, this.f10787S, f4, null);
        this.f10777I = h(Property.DEFAULT_FLOAT_VALUE, this.T, f4, null);
        this.f10778J = h(Property.DEFAULT_FLOAT_VALUE, this.f10788U, f4, null);
        int iA = a(f4, g(null), g(this.f10789V));
        this.f10779K = iA;
        textPaint.setShadowLayer(this.f10776H, this.f10777I, this.f10778J, iA);
        view.postInvalidateOnAnimation();
    }

    public final boolean c(CharSequence charSequence) {
        boolean z4 = this.f10794a.getLayoutDirection() == 1;
        if (this.f10773E) {
            return (z4 ? I.j.f830d : I.j.f829c).f(charSequence, charSequence.length());
        }
        return z4;
    }

    public final void d(float f4, boolean z4) {
        float f5;
        Typeface typeface;
        float f6;
        if (this.f10770B == null) {
            return;
        }
        float fWidth = this.f10800d.width();
        float fWidth2 = this.f10798c.width();
        if (Math.abs(f4 - 1.0f) < 1.0E-5f) {
            f5 = o() ? this.f10810i : this.f10808h;
            f6 = o() ? this.f10790W : this.f10791X;
            this.f10774F = o() ? 1.0f : h(this.f10808h, this.f10810i, f4, this.f10786R) / this.f10808h;
            if (!o()) {
                fWidth = fWidth2;
            }
            typeface = this.f10823s;
            fWidth2 = fWidth;
        } else {
            f5 = this.f10808h;
            float f7 = this.f10791X;
            typeface = this.f10826v;
            if (Math.abs(f4 - Property.DEFAULT_FLOAT_VALUE) < 1.0E-5f) {
                this.f10774F = 1.0f;
            } else {
                this.f10774F = h(this.f10808h, this.f10810i, f4, this.f10786R) / this.f10808h;
            }
            float f8 = this.f10810i / this.f10808h;
            float f9 = fWidth2 * f8;
            if (!z4 && f9 > fWidth && o()) {
                fWidth2 = Math.min(fWidth / f8, fWidth2);
            }
            f6 = f7;
        }
        int i4 = f4 < 0.5f ? this.f10803e0 : this.f10805f0;
        TextPaint textPaint = this.f10783O;
        if (fWidth2 > Property.DEFAULT_FLOAT_VALUE) {
            boolean z5 = this.f10775G != f5;
            boolean z6 = this.f10792Y != f6;
            boolean z7 = this.f10829y != typeface;
            StaticLayout staticLayout = this.f10793Z;
            boolean z8 = z5 || z6 || (staticLayout != null && (fWidth2 > ((float) staticLayout.getWidth()) ? 1 : (fWidth2 == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z7 || (this.f10780L != i4) || this.f10782N;
            this.f10775G = f5;
            this.f10792Y = f6;
            this.f10829y = typeface;
            this.f10782N = false;
            this.f10780L = i4;
            textPaint.setLinearText(this.f10774F != 1.0f);
            z = z8;
        }
        if (this.f10771C == null || z) {
            textPaint.setTextSize(this.f10775G);
            textPaint.setTypeface(this.f10829y);
            textPaint.setLetterSpacing(this.f10792Y);
            boolean zC = c(this.f10770B);
            this.f10772D = zC;
            StaticLayout staticLayoutE = e(((this.f10803e0 > 1 || this.f10805f0 > 1) && !zC) ? i4 : 1, textPaint, this.f10770B, fWidth2 * (o() ? 1.0f : this.f10774F), this.f10772D);
            this.f10793Z = staticLayoutE;
            this.f10771C = staticLayoutE.getText();
        }
    }

    public final StaticLayout e(int i4, TextPaint textPaint, CharSequence charSequence, float f4, boolean z4) {
        Layout.Alignment alignment;
        if (i4 == 1) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(this.f10804f, this.f10772D ? 1 : 0) & 7;
            alignment = absoluteGravity != 1 ? absoluteGravity != 5 ? this.f10772D ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.f10772D ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
        }
        h hVar = new h(charSequence, textPaint, (int) f4);
        hVar.f10851l = this.f10769A;
        hVar.f10850k = z4;
        hVar.f10844e = alignment;
        hVar.f10849j = false;
        hVar.f10845f = i4;
        float f5 = this.f10807g0;
        hVar.f10846g = Property.DEFAULT_FLOAT_VALUE;
        hVar.f10847h = f5;
        hVar.f10848i = this.f10809h0;
        hVar.f10852m = null;
        StaticLayout staticLayoutA = hVar.a();
        staticLayoutA.getClass();
        return staticLayoutA;
    }

    public final float f() {
        int i4 = this.f10811i0;
        if (i4 != -1) {
            return i4;
        }
        TextPaint textPaint = this.f10784P;
        textPaint.setTextSize(this.f10810i);
        textPaint.setTypeface(this.f10823s);
        textPaint.setLetterSpacing(this.f10790W);
        return -textPaint.ascent();
    }

    public final int g(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f10781M;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void i(Configuration configuration) {
        Typeface typeface = this.f10825u;
        if (typeface != null) {
            this.f10824t = com.stepos.statsrpk.c.D(configuration, typeface);
        }
        Typeface typeface2 = this.f10828x;
        if (typeface2 != null) {
            this.f10827w = com.stepos.statsrpk.c.D(configuration, typeface2);
        }
        Typeface typeface3 = this.f10824t;
        if (typeface3 == null) {
            typeface3 = this.f10825u;
        }
        this.f10823s = typeface3;
        Typeface typeface4 = this.f10827w;
        if (typeface4 == null) {
            typeface4 = this.f10828x;
        }
        this.f10826v = typeface4;
        j(true);
    }

    public final void j(boolean z4) {
        float fMeasureText;
        View view = this.f10794a;
        if ((view.getHeight() <= 0 || view.getWidth() <= 0) && !z4) {
            return;
        }
        d(1.0f, z4);
        CharSequence charSequence = this.f10771C;
        TextPaint textPaint = this.f10783O;
        if (charSequence != null && this.f10793Z != null) {
            this.f10801d0 = o() ? TextUtils.ellipsize(this.f10771C, textPaint, this.f10793Z.getWidth(), this.f10769A) : this.f10771C;
        }
        CharSequence charSequence2 = this.f10801d0;
        float fDescent = Property.DEFAULT_FLOAT_VALUE;
        if (charSequence2 != null) {
            this.f10795a0 = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.f10795a0 = Property.DEFAULT_FLOAT_VALUE;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f10806g, this.f10772D ? 1 : 0);
        int i4 = absoluteGravity & 112;
        Rect rect = this.f10800d;
        if (i4 == 48) {
            this.f10818n = rect.top;
        } else if (i4 != 80) {
            this.f10818n = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.f10818n = textPaint.ascent() + rect.bottom;
        }
        int i5 = absoluteGravity & 8388615;
        if (i5 == 1) {
            this.f10820p = rect.centerX() - (this.f10795a0 / 2.0f);
        } else if (i5 != 5) {
            this.f10820p = rect.left;
        } else {
            this.f10820p = rect.right - this.f10795a0;
        }
        if (this.f10795a0 <= rect.width()) {
            float f4 = this.f10820p;
            float fMax = Math.max(Property.DEFAULT_FLOAT_VALUE, rect.left - f4) + f4;
            this.f10820p = fMax;
            this.f10820p = Math.min(Property.DEFAULT_FLOAT_VALUE, rect.right - (this.f10795a0 + fMax)) + fMax;
        }
        TextPaint textPaint2 = this.f10784P;
        textPaint2.setTextSize(this.f10810i);
        textPaint2.setTypeface(this.f10823s);
        textPaint2.setLetterSpacing(this.f10790W);
        if (textPaint2.descent() + (-textPaint2.ascent()) <= rect.height()) {
            float f5 = this.f10818n;
            float fMax2 = Math.max(Property.DEFAULT_FLOAT_VALUE, rect.top - f5) + f5;
            this.f10818n = fMax2;
            this.f10818n = Math.min(Property.DEFAULT_FLOAT_VALUE, rect.bottom - (f() + fMax2)) + fMax2;
        }
        d(Property.DEFAULT_FLOAT_VALUE, z4);
        float height = this.f10793Z != null ? r15.getHeight() : 0.0f;
        StaticLayout staticLayout = this.f10793Z;
        if (staticLayout == null || this.f10803e0 <= 1) {
            CharSequence charSequence3 = this.f10771C;
            fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            fMeasureText = staticLayout.getWidth();
        }
        StaticLayout staticLayout2 = this.f10793Z;
        this.f10816l = staticLayout2 != null ? staticLayout2.getLineCount() : 0;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f10804f, this.f10772D ? 1 : 0);
        int i6 = absoluteGravity2 & 112;
        Rect rect2 = this.f10798c;
        if (i6 == 48) {
            this.f10817m = rect2.top;
        } else if (i6 != 80) {
            this.f10817m = rect2.centerY() - (height / 2.0f);
        } else {
            float f6 = rect2.bottom - height;
            if (this.f10815k0) {
                fDescent = textPaint.descent();
            }
            this.f10817m = f6 + fDescent;
        }
        int i7 = absoluteGravity2 & 8388615;
        if (i7 == 1) {
            this.f10819o = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i7 != 5) {
            this.f10819o = rect2.left;
        } else {
            this.f10819o = rect2.right - fMeasureText;
        }
        d(this.f10796b, false);
        view.postInvalidateOnAnimation();
        b();
    }

    public final void k(ColorStateList colorStateList) {
        if (this.f10814k == colorStateList && this.f10812j == colorStateList) {
            return;
        }
        this.f10814k = colorStateList;
        this.f10812j = colorStateList;
        j(false);
    }

    public final boolean l(Typeface typeface) {
        C0970a c0970a = this.f10830z;
        if (c0970a != null) {
            c0970a.f15806k = true;
        }
        if (this.f10825u == typeface) {
            return false;
        }
        this.f10825u = typeface;
        Typeface typefaceD = com.stepos.statsrpk.c.D(this.f10794a.getContext().getResources().getConfiguration(), typeface);
        this.f10824t = typefaceD;
        if (typefaceD == null) {
            typefaceD = this.f10825u;
        }
        this.f10823s = typefaceD;
        return true;
    }

    public final void m(float f4) {
        float fN = AbstractC0557a.n(f4, Property.DEFAULT_FLOAT_VALUE, 1.0f);
        if (fN != this.f10796b) {
            this.f10796b = fN;
            b();
        }
    }

    public final void n(Typeface typeface) {
        boolean z4;
        boolean zL = l(typeface);
        if (this.f10828x != typeface) {
            this.f10828x = typeface;
            Typeface typefaceD = com.stepos.statsrpk.c.D(this.f10794a.getContext().getResources().getConfiguration(), typeface);
            this.f10827w = typefaceD;
            if (typefaceD == null) {
                typefaceD = this.f10828x;
            }
            this.f10826v = typefaceD;
            z4 = true;
        } else {
            z4 = false;
        }
        if (zL || z4) {
            j(false);
        }
    }

    public final boolean o() {
        return this.f10805f0 == 1;
    }
}

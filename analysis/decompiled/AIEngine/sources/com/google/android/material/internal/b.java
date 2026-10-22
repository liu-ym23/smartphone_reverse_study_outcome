package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import com.google.android.material.textfield.TextInputLayout;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {
    public CharSequence B;
    public CharSequence C;
    public boolean D;
    public float F;
    public float G;
    public float H;
    public float I;
    public float J;
    public int K;
    public int L;
    public int[] M;
    public boolean N;
    public final TextPaint O;
    public final TextPaint P;
    public TimeInterpolator Q;
    public TimeInterpolator R;
    public float S;
    public float T;
    public float U;
    public ColorStateList V;
    public float W;
    public float X;
    public float Y;
    public StaticLayout Z;

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f5054a;

    /* renamed from: a0, reason: collision with root package name */
    public float f5055a0;

    /* renamed from: b, reason: collision with root package name */
    public float f5056b;
    public float b0;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f5057c;
    public float c0;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f5058d;

    /* renamed from: d0, reason: collision with root package name */
    public CharSequence f5059d0;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f5060e;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f5069j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f5071k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f5072k0;

    /* renamed from: l, reason: collision with root package name */
    public int f5073l;

    /* renamed from: m, reason: collision with root package name */
    public float f5074m;

    /* renamed from: n, reason: collision with root package name */
    public float f5075n;

    /* renamed from: o, reason: collision with root package name */
    public float f5076o;

    /* renamed from: p, reason: collision with root package name */
    public float f5077p;

    /* renamed from: q, reason: collision with root package name */
    public float f5078q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public Typeface f5079s;

    /* renamed from: t, reason: collision with root package name */
    public Typeface f5080t;

    /* renamed from: u, reason: collision with root package name */
    public Typeface f5081u;

    /* renamed from: v, reason: collision with root package name */
    public Typeface f5082v;

    /* renamed from: w, reason: collision with root package name */
    public Typeface f5083w;

    /* renamed from: x, reason: collision with root package name */
    public Typeface f5084x;

    /* renamed from: y, reason: collision with root package name */
    public Typeface f5085y;
    public w4.a z;

    /* renamed from: f, reason: collision with root package name */
    public int f5062f = 16;

    /* renamed from: g, reason: collision with root package name */
    public int f5064g = 16;
    public float h = 15.0f;

    /* renamed from: i, reason: collision with root package name */
    public float f5067i = 15.0f;
    public final TextUtils.TruncateAt A = TextUtils.TruncateAt.END;
    public final boolean E = true;

    /* renamed from: e0, reason: collision with root package name */
    public int f5061e0 = 1;

    /* renamed from: f0, reason: collision with root package name */
    public int f5063f0 = 1;

    /* renamed from: g0, reason: collision with root package name */
    public final float f5065g0 = 1.0f;

    /* renamed from: h0, reason: collision with root package name */
    public final int f5066h0 = 1;

    /* renamed from: i0, reason: collision with root package name */
    public int f5068i0 = -1;

    /* renamed from: j0, reason: collision with root package name */
    public int f5070j0 = -1;

    public b(TextInputLayout textInputLayout) {
        this.f5054a = textInputLayout;
        TextPaint textPaint = new TextPaint(129);
        this.O = textPaint;
        this.P = new TextPaint(textPaint);
        this.f5058d = new Rect();
        this.f5057c = new Rect();
        this.f5060e = new RectF();
        i(textInputLayout.getContext().getResources().getConfiguration());
    }

    public static int a(float f8, int i10, int i11) {
        float f9 = 1.0f - f8;
        return Color.argb(Math.round((Color.alpha(i11) * f8) + (Color.alpha(i10) * f9)), Math.round((Color.red(i11) * f8) + (Color.red(i10) * f9)), Math.round((Color.green(i11) * f8) + (Color.green(i10) * f9)), Math.round((Color.blue(i11) * f8) + (Color.blue(i10) * f9)));
    }

    public static float h(float f8, float f9, float f10, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f10 = timeInterpolator.getInterpolation(f10);
        }
        return l4.a.a(f8, f9, f10);
    }

    public final void b() {
        float f8 = this.f5056b;
        float f9 = this.f5057c.left;
        Rect rect = this.f5058d;
        float fH = h(f9, rect.left, f8, this.Q);
        RectF rectF = this.f5060e;
        rectF.left = fH;
        rectF.top = h(this.f5074m, this.f5075n, f8, this.Q);
        rectF.right = h(r1.right, rect.right, f8, this.Q);
        rectF.bottom = h(r1.bottom, rect.bottom, f8, this.Q);
        this.f5078q = h(this.f5076o, this.f5077p, f8, this.Q);
        this.r = h(this.f5074m, this.f5075n, f8, this.Q);
        d(f8, false);
        TextInputLayout textInputLayout = this.f5054a;
        textInputLayout.postInvalidateOnAnimation();
        o1.b bVar = l4.a.f10221b;
        this.b0 = 1.0f - h(0.0f, 1.0f, 1.0f - f8, bVar);
        textInputLayout.postInvalidateOnAnimation();
        this.c0 = h(1.0f, 0.0f, f8, bVar);
        textInputLayout.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.f5071k;
        ColorStateList colorStateList2 = this.f5069j;
        TextPaint textPaint = this.O;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(f8, g(colorStateList2), g(this.f5071k)));
        } else {
            textPaint.setColor(g(colorStateList));
        }
        float f10 = this.W;
        float f11 = this.X;
        if (f10 != f11) {
            textPaint.setLetterSpacing(h(f11, f10, f8, bVar));
        } else {
            textPaint.setLetterSpacing(f10);
        }
        this.H = l4.a.a(0.0f, this.S, f8);
        this.I = l4.a.a(0.0f, this.T, f8);
        this.J = l4.a.a(0.0f, this.U, f8);
        int iA = a(f8, 0, g(this.V));
        this.K = iA;
        textPaint.setShadowLayer(this.H, this.I, this.J, iA);
        textInputLayout.postInvalidateOnAnimation();
    }

    public final boolean c(CharSequence charSequence) {
        boolean z = this.f5054a.getLayoutDirection() == 1;
        if (this.E) {
            return (z ? t0.c.f12915d : t0.c.f12914c).b(charSequence, charSequence.length());
        }
        return z;
    }

    public final void d(float f8, boolean z) {
        float f9;
        Typeface typeface;
        float f10;
        if (this.B == null) {
            return;
        }
        float fWidth = this.f5058d.width();
        float fWidth2 = this.f5057c.width();
        if (Math.abs(f8 - 1.0f) < 1.0E-5f) {
            f9 = o() ? this.f5067i : this.h;
            f10 = o() ? this.W : this.X;
            this.F = o() ? 1.0f : h(this.h, this.f5067i, f8, this.R) / this.h;
            if (!o()) {
                fWidth = fWidth2;
            }
            typeface = this.f5079s;
            fWidth2 = fWidth;
        } else {
            f9 = this.h;
            float f11 = this.X;
            typeface = this.f5082v;
            if (Math.abs(f8 - 0.0f) < 1.0E-5f) {
                this.F = 1.0f;
            } else {
                this.F = h(this.h, this.f5067i, f8, this.R) / this.h;
            }
            float f12 = this.f5067i / this.h;
            float f13 = fWidth2 * f12;
            if (!z && f13 > fWidth && o()) {
                fWidth2 = Math.min(fWidth / f12, fWidth2);
            }
            f10 = f11;
        }
        int i10 = f8 < 0.5f ? this.f5061e0 : this.f5063f0;
        TextPaint textPaint = this.O;
        if (fWidth2 > 0.0f) {
            boolean z3 = this.G != f9;
            boolean z10 = this.Y != f10;
            boolean z11 = this.f5085y != typeface;
            StaticLayout staticLayout = this.Z;
            boolean z12 = z3 || z10 || (staticLayout != null && (fWidth2 > ((float) staticLayout.getWidth()) ? 1 : (fWidth2 == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z11 || (this.L != i10) || this.N;
            this.G = f9;
            this.Y = f10;
            this.f5085y = typeface;
            this.N = false;
            this.L = i10;
            textPaint.setLinearText(this.F != 1.0f);
            z = z12;
        }
        if (this.C == null || z) {
            textPaint.setTextSize(this.G);
            textPaint.setTypeface(this.f5085y);
            textPaint.setLetterSpacing(this.Y);
            boolean zC = c(this.B);
            this.D = zC;
            StaticLayout staticLayoutE = e(((this.f5061e0 > 1 || this.f5063f0 > 1) && !zC) ? i10 : 1, textPaint, this.B, fWidth2 * (o() ? 1.0f : this.F), this.D);
            this.Z = staticLayoutE;
            this.C = staticLayoutE.getText();
        }
    }

    public final StaticLayout e(int i10, TextPaint textPaint, CharSequence charSequence, float f8, boolean z) {
        Layout.Alignment alignment;
        if (i10 == 1) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(this.f5062f, this.D ? 1 : 0) & 7;
            alignment = absoluteGravity != 1 ? absoluteGravity != 5 ? this.D ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.D ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
        }
        StaticLayoutBuilderCompat staticLayoutBuilderCompat = new StaticLayoutBuilderCompat(charSequence, textPaint, (int) f8);
        staticLayoutBuilderCompat.f5050l = this.A;
        staticLayoutBuilderCompat.f5049k = z;
        staticLayoutBuilderCompat.f5044e = alignment;
        staticLayoutBuilderCompat.f5048j = false;
        staticLayoutBuilderCompat.f5045f = i10;
        float f9 = this.f5065g0;
        staticLayoutBuilderCompat.f5046g = 0.0f;
        staticLayoutBuilderCompat.h = f9;
        staticLayoutBuilderCompat.f5047i = this.f5066h0;
        staticLayoutBuilderCompat.f5051m = null;
        StaticLayout staticLayoutA = staticLayoutBuilderCompat.a();
        staticLayoutA.getClass();
        return staticLayoutA;
    }

    public final float f() {
        int i10 = this.f5068i0;
        if (i10 != -1) {
            return i10;
        }
        float f8 = this.f5067i;
        TextPaint textPaint = this.P;
        textPaint.setTextSize(f8);
        textPaint.setTypeface(this.f5079s);
        textPaint.setLetterSpacing(this.W);
        return -textPaint.ascent();
    }

    public final int g(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.M;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void i(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f5081u;
            if (typeface != null) {
                this.f5080t = w4.f.a(configuration, typeface);
            }
            Typeface typeface2 = this.f5084x;
            if (typeface2 != null) {
                this.f5083w = w4.f.a(configuration, typeface2);
            }
            Typeface typeface3 = this.f5080t;
            if (typeface3 == null) {
                typeface3 = this.f5081u;
            }
            this.f5079s = typeface3;
            Typeface typeface4 = this.f5083w;
            if (typeface4 == null) {
                typeface4 = this.f5084x;
            }
            this.f5082v = typeface4;
            j(true);
        }
    }

    public final void j(boolean z) {
        float fMeasureText;
        TextInputLayout textInputLayout = this.f5054a;
        if ((textInputLayout.getHeight() <= 0 || textInputLayout.getWidth() <= 0) && !z) {
            return;
        }
        d(1.0f, z);
        CharSequence charSequence = this.C;
        TextPaint textPaint = this.O;
        if (charSequence != null && this.Z != null) {
            this.f5059d0 = o() ? TextUtils.ellipsize(this.C, textPaint, this.Z.getWidth(), this.A) : this.C;
        }
        CharSequence charSequence2 = this.f5059d0;
        if (charSequence2 != null) {
            this.f5055a0 = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.f5055a0 = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f5064g, this.D ? 1 : 0);
        int i10 = absoluteGravity & 112;
        Rect rect = this.f5058d;
        if (i10 == 48) {
            this.f5075n = rect.top;
        } else if (i10 != 80) {
            this.f5075n = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.f5075n = textPaint.ascent() + rect.bottom;
        }
        int i11 = absoluteGravity & 8388615;
        if (i11 == 1) {
            this.f5077p = rect.centerX() - (this.f5055a0 / 2.0f);
        } else if (i11 != 5) {
            this.f5077p = rect.left;
        } else {
            this.f5077p = rect.right - this.f5055a0;
        }
        if (this.f5055a0 <= rect.width()) {
            float f8 = this.f5077p;
            float fMax = Math.max(0.0f, rect.left - f8) + f8;
            this.f5077p = fMax;
            this.f5077p = Math.min(0.0f, rect.right - (this.f5055a0 + fMax)) + fMax;
        }
        float f9 = this.f5067i;
        TextPaint textPaint2 = this.P;
        textPaint2.setTextSize(f9);
        textPaint2.setTypeface(this.f5079s);
        textPaint2.setLetterSpacing(this.W);
        if (textPaint2.descent() + (-textPaint2.ascent()) <= rect.height()) {
            float f10 = this.f5075n;
            float fMax2 = Math.max(0.0f, rect.top - f10) + f10;
            this.f5075n = fMax2;
            this.f5075n = Math.min(0.0f, rect.bottom - (f() + fMax2)) + fMax2;
        }
        d(0.0f, z);
        float height = this.Z != null ? r15.getHeight() : 0.0f;
        StaticLayout staticLayout = this.Z;
        if (staticLayout == null || this.f5061e0 <= 1) {
            CharSequence charSequence3 = this.C;
            fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            fMeasureText = staticLayout.getWidth();
        }
        StaticLayout staticLayout2 = this.Z;
        this.f5073l = staticLayout2 != null ? staticLayout2.getLineCount() : 0;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f5062f, this.D ? 1 : 0);
        int i12 = absoluteGravity2 & 112;
        Rect rect2 = this.f5057c;
        if (i12 == 48) {
            this.f5074m = rect2.top;
        } else if (i12 != 80) {
            this.f5074m = rect2.centerY() - (height / 2.0f);
        } else {
            this.f5074m = (rect2.bottom - height) + (this.f5072k0 ? textPaint.descent() : 0.0f);
        }
        int i13 = absoluteGravity2 & 8388615;
        if (i13 == 1) {
            this.f5076o = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i13 != 5) {
            this.f5076o = rect2.left;
        } else {
            this.f5076o = rect2.right - fMeasureText;
        }
        d(this.f5056b, false);
        textInputLayout.postInvalidateOnAnimation();
        b();
    }

    public final void k(ColorStateList colorStateList) {
        if (this.f5071k == colorStateList && this.f5069j == colorStateList) {
            return;
        }
        this.f5071k = colorStateList;
        this.f5069j = colorStateList;
        j(false);
    }

    public final boolean l(Typeface typeface) {
        w4.a aVar = this.z;
        if (aVar != null) {
            aVar.f13580d = true;
        }
        if (this.f5081u == typeface) {
            return false;
        }
        this.f5081u = typeface;
        Typeface typefaceA = w4.f.a(this.f5054a.getContext().getResources().getConfiguration(), typeface);
        this.f5080t = typefaceA;
        if (typefaceA == null) {
            typefaceA = this.f5081u;
        }
        this.f5079s = typefaceA;
        return true;
    }

    public final void m(float f8) {
        float fO = y.o(f8, 0.0f, 1.0f);
        if (fO != this.f5056b) {
            this.f5056b = fO;
            b();
        }
    }

    public final void n(Typeface typeface) {
        boolean z;
        boolean zL = l(typeface);
        if (this.f5084x != typeface) {
            this.f5084x = typeface;
            Typeface typefaceA = w4.f.a(this.f5054a.getContext().getResources().getConfiguration(), typeface);
            this.f5083w = typefaceA;
            if (typefaceA == null) {
                typefaceA = this.f5084x;
            }
            this.f5082v = typefaceA;
            z = true;
        } else {
            z = false;
        }
        if (zL || z) {
            j(false);
        }
    }

    public final boolean o() {
        return this.f5063f0 == 1;
    }
}

package p1;

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
import com.google.android.material.textfield.TextInputLayout;
import k4.v;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
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
    public final TextInputLayout f4663a;

    /* renamed from: a0, reason: collision with root package name */
    public float f4664a0;

    /* renamed from: b, reason: collision with root package name */
    public float f4665b;

    /* renamed from: b0, reason: collision with root package name */
    public float f4666b0;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f4667c;

    /* renamed from: c0, reason: collision with root package name */
    public float f4668c0;
    public final Rect d;

    /* renamed from: d0, reason: collision with root package name */
    public CharSequence f4669d0;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f4670e;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f4680j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f4682k;
    public boolean k0;

    /* renamed from: l, reason: collision with root package name */
    public int f4683l;

    /* renamed from: m, reason: collision with root package name */
    public float f4684m;

    /* renamed from: n, reason: collision with root package name */
    public float f4685n;

    /* renamed from: o, reason: collision with root package name */
    public float f4686o;

    /* renamed from: p, reason: collision with root package name */
    public float f4687p;

    /* renamed from: q, reason: collision with root package name */
    public float f4688q;

    /* renamed from: r, reason: collision with root package name */
    public float f4689r;

    /* renamed from: s, reason: collision with root package name */
    public Typeface f4690s;

    /* renamed from: t, reason: collision with root package name */
    public Typeface f4691t;

    /* renamed from: u, reason: collision with root package name */
    public Typeface f4692u;

    /* renamed from: v, reason: collision with root package name */
    public Typeface f4693v;

    /* renamed from: w, reason: collision with root package name */
    public Typeface f4694w;

    /* renamed from: x, reason: collision with root package name */
    public Typeface f4695x;
    public Typeface y;
    public r1.a z;

    /* renamed from: f, reason: collision with root package name */
    public int f4672f = 16;

    /* renamed from: g, reason: collision with root package name */
    public int f4674g = 16;

    /* renamed from: h, reason: collision with root package name */
    public float f4676h = 15.0f;

    /* renamed from: i, reason: collision with root package name */
    public float f4678i = 15.0f;
    public final TextUtils.TruncateAt A = TextUtils.TruncateAt.END;
    public final boolean E = true;

    /* renamed from: e0, reason: collision with root package name */
    public int f4671e0 = 1;

    /* renamed from: f0, reason: collision with root package name */
    public int f4673f0 = 1;

    /* renamed from: g0, reason: collision with root package name */
    public final float f4675g0 = 1.0f;

    /* renamed from: h0, reason: collision with root package name */
    public final int f4677h0 = 1;

    /* renamed from: i0, reason: collision with root package name */
    public int f4679i0 = -1;

    /* renamed from: j0, reason: collision with root package name */
    public int f4681j0 = -1;

    public b(TextInputLayout textInputLayout) {
        this.f4663a = textInputLayout;
        TextPaint textPaint = new TextPaint(129);
        this.O = textPaint;
        this.P = new TextPaint(textPaint);
        this.d = new Rect();
        this.f4667c = new Rect();
        this.f4670e = new RectF();
        i(textInputLayout.getContext().getResources().getConfiguration());
    }

    public static int a(int i8, int i9, float f3) {
        float f7 = 1.0f - f3;
        return Color.argb(Math.round((Color.alpha(i9) * f3) + (Color.alpha(i8) * f7)), Math.round((Color.red(i9) * f3) + (Color.red(i8) * f7)), Math.round((Color.green(i9) * f3) + (Color.green(i8) * f7)), Math.round((Color.blue(i9) * f3) + (Color.blue(i8) * f7)));
    }

    public static float h(float f3, float f7, float f9, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f9 = timeInterpolator.getInterpolation(f9);
        }
        return e1.a.a(f3, f7, f9);
    }

    public final void b() {
        float f3 = this.f4665b;
        float f7 = this.f4667c.left;
        Rect rect = this.d;
        float fH = h(f7, rect.left, f3, this.Q);
        RectF rectF = this.f4670e;
        rectF.left = fH;
        rectF.top = h(this.f4684m, this.f4685n, f3, this.Q);
        rectF.right = h(r1.right, rect.right, f3, this.Q);
        rectF.bottom = h(r1.bottom, rect.bottom, f3, this.Q);
        this.f4688q = h(this.f4686o, this.f4687p, f3, this.Q);
        this.f4689r = h(this.f4684m, this.f4685n, f3, this.Q);
        d(f3, false);
        TextInputLayout textInputLayout = this.f4663a;
        textInputLayout.postInvalidateOnAnimation();
        r0.a aVar = e1.a.f2340b;
        this.f4666b0 = 1.0f - h(0.0f, 1.0f, 1.0f - f3, aVar);
        textInputLayout.postInvalidateOnAnimation();
        this.f4668c0 = h(1.0f, 0.0f, f3, aVar);
        textInputLayout.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.f4682k;
        ColorStateList colorStateList2 = this.f4680j;
        TextPaint textPaint = this.O;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(g(colorStateList2), g(this.f4682k), f3));
        } else {
            textPaint.setColor(g(colorStateList));
        }
        float f9 = this.W;
        float f10 = this.X;
        if (f9 != f10) {
            textPaint.setLetterSpacing(h(f10, f9, f3, aVar));
        } else {
            textPaint.setLetterSpacing(f9);
        }
        this.H = e1.a.a(0.0f, this.S, f3);
        this.I = e1.a.a(0.0f, this.T, f3);
        this.J = e1.a.a(0.0f, this.U, f3);
        int iA = a(0, g(this.V), f3);
        this.K = iA;
        textPaint.setShadowLayer(this.H, this.I, this.J, iA);
        textInputLayout.postInvalidateOnAnimation();
    }

    public final boolean c(CharSequence charSequence) {
        boolean z = this.f4663a.getLayoutDirection() == 1;
        if (this.E) {
            return (z ? c0.g.d : c0.g.f1050c).b(charSequence, charSequence.length());
        }
        return z;
    }

    public final void d(float f3, boolean z) {
        float f7;
        Typeface typeface;
        float f9;
        if (this.B == null) {
            return;
        }
        float fWidth = this.d.width();
        float fWidth2 = this.f4667c.width();
        if (Math.abs(f3 - 1.0f) < 1.0E-5f) {
            f7 = o() ? this.f4678i : this.f4676h;
            f9 = o() ? this.W : this.X;
            this.F = o() ? 1.0f : h(this.f4676h, this.f4678i, f3, this.R) / this.f4676h;
            if (!o()) {
                fWidth = fWidth2;
            }
            typeface = this.f4690s;
            fWidth2 = fWidth;
        } else {
            f7 = this.f4676h;
            float f10 = this.X;
            typeface = this.f4693v;
            if (Math.abs(f3 - 0.0f) < 1.0E-5f) {
                this.F = 1.0f;
            } else {
                this.F = h(this.f4676h, this.f4678i, f3, this.R) / this.f4676h;
            }
            float f11 = this.f4678i / this.f4676h;
            float f12 = fWidth2 * f11;
            if (!z && f12 > fWidth && o()) {
                fWidth2 = Math.min(fWidth / f11, fWidth2);
            }
            f9 = f10;
        }
        int i8 = f3 < 0.5f ? this.f4671e0 : this.f4673f0;
        TextPaint textPaint = this.O;
        if (fWidth2 > 0.0f) {
            boolean z2 = this.G != f7;
            boolean z8 = this.Y != f9;
            boolean z9 = this.y != typeface;
            StaticLayout staticLayout = this.Z;
            boolean z10 = z2 || z8 || (staticLayout != null && (fWidth2 > ((float) staticLayout.getWidth()) ? 1 : (fWidth2 == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z9 || (this.L != i8) || this.N;
            this.G = f7;
            this.Y = f9;
            this.y = typeface;
            this.N = false;
            this.L = i8;
            textPaint.setLinearText(this.F != 1.0f);
            z = z10;
        }
        if (this.C == null || z) {
            textPaint.setTextSize(this.G);
            textPaint.setTypeface(this.y);
            textPaint.setLetterSpacing(this.Y);
            boolean zC = c(this.B);
            this.D = zC;
            StaticLayout staticLayoutE = e(((this.f4671e0 > 1 || this.f4673f0 > 1) && !zC) ? i8 : 1, textPaint, this.B, fWidth2 * (o() ? 1.0f : this.F), this.D);
            this.Z = staticLayoutE;
            this.C = staticLayoutE.getText();
        }
    }

    public final StaticLayout e(int i8, TextPaint textPaint, CharSequence charSequence, float f3, boolean z) {
        Layout.Alignment alignment;
        if (i8 == 1) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(this.f4672f, this.D ? 1 : 0) & 7;
            alignment = absoluteGravity != 1 ? absoluteGravity != 5 ? this.D ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.D ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
        }
        g gVar = new g(charSequence, textPaint, (int) f3);
        gVar.f4714l = this.A;
        gVar.f4713k = z;
        gVar.f4707e = alignment;
        gVar.f4712j = false;
        gVar.f4708f = i8;
        float f7 = this.f4675g0;
        gVar.f4709g = 0.0f;
        gVar.f4710h = f7;
        gVar.f4711i = this.f4677h0;
        gVar.f4715m = null;
        StaticLayout staticLayoutA = gVar.a();
        staticLayoutA.getClass();
        return staticLayoutA;
    }

    public final float f() {
        int i8 = this.f4679i0;
        if (i8 != -1) {
            return i8;
        }
        float f3 = this.f4678i;
        TextPaint textPaint = this.P;
        textPaint.setTextSize(f3);
        textPaint.setTypeface(this.f4690s);
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
        Typeface typeface = this.f4692u;
        if (typeface != null) {
            this.f4691t = v.b0(configuration, typeface);
        }
        Typeface typeface2 = this.f4695x;
        if (typeface2 != null) {
            this.f4694w = v.b0(configuration, typeface2);
        }
        Typeface typeface3 = this.f4691t;
        if (typeface3 == null) {
            typeface3 = this.f4692u;
        }
        this.f4690s = typeface3;
        Typeface typeface4 = this.f4694w;
        if (typeface4 == null) {
            typeface4 = this.f4695x;
        }
        this.f4693v = typeface4;
        j(true);
    }

    public final void j(boolean z) {
        float fMeasureText;
        TextInputLayout textInputLayout = this.f4663a;
        if ((textInputLayout.getHeight() <= 0 || textInputLayout.getWidth() <= 0) && !z) {
            return;
        }
        d(1.0f, z);
        CharSequence charSequence = this.C;
        TextPaint textPaint = this.O;
        if (charSequence != null && this.Z != null) {
            this.f4669d0 = o() ? TextUtils.ellipsize(this.C, textPaint, this.Z.getWidth(), this.A) : this.C;
        }
        CharSequence charSequence2 = this.f4669d0;
        if (charSequence2 != null) {
            this.f4664a0 = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.f4664a0 = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f4674g, this.D ? 1 : 0);
        int i8 = absoluteGravity & 112;
        Rect rect = this.d;
        if (i8 == 48) {
            this.f4685n = rect.top;
        } else if (i8 != 80) {
            this.f4685n = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.f4685n = textPaint.ascent() + rect.bottom;
        }
        int i9 = absoluteGravity & 8388615;
        if (i9 == 1) {
            this.f4687p = rect.centerX() - (this.f4664a0 / 2.0f);
        } else if (i9 != 5) {
            this.f4687p = rect.left;
        } else {
            this.f4687p = rect.right - this.f4664a0;
        }
        if (this.f4664a0 <= rect.width()) {
            float f3 = this.f4687p;
            float fMax = Math.max(0.0f, rect.left - f3) + f3;
            this.f4687p = fMax;
            this.f4687p = Math.min(0.0f, rect.right - (this.f4664a0 + fMax)) + fMax;
        }
        float f7 = this.f4678i;
        TextPaint textPaint2 = this.P;
        textPaint2.setTextSize(f7);
        textPaint2.setTypeface(this.f4690s);
        textPaint2.setLetterSpacing(this.W);
        if (textPaint2.descent() + (-textPaint2.ascent()) <= rect.height()) {
            float f9 = this.f4685n;
            float fMax2 = Math.max(0.0f, rect.top - f9) + f9;
            this.f4685n = fMax2;
            this.f4685n = Math.min(0.0f, rect.bottom - (f() + fMax2)) + fMax2;
        }
        d(0.0f, z);
        float height = this.Z != null ? r15.getHeight() : 0.0f;
        StaticLayout staticLayout = this.Z;
        if (staticLayout == null || this.f4671e0 <= 1) {
            CharSequence charSequence3 = this.C;
            fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            fMeasureText = staticLayout.getWidth();
        }
        StaticLayout staticLayout2 = this.Z;
        this.f4683l = staticLayout2 != null ? staticLayout2.getLineCount() : 0;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f4672f, this.D ? 1 : 0);
        int i10 = absoluteGravity2 & 112;
        Rect rect2 = this.f4667c;
        if (i10 == 48) {
            this.f4684m = rect2.top;
        } else if (i10 != 80) {
            this.f4684m = rect2.centerY() - (height / 2.0f);
        } else {
            this.f4684m = (rect2.bottom - height) + (this.k0 ? textPaint.descent() : 0.0f);
        }
        int i11 = absoluteGravity2 & 8388615;
        if (i11 == 1) {
            this.f4686o = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i11 != 5) {
            this.f4686o = rect2.left;
        } else {
            this.f4686o = rect2.right - fMeasureText;
        }
        d(this.f4665b, false);
        textInputLayout.postInvalidateOnAnimation();
        b();
    }

    public final void k(ColorStateList colorStateList) {
        if (this.f4682k == colorStateList && this.f4680j == colorStateList) {
            return;
        }
        this.f4682k = colorStateList;
        this.f4680j = colorStateList;
        j(false);
    }

    public final boolean l(Typeface typeface) {
        r1.a aVar = this.z;
        if (aVar != null) {
            aVar.d = true;
        }
        if (this.f4692u == typeface) {
            return false;
        }
        this.f4692u = typeface;
        Typeface typefaceB0 = v.b0(this.f4663a.getContext().getResources().getConfiguration(), typeface);
        this.f4691t = typefaceB0;
        if (typefaceB0 == null) {
            typefaceB0 = this.f4692u;
        }
        this.f4690s = typefaceB0;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0005 A[PHI: r0
      0x0005: PHI (r0v4 float) = (r0v0 float), (r0v1 float) binds: [B:3:0x0003, B:6:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(float r3) {
        /*
            r2 = this;
            r0 = 0
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 >= 0) goto L7
        L5:
            r3 = r0
            goto Le
        L7:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto Le
            goto L5
        Le:
            float r0 = r2.f4665b
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 == 0) goto L19
            r2.f4665b = r3
            r2.b()
        L19:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.b.m(float):void");
    }

    public final void n(Typeface typeface) {
        boolean z;
        boolean zL = l(typeface);
        if (this.f4695x != typeface) {
            this.f4695x = typeface;
            Typeface typefaceB0 = v.b0(this.f4663a.getContext().getResources().getConfiguration(), typeface);
            this.f4694w = typefaceB0;
            if (typefaceB0 == null) {
                typefaceB0 = this.f4695x;
            }
            this.f4693v = typefaceB0;
            z = true;
        } else {
            z = false;
        }
        if (zL || z) {
            j(false);
        }
    }

    public final boolean o() {
        return this.f4673f0 == 1;
    }
}

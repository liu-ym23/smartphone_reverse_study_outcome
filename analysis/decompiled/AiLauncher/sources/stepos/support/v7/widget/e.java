package stepos.support.v7.widget;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.U;
import androidx.core.view.C1321i;
import androidx.core.view.N;
import w0.C5715a;

/* loaded from: classes5.dex */
public final class e implements n {

    /* renamed from: W, reason: collision with root package name */
    public static final boolean f41542W = false;

    /* renamed from: X, reason: collision with root package name */
    public static final Paint f41543X = null;

    /* renamed from: A, reason: collision with root package name */
    public Paint f41544A;

    /* renamed from: B, reason: collision with root package name */
    public float f41545B;

    /* renamed from: C, reason: collision with root package name */
    public float f41546C;

    /* renamed from: D, reason: collision with root package name */
    public float f41547D;

    /* renamed from: E, reason: collision with root package name */
    public float f41548E;

    /* renamed from: F, reason: collision with root package name */
    public int[] f41549F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f41550G;

    /* renamed from: I, reason: collision with root package name */
    public Interpolator f41552I;

    /* renamed from: J, reason: collision with root package name */
    public Interpolator f41553J;

    /* renamed from: K, reason: collision with root package name */
    public float f41554K;

    /* renamed from: L, reason: collision with root package name */
    public float f41555L;

    /* renamed from: M, reason: collision with root package name */
    public float f41556M;

    /* renamed from: N, reason: collision with root package name */
    public int f41557N;

    /* renamed from: O, reason: collision with root package name */
    public float f41558O;

    /* renamed from: P, reason: collision with root package name */
    public float f41559P;

    /* renamed from: Q, reason: collision with root package name */
    public float f41560Q;

    /* renamed from: R, reason: collision with root package name */
    public int f41561R;

    /* renamed from: S, reason: collision with root package name */
    public float f41562S;

    /* renamed from: U, reason: collision with root package name */
    public float f41564U;

    /* renamed from: a, reason: collision with root package name */
    public final View f41566a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f41567b;

    /* renamed from: c, reason: collision with root package name */
    public float f41568c;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f41576k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f41577l;

    /* renamed from: m, reason: collision with root package name */
    public float f41578m;

    /* renamed from: n, reason: collision with root package name */
    public float f41579n;

    /* renamed from: o, reason: collision with root package name */
    public float f41580o;

    /* renamed from: p, reason: collision with root package name */
    public float f41581p;

    /* renamed from: q, reason: collision with root package name */
    public float f41582q;

    /* renamed from: r, reason: collision with root package name */
    public float f41583r;

    /* renamed from: s, reason: collision with root package name */
    public Typeface f41584s;

    /* renamed from: t, reason: collision with root package name */
    public Typeface f41585t;

    /* renamed from: u, reason: collision with root package name */
    public Typeface f41586u;

    /* renamed from: v, reason: collision with root package name */
    public CharSequence f41587v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f41588w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f41589x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f41590y;

    /* renamed from: z, reason: collision with root package name */
    public Bitmap f41591z;

    /* renamed from: g, reason: collision with root package name */
    public int f41572g = 16;

    /* renamed from: h, reason: collision with root package name */
    public int f41573h = 16;

    /* renamed from: i, reason: collision with root package name */
    public float f41574i = 15.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f41575j = 15.0f;

    /* renamed from: T, reason: collision with root package name */
    public float f41563T = 0.0f;

    /* renamed from: V, reason: collision with root package name */
    public boolean f41565V = false;

    /* renamed from: H, reason: collision with root package name */
    public final TextPaint f41551H = new TextPaint(129);

    /* renamed from: e, reason: collision with root package name */
    public final Rect f41570e = new Rect();

    /* renamed from: d, reason: collision with root package name */
    public final Rect f41569d = new Rect();

    /* renamed from: f, reason: collision with root package name */
    public final RectF f41571f = new RectF();

    public e(View view) {
        this.f41566a = view;
    }

    public static boolean A(Rect rect, int i10, int i11, int i12, int i13) {
        return rect.left == i10 && rect.top == i11 && rect.right == i12 && rect.bottom == i13;
    }

    public static int d(int i10, int i11, float f10) {
        float f11 = 1.0f - f10;
        return Color.argb((int) ((Color.alpha(i10) * f11) + (Color.alpha(i11) * f10)), (int) ((Color.red(i10) * f11) + (Color.red(i11) * f10)), (int) ((Color.green(i10) * f11) + (Color.green(i11) * f10)), (int) ((Color.blue(i10) * f11) + (Color.blue(i11) * f10)));
    }

    public static boolean u(float f10, float f11) {
        return Math.abs(f10 - f11) < 0.001f;
    }

    public static float w(float f10, float f11, float f12, Interpolator interpolator) {
        if (interpolator != null) {
            f12 = interpolator.getInterpolation(f12);
        }
        return d.a(f10, f11, f12);
    }

    public void B(int i10, int i11, int i12, int i13) {
        if (A(this.f41570e, i10, i11, i12, i13)) {
            return;
        }
        this.f41570e.set(i10, i11, i12, i13);
        this.f41550G = true;
        x();
    }

    public void C(int i10) {
        U uT = U.t(this.f41566a.getContext(), i10, R$styleable.TextAppearance);
        int i11 = R$styleable.TextAppearance_android_textColor;
        if (uT.s(i11)) {
            this.f41577l = uT.c(i11);
        }
        if (uT.s(R$styleable.TextAppearance_android_textSize)) {
            this.f41575j = uT.f(r1, (int) this.f41575j);
        }
        this.f41557N = uT.k(R$styleable.TextAppearance_android_shadowColor, 0);
        this.f41555L = uT.i(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f41556M = uT.i(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f41554K = uT.i(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        uT.x();
        this.f41584s = y(i10);
        z();
    }

    public void D(ColorStateList colorStateList) {
        if (this.f41577l != colorStateList) {
            this.f41577l = colorStateList;
            z();
        }
    }

    public void E(int i10) {
        if (this.f41573h != i10) {
            this.f41573h = i10;
            z();
        }
    }

    public void F(Typeface typeface) {
        if (b(this.f41584s, typeface)) {
            this.f41584s = typeface;
            z();
        }
    }

    public void G(int i10, int i11, int i12, int i13) {
        if (A(this.f41569d, i10, i11, i12, i13)) {
            return;
        }
        this.f41569d.set(i10, i11, i12, i13);
        this.f41550G = true;
        x();
    }

    public void H(int i10) {
        U uT = U.t(this.f41566a.getContext(), i10, R$styleable.TextAppearance);
        int i11 = R$styleable.TextAppearance_android_textColor;
        if (uT.s(i11)) {
            this.f41576k = uT.c(i11);
        }
        if (uT.s(R$styleable.TextAppearance_android_textSize)) {
            this.f41574i = uT.f(r1, (int) this.f41574i);
        }
        this.f41561R = uT.k(R$styleable.TextAppearance_android_shadowColor, 0);
        this.f41559P = uT.i(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f41560Q = uT.i(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f41558O = uT.i(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        uT.x();
        this.f41585t = y(i10);
        z();
    }

    public void I(ColorStateList colorStateList) {
        if (this.f41576k != colorStateList) {
            this.f41576k = colorStateList;
            z();
        }
    }

    public void J(int i10) {
        if (this.f41572g != i10) {
            this.f41572g = i10;
            z();
        }
    }

    public void K(Typeface typeface) {
        if (b(this.f41585t, typeface)) {
            this.f41585t = typeface;
            z();
        }
    }

    public void L(float f10) {
        float fA = C5715a.a(f10, 0.0f, 1.0f);
        if (fA != this.f41568c) {
            this.f41568c = fA;
            f();
        }
    }

    public final void M(float f10) {
        i(f10);
        boolean z10 = f41542W && this.f41547D != 1.0f;
        this.f41590y = z10;
        if (z10) {
            l();
        }
        N.Y(this.f41566a);
    }

    public final boolean N(int[] iArr) {
        this.f41549F = iArr;
        if (!v()) {
            return false;
        }
        z();
        return true;
    }

    public void O(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f41587v)) {
            this.f41587v = charSequence;
            this.f41588w = null;
            j();
            z();
        }
    }

    public void P(float f10) {
        int i10 = (int) (f10 * 255.0f);
        this.f41562S = i10;
        this.f41551H.setAlpha(i10);
    }

    public void Q(Interpolator interpolator) {
        this.f41553J = interpolator;
        z();
    }

    @Override // stepos.support.v7.widget.n
    public void a(float f10) {
        this.f41564U = f10;
    }

    public final boolean b(Typeface typeface, Typeface typeface2) {
        if (typeface == null || typeface.equals(typeface2)) {
            return typeface == null && typeface2 != null;
        }
        return true;
    }

    @Override // stepos.support.v7.widget.n
    public void c() {
        this.f41565V = false;
        if (u(this.f41568c, 1.0f)) {
            this.f41547D = 1.0f;
            this.f41548E = this.f41575j;
        } else if (u(this.f41568c, 0.0f)) {
            this.f41547D = 1.0f;
            this.f41548E = this.f41574i;
        }
        this.f41551H.setTextSize(this.f41548E);
        Log.i("[Collapsing]", "releaseTitleScale after mScale:" + this.f41547D + ",mCurrentTextSize:" + this.f41548E + ",mExpandedFraction:" + this.f41568c + ",paint text size:" + this.f41551H.getTextSize());
    }

    public final void e() {
        float f10 = this.f41548E;
        i(this.f41575j);
        CharSequence charSequence = this.f41588w;
        float fMeasureText = charSequence != null ? this.f41551H.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int iB = C1321i.b(this.f41573h, this.f41589x ? 1 : 0);
        int i10 = iB & 112;
        if (i10 == 48) {
            this.f41579n = this.f41570e.top - this.f41551H.ascent();
        } else if (i10 != 80) {
            this.f41579n = this.f41570e.centerY() + (((this.f41551H.descent() - this.f41551H.ascent()) / 2.0f) - this.f41551H.descent());
        } else {
            this.f41579n = this.f41570e.bottom;
        }
        int i11 = iB & 8388615;
        if (i11 == 1) {
            this.f41581p = this.f41570e.centerX() - (fMeasureText / 2.0f);
        } else if (i11 != 5) {
            this.f41581p = this.f41570e.left;
        } else {
            this.f41581p = this.f41570e.right - fMeasureText;
        }
        i(this.f41574i);
        CharSequence charSequence2 = this.f41588w;
        float fMeasureText2 = charSequence2 != null ? this.f41551H.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int iB2 = C1321i.b(this.f41572g, this.f41589x ? 1 : 0);
        int i12 = iB2 & 112;
        if (i12 == 48) {
            this.f41578m = this.f41569d.top - this.f41551H.ascent();
        } else if (i12 != 80) {
            this.f41578m = this.f41569d.centerY() + (((this.f41551H.descent() - this.f41551H.ascent()) / 2.0f) - this.f41551H.descent());
        } else {
            this.f41578m = this.f41569d.bottom;
        }
        int i13 = iB2 & 8388615;
        if (i13 == 1) {
            this.f41580o = this.f41569d.centerX() - (fMeasureText2 / 2.0f);
        } else if (i13 != 5) {
            this.f41580o = this.f41569d.left;
        } else {
            this.f41580o = this.f41569d.right - fMeasureText2;
        }
        j();
        M(f10);
    }

    public final void f() {
        h(this.f41568c);
    }

    public final boolean g(CharSequence charSequence) {
        return (N.u(this.f41566a) == 1 ? z0.e.f44554d : z0.e.f44553c).isRtl(charSequence, 0, charSequence.length());
    }

    public final void h(float f10) {
        t(f10);
        this.f41582q = w(this.f41580o, this.f41581p, f10, this.f41552I);
        this.f41583r = w(this.f41578m, this.f41579n, f10, this.f41552I);
        M(w(this.f41574i, this.f41575j, f10, this.f41553J));
        if (this.f41577l != this.f41576k) {
            this.f41551H.setColor(d(p(), o(), f10));
        } else {
            this.f41551H.setColor(o());
        }
        this.f41551H.setShadowLayer(w(this.f41558O, this.f41554K, f10, null), w(this.f41559P, this.f41555L, f10, null), w(this.f41560Q, this.f41556M, f10, null), d(this.f41561R, this.f41557N, f10));
        N.Y(this.f41566a);
    }

    public final void i(float f10) {
        boolean z10;
        float f11;
        boolean z11;
        if (this.f41587v == null || this.f41565V) {
            return;
        }
        float fWidth = this.f41570e.width();
        float fWidth2 = this.f41569d.width();
        if (u(f10, this.f41575j)) {
            f11 = this.f41575j;
            this.f41547D = 1.0f;
            if (b(this.f41586u, this.f41584s)) {
                this.f41586u = this.f41584s;
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            float f12 = this.f41574i;
            if (b(this.f41586u, this.f41585t)) {
                this.f41586u = this.f41585t;
                z10 = true;
            } else {
                z10 = false;
            }
            if (u(f10, this.f41574i)) {
                this.f41547D = 1.0f;
            } else {
                this.f41547D = f10 / this.f41574i;
            }
            float f13 = this.f41575j / this.f41574i;
            fWidth = fWidth2 * f13 > fWidth ? Math.min(fWidth / f13, fWidth2) : fWidth2;
            f11 = f12;
            z11 = z10;
        }
        if (fWidth > 0.0f) {
            z11 = this.f41548E != f11 || this.f41550G || z11;
            this.f41548E = f11;
            this.f41550G = false;
        }
        if (this.f41588w == null || z11) {
            this.f41551H.setTextSize(this.f41548E);
            this.f41551H.setTypeface(this.f41586u);
            this.f41551H.setLinearText(this.f41547D != 1.0f);
            CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.f41587v, this.f41551H, fWidth, TextUtils.TruncateAt.END);
            if (TextUtils.equals(charSequenceEllipsize, this.f41588w)) {
                return;
            }
            this.f41588w = charSequenceEllipsize;
            this.f41589x = g(charSequenceEllipsize);
        }
    }

    public final void j() {
        Bitmap bitmap = this.f41591z;
        if (bitmap != null) {
            bitmap.recycle();
            this.f41591z = null;
        }
    }

    public void k(Canvas canvas) {
        Canvas canvas2;
        float fAscent;
        int iSave = canvas.save();
        if (this.f41588w == null || !this.f41567b) {
            canvas2 = canvas;
        } else {
            float f10 = this.f41582q;
            float f11 = this.f41583r + this.f41563T;
            if (u(this.f41568c, 0.0f)) {
                f11 += this.f41564U;
            }
            boolean z10 = this.f41590y && this.f41591z != null;
            if (z10) {
                fAscent = this.f41545B * this.f41547D;
            } else {
                fAscent = this.f41551H.ascent() * this.f41547D;
                this.f41551H.descent();
            }
            if (z10) {
                f11 += fAscent;
            }
            float f12 = f11;
            float f13 = this.f41547D;
            if (f13 != 1.0f) {
                canvas.scale(f13, f13, f10, f12);
            }
            if (z10) {
                canvas.drawBitmap(this.f41591z, f10, f12, this.f41544A);
                canvas2 = canvas;
            } else {
                CharSequence charSequence = this.f41588w;
                canvas2 = canvas;
                canvas2.drawText(charSequence, 0, charSequence.length(), f10, f12, this.f41551H);
            }
        }
        canvas2.restoreToCount(iSave);
    }

    public final void l() {
        if (this.f41591z != null || this.f41569d.isEmpty() || TextUtils.isEmpty(this.f41588w)) {
            return;
        }
        h(0.0f);
        this.f41545B = this.f41551H.ascent();
        this.f41546C = this.f41551H.descent();
        TextPaint textPaint = this.f41551H;
        CharSequence charSequence = this.f41588w;
        int iRound = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
        int iRound2 = Math.round(this.f41546C - this.f41545B);
        if (iRound <= 0 || iRound2 <= 0) {
            return;
        }
        this.f41591z = Bitmap.createBitmap(iRound, iRound2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f41591z);
        CharSequence charSequence2 = this.f41588w;
        canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, iRound2 - this.f41551H.descent(), this.f41551H);
        if (this.f41544A == null) {
            this.f41544A = new Paint(3);
        }
    }

    public int m() {
        return this.f41573h;
    }

    public Typeface n() {
        Typeface typeface = this.f41584s;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public final int o() {
        int[] iArr = this.f41549F;
        return iArr != null ? this.f41577l.getColorForState(iArr, 0) : this.f41577l.getDefaultColor();
    }

    public final int p() {
        int[] iArr = this.f41549F;
        return iArr != null ? this.f41576k.getColorForState(iArr, 0) : this.f41576k.getDefaultColor();
    }

    public int q() {
        return this.f41572g;
    }

    public Typeface r() {
        Typeface typeface = this.f41585t;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public CharSequence s() {
        return this.f41587v;
    }

    public final void t(float f10) {
        this.f41571f.left = w(this.f41569d.left, this.f41570e.left, f10, this.f41552I);
        this.f41571f.top = w(this.f41578m, this.f41579n, f10, this.f41552I);
        this.f41571f.right = w(this.f41569d.right, this.f41570e.right, f10, this.f41552I);
        this.f41571f.bottom = w(this.f41569d.bottom, this.f41570e.bottom, f10, this.f41552I);
    }

    public final boolean v() {
        ColorStateList colorStateList = this.f41577l;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f41576k;
        return colorStateList2 != null && colorStateList2.isStateful();
    }

    public void x() {
        this.f41567b = this.f41570e.width() > 0 && this.f41570e.height() > 0 && this.f41569d.width() > 0 && this.f41569d.height() > 0;
    }

    public final Typeface y(int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = this.f41566a.getContext().obtainStyledAttributes(i10, new int[]{R.attr.fontFamily});
        try {
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            typedArrayObtainStyledAttributes.recycle();
            return null;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void z() {
        if (this.f41566a.getHeight() <= 0 || this.f41566a.getWidth() <= 0) {
            return;
        }
        e();
        f();
    }
}

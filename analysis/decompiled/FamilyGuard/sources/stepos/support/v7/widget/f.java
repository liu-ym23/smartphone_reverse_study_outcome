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
import androidx.appcompat.widget.a0;
import androidx.core.view.C0464i;
import androidx.core.view.H;

/* loaded from: classes.dex */
public final class f implements p {

    /* renamed from: W, reason: collision with root package name */
    private static final boolean f21973W = false;

    /* renamed from: X, reason: collision with root package name */
    private static final Paint f21974X = null;

    /* renamed from: A, reason: collision with root package name */
    private Paint f21975A;

    /* renamed from: B, reason: collision with root package name */
    private float f21976B;

    /* renamed from: C, reason: collision with root package name */
    private float f21977C;

    /* renamed from: D, reason: collision with root package name */
    private float f21978D;

    /* renamed from: E, reason: collision with root package name */
    private float f21979E;

    /* renamed from: F, reason: collision with root package name */
    private int[] f21980F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f21981G;

    /* renamed from: I, reason: collision with root package name */
    private Interpolator f21983I;

    /* renamed from: J, reason: collision with root package name */
    private Interpolator f21984J;

    /* renamed from: K, reason: collision with root package name */
    private float f21985K;

    /* renamed from: L, reason: collision with root package name */
    private float f21986L;

    /* renamed from: M, reason: collision with root package name */
    private float f21987M;

    /* renamed from: N, reason: collision with root package name */
    private int f21988N;

    /* renamed from: O, reason: collision with root package name */
    private float f21989O;

    /* renamed from: P, reason: collision with root package name */
    private float f21990P;

    /* renamed from: Q, reason: collision with root package name */
    private float f21991Q;

    /* renamed from: R, reason: collision with root package name */
    private int f21992R;

    /* renamed from: S, reason: collision with root package name */
    private float f21993S;

    /* renamed from: U, reason: collision with root package name */
    private float f21995U;

    /* renamed from: a, reason: collision with root package name */
    private final View f21997a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f21998b;

    /* renamed from: c, reason: collision with root package name */
    private float f21999c;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f22007k;

    /* renamed from: l, reason: collision with root package name */
    private ColorStateList f22008l;

    /* renamed from: m, reason: collision with root package name */
    private float f22009m;

    /* renamed from: n, reason: collision with root package name */
    private float f22010n;

    /* renamed from: o, reason: collision with root package name */
    private float f22011o;

    /* renamed from: p, reason: collision with root package name */
    private float f22012p;

    /* renamed from: q, reason: collision with root package name */
    private float f22013q;

    /* renamed from: r, reason: collision with root package name */
    private float f22014r;

    /* renamed from: s, reason: collision with root package name */
    private Typeface f22015s;

    /* renamed from: t, reason: collision with root package name */
    private Typeface f22016t;

    /* renamed from: u, reason: collision with root package name */
    private Typeface f22017u;

    /* renamed from: v, reason: collision with root package name */
    private CharSequence f22018v;

    /* renamed from: w, reason: collision with root package name */
    private CharSequence f22019w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f22020x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f22021y;

    /* renamed from: z, reason: collision with root package name */
    private Bitmap f22022z;

    /* renamed from: g, reason: collision with root package name */
    private int f22003g = 16;

    /* renamed from: h, reason: collision with root package name */
    private int f22004h = 16;

    /* renamed from: i, reason: collision with root package name */
    private float f22005i = 15.0f;

    /* renamed from: j, reason: collision with root package name */
    private float f22006j = 15.0f;

    /* renamed from: T, reason: collision with root package name */
    private float f21994T = 0.0f;

    /* renamed from: V, reason: collision with root package name */
    private boolean f21996V = false;

    /* renamed from: H, reason: collision with root package name */
    private final TextPaint f21982H = new TextPaint(129);

    /* renamed from: e, reason: collision with root package name */
    private final Rect f22001e = new Rect();

    /* renamed from: d, reason: collision with root package name */
    private final Rect f22000d = new Rect();

    /* renamed from: f, reason: collision with root package name */
    private final RectF f22002f = new RectF();

    public f(View view) {
        this.f21997a = view;
    }

    private static boolean A(Rect rect, int i5, int i6, int i7, int i8) {
        return rect.left == i5 && rect.top == i6 && rect.right == i7 && rect.bottom == i8;
    }

    private void M(float f5) {
        i(f5);
        boolean z5 = f21973W && this.f21978D != 1.0f;
        this.f22021y = z5;
        if (z5) {
            l();
        }
        H.a0(this.f21997a);
    }

    private boolean c(Typeface typeface, Typeface typeface2) {
        if (typeface == null || typeface.equals(typeface2)) {
            return typeface == null && typeface2 != null;
        }
        return true;
    }

    private static int d(int i5, int i6, float f5) {
        float f6 = 1.0f - f5;
        return Color.argb((int) ((Color.alpha(i5) * f6) + (Color.alpha(i6) * f5)), (int) ((Color.red(i5) * f6) + (Color.red(i6) * f5)), (int) ((Color.green(i5) * f6) + (Color.green(i6) * f5)), (int) ((Color.blue(i5) * f6) + (Color.blue(i6) * f5)));
    }

    private void e() {
        float f5 = this.f21979E;
        i(this.f22006j);
        CharSequence charSequence = this.f22019w;
        float fMeasureText = charSequence != null ? this.f21982H.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int iB = C0464i.b(this.f22004h, this.f22020x ? 1 : 0);
        int i5 = iB & 112;
        if (i5 == 48) {
            this.f22010n = this.f22001e.top - this.f21982H.ascent();
        } else if (i5 != 80) {
            this.f22010n = this.f22001e.centerY() + (((this.f21982H.descent() - this.f21982H.ascent()) / 2.0f) - this.f21982H.descent());
        } else {
            this.f22010n = this.f22001e.bottom;
        }
        int i6 = iB & 8388615;
        if (i6 == 1) {
            this.f22012p = this.f22001e.centerX() - (fMeasureText / 2.0f);
        } else if (i6 != 5) {
            this.f22012p = this.f22001e.left;
        } else {
            this.f22012p = this.f22001e.right - fMeasureText;
        }
        i(this.f22005i);
        CharSequence charSequence2 = this.f22019w;
        float fMeasureText2 = charSequence2 != null ? this.f21982H.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int iB2 = C0464i.b(this.f22003g, this.f22020x ? 1 : 0);
        int i7 = iB2 & 112;
        if (i7 == 48) {
            this.f22009m = this.f22000d.top - this.f21982H.ascent();
        } else if (i7 != 80) {
            this.f22009m = this.f22000d.centerY() + (((this.f21982H.descent() - this.f21982H.ascent()) / 2.0f) - this.f21982H.descent());
        } else {
            this.f22009m = this.f22000d.bottom;
        }
        int i8 = iB2 & 8388615;
        if (i8 == 1) {
            this.f22011o = this.f22000d.centerX() - (fMeasureText2 / 2.0f);
        } else if (i8 != 5) {
            this.f22011o = this.f22000d.left;
        } else {
            this.f22011o = this.f22000d.right - fMeasureText2;
        }
        j();
        M(f5);
    }

    private void f() {
        h(this.f21999c);
    }

    private boolean g(CharSequence charSequence) {
        return (H.x(this.f21997a) == 1 ? androidx.core.text.f.f9704d : androidx.core.text.f.f9703c).isRtl(charSequence, 0, charSequence.length());
    }

    private void h(float f5) {
        t(f5);
        this.f22013q = w(this.f22011o, this.f22012p, f5, this.f21983I);
        this.f22014r = w(this.f22009m, this.f22010n, f5, this.f21983I);
        M(w(this.f22005i, this.f22006j, f5, this.f21984J));
        if (this.f22008l != this.f22007k) {
            this.f21982H.setColor(d(p(), o(), f5));
        } else {
            this.f21982H.setColor(o());
        }
        this.f21982H.setShadowLayer(w(this.f21989O, this.f21985K, f5, null), w(this.f21990P, this.f21986L, f5, null), w(this.f21991Q, this.f21987M, f5, null), d(this.f21992R, this.f21988N, f5));
        H.a0(this.f21997a);
    }

    private void i(float f5) {
        boolean z5;
        float f6;
        boolean z6;
        if (this.f22018v == null || this.f21996V) {
            return;
        }
        float fWidth = this.f22001e.width();
        float fWidth2 = this.f22000d.width();
        if (u(f5, this.f22006j)) {
            f6 = this.f22006j;
            this.f21978D = 1.0f;
            if (c(this.f22017u, this.f22015s)) {
                this.f22017u = this.f22015s;
                z6 = true;
            } else {
                z6 = false;
            }
        } else {
            float f7 = this.f22005i;
            if (c(this.f22017u, this.f22016t)) {
                this.f22017u = this.f22016t;
                z5 = true;
            } else {
                z5 = false;
            }
            if (u(f5, this.f22005i)) {
                this.f21978D = 1.0f;
            } else {
                this.f21978D = f5 / this.f22005i;
            }
            float f8 = this.f22006j / this.f22005i;
            fWidth = fWidth2 * f8 > fWidth ? Math.min(fWidth / f8, fWidth2) : fWidth2;
            f6 = f7;
            z6 = z5;
        }
        if (fWidth > 0.0f) {
            z6 = this.f21979E != f6 || this.f21981G || z6;
            this.f21979E = f6;
            this.f21981G = false;
        }
        if (this.f22019w == null || z6) {
            this.f21982H.setTextSize(this.f21979E);
            this.f21982H.setTypeface(this.f22017u);
            this.f21982H.setLinearText(this.f21978D != 1.0f);
            CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.f22018v, this.f21982H, fWidth, TextUtils.TruncateAt.END);
            if (TextUtils.equals(charSequenceEllipsize, this.f22019w)) {
                return;
            }
            this.f22019w = charSequenceEllipsize;
            this.f22020x = g(charSequenceEllipsize);
        }
    }

    private void j() {
        Bitmap bitmap = this.f22022z;
        if (bitmap != null) {
            bitmap.recycle();
            this.f22022z = null;
        }
    }

    private void l() {
        if (this.f22022z != null || this.f22000d.isEmpty() || TextUtils.isEmpty(this.f22019w)) {
            return;
        }
        h(0.0f);
        this.f21976B = this.f21982H.ascent();
        this.f21977C = this.f21982H.descent();
        TextPaint textPaint = this.f21982H;
        CharSequence charSequence = this.f22019w;
        int iRound = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
        int iRound2 = Math.round(this.f21977C - this.f21976B);
        if (iRound <= 0 || iRound2 <= 0) {
            return;
        }
        this.f22022z = Bitmap.createBitmap(iRound, iRound2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f22022z);
        CharSequence charSequence2 = this.f22019w;
        canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, iRound2 - this.f21982H.descent(), this.f21982H);
        if (this.f21975A == null) {
            this.f21975A = new Paint(3);
        }
    }

    private int o() {
        int[] iArr = this.f21980F;
        return iArr != null ? this.f22008l.getColorForState(iArr, 0) : this.f22008l.getDefaultColor();
    }

    private int p() {
        int[] iArr = this.f21980F;
        return iArr != null ? this.f22007k.getColorForState(iArr, 0) : this.f22007k.getDefaultColor();
    }

    private void t(float f5) {
        this.f22002f.left = w(this.f22000d.left, this.f22001e.left, f5, this.f21983I);
        this.f22002f.top = w(this.f22009m, this.f22010n, f5, this.f21983I);
        this.f22002f.right = w(this.f22000d.right, this.f22001e.right, f5, this.f21983I);
        this.f22002f.bottom = w(this.f22000d.bottom, this.f22001e.bottom, f5, this.f21983I);
    }

    private static boolean u(float f5, float f6) {
        return Math.abs(f5 - f6) < 0.001f;
    }

    private static float w(float f5, float f6, float f7, Interpolator interpolator) {
        if (interpolator != null) {
            f7 = interpolator.getInterpolation(f7);
        }
        return e.a(f5, f6, f7);
    }

    private Typeface y(int i5) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = this.f21997a.getContext().obtainStyledAttributes(i5, new int[]{R.attr.fontFamily});
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

    void B(int i5, int i6, int i7, int i8) {
        if (A(this.f22001e, i5, i6, i7, i8)) {
            return;
        }
        this.f22001e.set(i5, i6, i7, i8);
        this.f21981G = true;
        x();
    }

    void C(int i5) {
        a0 a0VarT = a0.t(this.f21997a.getContext(), i5, g.j.f16995C2);
        int i6 = g.j.f17015G2;
        if (a0VarT.s(i6)) {
            this.f22008l = a0VarT.c(i6);
        }
        if (a0VarT.s(g.j.f17000D2)) {
            this.f22006j = a0VarT.f(r1, (int) this.f22006j);
        }
        this.f21988N = a0VarT.k(g.j.f17029J2, 0);
        this.f21986L = a0VarT.i(g.j.f17033K2, 0.0f);
        this.f21987M = a0VarT.i(g.j.f17037L2, 0.0f);
        this.f21985K = a0VarT.i(g.j.f17041M2, 0.0f);
        a0VarT.x();
        this.f22015s = y(i5);
        z();
    }

    void D(ColorStateList colorStateList) {
        if (this.f22008l != colorStateList) {
            this.f22008l = colorStateList;
            z();
        }
    }

    void E(int i5) {
        if (this.f22004h != i5) {
            this.f22004h = i5;
            z();
        }
    }

    void F(Typeface typeface) {
        if (c(this.f22015s, typeface)) {
            this.f22015s = typeface;
            z();
        }
    }

    void G(int i5, int i6, int i7, int i8) {
        if (A(this.f22000d, i5, i6, i7, i8)) {
            return;
        }
        this.f22000d.set(i5, i6, i7, i8);
        this.f21981G = true;
        x();
    }

    void H(int i5) {
        a0 a0VarT = a0.t(this.f21997a.getContext(), i5, g.j.f16995C2);
        int i6 = g.j.f17015G2;
        if (a0VarT.s(i6)) {
            this.f22007k = a0VarT.c(i6);
        }
        if (a0VarT.s(g.j.f17000D2)) {
            this.f22005i = a0VarT.f(r1, (int) this.f22005i);
        }
        this.f21992R = a0VarT.k(g.j.f17029J2, 0);
        this.f21990P = a0VarT.i(g.j.f17033K2, 0.0f);
        this.f21991Q = a0VarT.i(g.j.f17037L2, 0.0f);
        this.f21989O = a0VarT.i(g.j.f17041M2, 0.0f);
        a0VarT.x();
        this.f22016t = y(i5);
        z();
    }

    void I(ColorStateList colorStateList) {
        if (this.f22007k != colorStateList) {
            this.f22007k = colorStateList;
            z();
        }
    }

    void J(int i5) {
        if (this.f22003g != i5) {
            this.f22003g = i5;
            z();
        }
    }

    void K(Typeface typeface) {
        if (c(this.f22016t, typeface)) {
            this.f22016t = typeface;
            z();
        }
    }

    void L(float f5) {
        float fA = B.a.a(f5, 0.0f, 1.0f);
        if (fA != this.f21999c) {
            this.f21999c = fA;
            f();
        }
    }

    final boolean N(int[] iArr) {
        this.f21980F = iArr;
        if (!v()) {
            return false;
        }
        z();
        return true;
    }

    void O(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f22018v)) {
            this.f22018v = charSequence;
            this.f22019w = null;
            j();
            z();
        }
    }

    public void P(float f5) {
        int i5 = (int) (f5 * 255.0f);
        this.f21993S = i5;
        this.f21982H.setAlpha(i5);
    }

    void Q(Interpolator interpolator) {
        this.f21984J = interpolator;
        z();
    }

    @Override // stepos.support.v7.widget.p
    public void a(float f5) {
        this.f21995U = f5;
    }

    @Override // stepos.support.v7.widget.p
    public void b() {
        this.f21996V = false;
        if (u(this.f21999c, 1.0f)) {
            this.f21978D = 1.0f;
            this.f21979E = this.f22006j;
        } else if (u(this.f21999c, 0.0f)) {
            this.f21978D = 1.0f;
            this.f21979E = this.f22005i;
        }
        this.f21982H.setTextSize(this.f21979E);
        Log.i("[Collapsing]", "releaseTitleScale after mScale:" + this.f21978D + ",mCurrentTextSize:" + this.f21979E + ",mExpandedFraction:" + this.f21999c + ",paint text size:" + this.f21982H.getTextSize());
    }

    public void k(Canvas canvas) {
        Canvas canvas2;
        float fAscent;
        int iSave = canvas.save();
        if (this.f22019w == null || !this.f21998b) {
            canvas2 = canvas;
        } else {
            float f5 = this.f22013q;
            float f6 = this.f22014r + this.f21994T;
            if (u(this.f21999c, 0.0f)) {
                f6 += this.f21995U;
            }
            boolean z5 = this.f22021y && this.f22022z != null;
            if (z5) {
                fAscent = this.f21976B * this.f21978D;
            } else {
                fAscent = this.f21982H.ascent() * this.f21978D;
                this.f21982H.descent();
            }
            if (z5) {
                f6 += fAscent;
            }
            float f7 = f6;
            float f8 = this.f21978D;
            if (f8 != 1.0f) {
                canvas.scale(f8, f8, f5, f7);
            }
            if (z5) {
                canvas.drawBitmap(this.f22022z, f5, f7, this.f21975A);
                canvas2 = canvas;
            } else {
                CharSequence charSequence = this.f22019w;
                canvas2 = canvas;
                canvas2.drawText(charSequence, 0, charSequence.length(), f5, f7, this.f21982H);
            }
        }
        canvas2.restoreToCount(iSave);
    }

    int m() {
        return this.f22004h;
    }

    Typeface n() {
        Typeface typeface = this.f22015s;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    int q() {
        return this.f22003g;
    }

    Typeface r() {
        Typeface typeface = this.f22016t;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    CharSequence s() {
        return this.f22018v;
    }

    final boolean v() {
        ColorStateList colorStateList = this.f22008l;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f22007k;
        return colorStateList2 != null && colorStateList2.isStateful();
    }

    void x() {
        this.f21998b = this.f22001e.width() > 0 && this.f22001e.height() > 0 && this.f22000d.width() > 0 && this.f22000d.height() > 0;
    }

    public void z() {
        if (this.f21997a.getHeight() <= 0 || this.f21997a.getWidth() <= 0) {
            return;
        }
        e();
        f();
    }
}

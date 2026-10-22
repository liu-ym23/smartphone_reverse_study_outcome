package com.stepos.textinputlayout;

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
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.C0464i;
import androidx.core.view.H;
import g.j;
import j3.C0792a;

/* loaded from: classes.dex */
final class b {

    /* renamed from: G, reason: collision with root package name */
    private static final boolean f16030G = false;

    /* renamed from: H, reason: collision with root package name */
    private static final Paint f16031H = null;

    /* renamed from: A, reason: collision with root package name */
    private float f16032A;

    /* renamed from: B, reason: collision with root package name */
    private float f16033B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f16034C;

    /* renamed from: D, reason: collision with root package name */
    private final TextPaint f16035D;

    /* renamed from: E, reason: collision with root package name */
    private Interpolator f16036E;

    /* renamed from: F, reason: collision with root package name */
    private Interpolator f16037F;

    /* renamed from: a, reason: collision with root package name */
    private final View f16038a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f16039b;

    /* renamed from: c, reason: collision with root package name */
    private float f16040c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f16041d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f16042e;

    /* renamed from: f, reason: collision with root package name */
    private final RectF f16043f;

    /* renamed from: g, reason: collision with root package name */
    private int f16044g = 16;

    /* renamed from: h, reason: collision with root package name */
    private int f16045h = 16;

    /* renamed from: i, reason: collision with root package name */
    private float f16046i = 15.0f;

    /* renamed from: j, reason: collision with root package name */
    private float f16047j = 15.0f;

    /* renamed from: k, reason: collision with root package name */
    private int f16048k;

    /* renamed from: l, reason: collision with root package name */
    private int f16049l;

    /* renamed from: m, reason: collision with root package name */
    private float f16050m;

    /* renamed from: n, reason: collision with root package name */
    private float f16051n;

    /* renamed from: o, reason: collision with root package name */
    private float f16052o;

    /* renamed from: p, reason: collision with root package name */
    private float f16053p;

    /* renamed from: q, reason: collision with root package name */
    private float f16054q;

    /* renamed from: r, reason: collision with root package name */
    private float f16055r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f16056s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence f16057t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f16058u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f16059v;

    /* renamed from: w, reason: collision with root package name */
    private Bitmap f16060w;

    /* renamed from: x, reason: collision with root package name */
    private Paint f16061x;

    /* renamed from: y, reason: collision with root package name */
    private float f16062y;

    /* renamed from: z, reason: collision with root package name */
    private float f16063z;

    public b(View view) {
        this.f16038a = view;
        TextPaint textPaint = new TextPaint();
        this.f16035D = textPaint;
        textPaint.setAntiAlias(true);
        this.f16042e = new Rect();
        this.f16041d = new Rect();
        this.f16043f = new RectF();
    }

    private void B(float f5) {
        float fWidth;
        float f6;
        boolean z5;
        if (this.f16056s == null) {
            return;
        }
        if (n(f5, this.f16047j)) {
            fWidth = this.f16042e.width();
            f6 = this.f16047j;
            this.f16032A = 1.0f;
        } else {
            float fWidth2 = this.f16041d.width();
            float f7 = this.f16046i;
            if (n(f5, f7)) {
                this.f16032A = 1.0f;
            } else {
                this.f16032A = f5 / this.f16046i;
            }
            fWidth = fWidth2;
            f6 = f7;
        }
        if (fWidth > 0.0f) {
            z5 = Float.compare(this.f16033B, f6) != 0 || this.f16034C;
            this.f16033B = f6;
            this.f16034C = false;
        } else {
            z5 = false;
        }
        if (this.f16057t == null || z5) {
            this.f16035D.setTextSize(this.f16033B);
            CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.f16056s, this.f16035D, fWidth, TextUtils.TruncateAt.END);
            CharSequence charSequence = this.f16057t;
            if (charSequence == null || !charSequence.equals(charSequenceEllipsize)) {
                this.f16057t = charSequenceEllipsize;
            }
            this.f16058u = d(this.f16057t);
        }
        boolean z6 = f16030G && Float.compare(this.f16032A, 1.0f) != 0;
        this.f16059v = z6;
        if (z6) {
            g();
        }
        H.a0(this.f16038a);
    }

    private static int a(int i5, int i6, float f5) {
        float f6 = 1.0f - f5;
        return Color.argb((int) ((Color.alpha(i5) * f6) + (Color.alpha(i6) * f5)), (int) ((Color.red(i5) * f6) + (Color.red(i6) * f5)), (int) ((Color.green(i5) * f6) + (Color.green(i6) * f5)), (int) ((Color.blue(i5) * f6) + (Color.blue(i6) * f5)));
    }

    private void b() {
        this.f16035D.setTextSize(this.f16047j);
        CharSequence charSequence = this.f16057t;
        float fMeasureText = charSequence != null ? this.f16035D.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int iB = C0464i.b(this.f16045h, this.f16058u ? 1 : 0);
        int i5 = iB & 112;
        if (i5 == 48) {
            this.f16051n = this.f16042e.top - this.f16035D.ascent();
        } else if (i5 != 80) {
            this.f16051n = this.f16042e.centerY() + (((this.f16035D.descent() - this.f16035D.ascent()) / 2.0f) - this.f16035D.descent());
        } else {
            this.f16051n = this.f16042e.bottom;
        }
        int i6 = iB & 7;
        if (i6 == 1) {
            this.f16053p = this.f16042e.centerX() - (fMeasureText / 2.0f);
        } else if (i6 != 5) {
            this.f16053p = this.f16042e.left;
        } else {
            this.f16053p = this.f16042e.right - fMeasureText;
        }
        this.f16035D.setTextSize(this.f16046i);
        CharSequence charSequence2 = this.f16057t;
        float fMeasureText2 = charSequence2 != null ? this.f16035D.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int iB2 = C0464i.b(this.f16044g, this.f16058u ? 1 : 0);
        int i7 = iB2 & 112;
        if (i7 == 48) {
            this.f16050m = this.f16041d.top - this.f16035D.ascent();
        } else if (i7 != 80) {
            this.f16050m = this.f16041d.centerY() + (((this.f16035D.descent() - this.f16035D.ascent()) / 2.0f) - this.f16035D.descent());
        } else {
            this.f16050m = this.f16041d.bottom;
        }
        int i8 = iB2 & 7;
        if (i8 == 1) {
            this.f16052o = this.f16041d.centerX() - (fMeasureText2 / 2.0f);
        } else if (i8 != 5) {
            this.f16052o = this.f16041d.left;
        } else {
            this.f16052o = this.f16041d.right - fMeasureText2;
        }
        e();
    }

    private void c() {
        float f5 = this.f16040c;
        m(f5);
        this.f16054q = o(this.f16052o, this.f16053p, f5, this.f16036E);
        this.f16055r = o(this.f16050m, this.f16051n, f5, this.f16036E);
        B(o(this.f16046i, this.f16047j, f5, this.f16037F));
        int i5 = this.f16049l;
        int i6 = this.f16048k;
        if (i5 != i6) {
            this.f16035D.setColor(a(i6, i5, f5));
        } else {
            this.f16035D.setColor(i5);
        }
        H.a0(this.f16038a);
    }

    private boolean d(CharSequence charSequence) {
        return H.x(this.f16038a) == 1;
    }

    private void e() {
        Bitmap bitmap = this.f16060w;
        if (bitmap != null) {
            bitmap.recycle();
            this.f16060w = null;
        }
    }

    private void g() {
        if (this.f16060w != null || this.f16041d.isEmpty() || TextUtils.isEmpty(this.f16057t)) {
            return;
        }
        this.f16035D.setTextSize(this.f16046i);
        this.f16035D.setColor(this.f16048k);
        this.f16062y = this.f16035D.ascent();
        this.f16063z = this.f16035D.descent();
        TextPaint textPaint = this.f16035D;
        CharSequence charSequence = this.f16057t;
        int iRound = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
        int iRound2 = Math.round(this.f16063z - this.f16062y);
        if (iRound > 0 || iRound2 > 0) {
            this.f16060w = Bitmap.createBitmap(iRound, iRound2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f16060w);
            CharSequence charSequence2 = this.f16057t;
            canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, iRound2 - this.f16035D.descent(), this.f16035D);
            if (this.f16061x == null) {
                this.f16061x = new Paint(3);
            }
        }
    }

    private void m(float f5) {
        this.f16043f.left = o(this.f16041d.left, this.f16042e.left, f5, this.f16036E);
        this.f16043f.top = o(this.f16050m, this.f16051n, f5, this.f16036E);
        this.f16043f.right = o(this.f16041d.right, this.f16042e.right, f5, this.f16036E);
        this.f16043f.bottom = o(this.f16041d.bottom, this.f16042e.bottom, f5, this.f16036E);
    }

    private static boolean n(float f5, float f6) {
        return Math.abs(f5 - f6) < 0.001f;
    }

    private static float o(float f5, float f6, float f7, Interpolator interpolator) {
        if (interpolator != null) {
            f7 = interpolator.getInterpolation(f7);
        }
        return a.a(f5, f6, f7);
    }

    private static boolean r(Rect rect, int i5, int i6, int i7, int i8) {
        return rect.left == i5 && rect.top == i6 && rect.right == i7 && rect.bottom == i8;
    }

    void A(float f5) {
        float fA = c.a(f5, 0.0f, 1.0f);
        if (Float.compare(fA, this.f16040c) != 0) {
            this.f16040c = fA;
            c();
        }
    }

    void C(Interpolator interpolator) {
        this.f16036E = interpolator;
        q();
    }

    void D(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f16056s)) {
            this.f16056s = charSequence;
            this.f16057t = null;
            e();
            q();
        }
    }

    void E(Interpolator interpolator) {
        this.f16037F = interpolator;
        q();
    }

    void F(Typeface typeface) {
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        if (this.f16035D.getTypeface() != typeface) {
            this.f16035D.setTypeface(typeface);
            q();
        }
    }

    public void f(Canvas canvas) {
        Canvas canvas2;
        float fAscent;
        int iSave = canvas.save();
        if (this.f16057t == null || !this.f16039b) {
            canvas2 = canvas;
        } else {
            float f5 = this.f16054q;
            float f6 = this.f16055r;
            boolean z5 = this.f16059v && this.f16060w != null;
            this.f16035D.setTextSize(this.f16033B);
            if (z5) {
                fAscent = this.f16062y * this.f16032A;
            } else {
                fAscent = this.f16035D.ascent() * this.f16032A;
                this.f16035D.descent();
            }
            if (z5) {
                f6 += fAscent;
            }
            float f7 = f6;
            if (Float.compare(this.f16032A, 1.0f) != 0) {
                float f8 = this.f16032A;
                canvas.scale(f8, f8, f5, f7);
            }
            if (z5) {
                canvas.drawBitmap(this.f16060w, f5, f7, this.f16061x);
                canvas2 = canvas;
            } else {
                CharSequence charSequence = this.f16057t;
                canvas2 = canvas;
                canvas2.drawText(charSequence, 0, charSequence.length(), f5, f7, this.f16035D);
            }
        }
        canvas2.restoreToCount(iSave);
    }

    int h() {
        return this.f16049l;
    }

    float i() {
        return this.f16047j;
    }

    float j() {
        return this.f16040c;
    }

    CharSequence k() {
        return this.f16056s;
    }

    Typeface l() {
        return this.f16035D.getTypeface();
    }

    void p() {
        this.f16039b = this.f16042e.width() > 0 && this.f16042e.height() > 0 && this.f16041d.width() > 0 && this.f16041d.height() > 0;
    }

    public void q() {
        if (this.f16038a.getHeight() <= 0 || this.f16038a.getWidth() <= 0) {
            return;
        }
        b();
        c();
    }

    void s(int i5, int i6, int i7, int i8) {
        if (r(this.f16042e, i5, i6, i7, i8)) {
            return;
        }
        this.f16042e.set(i5, i6, i7, i8);
        this.f16034C = true;
        p();
    }

    void t(int i5) {
        TypedArray typedArrayObtainStyledAttributes = this.f16038a.getContext().obtainStyledAttributes(i5, j.f16995C2);
        if (typedArrayObtainStyledAttributes.hasValue(j.f17015G2)) {
            int iA = C0792a.a(this.f16038a.getContext());
            this.f16049l = iA;
            if (iA == 0) {
                this.f16049l = -16776961;
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(j.f17000D2)) {
            this.f16047j = typedArrayObtainStyledAttributes.getDimensionPixelSize(r0, (int) this.f16047j);
        }
        typedArrayObtainStyledAttributes.recycle();
        q();
    }

    void u(int i5) {
        if (this.f16049l != i5) {
            this.f16049l = i5;
            q();
        }
    }

    void v(int i5) {
        if (this.f16045h != i5) {
            this.f16045h = i5;
            q();
        }
    }

    void w(int i5, int i6, int i7, int i8) {
        if (r(this.f16041d, i5, i6, i7, i8)) {
            return;
        }
        this.f16041d.set(i5, i6, i7, i8);
        this.f16034C = true;
        p();
    }

    void x(int i5) {
        if (this.f16048k != i5) {
            this.f16048k = i5;
            q();
        }
    }

    void y(int i5) {
        if (this.f16044g != i5) {
            this.f16044g = i5;
            q();
        }
    }

    void z(float f5) {
        if (Float.compare(this.f16046i, f5) != 0) {
            this.f16046i = f5;
            q();
        }
    }
}

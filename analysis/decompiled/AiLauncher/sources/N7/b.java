package N7;

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
import android.view.View;
import android.view.animation.Interpolator;
import androidx.appcompat.R$styleable;
import androidx.core.view.C1321i;
import androidx.core.view.N;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: G, reason: collision with root package name */
    public static final boolean f4855G = false;

    /* renamed from: H, reason: collision with root package name */
    public static final Paint f4856H = null;

    /* renamed from: A, reason: collision with root package name */
    public float f4857A;

    /* renamed from: B, reason: collision with root package name */
    public float f4858B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f4859C;

    /* renamed from: D, reason: collision with root package name */
    public final TextPaint f4860D;

    /* renamed from: E, reason: collision with root package name */
    public Interpolator f4861E;

    /* renamed from: F, reason: collision with root package name */
    public Interpolator f4862F;

    /* renamed from: a, reason: collision with root package name */
    public final View f4863a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4864b;

    /* renamed from: c, reason: collision with root package name */
    public float f4865c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f4866d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f4867e;

    /* renamed from: f, reason: collision with root package name */
    public final RectF f4868f;

    /* renamed from: g, reason: collision with root package name */
    public int f4869g = 16;

    /* renamed from: h, reason: collision with root package name */
    public int f4870h = 16;

    /* renamed from: i, reason: collision with root package name */
    public float f4871i = 15.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f4872j = 15.0f;

    /* renamed from: k, reason: collision with root package name */
    public int f4873k;

    /* renamed from: l, reason: collision with root package name */
    public int f4874l;

    /* renamed from: m, reason: collision with root package name */
    public float f4875m;

    /* renamed from: n, reason: collision with root package name */
    public float f4876n;

    /* renamed from: o, reason: collision with root package name */
    public float f4877o;

    /* renamed from: p, reason: collision with root package name */
    public float f4878p;

    /* renamed from: q, reason: collision with root package name */
    public float f4879q;

    /* renamed from: r, reason: collision with root package name */
    public float f4880r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f4881s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f4882t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4883u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4884v;

    /* renamed from: w, reason: collision with root package name */
    public Bitmap f4885w;

    /* renamed from: x, reason: collision with root package name */
    public Paint f4886x;

    /* renamed from: y, reason: collision with root package name */
    public float f4887y;

    /* renamed from: z, reason: collision with root package name */
    public float f4888z;

    public b(View view) {
        this.f4863a = view;
        TextPaint textPaint = new TextPaint();
        this.f4860D = textPaint;
        textPaint.setAntiAlias(true);
        this.f4867e = new Rect();
        this.f4866d = new Rect();
        this.f4868f = new RectF();
    }

    public static int a(int i10, int i11, float f10) {
        float f11 = 1.0f - f10;
        return Color.argb((int) ((Color.alpha(i10) * f11) + (Color.alpha(i11) * f10)), (int) ((Color.red(i10) * f11) + (Color.red(i11) * f10)), (int) ((Color.green(i10) * f11) + (Color.green(i11) * f10)), (int) ((Color.blue(i10) * f11) + (Color.blue(i11) * f10)));
    }

    public static boolean n(float f10, float f11) {
        return Math.abs(f10 - f11) < 0.001f;
    }

    public static float o(float f10, float f11, float f12, Interpolator interpolator) {
        if (interpolator != null) {
            f12 = interpolator.getInterpolation(f12);
        }
        return a.a(f10, f11, f12);
    }

    public static boolean r(Rect rect, int i10, int i11, int i12, int i13) {
        return rect.left == i10 && rect.top == i11 && rect.right == i12 && rect.bottom == i13;
    }

    public void A(float f10) {
        float fA = c.a(f10, 0.0f, 1.0f);
        if (Float.compare(fA, this.f4865c) != 0) {
            this.f4865c = fA;
            c();
        }
    }

    public final void B(float f10) {
        float fWidth;
        float f11;
        boolean z10;
        if (this.f4881s == null) {
            return;
        }
        if (n(f10, this.f4872j)) {
            fWidth = this.f4867e.width();
            f11 = this.f4872j;
            this.f4857A = 1.0f;
        } else {
            float fWidth2 = this.f4866d.width();
            float f12 = this.f4871i;
            if (n(f10, f12)) {
                this.f4857A = 1.0f;
            } else {
                this.f4857A = f10 / this.f4871i;
            }
            fWidth = fWidth2;
            f11 = f12;
        }
        if (fWidth > 0.0f) {
            z10 = Float.compare(this.f4858B, f11) != 0 || this.f4859C;
            this.f4858B = f11;
            this.f4859C = false;
        } else {
            z10 = false;
        }
        if (this.f4882t == null || z10) {
            this.f4860D.setTextSize(this.f4858B);
            CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.f4881s, this.f4860D, fWidth, TextUtils.TruncateAt.END);
            CharSequence charSequence = this.f4882t;
            if (charSequence == null || !charSequence.equals(charSequenceEllipsize)) {
                this.f4882t = charSequenceEllipsize;
            }
            this.f4883u = d(this.f4882t);
        }
        boolean z11 = f4855G && Float.compare(this.f4857A, 1.0f) != 0;
        this.f4884v = z11;
        if (z11) {
            g();
        }
        N.Y(this.f4863a);
    }

    public void C(Interpolator interpolator) {
        this.f4861E = interpolator;
        q();
    }

    public void D(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f4881s)) {
            this.f4881s = charSequence;
            this.f4882t = null;
            e();
            q();
        }
    }

    public void E(Interpolator interpolator) {
        this.f4862F = interpolator;
        q();
    }

    public void F(Typeface typeface) {
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        if (this.f4860D.getTypeface() != typeface) {
            this.f4860D.setTypeface(typeface);
            q();
        }
    }

    public final void b() {
        this.f4860D.setTextSize(this.f4872j);
        CharSequence charSequence = this.f4882t;
        float fMeasureText = charSequence != null ? this.f4860D.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int iB = C1321i.b(this.f4870h, this.f4883u ? 1 : 0);
        int i10 = iB & 112;
        if (i10 == 48) {
            this.f4876n = this.f4867e.top - this.f4860D.ascent();
        } else if (i10 != 80) {
            this.f4876n = this.f4867e.centerY() + (((this.f4860D.descent() - this.f4860D.ascent()) / 2.0f) - this.f4860D.descent());
        } else {
            this.f4876n = this.f4867e.bottom;
        }
        int i11 = iB & 7;
        if (i11 == 1) {
            this.f4878p = this.f4867e.centerX() - (fMeasureText / 2.0f);
        } else if (i11 != 5) {
            this.f4878p = this.f4867e.left;
        } else {
            this.f4878p = this.f4867e.right - fMeasureText;
        }
        this.f4860D.setTextSize(this.f4871i);
        CharSequence charSequence2 = this.f4882t;
        float fMeasureText2 = charSequence2 != null ? this.f4860D.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int iB2 = C1321i.b(this.f4869g, this.f4883u ? 1 : 0);
        int i12 = iB2 & 112;
        if (i12 == 48) {
            this.f4875m = this.f4866d.top - this.f4860D.ascent();
        } else if (i12 != 80) {
            this.f4875m = this.f4866d.centerY() + (((this.f4860D.descent() - this.f4860D.ascent()) / 2.0f) - this.f4860D.descent());
        } else {
            this.f4875m = this.f4866d.bottom;
        }
        int i13 = iB2 & 7;
        if (i13 == 1) {
            this.f4877o = this.f4866d.centerX() - (fMeasureText2 / 2.0f);
        } else if (i13 != 5) {
            this.f4877o = this.f4866d.left;
        } else {
            this.f4877o = this.f4866d.right - fMeasureText2;
        }
        e();
    }

    public final void c() {
        float f10 = this.f4865c;
        m(f10);
        this.f4879q = o(this.f4877o, this.f4878p, f10, this.f4861E);
        this.f4880r = o(this.f4875m, this.f4876n, f10, this.f4861E);
        B(o(this.f4871i, this.f4872j, f10, this.f4862F));
        int i10 = this.f4874l;
        int i11 = this.f4873k;
        if (i10 != i11) {
            this.f4860D.setColor(a(i11, i10, f10));
        } else {
            this.f4860D.setColor(i10);
        }
        N.Y(this.f4863a);
    }

    public final boolean d(CharSequence charSequence) {
        return N.u(this.f4863a) == 1;
    }

    public final void e() {
        Bitmap bitmap = this.f4885w;
        if (bitmap != null) {
            bitmap.recycle();
            this.f4885w = null;
        }
    }

    public void f(Canvas canvas) {
        Canvas canvas2;
        float fAscent;
        int iSave = canvas.save();
        if (this.f4882t == null || !this.f4864b) {
            canvas2 = canvas;
        } else {
            float f10 = this.f4879q;
            float f11 = this.f4880r;
            boolean z10 = this.f4884v && this.f4885w != null;
            this.f4860D.setTextSize(this.f4858B);
            if (z10) {
                fAscent = this.f4887y * this.f4857A;
            } else {
                fAscent = this.f4860D.ascent() * this.f4857A;
                this.f4860D.descent();
            }
            if (z10) {
                f11 += fAscent;
            }
            float f12 = f11;
            if (Float.compare(this.f4857A, 1.0f) != 0) {
                float f13 = this.f4857A;
                canvas.scale(f13, f13, f10, f12);
            }
            if (z10) {
                canvas.drawBitmap(this.f4885w, f10, f12, this.f4886x);
                canvas2 = canvas;
            } else {
                CharSequence charSequence = this.f4882t;
                canvas2 = canvas;
                canvas2.drawText(charSequence, 0, charSequence.length(), f10, f12, this.f4860D);
            }
        }
        canvas2.restoreToCount(iSave);
    }

    public final void g() {
        if (this.f4885w != null || this.f4866d.isEmpty() || TextUtils.isEmpty(this.f4882t)) {
            return;
        }
        this.f4860D.setTextSize(this.f4871i);
        this.f4860D.setColor(this.f4873k);
        this.f4887y = this.f4860D.ascent();
        this.f4888z = this.f4860D.descent();
        TextPaint textPaint = this.f4860D;
        CharSequence charSequence = this.f4882t;
        int iRound = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
        int iRound2 = Math.round(this.f4888z - this.f4887y);
        if (iRound > 0 || iRound2 > 0) {
            this.f4885w = Bitmap.createBitmap(iRound, iRound2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f4885w);
            CharSequence charSequence2 = this.f4882t;
            canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, iRound2 - this.f4860D.descent(), this.f4860D);
            if (this.f4886x == null) {
                this.f4886x = new Paint(3);
            }
        }
    }

    public int h() {
        return this.f4874l;
    }

    public float i() {
        return this.f4872j;
    }

    public float j() {
        return this.f4865c;
    }

    public CharSequence k() {
        return this.f4881s;
    }

    public Typeface l() {
        return this.f4860D.getTypeface();
    }

    public final void m(float f10) {
        this.f4868f.left = o(this.f4866d.left, this.f4867e.left, f10, this.f4861E);
        this.f4868f.top = o(this.f4875m, this.f4876n, f10, this.f4861E);
        this.f4868f.right = o(this.f4866d.right, this.f4867e.right, f10, this.f4861E);
        this.f4868f.bottom = o(this.f4866d.bottom, this.f4867e.bottom, f10, this.f4861E);
    }

    public void p() {
        this.f4864b = this.f4867e.width() > 0 && this.f4867e.height() > 0 && this.f4866d.width() > 0 && this.f4866d.height() > 0;
    }

    public void q() {
        if (this.f4863a.getHeight() <= 0 || this.f4863a.getWidth() <= 0) {
            return;
        }
        b();
        c();
    }

    public void s(int i10, int i11, int i12, int i13) {
        if (r(this.f4867e, i10, i11, i12, i13)) {
            return;
        }
        this.f4867e.set(i10, i11, i12, i13);
        this.f4859C = true;
        p();
    }

    public void t(int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = this.f4863a.getContext().obtainStyledAttributes(i10, R$styleable.TextAppearance);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.TextAppearance_android_textColor)) {
            int iA = d.a(this.f4863a.getContext());
            this.f4874l = iA;
            if (iA == 0) {
                this.f4874l = -16776961;
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.TextAppearance_android_textSize)) {
            this.f4872j = typedArrayObtainStyledAttributes.getDimensionPixelSize(r0, (int) this.f4872j);
        }
        typedArrayObtainStyledAttributes.recycle();
        q();
    }

    public void u(int i10) {
        if (this.f4874l != i10) {
            this.f4874l = i10;
            q();
        }
    }

    public void v(int i10) {
        if (this.f4870h != i10) {
            this.f4870h = i10;
            q();
        }
    }

    public void w(int i10, int i11, int i12, int i13) {
        if (r(this.f4866d, i10, i11, i12, i13)) {
            return;
        }
        this.f4866d.set(i10, i11, i12, i13);
        this.f4859C = true;
        p();
    }

    public void x(int i10) {
        if (this.f4873k != i10) {
            this.f4873k = i10;
            q();
        }
    }

    public void y(int i10) {
        if (this.f4869g != i10) {
            this.f4869g = i10;
            q();
        }
    }

    public void z(float f10) {
        if (Float.compare(this.f4871i, f10) != 0) {
            this.f4871i = f10;
            q();
        }
    }
}

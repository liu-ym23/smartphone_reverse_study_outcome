package v6;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.stepos.textinputlayout.TextInputLayout;

/* renamed from: v6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2061b {

    /* renamed from: A, reason: collision with root package name */
    public AccelerateInterpolator f6771A;

    /* renamed from: B, reason: collision with root package name */
    public Interpolator f6772B;

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f6773a;
    public boolean b;
    public float c;
    public final Rect d;
    public final Rect e;
    public final RectF f;
    public int g = 16;
    public int h = 16;
    public float i = 15.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f6774j = 15.0f;
    public int k;
    public int l;
    public float m;
    public float n;
    public float o;
    public float p;

    /* renamed from: q, reason: collision with root package name */
    public float f6775q;

    /* renamed from: r, reason: collision with root package name */
    public float f6776r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f6777s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f6778t;
    public boolean u;

    /* renamed from: v, reason: collision with root package name */
    public Bitmap f6779v;

    /* renamed from: w, reason: collision with root package name */
    public float f6780w;

    /* renamed from: x, reason: collision with root package name */
    public float f6781x;
    public boolean y;

    /* renamed from: z, reason: collision with root package name */
    public final TextPaint f6782z;

    public C2061b(TextInputLayout textInputLayout) {
        this.f6773a = textInputLayout;
        TextPaint textPaint = new TextPaint();
        this.f6782z = textPaint;
        textPaint.setAntiAlias(true);
        this.e = new Rect();
        this.d = new Rect();
        this.f = new RectF();
    }

    public static float b(float f, float f7, float f9, Interpolator interpolator) {
        if (interpolator != null) {
            f9 = interpolator.getInterpolation(f9);
        }
        FastOutSlowInInterpolator fastOutSlowInInterpolator = AbstractC2060a.f6770a;
        return B7.a.b(f7, f, f9, f);
    }

    public final void a() {
        float fWidth;
        float f;
        boolean z10;
        float f7 = this.c;
        Rect rect = this.d;
        float f9 = rect.left;
        Rect rect2 = this.e;
        float fB = b(f9, rect2.left, f7, this.f6771A);
        RectF rectF = this.f;
        rectF.left = fB;
        rectF.top = b(this.m, this.n, f7, this.f6771A);
        rectF.right = b(rect.right, rect2.right, f7, this.f6771A);
        rectF.bottom = b(rect.bottom, rect2.bottom, f7, this.f6771A);
        this.f6775q = b(this.o, this.p, f7, this.f6771A);
        this.f6776r = b(this.m, this.n, f7, this.f6771A);
        float fB2 = b(this.i, this.f6774j, f7, this.f6772B);
        CharSequence charSequence = this.f6777s;
        TextInputLayout textInputLayout = this.f6773a;
        TextPaint textPaint = this.f6782z;
        if (charSequence != null) {
            if (Math.abs(fB2 - this.f6774j) < 0.001f) {
                fWidth = rect2.width();
                f = this.f6774j;
                this.f6780w = 1.0f;
            } else {
                fWidth = rect.width();
                float f10 = this.i;
                if (Math.abs(fB2 - f10) < 0.001f) {
                    this.f6780w = 1.0f;
                } else {
                    this.f6780w = fB2 / this.i;
                }
                f = f10;
            }
            if (fWidth > 0.0f) {
                z10 = Float.compare(this.f6781x, f) != 0 || this.y;
                this.f6781x = f;
                this.y = false;
            } else {
                z10 = false;
            }
            if (this.f6778t == null || z10) {
                textPaint.setTextSize(this.f6781x);
                CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.f6777s, textPaint, fWidth, TextUtils.TruncateAt.END);
                CharSequence charSequence2 = this.f6778t;
                if (charSequence2 == null || !charSequence2.equals(charSequenceEllipsize)) {
                    this.f6778t = charSequenceEllipsize;
                }
                this.u = ViewCompat.getLayoutDirection(textInputLayout) == 1;
            }
            ViewCompat.postInvalidateOnAnimation(textInputLayout);
        }
        int i = this.l;
        if (i != this.k) {
            float f11 = 1.0f - f7;
            textPaint.setColor(Color.argb((int) ((Color.alpha(i) * f7) + (Color.alpha(r9) * f11)), (int) ((Color.red(i) * f7) + (Color.red(r9) * f11)), (int) ((Color.green(i) * f7) + (Color.green(r9) * f11)), (int) ((Color.blue(i) * f7) + (Color.blue(r9) * f11))));
        } else {
            textPaint.setColor(i);
        }
        ViewCompat.postInvalidateOnAnimation(textInputLayout);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            r2 = this;
            android.graphics.Rect r0 = r2.e
            int r1 = r0.width()
            if (r1 <= 0) goto L1e
            int r0 = r0.height()
            if (r0 <= 0) goto L1e
            android.graphics.Rect r0 = r2.d
            int r1 = r0.width()
            if (r1 <= 0) goto L1e
            int r0 = r0.height()
            if (r0 <= 0) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            r2.b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.C2061b.c():void");
    }

    public final void d() {
        TextInputLayout textInputLayout = this.f6773a;
        if (textInputLayout.getHeight() <= 0 || textInputLayout.getWidth() <= 0) {
            return;
        }
        float f = this.f6774j;
        TextPaint textPaint = this.f6782z;
        textPaint.setTextSize(f);
        CharSequence charSequence = this.f6778t;
        float fMeasureText = charSequence != null ? textPaint.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.h, this.u ? 1 : 0);
        int i = absoluteGravity & 112;
        Rect rect = this.e;
        if (i == 48) {
            this.n = rect.top - textPaint.ascent();
        } else if (i != 80) {
            this.n = rect.centerY() + (((textPaint.descent() - textPaint.ascent()) / 2.0f) - textPaint.descent());
        } else {
            this.n = rect.bottom;
        }
        int i6 = absoluteGravity & 7;
        if (i6 == 1) {
            this.p = rect.centerX() - (fMeasureText / 2.0f);
        } else if (i6 != 5) {
            this.p = rect.left;
        } else {
            this.p = rect.right - fMeasureText;
        }
        textPaint.setTextSize(this.i);
        CharSequence charSequence2 = this.f6778t;
        float fMeasureText2 = charSequence2 != null ? textPaint.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.g, this.u ? 1 : 0);
        int i10 = absoluteGravity2 & 112;
        Rect rect2 = this.d;
        if (i10 == 48) {
            this.m = rect2.top - textPaint.ascent();
        } else if (i10 != 80) {
            this.m = rect2.centerY() + (((textPaint.descent() - textPaint.ascent()) / 2.0f) - textPaint.descent());
        } else {
            this.m = rect2.bottom;
        }
        int i11 = absoluteGravity2 & 7;
        if (i11 == 1) {
            this.o = rect2.centerX() - (fMeasureText2 / 2.0f);
        } else if (i11 != 5) {
            this.o = rect2.left;
        } else {
            this.o = rect2.right - fMeasureText2;
        }
        Bitmap bitmap = this.f6779v;
        if (bitmap != null) {
            bitmap.recycle();
            this.f6779v = null;
        }
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0005 A[PHI: r0
      0x0005: PHI (r0v4 float) = (r0v0 float), (r0v1 float) binds: [B:3:0x0003, B:6:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(float r3) {
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
            float r0 = r2.c
            int r0 = java.lang.Float.compare(r3, r0)
            if (r0 == 0) goto L1b
            r2.c = r3
            r2.a()
        L1b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.C2061b.e(float):void");
    }
}

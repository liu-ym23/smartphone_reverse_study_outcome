package wa;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import com.stepos.textinputlayout.TextInputLayout;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {
    public AccelerateInterpolator A;
    public Interpolator B;

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f13624a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13625b;

    /* renamed from: c, reason: collision with root package name */
    public float f13626c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f13627d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f13628e;

    /* renamed from: f, reason: collision with root package name */
    public final RectF f13629f;

    /* renamed from: g, reason: collision with root package name */
    public int f13630g = 16;
    public int h = 16;

    /* renamed from: i, reason: collision with root package name */
    public float f13631i = 15.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f13632j = 15.0f;

    /* renamed from: k, reason: collision with root package name */
    public int f13633k;

    /* renamed from: l, reason: collision with root package name */
    public int f13634l;

    /* renamed from: m, reason: collision with root package name */
    public float f13635m;

    /* renamed from: n, reason: collision with root package name */
    public float f13636n;

    /* renamed from: o, reason: collision with root package name */
    public float f13637o;

    /* renamed from: p, reason: collision with root package name */
    public float f13638p;

    /* renamed from: q, reason: collision with root package name */
    public float f13639q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f13640s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f13641t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f13642u;

    /* renamed from: v, reason: collision with root package name */
    public Bitmap f13643v;

    /* renamed from: w, reason: collision with root package name */
    public float f13644w;

    /* renamed from: x, reason: collision with root package name */
    public float f13645x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f13646y;
    public final TextPaint z;

    public b(TextInputLayout textInputLayout) {
        this.f13624a = textInputLayout;
        TextPaint textPaint = new TextPaint();
        this.z = textPaint;
        textPaint.setAntiAlias(true);
        this.f13628e = new Rect();
        this.f13627d = new Rect();
        this.f13629f = new RectF();
    }

    public static float b(float f8, float f9, float f10, Interpolator interpolator) {
        if (interpolator != null) {
            f10 = interpolator.getInterpolation(f10);
        }
        o1.b bVar = a.f13623a;
        return h0.e.a(f9, f8, f10, f8);
    }

    public final void a() {
        float fWidth;
        float f8;
        boolean z;
        float f9 = this.f13626c;
        Rect rect = this.f13627d;
        float f10 = rect.left;
        Rect rect2 = this.f13628e;
        float fB = b(f10, rect2.left, f9, this.A);
        RectF rectF = this.f13629f;
        rectF.left = fB;
        rectF.top = b(this.f13635m, this.f13636n, f9, this.A);
        rectF.right = b(rect.right, rect2.right, f9, this.A);
        rectF.bottom = b(rect.bottom, rect2.bottom, f9, this.A);
        this.f13639q = b(this.f13637o, this.f13638p, f9, this.A);
        this.r = b(this.f13635m, this.f13636n, f9, this.A);
        float fB2 = b(this.f13631i, this.f13632j, f9, this.B);
        CharSequence charSequence = this.f13640s;
        TextInputLayout textInputLayout = this.f13624a;
        TextPaint textPaint = this.z;
        if (charSequence != null) {
            if (Math.abs(fB2 - this.f13632j) < 0.001f) {
                fWidth = rect2.width();
                f8 = this.f13632j;
                this.f13644w = 1.0f;
            } else {
                fWidth = rect.width();
                float f11 = this.f13631i;
                if (Math.abs(fB2 - f11) < 0.001f) {
                    this.f13644w = 1.0f;
                } else {
                    this.f13644w = fB2 / this.f13631i;
                }
                f8 = f11;
            }
            if (fWidth > 0.0f) {
                z = Float.compare(this.f13645x, f8) != 0 || this.f13646y;
                this.f13645x = f8;
                this.f13646y = false;
            } else {
                z = false;
            }
            if (this.f13641t == null || z) {
                textPaint.setTextSize(this.f13645x);
                CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.f13640s, textPaint, fWidth, TextUtils.TruncateAt.END);
                CharSequence charSequence2 = this.f13641t;
                if (charSequence2 == null || !charSequence2.equals(charSequenceEllipsize)) {
                    this.f13641t = charSequenceEllipsize;
                }
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                this.f13642u = textInputLayout.getLayoutDirection() == 1;
            }
            WeakHashMap<View, h0> weakHashMap2 = e0.f13274a;
            textInputLayout.postInvalidateOnAnimation();
        }
        int i10 = this.f13634l;
        if (i10 != this.f13633k) {
            float f12 = 1.0f - f9;
            textPaint.setColor(Color.argb((int) ((Color.alpha(i10) * f9) + (Color.alpha(r9) * f12)), (int) ((Color.red(i10) * f9) + (Color.red(r9) * f12)), (int) ((Color.green(i10) * f9) + (Color.green(r9) * f12)), (int) ((Color.blue(i10) * f9) + (Color.blue(r9) * f12))));
        } else {
            textPaint.setColor(i10);
        }
        WeakHashMap<View, h0> weakHashMap3 = e0.f13274a;
        textInputLayout.postInvalidateOnAnimation();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            r2 = this;
            android.graphics.Rect r0 = r2.f13628e
            int r1 = r0.width()
            if (r1 <= 0) goto L1e
            int r0 = r0.height()
            if (r0 <= 0) goto L1e
            android.graphics.Rect r0 = r2.f13627d
            int r1 = r0.width()
            if (r1 <= 0) goto L1e
            int r0 = r0.height()
            if (r0 <= 0) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            r2.f13625b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: wa.b.c():void");
    }

    public final void d() {
        TextInputLayout textInputLayout = this.f13624a;
        if (textInputLayout.getHeight() <= 0 || textInputLayout.getWidth() <= 0) {
            return;
        }
        float f8 = this.f13632j;
        TextPaint textPaint = this.z;
        textPaint.setTextSize(f8);
        CharSequence charSequence = this.f13641t;
        float fMeasureText = charSequence != null ? textPaint.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int absoluteGravity = Gravity.getAbsoluteGravity(this.h, this.f13642u ? 1 : 0);
        int i10 = absoluteGravity & 112;
        Rect rect = this.f13628e;
        if (i10 == 48) {
            this.f13636n = rect.top - textPaint.ascent();
        } else if (i10 != 80) {
            this.f13636n = rect.centerY() + (((textPaint.descent() - textPaint.ascent()) / 2.0f) - textPaint.descent());
        } else {
            this.f13636n = rect.bottom;
        }
        int i11 = absoluteGravity & 7;
        if (i11 == 1) {
            this.f13638p = rect.centerX() - (fMeasureText / 2.0f);
        } else if (i11 != 5) {
            this.f13638p = rect.left;
        } else {
            this.f13638p = rect.right - fMeasureText;
        }
        textPaint.setTextSize(this.f13631i);
        CharSequence charSequence2 = this.f13641t;
        float fMeasureText2 = charSequence2 != null ? textPaint.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f13630g, this.f13642u ? 1 : 0);
        int i12 = absoluteGravity2 & 112;
        Rect rect2 = this.f13627d;
        if (i12 == 48) {
            this.f13635m = rect2.top - textPaint.ascent();
        } else if (i12 != 80) {
            this.f13635m = rect2.centerY() + (((textPaint.descent() - textPaint.ascent()) / 2.0f) - textPaint.descent());
        } else {
            this.f13635m = rect2.bottom;
        }
        int i13 = absoluteGravity2 & 7;
        if (i13 == 1) {
            this.f13637o = rect2.centerX() - (fMeasureText2 / 2.0f);
        } else if (i13 != 5) {
            this.f13637o = rect2.left;
        } else {
            this.f13637o = rect2.right - fMeasureText2;
        }
        Bitmap bitmap = this.f13643v;
        if (bitmap != null) {
            bitmap.recycle();
            this.f13643v = null;
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
            float r0 = r2.f13626c
            int r0 = java.lang.Float.compare(r3, r0)
            if (r0 == 0) goto L1b
            r2.f13626c = r3
            r2.a()
        L1b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: wa.b.e(float):void");
    }
}

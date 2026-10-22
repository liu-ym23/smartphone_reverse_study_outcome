package W2;

import K.S;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Interpolator;
import c0.C0387b;
import com.stepos.alphame.utils.Property;
import java.util.WeakHashMap;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: A, reason: collision with root package name */
    public Interpolator f1995A;

    /* renamed from: B, reason: collision with root package name */
    public Interpolator f1996B;

    /* renamed from: a, reason: collision with root package name */
    public final View f1997a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1998b;

    /* renamed from: c, reason: collision with root package name */
    public float f1999c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f2000d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f2001e;

    /* renamed from: f, reason: collision with root package name */
    public final RectF f2002f;

    /* renamed from: g, reason: collision with root package name */
    public int f2003g = 16;

    /* renamed from: h, reason: collision with root package name */
    public int f2004h = 16;

    /* renamed from: i, reason: collision with root package name */
    public float f2005i = 15.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f2006j = 15.0f;

    /* renamed from: k, reason: collision with root package name */
    public int f2007k;

    /* renamed from: l, reason: collision with root package name */
    public int f2008l;

    /* renamed from: m, reason: collision with root package name */
    public float f2009m;

    /* renamed from: n, reason: collision with root package name */
    public float f2010n;

    /* renamed from: o, reason: collision with root package name */
    public float f2011o;

    /* renamed from: p, reason: collision with root package name */
    public float f2012p;

    /* renamed from: q, reason: collision with root package name */
    public float f2013q;

    /* renamed from: r, reason: collision with root package name */
    public float f2014r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f2015s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f2016t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2017u;

    /* renamed from: v, reason: collision with root package name */
    public Bitmap f2018v;

    /* renamed from: w, reason: collision with root package name */
    public float f2019w;

    /* renamed from: x, reason: collision with root package name */
    public float f2020x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f2021y;

    /* renamed from: z, reason: collision with root package name */
    public final TextPaint f2022z;

    public b(View view) {
        this.f1997a = view;
        TextPaint textPaint = new TextPaint();
        this.f2022z = textPaint;
        textPaint.setAntiAlias(true);
        this.f2001e = new Rect();
        this.f2000d = new Rect();
        this.f2002f = new RectF();
    }

    public static float b(float f4, float f5, float f6, Interpolator interpolator) {
        if (interpolator != null) {
            f6 = interpolator.getInterpolation(f6);
        }
        C0387b c0387b = a.f1994a;
        return AbstractC0831a.c(f5, f4, f6, f4);
    }

    public final void a() {
        float fWidth;
        float f4;
        boolean z4;
        float f5 = this.f1999c;
        RectF rectF = this.f2002f;
        Rect rect = this.f2000d;
        float f6 = rect.left;
        Rect rect2 = this.f2001e;
        rectF.left = b(f6, rect2.left, f5, this.f1995A);
        rectF.top = b(this.f2009m, this.f2010n, f5, this.f1995A);
        rectF.right = b(rect.right, rect2.right, f5, this.f1995A);
        rectF.bottom = b(rect.bottom, rect2.bottom, f5, this.f1995A);
        this.f2013q = b(this.f2011o, this.f2012p, f5, this.f1995A);
        this.f2014r = b(this.f2009m, this.f2010n, f5, this.f1995A);
        float fB = b(this.f2005i, this.f2006j, f5, this.f1996B);
        CharSequence charSequence = this.f2015s;
        TextPaint textPaint = this.f2022z;
        View view = this.f1997a;
        if (charSequence != null) {
            if (Math.abs(fB - this.f2006j) < 0.001f) {
                fWidth = rect2.width();
                f4 = this.f2006j;
                this.f2019w = 1.0f;
            } else {
                float fWidth2 = rect.width();
                float f7 = this.f2005i;
                if (Math.abs(fB - f7) < 0.001f) {
                    this.f2019w = 1.0f;
                } else {
                    this.f2019w = fB / this.f2005i;
                }
                fWidth = fWidth2;
                f4 = f7;
            }
            if (fWidth > Property.DEFAULT_FLOAT_VALUE) {
                z4 = Float.compare(this.f2020x, f4) != 0 || this.f2021y;
                this.f2020x = f4;
                this.f2021y = false;
            } else {
                z4 = false;
            }
            if (this.f2016t == null || z4) {
                textPaint.setTextSize(this.f2020x);
                CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.f2015s, textPaint, fWidth, TextUtils.TruncateAt.END);
                CharSequence charSequence2 = this.f2016t;
                if (charSequence2 == null || !charSequence2.equals(charSequenceEllipsize)) {
                    this.f2016t = charSequenceEllipsize;
                }
                WeakHashMap weakHashMap = S.f939a;
                this.f2017u = view.getLayoutDirection() == 1;
            }
            WeakHashMap weakHashMap2 = S.f939a;
            view.postInvalidateOnAnimation();
        }
        int i4 = this.f2008l;
        if (i4 != this.f2007k) {
            float f8 = 1.0f - f5;
            textPaint.setColor(Color.argb((int) ((Color.alpha(i4) * f5) + (Color.alpha(r9) * f8)), (int) ((Color.red(i4) * f5) + (Color.red(r9) * f8)), (int) ((Color.green(i4) * f5) + (Color.green(r9) * f8)), (int) ((Color.blue(i4) * f5) + (Color.blue(r9) * f8))));
        } else {
            textPaint.setColor(i4);
        }
        WeakHashMap weakHashMap3 = S.f939a;
        view.postInvalidateOnAnimation();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            r2 = this;
            android.graphics.Rect r0 = r2.f2001e
            int r1 = r0.width()
            if (r1 <= 0) goto L1e
            int r0 = r0.height()
            if (r0 <= 0) goto L1e
            android.graphics.Rect r0 = r2.f2000d
            int r1 = r0.width()
            if (r1 <= 0) goto L1e
            int r0 = r0.height()
            if (r0 <= 0) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            r2.f1998b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: W2.b.c():void");
    }

    public final void d() {
        View view = this.f1997a;
        if (view.getHeight() <= 0 || view.getWidth() <= 0) {
            return;
        }
        TextPaint textPaint = this.f2022z;
        textPaint.setTextSize(this.f2006j);
        CharSequence charSequence = this.f2016t;
        float fMeasureText = Property.DEFAULT_FLOAT_VALUE;
        float fMeasureText2 = charSequence != null ? textPaint.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f2004h, this.f2017u ? 1 : 0);
        int i4 = absoluteGravity & 112;
        Rect rect = this.f2001e;
        if (i4 == 48) {
            this.f2010n = rect.top - textPaint.ascent();
        } else if (i4 != 80) {
            this.f2010n = rect.centerY() + (((textPaint.descent() - textPaint.ascent()) / 2.0f) - textPaint.descent());
        } else {
            this.f2010n = rect.bottom;
        }
        int i5 = absoluteGravity & 7;
        if (i5 == 1) {
            this.f2012p = rect.centerX() - (fMeasureText2 / 2.0f);
        } else if (i5 != 5) {
            this.f2012p = rect.left;
        } else {
            this.f2012p = rect.right - fMeasureText2;
        }
        textPaint.setTextSize(this.f2005i);
        CharSequence charSequence2 = this.f2016t;
        if (charSequence2 != null) {
            fMeasureText = textPaint.measureText(charSequence2, 0, charSequence2.length());
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f2003g, this.f2017u ? 1 : 0);
        int i6 = absoluteGravity2 & 112;
        Rect rect2 = this.f2000d;
        if (i6 == 48) {
            this.f2009m = rect2.top - textPaint.ascent();
        } else if (i6 != 80) {
            this.f2009m = rect2.centerY() + (((textPaint.descent() - textPaint.ascent()) / 2.0f) - textPaint.descent());
        } else {
            this.f2009m = rect2.bottom;
        }
        int i7 = absoluteGravity2 & 7;
        if (i7 == 1) {
            this.f2011o = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i7 != 5) {
            this.f2011o = rect2.left;
        } else {
            this.f2011o = rect2.right - fMeasureText;
        }
        Bitmap bitmap = this.f2018v;
        if (bitmap != null) {
            bitmap.recycle();
            this.f2018v = null;
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
            float r0 = r2.f1999c
            int r0 = java.lang.Float.compare(r3, r0)
            if (r0 == 0) goto L1b
            r2.f1999c = r3
            r2.a()
        L1b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: W2.b.e(float):void");
    }
}

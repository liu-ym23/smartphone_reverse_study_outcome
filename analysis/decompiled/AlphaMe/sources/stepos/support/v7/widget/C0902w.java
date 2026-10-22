package stepos.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Interpolator;
import c0.C0386a;
import com.stepos.alphame.utils.Property;
import g.AbstractC0560a;
import java.util.WeakHashMap;
import s.AbstractC0831a;

/* renamed from: stepos.support.v7.widget.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0902w implements J {

    /* renamed from: A, reason: collision with root package name */
    public float f15161A;

    /* renamed from: B, reason: collision with root package name */
    public int[] f15162B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f15163C;

    /* renamed from: E, reason: collision with root package name */
    public Interpolator f15165E;

    /* renamed from: F, reason: collision with root package name */
    public float f15166F;

    /* renamed from: G, reason: collision with root package name */
    public float f15167G;

    /* renamed from: H, reason: collision with root package name */
    public float f15168H;

    /* renamed from: I, reason: collision with root package name */
    public int f15169I;

    /* renamed from: J, reason: collision with root package name */
    public float f15170J;

    /* renamed from: K, reason: collision with root package name */
    public float f15171K;

    /* renamed from: L, reason: collision with root package name */
    public float f15172L;

    /* renamed from: M, reason: collision with root package name */
    public int f15173M;

    /* renamed from: N, reason: collision with root package name */
    public float f15174N;

    /* renamed from: a, reason: collision with root package name */
    public final View f15175a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15176b;

    /* renamed from: c, reason: collision with root package name */
    public float f15177c;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f15185k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f15186l;

    /* renamed from: m, reason: collision with root package name */
    public float f15187m;

    /* renamed from: n, reason: collision with root package name */
    public float f15188n;

    /* renamed from: o, reason: collision with root package name */
    public float f15189o;

    /* renamed from: p, reason: collision with root package name */
    public float f15190p;

    /* renamed from: q, reason: collision with root package name */
    public float f15191q;

    /* renamed from: r, reason: collision with root package name */
    public float f15192r;

    /* renamed from: s, reason: collision with root package name */
    public Typeface f15193s;

    /* renamed from: t, reason: collision with root package name */
    public Typeface f15194t;

    /* renamed from: u, reason: collision with root package name */
    public Typeface f15195u;

    /* renamed from: v, reason: collision with root package name */
    public CharSequence f15196v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f15197w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f15198x;

    /* renamed from: y, reason: collision with root package name */
    public Bitmap f15199y;

    /* renamed from: z, reason: collision with root package name */
    public float f15200z;

    /* renamed from: g, reason: collision with root package name */
    public int f15181g = 16;

    /* renamed from: h, reason: collision with root package name */
    public int f15182h = 16;

    /* renamed from: i, reason: collision with root package name */
    public float f15183i = 15.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f15184j = 15.0f;

    /* renamed from: D, reason: collision with root package name */
    public final TextPaint f15164D = new TextPaint(129);

    /* renamed from: e, reason: collision with root package name */
    public final Rect f15179e = new Rect();

    /* renamed from: d, reason: collision with root package name */
    public final Rect f15178d = new Rect();

    /* renamed from: f, reason: collision with root package name */
    public final RectF f15180f = new RectF();

    public C0902w(StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout) {
        this.f15175a = stepOSCollapsingToolbarLayout;
    }

    public static boolean c(Typeface typeface, Typeface typeface2) {
        return !(typeface == null || typeface.equals(typeface2)) || (typeface == null && typeface2 != null);
    }

    public static int d(float f4, int i4, int i5) {
        float f5 = 1.0f - f4;
        return Color.argb((int) ((Color.alpha(i5) * f4) + (Color.alpha(i4) * f5)), (int) ((Color.red(i5) * f4) + (Color.red(i4) * f5)), (int) ((Color.green(i5) * f4) + (Color.green(i4) * f5)), (int) ((Color.blue(i5) * f4) + (Color.blue(i4) * f5)));
    }

    public static boolean f(float f4, float f5) {
        return Math.abs(f4 - f5) < 0.001f;
    }

    public static float g(float f4, float f5, float f6, Interpolator interpolator) {
        if (interpolator != null) {
            f6 = interpolator.getInterpolation(f6);
        }
        C0386a c0386a = AbstractC0901v.f15154a;
        return AbstractC0831a.c(f5, f4, f6, f4);
    }

    @Override // stepos.support.v7.widget.J
    public final void a() {
        this.f15174N = Property.DEFAULT_FLOAT_VALUE;
    }

    @Override // stepos.support.v7.widget.J
    public final void b() {
        if (f(this.f15177c, 1.0f)) {
            this.f15200z = 1.0f;
            this.f15161A = this.f15184j;
        } else if (f(this.f15177c, Property.DEFAULT_FLOAT_VALUE)) {
            this.f15200z = 1.0f;
            this.f15161A = this.f15183i;
        }
        TextPaint textPaint = this.f15164D;
        textPaint.setTextSize(this.f15161A);
        Log.i("[Collapsing]", "releaseTitleScale after mScale:" + this.f15200z + ",mCurrentTextSize:" + this.f15161A + ",mExpandedFraction:" + this.f15177c + ",paint text size:" + textPaint.getTextSize());
    }

    public final void e(float f4) {
        boolean z4;
        float f5;
        boolean z5;
        if (this.f15196v == null) {
            return;
        }
        float fWidth = this.f15179e.width();
        float fWidth2 = this.f15178d.width();
        if (f(f4, this.f15184j)) {
            f5 = this.f15184j;
            this.f15200z = 1.0f;
            if (c(this.f15195u, this.f15193s)) {
                this.f15195u = this.f15193s;
                z5 = true;
            } else {
                z5 = false;
            }
        } else {
            float f6 = this.f15183i;
            if (c(this.f15195u, this.f15194t)) {
                this.f15195u = this.f15194t;
                z4 = true;
            } else {
                z4 = false;
            }
            if (f(f4, this.f15183i)) {
                this.f15200z = 1.0f;
            } else {
                this.f15200z = f4 / this.f15183i;
            }
            float f7 = this.f15184j / this.f15183i;
            fWidth = fWidth2 * f7 > fWidth ? Math.min(fWidth / f7, fWidth2) : fWidth2;
            f5 = f6;
            z5 = z4;
        }
        if (fWidth > Property.DEFAULT_FLOAT_VALUE) {
            z5 = this.f15161A != f5 || this.f15163C || z5;
            this.f15161A = f5;
            this.f15163C = false;
        }
        if (this.f15197w == null || z5) {
            TextPaint textPaint = this.f15164D;
            textPaint.setTextSize(this.f15161A);
            textPaint.setTypeface(this.f15195u);
            textPaint.setLinearText(this.f15200z != 1.0f);
            CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.f15196v, textPaint, fWidth, TextUtils.TruncateAt.END);
            if (TextUtils.equals(charSequenceEllipsize, this.f15197w)) {
                return;
            }
            this.f15197w = charSequenceEllipsize;
            WeakHashMap weakHashMap = K.S.f939a;
            this.f15198x = (this.f15175a.getLayoutDirection() == 1 ? I.j.f830d : I.j.f829c).f(charSequenceEllipsize, charSequenceEllipsize.length());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            r2 = this;
            android.graphics.Rect r0 = r2.f15179e
            int r1 = r0.width()
            if (r1 <= 0) goto L1e
            int r0 = r0.height()
            if (r0 <= 0) goto L1e
            android.graphics.Rect r0 = r2.f15178d
            int r1 = r0.width()
            if (r1 <= 0) goto L1e
            int r0 = r0.height()
            if (r0 <= 0) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            r2.f15176b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.C0902w.h():void");
    }

    public final Typeface i(int i4) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = this.f15175a.getContext().obtainStyledAttributes(i4, new int[]{R.attr.fontFamily});
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

    public final void j() {
        View view = this.f15175a;
        if (view.getHeight() <= 0 || view.getWidth() <= 0) {
            return;
        }
        float f4 = this.f15161A;
        e(this.f15184j);
        CharSequence charSequence = this.f15197w;
        TextPaint textPaint = this.f15164D;
        float fMeasureText = Property.DEFAULT_FLOAT_VALUE;
        float fMeasureText2 = charSequence != null ? textPaint.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f15182h, this.f15198x ? 1 : 0);
        int i4 = absoluteGravity & 112;
        Rect rect = this.f15179e;
        if (i4 == 48) {
            this.f15188n = rect.top - textPaint.ascent();
        } else if (i4 != 80) {
            this.f15188n = rect.centerY() + (((textPaint.descent() - textPaint.ascent()) / 2.0f) - textPaint.descent());
        } else {
            this.f15188n = rect.bottom;
        }
        int i5 = absoluteGravity & 8388615;
        if (i5 == 1) {
            this.f15190p = rect.centerX() - (fMeasureText2 / 2.0f);
        } else if (i5 != 5) {
            this.f15190p = rect.left;
        } else {
            this.f15190p = rect.right - fMeasureText2;
        }
        e(this.f15183i);
        CharSequence charSequence2 = this.f15197w;
        if (charSequence2 != null) {
            fMeasureText = textPaint.measureText(charSequence2, 0, charSequence2.length());
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f15181g, this.f15198x ? 1 : 0);
        int i6 = absoluteGravity2 & 112;
        Rect rect2 = this.f15178d;
        if (i6 == 48) {
            this.f15187m = rect2.top - textPaint.ascent();
        } else if (i6 != 80) {
            this.f15187m = rect2.centerY() + (((textPaint.descent() - textPaint.ascent()) / 2.0f) - textPaint.descent());
        } else {
            this.f15187m = rect2.bottom;
        }
        int i7 = absoluteGravity2 & 8388615;
        if (i7 == 1) {
            this.f15189o = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i7 != 5) {
            this.f15189o = rect2.left;
        } else {
            this.f15189o = rect2.right - fMeasureText;
        }
        Bitmap bitmap = this.f15199y;
        if (bitmap != null) {
            bitmap.recycle();
            this.f15199y = null;
        }
        m(f4);
        float f5 = this.f15177c;
        RectF rectF = this.f15180f;
        rectF.left = g(rect2.left, rect.left, f5, null);
        rectF.top = g(this.f15187m, this.f15188n, f5, null);
        rectF.right = g(rect2.right, rect.right, f5, null);
        rectF.bottom = g(rect2.bottom, rect.bottom, f5, null);
        this.f15191q = g(this.f15189o, this.f15190p, f5, null);
        this.f15192r = g(this.f15187m, this.f15188n, f5, null);
        m(g(this.f15183i, this.f15184j, f5, this.f15165E));
        ColorStateList colorStateList = this.f15186l;
        ColorStateList colorStateList2 = this.f15185k;
        if (colorStateList != colorStateList2) {
            int[] iArr = this.f15162B;
            int colorForState = iArr != null ? colorStateList2.getColorForState(iArr, 0) : colorStateList2.getDefaultColor();
            int[] iArr2 = this.f15162B;
            textPaint.setColor(d(f5, colorForState, iArr2 != null ? this.f15186l.getColorForState(iArr2, 0) : this.f15186l.getDefaultColor()));
        } else {
            int[] iArr3 = this.f15162B;
            textPaint.setColor(iArr3 != null ? colorStateList.getColorForState(iArr3, 0) : colorStateList.getDefaultColor());
        }
        textPaint.setShadowLayer(g(this.f15170J, this.f15166F, f5, null), g(this.f15171K, this.f15167G, f5, null), g(this.f15172L, this.f15168H, f5, null), d(f5, this.f15173M, this.f15169I));
        WeakHashMap weakHashMap = K.S.f939a;
        view.postInvalidateOnAnimation();
    }

    public final void k(int i4) {
        Context context = this.f15175a.getContext();
        android.support.v4.media.session.c cVar = new android.support.v4.media.session.c(context, context.obtainStyledAttributes(i4, AbstractC0560a.f12610w));
        if (cVar.v(3)) {
            this.f15186l = cVar.h(3);
        }
        if (cVar.v(0)) {
            this.f15184j = cVar.j(0, (int) this.f15184j);
        }
        this.f15169I = cVar.p(6, 0);
        this.f15167G = cVar.n(Property.DEFAULT_FLOAT_VALUE, 7);
        this.f15168H = cVar.n(Property.DEFAULT_FLOAT_VALUE, 8);
        this.f15166F = cVar.n(Property.DEFAULT_FLOAT_VALUE, 9);
        cVar.A();
        this.f15193s = i(i4);
        j();
    }

    public final void l(int i4) {
        Context context = this.f15175a.getContext();
        android.support.v4.media.session.c cVar = new android.support.v4.media.session.c(context, context.obtainStyledAttributes(i4, AbstractC0560a.f12610w));
        if (cVar.v(3)) {
            this.f15185k = cVar.h(3);
        }
        if (cVar.v(0)) {
            this.f15183i = cVar.j(0, (int) this.f15183i);
        }
        this.f15173M = cVar.p(6, 0);
        this.f15171K = cVar.n(Property.DEFAULT_FLOAT_VALUE, 7);
        this.f15172L = cVar.n(Property.DEFAULT_FLOAT_VALUE, 8);
        this.f15170J = cVar.n(Property.DEFAULT_FLOAT_VALUE, 9);
        cVar.A();
        this.f15194t = i(i4);
        j();
    }

    public final void m(float f4) {
        e(f4);
        WeakHashMap weakHashMap = K.S.f939a;
        this.f15175a.postInvalidateOnAnimation();
    }

    public final void n(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f15196v)) {
            this.f15196v = charSequence;
            this.f15197w = null;
            Bitmap bitmap = this.f15199y;
            if (bitmap != null) {
                bitmap.recycle();
                this.f15199y = null;
            }
            j();
        }
    }
}

package stepos.support.v7.widget;

import android.R;
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
import android.view.animation.Interpolator;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;

/* loaded from: classes4.dex */
public final class A implements O {

    /* renamed from: A, reason: collision with root package name */
    public float f6380A;

    /* renamed from: B, reason: collision with root package name */
    public int[] f6381B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f6382C;
    public Interpolator E;

    /* renamed from: F, reason: collision with root package name */
    public float f6384F;

    /* renamed from: G, reason: collision with root package name */
    public float f6385G;

    /* renamed from: H, reason: collision with root package name */
    public float f6386H;

    /* renamed from: I, reason: collision with root package name */
    public int f6387I;

    /* renamed from: J, reason: collision with root package name */
    public float f6388J;

    /* renamed from: K, reason: collision with root package name */
    public float f6389K;

    /* renamed from: L, reason: collision with root package name */
    public float f6390L;

    /* renamed from: M, reason: collision with root package name */
    public int f6391M;

    /* renamed from: a, reason: collision with root package name */
    public final StepOSCollapsingToolbarLayout f6392a;
    public boolean b;
    public float c;
    public ColorStateList k;
    public ColorStateList l;
    public float m;
    public float n;
    public float o;
    public float p;

    /* renamed from: q, reason: collision with root package name */
    public float f6394q;

    /* renamed from: r, reason: collision with root package name */
    public float f6395r;

    /* renamed from: s, reason: collision with root package name */
    public Typeface f6396s;

    /* renamed from: t, reason: collision with root package name */
    public Typeface f6397t;
    public Typeface u;

    /* renamed from: v, reason: collision with root package name */
    public CharSequence f6398v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f6399w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f6400x;
    public Bitmap y;

    /* renamed from: z, reason: collision with root package name */
    public float f6401z;
    public int g = 16;
    public int h = 16;
    public float i = 15.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f6393j = 15.0f;

    /* renamed from: D, reason: collision with root package name */
    public final TextPaint f6383D = new TextPaint(129);
    public final Rect e = new Rect();
    public final Rect d = new Rect();
    public final RectF f = new RectF();

    public A(StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout) {
        this.f6392a = stepOSCollapsingToolbarLayout;
    }

    public static boolean c(Typeface typeface, Typeface typeface2) {
        if (typeface == null || typeface.equals(typeface2)) {
            return typeface == null && typeface2 != null;
        }
        return true;
    }

    public static int d(float f, int i, int i6) {
        float f7 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i6) * f) + (Color.alpha(i) * f7)), (int) ((Color.red(i6) * f) + (Color.red(i) * f7)), (int) ((Color.green(i6) * f) + (Color.green(i) * f7)), (int) ((Color.blue(i6) * f) + (Color.blue(i) * f7)));
    }

    public static boolean f(float f, float f7) {
        return Math.abs(f - f7) < 0.001f;
    }

    public static float g(float f, float f7, float f9, Interpolator interpolator) {
        if (interpolator != null) {
            f9 = interpolator.getInterpolation(f9);
        }
        FastOutLinearInInterpolator fastOutLinearInInterpolator = AbstractC2010z.f6648a;
        return B7.a.b(f7, f, f9, f);
    }

    @Override // stepos.support.v7.widget.O
    public final void a() {
        if (f(this.c, 1.0f)) {
            this.f6401z = 1.0f;
            this.f6380A = this.f6393j;
        } else if (f(this.c, 0.0f)) {
            this.f6401z = 1.0f;
            this.f6380A = this.i;
        }
        float f = this.f6380A;
        TextPaint textPaint = this.f6383D;
        textPaint.setTextSize(f);
        Log.i("[Collapsing]", "releaseTitleScale after mScale:" + this.f6401z + ",mCurrentTextSize:" + this.f6380A + ",mExpandedFraction:" + this.c + ",paint text size:" + textPaint.getTextSize());
    }

    @Override // stepos.support.v7.widget.O
    public final void b() {
    }

    public final void e(float f) {
        boolean z10;
        float f7;
        boolean z11;
        if (this.f6398v == null) {
            return;
        }
        float fWidth = this.e.width();
        float fWidth2 = this.d.width();
        if (f(f, this.f6393j)) {
            f7 = this.f6393j;
            this.f6401z = 1.0f;
            if (c(this.u, this.f6396s)) {
                this.u = this.f6396s;
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            float f9 = this.i;
            if (c(this.u, this.f6397t)) {
                this.u = this.f6397t;
                z10 = true;
            } else {
                z10 = false;
            }
            if (f(f, this.i)) {
                this.f6401z = 1.0f;
            } else {
                this.f6401z = f / this.i;
            }
            float f10 = this.f6393j / this.i;
            fWidth = fWidth2 * f10 > fWidth ? Math.min(fWidth / f10, fWidth2) : fWidth2;
            f7 = f9;
            z11 = z10;
        }
        if (fWidth > 0.0f) {
            z11 = this.f6380A != f7 || this.f6382C || z11;
            this.f6380A = f7;
            this.f6382C = false;
        }
        if (this.f6399w == null || z11) {
            float f11 = this.f6380A;
            TextPaint textPaint = this.f6383D;
            textPaint.setTextSize(f11);
            textPaint.setTypeface(this.u);
            textPaint.setLinearText(this.f6401z != 1.0f);
            CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.f6398v, textPaint, fWidth, TextUtils.TruncateAt.END);
            if (TextUtils.equals(charSequenceEllipsize, this.f6399w)) {
                return;
            }
            this.f6399w = charSequenceEllipsize;
            this.f6400x = (ViewCompat.getLayoutDirection(this.f6392a) == 1 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequenceEllipsize, 0, charSequenceEllipsize.length());
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
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.A.h():void");
    }

    public final Typeface i(int i) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = this.f6392a.getContext().obtainStyledAttributes(i, new int[]{R.attr.fontFamily});
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
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f6392a;
        if (stepOSCollapsingToolbarLayout.getHeight() <= 0 || stepOSCollapsingToolbarLayout.getWidth() <= 0) {
            return;
        }
        float f = this.f6380A;
        e(this.f6393j);
        CharSequence charSequence = this.f6399w;
        TextPaint textPaint = this.f6383D;
        float fMeasureText = charSequence != null ? textPaint.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.h, this.f6400x ? 1 : 0);
        int i = absoluteGravity & 112;
        Rect rect = this.e;
        if (i == 48) {
            this.n = rect.top - textPaint.ascent();
        } else if (i != 80) {
            this.n = rect.centerY() + (((textPaint.descent() - textPaint.ascent()) / 2.0f) - textPaint.descent());
        } else {
            this.n = rect.bottom;
        }
        int i6 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i6 == 1) {
            this.p = rect.centerX() - (fMeasureText / 2.0f);
        } else if (i6 != 5) {
            this.p = rect.left;
        } else {
            this.p = rect.right - fMeasureText;
        }
        e(this.i);
        CharSequence charSequence2 = this.f6399w;
        float fMeasureText2 = charSequence2 != null ? textPaint.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.g, this.f6400x ? 1 : 0);
        int i10 = absoluteGravity2 & 112;
        Rect rect2 = this.d;
        if (i10 == 48) {
            this.m = rect2.top - textPaint.ascent();
        } else if (i10 != 80) {
            this.m = rect2.centerY() + (((textPaint.descent() - textPaint.ascent()) / 2.0f) - textPaint.descent());
        } else {
            this.m = rect2.bottom;
        }
        int i11 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i11 == 1) {
            this.o = rect2.centerX() - (fMeasureText2 / 2.0f);
        } else if (i11 != 5) {
            this.o = rect2.left;
        } else {
            this.o = rect2.right - fMeasureText2;
        }
        Bitmap bitmap = this.y;
        if (bitmap != null) {
            bitmap.recycle();
            this.y = null;
        }
        m(f);
        float f7 = this.c;
        float fG = g(rect2.left, rect.left, f7, null);
        RectF rectF = this.f;
        rectF.left = fG;
        rectF.top = g(this.m, this.n, f7, null);
        rectF.right = g(rect2.right, rect.right, f7, null);
        rectF.bottom = g(rect2.bottom, rect.bottom, f7, null);
        this.f6394q = g(this.o, this.p, f7, null);
        this.f6395r = g(this.m, this.n, f7, null);
        m(g(this.i, this.f6393j, f7, this.E));
        ColorStateList colorStateList = this.l;
        ColorStateList colorStateList2 = this.k;
        if (colorStateList != colorStateList2) {
            int[] iArr = this.f6381B;
            int colorForState = iArr != null ? colorStateList2.getColorForState(iArr, 0) : colorStateList2.getDefaultColor();
            int[] iArr2 = this.f6381B;
            textPaint.setColor(d(f7, colorForState, iArr2 != null ? this.l.getColorForState(iArr2, 0) : this.l.getDefaultColor()));
        } else {
            int[] iArr3 = this.f6381B;
            textPaint.setColor(iArr3 != null ? colorStateList.getColorForState(iArr3, 0) : colorStateList.getDefaultColor());
        }
        textPaint.setShadowLayer(g(this.f6388J, this.f6384F, f7, null), g(this.f6389K, this.f6385G, f7, null), g(this.f6390L, this.f6386H, f7, null), d(f7, this.f6391M, this.f6387I));
        ViewCompat.postInvalidateOnAnimation(stepOSCollapsingToolbarLayout);
    }

    public final void k(int i) {
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f6392a.getContext(), i, androidx.appcompat.R.styleable.TextAppearance);
        if (tintTypedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.TextAppearance_android_textColor)) {
            this.l = tintTypedArrayObtainStyledAttributes.getColorStateList(androidx.appcompat.R.styleable.TextAppearance_android_textColor);
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.TextAppearance_android_textSize)) {
            this.f6393j = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, (int) this.f6393j);
        }
        this.f6387I = tintTypedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.TextAppearance_android_shadowColor, 0);
        this.f6385G = tintTypedArrayObtainStyledAttributes.getFloat(androidx.appcompat.R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f6386H = tintTypedArrayObtainStyledAttributes.getFloat(androidx.appcompat.R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f6384F = tintTypedArrayObtainStyledAttributes.getFloat(androidx.appcompat.R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        tintTypedArrayObtainStyledAttributes.recycle();
        this.f6396s = i(i);
        j();
    }

    public final void l(int i) {
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f6392a.getContext(), i, androidx.appcompat.R.styleable.TextAppearance);
        if (tintTypedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.TextAppearance_android_textColor)) {
            this.k = tintTypedArrayObtainStyledAttributes.getColorStateList(androidx.appcompat.R.styleable.TextAppearance_android_textColor);
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.TextAppearance_android_textSize)) {
            this.i = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, (int) this.i);
        }
        this.f6391M = tintTypedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.TextAppearance_android_shadowColor, 0);
        this.f6389K = tintTypedArrayObtainStyledAttributes.getFloat(androidx.appcompat.R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f6390L = tintTypedArrayObtainStyledAttributes.getFloat(androidx.appcompat.R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f6388J = tintTypedArrayObtainStyledAttributes.getFloat(androidx.appcompat.R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        tintTypedArrayObtainStyledAttributes.recycle();
        this.f6397t = i(i);
        j();
    }

    public final void m(float f) {
        e(f);
        ViewCompat.postInvalidateOnAnimation(this.f6392a);
    }

    public final void n(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f6398v)) {
            this.f6398v = charSequence;
            this.f6399w = null;
            Bitmap bitmap = this.y;
            if (bitmap != null) {
                bitmap.recycle();
                this.y = null;
            }
            j();
        }
    }
}

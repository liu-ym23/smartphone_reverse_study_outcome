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
import java.util.WeakHashMap;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements o {
    public boolean A;
    public Bitmap B;
    public float C;
    public float D;
    public int[] E;
    public boolean F;
    public Interpolator H;
    public float I;
    public float J;
    public float K;
    public int L;
    public float M;
    public float N;
    public float O;
    public int P;

    /* renamed from: a, reason: collision with root package name */
    public final e f12711a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12712b;

    /* renamed from: c, reason: collision with root package name */
    public float f12713c;

    /* renamed from: n, reason: collision with root package name */
    public ColorStateList f12720n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f12721o;

    /* renamed from: p, reason: collision with root package name */
    public float f12722p;

    /* renamed from: q, reason: collision with root package name */
    public float f12723q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public float f12724s;

    /* renamed from: t, reason: collision with root package name */
    public float f12725t;

    /* renamed from: u, reason: collision with root package name */
    public float f12726u;

    /* renamed from: v, reason: collision with root package name */
    public Typeface f12727v;

    /* renamed from: w, reason: collision with root package name */
    public Typeface f12728w;

    /* renamed from: x, reason: collision with root package name */
    public Typeface f12729x;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f12730y;
    public CharSequence z;

    /* renamed from: j, reason: collision with root package name */
    public int f12716j = 16;

    /* renamed from: k, reason: collision with root package name */
    public int f12717k = 16;

    /* renamed from: l, reason: collision with root package name */
    public float f12718l = 15.0f;

    /* renamed from: m, reason: collision with root package name */
    public float f12719m = 15.0f;
    public final TextPaint G = new TextPaint(129);

    /* renamed from: e, reason: collision with root package name */
    public final Rect f12715e = new Rect();

    /* renamed from: d, reason: collision with root package name */
    public final Rect f12714d = new Rect();
    public final RectF h = new RectF();

    public d(e eVar) {
        this.f12711a = eVar;
    }

    public static boolean a(Typeface typeface, Typeface typeface2) {
        if (typeface == null || typeface.equals(typeface2)) {
            return typeface == null && typeface2 != null;
        }
        return true;
    }

    public static int c(float f8, int i10, int i11) {
        float f9 = 1.0f - f8;
        return Color.argb((int) ((Color.alpha(i11) * f8) + (Color.alpha(i10) * f9)), (int) ((Color.red(i11) * f8) + (Color.red(i10) * f9)), (int) ((Color.green(i11) * f8) + (Color.green(i10) * f9)), (int) ((Color.blue(i11) * f8) + (Color.blue(i10) * f9)));
    }

    public static boolean f(float f8, float f9) {
        return Math.abs(f8 - f9) < 0.001f;
    }

    public static float g(float f8, float f9, float f10, Interpolator interpolator) {
        if (interpolator != null) {
            f10 = interpolator.getInterpolation(f10);
        }
        o1.a aVar = c.f12706a;
        return h0.e.a(f9, f8, f10, f8);
    }

    @Override // stepos.support.v7.widget.o
    public final void b() {
        if (f(this.f12713c, 1.0f)) {
            this.C = 1.0f;
            this.D = this.f12719m;
        } else if (f(this.f12713c, 0.0f)) {
            this.C = 1.0f;
            this.D = this.f12718l;
        }
        float f8 = this.D;
        TextPaint textPaint = this.G;
        textPaint.setTextSize(f8);
        Log.i("[Collapsing]", "releaseTitleScale after mScale:" + this.C + ",mCurrentTextSize:" + this.D + ",mExpandedFraction:" + this.f12713c + ",paint text size:" + textPaint.getTextSize());
    }

    public final void e(float f8) {
        boolean z;
        float f9;
        boolean z3;
        if (this.f12730y == null) {
            return;
        }
        float fWidth = this.f12715e.width();
        float fWidth2 = this.f12714d.width();
        if (f(f8, this.f12719m)) {
            f9 = this.f12719m;
            this.C = 1.0f;
            if (a(this.f12729x, this.f12727v)) {
                this.f12729x = this.f12727v;
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            float f10 = this.f12718l;
            if (a(this.f12729x, this.f12728w)) {
                this.f12729x = this.f12728w;
                z = true;
            } else {
                z = false;
            }
            if (f(f8, this.f12718l)) {
                this.C = 1.0f;
            } else {
                this.C = f8 / this.f12718l;
            }
            float f11 = this.f12719m / this.f12718l;
            fWidth = fWidth2 * f11 > fWidth ? Math.min(fWidth / f11, fWidth2) : fWidth2;
            f9 = f10;
            z3 = z;
        }
        if (fWidth > 0.0f) {
            z3 = this.D != f9 || this.F || z3;
            this.D = f9;
            this.F = false;
        }
        if (this.z == null || z3) {
            float f12 = this.D;
            TextPaint textPaint = this.G;
            textPaint.setTextSize(f12);
            textPaint.setTypeface(this.f12729x);
            textPaint.setLinearText(this.C != 1.0f);
            CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.f12730y, textPaint, fWidth, TextUtils.TruncateAt.END);
            if (TextUtils.equals(charSequenceEllipsize, this.z)) {
                return;
            }
            this.z = charSequenceEllipsize;
            WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
            this.A = (this.f12711a.getLayoutDirection() == 1 ? t0.c.f12915d : t0.c.f12914c).b(charSequenceEllipsize, charSequenceEllipsize.length());
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
            android.graphics.Rect r0 = r2.f12715e
            int r1 = r0.width()
            if (r1 <= 0) goto L1e
            int r0 = r0.height()
            if (r0 <= 0) goto L1e
            android.graphics.Rect r0 = r2.f12714d
            int r1 = r0.width()
            if (r1 <= 0) goto L1e
            int r0 = r0.height()
            if (r0 <= 0) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            r2.f12712b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.d.h():void");
    }

    public final Typeface i(int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = this.f12711a.getContext().obtainStyledAttributes(i10, new int[]{R.attr.fontFamily});
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
        e eVar = this.f12711a;
        if (eVar.getHeight() <= 0 || eVar.getWidth() <= 0) {
            return;
        }
        float f8 = this.D;
        e(this.f12719m);
        CharSequence charSequence = this.z;
        TextPaint textPaint = this.G;
        float fMeasureText = charSequence != null ? textPaint.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f12717k, this.A ? 1 : 0);
        int i10 = absoluteGravity & 112;
        Rect rect = this.f12715e;
        if (i10 == 48) {
            this.f12723q = rect.top - textPaint.ascent();
        } else if (i10 != 80) {
            this.f12723q = rect.centerY() + (((textPaint.descent() - textPaint.ascent()) / 2.0f) - textPaint.descent());
        } else {
            this.f12723q = rect.bottom;
        }
        int i11 = absoluteGravity & 8388615;
        if (i11 == 1) {
            this.f12724s = rect.centerX() - (fMeasureText / 2.0f);
        } else if (i11 != 5) {
            this.f12724s = rect.left;
        } else {
            this.f12724s = rect.right - fMeasureText;
        }
        e(this.f12718l);
        CharSequence charSequence2 = this.z;
        float fMeasureText2 = charSequence2 != null ? textPaint.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f12716j, this.A ? 1 : 0);
        int i12 = absoluteGravity2 & 112;
        Rect rect2 = this.f12714d;
        if (i12 == 48) {
            this.f12722p = rect2.top - textPaint.ascent();
        } else if (i12 != 80) {
            this.f12722p = rect2.centerY() + (((textPaint.descent() - textPaint.ascent()) / 2.0f) - textPaint.descent());
        } else {
            this.f12722p = rect2.bottom;
        }
        int i13 = absoluteGravity2 & 8388615;
        if (i13 == 1) {
            this.r = rect2.centerX() - (fMeasureText2 / 2.0f);
        } else if (i13 != 5) {
            this.r = rect2.left;
        } else {
            this.r = rect2.right - fMeasureText2;
        }
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            bitmap.recycle();
            this.B = null;
        }
        m(f8);
        float f9 = this.f12713c;
        float fG = g(rect2.left, rect.left, f9, null);
        RectF rectF = this.h;
        rectF.left = fG;
        rectF.top = g(this.f12722p, this.f12723q, f9, null);
        rectF.right = g(rect2.right, rect.right, f9, null);
        rectF.bottom = g(rect2.bottom, rect.bottom, f9, null);
        this.f12725t = g(this.r, this.f12724s, f9, null);
        this.f12726u = g(this.f12722p, this.f12723q, f9, null);
        m(g(this.f12718l, this.f12719m, f9, this.H));
        ColorStateList colorStateList = this.f12721o;
        ColorStateList colorStateList2 = this.f12720n;
        if (colorStateList != colorStateList2) {
            int[] iArr = this.E;
            int colorForState = iArr != null ? colorStateList2.getColorForState(iArr, 0) : colorStateList2.getDefaultColor();
            int[] iArr2 = this.E;
            textPaint.setColor(c(f9, colorForState, iArr2 != null ? this.f12721o.getColorForState(iArr2, 0) : this.f12721o.getDefaultColor()));
        } else {
            int[] iArr3 = this.E;
            textPaint.setColor(iArr3 != null ? colorStateList.getColorForState(iArr3, 0) : colorStateList.getDefaultColor());
        }
        textPaint.setShadowLayer(g(this.M, this.I, f9, null), g(this.N, this.J, f9, null), g(this.O, this.K, f9, null), c(f9, this.P, this.L));
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        eVar.postInvalidateOnAnimation();
    }

    public final void k(int i10) throws Resources.NotFoundException {
        ColorStateList colorStateList;
        int resourceId;
        Context context = this.f12711a.getContext();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, g.a.f8941w);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            if (!typedArrayObtainStyledAttributes.hasValue(3) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = androidx.core.content.a.b(resourceId, context)) == null) {
                colorStateList = typedArrayObtainStyledAttributes.getColorStateList(3);
            }
            this.f12721o = colorStateList;
        }
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.f12719m = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, (int) this.f12719m);
        }
        this.L = typedArrayObtainStyledAttributes.getInt(6, 0);
        this.J = typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
        this.K = typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
        this.I = typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        this.f12727v = i(i10);
        j();
    }

    public final void l(int i10) throws Resources.NotFoundException {
        ColorStateList colorStateList;
        int resourceId;
        Context context = this.f12711a.getContext();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, g.a.f8941w);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            if (!typedArrayObtainStyledAttributes.hasValue(3) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = androidx.core.content.a.b(resourceId, context)) == null) {
                colorStateList = typedArrayObtainStyledAttributes.getColorStateList(3);
            }
            this.f12720n = colorStateList;
        }
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.f12718l = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, (int) this.f12718l);
        }
        this.P = typedArrayObtainStyledAttributes.getInt(6, 0);
        this.N = typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
        this.O = typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
        this.M = typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        this.f12728w = i(i10);
        j();
    }

    public final void m(float f8) {
        e(f8);
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        this.f12711a.postInvalidateOnAnimation();
    }

    public final void n(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f12730y)) {
            this.f12730y = charSequence;
            this.z = null;
            Bitmap bitmap = this.B;
            if (bitmap != null) {
                bitmap.recycle();
                this.B = null;
            }
            j();
        }
    }

    @Override // stepos.support.v7.widget.o
    public final void d() {
    }
}

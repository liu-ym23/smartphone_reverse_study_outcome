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
import android.util.Log;
import android.view.Gravity;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class v implements i0 {
    public float A;
    public int[] B;
    public boolean C;
    public TextPaint D;
    public Interpolator E;
    public float F;
    public float G;
    public float H;
    public int I;
    public float J;
    public float K;
    public float L;
    public int M;

    /* renamed from: a, reason: collision with root package name */
    public StepOSCollapsingToolbarLayout f12844a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12845b;

    /* renamed from: c, reason: collision with root package name */
    public float f12846c;

    /* renamed from: d, reason: collision with root package name */
    public Rect f12847d;

    /* renamed from: e, reason: collision with root package name */
    public Rect f12848e;

    /* renamed from: f, reason: collision with root package name */
    public RectF f12849f;

    /* renamed from: g, reason: collision with root package name */
    public int f12850g;

    /* renamed from: h, reason: collision with root package name */
    public int f12851h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public float f12852j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f12853k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f12854l;

    /* renamed from: m, reason: collision with root package name */
    public float f12855m;

    /* renamed from: n, reason: collision with root package name */
    public float f12856n;

    /* renamed from: o, reason: collision with root package name */
    public float f12857o;

    /* renamed from: p, reason: collision with root package name */
    public float f12858p;

    /* renamed from: q, reason: collision with root package name */
    public float f12859q;

    /* renamed from: r, reason: collision with root package name */
    public float f12860r;

    /* renamed from: s, reason: collision with root package name */
    public Typeface f12861s;

    /* renamed from: t, reason: collision with root package name */
    public Typeface f12862t;

    /* renamed from: u, reason: collision with root package name */
    public Typeface f12863u;

    /* renamed from: v, reason: collision with root package name */
    public CharSequence f12864v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f12865w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f12866x;

    /* renamed from: y, reason: collision with root package name */
    public Bitmap f12867y;

    /* renamed from: z, reason: collision with root package name */
    public float f12868z;

    public static boolean c(Typeface typeface, Typeface typeface2) {
        if (typeface == null || typeface.equals(typeface2)) {
            return typeface == null && typeface2 != null;
        }
        return true;
    }

    public static int d(int i, float f5, int i3) {
        float f10 = 1.0f - f5;
        return Color.argb((int) ((Color.alpha(i3) * f5) + (Color.alpha(i) * f10)), (int) ((Color.red(i3) * f5) + (Color.red(i) * f10)), (int) ((Color.green(i3) * f5) + (Color.green(i) * f10)), (int) ((Color.blue(i3) * f5) + (Color.blue(i) * f10)));
    }

    public static boolean f(float f5, float f10) {
        return Math.abs(f5 - f10) < 0.001f;
    }

    public static float g(float f5, float f10, float f11, Interpolator interpolator) {
        if (interpolator != null) {
            f11 = interpolator.getInterpolation(f11);
        }
        e4.a aVar = u.f12836a;
        return k0.a.f(f10, f5, f11, f5);
    }

    @Override // stepos.support.v7.widget.i0
    public final void b() {
        TextPaint textPaint = this.D;
        if (f(this.f12846c, 1.0f)) {
            this.f12868z = 1.0f;
            this.A = this.f12852j;
        } else if (f(this.f12846c, 0.0f)) {
            this.f12868z = 1.0f;
            this.A = this.i;
        }
        textPaint.setTextSize(this.A);
        Log.i("[Collapsing]", "releaseTitleScale after mScale:" + this.f12868z + ",mCurrentTextSize:" + this.A + ",mExpandedFraction:" + this.f12846c + ",paint text size:" + textPaint.getTextSize());
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(float r10) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.v.e(float):void");
    }

    public final void h() {
        Rect rect = this.f12847d;
        Rect rect2 = this.f12848e;
        this.f12845b = rect2.width() > 0 && rect2.height() > 0 && rect.width() > 0 && rect.height() > 0;
    }

    public final Typeface i(int i) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = this.f12844a.getContext().obtainStyledAttributes(i, new int[]{R.attr.fontFamily});
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
        TextPaint textPaint = this.D;
        Rect rect = this.f12848e;
        Rect rect2 = this.f12847d;
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f12844a;
        if (stepOSCollapsingToolbarLayout.getHeight() <= 0 || stepOSCollapsingToolbarLayout.getWidth() <= 0) {
            return;
        }
        float f5 = this.A;
        e(this.f12852j);
        CharSequence charSequence = this.f12865w;
        float fMeasureText = charSequence != null ? textPaint.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f12851h, this.f12866x ? 1 : 0);
        int i = absoluteGravity & 112;
        if (i == 48) {
            this.f12856n = rect.top - textPaint.ascent();
        } else if (i != 80) {
            this.f12856n = rect.centerY() + (((textPaint.descent() - textPaint.ascent()) / 2.0f) - textPaint.descent());
        } else {
            this.f12856n = rect.bottom;
        }
        int i3 = absoluteGravity & 8388615;
        if (i3 == 1) {
            this.f12858p = rect.centerX() - (fMeasureText / 2.0f);
        } else if (i3 != 5) {
            this.f12858p = rect.left;
        } else {
            this.f12858p = rect.right - fMeasureText;
        }
        e(this.i);
        CharSequence charSequence2 = this.f12865w;
        float fMeasureText2 = charSequence2 != null ? textPaint.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f12850g, this.f12866x ? 1 : 0);
        int i10 = absoluteGravity2 & 112;
        if (i10 == 48) {
            this.f12855m = rect2.top - textPaint.ascent();
        } else if (i10 != 80) {
            this.f12855m = rect2.centerY() + (((textPaint.descent() - textPaint.ascent()) / 2.0f) - textPaint.descent());
        } else {
            this.f12855m = rect2.bottom;
        }
        int i11 = absoluteGravity2 & 8388615;
        if (i11 == 1) {
            this.f12857o = rect2.centerX() - (fMeasureText2 / 2.0f);
        } else if (i11 != 5) {
            this.f12857o = rect2.left;
        } else {
            this.f12857o = rect2.right - fMeasureText2;
        }
        Bitmap bitmap = this.f12867y;
        if (bitmap != null) {
            bitmap.recycle();
            this.f12867y = null;
        }
        m(f5);
        float f10 = this.f12846c;
        RectF rectF = this.f12849f;
        rectF.left = g(rect2.left, rect.left, f10, null);
        rectF.top = g(this.f12855m, this.f12856n, f10, null);
        rectF.right = g(rect2.right, rect.right, f10, null);
        rectF.bottom = g(rect2.bottom, rect.bottom, f10, null);
        this.f12859q = g(this.f12857o, this.f12858p, f10, null);
        this.f12860r = g(this.f12855m, this.f12856n, f10, null);
        m(g(this.i, this.f12852j, f10, this.E));
        ColorStateList colorStateList = this.f12854l;
        ColorStateList colorStateList2 = this.f12853k;
        int[] iArr = this.B;
        if (colorStateList != colorStateList2) {
            int colorForState = iArr != null ? colorStateList2.getColorForState(iArr, 0) : colorStateList2.getDefaultColor();
            int[] iArr2 = this.B;
            ColorStateList colorStateList3 = this.f12854l;
            textPaint.setColor(d(colorForState, f10, iArr2 != null ? colorStateList3.getColorForState(iArr2, 0) : colorStateList3.getDefaultColor()));
        } else {
            textPaint.setColor(iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor());
        }
        textPaint.setShadowLayer(g(this.J, this.F, f10, null), g(this.K, this.G, f10, null), g(this.L, this.H, f10, null), d(this.M, f10, this.I));
        WeakHashMap weakHashMap = n3.k0.f8724a;
        stepOSCollapsingToolbarLayout.postInvalidateOnAnimation();
    }

    public final void k(int i) throws Resources.NotFoundException {
        ColorStateList colorStateList;
        int resourceId;
        Context context = this.f12844a.getContext();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, g.a.f4119w);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            if (!typedArrayObtainStyledAttributes.hasValue(3) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = id.k.u(resourceId, context)) == null) {
                colorStateList = typedArrayObtainStyledAttributes.getColorStateList(3);
            }
            this.f12854l = colorStateList;
        }
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.f12852j = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, (int) this.f12852j);
        }
        this.I = typedArrayObtainStyledAttributes.getInt(6, 0);
        this.G = typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
        this.H = typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
        this.F = typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        this.f12861s = i(i);
        j();
    }

    public final void l(int i) throws Resources.NotFoundException {
        ColorStateList colorStateList;
        int resourceId;
        Context context = this.f12844a.getContext();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, g.a.f4119w);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            if (!typedArrayObtainStyledAttributes.hasValue(3) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = id.k.u(resourceId, context)) == null) {
                colorStateList = typedArrayObtainStyledAttributes.getColorStateList(3);
            }
            this.f12853k = colorStateList;
        }
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, (int) this.i);
        }
        this.M = typedArrayObtainStyledAttributes.getInt(6, 0);
        this.K = typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
        this.L = typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
        this.J = typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        this.f12862t = i(i);
        j();
    }

    public final void m(float f5) {
        e(f5);
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f12844a;
        WeakHashMap weakHashMap = n3.k0.f8724a;
        stepOSCollapsingToolbarLayout.postInvalidateOnAnimation();
    }

    public final void n(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f12864v)) {
            this.f12864v = charSequence;
            this.f12865w = null;
            Bitmap bitmap = this.f12867y;
            if (bitmap != null) {
                bitmap.recycle();
                this.f12867y = null;
            }
            j();
        }
    }

    @Override // stepos.support.v7.widget.i0
    public final void a() {
    }
}

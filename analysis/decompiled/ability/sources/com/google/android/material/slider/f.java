package com.google.android.material.slider;

import A6.j;
import D7.N;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import c3.AbstractC0872b;
import c3.AbstractC0873c;
import c3.C0876f;
import com.google.android.material.datepicker.RunnableC0913p;
import com.google.android.material.internal.i;
import com.google.android.material.internal.o;
import com.stepos.ability.R;
import e3.k;
import j3.C1595a;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class f extends View {

    /* renamed from: Y0, reason: collision with root package name */
    public static final /* synthetic */ int f2524Y0 = 0;

    /* renamed from: A, reason: collision with root package name */
    public final int f2525A;

    /* renamed from: A0, reason: collision with root package name */
    public ColorStateList f2526A0;

    /* renamed from: B, reason: collision with root package name */
    public int f2527B;

    /* renamed from: B0, reason: collision with root package name */
    public ColorStateList f2528B0;

    /* renamed from: C, reason: collision with root package name */
    public int f2529C;

    /* renamed from: C0, reason: collision with root package name */
    public ColorStateList f2530C0;

    /* renamed from: D, reason: collision with root package name */
    public int f2531D;

    /* renamed from: D0, reason: collision with root package name */
    public ColorStateList f2532D0;
    public int E;

    /* renamed from: E0, reason: collision with root package name */
    public ColorStateList f2533E0;

    /* renamed from: F, reason: collision with root package name */
    public int f2534F;

    /* renamed from: F0, reason: collision with root package name */
    public final Path f2535F0;

    /* renamed from: G, reason: collision with root package name */
    public int f2536G;

    /* renamed from: G0, reason: collision with root package name */
    public final RectF f2537G0;

    /* renamed from: H0, reason: collision with root package name */
    public final RectF f2538H0;
    public final RectF I0;

    /* renamed from: J0, reason: collision with root package name */
    public final RectF f2539J0;
    public final Rect K0;

    /* renamed from: L, reason: collision with root package name */
    public int f2540L;

    /* renamed from: L0, reason: collision with root package name */
    public final RectF f2541L0;

    /* renamed from: M, reason: collision with root package name */
    public int f2542M;

    /* renamed from: M0, reason: collision with root package name */
    public final Rect f2543M0;

    /* renamed from: N, reason: collision with root package name */
    public int f2544N;

    /* renamed from: N0, reason: collision with root package name */
    public final Matrix f2545N0;

    /* renamed from: O, reason: collision with root package name */
    public int f2546O;

    /* renamed from: O0, reason: collision with root package name */
    public final k f2547O0;

    /* renamed from: P, reason: collision with root package name */
    public int f2548P;

    /* renamed from: P0, reason: collision with root package name */
    public Drawable f2549P0;

    /* renamed from: Q, reason: collision with root package name */
    public int f2550Q;

    /* renamed from: Q0, reason: collision with root package name */
    public List f2551Q0;

    /* renamed from: R, reason: collision with root package name */
    public int f2552R;

    /* renamed from: R0, reason: collision with root package name */
    public float f2553R0;

    /* renamed from: S, reason: collision with root package name */
    public boolean f2554S;

    /* renamed from: S0, reason: collision with root package name */
    public int f2555S0;

    /* renamed from: T, reason: collision with root package name */
    public Drawable f2556T;

    /* renamed from: T0, reason: collision with root package name */
    public final int f2557T0;

    /* renamed from: U, reason: collision with root package name */
    public boolean f2558U;

    /* renamed from: U0, reason: collision with root package name */
    public final a f2559U0;

    /* renamed from: V, reason: collision with root package name */
    public Drawable f2560V;

    /* renamed from: V0, reason: collision with root package name */
    public final b f2561V0;

    /* renamed from: W, reason: collision with root package name */
    public boolean f2562W;

    /* renamed from: W0, reason: collision with root package name */
    public final D6.b f2563W0;

    /* renamed from: X0, reason: collision with root package name */
    public boolean f2564X0;

    /* renamed from: a, reason: collision with root package name */
    public final Paint f2565a;

    /* renamed from: a0, reason: collision with root package name */
    public ColorStateList f2566a0;
    public final Paint b;
    public Drawable b0;
    public final Paint c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f2567c0;
    public final Paint d;

    /* renamed from: d0, reason: collision with root package name */
    public Drawable f2568d0;
    public final Paint e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f2569e0;
    public final Paint f;

    /* renamed from: f0, reason: collision with root package name */
    public ColorStateList f2570f0;
    public final Paint g;

    /* renamed from: g0, reason: collision with root package name */
    public int f2571g0;
    public final d h;

    /* renamed from: h0, reason: collision with root package name */
    public final int f2572h0;
    public final AccessibilityManager i;

    /* renamed from: i0, reason: collision with root package name */
    public final int f2573i0;

    /* renamed from: j, reason: collision with root package name */
    public RunnableC0913p f2574j;

    /* renamed from: j0, reason: collision with root package name */
    public float f2575j0;
    public final int k;

    /* renamed from: k0, reason: collision with root package name */
    public float f2576k0;
    public final ArrayList l;

    /* renamed from: l0, reason: collision with root package name */
    public MotionEvent f2577l0;
    public final ArrayList m;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f2578m0;
    public final ArrayList n;

    /* renamed from: n0, reason: collision with root package name */
    public float f2579n0;
    public boolean o;

    /* renamed from: o0, reason: collision with root package name */
    public float f2580o0;
    public ValueAnimator p;

    /* renamed from: p0, reason: collision with root package name */
    public ArrayList f2581p0;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator f2582q;

    /* renamed from: q0, reason: collision with root package name */
    public int f2583q0;

    /* renamed from: r, reason: collision with root package name */
    public final int f2584r;

    /* renamed from: r0, reason: collision with root package name */
    public int f2585r0;

    /* renamed from: s, reason: collision with root package name */
    public final int f2586s;
    public float s0;

    /* renamed from: t, reason: collision with root package name */
    public final int f2587t;
    public float[] t0;
    public final int u;

    /* renamed from: u0, reason: collision with root package name */
    public int f2588u0;

    /* renamed from: v, reason: collision with root package name */
    public final int f2589v;

    /* renamed from: v0, reason: collision with root package name */
    public int f2590v0;

    /* renamed from: w, reason: collision with root package name */
    public final int f2591w;

    /* renamed from: w0, reason: collision with root package name */
    public int f2592w0;

    /* renamed from: x, reason: collision with root package name */
    public final int f2593x;

    /* renamed from: x0, reason: collision with root package name */
    public int f2594x0;
    public final int y;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f2595y0;

    /* renamed from: z, reason: collision with root package name */
    public int f2596z;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f2597z0;

    /* JADX WARN: Type inference failed for: r1v11, types: [com.google.android.material.slider.a] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.google.android.material.slider.b] */
    public f(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(i3.a.a(context, attributeSet, R.attr.sliderStyle, R.style.Widget_MaterialComponents_Slider), attributeSet, R.attr.sliderStyle);
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = false;
        this.f2544N = -1;
        this.f2546O = -1;
        this.f2554S = false;
        this.f2558U = false;
        this.f2562W = false;
        this.f2567c0 = false;
        this.f2569e0 = false;
        this.f2578m0 = false;
        this.f2581p0 = new ArrayList();
        this.f2583q0 = -1;
        this.f2585r0 = -1;
        this.s0 = 0.0f;
        this.f2595y0 = false;
        this.f2535F0 = new Path();
        this.f2537G0 = new RectF();
        this.f2538H0 = new RectF();
        this.I0 = new RectF();
        this.f2539J0 = new RectF();
        this.K0 = new Rect();
        this.f2541L0 = new RectF();
        this.f2543M0 = new Rect();
        this.f2545N0 = new Matrix();
        k kVar = new k();
        this.f2547O0 = kVar;
        this.f2551Q0 = Collections.EMPTY_LIST;
        this.f2555S0 = 0;
        final Slider slider = (Slider) this;
        this.f2559U0 = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.material.slider.a
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                slider.C();
            }
        };
        this.f2561V0 = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.slider.b
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                slider.C();
            }
        };
        this.f2563W0 = new D6.b(slider, 18);
        Context context2 = getContext();
        this.f2564X0 = isShown();
        this.f2565a = new Paint();
        this.b = new Paint();
        Paint paint = new Paint(1);
        this.c = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint2 = new Paint(1);
        this.d = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.e = paint3;
        Paint.Style style2 = Paint.Style.STROKE;
        paint3.setStyle(style2);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        Paint paint4 = new Paint();
        this.f = paint4;
        paint4.setStyle(style2);
        paint4.setStrokeCap(cap);
        Paint paint5 = new Paint();
        this.g = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        Resources resources = context2.getResources();
        this.f2525A = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.f2586s = dimensionPixelOffset;
        this.E = dimensionPixelOffset;
        this.f2587t = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.u = resources.getDimensionPixelSize(R.dimen.mtrl_slider_track_height);
        this.f2589v = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_radius);
        this.f2591w = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_radius);
        this.f2593x = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_min_spacing);
        this.f2573i0 = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
        this.f2572h0 = resources.getDimensionPixelOffset(R.dimen.m3_slider_track_icon_padding);
        com.google.android.material.internal.k.a(context2, attributeSet, R.attr.sliderStyle, R.style.Widget_MaterialComponents_Slider);
        int[] iArr = P2.a.f1066F;
        com.google.android.material.internal.k.b(context2, attributeSet, iArr, R.attr.sliderStyle, R.style.Widget_MaterialComponents_Slider, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, R.attr.sliderStyle, R.style.Widget_MaterialComponents_Slider);
        setOrientation(typedArrayObtainStyledAttributes.getInt(2, 0));
        this.k = typedArrayObtainStyledAttributes.getResourceId(10, R.style.Widget_MaterialComponents_Tooltip);
        this.f2579n0 = typedArrayObtainStyledAttributes.getFloat(4, 0.0f);
        this.f2580o0 = typedArrayObtainStyledAttributes.getFloat(5, 1.0f);
        setValues(Float.valueOf(this.f2579n0));
        setCentered(typedArrayObtainStyledAttributes.getBoolean(6, false));
        this.s0 = typedArrayObtainStyledAttributes.getFloat(3, 0.0f);
        this.y = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(11, AbstractC0872b.c(context2)));
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(27);
        int i = zHasValue ? 27 : 29;
        int i6 = zHasValue ? 27 : 28;
        ColorStateList colorStateListA = AbstractC0873c.a(context2, typedArrayObtainStyledAttributes, i);
        setTrackInactiveTintList(colorStateListA == null ? AppCompatResources.getColorStateList(context2, R.color.material_slider_inactive_track_color) : colorStateListA);
        ColorStateList colorStateListA2 = AbstractC0873c.a(context2, typedArrayObtainStyledAttributes, i6);
        setTrackActiveTintList(colorStateListA2 == null ? AppCompatResources.getColorStateList(context2, R.color.material_slider_active_track_color) : colorStateListA2);
        kVar.q(AbstractC0873c.a(context2, typedArrayObtainStyledAttributes, 12));
        if (typedArrayObtainStyledAttributes.hasValue(16)) {
            setThumbStrokeColor(AbstractC0873c.a(context2, typedArrayObtainStyledAttributes, 16));
        }
        setThumbStrokeWidth(typedArrayObtainStyledAttributes.getDimension(17, 0.0f));
        ColorStateList colorStateListA3 = AbstractC0873c.a(context2, typedArrayObtainStyledAttributes, 7);
        setHaloTintList(colorStateListA3 == null ? AppCompatResources.getColorStateList(context2, R.color.material_slider_halo_color) : colorStateListA3);
        this.f2588u0 = typedArrayObtainStyledAttributes.hasValue(25) ? typedArrayObtainStyledAttributes.getInt(25, -1) : typedArrayObtainStyledAttributes.getBoolean(26, true) ? 0 : 2;
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(20);
        int i10 = zHasValue2 ? 20 : 22;
        int i11 = zHasValue2 ? 20 : 21;
        ColorStateList colorStateListA4 = AbstractC0873c.a(context2, typedArrayObtainStyledAttributes, i10);
        setTickInactiveTintList(colorStateListA4 == null ? AppCompatResources.getColorStateList(context2, R.color.material_slider_inactive_tick_marks_color) : colorStateListA4);
        ColorStateList colorStateListA5 = AbstractC0873c.a(context2, typedArrayObtainStyledAttributes, i11);
        setTickActiveTintList(colorStateListA5 == null ? AppCompatResources.getColorStateList(context2, R.color.material_slider_active_tick_marks_color) : colorStateListA5);
        setThumbTrackGapSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(18, 0));
        setTrackStopIndicatorSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(40, 0));
        setTrackCornerSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(30, -1));
        setTrackInsideCornerSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(39, 0));
        setTrackIconActiveStart(AbstractC0873c.c(context2, typedArrayObtainStyledAttributes, 34));
        setTrackIconActiveEnd(AbstractC0873c.c(context2, typedArrayObtainStyledAttributes, 33));
        setTrackIconActiveColor(AbstractC0873c.a(context2, typedArrayObtainStyledAttributes, 32));
        setTrackIconInactiveStart(AbstractC0873c.c(context2, typedArrayObtainStyledAttributes, 37));
        setTrackIconInactiveEnd(AbstractC0873c.c(context2, typedArrayObtainStyledAttributes, 36));
        setTrackIconInactiveColor(AbstractC0873c.a(context2, typedArrayObtainStyledAttributes, 35));
        setTrackIconSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(38, 0));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(15, 0) * 2;
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(19, dimensionPixelSize);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(14, dimensionPixelSize);
        setThumbWidth(dimensionPixelSize2);
        setThumbHeight(dimensionPixelSize3);
        setHaloRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0));
        setThumbElevation(typedArrayObtainStyledAttributes.getDimension(13, 0.0f));
        setTrackHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(31, 0));
        setTickActiveRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(23, this.f2548P / 2));
        setTickInactiveRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(24, this.f2548P / 2));
        setLabelBehavior(typedArrayObtainStyledAttributes.getInt(9, 0));
        if (!typedArrayObtainStyledAttributes.getBoolean(0, true)) {
            setEnabled(false);
        }
        typedArrayObtainStyledAttributes.recycle();
        setFocusable(true);
        setClickable(true);
        kVar.t();
        this.f2584r = ViewConfiguration.get(context2).getScaledTouchSlop();
        d dVar = new d(slider);
        this.h = dVar;
        ViewCompat.setAccessibilityDelegate(this, dVar);
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.i = accessibilityManager;
        this.f2557T0 = accessibilityManager.getRecommendedTimeoutMillis(10000, 6);
    }

    public final void A(int i, Rect rect) {
        int iU = this.E + ((int) (u(getValues().get(i).floatValue()) * this.f2594x0));
        int iC = c();
        int iMax = Math.max(this.f2534F / 2, this.y / 2);
        int iMax2 = Math.max(this.f2536G / 2, this.y / 2);
        RectF rectF = new RectF(iU - iMax, iC - iMax2, iU + iMax, iC + iMax2);
        if (r()) {
            this.f2545N0.mapRect(rectF);
        }
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public final void B() {
        if (!(getBackground() instanceof RippleDrawable) || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            float fU = (u(((Float) this.f2581p0.get(this.f2585r0)).floatValue()) * this.f2594x0) + this.E;
            int iC = c();
            float f = this.f2540L;
            float[] fArr = {fU - f, iC - r3, fU + f, iC + r3};
            if (r()) {
                this.f2545N0.mapPoints(fArr);
            }
            background.setHotspotBounds((int) fArr[0], (int) fArr[1], (int) fArr[2], (int) fArr[3]);
        }
    }

    public final void C() {
        float f;
        boolean zR = r();
        boolean zQ = q();
        float f7 = 0.5f;
        if (zR && zQ) {
            f = 0.5f;
            f7 = -0.2f;
        } else {
            f = 1.2f;
            if (zR) {
                f7 = 1.2f;
                f = 0.5f;
            }
        }
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            C1595a c1595a = (C1595a) it.next();
            c1595a.f4770a0 = f7;
            c1595a.b0 = f;
            c1595a.invalidateSelf();
        }
        int i = this.f2529C;
        if (i == 0 || i == 1) {
            if (this.f2583q0 == -1 || !isEnabled()) {
                k();
                return;
            } else {
                j();
                return;
            }
        }
        if (i == 2) {
            k();
            return;
        }
        if (i != 3) {
            throw new IllegalArgumentException("Unexpected labelBehavior: " + this.f2529C);
        }
        if (isEnabled()) {
            Rect rect = new Rect();
            o.a(this).getHitRect(rect);
            if (getLocalVisibleRect(rect) && this.f2564X0) {
                j();
                return;
            }
        }
        k();
    }

    public final void D() {
        int i = this.f2542M;
        if (i > 0) {
            int i6 = this.f2534F;
            this.f2544N = i6;
            this.f2546O = i;
            int iRound = Math.round(i6 * 0.5f);
            int i10 = this.f2534F - iRound;
            setThumbWidth(iRound);
            setThumbTrackGapSize(this.f2542M - (i10 / 2));
        }
    }

    public final void E() {
        M();
        float f = this.s0;
        int iMin = 0;
        if (f <= 0.0f) {
            F(0);
            return;
        }
        int i = this.f2588u0;
        if (i == 0) {
            iMin = Math.min((int) (((this.f2580o0 - this.f2579n0) / f) + 1.0f), (this.f2594x0 / this.f2593x) + 1);
        } else if (i == 1) {
            int i6 = (int) (((this.f2580o0 - this.f2579n0) / f) + 1.0f);
            if (i6 <= (this.f2594x0 / this.f2593x) + 1) {
                iMin = i6;
            }
        } else if (i != 2) {
            throw new IllegalStateException("Unexpected tickVisibilityMode: " + this.f2588u0);
        }
        F(iMin);
    }

    public final void F(int i) {
        if (i == 0) {
            this.t0 = null;
            return;
        }
        float[] fArr = this.t0;
        if (fArr == null || fArr.length != i * 2) {
            this.t0 = new float[i * 2];
        }
        float f = this.f2594x0 / (i - 1);
        float fC = c();
        for (int i6 = 0; i6 < i * 2; i6 += 2) {
            float[] fArr2 = this.t0;
            fArr2[i6] = ((i6 / 2.0f) * f) + this.E;
            fArr2[i6 + 1] = fC;
        }
        if (r()) {
            this.f2545N0.mapPoints(this.t0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G(android.graphics.Canvas r11, android.graphics.Paint r12, android.graphics.RectF r13, float r14, com.google.android.material.slider.BaseSlider$FullCornerDirection r15) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.f.G(android.graphics.Canvas, android.graphics.Paint, android.graphics.RectF, float, com.google.android.material.slider.BaseSlider$FullCornerDirection):void");
    }

    public final void H() {
        Drawable drawable = this.f2560V;
        if (drawable != null) {
            if (!this.f2562W && this.f2566a0 != null) {
                this.f2560V = DrawableCompat.wrap(drawable).mutate();
                this.f2562W = true;
            }
            if (this.f2562W) {
                this.f2560V.setTintList(this.f2566a0);
            }
        }
    }

    public final void I() {
        Drawable drawable = this.f2556T;
        if (drawable != null) {
            if (!this.f2558U && this.f2566a0 != null) {
                this.f2556T = DrawableCompat.wrap(drawable).mutate();
                this.f2558U = true;
            }
            if (this.f2558U) {
                this.f2556T.setTintList(this.f2566a0);
            }
        }
    }

    public final void J() {
        Drawable drawable = this.f2568d0;
        if (drawable != null) {
            if (!this.f2569e0 && this.f2570f0 != null) {
                this.f2568d0 = DrawableCompat.wrap(drawable).mutate();
                this.f2569e0 = true;
            }
            if (this.f2569e0) {
                this.f2568d0.setTintList(this.f2570f0);
            }
        }
    }

    public final void K() {
        Drawable drawable = this.b0;
        if (drawable != null) {
            if (!this.f2567c0 && this.f2570f0 != null) {
                this.b0 = DrawableCompat.wrap(drawable).mutate();
                this.f2567c0 = true;
            }
            if (this.f2567c0) {
                this.b0.setTintList(this.f2570f0);
            }
        }
    }

    public final void L(boolean z10) {
        int paddingTop;
        int paddingBottom;
        boolean z11;
        if (r()) {
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
        } else {
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        int i = paddingBottom + paddingTop;
        int iMax = Math.max(this.f2525A, Math.max(this.f2531D + i, this.f2536G + i));
        boolean z12 = true;
        if (iMax == this.f2527B) {
            z11 = false;
        } else {
            this.f2527B = iMax;
            z11 = true;
        }
        int iMax2 = Math.max(Math.max(Math.max((this.f2534F / 2) - this.f2587t, 0), Math.max((this.f2531D - this.u) / 2, 0)), Math.max(Math.max(this.f2590v0 - this.f2589v, 0), Math.max(this.f2592w0 - this.f2591w, 0))) + this.f2586s;
        if (this.E == iMax2) {
            z12 = false;
        } else {
            this.E = iMax2;
            if (isLaidOut()) {
                this.f2594x0 = Math.max((r() ? getHeight() : getWidth()) - (this.E * 2), 0);
                E();
            }
        }
        if (r()) {
            float fC = c();
            Matrix matrix = this.f2545N0;
            matrix.reset();
            matrix.setRotate(90.0f, fC, fC);
        }
        if (z11 || z10) {
            requestLayout();
        } else if (z12) {
            postInvalidate();
        }
    }

    public final void M() {
        if (this.f2597z0) {
            if (this.f2579n0 >= this.f2580o0) {
                throw new IllegalStateException("valueFrom(" + this.f2579n0 + ") must be smaller than valueTo(" + this.f2580o0 + ")");
            }
            Iterator it = this.f2581p0.iterator();
            while (it.hasNext()) {
                Float f = (Float) it.next();
                if (f.floatValue() < this.f2579n0 || f.floatValue() > this.f2580o0) {
                    float f7 = this.f2579n0;
                    float f9 = this.f2580o0;
                    StringBuilder sb = new StringBuilder("Slider value(");
                    sb.append(f);
                    sb.append(") must be greater or equal to valueFrom(");
                    sb.append(f7);
                    sb.append("), and lower or equal to valueTo(");
                    throw new IllegalStateException(androidx.compose.foundation.b.u(sb, ")", f9));
                }
                if (this.s0 > 0.0f && !N(f.floatValue())) {
                    float f10 = this.f2579n0;
                    float f11 = this.s0;
                    throw new IllegalStateException("Value(" + f + ") must be equal to valueFrom(" + f10 + ") plus a multiple of stepSize(" + f11 + ") when using stepSize(" + f11 + ")");
                }
            }
            if (this.s0 > 0.0f && !N(this.f2580o0)) {
                float f12 = this.s0;
                float f13 = this.f2579n0;
                float f14 = this.f2580o0;
                StringBuilder sb2 = new StringBuilder("The stepSize(");
                sb2.append(f12);
                sb2.append(") must be 0, or a factor of the valueFrom(");
                sb2.append(f13);
                sb2.append(")-valueTo(");
                throw new IllegalStateException(androidx.compose.foundation.b.u(sb2, ") range", f14));
            }
            float minSeparation = getMinSeparation();
            if (minSeparation < 0.0f) {
                throw new IllegalStateException(B7.a.l("minSeparation(", ") must be greater or equal to 0", minSeparation));
            }
            float f15 = this.s0;
            if (f15 > 0.0f && minSeparation > 0.0f) {
                if (this.f2555S0 != 1) {
                    throw new IllegalStateException("minSeparation(" + minSeparation + ") cannot be set as a dimension when using stepSize(" + this.s0 + ")");
                }
                if (minSeparation < f15 || !n(minSeparation)) {
                    float f16 = this.s0;
                    StringBuilder sb3 = new StringBuilder("minSeparation(");
                    sb3.append(minSeparation);
                    sb3.append(") must be greater or equal and a multiple of stepSize(");
                    sb3.append(f16);
                    sb3.append(") when using stepSize(");
                    throw new IllegalStateException(androidx.compose.foundation.b.u(sb3, ")", f16));
                }
            }
            float f17 = this.s0;
            if (f17 != 0.0f) {
                if (((int) f17) != f17) {
                    Log.w("f", "Floating point value used for stepSize(" + f17 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
                float f18 = this.f2579n0;
                if (((int) f18) != f18) {
                    Log.w("f", "Floating point value used for valueFrom(" + f18 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
                float f19 = this.f2580o0;
                if (((int) f19) != f19) {
                    Log.w("f", "Floating point value used for valueTo(" + f19 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
            }
            this.f2597z0 = false;
        }
    }

    public final boolean N(float f) {
        return n(new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Float.toString(this.f2579n0)), MathContext.DECIMAL64).doubleValue());
    }

    public final float O(float f) {
        return (u(f) * this.f2594x0) + this.E;
    }

    public final void a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, this.f2534F, this.f2536G);
        } else {
            float fMax = Math.max(this.f2534F, this.f2536G) / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * fMax), (int) (intrinsicHeight * fMax));
        }
    }

    public final void b(Canvas canvas, RectF rectF, Drawable drawable, boolean z10) {
        if (drawable != null) {
            int i = this.f2571g0;
            float f = rectF.right - rectF.left;
            int i6 = this.f2572h0;
            float f7 = (i6 * 2) + i;
            RectF rectF2 = this.f2541L0;
            if (f >= f7) {
                float f9 = z10 ^ (q() || r()) ? rectF.left + i6 : (rectF.right - i6) - i;
                float f10 = i;
                float fC = c() - (f10 / 2.0f);
                rectF2.set(f9, fC, f9 + f10, f10 + fC);
            } else {
                rectF2.setEmpty();
            }
            if (rectF2.isEmpty()) {
                return;
            }
            if (r()) {
                this.f2545N0.mapRect(rectF2);
            }
            Rect rect = this.f2543M0;
            rectF2.round(rect);
            drawable.setBounds(rect);
            drawable.draw(canvas);
        }
    }

    public final int c() {
        int i = this.f2527B / 2;
        int i6 = this.f2529C;
        return i + ((i6 == 1 || i6 == 3) ? ((C1595a) this.l.get(0)).getIntrinsicHeight() : 0);
    }

    public final ValueAnimator d(boolean z10) {
        int iN;
        TimeInterpolator timeInterpolatorO;
        float fFloatValue = z10 ? 0.0f : 1.0f;
        ValueAnimator valueAnimator = z10 ? this.f2582q : this.p;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, z10 ? 1.0f : 0.0f);
        if (z10) {
            iN = N.N(getContext(), R.attr.motionDurationMedium4, 83);
            timeInterpolatorO = N.O(getContext(), R.attr.motionEasingEmphasizedInterpolator, Q2.a.e);
        } else {
            iN = N.N(getContext(), R.attr.motionDurationShort3, 117);
            timeInterpolatorO = N.O(getContext(), R.attr.motionEasingEmphasizedAccelerateInterpolator, Q2.a.c);
        }
        valueAnimatorOfFloat.setDuration(iN);
        valueAnimatorOfFloat.setInterpolator(timeInterpolatorO);
        valueAnimatorOfFloat.addUpdateListener(new j(this, 3));
        return valueAnimatorOfFloat;
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.h.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        this.f2565a.setColor(m(this.f2533E0));
        this.b.setColor(m(this.f2532D0));
        this.e.setColor(m(this.f2530C0));
        this.f.setColor(m(this.f2528B0));
        this.g.setColor(m(this.f2530C0));
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            C1595a c1595a = (C1595a) it.next();
            if (c1595a.isStateful()) {
                c1595a.setState(getDrawableState());
            }
        }
        k kVar = this.f2547O0;
        if (kVar.isStateful()) {
            kVar.setState(getDrawableState());
        }
        int iM = m(this.f2526A0);
        Paint paint = this.d;
        paint.setColor(iM);
        paint.setAlpha(63);
    }

    public final void e(float f, float f7, float f9, float f10, Canvas canvas, RectF rectF, BaseSlider$FullCornerDirection baseSlider$FullCornerDirection) {
        if (f7 - f > getTrackCornerSize() - this.f2542M) {
            rectF.set(f, f9, f7, f10);
        } else {
            rectF.setEmpty();
        }
        G(canvas, this.f2565a, rectF, getTrackCornerSize(), baseSlider$FullCornerDirection);
    }

    public final void f(Canvas canvas, float f, float f7) {
        Iterator it = this.f2581p0.iterator();
        while (it.hasNext()) {
            float fO = O(((Float) it.next()).floatValue());
            float f9 = (this.f2534F / 2.0f) + this.f2542M;
            if (f >= fO - f9 && f <= fO + f9) {
                return;
            }
        }
        boolean zR = r();
        Paint paint = this.g;
        if (zR) {
            canvas.drawPoint(f7, f, paint);
        } else {
            canvas.drawPoint(f, f7, paint);
        }
    }

    public final void g(Canvas canvas, int i, int i6, float f, Drawable drawable) {
        canvas.save();
        if (r()) {
            canvas.concat(this.f2545N0);
        }
        canvas.translate((this.E + ((int) (u(f) * i))) - (drawable.getBounds().width() / 2.0f), i6 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.h.getAccessibilityFocusedVirtualViewId();
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public abstract int getThumbRadius();

    public abstract int getTrackCornerSize();

    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.f2581p0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(int r6, int r7, android.graphics.Canvas r8, android.graphics.Paint r9) {
        /*
            r5 = this;
        L0:
            if (r6 >= r7) goto L72
            boolean r0 = r5.r()
            if (r0 == 0) goto Lf
            float[] r0 = r5.t0
            int r1 = r6 + 1
            r0 = r0[r1]
            goto L13
        Lf:
            float[] r0 = r5.t0
            r0 = r0[r6]
        L13:
            int r1 = r5.f2542M
            float r1 = (float) r1
            int r2 = r5.f2534F
            float r2 = (float) r2
            r3 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r3
            float r2 = r2 + r1
            java.util.ArrayList r1 = r5.f2581p0
            java.util.Iterator r1 = r1.iterator()
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L43
            java.lang.Object r1 = r1.next()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            float r1 = r5.O(r1)
            float r4 = r1 - r2
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 < 0) goto L43
            float r1 = r1 + r2
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 > 0) goto L43
            goto L6f
        L43:
            boolean r1 = r5.f2554S
            if (r1 == 0) goto L64
            int r1 = r5.f2542M
            float r1 = (float) r1
            int r2 = r5.f2534F
            float r2 = (float) r2
            float r2 = r2 / r3
            float r2 = r2 + r1
            int r1 = r5.f2594x0
            int r4 = r5.E
            int r4 = r4 * 2
            int r4 = r4 + r1
            float r1 = (float) r4
            float r1 = r1 / r3
            float r3 = r1 - r2
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 < 0) goto L64
            float r1 = r1 + r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L64
            goto L6f
        L64:
            float[] r0 = r5.t0
            r1 = r0[r6]
            int r2 = r6 + 1
            r0 = r0[r2]
            r8.drawPoint(r1, r0, r9)
        L6f:
            int r6 = r6 + 2
            goto L0
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.f.h(int, int, android.graphics.Canvas, android.graphics.Paint):void");
    }

    public final void i(Canvas canvas, RectF rectF, RectF rectF2) {
        if (this.f2556T == null && this.f2560V == null && this.b0 == null && this.f2568d0 == null) {
            return;
        }
        if (this.f2581p0.size() > 1) {
            Log.w("f", "Track icons can only be used when only 1 thumb is present.");
        }
        b(canvas, rectF, this.f2556T, true);
        b(canvas, rectF2, this.b0, true);
        b(canvas, rectF, this.f2560V, false);
        b(canvas, rectF2, this.f2568d0, false);
    }

    public final void j() {
        if (!this.o) {
            this.o = true;
            ValueAnimator valueAnimatorD = d(true);
            this.p = valueAnimatorD;
            this.f2582q = null;
            valueAnimatorD.start();
        }
        ArrayList arrayList = this.l;
        Iterator it = arrayList.iterator();
        for (int i = 0; i < this.f2581p0.size() && it.hasNext(); i++) {
            if (i != this.f2585r0) {
                w((C1595a) it.next(), ((Float) this.f2581p0.get(i)).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(arrayList.size()), Integer.valueOf(this.f2581p0.size())));
        }
        w((C1595a) it.next(), ((Float) this.f2581p0.get(this.f2585r0)).floatValue());
    }

    public final void k() {
        if (this.o) {
            this.o = false;
            ValueAnimator valueAnimatorD = d(false);
            this.f2582q = valueAnimatorD;
            this.p = null;
            valueAnimatorD.addListener(new c(this));
            this.f2582q.start();
        }
    }

    public final float[] l() {
        float fFloatValue = ((Float) this.f2581p0.get(0)).floatValue();
        ArrayList arrayList = this.f2581p0;
        float fFloatValue2 = ((Float) arrayList.get(arrayList.size() - 1)).floatValue();
        if (this.f2581p0.size() == 1) {
            fFloatValue = this.f2579n0;
        }
        float fU = u(fFloatValue);
        float fU2 = u(fFloatValue2);
        if (this.f2554S) {
            float fMin = Math.min(0.5f, fU2);
            fU2 = Math.max(0.5f, fU2);
            fU = fMin;
        }
        return (this.f2554S || !(q() || r())) ? new float[]{fU, fU2} : new float[]{fU2, fU};
    }

    public final int m(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    public final boolean n(double d) {
        double dDoubleValue = new BigDecimal(Double.toString(d)).divide(new BigDecimal(Float.toString(this.s0)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < 1.0E-4d;
    }

    public final boolean o(MotionEvent motionEvent) {
        if (motionEvent.getToolType(0) != 3) {
            for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if ((viewGroup.canScrollHorizontally(1) || viewGroup.canScrollHorizontally(-1)) && viewGroup.shouldDelayChildPressedState()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2564X0 = isShown();
        getViewTreeObserver().addOnScrollChangedListener(this.f2559U0);
        getViewTreeObserver().addOnGlobalLayoutListener(this.f2561V0);
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            C1595a c1595a = (C1595a) it.next();
            ViewGroup viewGroupA = o.a(this);
            if (viewGroupA == null) {
                c1595a.getClass();
            } else {
                c1595a.getClass();
                int[] iArr = new int[2];
                viewGroupA.getLocationOnScreen(iArr);
                c1595a.f4767X = iArr[0];
                viewGroupA.getWindowVisibleDisplayFrame(c1595a.f4760Q);
                viewGroupA.addOnLayoutChangeListener(c1595a.f4759P);
            }
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        RunnableC0913p runnableC0913p = this.f2574j;
        if (runnableC0913p != null) {
            removeCallbacks(runnableC0913p);
        }
        this.o = false;
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            C1595a c1595a = (C1595a) it.next();
            ViewGroup viewGroupA = o.a(this);
            if (viewGroupA != null) {
                viewGroupA.getOverlay().remove(c1595a);
                viewGroupA.removeOnLayoutChangeListener(c1595a.f4759P);
            }
        }
        getViewTreeObserver().removeOnScrollChangedListener(this.f2559U0);
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f2561V0);
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0140  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDraw(android.graphics.Canvas r19) {
        /*
            Method dump skipped, instructions count: 723
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.f.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z10, int i, Rect rect) {
        super.onFocusChanged(z10, i, rect);
        d dVar = this.h;
        if (!z10) {
            this.f2583q0 = -1;
            dVar.clearKeyboardFocusForVirtualView(this.f2585r0);
            return;
        }
        if (i == 1) {
            s(Integer.MAX_VALUE);
        } else if (i == 2) {
            s(Integer.MIN_VALUE);
        } else if (i == 17) {
            t(Integer.MAX_VALUE);
        } else if (i == 66) {
            t(Integer.MIN_VALUE);
        }
        dVar.requestKeyboardFocusForVirtualView(this.f2585r0);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setVisibleToUser(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onKeyDown(int r14, android.view.KeyEvent r15) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.f.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        this.f2595y0 = false;
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        int i10 = this.f2529C;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f2527B + ((i10 == 1 || i10 == 3) ? ((C1595a) this.l.get(0)).getIntrinsicHeight() : 0), BasicMeasure.EXACTLY);
        if (r()) {
            super.onMeasure(iMakeMeasureSpec, i6);
        } else {
            super.onMeasure(i, iMakeMeasureSpec);
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        BaseSlider$SliderState baseSlider$SliderState = (BaseSlider$SliderState) parcelable;
        super.onRestoreInstanceState(baseSlider$SliderState.getSuperState());
        this.f2579n0 = baseSlider$SliderState.valueFrom;
        this.f2580o0 = baseSlider$SliderState.valueTo;
        x(baseSlider$SliderState.values);
        this.s0 = baseSlider$SliderState.stepSize;
        if (baseSlider$SliderState.hasFocus) {
            requestFocus();
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        BaseSlider$SliderState baseSlider$SliderState = new BaseSlider$SliderState(super.onSaveInstanceState());
        baseSlider$SliderState.valueFrom = this.f2579n0;
        baseSlider$SliderState.valueTo = this.f2580o0;
        baseSlider$SliderState.values = new ArrayList<>(this.f2581p0);
        baseSlider$SliderState.stepSize = this.s0;
        baseSlider$SliderState.hasFocus = hasFocus();
        return baseSlider$SliderState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i6, int i10, int i11) {
        if (r()) {
            i = i6;
        }
        this.f2594x0 = Math.max(i - (this.E * 2), 0);
        E();
        B();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b6  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.f.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean z10) {
        super.onVisibilityAggregated(z10);
        this.f2564X0 = z10;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            ViewGroup viewGroupA = o.a(this);
            ViewOverlay overlay = viewGroupA == null ? null : viewGroupA.getOverlay();
            if (overlay == null) {
                return;
            }
            Iterator it = this.l.iterator();
            while (it.hasNext()) {
                overlay.remove((C1595a) it.next());
            }
        }
    }

    public final boolean p(MotionEvent motionEvent) {
        if (motionEvent.getToolType(0) != 3) {
            for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean q() {
        return getLayoutDirection() == 1;
    }

    public final boolean r() {
        return this.f2596z == 1;
    }

    public final boolean s(int i) {
        int i6 = this.f2585r0;
        int iClamp = (int) MathUtils.clamp(i6 + i, 0L, this.f2581p0.size() - 1);
        this.f2585r0 = iClamp;
        if (iClamp == i6) {
            return false;
        }
        if (this.f2583q0 != -1) {
            this.f2583q0 = iClamp;
        }
        B();
        postInvalidate();
        return true;
    }

    public void setActiveThumbIndex(int i) {
        this.f2583q0 = i;
    }

    public abstract void setCentered(boolean z10);

    public void setCustomThumbDrawablesForValues(@NonNull @DrawableRes int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            drawableArr[i] = getResources().getDrawable(iArr[i]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        setLayerType(z10 ? 0 : 2, null);
    }

    public abstract void setHaloRadius(int i);

    public abstract void setHaloTintList(ColorStateList colorStateList);

    public abstract void setLabelBehavior(int i);

    public abstract void setOrientation(int i);

    public void setSeparationUnit(int i) {
        this.f2555S0 = i;
        this.f2597z0 = true;
        postInvalidate();
    }

    public abstract void setThumbElevation(float f);

    public abstract void setThumbHeight(int i);

    public abstract void setThumbStrokeColor(ColorStateList colorStateList);

    public abstract void setThumbStrokeWidth(float f);

    public abstract void setThumbTrackGapSize(int i);

    public abstract void setThumbWidth(int i);

    public abstract void setTickActiveRadius(int i);

    public abstract void setTickActiveTintList(ColorStateList colorStateList);

    public abstract void setTickInactiveRadius(int i);

    public abstract void setTickInactiveTintList(ColorStateList colorStateList);

    public abstract void setTrackActiveTintList(ColorStateList colorStateList);

    public abstract void setTrackCornerSize(int i);

    public abstract void setTrackHeight(int i);

    public abstract void setTrackIconActiveColor(ColorStateList colorStateList);

    public abstract void setTrackIconActiveEnd(Drawable drawable);

    public abstract void setTrackIconActiveStart(Drawable drawable);

    public abstract void setTrackIconInactiveColor(ColorStateList colorStateList);

    public abstract void setTrackIconInactiveEnd(Drawable drawable);

    public abstract void setTrackIconInactiveStart(Drawable drawable);

    public abstract void setTrackIconSize(int i);

    public abstract void setTrackInactiveTintList(ColorStateList colorStateList);

    public abstract void setTrackInsideCornerSize(int i);

    public abstract void setTrackStopIndicatorSize(int i);

    public void setValues(@NonNull Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        x(arrayList);
    }

    public final void t(int i) {
        if (q() || r()) {
            i = i == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i;
        }
        s(i);
    }

    public final float u(float f) {
        float f7 = this.f2579n0;
        float f9 = (f - f7) / (this.f2580o0 - f7);
        return (q() || r()) ? 1.0f - f9 : f9;
    }

    public final void v() {
        Iterator it = this.n.iterator();
        if (it.hasNext()) {
            throw B7.a.f(it);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(j3.C1595a r5, float r6) {
        /*
            r4 = this;
            int r0 = (int) r6
            float r0 = (float) r0
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 != 0) goto L9
            java.lang.String r0 = "%.0f"
            goto Lb
        L9:
            java.lang.String r0 = "%.2f"
        Lb:
            java.lang.Float r1 = java.lang.Float.valueOf(r6)
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            java.lang.String r0 = java.lang.String.format(r0, r1)
            java.lang.CharSequence r1 = r5.f4755L
            boolean r1 = android.text.TextUtils.equals(r1, r0)
            if (r1 != 0) goto L29
            r5.f4755L = r0
            com.google.android.material.internal.i r0 = r5.f4758O
            r1 = 1
            r0.d = r1
            r5.invalidateSelf()
        L29:
            boolean r0 = r4.r()
            if (r0 == 0) goto L72
            int r0 = r4.E
            float r6 = r4.u(r6)
            int r1 = r4.f2594x0
            float r1 = (float) r1
            float r6 = r6 * r1
            int r6 = (int) r6
            int r0 = r0 + r6
            int r6 = r5.getIntrinsicHeight()
            int r6 = r6 / 2
            int r0 = r0 - r6
            int r6 = r5.getIntrinsicHeight()
            int r6 = r6 + r0
            boolean r1 = r4.q()
            if (r1 == 0) goto L60
            int r1 = r4.c()
            int r2 = r4.f2536G
            int r2 = r2 / 2
            int r3 = r4.f2573i0
            int r2 = r2 + r3
            int r1 = r1 - r2
            int r2 = r5.getIntrinsicWidth()
        L5d:
            int r2 = r1 - r2
            goto L9b
        L60:
            int r1 = r4.c()
            int r2 = r4.f2536G
            int r2 = r2 / 2
            int r3 = r4.f2573i0
            int r2 = r2 + r3
            int r2 = r2 + r1
            int r1 = r5.getIntrinsicWidth()
            int r1 = r1 + r2
            goto L9b
        L72:
            int r0 = r4.E
            float r6 = r4.u(r6)
            int r1 = r4.f2594x0
            float r1 = (float) r1
            float r6 = r6 * r1
            int r6 = (int) r6
            int r0 = r0 + r6
            int r6 = r5.getIntrinsicWidth()
            int r6 = r6 / 2
            int r0 = r0 - r6
            int r6 = r5.getIntrinsicWidth()
            int r6 = r6 + r0
            int r1 = r4.c()
            int r2 = r4.f2536G
            int r2 = r2 / 2
            int r3 = r4.f2573i0
            int r2 = r2 + r3
            int r1 = r1 - r2
            int r2 = r5.getIntrinsicHeight()
            goto L5d
        L9b:
            android.graphics.Rect r3 = r4.K0
            r3.set(r0, r2, r6, r1)
            boolean r6 = r4.r()
            if (r6 == 0) goto Lb3
            android.graphics.RectF r6 = new android.graphics.RectF
            r6.<init>(r3)
            android.graphics.Matrix r0 = r4.f2545N0
            r0.mapRect(r6)
            r6.round(r3)
        Lb3:
            android.view.ViewGroup r6 = com.google.android.material.internal.o.a(r4)
            com.google.android.material.internal.d.b(r6, r4, r3)
            r5.setBounds(r3)
            android.view.ViewGroup r4 = com.google.android.material.internal.o.a(r4)
            if (r4 != 0) goto Lc5
            r4 = 0
            goto Lc9
        Lc5:
            android.view.ViewOverlay r4 = r4.getOverlay()
        Lc9:
            if (r4 != 0) goto Lcc
            return
        Lcc:
            r4.add(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.f.w(j3.a, float):void");
    }

    public final void x(ArrayList arrayList) {
        ViewGroup viewGroupA;
        int resourceId;
        ViewGroup viewGroupA2;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.f2581p0.size() == arrayList.size() && this.f2581p0.equals(arrayList)) {
            return;
        }
        this.f2581p0 = arrayList;
        this.f2597z0 = true;
        this.f2585r0 = 0;
        B();
        ArrayList arrayList2 = this.l;
        if (arrayList2.size() > this.f2581p0.size()) {
            List<C1595a> listSubList = arrayList2.subList(this.f2581p0.size(), arrayList2.size());
            for (C1595a c1595a : listSubList) {
                if (isAttachedToWindow() && (viewGroupA2 = o.a(this)) != null) {
                    viewGroupA2.getOverlay().remove(c1595a);
                    viewGroupA2.removeOnLayoutChangeListener(c1595a.f4759P);
                }
            }
            listSubList.clear();
        }
        while (true) {
            C0876f c0876f = null;
            if (arrayList2.size() >= this.f2581p0.size()) {
                break;
            }
            Context context = getContext();
            int i = this.k;
            C1595a c1595a2 = new C1595a(context, i);
            TypedArray typedArrayD = com.google.android.material.internal.k.d(c1595a2.f4756M, null, P2.a.f1073M, 0, i, new int[0]);
            Context context2 = c1595a2.f4756M;
            c1595a2.f4766W = context2.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
            boolean z10 = typedArrayD.getBoolean(8, true);
            c1595a2.f4765V = z10;
            if (z10) {
                e3.o oVarF = c1595a2.b.f4345a.f();
                oVarF.k = c1595a2.B();
                c1595a2.setShapeAppearanceModel(oVarF.a());
            } else {
                c1595a2.f4766W = 0;
            }
            CharSequence text = typedArrayD.getText(6);
            boolean zEquals = TextUtils.equals(c1595a2.f4755L, text);
            i iVar = c1595a2.f4758O;
            if (!zEquals) {
                c1595a2.f4755L = text;
                iVar.d = true;
                c1595a2.invalidateSelf();
            }
            if (typedArrayD.hasValue(0) && (resourceId = typedArrayD.getResourceId(0, 0)) != 0) {
                c0876f = new C0876f(context2, resourceId);
            }
            if (c0876f != null && typedArrayD.hasValue(1)) {
                c0876f.k = AbstractC0873c.a(context2, typedArrayD, 1);
            }
            iVar.b(c0876f, context2);
            TypedValue typedValueD = AbstractC0872b.d(context2, C1595a.class.getCanonicalName(), R.attr.colorOnBackground);
            int i6 = typedValueD.resourceId;
            int color = i6 != 0 ? ContextCompat.getColor(context2, i6) : typedValueD.data;
            TypedValue typedValueD2 = AbstractC0872b.d(context2, C1595a.class.getCanonicalName(), android.R.attr.colorBackground);
            int i10 = typedValueD2.resourceId;
            c1595a2.q(ColorStateList.valueOf(typedArrayD.getColor(7, ColorUtils.compositeColors(ColorUtils.setAlphaComponent(color, 153), ColorUtils.setAlphaComponent(i10 != 0 ? ContextCompat.getColor(context2, i10) : typedValueD2.data, 229)))));
            TypedValue typedValueD3 = AbstractC0872b.d(context2, C1595a.class.getCanonicalName(), R.attr.colorSurface);
            int i11 = typedValueD3.resourceId;
            c1595a2.v(ColorStateList.valueOf(i11 != 0 ? ContextCompat.getColor(context2, i11) : typedValueD3.data));
            c1595a2.f4761R = typedArrayD.getDimensionPixelSize(2, 0);
            c1595a2.f4762S = typedArrayD.getDimensionPixelSize(4, 0);
            c1595a2.f4763T = typedArrayD.getDimensionPixelSize(5, 0);
            c1595a2.f4764U = typedArrayD.getDimensionPixelSize(3, 0);
            typedArrayD.recycle();
            arrayList2.add(c1595a2);
            if (isAttachedToWindow() && (viewGroupA = o.a(this)) != null) {
                int[] iArr = new int[2];
                viewGroupA.getLocationOnScreen(iArr);
                c1595a2.f4767X = iArr[0];
                viewGroupA.getWindowVisibleDisplayFrame(c1595a2.f4760Q);
                viewGroupA.addOnLayoutChangeListener(c1595a2.f4759P);
            }
        }
        int i12 = arrayList2.size() == 1 ? 0 : 1;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            C1595a c1595a3 = (C1595a) it.next();
            c1595a3.b.k = i12;
            c1595a3.invalidateSelf();
        }
        Iterator it2 = this.m.iterator();
        while (it2.hasNext()) {
            if (it2.next() != null) {
                throw new ClassCastException();
            }
            Iterator it3 = this.f2581p0.iterator();
            if (it3.hasNext()) {
                ((Float) it3.next()).getClass();
                throw null;
            }
        }
        postInvalidate();
    }

    public final boolean y(float f, int i) {
        this.f2585r0 = i;
        if (Math.abs(f - ((Float) this.f2581p0.get(i)).floatValue()) < 1.0E-4d) {
            return false;
        }
        float minSeparation = getMinSeparation();
        if (this.f2555S0 == 0) {
            if (minSeparation == 0.0f) {
                minSeparation = 0.0f;
            } else {
                float f7 = this.f2579n0;
                minSeparation = B7.a.b(f7, this.f2580o0, (minSeparation - this.E) / this.f2594x0, f7);
            }
        }
        if (q() || r()) {
            minSeparation = -minSeparation;
        }
        int i6 = i + 1;
        int i10 = i - 1;
        this.f2581p0.set(i, Float.valueOf(MathUtils.clamp(f, i10 < 0 ? this.f2579n0 : minSeparation + ((Float) this.f2581p0.get(i10)).floatValue(), i6 >= this.f2581p0.size() ? this.f2580o0 : ((Float) this.f2581p0.get(i6)).floatValue() - minSeparation)));
        Iterator it = this.m.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            ((Float) this.f2581p0.get(i)).getClass();
            throw null;
        }
        AccessibilityManager accessibilityManager = this.i;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            Runnable runnable = this.f2574j;
            if (runnable == null) {
                this.f2574j = new RunnableC0913p(this);
            } else {
                removeCallbacks(runnable);
            }
            RunnableC0913p runnableC0913p = this.f2574j;
            runnableC0913p.b = i;
            postDelayed(runnableC0913p, 200L);
        }
        return true;
    }

    public final void z() {
        double dRound;
        float f = this.f2553R0;
        float f7 = this.s0;
        if (f7 > 0.0f) {
            dRound = Math.round(f * r1) / ((int) ((this.f2580o0 - this.f2579n0) / f7));
        } else {
            dRound = f;
        }
        if (q() || r()) {
            dRound = 1.0d - dRound;
        }
        float f9 = this.f2580o0;
        y((float) ((dRound * (f9 - r1)) + this.f2579n0), this.f2583q0);
    }

    public void setValues(@NonNull List<Float> list) {
        x(new ArrayList(list));
    }

    public void setCustomThumbDrawablesForValues(@NonNull Drawable... drawableArr) {
        this.f2549P0 = null;
        this.f2551Q0 = new ArrayList();
        for (Drawable drawable : drawableArr) {
            List list = this.f2551Q0;
            Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
            a(drawableNewDrawable);
            list.add(drawableNewDrawable);
        }
        postInvalidate();
    }
}

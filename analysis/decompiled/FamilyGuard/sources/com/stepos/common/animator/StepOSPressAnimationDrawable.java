package com.stepos.common.animator;

import H1.m;
import N1.h;
import P.e;
import P.g;
import P.i;
import P.j;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Interpolator;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import t1.C1115h;
import t1.k;
import t1.l;

/* loaded from: classes.dex */
public class StepOSPressAnimationDrawable extends StateListDrawable {

    /* renamed from: C, reason: collision with root package name */
    private static final Interpolator f13561C = androidx.core.view.animation.a.a(0.4f, 0.0f, 0.58f, 1.0f);

    /* renamed from: D, reason: collision with root package name */
    private static final Interpolator f13562D = androidx.core.view.animation.a.a(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: E, reason: collision with root package name */
    public static final /* synthetic */ int f13563E = 0;

    /* renamed from: A, reason: collision with root package name */
    private int f13564A;

    /* renamed from: B, reason: collision with root package name */
    private int f13565B;

    /* renamed from: a, reason: collision with root package name */
    private C1115h f13566a;

    /* renamed from: c, reason: collision with root package name */
    protected int f13568c;

    /* renamed from: d, reason: collision with root package name */
    protected int f13569d;

    /* renamed from: e, reason: collision with root package name */
    private float f13570e;

    /* renamed from: f, reason: collision with root package name */
    private int f13571f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f13572g;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f13573h;

    /* renamed from: i, reason: collision with root package name */
    private ValueAnimator f13574i;

    /* renamed from: j, reason: collision with root package name */
    private i f13575j;

    /* renamed from: r, reason: collision with root package name */
    private int f13583r;

    /* renamed from: s, reason: collision with root package name */
    private int f13584s;

    /* renamed from: v, reason: collision with root package name */
    private boolean f13587v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f13588w;

    /* renamed from: y, reason: collision with root package name */
    private int f13590y;

    /* renamed from: z, reason: collision with root package name */
    private int f13591z;

    /* renamed from: b, reason: collision with root package name */
    private Rect f13567b = new Rect();

    /* renamed from: o, reason: collision with root package name */
    private int f13580o = 0;

    /* renamed from: k, reason: collision with root package name */
    private float f13576k = 1.0f;

    /* renamed from: l, reason: collision with root package name */
    private float f13577l = 1.0f;

    /* renamed from: p, reason: collision with root package name */
    private int f13581p = -16777216;

    /* renamed from: n, reason: collision with root package name */
    private float f13579n = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    private float f13578m = 0.03f;

    /* renamed from: q, reason: collision with root package name */
    private boolean f13582q = true;

    /* renamed from: x, reason: collision with root package name */
    private boolean f13589x = false;

    /* renamed from: t, reason: collision with root package name */
    private int f13585t = 0;

    /* renamed from: u, reason: collision with root package name */
    private int f13586u = 0;

    class a implements e.r {
        a() {
        }

        @Override // P.e.r
        public void a(P.e eVar, float f5, float f6) {
            StepOSPressAnimationDrawable.this.f13570e = f5 / 100.0f;
            StepOSPressAnimationDrawable.this.invalidateSelf();
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            StepOSPressAnimationDrawable.this.f13571f = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            StepOSPressAnimationDrawable.this.invalidateSelf();
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (StepOSPressAnimationDrawable.this.f13587v) {
                StepOSPressAnimationDrawable.this.f13587v = false;
                StepOSPressAnimationDrawable.this.r();
            }
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            StepOSPressAnimationDrawable.this.f13571f = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            StepOSPressAnimationDrawable.this.invalidateSelf();
        }
    }

    static class e extends Drawable {
        e() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            super.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i5) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public StepOSPressAnimationDrawable() {
        this.f13588w = true;
        addState(new int[]{R.attr.state_pressed}, new e());
        addState(new int[0], new e());
        try {
            Canvas canvas = new Canvas();
            h.b(canvas).a("setNightModeUseOf", Integer.TYPE).a(canvas, 2);
        } catch (Exception e6) {
            Log.e("StepOSSPressDrawable", "setNightModeUseOf error " + e6);
            this.f13588w = false;
        }
    }

    public static /* synthetic */ void a(i iVar) {
        if (iVar != null) {
            iVar.p();
        }
    }

    private void i() {
        k();
        j();
        m();
        l();
        this.f13572g = true;
    }

    private void j() {
        i iVarX = new i(new g()).x(new j().f(0.9f).h(250.0f));
        this.f13575j = iVarX;
        iVarX.m(this.f13577l * 100.0f);
        this.f13570e = this.f13577l;
        this.f13575j.u().g(this.f13576k * 100.0f);
        this.f13575j.c(new a());
    }

    private void k() {
        C1115h c1115h = new C1115h(l.a().r(new k()).o(0.0f).m());
        this.f13566a = c1115h;
        c1115h.setTint(this.f13581p);
        this.f13566a.c0(this.f13580o);
        this.f13566a.setAlpha((int) (this.f13579n * 255.0f));
    }

    private void l() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f13578m, this.f13579n);
        this.f13574i = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(f13561C);
        this.f13574i.setDuration(n() ? 300L : 200L);
        this.f13574i.addUpdateListener(new d());
    }

    private void m() {
        float f5 = n() ? 100.0f : 200.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f13579n, this.f13578m);
        this.f13573h = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(f13561C);
        this.f13573h.setDuration((long) f5);
        this.f13573h.addUpdateListener(new b());
        this.f13573h.addListener(new c());
    }

    private boolean n() {
        return Float.compare(this.f13576k, 1.0f) != 0;
    }

    private void q(final i iVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            iVar.p();
            return;
        }
        Log.w("StepOSSPressDrawable", "Your looper is not on MainLooper, force run on MainLooper now, and trace:" + Log.getStackTraceString(new Throwable()));
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: I1.c
            @Override // java.lang.Runnable
            public final void run() {
                StepOSPressAnimationDrawable.a(iVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.f13574i.setFloatValues(this.f13571f / 255.0f, this.f13579n);
        if (this.f13573h.isRunning()) {
            this.f13587v = true;
        } else {
            this.f13574i.start();
        }
        this.f13575j.m(this.f13570e * 100.0f);
        this.f13575j.u().g(this.f13577l * 100.0f);
        q(this.f13575j);
    }

    private void s() {
        this.f13573h.setFloatValues(this.f13571f / 255.0f, this.f13578m);
        this.f13573h.start();
        if (this.f13574i.isRunning()) {
            this.f13574i.cancel();
        }
        this.f13575j.m(this.f13570e * 100.0f);
        this.f13575j.u().g(this.f13576k * 100.0f);
        q(this.f13575j);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f13588w) {
            try {
                h.b(canvas).a("setNightModeUseOf", Integer.TYPE).a(canvas, 2);
            } catch (Exception unused) {
            }
        }
        if (o()) {
            this.f13567b.set(getBounds().centerX() - (this.f13568c / 2), getBounds().centerY() - (this.f13569d / 2), getBounds().centerX() + (this.f13568c / 2), this.f13569d);
        } else {
            this.f13567b.set((int) (getBounds().centerX() - ((this.f13568c / 2) * this.f13570e)), (int) (getBounds().centerY() - ((this.f13569d / 2) * this.f13570e)), (int) (getBounds().centerX() + ((this.f13568c / 2) * this.f13570e)), (int) (getBounds().centerY() + ((this.f13569d / 2) * this.f13570e)));
        }
        this.f13566a.setAlpha(this.f13571f);
        this.f13566a.setBounds(this.f13567b);
        this.f13566a.draw(canvas);
    }

    protected C1115h g() {
        return this.f13566a;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    protected int h() {
        return this.f13580o;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, m.B5);
        int i5 = m.L5;
        if (typedArrayObtainAttributes.hasValue(i5)) {
            this.f13580o = typedArrayObtainAttributes.getDimensionPixelSize(i5, 0);
        }
        int i6 = m.K5;
        if (typedArrayObtainAttributes.hasValue(i6)) {
            this.f13576k = typedArrayObtainAttributes.getFloat(i6, 1.0f);
        }
        int i7 = m.J5;
        if (typedArrayObtainAttributes.hasValue(i7)) {
            this.f13577l = typedArrayObtainAttributes.getFloat(i7, 1.0f);
        }
        int i8 = m.D5;
        if (typedArrayObtainAttributes.hasValue(i8)) {
            this.f13585t = typedArrayObtainAttributes.getDimensionPixelSize(i8, 0);
        }
        int i9 = m.E5;
        if (typedArrayObtainAttributes.hasValue(i9)) {
            this.f13586u = typedArrayObtainAttributes.getDimensionPixelSize(i9, 0);
        }
        int i10 = m.N5;
        if (typedArrayObtainAttributes.hasValue(i10)) {
            this.f13581p = typedArrayObtainAttributes.getColor(i10, -16777216);
        }
        int i11 = m.H5;
        if (typedArrayObtainAttributes.hasValue(i11)) {
            this.f13579n = typedArrayObtainAttributes.getFloat(i11, 0.0f);
        }
        int i12 = m.I5;
        if (typedArrayObtainAttributes.hasValue(i12)) {
            this.f13578m = typedArrayObtainAttributes.getFloat(i12, 0.03f);
        }
        int i13 = m.P5;
        if (typedArrayObtainAttributes.hasValue(i13)) {
            this.f13582q = typedArrayObtainAttributes.getBoolean(i13, true);
        }
        int i14 = m.G5;
        if (typedArrayObtainAttributes.hasValue(i14)) {
            this.f13589x = typedArrayObtainAttributes.getBoolean(i14, false);
        }
        int i15 = m.M5;
        if (typedArrayObtainAttributes.hasValue(i15)) {
            this.f13590y = typedArrayObtainAttributes.getDimensionPixelSize(i15, 0);
        }
        int i16 = m.F5;
        if (typedArrayObtainAttributes.hasValue(i16)) {
            this.f13591z = typedArrayObtainAttributes.getDimensionPixelSize(i16, 0);
        }
        int i17 = m.O5;
        if (typedArrayObtainAttributes.hasValue(i17)) {
            this.f13564A = typedArrayObtainAttributes.getDimensionPixelSize(i17, 0);
        }
        int i18 = m.C5;
        if (typedArrayObtainAttributes.hasValue(i18)) {
            this.f13565B = typedArrayObtainAttributes.getDimensionPixelSize(i18, 0);
        }
        typedArrayObtainAttributes.recycle();
        if (this.f13572g) {
            return;
        }
        i();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        return true;
    }

    public boolean o() {
        return false;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        int i5;
        super.onBoundsChange(rect);
        getBounds().offset(this.f13585t, this.f13586u);
        if (this.f13582q) {
            this.f13568c = (getBounds().width() - this.f13590y) - this.f13591z;
            this.f13569d = (getBounds().height() - this.f13564A) - this.f13565B;
            return;
        }
        if (!this.f13589x) {
            int i6 = this.f13580o;
            this.f13568c = i6 * 2;
            this.f13569d = i6 * 2;
            return;
        }
        int iMin = Math.min(getBounds().width(), getBounds().height());
        this.f13568c = iMin;
        this.f13569d = iMin;
        int i7 = this.f13583r;
        if (i7 <= 0 || (i5 = this.f13584s) <= 0) {
            return;
        }
        this.f13568c = i7;
        this.f13569d = i5;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        if (!this.f13572g) {
            i();
        }
        boolean z5 = false;
        boolean z6 = false;
        for (int i5 : iArr) {
            if (i5 == 16842910) {
                z5 = true;
            } else if (i5 == 16842919) {
                z6 = true;
            }
        }
        if (z5 && z6) {
            s();
            return zOnStateChange;
        }
        r();
        return zOnStateChange;
    }

    public void p(int i5, int i6) {
        this.f13583r = i5;
        this.f13584s = i6;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        this.f13566a.setAlpha(i5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f13566a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i5) {
        this.f13581p = i5;
    }
}

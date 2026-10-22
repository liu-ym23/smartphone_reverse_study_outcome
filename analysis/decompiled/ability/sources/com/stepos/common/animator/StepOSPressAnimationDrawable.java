package com.stepos.common.animator;

import V4.s;
import android.R;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import e3.C1412a;
import e3.C1417f;
import e3.o;
import e3.p;
import java.lang.reflect.InvocationTargetException;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes3.dex */
public class StepOSPressAnimationDrawable extends StateListDrawable {

    /* renamed from: C, reason: collision with root package name */
    public static final Interpolator f3546C = PathInterpolatorCompat.create(0.4f, 0.0f, 0.58f, 1.0f);

    /* renamed from: A, reason: collision with root package name */
    public int f3547A;

    /* renamed from: B, reason: collision with root package name */
    public int f3548B;

    /* renamed from: a, reason: collision with root package name */
    public e3.k f3549a;
    public int c;
    public int d;
    public float e;
    public int f;
    public boolean g;
    public ValueAnimator h;
    public ValueAnimator i;

    /* renamed from: j, reason: collision with root package name */
    public SpringAnimation f3550j;

    /* renamed from: r, reason: collision with root package name */
    public int f3552r;

    /* renamed from: s, reason: collision with root package name */
    public int f3553s;

    /* renamed from: v, reason: collision with root package name */
    public boolean f3555v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f3556w;
    public int y;

    /* renamed from: z, reason: collision with root package name */
    public int f3558z;
    public final Rect b = new Rect();
    public int o = 0;
    public float k = 1.0f;
    public float l = 1.0f;
    public int p = ViewCompat.MEASURED_STATE_MASK;
    public float n = 0.0f;
    public float m = 0.03f;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3551q = true;

    /* renamed from: x, reason: collision with root package name */
    public boolean f3557x = false;

    /* renamed from: t, reason: collision with root package name */
    public int f3554t = 0;
    public int u = 0;

    static {
        PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
    }

    public StepOSPressAnimationDrawable() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f3556w = true;
        addState(new int[]{R.attr.state_pressed}, new h());
        addState(new int[0], new h());
        try {
            Canvas canvas = new Canvas();
            a5.g.a(canvas).a("setNightModeUseOf", Integer.TYPE).f1642a.invoke(canvas, 2);
        } catch (Exception e) {
            Log.e("StepOSSPressDrawable", "setNightModeUseOf error " + e);
            this.f3556w = false;
        }
    }

    public static void b(SpringAnimation springAnimation) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            springAnimation.start();
            return;
        }
        Log.w("StepOSSPressDrawable", "Your looper is not on MainLooper, force run on MainLooper now, and trace:" + Log.getStackTraceString(new Throwable()));
        new Handler(Looper.getMainLooper()).post(new e(springAnimation, 0));
    }

    public final void a() {
        C1417f c1417f = new C1417f(0);
        C1417f c1417f2 = new C1417f(0);
        C1417f c1417f3 = new C1417f(0);
        C1417f c1417f4 = new C1417f(0);
        e3.n nVar = new e3.n();
        o.b(nVar);
        o.b(nVar);
        o.b(nVar);
        o.b(nVar);
        C1412a c1412a = new C1412a(0.0f);
        C1412a c1412a2 = new C1412a(0.0f);
        C1412a c1412a3 = new C1412a(0.0f);
        C1412a c1412a4 = new C1412a(0.0f);
        p pVar = new p();
        pVar.f4369a = nVar;
        pVar.b = nVar;
        pVar.c = nVar;
        pVar.d = nVar;
        pVar.e = c1412a;
        pVar.f = c1412a2;
        pVar.g = c1412a3;
        pVar.h = c1412a4;
        pVar.i = c1417f;
        pVar.f4370j = c1417f2;
        pVar.k = c1417f3;
        pVar.l = c1417f4;
        e3.k kVar = new e3.k(pVar);
        this.f3549a = kVar;
        kVar.setTint(this.p);
        e3.k kVar2 = this.f3549a;
        float f = this.o;
        o oVarF = kVar2.b.f4345a.f();
        oVarF.c(f);
        kVar2.setShapeAppearanceModel(oVarF.a());
        this.f3549a.setAlpha((int) (this.n * 255.0f));
        SpringAnimation spring = new SpringAnimation(new FloatValueHolder()).setSpring(new SpringForce().setDampingRatio(0.9f).setStiffness(250.0f));
        this.f3550j = spring;
        spring.setStartValue(this.l * 100.0f);
        this.e = this.l;
        this.f3550j.getSpring().setFinalPosition(this.k * 100.0f);
        this.f3550j.addUpdateListener(new f(this));
        float f7 = Float.compare(this.k, 1.0f) == 0 ? 200.0f : 100.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.n, this.m);
        this.h = valueAnimatorOfFloat;
        Interpolator interpolator = f3546C;
        valueAnimatorOfFloat.setInterpolator(interpolator);
        this.h.setDuration((long) f7);
        this.h.addUpdateListener(new g(this, 0));
        this.h.addListener(new A6.m(this, 8));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.m, this.n);
        this.i = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.setInterpolator(interpolator);
        this.i.setDuration(Float.compare(this.k, 1.0f) != 0 ? 300L : 200L);
        this.i.addUpdateListener(new g(this, 1));
        this.g = true;
    }

    public final void c() {
        this.i.setFloatValues(this.f / 255.0f, this.n);
        if (this.h.isRunning()) {
            this.f3555v = true;
        } else {
            this.i.start();
        }
        this.f3550j.setStartValue(this.e * 100.0f);
        this.f3550j.getSpring().setFinalPosition(this.l * 100.0f);
        b(this.f3550j);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f3556w) {
            try {
                a5.g.a(canvas).a("setNightModeUseOf", Integer.TYPE).f1642a.invoke(canvas, 2);
            } catch (Exception unused) {
            }
        }
        boolean z10 = this instanceof ImmersiveListItemDrawable;
        Rect rect = this.b;
        if (z10) {
            rect.set(getBounds().centerX() - (this.c / 2), getBounds().centerY() - (this.d / 2), (this.c / 2) + getBounds().centerX(), this.d);
        } else {
            rect.set((int) (getBounds().centerX() - ((this.c / 2) * this.e)), (int) (getBounds().centerY() - ((this.d / 2) * this.e)), (int) (((this.c / 2) * this.e) + getBounds().centerX()), (int) (((this.d / 2) * this.e) + getBounds().centerY()));
        }
        this.f3549a.setAlpha(this.f);
        this.f3549a.setBounds(rect);
        this.f3549a.draw(canvas);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, s.p);
        if (typedArrayObtainAttributes.hasValue(9)) {
            this.o = typedArrayObtainAttributes.getDimensionPixelSize(9, 0);
        }
        if (typedArrayObtainAttributes.hasValue(8)) {
            this.k = typedArrayObtainAttributes.getFloat(8, 1.0f);
        }
        if (typedArrayObtainAttributes.hasValue(7)) {
            this.l = typedArrayObtainAttributes.getFloat(7, 1.0f);
        }
        if (typedArrayObtainAttributes.hasValue(1)) {
            this.f3554t = typedArrayObtainAttributes.getDimensionPixelSize(1, 0);
        }
        if (typedArrayObtainAttributes.hasValue(2)) {
            this.u = typedArrayObtainAttributes.getDimensionPixelSize(2, 0);
        }
        if (typedArrayObtainAttributes.hasValue(11)) {
            this.p = typedArrayObtainAttributes.getColor(11, ViewCompat.MEASURED_STATE_MASK);
        }
        if (typedArrayObtainAttributes.hasValue(5)) {
            this.n = typedArrayObtainAttributes.getFloat(5, 0.0f);
        }
        if (typedArrayObtainAttributes.hasValue(6)) {
            this.m = typedArrayObtainAttributes.getFloat(6, 0.03f);
        }
        if (typedArrayObtainAttributes.hasValue(13)) {
            this.f3551q = typedArrayObtainAttributes.getBoolean(13, true);
        }
        if (typedArrayObtainAttributes.hasValue(4)) {
            this.f3557x = typedArrayObtainAttributes.getBoolean(4, false);
        }
        if (typedArrayObtainAttributes.hasValue(10)) {
            this.y = typedArrayObtainAttributes.getDimensionPixelSize(10, 0);
        }
        if (typedArrayObtainAttributes.hasValue(3)) {
            this.f3558z = typedArrayObtainAttributes.getDimensionPixelSize(3, 0);
        }
        if (typedArrayObtainAttributes.hasValue(12)) {
            this.f3547A = typedArrayObtainAttributes.getDimensionPixelSize(12, 0);
        }
        if (typedArrayObtainAttributes.hasValue(0)) {
            this.f3548B = typedArrayObtainAttributes.getDimensionPixelSize(0, 0);
        }
        typedArrayObtainAttributes.recycle();
        if (this.g) {
            return;
        }
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        return !(this instanceof ImmersiveListItemDrawable);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        int i;
        super.onBoundsChange(rect);
        getBounds().offset(this.f3554t, this.u);
        if (this.f3551q) {
            this.c = (getBounds().width() - this.y) - this.f3558z;
            this.d = (getBounds().height() - this.f3547A) - this.f3548B;
            return;
        }
        if (!this.f3557x) {
            int i6 = this.o;
            this.c = i6 * 2;
            this.d = i6 * 2;
            return;
        }
        int iMin = Math.min(getBounds().width(), getBounds().height());
        this.c = iMin;
        this.d = iMin;
        int i10 = this.f3552r;
        if (i10 <= 0 || (i = this.f3553s) <= 0) {
            return;
        }
        this.c = i10;
        this.d = i;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        if (!this.g) {
            a();
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z10 = true;
            } else if (i == 16842919) {
                z11 = true;
            }
        }
        if (!z10 || !z11) {
            c();
            return zOnStateChange;
        }
        this.h.setFloatValues(this.f / 255.0f, this.m);
        this.h.start();
        if (this.i.isRunning()) {
            this.i.cancel();
        }
        this.f3550j.setStartValue(this.e * 100.0f);
        this.f3550j.getSpring().setFinalPosition(this.k * 100.0f);
        b(this.f3550j);
        return zOnStateChange;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f3549a.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f3549a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        this.p = i;
    }
}

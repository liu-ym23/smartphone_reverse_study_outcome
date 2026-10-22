package com.stepos.common.animator;

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
import android.view.animation.PathInterpolator;
import f7.a;
import f7.f;
import f7.i;
import f7.l;
import f7.m;
import id.k;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;
import org.xmlpull.v1.XmlPullParser;
import r9.e;
import r9.h;
import w.d;
import z3.g;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class StepOSPressAnimationDrawable extends StateListDrawable {
    public static final PathInterpolator G = new PathInterpolator(0.4f, 0.0f, 0.58f, 1.0f);
    public final boolean A;
    public int C;
    public int D;
    public int E;
    public int F;

    /* renamed from: c, reason: collision with root package name */
    public i f2514c;

    /* renamed from: g, reason: collision with root package name */
    public int f2516g;

    /* renamed from: h, reason: collision with root package name */
    public int f2517h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public int f2518j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2519k;

    /* renamed from: l, reason: collision with root package name */
    public ValueAnimator f2520l;

    /* renamed from: m, reason: collision with root package name */
    public ValueAnimator f2521m;

    /* renamed from: n, reason: collision with root package name */
    public g f2522n;

    /* renamed from: v, reason: collision with root package name */
    public int f2530v;

    /* renamed from: w, reason: collision with root package name */
    public int f2531w;

    /* renamed from: z, reason: collision with root package name */
    public boolean f2534z;

    /* renamed from: f, reason: collision with root package name */
    public final Rect f2515f = new Rect();

    /* renamed from: s, reason: collision with root package name */
    public int f2527s = 0;

    /* renamed from: o, reason: collision with root package name */
    public float f2523o = 1.0f;

    /* renamed from: p, reason: collision with root package name */
    public float f2524p = 1.0f;

    /* renamed from: t, reason: collision with root package name */
    public int f2528t = -16777216;

    /* renamed from: r, reason: collision with root package name */
    public float f2526r = 0.0f;

    /* renamed from: q, reason: collision with root package name */
    public float f2525q = 0.03f;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2529u = true;
    public boolean B = false;

    /* renamed from: x, reason: collision with root package name */
    public int f2532x = 0;

    /* renamed from: y, reason: collision with root package name */
    public int f2533y = 0;

    static {
        k.m(0.33f, 0.0f, 0.67f, 1.0f);
    }

    public StepOSPressAnimationDrawable() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.A = true;
        addState(new int[]{R.attr.state_pressed}, new h());
        addState(new int[0], new h());
        try {
            Canvas canvas = new Canvas();
            u9.g.a(canvas).a("setNightModeUseOf", Integer.TYPE).f14264a.invoke(canvas, 2);
        } catch (Exception e10) {
            Log.e("StepOSSPressDrawable", "setNightModeUseOf error " + e10);
            this.A = false;
        }
    }

    public static void b(g gVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            gVar.g();
            return;
        }
        Log.w("StepOSSPressDrawable", "Your looper is not on MainLooper, force run on MainLooper now, and trace:" + Log.getStackTraceString(new Throwable()));
        Handler handler = new Handler(Looper.getMainLooper());
        e eVar = new e(0);
        eVar.f10501f = gVar;
        VarHandle.storeStoreFence();
        handler.post(eVar);
    }

    public final void a() {
        int i = 0;
        f fVar = new f(i);
        f fVar2 = new f(i);
        f fVar3 = new f(i);
        f fVar4 = new f(i);
        f7.k kVar = new f7.k();
        a aVar = new a(0.0f);
        a aVar2 = new a(0.0f);
        a aVar3 = new a(0.0f);
        a aVar4 = new a(0.0f);
        m mVar = new m();
        mVar.f3986a = kVar;
        mVar.f3987b = kVar;
        mVar.f3988c = kVar;
        mVar.f3989d = kVar;
        mVar.f3990e = aVar;
        mVar.f3991f = aVar2;
        mVar.f3992g = aVar3;
        mVar.f3993h = aVar4;
        mVar.i = fVar;
        mVar.f3994j = fVar2;
        mVar.f3995k = fVar3;
        mVar.f3996l = fVar4;
        i iVar = new i(mVar);
        this.f2514c = iVar;
        iVar.setTint(this.f2528t);
        i iVar2 = this.f2514c;
        float f5 = this.f2527s;
        l lVarF = iVar2.f3954f.f3936a.f();
        lVarF.f3979e = new a(f5);
        lVarF.f3980f = new a(f5);
        lVarF.f3981g = new a(f5);
        lVarF.f3982h = new a(f5);
        iVar2.setShapeAppearanceModel(lVarF.a());
        this.f2514c.setAlpha((int) (this.f2526r * 255.0f));
        z3.h hVar = new z3.h();
        hVar.a(0.9f);
        hVar.b(250.0f);
        g gVar = new g(new d());
        gVar.f16369k = hVar;
        this.f2522n = gVar;
        float f10 = this.f2524p;
        gVar.f16361b = f10 * 100.0f;
        gVar.f16362c = true;
        this.i = f10;
        hVar.i = this.f2523o * 100.0f;
        r9.f fVar5 = new r9.f();
        fVar5.f10502a = this;
        VarHandle.storeStoreFence();
        gVar.a(fVar5);
        float f11 = Float.compare(this.f2523o, 1.0f) == 0 ? 200.0f : 100.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f2526r, this.f2525q);
        this.f2520l = valueAnimatorOfFloat;
        PathInterpolator pathInterpolator = G;
        valueAnimatorOfFloat.setInterpolator(pathInterpolator);
        this.f2520l.setDuration((long) f11);
        ValueAnimator valueAnimator = this.f2520l;
        r9.g gVar2 = new r9.g(0);
        gVar2.f10504b = this;
        VarHandle.storeStoreFence();
        valueAnimator.addUpdateListener(gVar2);
        this.f2520l.addListener(new bb.d(this, 8));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.f2525q, this.f2526r);
        this.f2521m = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.setInterpolator(pathInterpolator);
        this.f2521m.setDuration(Float.compare(this.f2523o, 1.0f) != 0 ? 300L : 200L);
        ValueAnimator valueAnimator2 = this.f2521m;
        r9.g gVar3 = new r9.g(1);
        gVar3.f10504b = this;
        VarHandle.storeStoreFence();
        valueAnimator2.addUpdateListener(gVar3);
        this.f2519k = true;
    }

    public final void c() {
        this.f2521m.setFloatValues(this.f2518j / 255.0f, this.f2526r);
        if (this.f2520l.isRunning()) {
            this.f2534z = true;
        } else {
            this.f2521m.start();
        }
        g gVar = this.f2522n;
        gVar.f16361b = this.i * 100.0f;
        gVar.f16362c = true;
        gVar.f16369k.i = this.f2524p * 100.0f;
        b(gVar);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.A) {
            try {
                u9.g.a(canvas).a("setNightModeUseOf", Integer.TYPE).f14264a.invoke(canvas, 2);
            } catch (Exception unused) {
            }
        }
        int iCenterX = (int) (getBounds().centerX() - ((this.f2516g / 2) * this.i));
        int iCenterY = (int) (getBounds().centerY() - ((this.f2517h / 2) * this.i));
        int iCenterX2 = (int) (((this.f2516g / 2) * this.i) + getBounds().centerX());
        int iCenterY2 = (int) (((this.f2517h / 2) * this.i) + getBounds().centerY());
        Rect rect = this.f2515f;
        rect.set(iCenterX, iCenterY, iCenterX2, iCenterY2);
        this.f2514c.setAlpha(this.f2518j);
        this.f2514c.setBounds(rect);
        this.f2514c.draw(canvas);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, q9.a.f10205h);
        if (typedArrayObtainAttributes.hasValue(9)) {
            this.f2527s = typedArrayObtainAttributes.getDimensionPixelSize(9, 0);
        }
        if (typedArrayObtainAttributes.hasValue(8)) {
            this.f2523o = typedArrayObtainAttributes.getFloat(8, 1.0f);
        }
        if (typedArrayObtainAttributes.hasValue(7)) {
            this.f2524p = typedArrayObtainAttributes.getFloat(7, 1.0f);
        }
        if (typedArrayObtainAttributes.hasValue(1)) {
            this.f2532x = typedArrayObtainAttributes.getDimensionPixelSize(1, 0);
        }
        if (typedArrayObtainAttributes.hasValue(2)) {
            this.f2533y = typedArrayObtainAttributes.getDimensionPixelSize(2, 0);
        }
        if (typedArrayObtainAttributes.hasValue(11)) {
            this.f2528t = typedArrayObtainAttributes.getColor(11, -16777216);
        }
        if (typedArrayObtainAttributes.hasValue(5)) {
            this.f2526r = typedArrayObtainAttributes.getFloat(5, 0.0f);
        }
        if (typedArrayObtainAttributes.hasValue(6)) {
            this.f2525q = typedArrayObtainAttributes.getFloat(6, 0.03f);
        }
        if (typedArrayObtainAttributes.hasValue(13)) {
            this.f2529u = typedArrayObtainAttributes.getBoolean(13, true);
        }
        if (typedArrayObtainAttributes.hasValue(4)) {
            this.B = typedArrayObtainAttributes.getBoolean(4, false);
        }
        if (typedArrayObtainAttributes.hasValue(10)) {
            this.C = typedArrayObtainAttributes.getDimensionPixelSize(10, 0);
        }
        if (typedArrayObtainAttributes.hasValue(3)) {
            this.D = typedArrayObtainAttributes.getDimensionPixelSize(3, 0);
        }
        if (typedArrayObtainAttributes.hasValue(12)) {
            this.E = typedArrayObtainAttributes.getDimensionPixelSize(12, 0);
        }
        if (typedArrayObtainAttributes.hasValue(0)) {
            this.F = typedArrayObtainAttributes.getDimensionPixelSize(0, 0);
        }
        typedArrayObtainAttributes.recycle();
        if (this.f2519k) {
            return;
        }
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isProjected() {
        return true;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        int i;
        super.onBoundsChange(rect);
        getBounds().offset(this.f2532x, this.f2533y);
        if (this.f2529u) {
            this.f2516g = (getBounds().width() - this.C) - this.D;
            this.f2517h = (getBounds().height() - this.E) - this.F;
            return;
        }
        if (!this.B) {
            int i3 = this.f2527s;
            this.f2516g = i3 * 2;
            this.f2517h = i3 * 2;
            return;
        }
        int iMin = Math.min(getBounds().width(), getBounds().height());
        this.f2516g = iMin;
        this.f2517h = iMin;
        int i10 = this.f2530v;
        if (i10 <= 0 || (i = this.f2531w) <= 0) {
            return;
        }
        this.f2516g = i10;
        this.f2517h = i;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        if (!this.f2519k) {
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
        this.f2520l.setFloatValues(this.f2518j / 255.0f, this.f2525q);
        this.f2520l.start();
        if (this.f2521m.isRunning()) {
            this.f2521m.cancel();
        }
        g gVar = this.f2522n;
        gVar.f16361b = this.i * 100.0f;
        gVar.f16362c = true;
        gVar.f16369k.i = this.f2523o * 100.0f;
        b(gVar);
        return zOnStateChange;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f2514c.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f2514c.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        this.f2528t = i;
    }
}

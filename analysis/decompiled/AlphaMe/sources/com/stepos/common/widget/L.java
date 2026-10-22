package com.stepos.common.widget;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class L implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public float f11669a;

    /* renamed from: b, reason: collision with root package name */
    public long f11670b;

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f11671c;

    /* renamed from: d, reason: collision with root package name */
    public long f11672d;

    /* renamed from: e, reason: collision with root package name */
    public Interpolator f11673e;

    /* renamed from: f, reason: collision with root package name */
    public long f11674f;

    /* renamed from: g, reason: collision with root package name */
    public float f11675g;

    /* renamed from: h, reason: collision with root package name */
    public long f11676h;

    /* renamed from: i, reason: collision with root package name */
    public Interpolator f11677i;

    /* renamed from: j, reason: collision with root package name */
    public long f11678j;

    /* renamed from: k, reason: collision with root package name */
    public Interpolator f11679k;

    /* renamed from: l, reason: collision with root package name */
    public long f11680l;

    /* renamed from: m, reason: collision with root package name */
    public float f11681m;

    /* renamed from: n, reason: collision with root package name */
    public long f11682n;

    /* renamed from: o, reason: collision with root package name */
    public Interpolator f11683o;

    /* renamed from: p, reason: collision with root package name */
    public long f11684p;

    /* renamed from: q, reason: collision with root package name */
    public Interpolator f11685q;

    /* renamed from: r, reason: collision with root package name */
    public long f11686r;

    /* renamed from: s, reason: collision with root package name */
    public com.google.android.gms.common.api.internal.p f11687s;

    public static float a(float f4, long j4, long j5, long j6, float f5, Interpolator interpolator, Interpolator interpolator2) {
        float f6 = f4 - j4;
        if (f6 < Property.DEFAULT_FLOAT_VALUE) {
            f6 += j5 + j6;
        }
        float f7 = j5;
        if (f6 < f7) {
            return (interpolator.getInterpolation(f6 / f7) * (f5 - Property.DEFAULT_FLOAT_VALUE)) + Property.DEFAULT_FLOAT_VALUE;
        }
        return (interpolator2.getInterpolation((f6 - f7) / j6) * (Property.DEFAULT_FLOAT_VALUE - f5)) + f5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.f11687s == null) {
            return;
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float fA = a(fFloatValue, this.f11674f, this.f11670b, this.f11672d, this.f11669a, this.f11671c, this.f11673e);
        float fA2 = a(fFloatValue, this.f11680l, this.f11676h, this.f11678j, this.f11675g, this.f11677i, this.f11679k);
        float fA3 = a(fFloatValue, this.f11686r, this.f11682n, this.f11684p, this.f11681m, this.f11683o, this.f11685q);
        SwimmingAnimationView swimmingAnimationView = (SwimmingAnimationView) this.f11687s.f9664b;
        swimmingAnimationView.f11825e = fA;
        swimmingAnimationView.f11826f = fA2;
        swimmingAnimationView.f11827g = fA3;
        swimmingAnimationView.invalidate();
    }
}

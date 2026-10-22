package com.stepos.common.widget;

import android.animation.ValueAnimator;

/* loaded from: classes3.dex */
public final class P implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public float f3729a;
    public long b;
    public X4.a c;
    public long d;
    public X4.a e;
    public float f;
    public long g;
    public X4.a h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public X4.a f3730j;
    public long k;
    public float l;
    public long m;
    public X4.a n;
    public long o;
    public X4.a p;

    /* renamed from: q, reason: collision with root package name */
    public long f3731q;

    /* renamed from: r, reason: collision with root package name */
    public Q.a f3732r;

    public static float a(float f, long j5, long j6, long j10, float f7, X4.a aVar, X4.a aVar2) {
        float f9 = f - j5;
        if (f9 < 0.0f) {
            f9 += j6 + j10;
        }
        float f10 = j6;
        if (f9 < f10) {
            return (aVar.getInterpolation(f9 / f10) * (f7 - 0.0f)) + 0.0f;
        }
        return (aVar2.getInterpolation((f9 - f10) / j10) * (0.0f - f7)) + f7;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.f3732r == null) {
            return;
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float fA = a(fFloatValue, 0L, this.b, this.d, this.f3729a, this.c, this.e);
        float fA2 = a(fFloatValue, this.k, this.g, this.i, this.f, this.h, this.f3730j);
        float fA3 = a(fFloatValue, this.f3731q, this.m, this.o, this.l, this.n, this.p);
        SwimmingAnimationView swimmingAnimationView = (SwimmingAnimationView) this.f3732r.b;
        swimmingAnimationView.e = fA;
        swimmingAnimationView.f = fA2;
        swimmingAnimationView.g = fA3;
        swimmingAnimationView.invalidate();
    }
}

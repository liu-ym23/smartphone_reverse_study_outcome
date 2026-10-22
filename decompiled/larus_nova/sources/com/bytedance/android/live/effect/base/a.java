package com.bytedance.android.live.effect.base;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f66989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f66990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AdjustPercentBar f66991c;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        float r101 = ((Float) r100.getAnimatedValue()).floatValue();
        AdjustPercentBar r102 = this.f66991c;
        int r103 = this.f66989a;
        r102.f66932v = (int) (r103 + ((this.f66990b - r103) * r101));
        r102.invalidate();
    }

    public a(AdjustPercentBar r100, int r101, int r102) {
        this.f66991c = r100;
        this.f66989a = r101;
        this.f66990b = r102;
    }
}

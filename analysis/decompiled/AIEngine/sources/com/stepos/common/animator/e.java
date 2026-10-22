package com.stepos.common.animator;

import android.animation.ValueAnimator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StepOSPressAnimationDrawable f6468a;

    public e(StepOSPressAnimationDrawable stepOSPressAnimationDrawable) {
        this.f6468a = stepOSPressAnimationDrawable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        StepOSPressAnimationDrawable stepOSPressAnimationDrawable = this.f6468a;
        stepOSPressAnimationDrawable.h = iFloatValue;
        stepOSPressAnimationDrawable.invalidateSelf();
    }
}

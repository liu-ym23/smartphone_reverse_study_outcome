package com.stepos.common.animator;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11294a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StepOSPressAnimationDrawable f11295b;

    public /* synthetic */ g(StepOSPressAnimationDrawable stepOSPressAnimationDrawable, int i4) {
        this.f11294a = i4;
        this.f11295b = stepOSPressAnimationDrawable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i4 = this.f11294a;
        StepOSPressAnimationDrawable stepOSPressAnimationDrawable = this.f11295b;
        switch (i4) {
            case 0:
                stepOSPressAnimationDrawable.f11246f = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                stepOSPressAnimationDrawable.invalidateSelf();
                break;
            default:
                stepOSPressAnimationDrawable.f11246f = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                stepOSPressAnimationDrawable.invalidateSelf();
                break;
        }
    }
}

package com.stepos.common.animator;

import android.animation.ValueAnimator;

/* loaded from: classes3.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3565a;
    public final /* synthetic */ StepOSPressAnimationDrawable b;

    public /* synthetic */ g(StepOSPressAnimationDrawable stepOSPressAnimationDrawable, int i) {
        this.f3565a = i;
        this.b = stepOSPressAnimationDrawable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f3565a) {
            case 0:
                int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                StepOSPressAnimationDrawable stepOSPressAnimationDrawable = this.b;
                stepOSPressAnimationDrawable.f = iFloatValue;
                stepOSPressAnimationDrawable.invalidateSelf();
                break;
            default:
                int iFloatValue2 = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                StepOSPressAnimationDrawable stepOSPressAnimationDrawable2 = this.b;
                stepOSPressAnimationDrawable2.f = iFloatValue2;
                stepOSPressAnimationDrawable2.invalidateSelf();
                break;
        }
    }
}

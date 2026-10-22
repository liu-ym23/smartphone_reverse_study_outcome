package com.stepos.common.animator;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: classes3.dex */
public final class f implements DynamicAnimation.OnAnimationUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StepOSPressAnimationDrawable f3564a;

    public f(StepOSPressAnimationDrawable stepOSPressAnimationDrawable) {
        this.f3564a = stepOSPressAnimationDrawable;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f7) {
        StepOSPressAnimationDrawable stepOSPressAnimationDrawable = this.f3564a;
        stepOSPressAnimationDrawable.e = f / 100.0f;
        stepOSPressAnimationDrawable.invalidateSelf();
    }
}

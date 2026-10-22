package com.google.android.material.appbar;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: classes3.dex */
public final class j implements DynamicAnimation.OnAnimationEndListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StepOSAppBarBehavior f2294a;

    public j(StepOSAppBarBehavior stepOSAppBarBehavior) {
        this.f2294a = stepOSAppBarBehavior;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z10, float f, float f7) {
        StepOSAppBarBehavior stepOSAppBarBehavior = this.f2294a;
        if (stepOSAppBarBehavior.f2286r) {
            return;
        }
        stepOSAppBarBehavior.a();
    }
}

package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import stepos.support.v7.widget.StepOSAppBarLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StepOSAppBarLayout.a f4596a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StepOSAppBarBehavior f4597b;

    public g(StepOSAppBarBehavior stepOSAppBarBehavior, StepOSAppBarLayout.a aVar) {
        this.f4597b = stepOSAppBarBehavior;
        this.f4596a = aVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AppBarLayout appBarLayout;
        StepOSAppBarBehavior stepOSAppBarBehavior = this.f4597b;
        CoordinatorLayout coordinatorLayout = stepOSAppBarBehavior.f4571q;
        if (coordinatorLayout == null || (appBarLayout = stepOSAppBarBehavior.r) == null) {
            return;
        }
        stepOSAppBarBehavior.m(coordinatorLayout, appBarLayout, ((Integer) this.f4596a.getAnimatedValue()).intValue());
    }
}

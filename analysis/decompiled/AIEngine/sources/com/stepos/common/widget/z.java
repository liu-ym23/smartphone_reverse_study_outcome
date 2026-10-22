package com.stepos.common.widget;

import android.animation.ValueAnimator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class z implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StepOSRatingBar f7208a;

    public z(StepOSRatingBar stepOSRatingBar) {
        this.f7208a = stepOSRatingBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int i10 = 0;
        while (true) {
            StepOSRatingBar stepOSRatingBar = this.f7208a;
            if (i10 >= stepOSRatingBar.getNumStars()) {
                stepOSRatingBar.invalidate();
                return;
            } else {
                stepOSRatingBar.f7071o[i10] = Math.min(Math.max(0.0f, (stepOSRatingBar.f7072p[i10] + fIntValue) - (i10 * 16.0f)), stepOSRatingBar.f7073q + stepOSRatingBar.r);
                i10++;
            }
        }
    }
}

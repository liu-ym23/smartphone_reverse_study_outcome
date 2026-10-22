package com.stepos.common.widget;

import android.animation.ValueAnimator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CircularProgressButton f7151a;

    public f(CircularProgressButton circularProgressButton) {
        this.f7151a = circularProgressButton;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        CircularProgressButton circularProgressButton = this.f7151a;
        circularProgressButton.c0 = iIntValue;
        circularProgressButton.invalidate();
    }
}

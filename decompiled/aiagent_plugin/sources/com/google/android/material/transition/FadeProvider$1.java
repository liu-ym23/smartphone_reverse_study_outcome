package com.google.android.material.transition;

import android.animation.ValueAnimator;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class FadeProvider$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ float val$endFraction;
    final /* synthetic */ float val$endValue;
    final /* synthetic */ float val$startFraction;
    final /* synthetic */ float val$startValue;
    final /* synthetic */ View val$view;

    FadeProvider$1(View r1, float r2, float r3, float r4, float r5) {
        this.val$view = r1;
        this.val$startValue = r2;
        this.val$endValue = r3;
        this.val$startFraction = r4;
        this.val$endFraction = r5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r5) {
        float r6 = ((Float) ZeusTransformUtils.preCheckCast(r5.getAnimatedValue(), Float.class, "com.obric.aiagent.plugin")).floatValue();
        this.val$view.setAlpha(n.a(this.val$startValue, this.val$endValue, this.val$startFraction, this.val$endFraction, r6));
    }
}

package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CircularRevealCompat.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static Animator a(CircularRevealWidget r7, float r8, float r9, float r10) {
        CircularRevealWidget r11 = (CircularRevealWidget) ZeusTransformUtils.wrapperContextForParams(r7, CircularRevealWidget.class, "com.obric.aiagent.plugin");
        ObjectAnimator r0 = ObjectAnimator.ofObject(r11, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.a[]{new CircularRevealWidget.a(r8, r9, r10)});
        if (Build.VERSION.SDK_INT < 21) goto L10;
        CircularRevealWidget.a r2 = r11.getRevealInfo();
        if (r2 == null) goto L9;
        Animator r12 = ViewAnimationUtils.createCircularReveal((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"), (int) r8, (int) r9, r2.f13297c, r10);
        AnimatorSet r13 = new AnimatorSet();
        r13.playTogether(new Animator[]{r0, r12});
        return r13;
    L9:
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    L10:
        return r0;
    }

    public static Animator.AnimatorListener a(CircularRevealWidget r2) {
        final CircularRevealWidget r3 = (CircularRevealWidget) ZeusTransformUtils.wrapperContextForParams(r2, CircularRevealWidget.class, "com.obric.aiagent.plugin");
        return new CircularRevealCompat$1(r3);
    }
}

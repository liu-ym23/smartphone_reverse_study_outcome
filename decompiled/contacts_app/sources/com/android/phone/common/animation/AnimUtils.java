package com.android.phone.common.animation;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.android.phone.common.compat.PathInterpolatorCompat;

/* JADX INFO: loaded from: classes2.dex */
public class AnimUtils {
    public static final int DEFAULT_DURATION = -1;
    public static final Interpolator EASE_IN = null;
    public static final Interpolator EASE_OUT = null;
    public static final Interpolator EASE_OUT_EASE_IN = null;
    public static final int NO_DELAY = 0;

    public static class AnimationCallback {
        public void onAnimationCancel() {
        }

        public void onAnimationEnd() {
        }

        public AnimationCallback() {
        }
    }

    public AnimUtils() {
    }

    static {
        EASE_IN = PathInterpolatorCompat.create(0.0f, 0.0f, 0.2f, 1.0f);
        EASE_OUT = PathInterpolatorCompat.create(0.4f, 0.0f, 1.0f, 1.0f);
        EASE_OUT_EASE_IN = PathInterpolatorCompat.create(0.4f, 0.0f, 0.2f, 1.0f);
    }

    public static void crossFadeViews(View r0, View r1, int r2) {
        fadeIn(r0, r2);
        fadeOut(r1, r2);
    }

    public static void fadeOut(View r1, int r2) {
        fadeOut(r1, r2, null);
    }

    public static void fadeOut(final View r3, int r4, final AnimationCallback r5) {
        r3.setAlpha(1.0f);
        ViewPropertyAnimator r0 = r3.animate();
        r0.cancel();
        r0.alpha(0.0f).withLayer().setListener(new AnonymousClass1(r3, r5));
        if (r4 == (-1)) goto L5;
        r0.setDuration(r4);
    L5:
        r0.start();
    }

    public static void fadeIn(View r2, int r3) {
        fadeIn(r2, r3, 0, null);
    }

    public static void fadeIn(final View r3, int r4, int r5, final AnimationCallback r6) {
        r3.setAlpha(0.0f);
        ViewPropertyAnimator r0 = r3.animate();
        r0.cancel();
        r0.setStartDelay(r5);
        r0.alpha(1.0f).withLayer().setListener(new AnonymousClass2(r3, r6));
        if (r4 == (-1)) goto L5;
        r0.setDuration(r4);
    L5:
        r0.start();
    }

    public static void scaleIn(final View r7, int r8, int r9) {
        scaleInternal(r7, 0, 1, r8, r9, new AnonymousClass3(r7), EASE_IN);
    }

    public static void scaleOut(final View r7, int r8) {
        scaleInternal(r7, 1, 0, r8, 0, new AnonymousClass4(r7), EASE_OUT);
    }

    private static void scaleInternal(View r0, int r1, int r2, int r3, int r4, AnimatorListenerAdapter r5, Interpolator r6) {
        float r7 = r1;
        r0.setScaleX(r7);
        r0.setScaleY(r7);
        ViewPropertyAnimator r8 = r0.animate();
        r8.cancel();
        float r9 = r2;
        r8.setInterpolator(r6).scaleX(r9).scaleY(r9).setListener(r5).withLayer();
        if (r3 == (-1)) goto L5;
        r8.setDuration(r3);
    L5:
        r8.setStartDelay(r4);
        r8.start();
    }

    public static void changeDimensions(final View r7, int r8, int r9) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        final int r4 = r7.getWidth();
        final int r6 = r7.getHeight();
        final int r3 = r8 - r4;
        final int r5 = r9 - r6;
        r0.addUpdateListener(new AnonymousClass5(r7, r3, r4, r5, r6));
        r0.start();
    }
}

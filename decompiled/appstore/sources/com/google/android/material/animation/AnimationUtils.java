package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import x.a;
import x.b;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AnimationUtils {
    public static final TimeInterpolator DECELERATE_INTERPOLATOR = null;
    public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = null;
    public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = null;
    public static final TimeInterpolator LINEAR_INTERPOLATOR = null;
    public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = null;

    static {
        LINEAR_INTERPOLATOR = new LinearInterpolator();
        FAST_OUT_SLOW_IN_INTERPOLATOR = new b();
        FAST_OUT_LINEAR_IN_INTERPOLATOR = new a();
        LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();
        DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    }

    public AnimationUtils() {
    }

    public static float lerp(float r10, float r11, float r12) {
        return r10 + (r12 * (r11 - r10));
    }

    public static int lerp(int r10, int r11, float r12) {
        return r10 + Math.round(r12 * (r11 - r10));
    }

    public static float lerp(float r10, float r11, @FloatRange(from = 0.0d, to = 1.0d) float r12, @FloatRange(from = 0.0d, to = 1.0d) float r13, @FloatRange(from = 0.0d, to = 1.0d) float r14) {
        if (r14 >= r12) goto L6;
        return r10;
    L6:
        if (r14 <= r13) goto L9;
        return r11;
    L9:
        return lerp(r10, r11, (r14 - r12) / (r13 - r12));
    }
}

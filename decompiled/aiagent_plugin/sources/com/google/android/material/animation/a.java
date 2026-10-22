package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* JADX INFO: compiled from: AnimationUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f13142a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f13143b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f13144c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f13145d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f13146e = null;

    public static float a(float r0, float r1, float r2) {
        return r0 + (r2 * (r1 - r0));
    }

    static {
        f13142a = new LinearInterpolator();
        f13143b = new FastOutSlowInInterpolator();
        f13144c = new FastOutLinearInInterpolator();
        f13145d = new LinearOutSlowInInterpolator();
        f13146e = new DecelerateInterpolator();
    }

    public static int a(int r0, int r1, float r2) {
        return r0 + Math.round(r2 * (r1 - r0));
    }

    public static float a(float r1, float r2, float r3, float r4, float r5) {
        if (r5 >= r3) goto L6;
        return r1;
    L6:
        if (r5 <= r4) goto L9;
        return r2;
    L9:
        return a(r1, r2, (r5 - r3) / (r4 - r3));
    }
}

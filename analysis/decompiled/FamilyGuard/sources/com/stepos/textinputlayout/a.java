package com.stepos.textinputlayout;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    static final Interpolator f16027a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    static final Interpolator f16028b = new U.b();

    /* renamed from: c, reason: collision with root package name */
    static final Interpolator f16029c = new DecelerateInterpolator();

    static float a(float f5, float f6, float f7) {
        return f5 + (f7 * (f6 - f5));
    }
}

package stepos.support.v7.widget;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Interpolator f21963a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    static final Interpolator f21964b = new U.b();

    /* renamed from: c, reason: collision with root package name */
    static final Interpolator f21965c = new U.a();

    /* renamed from: d, reason: collision with root package name */
    static final Interpolator f21966d = new U.c();

    /* renamed from: e, reason: collision with root package name */
    public static final Interpolator f21967e = new DecelerateInterpolator();

    /* renamed from: f, reason: collision with root package name */
    public static final Interpolator f21968f = new AccelerateDecelerateInterpolator();

    /* renamed from: g, reason: collision with root package name */
    public static final Interpolator f21969g = androidx.core.view.animation.a.a(0.0f, 0.33f, 0.1f, 1.0f);

    /* renamed from: h, reason: collision with root package name */
    public static final Interpolator f21970h = androidx.core.view.animation.a.a(0.0f, 0.66f, 0.66f, 1.0f);

    /* renamed from: i, reason: collision with root package name */
    public static final Interpolator f21971i = androidx.core.view.animation.a.a(0.0f, 0.0f, 0.6f, 1.0f);

    /* renamed from: j, reason: collision with root package name */
    public static final Interpolator f21972j = androidx.core.view.animation.a.a(0.4f, 0.0f, 0.4f, 1.0f);

    public static float a(float f5, float f6, float f7) {
        return f5 + (f7 * (f6 - f5));
    }

    public static int b(int i5, int i6, float f5) {
        return i5 + Math.round(f5 * (i6 - i5));
    }
}

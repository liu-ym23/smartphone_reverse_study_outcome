package stepos.support.v7.widget;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Interpolator f41532a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final Interpolator f41533b = new T0.b();

    /* renamed from: c, reason: collision with root package name */
    public static final Interpolator f41534c = new T0.a();

    /* renamed from: d, reason: collision with root package name */
    public static final Interpolator f41535d = new T0.c();

    /* renamed from: e, reason: collision with root package name */
    public static final Interpolator f41536e = new DecelerateInterpolator();

    /* renamed from: f, reason: collision with root package name */
    public static final Interpolator f41537f = new AccelerateDecelerateInterpolator();

    /* renamed from: g, reason: collision with root package name */
    public static final Interpolator f41538g = D0.a.a(0.0f, 0.33f, 0.1f, 1.0f);

    /* renamed from: h, reason: collision with root package name */
    public static final Interpolator f41539h = D0.a.a(0.0f, 0.66f, 0.66f, 1.0f);

    /* renamed from: i, reason: collision with root package name */
    public static final Interpolator f41540i = D0.a.a(0.0f, 0.0f, 0.6f, 1.0f);

    /* renamed from: j, reason: collision with root package name */
    public static final Interpolator f41541j = D0.a.a(0.4f, 0.0f, 0.4f, 1.0f);

    public static float a(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }
}

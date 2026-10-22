package stepos.support.v7.widget;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final o1.a f12706a;

    /* renamed from: b, reason: collision with root package name */
    public static final o1.a f12707b;

    /* renamed from: c, reason: collision with root package name */
    public static final PathInterpolator f12708c;

    /* renamed from: d, reason: collision with root package name */
    public static final PathInterpolator f12709d;

    static {
        new LinearInterpolator();
        new o1.b();
        f12706a = new o1.a(0);
        f12707b = new o1.a(1);
        new DecelerateInterpolator();
        new AccelerateDecelerateInterpolator();
        x0.a.a(0.0f, 0.33f, 0.1f, 1.0f);
        x0.a.a(0.0f, 0.66f, 0.66f, 1.0f);
        f12708c = new PathInterpolator(0.0f, 0.0f, 0.6f, 1.0f);
        f12709d = new PathInterpolator(0.4f, 0.0f, 0.4f, 1.0f);
    }
}

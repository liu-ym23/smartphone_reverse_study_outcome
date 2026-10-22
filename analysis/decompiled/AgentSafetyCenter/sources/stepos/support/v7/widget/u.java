package stepos.support.v7.widget;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final e4.a f12836a;

    /* renamed from: b, reason: collision with root package name */
    public static final e4.a f12837b;

    /* renamed from: c, reason: collision with root package name */
    public static final PathInterpolator f12838c;

    /* renamed from: d, reason: collision with root package name */
    public static final PathInterpolator f12839d;

    static {
        new LinearInterpolator();
        new e4.a(1);
        f12836a = new e4.a(0);
        f12837b = new e4.a(2);
        new DecelerateInterpolator();
        new AccelerateDecelerateInterpolator();
        id.k.m(0.0f, 0.33f, 0.1f, 1.0f);
        id.k.m(0.0f, 0.66f, 0.66f, 1.0f);
        f12838c = new PathInterpolator(0.0f, 0.0f, 0.6f, 1.0f);
        f12839d = new PathInterpolator(0.4f, 0.0f, 0.4f, 1.0f);
    }
}

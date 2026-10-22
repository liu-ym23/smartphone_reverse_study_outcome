package q6;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f10101a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final e4.a f10102b;

    /* renamed from: c, reason: collision with root package name */
    public static final e4.a f10103c;

    /* renamed from: d, reason: collision with root package name */
    public static final DecelerateInterpolator f10104d;

    static {
        new e4.a(1);
        f10102b = new e4.a(0);
        f10103c = new e4.a(2);
        f10104d = new DecelerateInterpolator();
    }

    public static float a(float f5, float f10, float f11, float f12, float f13) {
        return f13 <= f11 ? f5 : f13 >= f12 ? f10 : k0.a.f(f10, f5, (f13 - f11) / (f12 - f11), f5);
    }
}

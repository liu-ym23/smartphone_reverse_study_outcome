package e1;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f2339a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final r0.a f2340b = new r0.a(r0.a.d);

    /* renamed from: c, reason: collision with root package name */
    public static final r0.a f2341c = new r0.a(r0.a.f5061c);
    public static final r0.a d = new r0.a(r0.a.f5062e);

    static {
        new DecelerateInterpolator();
    }

    public static float a(float f3, float f7, float f9) {
        return ((f7 - f3) * f9) + f3;
    }

    public static float b(float f3, float f7, float f9, float f10, float f11) {
        return f11 <= f9 ? f3 : f11 >= f10 ? f7 : a(f3, f7, (f11 - f9) / (f10 - f9));
    }

    public static int c(int i8, int i9, float f3) {
        return Math.round(f3 * (i9 - i8)) + i8;
    }
}

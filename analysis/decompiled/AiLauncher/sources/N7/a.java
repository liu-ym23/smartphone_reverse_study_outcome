package N7;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Interpolator f4852a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final Interpolator f4853b = new T0.b();

    /* renamed from: c, reason: collision with root package name */
    public static final Interpolator f4854c = new DecelerateInterpolator();

    public static float a(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }
}

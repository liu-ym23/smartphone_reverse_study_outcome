package Q2;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f1097a = new LinearInterpolator();
    public static final FastOutSlowInInterpolator b = new FastOutSlowInInterpolator();
    public static final FastOutLinearInInterpolator c = new FastOutLinearInInterpolator();
    public static final LinearOutSlowInInterpolator d = new LinearOutSlowInInterpolator();
    public static final DecelerateInterpolator e = new DecelerateInterpolator();

    public static float a(float f, float f7, float f9) {
        return B7.a.b(f7, f, f9, f);
    }

    public static float b(float f, float f7, float f9, float f10, float f11) {
        return f11 <= f9 ? f : f11 >= f10 ? f7 : a(f, f7, (f11 - f9) / (f10 - f9));
    }

    public static int c(int i, int i6, float f) {
        return Math.round(f * (i6 - i)) + i;
    }
}

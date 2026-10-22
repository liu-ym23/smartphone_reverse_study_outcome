package b1;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* renamed from: b1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0553a {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f11783a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f11784b = new U.b();

    /* renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f11785c = new U.a();

    /* renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f11786d = new U.c();

    /* renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f11787e = new DecelerateInterpolator();

    public static float a(float f5, float f6, float f7) {
        return f5 + (f7 * (f6 - f5));
    }

    public static float b(float f5, float f6, float f7, float f8, float f9) {
        return f9 <= f7 ? f5 : f9 >= f8 ? f6 : a(f5, f6, (f9 - f7) / (f8 - f7));
    }

    public static int c(int i5, int i6, float f5) {
        return i5 + Math.round(f5 * (i6 - i5));
    }
}

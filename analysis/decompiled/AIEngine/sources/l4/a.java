package l4;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import h0.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f10220a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final o1.b f10221b = new o1.b();

    /* renamed from: c, reason: collision with root package name */
    public static final o1.a f10222c = new o1.a(0);

    /* renamed from: d, reason: collision with root package name */
    public static final o1.a f10223d = new o1.a(1);

    /* renamed from: e, reason: collision with root package name */
    public static final DecelerateInterpolator f10224e = new DecelerateInterpolator();

    public static float a(float f8, float f9, float f10) {
        return e.a(f9, f8, f10, f8);
    }

    public static float b(float f8, float f9, float f10, float f11, float f12) {
        return f12 <= f10 ? f8 : f12 >= f11 ? f9 : a(f8, f9, (f12 - f10) / (f11 - f10));
    }

    public static int c(float f8, int i10, int i11) {
        return Math.round(f8 * (i11 - i10)) + i10;
    }
}

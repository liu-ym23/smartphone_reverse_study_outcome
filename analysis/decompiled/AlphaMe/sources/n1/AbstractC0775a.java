package n1;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import c0.C0386a;
import c0.C0387b;
import c0.C0388c;
import s.AbstractC0831a;

/* renamed from: n1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0775a {

    /* renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f13650a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final C0387b f13651b = new C0387b();

    /* renamed from: c, reason: collision with root package name */
    public static final C0386a f13652c = new C0386a();

    /* renamed from: d, reason: collision with root package name */
    public static final C0388c f13653d = new C0388c();

    /* renamed from: e, reason: collision with root package name */
    public static final DecelerateInterpolator f13654e = new DecelerateInterpolator();

    public static float a(float f4, float f5, float f6) {
        return AbstractC0831a.c(f5, f4, f6, f4);
    }

    public static float b(float f4, float f5, float f6, float f7, float f8) {
        return f8 <= f6 ? f4 : f8 >= f7 ? f5 : a(f4, f5, (f8 - f6) / (f7 - f6));
    }

    public static int c(float f4, int i4, int i5) {
        return Math.round(f4 * (i5 - i4)) + i4;
    }
}

package h6;

import f6.s;
import java.util.concurrent.TimeUnit;
import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3065a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f3066b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f3067c;
    public static final int d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f3068e;

    /* renamed from: f, reason: collision with root package name */
    public static final g f3069f;

    static {
        String property;
        int i8 = s.f2661a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        f3065a = property;
        f3066b = f6.a.k("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Util.VLI_MAX);
        int i9 = s.f2661a;
        if (i9 < 2) {
            i9 = 2;
        }
        f3067c = f6.a.l(i9, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        d = f6.a.l(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        f3068e = TimeUnit.SECONDS.toNanos(f6.a.k("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Util.VLI_MAX));
        f3069f = g.f3060a;
    }
}

package pa;

import java.util.concurrent.TimeUnit;
import na.u;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final String f8564a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f8565b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f8566c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f8567d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f8568e;

    /* renamed from: f, reason: collision with root package name */
    public static final g f8569f;

    static {
        String property;
        int i2 = u.f6929a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        f8564a = property;
        f8565b = na.b.k("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i10 = u.f6929a;
        if (i10 < 2) {
            i10 = 2;
        }
        f8566c = na.b.l("kotlinx.coroutines.scheduler.core.pool.size", i10, 8);
        f8567d = na.b.l("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 4);
        f8568e = TimeUnit.SECONDS.toNanos(na.b.k("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f8569f = g.f8559a;
    }
}

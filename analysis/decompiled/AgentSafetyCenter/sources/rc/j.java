package rc;

import java.util.concurrent.TimeUnit;
import pc.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10560a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f10561b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f10562c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f10563d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f10564e;

    /* renamed from: f, reason: collision with root package name */
    public static final g f10565f;

    static {
        String property;
        int i = u.f9986a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        f10560a = property;
        f10561b = pc.a.i("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i3 = u.f9986a;
        if (i3 < 2) {
            i3 = 2;
        }
        f10562c = pc.a.j(i3, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        f10563d = pc.a.j(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        f10564e = TimeUnit.SECONDS.toNanos(pc.a.i("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f10565f = g.f10556a;
    }
}

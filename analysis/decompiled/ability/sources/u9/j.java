package u9;

import java.util.concurrent.TimeUnit;
import s9.AbstractC1921a;
import s9.r;

/* loaded from: classes4.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6747a;
    public static final long b;
    public static final int c;
    public static final int d;
    public static final long e;
    public static final f f;

    static {
        String property;
        int i = r.f6007a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        f6747a = property;
        b = AbstractC1921a.i("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i6 = r.f6007a;
        if (i6 < 2) {
            i6 = 2;
        }
        c = AbstractC1921a.j(i6, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        d = AbstractC1921a.j(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        e = TimeUnit.SECONDS.toNanos(AbstractC1921a.i("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f = f.f6744a;
    }
}

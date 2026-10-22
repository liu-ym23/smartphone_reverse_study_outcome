package f3;

import d3.x;
import f1.AbstractC0557a;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.ranges.RangesKt;

/* loaded from: classes2.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12573a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f12574b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f12575c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f12576d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f12577e;

    /* renamed from: f, reason: collision with root package name */
    public static final f f12578f;

    /* renamed from: g, reason: collision with root package name */
    public static final E3.b f12579g;

    /* renamed from: h, reason: collision with root package name */
    public static final E3.b f12580h;

    static {
        String property;
        int i4 = x.f12483a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        f12573a = property;
        f12574b = AbstractC0557a.d0("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, LongCompanionObject.MAX_VALUE);
        f12575c = AbstractC0557a.e0("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.coerceAtLeast(x.f12483a, 2), 1, 0, 8);
        f12576d = AbstractC0557a.e0("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
        f12577e = TimeUnit.SECONDS.toNanos(AbstractC0557a.d0("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, LongCompanionObject.MAX_VALUE));
        f12578f = f.f12568b;
        f12579g = new E3.b(0);
        f12580h = new E3.b(1);
    }
}

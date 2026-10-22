package com.bytedance.ai.applet.app.foundation.performance;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public abstract class k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicLong f34338g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f34339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f34341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f34342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f34343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f34344f;

    public static final class a {
    }

    public abstract e b(AppletPerformanceOutcome r100, long r101, AppletPerformanceErrorCode r102, String r103);

    static {
        f34338g = new AtomicLong(0);
    }

    public final boolean a(long r100) {
        if (this.f34343e == false) goto L5;
    L9:
        return false;
    L5:
        if (h.a(r100) == false) goto L9;
        if (r100 < this.f34340b) goto L9;
        return true;
    }

    public k(c r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.f34339a = r100;
        this.f34340b = r101;
        this.f34341c = f34338g.incrementAndGet();
        this.f34342d = new Object();
    }

    public final boolean c(AppletPerformanceErrorCode r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        return d(this, AppletPerformanceOutcome.FAILED, 0, r100, r110, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(k r110, AppletPerformanceOutcome r111, long r112, AppletPerformanceErrorCode r113, String r114, int r115) {
        if ((r115 & 2) == 0) goto L5;
        long r100 = RangesKt.coerceAtLeast(System.currentTimeMillis(), r110.f34340b);
    L6:
        Object r101 = null;
        if ((r115 & 8) == 0) goto L9;
        String r102 = null;
    L10:
        Object r103 = r110.f34342d;
        monitor-enter(r103);
    L37:
        th = move-exception;
        throw th;
    L13:
        if (r110.f34343e == false) goto L15;
        Pair r104 = TuplesKt.to(Boolean.FALSE, null);     // Catch: Throwable -> L37
    L31:
        monitor-exit(r103);
        if (((Boolean) r104.getFirst()).booleanValue() == true) goto L35;
        c r105 = r110.f34339a;
        String r106 = "trace already closed: " + r110.f34341c;
        r105.getClass();
        c.k("close", r106);
        return false;
    L35:
        r110.f34339a.i(r110, (e) r104.getSecond());
        return true;
    L15:
        r110.f34343e = true;     // Catch: Throwable -> L37
        if (r110.f34344f == true) goto L30;
        r110.f34344f = true;     // Catch: Throwable -> L37
        long r107 = RangesKt.coerceAtLeast(r100, r110.f34340b);     // Catch: Throwable -> L37
        if (r111 == AppletPerformanceOutcome.SUCCESS) goto L27;
        if (r102 != null) goto L23;
    L28:
        Object r108 = r111.name().toLowerCase(Locale.ROOT);     // Catch: Throwable -> L37
    L29:
        r101 = r110.b(r111, r107, r113, r108);     // Catch: Throwable -> L37
        goto L30
    L23:
        if ((!StringsKt.isBlank(r102)) == false) goto L25;
        r101 = r102;
    L25:
        if (r101 == null) goto L28;
    L27:
        r108 = r101;
    L30:
        r104 = TuplesKt.to(Boolean.TRUE, r101);     // Catch: Throwable -> L37
        goto L31
    L9:
        r102 = r114;
        goto L10
    L5:
        r100 = r112;
        goto L6
    }
}

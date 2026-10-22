package com.obric.performance.power.monitor.g;

import android.os.SystemClock;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: GPSMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f37000a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f37001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f37002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f37003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static List<m<Integer, Long>> f37004e;

    private a() {
    }

    public final int a() {
        return f37001b;
    }

    public final void a(int r1) {
        f37001b = r1;
    }

    static {
        f37000a = new a();
        f37004e = Collections.synchronizedList((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin"));
    }

    public static final void b(int r5) {
        List<m<Integer, Long>> r0 = f37004e;
        o.a(r0);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r2.add(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r3.next(), m.class, "com.obric.aiagent.plugin")).a(), Number.class, "com.obric.aiagent.plugin")).intValue()));
        goto L4
    L7:
        if (((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin")).contains(Integer.valueOf(r5)) == false) goto L9;
        return;
    L9:
        f37004e.add(new m(Integer.valueOf(r5), Long.valueOf(SystemClock.uptimeMillis())));
        ILogDepend.Companion.d("PowerMonitor", "GPSMonitor onRequest: " + r5);
    }

    public static final void c(int r11) {
        List<m<Integer, Long>> r0 = f37004e;
        o.a(r0);
        monitor-enter(r0);
        List<m<Integer, Long>> r1 = f37004e;     // Catch: Throwable -> L22
        o.c(r1, "gpsRequestListenerList");     // Catch: Throwable -> L22
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L22
    L6:
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();     // Catch: Throwable -> L22
        if (((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin")).a(), Number.class, "com.obric.aiagent.plugin")).intValue() != r11) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L6;
    L14:
        m r5 = (m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r5 != null) goto L18;
        monitor-exit(r0);
        return;
    L18:
        f37002c += SystemClock.uptimeMillis() - Math.max(f37003d, ((Number) ZeusTransformUtils.preCheckCast(r5.b(), Number.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Throwable -> L22
        f37004e.remove(r5);     // Catch: Throwable -> L22
        monitor-exit(r0);
        ILogDepend.Companion.d("PowerMonitor", "GPSMonitor onRemove: " + r11 + ", gpsRequestListenerTime: " + f37002c);
        return;
    L10:
        r4 = false;
        goto L11
    L13:
        r3 = null;
    L22:
        th = move-exception;
        throw th;
    }

    public final int b() {
        return f37004e.size();
    }

    public final void c() {
        f37003d = SystemClock.uptimeMillis();
    }

    public final long d() {
        List<m<Integer, Long>> r12 = f37004e;
        o.c(r12, "gpsRequestListenerList");
        monitor-enter(r12);
        List<m<Integer, Long>> r0 = f37004e;     // Catch: Throwable -> L11
        o.c(r0, "gpsRequestListenerList");     // Catch: Throwable -> L11
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L11
        long r3 = 0;
    L6:
        if (r1.hasNext() == false) goto L8;
        r3 = r3 + (SystemClock.uptimeMillis() - Math.max(f37003d, ((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r1.next(), m.class, "com.obric.aiagent.plugin")).b(), Number.class, "com.obric.aiagent.plugin")).longValue()));     // Catch: Throwable -> L11
        goto L6
    L8:
        long r4 = r3 + f37002c;     // Catch: Throwable -> L11
        f37002c = 0;     // Catch: Throwable -> L11
        f37003d = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        monitor-exit(r12);
        return r4;
    L11:
        th = move-exception;
        throw th;
    }

    public final int e() {
        int r1 = f37001b;
        f37001b = 0;
        return r1;
    }
}

package com.obric.performance.power.monitor.cpu;

import android.os.PowerManager;
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

/* JADX INFO: compiled from: WakeLockMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f36970a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f36971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f36972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static List<m<Integer, Long>> f36973d;

    private c() {
    }

    static {
        f36970a = new c();
        f36973d = Collections.synchronizedList((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin"));
    }

    public static final void a(Object r5) {
        o.e(r5, "wakeLockObject");
        int r0 = r5.hashCode();
        if (ZeusTransformUtils.instanceOf(r5, PowerManager.WakeLock.class) == false) goto L14;
        List<m<Integer, Long>> r6 = f36973d;
        o.a(r6);
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L9;
        r1.add(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r8.next(), m.class, "com.obric.aiagent.plugin")).a(), Number.class, "com.obric.aiagent.plugin")).intValue()));
        goto L6
    L9:
        if (((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin")).contains(Integer.valueOf(r0)) == true) goto L15;
        f36973d.add(new m(Integer.valueOf(r0), Long.valueOf(SystemClock.uptimeMillis())));
        ILogDepend.Companion.d("PowerMonitor", "WakeLockMonitor onAcquire: " + r0);
        return;
    L15:
        return;
    }

    public static final void b(Object r11) {
        o.e(r11, "wakeLockObject");
        int r0 = r11.hashCode();
        if (ZeusTransformUtils.instanceOf(r11, PowerManager.WakeLock.class) == false) goto L35;
        List<m<Integer, Long>> r1 = f36973d;
        o.a(r1);
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L9;
        r3.add(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r4.next(), m.class, "com.obric.aiagent.plugin")).a(), Number.class, "com.obric.aiagent.plugin")).intValue()));
        goto L6
    L9:
        if (((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin")).contains(Integer.valueOf(r0)) == true) goto L12;
        return;
    L12:
        if (((PowerManager.WakeLock) ZeusTransformUtils.preCheckCast(r11, PowerManager.WakeLock.class, "com.obric.aiagent.plugin")).isHeld() == true) goto L44;
        List<m<Integer, Long>> r12 = f36973d;
        o.a(r12);
        monitor-enter(r12);
        List<m<Integer, Long>> r5 = f36973d;     // Catch: Throwable -> L32
        o.c(r5, "wakeLockList");     // Catch: Throwable -> L32
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L32
    L17:
        if (r6.hasNext() == false) goto L24;
        Object r7 = r6.next();     // Catch: Throwable -> L32
        if (((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.aiagent.plugin")).a(), Number.class, "com.obric.aiagent.plugin")).intValue() != r0) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L17;
    L25:
        m r9 = (m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (r9 != null) goto L29;
        monitor-exit(r12);
        return;
    L29:
        f36971b += SystemClock.uptimeMillis() - Math.max(f36972c, ((Number) ZeusTransformUtils.preCheckCast(r9.b(), Number.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Throwable -> L32
        f36973d.remove(r9);     // Catch: Throwable -> L32
        monitor-exit(r12);
        ILogDepend.Companion.d("PowerMonitor", "WakeLockMonitor onRelease: " + r0 + ", wakeLockTime: " + f36971b);
        return;
    L21:
        r8 = false;
        goto L22
    L24:
        r7 = null;
    L32:
        th = move-exception;
        throw th;
    L44:
        return;
    }

    public final int a() {
        return f36973d.size();
    }

    public final void b() {
        f36972c = SystemClock.uptimeMillis();
    }

    public final long c() {
        List<m<Integer, Long>> r12 = f36973d;
        o.c(r12, "wakeLockList");
        monitor-enter(r12);
        List<m<Integer, Long>> r0 = f36973d;     // Catch: Throwable -> L11
        o.c(r0, "wakeLockList");     // Catch: Throwable -> L11
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L11
        long r3 = 0;
    L6:
        if (r1.hasNext() == false) goto L8;
        r3 = r3 + (SystemClock.uptimeMillis() - Math.max(f36972c, ((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r1.next(), m.class, "com.obric.aiagent.plugin")).b(), Number.class, "com.obric.aiagent.plugin")).longValue()));     // Catch: Throwable -> L11
        goto L6
    L8:
        long r4 = r3 + f36971b;     // Catch: Throwable -> L11
        f36971b = 0;     // Catch: Throwable -> L11
        f36972c = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        monitor-exit(r12);
        return r4;
    L11:
        th = move-exception;
        throw th;
    }
}

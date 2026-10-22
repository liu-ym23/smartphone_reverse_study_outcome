package com.obric.performance.power.monitor.h;

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

/* JADX INFO: compiled from: SensorMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f37007a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f37008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f37009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static List<m<a, Long>> f37010d;

    private b() {
    }

    static {
        f37007a = new b();
        f37010d = Collections.synchronizedList((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin"));
    }

    public static final void a(a r6) {
        o.e(r6, "sensorInfo");
        List<m<a, Long>> r0 = f37010d;
        o.a(r0);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r2.add(Integer.valueOf(((a) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r3.next(), m.class, "com.obric.aiagent.plugin")).a(), a.class, "com.obric.aiagent.plugin")).a()));
        goto L4
    L7:
        if (((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin")).contains(Integer.valueOf(r6.a())) == false) goto L15;
        List<m<a, Long>> r4 = f37010d;
        o.a(r4);
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r5, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r5.iterator();
    L10:
        if (r8.hasNext() == false) goto L13;
        r7.add(((a) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r8.next(), m.class, "com.obric.aiagent.plugin")).a(), a.class, "com.obric.aiagent.plugin")).b());
        goto L10
    L13:
        if (((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin")).contains(r6.b()) == false) goto L15;
        return;
    L15:
        f37010d.add(new m(r6, Long.valueOf(SystemClock.uptimeMillis())));
        ILogDepend.Companion.d("PowerMonitor", "SensorMonitor onRegister: listenerHashCode=" + r6.a() + ", sensorHashCode=" + r6.b());
    }

    public static final void b(a r11) {
        o.e(r11, "sensorInfo");
        Object r3 = null;
        if (r11.b() != null) goto L25;
        List<m<a, Long>> r0 = f37010d;
        o.a(r0);
        monitor-enter(r0);
        List<m<a, Long>> r4 = f37010d;     // Catch: Throwable -> L22
        o.c(r4, "sensorListenerList");     // Catch: Throwable -> L22
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L22
    L8:
        if (r5.hasNext() == false) goto L15;
        Object r6 = r5.next();     // Catch: Throwable -> L22
        if (((a) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r6, m.class, "com.obric.aiagent.plugin")).a(), a.class, "com.obric.aiagent.plugin")).a() != r11.a()) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L8;
        r3 = r6;
        goto L15
    L12:
        r7 = false;
    L15:
        m r1 = (m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r1 != null) goto L19;
        monitor-exit(r0);
        return;
    L19:
        f37008b += SystemClock.uptimeMillis() - Math.max(f37009c, ((Number) ZeusTransformUtils.preCheckCast(r1.b(), Number.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Throwable -> L22
        f37010d.remove(r1);     // Catch: Throwable -> L22
        monitor-exit(r0);
        ILogDepend.Companion.d("PowerMonitor", "SensorMonitor onUnregister: listenerHashCode=" + r11.a() + ", sensorHashCode=null, sensorListenerTime=" + f37008b);
        return;
    L22:
        th = move-exception;
        throw th;
    L25:
        List<m<a, Long>> r2 = f37010d;
        o.a(r2);
        monitor-enter(r2);
        List<m<a, Long>> r8 = f37010d;     // Catch: Throwable -> L46
        o.c(r8, "sensorListenerList");     // Catch: Throwable -> L46
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L46
    L29:
        if (r9.hasNext() == false) goto L38;
        Object r10 = r9.next();     // Catch: Throwable -> L46
        m r12 = (m) ZeusTransformUtils.preCheckCast(r10, m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        if (((a) ZeusTransformUtils.preCheckCast(r12.a(), a.class, "com.obric.aiagent.plugin")).a() == r11.a()) goto L33;
    L35:
        boolean r13 = false;
    L36:
        if (r13 == false) goto L29;
        r3 = r10;
        goto L38
    L33:
        if (o.a(((a) ZeusTransformUtils.preCheckCast(r12.a(), a.class, "com.obric.aiagent.plugin")).b(), r11.b()) == false) goto L35;
        r13 = true;
    L38:
        m r14 = (m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        if (r14 != null) goto L42;
        monitor-exit(r2);
        return;
    L42:
        f37008b += SystemClock.uptimeMillis() - Math.max(f37009c, ((Number) ZeusTransformUtils.preCheckCast(r14.b(), Number.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Throwable -> L46
        f37010d.remove(r14);     // Catch: Throwable -> L46
        monitor-exit(r2);
        ILogDepend.Companion.d("PowerMonitor", "SensorMonitor onUnregister: listenerHashCode=" + r11.a() + ", sensorHashCode=" + r11.b() + ", sensorListenerTime=" + f37008b);
        return;
    L46:
        th = move-exception;
        throw th;
    }

    public final int a() {
        return f37010d.size();
    }

    public final void b() {
        f37009c = SystemClock.uptimeMillis();
    }

    public final long c() {
        List<m<a, Long>> r12 = f37010d;
        o.c(r12, "sensorListenerList");
        monitor-enter(r12);
        List<m<a, Long>> r0 = f37010d;     // Catch: Throwable -> L11
        o.c(r0, "sensorListenerList");     // Catch: Throwable -> L11
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L11
        long r3 = 0;
    L6:
        if (r1.hasNext() == false) goto L8;
        r3 = r3 + (SystemClock.uptimeMillis() - Math.max(f37009c, ((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r1.next(), m.class, "com.obric.aiagent.plugin")).b(), Number.class, "com.obric.aiagent.plugin")).longValue()));     // Catch: Throwable -> L11
        goto L6
    L8:
        long r4 = r3 + f37008b;     // Catch: Throwable -> L11
        f37008b = 0;     // Catch: Throwable -> L11
        f37009c = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        monitor-exit(r12);
        return r4;
    L11:
        th = move-exception;
        throw th;
    }
}

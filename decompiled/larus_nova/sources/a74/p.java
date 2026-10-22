package a74;

import android.content.Context;
import android.content.Intent;
import com.bytedance.badger.service.SensorDataService;
import com.bytedance.map.api.monitor.MonitorValueConst;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes47.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Context f2008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile SensorDataService f2009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f2010c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f2011d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ArrayDeque f2012e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f2013f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h f2014g = null;

    static {
        f2010c = new AtomicBoolean(false);
        f2011d = new AtomicBoolean(false);
        f2012e = new ArrayDeque();
        f2013f = new Object();
        f2014g = new h();
    }

    public static synchronized void a(final int r100, final int r101, final q r102) {
        monitor-enter(p.class);
        com.bytedance.badger.utils.m.a().b(new n(r100, r101, r102));     // Catch: Throwable -> L7
        monitor-exit(p.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void b(Context r100) {
        if (r100 != null) goto L8;
        String r101 = "init ignored: context null";
    L5:
        com.bytedance.badger.e.g("event_behavior# ", r101);
        return;
    L8:
        if (f2008a == null) goto L10;
        return;
    L10:
        f2008a = r100.getApplicationContext();
        r101 = "init done " + ThreadMethodProxy.currentThread().getName();
        goto L5
    }

    public static void c(String r100) {
    L2:
        Object r101 = f2013f;
        monitor-enter(r101);
        m r102 = (m) f2012e.pollFirst();     // Catch: Throwable -> L11
        if (r102 == null) goto L6;
        monitor-exit(r101);     // Catch: Throwable -> L11
        r102.f2004c.a(r100);     // Catch: Throwable -> L14
        goto L2
    L6:
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void e() {
        AtomicBoolean r100 = f2011d;
        if (r100.get() == false) goto L5;
        StringBuilder r101 = new StringBuilder("processNext# isCollecting return... ");
    L11:
        r101.append(ThreadMethodProxy.currentThread().getName());
        com.bytedance.badger.e.g("event_behavior# ", r101.toString());
        return;
    L5:
        Object r102 = f2013f;
        monitor-enter(r102);
        ArrayDeque r103 = f2012e;     // Catch: Throwable -> L39
        m r104 = (m) r103.pollFirst();     // Catch: Throwable -> L39
        monitor-exit(r102);     // Catch: Throwable -> L39
        if (r104 != null) goto L13;
        r101 = new StringBuilder("queue empty return... ");
        goto L11
    L13:
        SensorDataService r105 = f2009b;
        if (r105 != null) goto L24;
        monitor-enter(r102);
        r103.addFirst(r104);     // Catch: Throwable -> L20
        monitor-exit(r102);     // Catch: Throwable -> L20
        d();
        return;
    L20:
        th = move-exception;
        throw th;
    L24:
        if (r100.compareAndSet(false, true) == true) goto L32;
        monitor-enter(r102);
        r103.addFirst(r104);     // Catch: Throwable -> L29
        monitor-exit(r102);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    L32:
        com.bytedance.badger.e.f("event_behavior# ", "start collect... " + ThreadMethodProxy.currentThread().getName());
        r105.e(r104.f2002a, r104.f2003b, new l(r104));     // Catch: Throwable -> L35
        return;
    L35:
        f2011d.set(false);
        r104.f2004c.a("collect_failed");     // Catch: Throwable -> L42
    L37:
        e();
        return;
    L39:
        th = move-exception;
        throw th;
    }

    public static void d() {
        if (f2009b == null) goto L6;
        com.bytedance.badger.e.f("event_behavior# ", "ensureBoundAndProcess# service is ok... " + ThreadMethodProxy.currentThread().getName());
        e();
        return;
    L6:
        Context r100 = f2008a;
        if (r100 != null) goto L10;
        c(MonitorValueConst.TYPE_CONTEXT_NULL);
        return;
    L10:
        boolean r101 = false;
        if (f2010c.compareAndSet(false, true) == true) goto L20;
        return;
    L20:
        r101 = r100.bindService(new Intent(r100, SensorDataService.class), f2014g, 1);     // Catch: Throwable -> L16
    L17:
        if (r101 == true) goto L22;
        com.bytedance.badger.utils.m.a().b(new o());
        return;
    }
}

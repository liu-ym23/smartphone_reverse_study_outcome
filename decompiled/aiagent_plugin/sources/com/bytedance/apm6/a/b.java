package com.bytedance.apm6.a;

import android.app.Activity;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: MemoryCollector.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f5019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile com.bytedance.apm.g.d f5020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.apm6.a.b.a f5021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.apm6.util.e.a f5022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f5023e;
    private long f;
    private C0123b g;
    private Map<Object, Object> h;
    private volatile boolean i;
    private List<com.bytedance.apm6.a.c.a> j;

    /* JADX INFO: compiled from: MemoryCollector.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f5025a = null;

        static /* synthetic */ b a() {
            return f5025a;
        }

        static {
            f5025a = new b(null);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm6.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MemoryCollector.java */
    private class C0123b extends com.bytedance.apm6.service.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f5026a;

        private C0123b(b r1) {
            this.f5026a = r1;
        }

        /* synthetic */ C0123b(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.bytedance.apm6.service.d.b, com.bytedance.apm6.service.d.c
        public final void a(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            if (com.bytedance.apm6.foundation.context.a.u() == false) goto L6;
            com.bytedance.apm6.util.c.b.a("APM-Memory", "isStopWhenBackground:" + b.c(this.f5026a));
        L6:
            if (b.c(this.f5026a) == false) goto L9;
            b.d(this.f5026a);
            return;
        }

        @Override // com.bytedance.apm6.service.d.b, com.bytedance.apm6.service.d.c
        public final void b(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            if (com.bytedance.apm6.foundation.context.a.u() == false) goto L6;
            com.bytedance.apm6.util.c.b.a("APM-Memory", "isStopWhenBackground:" + b.c(this.f5026a));
        L6:
            if (b.c(this.f5026a) == false) goto L9;
            b.e(this.f5026a);
            return;
        }
    }

    static {
    }

    /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean a(b r0) {
        return r0.i;
    }

    static /* synthetic */ void b(b r0) {
        r0.f();
    }

    static /* synthetic */ boolean c(b r0) {
        return r0.i();
    }

    static /* synthetic */ void d(b r0) {
        r0.d();
    }

    static /* synthetic */ void e(b r0) {
        r0.e();
    }

    private b() {
        this.f = 0;
        this.g = new C0123b(this, null);
        this.j = new CopyOnWriteArrayList();
    }

    public static b a() {
        return a.a();
    }

    public final synchronized void b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f5019a == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f5019a = true;     // Catch: Throwable -> L11
        a(((com.bytedance.apm6.a.b.b) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.a.b.b.class), com.bytedance.apm6.a.b.b.class, "com.obric.aiagent.plugin")).a());     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void c() {
        c.a().b();
    }

    public synchronized void a(com.bytedance.apm6.a.b.a r7) {
        monitor-enter(this);
        if (r7 != null) goto L47;
        monitor-exit(this);
        return;
    L47:
        this.f5021c = r7;     // Catch: Throwable -> L44
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L10;
        com.bytedance.apm6.util.c.b.a("APM-Memory", "updateConfig: " + r7);     // Catch: Throwable -> L44
    L10:
        if (r7.a() == true) goto L19;
        e();     // Catch: Throwable -> L44
        com.bytedance.apm6.service.d.a r0 = (com.bytedance.apm6.service.d.a) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.d.a.class), com.bytedance.apm6.service.d.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        if (r0 == null) goto L15;
        r0.unregister(this.g);     // Catch: Throwable -> L44
    L15:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L17;
        com.bytedance.apm6.util.c.b.a("APM-Memory", "isApm6SampleEnable: " + r7.a());     // Catch: Throwable -> L44
    L17:
        monitor-exit(this);
        return;
    L19:
        com.bytedance.apm6.service.d.a r1 = (com.bytedance.apm6.service.d.a) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.d.a.class), com.bytedance.apm6.service.d.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        if (r1 != null) goto L22;
    L25:
        long r2 = r7.c() * 1000;     // Catch: Throwable -> L44
        this.f = r2;     // Catch: Throwable -> L44
        if (r2 >= OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS) goto L32;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L30;
        com.bytedance.apm6.util.c.b.a("APM-Memory", "pollingIntervalMillis: " + this.f);     // Catch: Throwable -> L44
    L30:
        this.f = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;     // Catch: Throwable -> L44
    L32:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L34;
        com.bytedance.apm6.util.c.b.a("APM-Memory", "result pollingIntervalMillis: " + this.f);     // Catch: Throwable -> L44
    L34:
        com.bytedance.apm6.util.e.a r8 = this.f5022d;     // Catch: Throwable -> L44
        if (r8 != null) goto L37;
    L39:
        d();     // Catch: Throwable -> L44
        com.bytedance.apm6.a.a r9 = (com.bytedance.apm6.a.a) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.a.a.class), com.bytedance.apm6.a.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        if (r9 == null) goto L42;
        r9.a();     // Catch: Throwable -> L44
    L42:
        monitor-exit(this);
        return;
    L37:
        if (r8.c() == this.f) goto L39;
        e();     // Catch: Throwable -> L44
        goto L39
    L22:
        if (r7.d() == false) goto L24;
        r1.unregister(this.g);     // Catch: Throwable -> L44
        r1.register(this.g);     // Catch: Throwable -> L44
        goto L25
    L24:
        r1.unregister(this.g);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }

    public void a(com.bytedance.apm.g.d r3) {
        this.f5020b = (com.bytedance.apm.g.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.g.d.class, "com.obric.aiagent.plugin");
    }

    private synchronized void d() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f5023e == true) goto L9;
        this.f5023e = true;     // Catch: Throwable -> L11
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L8;
        com.bytedance.apm6.util.c.b.a("APM-Memory", "start");     // Catch: Throwable -> L11
    L8:
        g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
    }

    private synchronized void e() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f5023e == false) goto L6;
        this.f5023e = false;     // Catch: Throwable -> L8
        h();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    private void f() {
        long r0 = System.currentTimeMillis();
        com.bytedance.apm6.a.d.a r2 = c.a().a(this.f5021c);
        if (r2 == null) goto L5;
        r2.a(this.h);
        this.h = null;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L12;
        com.bytedance.apm6.util.c.b.a("APM-Memory", String.format("collect[isUploadEnable=%s cost=%s]: %s", new Object[]{Boolean.valueOf(this.f5021c.f()), Long.valueOf(System.currentTimeMillis() - r0), r2.i().toString()}));
    L12:
        if (this.f5021c.f() == false) goto L15;
        a(r2);
    L18:
        if (r2.f() > this.f5021c.b()) goto L20;
    L22:
        List<com.bytedance.apm6.a.c.a> r1 = this.j;
        if (r1 != null) goto L25;
        return;
    L25:
        if (r1.size() <= 0) goto L38;
        com.bytedance.apm6.a.a.a r3 = r2.j();     // Catch: Exception -> L32
        Iterator<com.bytedance.apm6.a.c.a> r8 = this.j.iterator();     // Catch: Exception -> L32
    L28:
        if (r8.hasNext() == false) goto L40;
        ((com.bytedance.apm6.a.c.a) ZeusTransformUtils.preCheckCast(r8.next(), com.bytedance.apm6.a.c.a.class, "com.obric.aiagent.plugin")).a(r3);     // Catch: Exception -> L32
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L20:
        if (this.f5020b == null) goto L22;
        this.f5020b.a("reach_top_java");
        goto L22
    L15:
        if (com.bytedance.apm.h.a.a() == false) goto L18;
        com.bytedance.apm.h.a.c(TAG, r2.i().toString());
        goto L18
    L5:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L37;
        com.bytedance.apm6.util.c.b.a("APM-Memory", "collectWithConfig return is null");
        return;
    }

    private void g() {
        if (this.f5022d == null) goto L5;
        return;
    L5:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L7;
        com.bytedance.apm6.util.c.b.a("APM-Memory", "scheduleCollectMemory");
    L7:
        final long r4 = 0;
        final long r6 = this.f;
        this.f5022d = new AnonymousClass1(this, r4, r6);
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5474b).a(this.f5022d);
    }

    private void h() {
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L6;
        com.bytedance.apm6.util.c.b.a("APM-Memory", "cancelCollectMemory");
    L6:
        if (this.f5022d == null) goto L9;
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5474b).b(this.f5022d);
        this.f5022d = null;
        return;
    }

    private void a(com.bytedance.apm6.monitor.b r2) {
        com.bytedance.apm6.monitor.b r1 = (com.bytedance.apm6.monitor.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.apm6.monitor.b.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return;
    L5:
        com.bytedance.apm6.monitor.a.a(r1);
    }

    private boolean i() {
        com.bytedance.apm6.a.b.a r0 = this.f5021c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.d() == false) goto L7;
        return true;
    }
}

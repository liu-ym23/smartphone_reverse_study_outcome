package com.bytedance.apm6.cpu.a;

import android.content.Context;
import android.os.Process;
import com.bytedance.apm.util.o;
import com.bytedance.apm6.cpu.c.i;
import com.bytedance.apm6.cpu.c.j;
import com.bytedance.monitor.collector.k;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: CpuDataCollector.java */
/* JADX INFO: loaded from: classes.dex */
class d extends com.bytedance.apm6.service.d.b {
    private static final String TAG = "MonitorCpu";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f5206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f5207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.apm6.util.e.a f5208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f5209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f5210e;
    private long f;
    private long g;
    private com.bytedance.apm6.cpu.b.a h;
    private com.bytedance.watson.assist.a.c i;
    private boolean j;

    static /* synthetic */ long a(d r2) {
        return r2.f5209d;
    }

    static /* synthetic */ void a(d r0, boolean r1) {
        r0.a(r1);
    }

    static /* synthetic */ boolean b(d r0) {
        return r0.j;
    }

    static /* synthetic */ boolean b(d r0, boolean r1) {
        r0.j = r1;
        return r1;
    }

    static /* synthetic */ void c(d r0) {
        r0.c();
    }

    static /* synthetic */ void d(d r0) {
        r0.b();
    }

    d(c r3, com.bytedance.watson.assist.a.c r4) {
        com.bytedance.watson.assist.a.c r5 = (com.bytedance.watson.assist.a.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.watson.assist.a.c.class, "com.obric.aiagent.plugin");
        this.j = true;
        this.f5207b = new AtomicBoolean(false);
        this.f5206a = r3;
        this.i = r5;
    }

    void a(com.bytedance.apm6.cpu.b.a r4) {
        if (this.f5207b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.h = r4;
        a();
        if (this.f5208c == null) goto L11;
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5476d).a(this.f5208c);
    L11:
        this.i.b();     // Catch: Throwable -> L10
        return;
    }

    private void a(boolean r3) {
        com.bytedance.apm6.cpu.b.a r0 = this.h;
        if (r3 == false) goto L5;
        long r1 = r0.a();
    L6:
        this.f5209d = r1;
        if (r3 == false) goto L9;
        long r2 = this.h.f();
    L10:
        this.f5210e = r2;
        return;
    L9:
        r2 = this.h.e();
        goto L10
    L5:
        r1 = r0.b();
        goto L6
    }

    private void a() {
        if (this.f5208c != null) goto L6;
        final long r3 = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
        final long r5 = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
        this.f5208c = new AnonymousClass1(this, r3, r5);
        return;
    }

    private void b() {
        long r0 = System.currentTimeMillis();
        if ((r0 - this.g) >= this.f5210e) goto L5;
        return;
    L5:
        this.g = r0;
        HashMap r6 = new HashMap();
        HashMap r7 = new HashMap();
        boolean r1 = false;
        i.a(Process.myPid(), r6);
        Thread.sleep(100);     // Catch: InterruptedException -> L8
    L10:
        if (r1 == false) goto L12;
        return;
    L12:
        i.a(Process.myPid(), r7);
        com.bytedance.watson.assist.a.c.a r2 = null;
        r2 = this.i.i();     // Catch: Exception -> L16
    L14:
        a(0, r6, r7, r2);
        return;
    L8:
        e = move-exception;
        com.bytedance.apm6.util.c.b.b("APM-CPU", "InterruptedException", e);
        r1 = true;
        goto L10
    }

    private void c() {
        long r1 = System.currentTimeMillis();
        if ((r1 - this.f) >= this.f5209d) goto L5;
        return;
    L5:
        this.f = r1;
        int r3 = com.bytedance.apm.util.b.b();
        if (r3 > 0) goto L8;
        return;
    L8:
        long r4 = k.a().m();
        long r6 = k.a().b(r3);
        boolean r8 = false;
        Thread.sleep(360);     // Catch: InterruptedException -> L11
    L12:
        if (r8 == false) goto L14;
        return;
    L14:
        long r9 = k.a().m();
        double r12 = -1.0d;
        long r10 = k.a().b(r3) - r6;
        if (r10 <= 0) goto L17;
        r12 = (r9 - r4) / r10;
        com.bytedance.apm.h.a.c(TAG, "appCpuRate -> " + r12);
    L17:
        double r7 = (r9 - r4) * 1000.0d;
        double r5 = (r7 / (System.currentTimeMillis() - r1)) / com.bytedance.apm.util.b.a(100);
        if (com.bytedance.apm.c.i() == false) goto L21;
        com.bytedance.apm6.util.c.b.a("APM-CPU", String.valueOf(r7) + " " + (System.currentTimeMillis() - r1) + " " + com.bytedance.apm.util.b.a(100));
    L21:
        if (com.bytedance.apm.c.i() == false) goto L23;
        com.bytedance.apm.h.a.c(TAG, "appCpuSpeed -> " + r5);
        com.bytedance.apm6.util.c.b.a("APM-CPU", "collect cpu data, rate: " + r12 + " speed: " + r5);
    L23:
        com.bytedance.watson.assist.a.c.a r2 = null;
        this.i.f();     // Catch: Throwable -> L32
        r2 = this.i.i();     // Catch: Throwable -> L32
    L26:
        if (this.f5206a.a() == false) goto L28;
        this.f5206a.a(r12, r5);
        this.f5206a.a(r2);
    L28:
        com.bytedance.apm6.cpu.d.a.a().a(r12, r5);
        com.bytedance.apm6.cpu.a.InterfaceC0127a r14 = b.a().d();
        if (r14 == null) goto L37;
        r14.a(r5, r12, com.bytedance.apm6.perf.base.c.a().b(), r2, com.bytedance.common.utility.i.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
        return;
    L37:
        return;
    L11:
        r8 = true;
        goto L12
    }

    private void a(long r18, Map<Integer, j> r20, Map<Integer, j> r21, com.bytedance.watson.assist.a.c.a r22) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        if (r3.isEmpty() == false) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L62;
        LinkedList r6 = new LinkedList();
        LinkedList<com.bytedance.apm6.service.e.a.C0132a> r7 = new LinkedList();
        Iterator r4 = r3.entrySet().iterator();
    L9:
        if (r4.hasNext() == false) goto L29;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        j r9 = (j) ZeusTransformUtils.preCheckCast(r8.getValue(), j.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L9;
        j r10 = (j) ZeusTransformUtils.preCheckCast(r5.get(r8.getKey()), j.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L9;
        if (r10.g().equals(r9.g()) == false) goto L9;
        long r11 = r10.h() - r9.h();
        if (r11 == 0) goto L9;
        com.bytedance.apm6.util.c.b.a("APM-CPU", "cpu_thread=" + r10.g() + " thread_time=" + r11 + " app_time=" + r18);
        if (r18 == 0) goto L24;
        double r12 = r11 / r18;
        if (r12 <= 9.0E-4d) goto L9;
        r6.add(new o(r10.g(), Double.valueOf(String.format("%.3f", new Object[]{Double.valueOf(r12)}))));
        r7.add(new com.bytedance.apm6.service.e.a.C0132a(r10.g(), Double.valueOf(String.format("%.3f", new Object[]{Double.valueOf(r12)})).doubleValue(), r10.f()));
        goto L9
    L24:
        double r13 = r11;
        r6.add(new o(r10.g(), Double.valueOf(r13)));
        r7.add(new com.bytedance.apm6.service.e.a.C0132a(r10.g(), r13, r10.f()));
        goto L9
    L29:
        if (r6.isEmpty() == false) goto L31;
        return;
    L31:
        Collections.sort(r7, new AnonymousClass2(this));
        com.bytedance.apm6.cpu.d.a.a().a(r7);
        if (this.h.d() == true) goto L34;
        return;
    L34:
        if (b.a().c() == false) goto L36;
        a.EnumC0128a r1 = a.EnumC0128a.f5189b;
    L37:
        e r2 = new e(r1, com.bytedance.apm6.perf.base.c.a().b(), r6, r22);
        r2.a(com.ss.thor.b.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
        r2.a(this.i.h());     // Catch: Throwable -> L41
    L39:
        com.bytedance.apm6.monitor.a.a(r2);
        return;
    L36:
        r1 = a.EnumC0128a.f5190c;
        goto L37
    }
}

package com.bytedance.apm6.cpu.a;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: CpuDataAssembler.java */
/* JADX INFO: loaded from: classes.dex */
class c extends com.bytedance.apm6.service.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f5200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.apm6.cpu.b.a f5201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.watson.assist.a.c f5202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashMap<String, a> f5203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<String, a> f5204e;
    private HashMap<String, a> f;

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.a.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: CpuDataAssembler.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5205a = null;

        static {
            int[] r0 = new int[a.EnumC0128a.values().length];
            f5205a = r0;
            r0[a.EnumC0128a.f5188a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f5205a[a.EnumC0128a.f5190c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f5205a[a.EnumC0128a.f5189b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    c(com.bytedance.watson.assist.a.c r3) {
        com.bytedance.watson.assist.a.c r4 = (com.bytedance.watson.assist.a.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.watson.assist.a.c.class, "com.obric.aiagent.plugin");
        this.f5200a = new AtomicBoolean(false);
        this.f5202c = r4;
    }

    void a(com.bytedance.apm6.cpu.b.a r4) {
        if (this.f5200a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.f5203d = new HashMap();
        this.f5204e = new HashMap();
        this.f = new HashMap();
        this.f5201b = r4;
    }

    boolean a() {
        return this.f5200a.get();
    }

    void a(double r10, double r12) {
        if (this.f5200a.get() == true) goto L5;
        return;
    L5:
        String r0 = com.bytedance.apm6.perf.base.c.a().b();
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L9;
        com.bytedance.apm6.util.c.b.a("APM-CPU", r0);
    L9:
        monitor-enter(c.class);
    L20:
        th = move-exception;
        throw th;
    L11:
        if (b.a().c() == false) goto L13;
        a.EnumC0128a r2 = a.EnumC0128a.f5189b;     // Catch: Throwable -> L20
    L14:
        a r3 = a(r2, a(r2, r0), r10, r12);     // Catch: Throwable -> L20
        a(r2, r0, r3);     // Catch: Throwable -> L20
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L17;
        com.bytedance.apm6.util.c.b.a("APM-CPU", "after add cache data: " + r3);     // Catch: Throwable -> L20
    L17:
        a(a.EnumC0128a.f5188a, r0, a(a.EnumC0128a.f5188a, a(a.EnumC0128a.f5188a, r0), r10, r12));     // Catch: Throwable -> L20
        monitor-exit(c.class);     // Catch: Throwable -> L20
        return;
    L13:
        r2 = a.EnumC0128a.f5190c;     // Catch: Throwable -> L20
        goto L14
    }

    private static a a(a.EnumC0128a r2, a r3, double r4, double r6) {
        if (r3 != null) goto L5;
        r3 = new a(r2, System.currentTimeMillis());
        r3.a(com.bytedance.apm6.perf.base.c.a().b());
    L5:
        if (r4 < 0.0d) goto L7;
    L8:
        r3.h();
    L9:
        r3.c(r6);
        r3.a(r4);
        r3.b(r4);
        r3.d(r6);
        return r3;
    L7:
        if (r6 < 0.0d) goto L9;
        goto L8
    }

    private void a(a.EnumC0128a r2, String r3, a r4) {
        int r5 = AnonymousClass1.f5205a[r2.ordinal()];
        if (r5 != 1) goto L5;
        this.f5203d.put(r3, r4);
        return;
    L5:
        if (r5 != 2) goto L7;
        this.f.put(r3, r4);
        return;
    L7:
        if (r5 != 3) goto L15;
        this.f5204e.put(r3, r4);
        return;
    }

    private a a(a.EnumC0128a r3, String r4) {
        int r5 = AnonymousClass1.f5205a[r3.ordinal()];
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L13;
        if (r5 == 3) goto L11;
        return null;
    L11:
        return (a) ZeusTransformUtils.preCheckCast(this.f5204e.get(r4), a.class, "com.obric.aiagent.plugin");
    L13:
        return (a) ZeusTransformUtils.preCheckCast(this.f.get(r4), a.class, "com.obric.aiagent.plugin");
    L15:
        return (a) ZeusTransformUtils.preCheckCast(this.f5203d.get(r4), a.class, "com.obric.aiagent.plugin");
    }

    public void a(com.bytedance.watson.assist.a.c.a r3) {
        if (this.f5200a.get() == true) goto L6;
        return;
    L6:
        monitor-enter(c.class);
        a(a.EnumC0128a.f5189b, r3);     // Catch: Throwable -> L10
        a(a.EnumC0128a.f5190c, r3);     // Catch: Throwable -> L10
        a(a.EnumC0128a.f5188a, r3);     // Catch: Throwable -> L10
        monitor-exit(c.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void a(a.EnumC0128a r17, com.bytedance.watson.assist.a.c.a r18) {
        long r13 = System.currentTimeMillis();
        int r0 = AnonymousClass1.f5205a[r17.ordinal()];
        if (r0 != 1) goto L5;
        Iterator<Map.Entry<String, a>> r1 = this.f5203d.entrySet().iterator();
    L9:
        Iterator<Map.Entry<String, a>> r15 = r1;
        if (r15 != null) goto L16;
        return;
    L16:
        if (r15.hasNext() == false) goto L24;
        a r2 = (a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), a.class, "com.obric.aiagent.plugin");
        if ((r13 - r2.f()) <= this.f5201b.c()) goto L16;
        r15.remove();
        double r3 = r2.a() / ((double) r2.g());
        double r5 = r2.b();
        double r7 = r2.c() / ((double) r2.g());
        double r9 = r2.d();
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L23;
        com.bytedance.apm6.util.c.b.a("APM-CPU", "cpu cache item: " + r2);
        com.bytedance.apm6.util.c.b.a("APM-CPU", "assemble cpu data, type: " + r17 + " rate: " + r3 + " maxRate: " + r5 + " speed: " + r7 + " maxSpeed: " + r9);
    L23:
        a(r17, r2.e(), r3, r5, r7, r9, r18);
        goto L16
    L24:
        return;
    L5:
        if (r0 != 2) goto L7;
        r1 = this.f.entrySet().iterator();
        goto L9
    L7:
        if (r0 == 3) goto L10;
        r1 = null;
        goto L9
    L10:
        r1 = this.f5204e.entrySet().iterator();
        goto L9
    }

    private void a(a.EnumC0128a r14, String r15, double r16, double r18, double r20, double r22, com.bytedance.watson.assist.a.c.a r24) {
        e r12 = new e(r14, r15, r16, r18, r20, r22, r24);
        r12.a(com.ss.thor.b.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")));
        r12.a(this.f5202c.h());     // Catch: Throwable -> L6
    L4:
        com.bytedance.apm6.monitor.a.a(r12);
    }
}

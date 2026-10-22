package com.bytedance.apm6.hub;

import com.bytedance.apm.config.f;
import com.bytedance.apm6.consumer.slardar.g;
import com.bytedance.apm6.foundation.ActivityLifeManager;
import com.bytedance.apm6.foundation.a.c;
import com.bytedance.apm6.frequency.d;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMonitorLogManager;
import com.bytedance.services.apm.api.e;
import com.bytedance.services.apm.api.k;
import com.bytedance.services.apm.api.l;

/* JADX INFO: compiled from: Apm.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f5371a = false;

    static {
    }

    static /* synthetic */ void b(b r0) {
        d(r0);
    }

    public static synchronized Runnable a(final b r2) {
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f5371a == false) goto L10;
        monitor-exit(a.class);
        return null;
    L10:
        f5371a = true;     // Catch: Throwable -> L13
        c(r2);     // Catch: Throwable -> L13
        Runnable r1 = new AnonymousClass1(r2);     // Catch: Throwable -> L13
        monitor-exit(a.class);
        return r1;
    }

    private static void c(b r2) {
        com.bytedance.apm6.foundation.context.a.a(r2);
        com.bytedance.apm6.foundation.context.a.b(System.currentTimeMillis());
        com.bytedance.apm6.foundation.context.a.a(System.currentTimeMillis());
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L5;
        com.bytedance.apm6.util.c.b.a("APM-Hub", "APM init start in process " + r2.f());
    L5:
        com.bytedance.apm6.util.c.b.a(new c());
        com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.d.a.class, new ActivityLifeManager());
    }

    private static void d(final b r4) {
        com.bytedance.apm6.service.c.a(IHttpService.class, new AnonymousClass12(r4));
        com.bytedance.apm6.service.c.a(com.bytedance.apm6.consumer.slardar.a.b.class, new AnonymousClass19(r4));
        com.bytedance.apm6.service.c.a(com.bytedance.apm6.commonevent.a.b.class, new AnonymousClass20(r4));
        com.bytedance.apm6.service.c.a(com.bytedance.apm6.cpu.b.b.class, new AnonymousClass21(r4));
        com.bytedance.apm6.service.c.a(f.class, new AnonymousClass22(r4));
        com.bytedance.apm6.service.c.a(d.class, new AnonymousClass23(r4));
        com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.d.a.class, new AnonymousClass24());
        com.bytedance.apm6.service.c.a(e.class, new AnonymousClass25(r4));
        com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.b.a.class, new AnonymousClass2(r4));
        com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.e.b.class, new AnonymousClass3());
        com.bytedance.apm6.service.c.a(k.class, new AnonymousClass4());
        com.bytedance.apm6.service.c.a(l.class, new AnonymousClass5());
        new ActivityLifeManager();
        com.bytedance.apm6.service.c.a(com.bytedance.apm6.a.b.b.class, new AnonymousClass6(r4));
        com.bytedance.apm6.service.c.a(com.bytedance.apm6.java_alloc.c.class, new AnonymousClass7(r4));
        com.bytedance.apm6.service.c.a(com.bytedance.apm6.a.a.class, new AnonymousClass8(r4));
        com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.a.a.class, new AnonymousClass9(r4));
        com.bytedance.apm6.service.c.a(com.bytedance.apm6.disk.a.b.class, new AnonymousClass10());
        com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.e.a.class, new AnonymousClass11());
        com.bytedance.apm6.service.c.a(g.class, new AnonymousClass13(r4));
        com.bytedance.apm6.service.c.a(com.bytedance.apm6.fd.a.b.class, new AnonymousClass14());
        com.bytedance.news.common.service.manager.d.a(IActivityLifeManager.class, new AnonymousClass15());
        com.bytedance.news.common.service.manager.d.a(IMonitorLogManager.class, new AnonymousClass16());
        com.bytedance.apm6.hub.a.a.a.a().b();
        com.bytedance.apm6.util.e.b r0 = com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5474b);
        final long r2 = r4.x();
        r0.a(new AnonymousClass17(r2));
        a();
    }

    private static void a() {
        com.bytedance.apm6.consumer.slardar.e.c.a().a(new AnonymousClass18());
    }
}

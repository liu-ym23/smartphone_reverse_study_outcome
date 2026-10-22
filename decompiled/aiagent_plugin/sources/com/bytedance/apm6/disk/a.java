package com.bytedance.apm6.disk;

import com.bytedance.apm.g.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DiskCollector.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f5286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.apm6.disk.a.a f5287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f5288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f5289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.apm6.util.e.a f5290e;

    public a() {
    }

    static /* synthetic */ com.bytedance.apm6.disk.a.a a(a r0) {
        return r0.f5287b;
    }

    static /* synthetic */ com.bytedance.apm6.util.e.a b(a r0) {
        return r0.f5290e;
    }

    static {
        f5286a = new a();
    }

    public static a a() {
        return f5286a;
    }

    public void b() {
        if (this.f5288c == false) goto L5;
        return;
    L5:
        this.f5288c = true;
        com.bytedance.apm6.disk.a.b r0 = (com.bytedance.apm6.disk.a.b) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.disk.a.b.class), com.bytedance.apm6.disk.a.b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        a(r0.a());
        return;
    }

    public synchronized void a(com.bytedance.apm6.disk.a.a r4) {
        monitor-enter(this);
        if (r4 != null) goto L26;
        monitor-exit(this);
        return;
    L26:
        this.f5287b = r4;     // Catch: Throwable -> L23
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L10;
        com.bytedance.apm6.util.c.b.a("APM-Disk", "updateConfig:" + r4);     // Catch: Throwable -> L23
    L10:
        if (this.f5288c == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        com.bytedance.apm6.service.d.a r5 = (com.bytedance.apm6.service.d.a) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.d.a.class), com.bytedance.apm6.service.d.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r5 != null) goto L16;
    L21:
        monitor-exit(this);
        return;
    L16:
        if (r5.isForeground() == true) goto L21;
        c();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public void a(f r2) {
        f r1 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.aiagent.plugin");
        c.a().a(r1);
    }

    private synchronized void c() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.f5289d == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        com.bytedance.apm6.disk.a.a r0 = this.f5287b;     // Catch: Throwable -> L22
        if (r0 != null) goto L10;
    L20:
        monitor-exit(this);
        return;
    L10:
        if (r0.a() == false) goto L20;
        if (com.bytedance.apm6.foundation.context.a.e() == true) goto L17;
        monitor-exit(this);
        return;
    L17:
        this.f5289d = true;     // Catch: Throwable -> L22
        this.f5290e = new AnonymousClass1(this);     // Catch: Throwable -> L22
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5474b).a(this.f5290e);     // Catch: Throwable -> L22
        monitor-exit(this);
    }
}

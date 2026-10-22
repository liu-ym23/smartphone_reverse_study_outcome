package com.bytedance.apm6.fd;

import android.os.Process;
import com.bytedance.apm6.service.c;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.apm.api.IFdCheck;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: FdCollector.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f5319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.apm6.fd.a.a f5320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f5321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f5322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f5323e;
    private com.bytedance.apm6.util.e.a f;
    private IFdCheck g;

    public a() {
        this.f5323e = false;
    }

    static /* synthetic */ com.bytedance.apm6.util.e.a a(a r0) {
        return r0.f;
    }

    static /* synthetic */ com.bytedance.apm6.util.e.a a(a r0, com.bytedance.apm6.util.e.a r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ boolean a(a r0, boolean r1) {
        r0.f5323e = r1;
        return r1;
    }

    static /* synthetic */ void b(a r0) {
        r0.c();
    }

    static /* synthetic */ void c(a r0) {
        r0.d();
    }

    static {
        f5319a = new a();
    }

    public static a a() {
        return f5319a;
    }

    public void b() {
        if (this.f5321c == false) goto L5;
        return;
    L5:
        this.f5321c = true;
        com.bytedance.apm6.fd.a.b r0 = (com.bytedance.apm6.fd.a.b) ZeusTransformUtils.preCheckCast(c.a(com.bytedance.apm6.fd.a.b.class), com.bytedance.apm6.fd.a.b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L8;
        a(r0.a());
    L8:
        final long r1 = 1200000;
        this.f = new AnonymousClass1(this, r1);
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5474b).a(this.f);
    }

    public synchronized void a(com.bytedance.apm6.fd.a.a r4) {
        monitor-enter(this);
        if (r4 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        this.f5320b = r4;     // Catch: Throwable -> L12
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L9;
        com.bytedance.apm6.util.c.b.a("APM-FD", "updateConfig:" + r4);     // Catch: Throwable -> L12
    L9:
        c();     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private synchronized void c() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f5323e == false) goto L15;
        com.bytedance.apm6.fd.a.a r0 = this.f5320b;     // Catch: Throwable -> L17
        if (r0 == null) goto L15;
        if (r0.c() == false) goto L15;
        if (this.f5322d == true) goto L15;
        this.f5322d = true;     // Catch: Throwable -> L17
        com.bytedance.apm6.util.e.b r1 = com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5474b);     // Catch: Throwable -> L17
        final long r3 = 0;
        final long r5 = this.f5320b.b();     // Catch: Throwable -> L17
        r1.a(new AnonymousClass2(this, r3, r5));     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L15:
        monitor-exit(this);
    }

    private void d() {
        if (this.f5320b != null) goto L5;
        return;
    L5:
        com.bytedance.apm6.service.d.a r0 = (com.bytedance.apm6.service.d.a) ZeusTransformUtils.preCheckCast(c.a(com.bytedance.apm6.service.d.a.class), com.bytedance.apm6.service.d.a.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r0 == null) goto L8;
        r1 = r0.isForeground();
    L8:
        int r2 = e();
        if (r2 > 0) goto L11;
    L14:
        IFdCheck r6 = f();
        if (r6 != null) goto L17;
        return;
    L17:
        com.bytedance.apm6.monitor.a.a(new b(r2, r6.getFdList(), r1));
        return;
    L11:
        if (r2 >= this.f5320b.a()) goto L14;
        com.bytedance.apm6.monitor.a.a(new b(r2, null, r1));
    }

    private int e() {
        return new File("/proc/" + Process.myPid() + "/fd").listFiles().length;
    L5:
        return 0;
    }

    private IFdCheck f() {
        if (this.g != null) goto L6;
        this.g = (IFdCheck) ZeusTransformUtils.preCheckCast(d.a(IFdCheck.class), IFdCheck.class, "com.obric.aiagent.plugin");
    L6:
        return this.g;
    }
}

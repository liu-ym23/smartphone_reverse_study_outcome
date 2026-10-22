package com.bytedance.framwork.core.sdklib.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: LogReporter.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.framwork.core.sdklib.thread.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f8611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long f8612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.apm6.util.a.a<b> f8613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile j f8614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8615e;
    private long f;

    /* JADX INFO: compiled from: LogReporter.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final e f8616a = null;

        static /* synthetic */ e a() {
            return f8616a;
        }

        static {
            f8616a = new e();
        }
    }

    public e() {
        this.f8611a = 60000;
        this.f8612b = 1048576;
        this.f8613c = new com.bytedance.apm6.util.a.a(10);
    }

    public static e a() {
        return a.a();
    }

    public synchronized void a(long r4) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (k.d() == false) goto L7;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "setLoopInterval:" + r4);     // Catch: Throwable -> L16
    L7:
        if (r4 > 0) goto L9;
    L14:
        monitor-exit(this);
        return;
    L9:
        if (this.f8611a == r4) goto L14;
        this.f8611a = Math.min(r4, this.f8611a);     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public synchronized void b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f8615e == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f8615e = true;     // Catch: Throwable -> L11
        com.bytedance.framwork.core.sdklib.thread.a.a().a(this);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    @Override // com.bytedance.framwork.core.sdklib.thread.b
    public void b(long r3) {
        if ((r3 - this.f) < this.f8611a) goto L8;
        c();
        this.f = System.currentTimeMillis();
        if (k.d() == false) goto L9;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "onTimeEvent");
        return;
    L9:
        return;
    }

    public void a(j r1) {
        this.f8614d = r1;
    }

    private void c() {
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L10
        d();     // Catch: Throwable -> L10
        e();     // Catch: Throwable -> L10
        if (k.c() == false) goto L7;
        f();     // Catch: Throwable -> L10
    L7:
        if (k.d() == false) goto L15;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "LogReporter One Loop Cost:" + (System.currentTimeMillis() - r1));     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "report", th);
    }

    private void d() {
    L6:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "flushBuffer", th);
        return;
    L3:
        if (this.f8614d == null) goto L11;
        this.f8614d.a();     // Catch: Throwable -> L6
        return;
    }

    private void e() {
        if (this.f8613c.b() == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L7:
        if (this.f8613c.b() == true) goto L18;
        r0.add(this.f8613c.a());
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.f8613c.a(), b.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        int r3 = r2.a();
        if (r1 == 0) goto L17;
        if ((r1 + r3) < this.f8612b) goto L17;
        f.a().a(r0);
        r0.clear();
        r0.add(r2);
        r1 = r3;
    L17:
        r1 = r1 + r3;
        r0.add(r2);
        goto L7
    L18:
        f.a().a(r0);
    }

    private void f() {
        ArrayList r0 = new ArrayList();
        if (this.f8614d == null) goto L8;
        List<File> r1 = this.f8614d.b();
        if (com.bytedance.apm6.util.f.a(r1) == true) goto L8;
        r0.addAll(r1);
    L8:
        if (com.bytedance.apm6.util.f.a(r0) == false) goto L10;
        return;
    L10:
        ArrayList r2 = new ArrayList();
        int r3 = 0;
        int r4 = 0;
    L12:
        if (r3 >= r0.size()) goto L32;
        File r5 = (File) ZeusTransformUtils.preCheckCast(r0.get(r3), File.class, "com.obric.aiagent.plugin");
        if (r5.exists() == true) goto L16;
        com.bytedance.framwork.core.sdklib.a.c.d.c("APM-SDK", "reportFile file is not exist:" + r5.getAbsolutePath());
    L30:
        r3 = r3 + 1;
        goto L12
    L16:
        b r6 = b.a(r5);
        if (r6 == null) goto L19;
        int r7 = r6.a();
        if (r4 != 0) goto L25;
    L29:
        r4 = r4 + r7;
        r2.add(r6);
        goto L30
    L25:
        if ((r4 + r7) < this.f8612b) goto L29;
        f.a().a(r2);
        return;
    L19:
        if (k.d() == false) goto L21;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "logFile invalid. delete now.");
    L21:
        r5.delete();
        goto L30
    L32:
        if (com.bytedance.apm6.util.f.a(r2) == true) goto L40;
        f.a().a(r2);
        return;
    }

    public void a(b r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.f8613c.a(r1);
    }
}

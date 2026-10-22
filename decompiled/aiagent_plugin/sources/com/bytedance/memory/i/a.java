package com.bytedance.memory.i;

import com.bytedance.monitor.a.b.c;
import com.bytedance.monitor.a.b.d;
import com.bytedance.monitor.a.b.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MemoryChecker.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile a f8845e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f8846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f8847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f8848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.memory.b.a f8849d;
    private d f;
    private com.bytedance.memory.f.a g;
    private e h;

    static {
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.d();
    }

    static /* synthetic */ boolean a(a r0, com.bytedance.memory.f.a r1) {
        return r0.a(r1);
    }

    static /* synthetic */ boolean a(a r0, boolean r1) {
        r0.f8848c = r1;
        return r1;
    }

    static /* synthetic */ com.bytedance.memory.f.a b(a r0) {
        return r0.g;
    }

    static /* synthetic */ com.bytedance.memory.b.a c(a r0) {
        return r0.f8849d;
    }

    private a() {
        this.f8846a = false;
        this.f8847b = false;
        this.f8848c = false;
        this.h = new AnonymousClass1(this);
        this.f = c.a();
    }

    public static a a() {
        if (f8845e != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8845e != null) goto L9;
        f8845e = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f8845e;
    }

    public void a(com.bytedance.memory.f.a r7, com.bytedance.memory.b.a r8) {
        com.bytedance.memory.b.a r9 = (com.bytedance.memory.b.a) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.memory.b.a.class, "com.obric.aiagent.plugin");
        if (this.f8846a == false) goto L6;
        com.bytedance.memory.b.c.a("startCheck canAnalyse", new Object[0]);
        return;
    L6:
        this.f8847b = false;
        this.g = r7;
        if (this.f == null) goto L14;
        com.bytedance.memory.b.c.a("enter startCheck", new Object[0]);
        this.f8849d = r9;
        if (r9.d() == false) goto L11;
        int r10 = 1;
    L12:
        long r4 = r10 * 1000;
        this.f.a(this.h, r4, r4);
        return;
    L11:
        r10 = 30;
        goto L12
    }

    public void a(boolean r1) {
        this.f8846a = r1;
    }

    private boolean a(com.bytedance.memory.f.a r1) {
        if (com.bytedance.memory.b.d.a() < r1.f()) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean d() {
        boolean r0 = this.f8849d.b();
        if (r0 == true) goto L5;
    L7:
        if (r0 == true) goto L15;
        if (this.f8848c == true) goto L15;
        if (this.f8847b == true) goto L15;
        if (this.f8849d.c() == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (this.f == null) goto L7;
        com.bytedance.memory.b.c.a("canAnalyse, so cancel check", new Object[0]);
        this.f.b(this.h);
        this.f8846a = true;
        goto L7
    }

    public void b() {
        com.bytedance.memory.b.c.a("stopCheck", new Object[0]);
        this.f8847b = true;
        d r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.b(this.h);
    }

    public void c() {
        com.bytedance.memory.b.c.a("finish dumpHeap", new Object[0]);
        this.f8848c = false;
    }
}

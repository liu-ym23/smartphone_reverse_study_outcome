package com.bytedance.monitor.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: AsyncTaskManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f8880b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f8881d = null;
    private static final Object f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile com.bytedance.monitor.a.b.a.b f8882a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile com.bytedance.monitor.a.b.a.b f8883c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile com.bytedance.monitor.a.b.a.b f8884e;
    private Map<b, Long> g;
    private f h;
    private d.a i;

    /* JADX INFO: renamed from: com.bytedance.monitor.a.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncTaskManager.java */
    private static final class C0202a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f8888a = null;

        static {
            f8888a = new a();
        }
    }

    static /* synthetic */ Map a(a r0) {
        return r0.g;
    }

    static {
        f8880b = new Object();
        f8881d = new Object();
        f = new Object();
    }

    public a() {
        this.g = new ConcurrentHashMap(3);
    }

    public static a a() {
        return C0202a.f8888a;
    }

    @Override // com.bytedance.monitor.a.b.a.c
    public void a(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L10;
        return;
    L10:
        c(r4).a(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        a(th, "Apm-Async-task-post");
    }

    @Override // com.bytedance.monitor.a.b.a.c
    public void a(e r3, long r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L10;
        return;
    L10:
        c(r5).a(r5, r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        a(th, "Apm-Async-task-postDelayed");
    }

    @Override // com.bytedance.monitor.a.b.a.c
    public void b(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L10;
        return;
    L10:
        c(r4).b(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        a(th, "Apm-Async-task-removeTask");
    }

    @Override // com.bytedance.monitor.a.b.a.c
    public void a(e r7, long r8, long r10) {
        e r1 = (e) ZeusTransformUtils.wrapperContextForParams(r7, e.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L10;
        return;
    L10:
        c(r1).a(r1, r8, r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        a(th, "Apm-Async-task-removeTask");
    }

    @Override // com.bytedance.monitor.a.b.d
    public ExecutorService b() {
        return e();
    }

    @Override // com.bytedance.monitor.a.b.d
    public f c() {
        return this.h;
    }

    @Override // com.bytedance.monitor.a.b.d
    public long a(b r2) {
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(this.g.get(r2), Long.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return -1;
    L5:
        return r1.longValue();
    }

    @Override // com.bytedance.monitor.a.b.d
    public void a(Throwable r1, String r2) {
        d.a r0 = this.i;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    @Override // com.bytedance.monitor.a.b.d
    public void a(ExecutorService r3) {
        ExecutorService r4 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
        e().a(r4);
    }

    private com.bytedance.monitor.a.b.a.c c(e r3) {
        b r4 = ((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin")).b();
        if (r4 != b.f8907a) goto L7;
        return e();
    L7:
        if (r4 != b.f8908b) goto L11;
        return f();
    L11:
        return d();
    }

    public com.bytedance.monitor.a.b.a.b d() {
        if (this.f8883c != null) goto L15;
        Object r0 = f8881d;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f8883c != null) goto L9;
        b(this.h);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return this.f8883c;
    }

    public com.bytedance.monitor.a.b.a.b e() {
        if (this.f8882a != null) goto L15;
        Object r0 = f8880b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f8882a != null) goto L9;
        a(this.h);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return this.f8882a;
    }

    public com.bytedance.monitor.a.b.a.b f() {
        if (this.f8884e != null) goto L15;
        Object r0 = f;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f8884e != null) goto L9;
        c(this.h);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return this.f8884e;
    }

    private void a(f r5) {
        f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.aiagent.plugin");
        Object r0 = f8880b;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f8882a != null) goto L7;
        com.bytedance.monitor.a.b.a.a r1 = new com.bytedance.monitor.a.b.a.a("io-task");     // Catch: Throwable -> L9
        r1.a(r6);     // Catch: Throwable -> L9
        r1.a(new AnonymousClass1(this));     // Catch: Throwable -> L9
        com.bytedance.monitor.a.b.a.b r2 = new com.bytedance.monitor.a.b.a.b(1, r1);     // Catch: Throwable -> L9
        r2.a(r6);     // Catch: Throwable -> L9
        this.f8882a = r2;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void b(f r5) {
        f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.aiagent.plugin");
        Object r0 = f8881d;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f8883c != null) goto L7;
        com.bytedance.monitor.a.b.a.a r1 = new com.bytedance.monitor.a.b.a.a("light-weight-task");     // Catch: Throwable -> L9
        r1.a(r6);     // Catch: Throwable -> L9
        r1.a(new AnonymousClass2(this));     // Catch: Throwable -> L9
        com.bytedance.monitor.a.b.a.b r2 = new com.bytedance.monitor.a.b.a.b(1, r1);     // Catch: Throwable -> L9
        r2.a(r6);     // Catch: Throwable -> L9
        this.f8883c = r2;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void c(f r5) {
        f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.aiagent.plugin");
        Object r0 = f;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f8884e != null) goto L7;
        com.bytedance.monitor.a.b.a.a r1 = new com.bytedance.monitor.a.b.a.a("time-sensitive-task");     // Catch: Throwable -> L9
        r1.a(r6);     // Catch: Throwable -> L9
        r1.a(new AnonymousClass3(this));     // Catch: Throwable -> L9
        com.bytedance.monitor.a.b.a.b r2 = new com.bytedance.monitor.a.b.a.b(1, r1);     // Catch: Throwable -> L9
        r2.a(r6);     // Catch: Throwable -> L9
        this.f8884e = r2;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    @Override // com.bytedance.monitor.a.b.d
    public void a(d.a r3) {
        this.i = (d.a) ZeusTransformUtils.wrapperContextForParams(r3, d.a.class, "com.obric.aiagent.plugin");
    }
}

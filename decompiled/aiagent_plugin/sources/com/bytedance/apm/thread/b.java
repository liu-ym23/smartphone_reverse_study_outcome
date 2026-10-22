package com.bytedance.apm.thread;

import com.bytedance.monitor.a.b.e;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: AsyncEventManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f4870a = 30000;
    private static long f = 30000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    CopyOnWriteArraySet<InterfaceC0118b> f4871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    CopyOnWriteArraySet<InterfaceC0118b> f4872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile ExecutorService f4873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f4874e;
    private com.bytedance.monitor.a.b.d g;
    private final e h;
    private final e i;

    /* JADX INFO: compiled from: AsyncEventManager.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f4878a = null;

        static {
            f4878a = new b(null);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.thread.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncEventManager.java */
    public interface InterfaceC0118b {
        void onTimeEvent(long r1);
    }

    static {
    }

    /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean a(b r0) {
        return r0.f4874e;
    }

    static /* synthetic */ long e() {
        return f;
    }

    private b() {
        this.f4874e = true;
        this.h = new AnonymousClass1(this);
        this.i = new AnonymousClass2(this);
        this.f4871b = new CopyOnWriteArraySet();
        this.f4872c = new CopyOnWriteArraySet();
        this.g = com.bytedance.monitor.a.b.c.a();
    }

    public static b a() {
        return a.f4878a;
    }

    public boolean b() {
        if (this.g != null) goto L5;
    L7:
        return false;
    L5:
        if (Thread.currentThread().getId() != this.g.a(com.bytedance.monitor.a.b.b.f8909c)) goto L7;
        return true;
    }

    public void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (this.g == null) goto L10;
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.f4874e == false) goto L12;
        this.g.a(a(r4, CozeCloudExt.API_KEY_HTTP_POST_METHOD));
        return;
    L12:
        return;
    }

    public void b(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        com.bytedance.monitor.a.b.d r0 = this.g;
        if (r0 == null) goto L8;
        if (r4 == null) goto L9;
        r0.a(a(r4, CozeCloudExt.API_KEY_HTTP_POST_METHOD));
        return;
    L9:
        return;
    }

    public void a(Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (this.g == null) goto L10;
        if (r5 != null) goto L6;
        return;
    L6:
        if (this.f4874e == false) goto L12;
        this.g.a(a(r5, "postDelayed"), r4);
        return;
    L12:
        return;
    }

    public void a(e r3, long r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        if (this.g == null) goto L10;
        if (r5 != null) goto L6;
        return;
    L6:
        if (this.f4874e == false) goto L12;
        this.g.a(r5, r4);
        return;
    L12:
        return;
    }

    public void b(e r3, long r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        com.bytedance.monitor.a.b.d r2 = this.g;
        if (r2 == null) goto L8;
        if (r5 == null) goto L9;
        r2.a(r5, r4);
        return;
    L9:
        return;
    }

    public void a(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        com.bytedance.monitor.a.b.d r2 = this.g;
        if (r2 == null) goto L8;
        if (r4 == null) goto L9;
        r2.b(r4);
        return;
    L9:
        return;
    }

    public void a(InterfaceC0118b r3) {
        InterfaceC0118b r4 = (InterfaceC0118b) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0118b.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L13;
        if (this.f4874e == true) goto L7;
        return;
    L7:
        if (this.f4871b.contains(r4) == true) goto L15;
        this.f4871b.add(r4);     // Catch: Throwable -> L10
        a(this.h);     // Catch: Throwable -> L10
        a(this.h, f4870a);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L16:
        return;
    }

    public void b(InterfaceC0118b r3) {
        InterfaceC0118b r4 = (InterfaceC0118b) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0118b.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L9;
        this.f4871b.remove(r4);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public void c() {
        this.f4874e = false;
        a(this.h);
        a(this.i);
    }

    public void d() {
        this.f4874e = true;
        if (this.f4871b.isEmpty() == true) goto L6;
        a(this.h);
        a(this.h, f4870a);
    L6:
        if (this.f4872c.isEmpty() == true) goto L9;
        a(this.i);
        a(this.i, f);
        return;
    }

    public void a(ExecutorService r3) {
        ExecutorService r4 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        monitor-enter(this);
        this.f4873d = r4;     // Catch: Throwable -> L11
        com.bytedance.monitor.a.b.d r0 = this.g;     // Catch: Throwable -> L11
        if (r0 == null) goto L9;
        r0.a(r4);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void c(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (this.f4873d != null) goto L16;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.f4873d != null) goto L11;
        com.bytedance.monitor.a.b.d r0 = this.g;     // Catch: Throwable -> L13
        if (r0 == null) goto L10;
        this.f4873d = r0.b();     // Catch: Throwable -> L13
        goto L11
    L10:
        this.f4873d = Executors.newFixedThreadPool(1, new AnonymousClass3(this));     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
    L16:
        this.f4873d.submit(r4);
    }

    private e a(Runnable r2, String r3) {
        return com.bytedance.monitor.a.b.c.a("AsyncEventManager-" + r3, (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"));
    }
}

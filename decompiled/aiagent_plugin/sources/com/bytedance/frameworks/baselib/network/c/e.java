package com.bytedance.frameworks.baselib.network.c;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: NetThreadPoolManager.java */
/* JADX INFO: loaded from: classes.dex */
class e implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static e f8015a;
    private static AtomicInteger h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakHandler f8016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ThreadPoolExecutor f8017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ThreadPoolExecutor f8018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ThreadPoolExecutor f8019e;
    private ThreadPoolExecutor f;
    private ThreadPoolExecutor g;

    /* JADX INFO: compiled from: NetThreadPoolManager.java */
    abstract class a implements Comparable<a>, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.bytedance.frameworks.baselib.network.c.b f8022a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f8023c;

        static /* synthetic */ com.bytedance.frameworks.baselib.network.c.b b(a r0) {
            return r0.f8022a;
        }

        public a(e r1, com.bytedance.frameworks.baselib.network.c.b r2) {
            this.f8023c = r1;
            this.f8022a = r2;
        }
    }

    /* JADX INFO: compiled from: NetThreadPoolManager.java */
    static class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f8024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f8025b;

        b(String r3) {
            this.f8024a = new AtomicInteger(1);
            this.f8025b = "ApiExecutor";
            if (TextUtils.isEmpty(r3) == true) goto L6;
            this.f8025b = r3;
            return;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r3) {
            final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
            final String r0 = this.f8025b + "#" + this.f8024a.getAndIncrement();
            Thread r1 = new AnonymousClass1(this, r4, r0);
            r1.setDaemon(false);
            return r1;
        }
    }

    static /* synthetic */ ExecutorService a(e r0) {
        return r0.c();
    }

    static /* synthetic */ ExecutorService b(e r0) {
        return r0.d();
    }

    static {
        h = new AtomicInteger();
        f8015a = new e();
    }

    private static int a() {
        return h.incrementAndGet();
    }

    private e() {
        this.f8016b = new WeakHandler(Looper.getMainLooper(), this);
    }

    private g b() {
        return f.a();
    }

    private synchronized ExecutorService c() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f8017c != null) goto L8;
        ThreadPoolExecutor r0 = b().a();     // Catch: Throwable -> L11
        this.f8017c = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        this.f8017c = new ThreadPoolExecutor(b().o(), Integer.MAX_VALUE, b().n(), TimeUnit.SECONDS, new SynchronousQueue(), new b("NetImmediate"));     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r1 = this.f8017c;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    }

    private synchronized ExecutorService d() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f8018d != null) goto L8;
        ThreadPoolExecutor r0 = b().c();     // Catch: Throwable -> L11
        this.f8018d = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(b().j(), b().f(), b().l(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new b("NetNormal"));     // Catch: Throwable -> L11
        this.f8018d = r1;     // Catch: Throwable -> L11
        r1.allowCoreThreadTimeOut(f.a().p());     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r2 = this.f8018d;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }

    private synchronized ExecutorService e() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f8019e != null) goto L8;
        ThreadPoolExecutor r0 = b().d();     // Catch: Throwable -> L11
        this.f8019e = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(b().k(), b().g(), b().m(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new b("NetDownload"));     // Catch: Throwable -> L11
        this.f8019e = r1;     // Catch: Throwable -> L11
        r1.allowCoreThreadTimeOut(f.a().p());     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r2 = this.f8019e;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }

    private synchronized ExecutorService f() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f != null) goto L8;
        ThreadPoolExecutor r0 = b().e();     // Catch: Throwable -> L11
        this.f = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(b().h(), b().h(), b().i(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new b("NetLowest"));     // Catch: Throwable -> L11
        this.f = r1;     // Catch: Throwable -> L11
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r2 = this.f;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }

    private synchronized ExecutorService g() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.g != null) goto L8;
        ThreadPoolExecutor r0 = b().b();     // Catch: Throwable -> L11
        this.g = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        this.g = new ThreadPoolExecutor(1, 1, b().n(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new b("NetLocal"));     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r1 = this.g;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    }

    void a(com.bytedance.frameworks.baselib.network.c.b r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.e() == true) goto L21;
        r5.c(a());
        if (r5.a() != c.a.f8014e) goto L10;
        c().execute(r5);
        return;
    L10:
        if (r5.a() != c.a.f8010a) goto L12;
        f().execute(r5);
        return;
    L12:
        long r0 = r5.f();
        if (r0 <= 0) goto L15;
        Message r2 = Message.obtain();
        r2.what = 1;
        r2.obj = r5;
        this.f8016b.sendMessageDelayed(r2, r0);
        return;
    L15:
        a(this.f8019e, r5);
        e().execute(r5);
        return;
    }

    void b(com.bytedance.frameworks.baselib.network.c.b r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.e() == true) goto L25;
        r5.c(a());
        if (r5.d() == false) goto L10;
        g().execute(c(r5));
        return;
    L10:
        if (r5.a() != c.a.f8014e) goto L13;
        c().execute(r5);
        return;
    L13:
        if (r5.a() != c.a.f8010a) goto L15;
        f().execute(r5);
        return;
    L15:
        long r0 = r5.f();
        if (r0 <= 0) goto L18;
        Message r2 = Message.obtain();
        r2.what = 0;
        r2.obj = r5;
        this.f8016b.sendMessageDelayed(r2, r0);
        return;
    L18:
        a(this.f8018d, r5);
        d().execute(r5);
        return;
    }

    private a c(final com.bytedance.frameworks.baselib.network.c.b r2) {
        return new AnonymousClass1(this, r2, r2);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (ZeusTransformUtils.instanceOf(r5.obj, Runnable.class) == false) goto L23;
        int r0 = r5.what;     // Catch: Throwable -> L15
        if (r0 != 0) goto L10;
        a(this.f8018d, (com.bytedance.frameworks.baselib.network.c.b) ZeusTransformUtils.preCheckCast(r5.obj, com.bytedance.frameworks.baselib.network.c.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        d().execute((Runnable) ZeusTransformUtils.preCheckCast(r5.obj, Runnable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
    L18:
        return;
    L10:
        if (r0 != 1) goto L18;
        a(this.f8019e, (com.bytedance.frameworks.baselib.network.c.b) ZeusTransformUtils.preCheckCast(r5.obj, com.bytedance.frameworks.baselib.network.c.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        c().execute((Runnable) ZeusTransformUtils.preCheckCast(r5.obj, Runnable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private static void a(ThreadPoolExecutor r2, com.bytedance.frameworks.baselib.network.c.b r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (ZeusTransformUtils.instanceOf(r3, com.bytedance.frameworks.baselib.network.c.a.class) == false) goto L8;
        ((com.bytedance.frameworks.baselib.network.c.a) ZeusTransformUtils.preCheckCast(r3, com.bytedance.frameworks.baselib.network.c.a.class, "com.obric.aiagent.plugin")).b(r2.getQueue().size());
        return;
    }
}

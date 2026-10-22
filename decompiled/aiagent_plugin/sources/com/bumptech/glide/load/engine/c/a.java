package com.bumptech.glide.load.engine.c;

import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: GlideExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ExecutorService {
    private static final String TAG = "GlideExecutor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f3594a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f3595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ExecutorService f3596c;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GlideExecutor.java */
    public static final class C0094a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f3597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f3599c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private c f3600d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f3601e;
        private long f;

        C0094a(boolean r2) {
            this.f3600d = c.f3610d;
            this.f3597a = r2;
        }

        public C0094a a(int r1) {
            this.f3598b = r1;
            this.f3599c = r1;
            return this;
        }

        public C0094a a(String r1) {
            this.f3601e = r1;
            return this;
        }

        public a a() {
            if (TextUtils.isEmpty(this.f3601e) == true) goto L10;
            ThreadPoolExecutor r0 = new ThreadPoolExecutor(this.f3598b, this.f3599c, this.f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(this.f3601e, this.f3600d, this.f3597a));
            if (this.f == 0) goto L8;
            r0.allowCoreThreadTimeOut(true);
        L8:
            return new a(r0);
        L10:
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f3601e);
        }
    }

    /* JADX INFO: compiled from: GlideExecutor.java */
    private static final class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f3602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f3603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f3604c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f3605d;

        b(String r3, c r4, boolean r5) {
            c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
            this.f3604c = r3;
            this.f3602a = r6;
            this.f3603b = r5;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable r4) {
            monitor-enter(this);
            final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
            final String r1 = "glide-" + this.f3604c + "-thread-" + this.f3605d;     // Catch: Throwable -> L6
            Thread r0 = new AnonymousClass1(this, r5, r1);     // Catch: Throwable -> L6
            this.f3605d++;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: GlideExecutor.java */
    public interface c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f3607a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f3608b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f3609c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f3610d = null;

        void a(Throwable r1);

        static {
            f3607a = new AnonymousClass1();
            c r0 = new AnonymousClass2();
            f3608b = r0;
            f3609c = new AnonymousClass3();
            f3610d = r0;
        }
    }

    static {
        f3594a = TimeUnit.SECONDS.toMillis(10);
    }

    public static C0094a a() {
        return new C0094a(true).a(1).a("disk-cache");
    }

    public static a b() {
        return a().a();
    }

    public static C0094a c() {
        return new C0094a(false).a(h()).a(DBHelper.BATTERY_COL_SOURCE);
    }

    public static a d() {
        return c().a();
    }

    public static a e() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f3594a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b("source-unlimited", c.f3610d, false)));
    }

    public static C0094a f() {
        if (h() < 4) goto L5;
        int r0 = 2;
    L7:
        return new C0094a(true).a(r0).a("animation");
    L5:
        r0 = 1;
        goto L7
    }

    public static a g() {
        return f().a();
    }

    a(ExecutorService r3) {
        this.f3596c = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        this.f3596c.execute(r4);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        return this.f3596c.submit(r4);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r3) {
        Collection<? extends Callable<T>> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        return this.f3596c.invokeAll(r4);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r3, long r4, TimeUnit r6) {
        Collection<? extends Callable<T>> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        return this.f3596c.invokeAll(r5, r4, r6);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> r3) {
        Collection<? extends Callable<T>> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        return (T) this.f3596c.invokeAny(r4);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> r3, long r4, TimeUnit r6) {
        Collection<? extends Callable<T>> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        return (T) this.f3596c.invokeAny(r5, r4, r6);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable r3, T r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        return this.f3596c.submit(r5, r4);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> r3) {
        Callable<T> r4 = (Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.aiagent.plugin");
        return this.f3596c.submit(r4);
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f3596c.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.f3596c.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f3596c.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f3596c.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long r1, TimeUnit r3) {
        return this.f3596c.awaitTermination(r1, r3);
    }

    public String toString() {
        return this.f3596c.toString();
    }

    public static int h() {
        if (f3595b != 0) goto L6;
        f3595b = Math.min(4, com.bumptech.glide.load.engine.c.b.a());
    L6:
        return f3595b;
    }
}

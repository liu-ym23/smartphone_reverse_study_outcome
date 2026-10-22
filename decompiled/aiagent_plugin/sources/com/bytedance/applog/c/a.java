package com.bytedance.applog.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: AppLogExecutors.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5555a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5556b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5557c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5558d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f5559e = null;
    private static final ThreadFactoryC0135a f = null;
    private static final RejectedExecutionHandler g = null;
    private static final com.bytedance.applog.util.a<b> h = null;
    private static final com.bytedance.applog.util.a<b> i = null;

    /* JADX INFO: renamed from: com.bytedance.applog.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppLogExecutors.java */
    private static class ThreadFactoryC0135a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final AtomicInteger f5560a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ThreadGroup f5561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicInteger f5562c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f5563d;

        static {
            f5560a = new AtomicInteger(1);
        }

        ThreadFactoryC0135a(String r3) {
            this.f5562c = new AtomicInteger(1);
            SecurityManager r0 = System.getSecurityManager();
            if (r0 == null) goto L5;
            ThreadGroup r1 = r0.getThreadGroup();
        L6:
            this.f5561b = r1;
            this.f5563d = r3 + "-" + f5560a.getAndIncrement() + "-Thread-";
            return;
        L5:
            r1 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r7) {
            Thread r8 = new Thread(this.f5561b, (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.aiagent.plugin"), this.f5563d + this.f5562c.getAndIncrement(), 0);
            if (r8.isDaemon() == false) goto L6;
            r8.setDaemon(false);
        L6:
            if (r8.getPriority() == 5) goto L8;
            r8.setPriority(5);
        L8:
            return r8;
        }
    }

    static /* synthetic */ BlockingQueue c() {
        return f5559e;
    }

    static /* synthetic */ ThreadFactoryC0135a d() {
        return f;
    }

    static /* synthetic */ RejectedExecutionHandler e() {
        return g;
    }

    static {
        int r0 = Runtime.getRuntime().availableProcessors();
        f5555a = r0;
        if (r0 > 0) goto L6;
        r0 = 1;
    L6:
        f5556b = r0;
        int r1 = Math.max(2, Math.min(r0 - 1, 6)) * 2;
        f5557c = r1;
        f5558d = (r1 * 2) + 1;
        f5559e = new LinkedBlockingQueue();
        f = new ThreadFactoryC0135a("AppLogDefaultExecutors");
        g = new AnonymousClass1();
        h = new AnonymousClass2();
        i = new AnonymousClass3();
    }

    public static ExecutorService a() {
        return (ExecutorService) ZeusTransformUtils.preCheckCast(h.c(new Object[0]), ExecutorService.class, "com.obric.aiagent.plugin");
    }

    public static ExecutorService b() {
        return (ExecutorService) ZeusTransformUtils.preCheckCast(i.c(new Object[0]), ExecutorService.class, "com.obric.aiagent.plugin");
    }
}

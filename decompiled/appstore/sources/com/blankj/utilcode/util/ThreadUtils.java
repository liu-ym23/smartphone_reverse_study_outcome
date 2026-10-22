package com.blankj.utilcode.util;

import android.util.Log;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public abstract class ThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f6196a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f6197b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6198c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Timer f6199d = null;

    public static final class LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {
        private int mCapacity;
        private volatile a mPool;

        public LinkedBlockingQueue4Util() {
            this.mCapacity = Channel.UNLIMITED;
        }

        public static /* synthetic */ a access$602(LinkedBlockingQueue4Util r10, a r11) {
            r10.mPool = r11;
            return r11;
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public /* bridge */ /* synthetic */ boolean offer(@NonNull Object r10) {
            return offer((Runnable) r10);
        }

        public boolean offer(@NonNull Runnable r10) {
            if (this.mCapacity > size()) goto L11;
            if (this.mPool == null) goto L11;
            if (this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) goto L11;
            return false;
        L11:
            return super.offer(r10);
        }

        public LinkedBlockingQueue4Util(boolean r10) {
            this.mCapacity = Channel.UNLIMITED;
            if (r10 == false) goto L6;
            this.mCapacity = 0;
            return;
        }

        public LinkedBlockingQueue4Util(int r10) {
            this.mCapacity = r10;
        }
    }

    public static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = null;
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        public class a extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ UtilsThreadFactory f6200a;

            public a(UtilsThreadFactory r10, Runnable r11, String r12) {
                this.f6200a = r10;
                super(r11, r12);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                Log.e("ThreadUtils", "Request threw uncaught throwable", th);
            }
        }

        public class b implements Thread.UncaughtExceptionHandler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ UtilsThreadFactory f6201a;

            public b(UtilsThreadFactory r10) {
                this.f6201a = r10;
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread r10, Throwable r11) {
                System.out.println(r11);
            }
        }

        static {
            POOL_NUMBER = new AtomicInteger(1);
        }

        public UtilsThreadFactory(String r10, int r11) {
            this(r10, r11, false);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable r10) {
            a r11 = new a(this, r10, this.namePrefix + getAndIncrement());
            r11.setDaemon(this.isDaemon);
            r11.setUncaughtExceptionHandler(new b(this));
            r11.setPriority(this.priority);
            return r11;
        }

        public UtilsThreadFactory(String r10, int r11, boolean r12) {
            this.namePrefix = r10 + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = r11;
            this.isDaemon = r12;
        }
    }

    public static final class a extends ThreadPoolExecutor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f6202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LinkedBlockingQueue4Util f6203b;

        public a(int r10, int r11, long r12, TimeUnit r13, LinkedBlockingQueue4Util r14, ThreadFactory r15) {
            super(r10, r11, r12, r13, r14, r15);
            this.f6202a = new AtomicInteger();
            LinkedBlockingQueue4Util.access$602(r14, this);
            this.f6203b = r14;
        }

        public static /* synthetic */ ExecutorService a(int r10, int r11) {
            return b(r10, r11);
        }

        public static ExecutorService b(int r24, int r25) {
            if (r24 == (-8)) goto L19;
            if (r24 == (-4)) goto L17;
            if (r24 == (-2)) goto L15;
            if (r24 == (-1)) goto L13;
            return new a(r24, r24, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("fixed(" + r24 + ")", r25));
        L13:
            return new a(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("single", r25));
        L15:
            return new a(0, 128, 60, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cached", r25));
        L17:
            return new a((ThreadUtils.a() * 2) + 1, (ThreadUtils.a() * 2) + 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("io", r25));
        L19:
            return new a(ThreadUtils.a() + 1, (ThreadUtils.a() * 2) + 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cpu", r25));
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable r10, Throwable r11) {
            this.f6202a.decrementAndGet();
            super.afterExecute(r10, r11);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(Runnable r10) {
            if (isShutdown() == false) goto L5;
            return;
        L5:
            this.f6202a.incrementAndGet();
            super.execute(r10);     // Catch: Throwable -> L8 RejectedExecutionException -> L9
        L14:
            return;
        L9:
            Log.e("ThreadUtils", "This will not happen!");
            this.f6203b.offer(r10);
            return;
        L8:
            this.f6202a.decrementAndGet();
        }
    }

    static {
        f6196a = new HashMap();
        f6197b = new ConcurrentHashMap();
        f6198c = Runtime.getRuntime().availableProcessors();
        f6199d = new Timer();
    }

    public static /* synthetic */ int a() {
        return f6198c;
    }

    public static ExecutorService b() {
        return c(-2);
    }

    public static ExecutorService c(int r10) {
        return d(r10, 5);
    }

    public static ExecutorService d(int r10, int r11) {
        Map r12 = f6196a;
        monitor-enter(r12);
        Map r13 = (Map) r12.get(Integer.valueOf(r10));     // Catch: Throwable -> L7
        if (r13 != null) goto L9;
        ConcurrentHashMap r14 = new ConcurrentHashMap();     // Catch: Throwable -> L7
        ExecutorService r15 = a.a(r10, r11);     // Catch: Throwable -> L7
        r14.put(Integer.valueOf(r11), r15);     // Catch: Throwable -> L7
        r12.put(Integer.valueOf(r10), r14);     // Catch: Throwable -> L7
    L12:
        monitor-exit(r12);     // Catch: Throwable -> L7
        return r15;
    L9:
        r15 = (ExecutorService) r13.get(Integer.valueOf(r11));     // Catch: Throwable -> L7
        if (r15 != null) goto L12;
        r15 = a.a(r10, r11);     // Catch: Throwable -> L7
        r13.put(Integer.valueOf(r11), r15);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }
}

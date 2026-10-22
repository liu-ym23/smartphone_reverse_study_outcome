package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.Thread;
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
import s.C5424F;

/* loaded from: classes.dex */
public final class ThreadUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final Handler f19187a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Integer, Map<Integer, ExecutorService>> f19188b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final Map<Object, ExecutorService> f19189c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public static final int f19190d = Runtime.getRuntime().availableProcessors();

    /* renamed from: e, reason: collision with root package name */
    public static final Timer f19191e = new Timer();

    public static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f19194d = new AtomicInteger(1);

        /* renamed from: a, reason: collision with root package name */
        public final String f19195a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19196b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f19197c;

        public class a extends Thread {
            public a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (Throwable th) {
                    Log.e("ThreadUtils", "Request threw uncaught throwable", th);
                }
            }
        }

        public class b implements Thread.UncaughtExceptionHandler {
            public b() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                System.out.println(th);
            }
        }

        public UtilsThreadFactory(String str, int i10) {
            this(str, i10, false);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            a aVar = new a(runnable, this.f19195a + getAndIncrement());
            aVar.setDaemon(this.f19197c);
            aVar.setUncaughtExceptionHandler(new b());
            aVar.setPriority(this.f19196b);
            return aVar;
        }

        public UtilsThreadFactory(String str, int i10, boolean z10) {
            this.f19195a = str + "-pool-" + f19194d.getAndIncrement() + "-thread-";
            this.f19196b = i10;
            this.f19197c = z10;
        }
    }

    public static final class a extends ThreadPoolExecutor implements AutoCloseable {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f19200a;

        /* renamed from: b, reason: collision with root package name */
        public LinkedBlockingQueue4Util f19201b;

        public a(int i10, int i11, long j10, TimeUnit timeUnit, LinkedBlockingQueue4Util linkedBlockingQueue4Util, ThreadFactory threadFactory) {
            super(i10, i11, j10, timeUnit, linkedBlockingQueue4Util, threadFactory);
            this.f19200a = new AtomicInteger();
            linkedBlockingQueue4Util.f19192a = this;
            this.f19201b = linkedBlockingQueue4Util;
        }

        public static ExecutorService e(int i10, int i11) {
            if (i10 == -8) {
                return new a(ThreadUtils.f19190d + 1, (ThreadUtils.f19190d * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cpu", i11));
            }
            if (i10 == -4) {
                return new a((ThreadUtils.f19190d * 2) + 1, (ThreadUtils.f19190d * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("io", i11));
            }
            if (i10 == -2) {
                return new a(0, 128, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cached", i11));
            }
            if (i10 == -1) {
                return new a(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory(M5.c.DOWNLOAD_SINGLE, i11));
            }
            return new a(i10, i10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("fixed(" + i10 + ")", i11));
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            this.f19200a.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        @Override // java.lang.AutoCloseable
        public /* synthetic */ void close() throws InterruptedException {
            C5424F.a(this);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (isShutdown()) {
                return;
            }
            this.f19200a.incrementAndGet();
            try {
                super.execute(runnable);
            } catch (RejectedExecutionException unused) {
                Log.e("ThreadUtils", "This will not happen!");
                this.f19201b.offer(runnable);
            } catch (Throwable unused2) {
                this.f19200a.decrementAndGet();
            }
        }
    }

    public static ExecutorService b() {
        return c(-2);
    }

    public static ExecutorService c(int i10) {
        return d(i10, 5);
    }

    public static ExecutorService d(int i10, int i11) {
        ExecutorService executorServiceE;
        Map<Integer, Map<Integer, ExecutorService>> map = f19188b;
        synchronized (map) {
            try {
                Map<Integer, ExecutorService> map2 = map.get(Integer.valueOf(i10));
                if (map2 == null) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    executorServiceE = a.e(i10, i11);
                    concurrentHashMap.put(Integer.valueOf(i11), executorServiceE);
                    map.put(Integer.valueOf(i10), concurrentHashMap);
                } else {
                    executorServiceE = map2.get(Integer.valueOf(i11));
                    if (executorServiceE == null) {
                        executorServiceE = a.e(i10, i11);
                        map2.put(Integer.valueOf(i11), executorServiceE);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorServiceE;
    }

    public static void e(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f19187a.post(runnable);
        }
    }

    public static void f(Runnable runnable, long j10) {
        f19187a.postDelayed(runnable, j10);
    }

    public static final class LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {

        /* renamed from: a, reason: collision with root package name */
        public volatile a f19192a;

        /* renamed from: b, reason: collision with root package name */
        public int f19193b;

        public LinkedBlockingQueue4Util() {
            this.f19193b = Integer.MAX_VALUE;
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean offer(Runnable runnable) {
            if (this.f19193b > size() || this.f19192a == null || this.f19192a.getPoolSize() >= this.f19192a.getMaximumPoolSize()) {
                return super.offer(runnable);
            }
            return false;
        }

        public LinkedBlockingQueue4Util(boolean z10) {
            this.f19193b = Integer.MAX_VALUE;
            if (z10) {
                this.f19193b = 0;
            }
        }
    }
}

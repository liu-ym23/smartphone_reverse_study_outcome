package u9;

import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24900a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f24901b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f24902c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f24903d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BlockingQueue f24904e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ExecutorService f24905f = null;

    public static /* synthetic */ class a {
    }

    public static class b extends Thread {
        public b(Runnable r10) {
            super(r10, "vivo_media_worker_pool_thread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            long r10 = System.currentTimeMillis();
            super.run();
            o0.a.c("ProxyCacheThreadHandler execution time: " + (System.currentTimeMillis() - r10));
        }
    }

    /* JADX INFO: renamed from: u9.c$c, reason: collision with other inner class name */
    public static class ThreadFactoryC0389c implements ThreadFactory {
        public ThreadFactoryC0389c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            return new b(r10);
        }

        public /* synthetic */ ThreadFactoryC0389c(a r10) {
            this();
        }
    }

    static {
        int r10 = Runtime.getRuntime().availableProcessors();
        f24900a = r10;
        int r11 = r10 + 1;
        f24901b = r11;
        int r12 = (r10 * 2) + 1;
        f24902c = r12;
        int r13 = r10 ^ 2;
        f24903d = r13;
        LinkedBlockingQueue r14 = new LinkedBlockingQueue(r13);
        f24904e = r14;
        f24905f = new ThreadPoolExecutor(r11, r12, 1, TimeUnit.SECONDS, r14, new ThreadFactoryC0389c(null), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public static Future a(Callable r10) {
        return f24905f.submit(r10);
    }

    public static Future b(Runnable r10) {
        return f24905f.submit(r10);
    }
}

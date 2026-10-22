package E2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class f extends ThreadPoolExecutor implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor.AbortPolicy f459a = new ThreadPoolExecutor.AbortPolicy();

    public f(int i, int i6, LinkedBlockingQueue linkedBlockingQueue, ThreadFactory threadFactory) {
        super(i, i6, 30L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory, f459a);
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() throws InterruptedException {
        boolean zIsTerminated;
        if (this == ForkJoinPool.commonPool() || (zIsTerminated = isTerminated())) {
            return;
        }
        boolean z10 = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z10) {
                    shutdownNow();
                    z10 = true;
                }
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final void shutdown() {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        return new ArrayList();
    }
}

package j6;

import android.util.Log;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends ThreadPoolExecutor implements AutoCloseable {

    /* renamed from: c, reason: collision with root package name */
    public final AtomicInteger f6605c;

    /* renamed from: f, reason: collision with root package name */
    public final f f6606f;

    public g(int i, int i3, long j10, TimeUnit timeUnit, f fVar, j jVar) {
        super(i, i3, j10, timeUnit, fVar, jVar);
        this.f6605c = new AtomicInteger();
        fVar.f6603c = this;
        this.f6606f = fVar;
    }

    public static g d() {
        return new g(0, 128, 60L, TimeUnit.SECONDS, new f(0), new j("cached"));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable runnable, Throwable th) {
        this.f6605c.decrementAndGet();
        super.afterExecute(runnable, th);
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() throws InterruptedException {
        boolean zIsTerminated;
        if (this == ForkJoinPool.commonPool() || (zIsTerminated = isTerminated())) {
            return;
        }
        shutdown();
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

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (isShutdown()) {
            return;
        }
        AtomicInteger atomicInteger = this.f6605c;
        atomicInteger.incrementAndGet();
        try {
            super.execute(runnable);
        } catch (RejectedExecutionException unused) {
            Log.e("ThreadUtils", "This will not happen!");
            this.f6606f.offer(runnable);
        } catch (Throwable unused2) {
            atomicInteger.decrementAndGet();
        }
    }
}

package A;

import android.util.Pair;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class d extends ScheduledThreadPoolExecutor implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f66a;
    public final ConcurrentHashMap b;

    public d(c cVar) {
        super(1, cVar);
        this.f66a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable runnable, Throwable th) {
        Object obj;
        super.afterExecute(runnable, th);
        if (runnable instanceof ScheduledFuture) {
            ScheduledFuture scheduledFuture = (ScheduledFuture) runnable;
            ConcurrentHashMap concurrentHashMap = this.b;
            Pair pair = (Pair) concurrentHashMap.get(scheduledFuture);
            if (pair == null || (obj = pair.first) == null) {
                return;
            }
            Integer num = (Integer) obj;
            Boolean bool = (Boolean) pair.second;
            if (bool == null || bool.booleanValue()) {
                return;
            }
            ConcurrentHashMap concurrentHashMap2 = this.f66a;
            List list = (List) concurrentHashMap2.get(num);
            if (list != null) {
                list.remove(scheduledFuture);
                if (list.isEmpty()) {
                    concurrentHashMap2.remove(num);
                }
            }
            concurrentHashMap.remove(scheduledFuture);
        }
    }

    public final void b(H2.a aVar) {
        super.submit(aVar);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
    }

    public final void c(z.b bVar, long j5) {
        ScheduledFuture<?> scheduledFutureSchedule = schedule(bVar, j5, TimeUnit.MILLISECONDS);
        int iHashCode = bVar.hashCode();
        Integer numValueOf = Integer.valueOf(iHashCode);
        ConcurrentHashMap concurrentHashMap = this.f66a;
        List copyOnWriteArrayList = (List) concurrentHashMap.get(numValueOf);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            concurrentHashMap.put(Integer.valueOf(iHashCode), copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(scheduledFutureSchedule);
        this.b.put(scheduledFutureSchedule, new Pair(Integer.valueOf(iHashCode), Boolean.FALSE));
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

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void terminated() {
        super.terminated();
    }
}

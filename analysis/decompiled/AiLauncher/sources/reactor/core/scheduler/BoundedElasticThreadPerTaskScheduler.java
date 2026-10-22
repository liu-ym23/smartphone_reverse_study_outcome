package reactor.core.scheduler;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.SchedulerState;

/* loaded from: classes5.dex */
final class BoundedElasticThreadPerTaskScheduler implements Scheduler, SchedulerState.DisposeAwaiter<BoundedServices>, Scannable {

    public static final class BoundedServices {
        private BoundedServices() {
        }

        public BoundedServices(BoundedElasticThreadPerTaskScheduler boundedElasticThreadPerTaskScheduler) {
        }
    }

    public BoundedElasticThreadPerTaskScheduler(int i10, int i11, ThreadFactory threadFactory) {
        throw new UnsupportedOperationException("Unsupported in JDK lower than 21");
    }

    @Override // reactor.core.scheduler.SchedulerState.DisposeAwaiter
    public boolean await(BoundedServices boundedServices, long j10, TimeUnit timeUnit) throws InterruptedException {
        return false;
    }

    @Override // reactor.core.scheduler.Scheduler
    public Scheduler.Worker createWorker() {
        throw new UnsupportedOperationException("Unsupported in JDK lower than 21");
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return null;
    }

    @Override // reactor.core.scheduler.Scheduler
    public Disposable schedule(Runnable runnable) {
        throw new UnsupportedOperationException("Unsupported in JDK lower than 21");
    }
}

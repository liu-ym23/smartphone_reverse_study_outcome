package reactor.core.scheduler;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.SchedulerState;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class BoundedElasticThreadPerTaskScheduler implements Scheduler, SchedulerState.DisposeAwaiter<BoundedServices>, Scannable {
    public BoundedElasticThreadPerTaskScheduler(int i, int i3, ThreadFactory threadFactory) {
        throw new UnsupportedOperationException("Unsupported in JDK lower than 21");
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class BoundedServices {
        private BoundedServices() {
        }

        public BoundedServices(BoundedElasticThreadPerTaskScheduler boundedElasticThreadPerTaskScheduler) {
        }
    }

    @Override // reactor.core.scheduler.SchedulerState.DisposeAwaiter
    public boolean await(BoundedServices boundedServices, long j10, TimeUnit timeUnit) {
        return false;
    }
}

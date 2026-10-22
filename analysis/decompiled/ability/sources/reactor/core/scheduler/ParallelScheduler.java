package reactor.core.scheduler;

import com.fasterxml.jackson.core.JsonFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.SchedulerState;

/* loaded from: classes4.dex */
final class ParallelScheduler implements Scheduler, Supplier<ScheduledExecutorService>, SchedulerState.DisposeAwaiter<ScheduledExecutorService[]>, Scannable {
    private static final AtomicReferenceFieldUpdater<ParallelScheduler, SchedulerState> STATE;
    static final ScheduledExecutorService TERMINATED;
    final ThreadFactory factory;
    final int n;
    int roundRobin;
    volatile SchedulerState<ScheduledExecutorService[]> state;
    static final ScheduledExecutorService[] SHUTDOWN = new ScheduledExecutorService[0];
    static final AtomicLong COUNTER = new AtomicLong();

    static {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        TERMINATED = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.shutdownNow();
        STATE = AtomicReferenceFieldUpdater.newUpdater(ParallelScheduler.class, SchedulerState.class, "state");
    }

    public ParallelScheduler(int i, ThreadFactory threadFactory) {
        if (i <= 0) {
            throw new IllegalArgumentException(B7.a.h(i, "n > 0 required but it was "));
        }
        this.n = i;
        this.factory = threadFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Mono lambda$disposeGracefully$0() {
        SchedulerState<ScheduledExecutorService[]> schedulerState = this.state;
        if (schedulerState != null && schedulerState.currentResource == SHUTDOWN) {
            return schedulerState.onDispose;
        }
        SchedulerState schedulerStateTransition = SchedulerState.transition(schedulerState == null ? null : schedulerState.currentResource, SHUTDOWN, this);
        STATE.compareAndSet(this, schedulerState, schedulerStateTransition);
        T t9 = schedulerStateTransition.initialResource;
        if (t9 != 0) {
            for (ScheduledExecutorService scheduledExecutorService : (ScheduledExecutorService[]) t9) {
                scheduledExecutorService.shutdown();
            }
        }
        return schedulerStateTransition.onDispose;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Scannable lambda$inners$2(final ScheduledExecutorService scheduledExecutorService) {
        return new Scannable() { // from class: reactor.core.scheduler.f
            @Override // reactor.core.Scannable
            public final Object scanUnsafe(Scannable.Attr attr) {
                return Schedulers.scanExecutor(scheduledExecutorService, attr);
            }
        };
    }

    @Override // reactor.core.scheduler.Scheduler
    public Scheduler.Worker createWorker() {
        return new ExecutorServiceWorker(pick());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // reactor.core.scheduler.Scheduler, reactor.core.Disposable
    public void dispose() {
        SchedulerState<ScheduledExecutorService[]> schedulerState = this.state;
        int i = 0;
        if (schedulerState != null && schedulerState.currentResource == SHUTDOWN) {
            ScheduledExecutorService[] scheduledExecutorServiceArr = schedulerState.initialResource;
            if (scheduledExecutorServiceArr != null) {
                ScheduledExecutorService[] scheduledExecutorServiceArr2 = scheduledExecutorServiceArr;
                int length = scheduledExecutorServiceArr2.length;
                while (i < length) {
                    scheduledExecutorServiceArr2[i].shutdownNow();
                    i++;
                }
                return;
            }
            return;
        }
        SchedulerState schedulerStateTransition = SchedulerState.transition(schedulerState == null ? null : schedulerState.currentResource, SHUTDOWN, this);
        STATE.compareAndSet(this, schedulerState, schedulerStateTransition);
        T t9 = schedulerStateTransition.initialResource;
        if (t9 != 0) {
            ScheduledExecutorService[] scheduledExecutorServiceArr3 = (ScheduledExecutorService[]) t9;
            int length2 = scheduledExecutorServiceArr3.length;
            while (i < length2) {
                scheduledExecutorServiceArr3[i].shutdownNow();
                i++;
            }
        }
    }

    @Override // reactor.core.scheduler.Scheduler
    public Mono<Void> disposeGracefully() {
        return Mono.defer(new b(this, 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // reactor.core.scheduler.Scheduler
    public void init() {
        SchedulerState<ScheduledExecutorService[]> schedulerState = this.state;
        if (schedulerState != null) {
            if (schedulerState.currentResource == SHUTDOWN) {
                throw new IllegalStateException("Initializing a disposed scheduler is not permitted");
            }
            return;
        }
        SchedulerState schedulerStateInit = SchedulerState.init(new ScheduledExecutorService[this.n]);
        for (int i = 0; i < this.n; i++) {
            ((ScheduledExecutorService[]) schedulerStateInit.currentResource)[i] = Schedulers.decorateExecutorService(this, get());
        }
        if (STATE.compareAndSet(this, null, schedulerStateInit)) {
            return;
        }
        for (ScheduledExecutorService scheduledExecutorService : (ScheduledExecutorService[]) schedulerStateInit.currentResource) {
            scheduledExecutorService.shutdownNow();
        }
        if (isDisposed()) {
            throw new IllegalStateException("Initializing a disposed scheduler is not permitted");
        }
    }

    @Override // reactor.core.Scannable
    public Stream<? extends Scannable> inners() {
        return Stream.of((Object[]) this.state.currentResource).map(new g(0));
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        SchedulerState<ScheduledExecutorService[]> schedulerState = this.state;
        return schedulerState != null && schedulerState.currentResource == SHUTDOWN;
    }

    public ScheduledExecutorService pick() {
        SchedulerState<ScheduledExecutorService[]> schedulerState = this.state;
        if (schedulerState == null) {
            init();
            schedulerState = this.state;
            if (schedulerState == null) {
                throw new IllegalStateException("executors uninitialized after implicit init()");
            }
        }
        ScheduledExecutorService[] scheduledExecutorServiceArr = schedulerState.currentResource;
        if (scheduledExecutorServiceArr == SHUTDOWN) {
            return TERMINATED;
        }
        int i = this.roundRobin;
        if (i == this.n) {
            this.roundRobin = 1;
            i = 0;
        } else {
            this.roundRobin = i + 1;
        }
        return scheduledExecutorServiceArr[i];
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.TERMINATED || attr == Scannable.Attr.CANCELLED) {
            return Boolean.valueOf(isDisposed());
        }
        if (attr == Scannable.Attr.CAPACITY || attr == Scannable.Attr.BUFFERED) {
            return Integer.valueOf(this.n);
        }
        if (attr == Scannable.Attr.NAME) {
            return toString();
        }
        return null;
    }

    @Override // reactor.core.scheduler.Scheduler
    public Disposable schedule(Runnable runnable) {
        return Schedulers.directSchedule(pick(), runnable, null, 0L, TimeUnit.MILLISECONDS);
    }

    @Override // reactor.core.scheduler.Scheduler
    public Disposable schedulePeriodically(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
        return Schedulers.directSchedulePeriodically(pick(), runnable, j5, j6, timeUnit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // reactor.core.scheduler.Scheduler
    public void start() {
        SchedulerState<ScheduledExecutorService[]> schedulerState = this.state;
        if (schedulerState == null || schedulerState.currentResource == SHUTDOWN) {
            SchedulerState schedulerStateInit = SchedulerState.init(new ScheduledExecutorService[this.n]);
            for (int i = 0; i < this.n; i++) {
                ((ScheduledExecutorService[]) schedulerStateInit.currentResource)[i] = Schedulers.decorateExecutorService(this, get());
            }
            if (STATE.compareAndSet(this, schedulerState, schedulerStateInit)) {
                return;
            }
            for (ScheduledExecutorService scheduledExecutorService : (ScheduledExecutorService[]) schedulerStateInit.currentResource) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("parallel(");
        sb.append(this.n);
        if (this.factory instanceof ReactorThreadFactory) {
            sb.append(",\"");
            sb.append(((ReactorThreadFactory) this.factory).get());
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        sb.append(')');
        return sb.toString();
    }

    @Override // reactor.core.scheduler.SchedulerState.DisposeAwaiter
    public boolean await(ScheduledExecutorService[] scheduledExecutorServiceArr, long j5, TimeUnit timeUnit) throws InterruptedException {
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            if (!scheduledExecutorService.awaitTermination(j5, timeUnit)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.function.Supplier
    public ScheduledExecutorService get() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, this.factory);
        scheduledThreadPoolExecutor.setMaximumPoolSize(1);
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
        return scheduledThreadPoolExecutor;
    }

    @Override // reactor.core.scheduler.Scheduler
    public Disposable schedule(Runnable runnable, long j5, TimeUnit timeUnit) {
        return Schedulers.directSchedule(pick(), runnable, null, j5, timeUnit);
    }
}

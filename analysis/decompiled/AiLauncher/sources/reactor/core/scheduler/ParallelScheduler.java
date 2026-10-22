package reactor.core.scheduler;

import com.fasterxml.jackson.core.JsonFactory;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.SchedulerState;

/* loaded from: classes5.dex */
final class ParallelScheduler implements Scheduler, Supplier<ScheduledExecutorService>, SchedulerState.DisposeAwaiter<ScheduledExecutorService[]>, Scannable {
    private static final AtomicReferenceFieldUpdater<ParallelScheduler, SchedulerState> STATE;
    static final ScheduledExecutorService TERMINATED;
    final ThreadFactory factory;

    /* renamed from: n, reason: collision with root package name */
    final int f39829n;
    int roundRobin;
    volatile SchedulerState<ScheduledExecutorService[]> state;
    static final ScheduledExecutorService[] SHUTDOWN = new ScheduledExecutorService[0];
    static final AtomicLong COUNTER = new AtomicLong();

    static {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        TERMINATED = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.shutdownNow();
        STATE = AtomicReferenceFieldUpdater.newUpdater(ParallelScheduler.class, SchedulerState.class, VoiceWakeupReceiver.EXTRA_STATE);
    }

    public ParallelScheduler(int i10, ThreadFactory threadFactory) {
        if (i10 > 0) {
            this.f39829n = i10;
            this.factory = threadFactory;
        } else {
            throw new IllegalArgumentException("n > 0 required but it was " + i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Mono a(ParallelScheduler parallelScheduler) {
        SchedulerState<ScheduledExecutorService[]> schedulerState = parallelScheduler.state;
        if (schedulerState != null && schedulerState.currentResource == SHUTDOWN) {
            return schedulerState.onDispose;
        }
        SchedulerState schedulerStateTransition = SchedulerState.transition(schedulerState == null ? null : schedulerState.currentResource, SHUTDOWN, parallelScheduler);
        STATE.compareAndSet(parallelScheduler, schedulerState, schedulerStateTransition);
        T t10 = schedulerStateTransition.initialResource;
        if (t10 != 0) {
            for (ScheduledExecutorService scheduledExecutorService : (ScheduledExecutorService[]) t10) {
                scheduledExecutorService.shutdown();
            }
        }
        return schedulerStateTransition.onDispose;
    }

    public static /* synthetic */ Scannable c(final ScheduledExecutorService scheduledExecutorService) {
        return new Scannable() { // from class: reactor.core.scheduler.h
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
        int i10 = 0;
        if (schedulerState != null && schedulerState.currentResource == SHUTDOWN) {
            ScheduledExecutorService[] scheduledExecutorServiceArr = schedulerState.initialResource;
            if (scheduledExecutorServiceArr != null) {
                ScheduledExecutorService[] scheduledExecutorServiceArr2 = scheduledExecutorServiceArr;
                int length = scheduledExecutorServiceArr2.length;
                while (i10 < length) {
                    scheduledExecutorServiceArr2[i10].shutdownNow();
                    i10++;
                }
                return;
            }
            return;
        }
        SchedulerState schedulerStateTransition = SchedulerState.transition(schedulerState == null ? null : schedulerState.currentResource, SHUTDOWN, this);
        STATE.compareAndSet(this, schedulerState, schedulerStateTransition);
        T t10 = schedulerStateTransition.initialResource;
        if (t10 != 0) {
            ScheduledExecutorService[] scheduledExecutorServiceArr3 = (ScheduledExecutorService[]) t10;
            int length2 = scheduledExecutorServiceArr3.length;
            while (i10 < length2) {
                scheduledExecutorServiceArr3[i10].shutdownNow();
                i10++;
            }
        }
    }

    @Override // reactor.core.scheduler.Scheduler
    public Mono<Void> disposeGracefully() {
        return Mono.defer(new Supplier() { // from class: reactor.core.scheduler.g
            @Override // java.util.function.Supplier
            public final Object get() {
                return ParallelScheduler.a(this.f39833a);
            }
        });
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
        SchedulerState schedulerStateInit = SchedulerState.init(new ScheduledExecutorService[this.f39829n]);
        for (int i10 = 0; i10 < this.f39829n; i10++) {
            ((ScheduledExecutorService[]) schedulerStateInit.currentResource)[i10] = Schedulers.decorateExecutorService(this, get());
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
        return Stream.of((Object[]) this.state.currentResource).map(new Function() { // from class: reactor.core.scheduler.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ParallelScheduler.c((ScheduledExecutorService) obj);
            }
        });
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
        int i10 = this.roundRobin;
        if (i10 == this.f39829n) {
            this.roundRobin = 1;
            i10 = 0;
        } else {
            this.roundRobin = i10 + 1;
        }
        return scheduledExecutorServiceArr[i10];
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.TERMINATED || attr == Scannable.Attr.CANCELLED) {
            return Boolean.valueOf(isDisposed());
        }
        if (attr == Scannable.Attr.CAPACITY || attr == Scannable.Attr.BUFFERED) {
            return Integer.valueOf(this.f39829n);
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
    public Disposable schedulePeriodically(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return Schedulers.directSchedulePeriodically(pick(), runnable, j10, j11, timeUnit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // reactor.core.scheduler.Scheduler
    public void start() {
        SchedulerState<ScheduledExecutorService[]> schedulerState = this.state;
        if (schedulerState == null || schedulerState.currentResource == SHUTDOWN) {
            SchedulerState schedulerStateInit = SchedulerState.init(new ScheduledExecutorService[this.f39829n]);
            for (int i10 = 0; i10 < this.f39829n; i10++) {
                ((ScheduledExecutorService[]) schedulerStateInit.currentResource)[i10] = Schedulers.decorateExecutorService(this, get());
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
        StringBuilder sb2 = new StringBuilder("parallel");
        sb2.append('(');
        sb2.append(this.f39829n);
        if (this.factory instanceof ReactorThreadFactory) {
            sb2.append(",\"");
            sb2.append(((ReactorThreadFactory) this.factory).get());
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        sb2.append(')');
        return sb2.toString();
    }

    @Override // reactor.core.scheduler.SchedulerState.DisposeAwaiter
    public boolean await(ScheduledExecutorService[] scheduledExecutorServiceArr, long j10, TimeUnit timeUnit) throws InterruptedException {
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            if (!scheduledExecutorService.awaitTermination(j10, timeUnit)) {
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
    public Disposable schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        return Schedulers.directSchedule(pick(), runnable, null, j10, timeUnit);
    }
}

package reactor.core.scheduler;

import java.lang.invoke.VarHandle;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Supplier;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.SchedulerState;
import reactor.util.annotation.NonNull;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class DelegateServiceScheduler implements Scheduler, SchedulerState.DisposeAwaiter<ScheduledExecutorService>, Scannable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final AtomicReferenceFieldUpdater<DelegateServiceScheduler, SchedulerState> STATE;
    static final ScheduledExecutorService TERMINATED;
    final String executorName;
    final ScheduledExecutorService original;

    @Nullable
    volatile SchedulerState<ScheduledExecutorService> state;

    static {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        TERMINATED = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.shutdownNow();
        STATE = AtomicReferenceFieldUpdater.newUpdater(DelegateServiceScheduler.class, SchedulerState.class, "state");
    }

    public DelegateServiceScheduler(String str, ExecutorService executorService) {
        this.executorName = str;
        this.original = convert(executorService);
    }

    public static ScheduledExecutorService convert(ExecutorService executorService) {
        return executorService instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorService : new UnsupportedScheduledExecutorService(executorService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$disposeGracefully$0() {
        SchedulerState<ScheduledExecutorService> schedulerState = this.state;
        if (schedulerState != null && schedulerState.currentResource == TERMINATED) {
            return schedulerState.onDispose;
        }
        SchedulerState schedulerStateTransition = SchedulerState.transition(schedulerState == null ? null : schedulerState.currentResource, TERMINATED, this);
        STATE.compareAndSet(this, schedulerState, schedulerStateTransition);
        T t10 = schedulerStateTransition.initialResource;
        if (t10 != 0) {
            ((ScheduledExecutorService) t10).shutdown();
        }
        return schedulerStateTransition.onDispose;
    }

    @Override // reactor.core.scheduler.Scheduler
    public Scheduler.Worker createWorker() {
        return new ExecutorServiceWorker(getOrCreate());
    }

    @Override // reactor.core.scheduler.Scheduler, reactor.core.Disposable
    public void dispose() {
        SchedulerState<ScheduledExecutorService> schedulerState = this.state;
        if (schedulerState != null && schedulerState.currentResource == TERMINATED) {
            schedulerState.initialResource.shutdownNow();
            return;
        }
        SchedulerState schedulerStateTransition = SchedulerState.transition(schedulerState == null ? null : schedulerState.currentResource, TERMINATED, this);
        STATE.compareAndSet(this, schedulerState, schedulerStateTransition);
        T t10 = schedulerStateTransition.initialResource;
        if (t10 != 0) {
            ((ScheduledExecutorService) t10).shutdownNow();
        }
    }

    @Override // reactor.core.scheduler.Scheduler
    public Mono<Void> disposeGracefully() {
        b bVar = new b(1);
        bVar.f10892f = this;
        VarHandle.storeStoreFence();
        return Mono.defer(bVar);
    }

    public ScheduledExecutorService getOrCreate() {
        SchedulerState<ScheduledExecutorService> schedulerState = this.state;
        if (schedulerState == null) {
            init();
            schedulerState = this.state;
            if (schedulerState == null) {
                od.f.e("executor is null after implicit start()");
                return null;
            }
        }
        return schedulerState.currentResource;
    }

    @Override // reactor.core.scheduler.Scheduler
    public void init() {
        SchedulerState<ScheduledExecutorService> schedulerState = this.state;
        if (schedulerState != null) {
            if (schedulerState.currentResource != TERMINATED) {
                return;
            }
            od.f.e("Initializing a disposed scheduler is not permitted");
        } else {
            if (STATE.compareAndSet(this, null, SchedulerState.init(Schedulers.decorateExecutorService(this, this.original))) || !isDisposed()) {
                return;
            }
            od.f.e("Initializing a disposed scheduler is not permitted");
        }
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        SchedulerState<ScheduledExecutorService> schedulerState = this.state;
        return schedulerState != null && schedulerState.currentResource == TERMINATED;
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.TERMINATED || attr == Scannable.Attr.CANCELLED) {
            return Boolean.valueOf(isDisposed());
        }
        if (attr == Scannable.Attr.NAME) {
            return toString();
        }
        SchedulerState<ScheduledExecutorService> schedulerState = this.state;
        if (schedulerState != null) {
            return Schedulers.scanExecutor(schedulerState.currentResource, attr);
        }
        return null;
    }

    @Override // reactor.core.scheduler.Scheduler
    public Disposable schedule(Runnable runnable) {
        return Schedulers.directSchedule(getOrCreate(), runnable, null, 0L, TimeUnit.MILLISECONDS);
    }

    @Override // reactor.core.scheduler.Scheduler
    public Disposable schedulePeriodically(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return Schedulers.directSchedulePeriodically(getOrCreate(), runnable, j10, j11, timeUnit);
    }

    @Override // reactor.core.scheduler.Scheduler
    public void start() {
        STATE.compareAndSet(this, null, SchedulerState.init(Schedulers.decorateExecutorService(this, this.original)));
    }

    public String toString() {
        return k0.a.s(new StringBuilder("fromExecutorService("), this.executorName, ')');
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class UnsupportedScheduledExecutorService implements ScheduledExecutorService, Supplier<ExecutorService>, AutoCloseable {
        final ExecutorService exec;

        public UnsupportedScheduledExecutorService(ExecutorService executorService) {
            this.exec = executorService;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j10, @NonNull TimeUnit timeUnit) {
            return this.exec.awaitTermination(j10, timeUnit);
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

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.exec.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        @NonNull
        public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) {
            return this.exec.invokeAll(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        @NonNull
        public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) {
            return (T) this.exec.invokeAny(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.exec.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.exec.isTerminated();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        @NonNull
        public ScheduledFuture<?> schedule(@NonNull Runnable runnable, long j10, @NonNull TimeUnit timeUnit) {
            throw Exceptions.failWithRejectedNotTimeCapable();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        @NonNull
        public ScheduledFuture<?> scheduleAtFixedRate(@NonNull Runnable runnable, long j10, long j11, @NonNull TimeUnit timeUnit) {
            throw Exceptions.failWithRejectedNotTimeCapable();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        @NonNull
        public ScheduledFuture<?> scheduleWithFixedDelay(@NonNull Runnable runnable, long j10, long j11, @NonNull TimeUnit timeUnit) {
            throw Exceptions.failWithRejectedNotTimeCapable();
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.exec.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        @NonNull
        public List<Runnable> shutdownNow() {
            return this.exec.shutdownNow();
        }

        @Override // java.util.concurrent.ExecutorService
        @NonNull
        public <T> Future<T> submit(@NonNull Callable<T> callable) {
            return this.exec.submit(callable);
        }

        public String toString() {
            return this.exec.toString();
        }

        @Override // java.util.function.Supplier
        public ExecutorService get() {
            return this.exec;
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        @NonNull
        public <V> ScheduledFuture<V> schedule(@NonNull Callable<V> callable, long j10, @NonNull TimeUnit timeUnit) {
            throw Exceptions.failWithRejectedNotTimeCapable();
        }

        @Override // java.util.concurrent.ExecutorService
        @NonNull
        public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j10, @NonNull TimeUnit timeUnit) {
            return this.exec.invokeAll(collection, j10, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j10, @NonNull TimeUnit timeUnit) {
            return (T) this.exec.invokeAny(collection, j10, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        @NonNull
        public <T> Future<T> submit(@NonNull Runnable runnable, T t10) {
            return this.exec.submit(runnable, t10);
        }

        @Override // java.util.concurrent.ExecutorService
        @NonNull
        public Future<?> submit(@NonNull Runnable runnable) {
            return this.exec.submit(runnable);
        }
    }

    @Override // reactor.core.scheduler.SchedulerState.DisposeAwaiter
    public boolean await(ScheduledExecutorService scheduledExecutorService, long j10, TimeUnit timeUnit) {
        return scheduledExecutorService.awaitTermination(j10, timeUnit);
    }

    @Override // reactor.core.scheduler.Scheduler
    public Disposable schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        return Schedulers.directSchedule(getOrCreate(), runnable, null, j10, timeUnit);
    }
}

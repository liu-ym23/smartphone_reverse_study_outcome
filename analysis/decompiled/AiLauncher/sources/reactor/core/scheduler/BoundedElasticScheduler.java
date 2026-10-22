package reactor.core.scheduler;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.BoundedElasticScheduler;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.SchedulerState;
import reactor.util.Logger;
import reactor.util.Loggers;
import reactor.util.annotation.Nullable;
import s.C5424F;

/* loaded from: classes5.dex */
final class BoundedElasticScheduler implements Scheduler, SchedulerState.DisposeAwaiter<BoundedServices>, Scannable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int DEFAULT_TTL_SECONDS = 60;
    final Clock clock;
    final ThreadFactory factory;
    final int maxTaskQueuedPerThread;
    final int maxThreads;
    volatile SchedulerState<BoundedServices> state;
    final long ttlMillis;
    static final Logger LOGGER = Loggers.getLogger((Class<?>) BoundedElasticScheduler.class);
    static final AtomicLong COUNTER = new AtomicLong();
    static final AtomicReferenceFieldUpdater<BoundedElasticScheduler, SchedulerState> STATE = AtomicReferenceFieldUpdater.newUpdater(BoundedElasticScheduler.class, SchedulerState.class, VoiceWakeupReceiver.EXTRA_STATE);
    private static final SchedulerState<BoundedServices> INIT = SchedulerState.init(BoundedServices.SHUTDOWN);

    public static class BoundedState implements Disposable, Scannable {
        static final int EVICTED = -1;
        static final AtomicIntegerFieldUpdater<BoundedState> MARK_COUNT = AtomicIntegerFieldUpdater.newUpdater(BoundedState.class, "markCount");
        final ScheduledExecutorService executor;
        long idleSinceTimestamp = -1;
        volatile int markCount;
        final BoundedServices parent;

        public BoundedState(BoundedServices boundedServices, ScheduledExecutorService scheduledExecutorService) {
            this.parent = boundedServices;
            this.executor = scheduledExecutorService;
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            release();
        }

        public int estimateQueueSize() {
            ScheduledExecutorService scheduledExecutorService = this.executor;
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                return ((ScheduledThreadPoolExecutor) scheduledExecutorService).getQueue().size();
            }
            return -1;
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return MARK_COUNT.get(this) <= 0;
        }

        public boolean markPicked() {
            AtomicIntegerFieldUpdater<BoundedState> atomicIntegerFieldUpdater;
            int i10;
            do {
                atomicIntegerFieldUpdater = MARK_COUNT;
                i10 = atomicIntegerFieldUpdater.get(this);
                if (i10 == -1) {
                    return false;
                }
            } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 + 1));
            return true;
        }

        public void release() {
            int iDecrementAndGet = MARK_COUNT.decrementAndGet(this);
            if (iDecrementAndGet < 0) {
                return;
            }
            if (iDecrementAndGet != 0) {
                this.idleSinceTimestamp = -1L;
            } else {
                this.idleSinceTimestamp = this.parent.clock.millis();
                this.parent.setIdle(this);
            }
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return Schedulers.scanExecutor(this.executor, attr);
        }

        public void shutdown(boolean z10) {
            this.idleSinceTimestamp = -1L;
            MARK_COUNT.set(this, -1);
            if (z10) {
                this.executor.shutdownNow();
            } else {
                this.executor.shutdown();
            }
        }

        public String toString() {
            return "BoundedState@" + System.identityHashCode(this) + "{ backing=" + MARK_COUNT.get(this) + ", idleSince=" + this.idleSinceTimestamp + ", executor=" + this.executor + '}';
        }

        public boolean tryEvict(long j10, long j11) {
            long j12 = this.idleSinceTimestamp;
            if (j12 < 0 || j10 - j12 < j11 || !MARK_COUNT.compareAndSet(this, 0, -1)) {
                return false;
            }
            this.executor.shutdownNow();
            return true;
        }
    }

    public BoundedElasticScheduler(int i10, int i11, ThreadFactory threadFactory, long j10, Clock clock) {
        if (j10 <= 0) {
            throw new IllegalArgumentException("TTL must be strictly positive, was " + j10 + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
        }
        if (i10 <= 0) {
            throw new IllegalArgumentException("maxThreads must be strictly positive, was " + i10);
        }
        if (i11 <= 0) {
            throw new IllegalArgumentException("maxTaskQueuedPerThread must be strictly positive, was " + i11);
        }
        this.maxThreads = i10;
        this.maxTaskQueuedPerThread = i11;
        this.factory = threadFactory;
        Objects.requireNonNull(clock, "A Clock must be provided");
        this.clock = clock;
        this.ttlMillis = j10;
        STATE.lazySet(this, INIT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Mono a(BoundedElasticScheduler boundedElasticScheduler) {
        SchedulerState<BoundedServices> schedulerState = boundedElasticScheduler.state;
        BoundedServices boundedServices = schedulerState.currentResource;
        BoundedServices boundedServices2 = BoundedServices.SHUTDOWN;
        if (boundedServices == boundedServices2) {
            return schedulerState.onDispose;
        }
        BoundedState[] boundedStateArrDispose = boundedServices.dispose();
        SchedulerState schedulerStateTransition = SchedulerState.transition(schedulerState.currentResource, boundedServices2, boundedElasticScheduler);
        STATE.compareAndSet(boundedElasticScheduler, schedulerState, schedulerStateTransition);
        ((BoundedServices) schedulerStateTransition.initialResource).evictor.shutdown();
        for (BoundedState boundedState : boundedStateArrDispose) {
            boundedState.shutdown(false);
        }
        return schedulerStateTransition.onDispose;
    }

    public static /* synthetic */ boolean b(BoundedState boundedState) {
        return (boundedState == null || boundedState == BoundedServices.CREATING) ? false : true;
    }

    public BoundedScheduledExecutorService createBoundedExecutorService() {
        return new BoundedScheduledExecutorService(this.maxTaskQueuedPerThread, this.factory);
    }

    @Override // reactor.core.scheduler.Scheduler
    public Scheduler.Worker createWorker() {
        BoundedState boundedStatePick = this.state.currentResource.pick();
        ExecutorServiceWorker executorServiceWorker = new ExecutorServiceWorker(boundedStatePick.executor);
        executorServiceWorker.disposables.add(boundedStatePick);
        return executorServiceWorker;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // reactor.core.scheduler.Scheduler, reactor.core.Disposable
    public void dispose() {
        SchedulerState<BoundedServices> schedulerState = this.state;
        BoundedServices boundedServices = schedulerState.currentResource;
        BoundedServices boundedServices2 = BoundedServices.SHUTDOWN;
        int i10 = 0;
        if (boundedServices != boundedServices2) {
            BoundedState[] boundedStateArrDispose = boundedServices.dispose();
            SchedulerState schedulerStateTransition = SchedulerState.transition(schedulerState.currentResource, boundedServices2, this);
            STATE.compareAndSet(this, schedulerState, schedulerStateTransition);
            ((BoundedServices) schedulerStateTransition.initialResource).evictor.shutdownNow();
            int length = boundedStateArrDispose.length;
            while (i10 < length) {
                boundedStateArrDispose[i10].shutdown(true);
                i10++;
            }
            return;
        }
        BoundedServices boundedServices3 = schedulerState.initialResource;
        if (boundedServices3 != null) {
            boundedServices3.evictor.shutdownNow();
            BoundedState[] boundedStateArr = schedulerState.initialResource.busyStates.array;
            int length2 = boundedStateArr.length;
            while (i10 < length2) {
                boundedStateArr[i10].shutdown(true);
                i10++;
            }
        }
    }

    @Override // reactor.core.scheduler.Scheduler
    public Mono<Void> disposeGracefully() {
        return Mono.defer(new Supplier() { // from class: reactor.core.scheduler.b
            @Override // java.util.function.Supplier
            public final Object get() {
                return BoundedElasticScheduler.a(this.f39830a);
            }
        });
    }

    public int estimateBusy() {
        return this.state.currentResource.busyStates.array.length;
    }

    public int estimateIdle() {
        return this.state.currentResource.idleQueue.size();
    }

    public int estimateRemainingTaskCapacity() {
        BoundedState[] boundedStateArr = this.state.currentResource.busyStates.array;
        int i10 = this.maxTaskQueuedPerThread * this.maxThreads;
        for (BoundedState boundedState : boundedStateArr) {
            int iEstimateQueueSize = boundedState.estimateQueueSize();
            if (iEstimateQueueSize < 0) {
                return -1;
            }
            i10 -= iEstimateQueueSize;
        }
        return i10;
    }

    public int estimateSize() {
        return this.state.currentResource.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // reactor.core.scheduler.Scheduler
    public void init() {
        SchedulerState<BoundedServices> schedulerState = this.state;
        SchedulerState<BoundedServices> schedulerState2 = INIT;
        if (schedulerState != schedulerState2) {
            if (schedulerState.currentResource == BoundedServices.SHUTDOWN) {
                throw new IllegalStateException("Initializing a disposed scheduler is not permitted");
            }
            return;
        }
        SchedulerState schedulerStateInit = SchedulerState.init(new BoundedServices(this));
        if (!STATE.compareAndSet(this, schedulerState2, schedulerStateInit)) {
            ((BoundedServices) schedulerStateInit.currentResource).evictor.shutdownNow();
            if (isDisposed()) {
                throw new IllegalStateException("Initializing a disposed scheduler is not permitted");
            }
            return;
        }
        try {
            T t10 = schedulerStateInit.currentResource;
            ScheduledExecutorService scheduledExecutorService = ((BoundedServices) t10).evictor;
            BoundedServices boundedServices = (BoundedServices) t10;
            boundedServices.getClass();
            RunnableC5412c runnableC5412c = new RunnableC5412c(boundedServices);
            long j10 = this.ttlMillis;
            scheduledExecutorService.scheduleAtFixedRate(runnableC5412c, j10, j10, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException unused) {
            throw new IllegalStateException("Scheduler disposed during initialization");
        }
    }

    @Override // reactor.core.Scannable
    public Stream<? extends Scannable> inners() {
        BoundedServices boundedServices = this.state.currentResource;
        return Stream.concat(Stream.of((Object[]) boundedServices.busyStates.array), boundedServices.idleQueue.stream()).filter(new Predicate() { // from class: reactor.core.scheduler.a
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return BoundedElasticScheduler.b((BoundedElasticScheduler.BoundedState) obj);
            }
        });
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        SchedulerState<BoundedServices> schedulerState = this.state;
        return schedulerState != INIT && schedulerState.currentResource == BoundedServices.SHUTDOWN;
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.TERMINATED || attr == Scannable.Attr.CANCELLED) {
            return Boolean.valueOf(isDisposed());
        }
        if (attr == Scannable.Attr.BUFFERED) {
            return Integer.valueOf(estimateSize());
        }
        if (attr == Scannable.Attr.CAPACITY) {
            return Integer.valueOf(this.maxThreads);
        }
        if (attr == Scannable.Attr.NAME) {
            return toString();
        }
        return null;
    }

    @Override // reactor.core.scheduler.Scheduler
    public Disposable schedule(Runnable runnable) {
        BoundedState boundedStatePick = this.state.currentResource.pick();
        try {
            return Schedulers.directSchedule(boundedStatePick.executor, runnable, boundedStatePick, 0L, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e10) {
            boundedStatePick.dispose();
            throw e10;
        }
    }

    @Override // reactor.core.scheduler.Scheduler
    public Disposable schedulePeriodically(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        BoundedState boundedStatePick = this.state.currentResource.pick();
        try {
            return Disposables.composite(Schedulers.directSchedulePeriodically(boundedStatePick.executor, runnable, j10, j11, timeUnit), boundedStatePick);
        } catch (RejectedExecutionException e10) {
            boundedStatePick.dispose();
            throw e10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // reactor.core.scheduler.Scheduler
    public void start() {
        SchedulerState<BoundedServices> schedulerState = this.state;
        if (schedulerState.currentResource != BoundedServices.SHUTDOWN) {
            return;
        }
        SchedulerState schedulerStateInit = SchedulerState.init(new BoundedServices(this));
        if (STATE.compareAndSet(this, schedulerState, schedulerStateInit)) {
            try {
                T t10 = schedulerStateInit.currentResource;
                ScheduledExecutorService scheduledExecutorService = ((BoundedServices) t10).evictor;
                BoundedServices boundedServices = (BoundedServices) t10;
                boundedServices.getClass();
                RunnableC5412c runnableC5412c = new RunnableC5412c(boundedServices);
                long j10 = this.ttlMillis;
                scheduledExecutorService.scheduleAtFixedRate(runnableC5412c, j10, j10, TimeUnit.MILLISECONDS);
                return;
            } catch (RejectedExecutionException unused) {
            }
        }
        ((BoundedServices) schedulerStateInit.currentResource).evictor.shutdownNow();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("boundedElastic");
        sb2.append('(');
        if (this.factory instanceof ReactorThreadFactory) {
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            sb2.append(((ReactorThreadFactory) this.factory).get());
            sb2.append("\",");
        }
        sb2.append("maxThreads=");
        sb2.append(this.maxThreads);
        sb2.append(",maxTaskQueuedPerThread=");
        int i10 = this.maxTaskQueuedPerThread;
        sb2.append(i10 == Integer.MAX_VALUE ? "unbounded" : Integer.valueOf(i10));
        sb2.append(",ttl=");
        long j10 = this.ttlMillis;
        if (j10 < 1000) {
            sb2.append(j10);
            sb2.append("ms)");
        } else {
            sb2.append(j10 / 1000);
            sb2.append("s)");
        }
        return sb2.toString();
    }

    public static final class BoundedScheduledExecutorService extends ScheduledThreadPoolExecutor implements Scannable, AutoCloseable {
        final int queueCapacity;

        public BoundedScheduledExecutorService(int i10, ThreadFactory threadFactory) {
            super(1, threadFactory);
            setMaximumPoolSize(1);
            setRemoveOnCancelPolicy(true);
            if (i10 < 1) {
                throw new IllegalArgumentException("was expecting a non-zero positive queue capacity");
            }
            this.queueCapacity = i10;
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
            return super.awaitTermination(j10, timeUnit);
        }

        @Override // java.lang.AutoCloseable
        public /* synthetic */ void close() throws InterruptedException {
            C5424F.a(this);
        }

        public void ensureQueueCapacity(int i10) {
            int size;
            if (this.queueCapacity != Integer.MAX_VALUE && (size = super.getQueue().size() + i10) > this.queueCapacity) {
                throw Exceptions.failWithRejected("Task capacity of bounded elastic scheduler reached while scheduling " + i10 + " tasks (" + size + "/" + this.queueCapacity + ")");
            }
        }

        @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            ensureQueueCapacity(1);
            super.submit(runnable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public synchronized <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
            ensureQueueCapacity(collection.size());
            return super.invokeAll(collection);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public synchronized <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
            ensureQueueCapacity(collection.size());
            return (T) super.invokeAny(collection);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return super.isShutdown();
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return super.isTerminated();
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (Scannable.Attr.TERMINATED == attr) {
                return Boolean.valueOf(isTerminated());
            }
            if (Scannable.Attr.BUFFERED == attr) {
                return Integer.valueOf(getQueue().size());
            }
            if (Scannable.Attr.CAPACITY == attr) {
                return Integer.valueOf(this.queueCapacity);
            }
            return null;
        }

        @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
        public synchronized ScheduledFuture<?> schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            ensureQueueCapacity(1);
            return super.schedule(runnable, j10, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
        public synchronized ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            ensureQueueCapacity(1);
            return super.scheduleAtFixedRate(runnable, j10, j11, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            ensureQueueCapacity(1);
            return super.scheduleWithFixedDelay(runnable, j10, j11, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
        public void shutdown() {
            super.shutdown();
        }

        @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            return super.shutdownNow();
        }

        @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public synchronized <T> Future<T> submit(Callable<T> callable) {
            ensureQueueCapacity(1);
            return super.submit(callable);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public String toString() {
            int size = getQueue().size();
            long completedTaskCount = getCompletedTaskCount();
            String str = getActiveCount() > 0 ? "ACTIVE" : "IDLE";
            if (this.queueCapacity == Integer.MAX_VALUE) {
                return "BoundedScheduledExecutorService{" + str + ", queued=" + size + "/unbounded, completed=" + completedTaskCount + '}';
            }
            return "BoundedScheduledExecutorService{" + str + ", queued=" + size + "/" + this.queueCapacity + ", completed=" + completedTaskCount + '}';
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public synchronized <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException {
            ensureQueueCapacity(collection.size());
            return super.invokeAll(collection, j10, timeUnit);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public synchronized <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            ensureQueueCapacity(collection.size());
            return (T) super.invokeAny(collection, j10, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
        public synchronized <V> ScheduledFuture<V> schedule(Callable<V> callable, long j10, TimeUnit timeUnit) {
            ensureQueueCapacity(1);
            return super.schedule(callable, j10, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public synchronized <T> Future<T> submit(Runnable runnable, T t10) {
            ensureQueueCapacity(1);
            return super.submit(runnable, t10);
        }

        @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public synchronized Future<?> submit(Runnable runnable) {
            ensureQueueCapacity(1);
            return super.submit(runnable);
        }
    }

    @Override // reactor.core.scheduler.SchedulerState.DisposeAwaiter
    public boolean await(BoundedServices boundedServices, long j10, TimeUnit timeUnit) throws InterruptedException {
        if (!boundedServices.evictor.awaitTermination(j10, timeUnit)) {
            return false;
        }
        for (BoundedState boundedState : boundedServices.busyStates.array) {
            if (!boundedState.executor.awaitTermination(j10, timeUnit)) {
                return false;
            }
        }
        return true;
    }

    @Override // reactor.core.scheduler.Scheduler
    public Disposable schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        BoundedState boundedStatePick = this.state.currentResource.pick();
        try {
            return Schedulers.directSchedule(boundedStatePick.executor, runnable, boundedStatePick, j10, timeUnit);
        } catch (RejectedExecutionException e10) {
            boundedStatePick.dispose();
            throw e10;
        }
    }

    public static final class BoundedServices extends AtomicInteger {
        static final AtomicReferenceFieldUpdater<BoundedServices, BusyStates> BUSY_STATES;
        static final BoundedState CREATING;
        static final AtomicLong EVICTOR_COUNTER;
        static final ThreadFactory EVICTOR_FACTORY;
        static final ScheduledExecutorService EVICTOR_SHUTDOWN;
        static final BoundedServices SHUTDOWN;
        static final BoundedServices SHUTTING_DOWN;
        volatile BusyStates busyStates;
        final Clock clock;
        final ScheduledExecutorService evictor;
        final Deque<BoundedState> idleQueue;
        final BoundedElasticScheduler parent;
        static final ZoneId ZONE_UTC = ZoneId.of("UTC");
        static final BusyStates ALL_IDLE = new BusyStates(new BoundedState[0], false);
        static final BusyStates ALL_SHUTDOWN = new BusyStates(new BoundedState[0], true);

        public static final class BusyStates {
            final BoundedState[] array;
            final boolean shutdown;

            public BusyStates(BoundedState[] boundedStateArr, boolean z10) {
                this.array = boundedStateArr;
                this.shutdown = z10;
            }
        }

        static {
            ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            EVICTOR_SHUTDOWN = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
            scheduledExecutorServiceNewSingleThreadScheduledExecutor.shutdownNow();
            BoundedServices boundedServices = new BoundedServices();
            SHUTDOWN = boundedServices;
            BoundedServices boundedServices2 = new BoundedServices();
            SHUTTING_DOWN = boundedServices2;
            boundedServices.dispose();
            boundedServices2.dispose();
            ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor2 = Executors.newSingleThreadScheduledExecutor();
            scheduledExecutorServiceNewSingleThreadScheduledExecutor2.shutdownNow();
            BoundedState boundedState = new BoundedState(boundedServices, scheduledExecutorServiceNewSingleThreadScheduledExecutor2) { // from class: reactor.core.scheduler.BoundedElasticScheduler.BoundedServices.1
                @Override // reactor.core.scheduler.BoundedElasticScheduler.BoundedState
                public String toString() {
                    return "CREATING BoundedState";
                }
            };
            CREATING = boundedState;
            boundedState.markCount = -1;
            boundedState.idleSinceTimestamp = -1L;
            EVICTOR_COUNTER = new AtomicLong();
            EVICTOR_FACTORY = new ThreadFactory() { // from class: reactor.core.scheduler.d
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return BoundedElasticScheduler.BoundedServices.a(runnable);
                }
            };
            BUSY_STATES = AtomicReferenceFieldUpdater.newUpdater(BoundedServices.class, BusyStates.class, "busyStates");
        }

        private BoundedServices() {
            this.parent = null;
            this.clock = Clock.fixed(Instant.EPOCH, ZONE_UTC);
            this.idleQueue = new ConcurrentLinkedDeque();
            this.busyStates = ALL_SHUTDOWN;
            this.evictor = EVICTOR_SHUTDOWN;
        }

        public static /* synthetic */ Thread a(Runnable runnable) {
            Thread thread = new Thread(runnable, "boundedElastic-evictor-" + EVICTOR_COUNTER.incrementAndGet());
            thread.setDaemon(true);
            return thread;
        }

        @Nullable
        private BoundedState choseOneBusy() {
            BoundedState[] boundedStateArr = this.busyStates.array;
            int length = boundedStateArr.length;
            if (length == 0) {
                return null;
            }
            if (length == 1) {
                return boundedStateArr[0];
            }
            BoundedState boundedState = boundedStateArr[0];
            int i10 = Integer.MAX_VALUE;
            for (BoundedState boundedState2 : boundedStateArr) {
                int i11 = boundedState2.markCount;
                if (i11 < i10) {
                    boundedState = boundedState2;
                    i10 = i11;
                }
            }
            return boundedState;
        }

        public BoundedState[] dispose() {
            BusyStates busyStates;
            do {
                busyStates = this.busyStates;
                if (busyStates.shutdown) {
                    return busyStates.array;
                }
            } while (!BUSY_STATES.compareAndSet(this, busyStates, new BusyStates(busyStates.array, true)));
            BoundedState[] boundedStateArr = busyStates.array;
            ArrayList arrayList = new ArrayList(this.idleQueue.size() + boundedStateArr.length);
            while (true) {
                BoundedState boundedStatePollLast = this.idleQueue.pollLast();
                if (boundedStatePollLast == null) {
                    Collections.addAll(arrayList, boundedStateArr);
                    return (BoundedState[]) arrayList.toArray(new BoundedState[0]);
                }
                arrayList.add(boundedStatePollLast);
            }
        }

        public void eviction() {
            long jMillis = this.parent.clock.millis();
            for (BoundedState boundedState : new ArrayList(this.idleQueue)) {
                if (boundedState.tryEvict(jMillis, this.parent.ttlMillis)) {
                    this.idleQueue.remove(boundedState);
                    decrementAndGet();
                }
            }
        }

        public BoundedState pick() {
            while (this.busyStates != ALL_SHUTDOWN) {
                int i10 = get();
                if (!this.idleQueue.isEmpty()) {
                    BoundedState boundedStatePollLast = this.idleQueue.pollLast();
                    if (boundedStatePollLast != null && boundedStatePollLast.markPicked()) {
                        if (setBusy(boundedStatePollLast)) {
                            return boundedStatePollLast;
                        }
                        boundedStatePollLast.shutdown(true);
                        return CREATING;
                    }
                } else if (i10 >= this.parent.maxThreads) {
                    BoundedState boundedStateChoseOneBusy = choseOneBusy();
                    if (boundedStateChoseOneBusy != null && boundedStateChoseOneBusy.markPicked()) {
                        return boundedStateChoseOneBusy;
                    }
                } else if (compareAndSet(i10, i10 + 1)) {
                    BoundedElasticScheduler boundedElasticScheduler = this.parent;
                    BoundedState boundedState = new BoundedState(this, Schedulers.decorateExecutorService(boundedElasticScheduler, boundedElasticScheduler.createBoundedExecutorService()));
                    if (boundedState.markPicked()) {
                        if (setBusy(boundedState)) {
                            return boundedState;
                        }
                        boundedState.shutdown(true);
                        return CREATING;
                    }
                } else {
                    continue;
                }
            }
            return CREATING;
        }

        public boolean setBusy(BoundedState boundedState) {
            BusyStates busyStates;
            BoundedState[] boundedStateArr;
            do {
                busyStates = this.busyStates;
                if (busyStates.shutdown) {
                    return false;
                }
                BoundedState[] boundedStateArr2 = busyStates.array;
                int length = boundedStateArr2.length;
                boundedStateArr = new BoundedState[length + 1];
                System.arraycopy(boundedStateArr2, 0, boundedStateArr, 0, length);
                boundedStateArr[length] = boundedState;
            } while (!BUSY_STATES.compareAndSet(this, busyStates, new BusyStates(boundedStateArr, false)));
            return true;
        }

        public void setIdle(BoundedState boundedState) {
            BusyStates busyStates;
            BusyStates busyStates2;
            do {
                busyStates = this.busyStates;
                BoundedState[] boundedStateArr = this.busyStates.array;
                int length = boundedStateArr.length;
                if (length == 0 || busyStates.shutdown) {
                    return;
                }
                if (length == 1) {
                    busyStates2 = boundedStateArr[0] == boundedState ? ALL_IDLE : null;
                } else {
                    for (int i10 = 0; i10 < length; i10++) {
                        if (boundedStateArr[i10] == boundedState) {
                            BusyStates busyStates3 = new BusyStates(new BoundedState[length - 1], false);
                            System.arraycopy(boundedStateArr, 0, busyStates3.array, 0, i10);
                            System.arraycopy(boundedStateArr, i10 + 1, busyStates3.array, i10, (length - i10) - 1);
                            busyStates2 = busyStates3;
                            break;
                        }
                    }
                }
                if (busyStates2 == null) {
                    return;
                }
            } while (!BUSY_STATES.compareAndSet(this, busyStates, busyStates2));
            this.idleQueue.add(boundedState);
            if (!this.busyStates.shutdown) {
                return;
            }
            boundedState.shutdown(true);
            while (true) {
                BoundedState boundedStatePollLast = this.idleQueue.pollLast();
                if (boundedStatePollLast == null) {
                    return;
                } else {
                    boundedStatePollLast.shutdown(true);
                }
            }
        }

        public BoundedServices(BoundedElasticScheduler boundedElasticScheduler) {
            this.parent = boundedElasticScheduler;
            this.clock = boundedElasticScheduler.clock;
            this.idleQueue = new ConcurrentLinkedDeque();
            this.busyStates = ALL_IDLE;
            this.evictor = Executors.newSingleThreadScheduledExecutor(EVICTOR_FACTORY);
        }
    }

    public BoundedElasticScheduler(int i10, int i11, ThreadFactory threadFactory, int i12) {
        this(i10, i11, threadFactory, i12 * 1000, Clock.tickSeconds(BoundedServices.ZONE_UTC));
    }
}

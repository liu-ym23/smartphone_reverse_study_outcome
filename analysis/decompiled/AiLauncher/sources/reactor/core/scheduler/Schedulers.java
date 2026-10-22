package reactor.core.scheduler;

import com.stepos.core.error.AIEngineError;
import java.lang.Thread;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.scheduler.DelegateServiceScheduler;
import reactor.core.scheduler.Scheduler;
import reactor.util.Logger;
import reactor.util.Loggers;
import reactor.util.Metrics;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
public abstract class Schedulers {
    static final String BOUNDED_ELASTIC = "boundedElastic";
    static final Supplier<Scheduler> BOUNDED_ELASTIC_SUPPLIER;
    static AtomicReference<CachedScheduler> CACHED_BOUNDED_ELASTIC = null;
    static AtomicReference<CachedScheduler> CACHED_PARALLEL = null;
    static AtomicReference<CachedScheduler> CACHED_SINGLE = null;
    static final Map<String, BiFunction<Scheduler, ScheduledExecutorService, ScheduledExecutorService>> DECORATORS;
    static final Factory DEFAULT;
    static final Predicate<Thread> DEFAULT_NON_BLOCKING_THREAD_PREDICATE;
    static final String FROM_EXECUTOR = "fromExecutor";
    static final String FROM_EXECUTOR_SERVICE = "fromExecutorService";
    static final String IMMEDIATE = "immediate";
    static final Logger LOGGER;
    static final String LOOM_BOUNDED_ELASTIC = "loomBoundedElastic";
    static final String PARALLEL = "parallel";
    static final Supplier<Scheduler> PARALLEL_SUPPLIER;
    static final String SINGLE = "single";
    static final Supplier<Scheduler> SINGLE_SUPPLIER;
    static volatile Factory factory;
    static Predicate<Thread> nonBlockingThreadPredicate;

    @Nullable
    static BiConsumer<Thread, ? super Throwable> onHandleErrorHook;
    private static final LinkedHashMap<String, BiConsumer<Thread, Throwable>> onHandleErrorHooks;

    @Nullable
    private static Function<Runnable, Runnable> onScheduleHook;
    private static final LinkedHashMap<String, Function<Runnable, Runnable>> onScheduleHooks;
    public static final int DEFAULT_POOL_SIZE = ((Integer) Optional.ofNullable(System.getProperty("reactor.schedulers.defaultPoolSize")).map(new Function() { // from class: reactor.core.scheduler.y
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return Integer.valueOf(Integer.parseInt((String) obj));
        }
    }).orElseGet(new Supplier() { // from class: reactor.core.scheduler.z
        @Override // java.util.function.Supplier
        public final Object get() {
            return Integer.valueOf(Runtime.getRuntime().availableProcessors());
        }
    })).intValue();
    public static final int DEFAULT_BOUNDED_ELASTIC_SIZE = ((Integer) Optional.ofNullable(System.getProperty("reactor.schedulers.defaultBoundedElasticSize")).map(new Function() { // from class: reactor.core.scheduler.y
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return Integer.valueOf(Integer.parseInt((String) obj));
        }
    }).orElseGet(new Supplier() { // from class: reactor.core.scheduler.A
        @Override // java.util.function.Supplier
        public final Object get() {
            return Integer.valueOf(Runtime.getRuntime().availableProcessors() * 10);
        }
    })).intValue();
    public static final int DEFAULT_BOUNDED_ELASTIC_QUEUESIZE = ((Integer) Optional.ofNullable(System.getProperty("reactor.schedulers.defaultBoundedElasticQueueSize")).map(new Function() { // from class: reactor.core.scheduler.y
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return Integer.valueOf(Integer.parseInt((String) obj));
        }
    }).orElse(Integer.valueOf(AIEngineError.UNKNOWN))).intValue();
    public static final boolean DEFAULT_BOUNDED_ELASTIC_ON_VIRTUAL_THREADS = ((Boolean) Optional.ofNullable(System.getProperty("reactor.schedulers.defaultBoundedElasticOnVirtualThreads")).map(new Function() { // from class: reactor.core.scheduler.B
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return Boolean.valueOf(Boolean.parseBoolean((String) obj));
        }
    }).orElse(Boolean.FALSE)).booleanValue();

    public static class CachedScheduler implements Scheduler, Supplier<Scheduler>, Scannable {
        final Scheduler cached;
        final String stringRepresentation;

        public CachedScheduler(String str, Scheduler scheduler) {
            this.cached = scheduler;
            this.stringRepresentation = "Schedulers." + str + "()";
        }

        public void _dispose() {
            this.cached.dispose();
        }

        @Override // reactor.core.scheduler.Scheduler
        public Scheduler.Worker createWorker() {
            return this.cached.createWorker();
        }

        @Override // reactor.core.scheduler.Scheduler, reactor.core.Disposable
        public void dispose() {
        }

        @Override // reactor.core.scheduler.Scheduler
        public void init() {
            this.cached.init();
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return this.cached.isDisposed();
        }

        @Override // reactor.core.scheduler.Scheduler
        public long now(TimeUnit timeUnit) {
            return this.cached.now(timeUnit);
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return Scannable.Attr.NAME == attr ? this.stringRepresentation : Scannable.from(this.cached).scanUnsafe(attr);
        }

        @Override // reactor.core.scheduler.Scheduler
        public Disposable schedule(Runnable runnable) {
            return this.cached.schedule(runnable);
        }

        @Override // reactor.core.scheduler.Scheduler
        public Disposable schedulePeriodically(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            return this.cached.schedulePeriodically(runnable, j10, j11, timeUnit);
        }

        @Override // reactor.core.scheduler.Scheduler
        public void start() {
            this.cached.start();
        }

        public String toString() {
            return this.stringRepresentation;
        }

        @Override // java.util.function.Supplier
        public Scheduler get() {
            return this.cached;
        }

        @Override // reactor.core.scheduler.Scheduler
        public Disposable schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.cached.schedule(runnable, j10, timeUnit);
        }
    }

    public interface Factory {
        default Scheduler newBoundedElastic(int i10, int i11, ThreadFactory threadFactory, int i12) {
            return new BoundedElasticScheduler(i10, i11, threadFactory, i12);
        }

        default Scheduler newParallel(int i10, ThreadFactory threadFactory) {
            return new ParallelScheduler(i10, threadFactory);
        }

        default Scheduler newSingle(ThreadFactory threadFactory) {
            return new SingleScheduler(threadFactory);
        }

        default Scheduler newThreadPerTaskBoundedElastic(int i10, int i11, ThreadFactory threadFactory) {
            return new BoundedElasticThreadPerTaskScheduler(i10, i11, threadFactory);
        }
    }

    public static final class Snapshot implements Disposable {

        @Nullable
        final CachedScheduler oldBoundedElasticScheduler;
        final Factory oldFactory;

        @Nullable
        final CachedScheduler oldParallelScheduler;

        @Nullable
        final CachedScheduler oldSingleScheduler;

        @Override // reactor.core.Disposable
        public void dispose() {
            CachedScheduler cachedScheduler = this.oldBoundedElasticScheduler;
            if (cachedScheduler != null) {
                cachedScheduler._dispose();
            }
            CachedScheduler cachedScheduler2 = this.oldParallelScheduler;
            if (cachedScheduler2 != null) {
                cachedScheduler2._dispose();
            }
            CachedScheduler cachedScheduler3 = this.oldSingleScheduler;
            if (cachedScheduler3 != null) {
                cachedScheduler3._dispose();
            }
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            CachedScheduler cachedScheduler = this.oldBoundedElasticScheduler;
            if (cachedScheduler != null && !cachedScheduler.isDisposed()) {
                return false;
            }
            CachedScheduler cachedScheduler2 = this.oldParallelScheduler;
            if (cachedScheduler2 != null && !cachedScheduler2.isDisposed()) {
                return false;
            }
            CachedScheduler cachedScheduler3 = this.oldSingleScheduler;
            return cachedScheduler3 == null || cachedScheduler3.isDisposed();
        }

        private Snapshot(@Nullable CachedScheduler cachedScheduler, @Nullable CachedScheduler cachedScheduler2, @Nullable CachedScheduler cachedScheduler3, Factory factory) {
            this.oldBoundedElasticScheduler = cachedScheduler;
            this.oldParallelScheduler = cachedScheduler2;
            this.oldSingleScheduler = cachedScheduler3;
            this.oldFactory = factory;
        }
    }

    static {
        Predicate<Thread> predicate = new Predicate() { // from class: reactor.core.scheduler.C
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Schedulers.d((Thread) obj);
            }
        };
        DEFAULT_NON_BLOCKING_THREAD_PREDICATE = predicate;
        nonBlockingThreadPredicate = predicate;
        CACHED_BOUNDED_ELASTIC = new AtomicReference<>();
        CACHED_PARALLEL = new AtomicReference<>();
        CACHED_SINGLE = new AtomicReference<>();
        BOUNDED_ELASTIC_SUPPLIER = new BoundedElasticSchedulerSupplier();
        PARALLEL_SUPPLIER = new Supplier() { // from class: reactor.core.scheduler.D
            @Override // java.util.function.Supplier
            public final Object get() {
                return Schedulers.newParallel(Schedulers.PARALLEL, Schedulers.DEFAULT_POOL_SIZE, true);
            }
        };
        SINGLE_SUPPLIER = new Supplier() { // from class: reactor.core.scheduler.E
            @Override // java.util.function.Supplier
            public final Object get() {
                return Schedulers.newSingle("single", true);
            }
        };
        Factory factory2 = new Factory() { // from class: reactor.core.scheduler.Schedulers.1
        };
        DEFAULT = factory2;
        DECORATORS = new LinkedHashMap();
        factory = factory2;
        onHandleErrorHooks = new LinkedHashMap<>(1);
        onScheduleHooks = new LinkedHashMap<>(1);
        LOGGER = Loggers.getLogger((Class<?>) Schedulers.class);
    }

    public static boolean addExecutorServiceDecorator(String str, BiFunction<Scheduler, ScheduledExecutorService, ScheduledExecutorService> biFunction) {
        boolean z10;
        Map<String, BiFunction<Scheduler, ScheduledExecutorService, ScheduledExecutorService>> map = DECORATORS;
        synchronized (map) {
            z10 = map.putIfAbsent(str, biFunction) == null;
        }
        return z10;
    }

    public static Scheduler boundedElastic() {
        return cache(CACHED_BOUNDED_ELASTIC, BOUNDED_ELASTIC, BOUNDED_ELASTIC_SUPPLIER);
    }

    public static CachedScheduler cache(AtomicReference<CachedScheduler> atomicReference, String str, Supplier<Scheduler> supplier) {
        CachedScheduler cachedScheduler = atomicReference.get();
        if (cachedScheduler != null) {
            return cachedScheduler;
        }
        CachedScheduler cachedScheduler2 = new CachedScheduler(str, supplier.get());
        if (atomicReference.compareAndSet(null, cachedScheduler2)) {
            return cachedScheduler2;
        }
        cachedScheduler2._dispose();
        return atomicReference.get();
    }

    @Nullable
    private static BiConsumer<Thread, ? super Throwable> createOrAppendHandleError(Collection<BiConsumer<Thread, Throwable>> collection) {
        BiConsumer<Thread, Throwable> biConsumerAndThen = null;
        for (BiConsumer<Thread, Throwable> biConsumer : collection) {
            biConsumerAndThen = biConsumerAndThen != null ? biConsumerAndThen.andThen(biConsumer) : biConsumer;
        }
        return biConsumerAndThen;
    }

    public static /* synthetic */ boolean d(Thread thread) {
        return false;
    }

    public static ScheduledExecutorService decorateExecutorService(Scheduler scheduler, ScheduledExecutorService scheduledExecutorService) {
        Map<String, BiFunction<Scheduler, ScheduledExecutorService, ScheduledExecutorService>> map = DECORATORS;
        synchronized (map) {
            try {
                Iterator<BiFunction<Scheduler, ScheduledExecutorService, ScheduledExecutorService>> it = map.values().iterator();
                while (it.hasNext()) {
                    scheduledExecutorService = it.next().apply(scheduler, scheduledExecutorService);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return scheduledExecutorService;
    }

    public static final void defaultUncaughtException(Thread thread, Throwable th) {
        LOGGER.error("Scheduler worker in group " + thread.getThreadGroup().getName() + " failed with an uncaught exception", th);
    }

    public static Disposable directSchedule(ScheduledExecutorService scheduledExecutorService, Runnable runnable, @Nullable Disposable disposable, long j10, TimeUnit timeUnit) {
        SchedulerTask schedulerTask = new SchedulerTask(onSchedule(runnable), disposable);
        schedulerTask.setFuture(j10 <= 0 ? scheduledExecutorService.submit((Callable) schedulerTask) : scheduledExecutorService.schedule((Callable) schedulerTask, j10, timeUnit));
        return schedulerTask;
    }

    public static Disposable directSchedulePeriodically(ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        Runnable runnableOnSchedule = onSchedule(runnable);
        if (j11 <= 0) {
            InstantPeriodicWorkerTask instantPeriodicWorkerTask = new InstantPeriodicWorkerTask(runnableOnSchedule, scheduledExecutorService);
            instantPeriodicWorkerTask.setFirst(j10 <= 0 ? scheduledExecutorService.submit(instantPeriodicWorkerTask) : scheduledExecutorService.schedule(instantPeriodicWorkerTask, j10, timeUnit));
            return instantPeriodicWorkerTask;
        }
        PeriodicSchedulerTask periodicSchedulerTask = new PeriodicSchedulerTask(runnableOnSchedule);
        periodicSchedulerTask.setFuture(scheduledExecutorService.scheduleAtFixedRate(periodicSchedulerTask, j10, j11, timeUnit));
        return periodicSchedulerTask;
    }

    @Deprecated
    public static void disableMetrics() {
        removeExecutorServiceDecorator("reactor.metrics.decorator");
    }

    @Deprecated
    public static void enableMetrics() {
        if (Metrics.isInstrumentationAvailable()) {
            addExecutorServiceDecorator("reactor.metrics.decorator", new SchedulerMetricDecorator());
        }
    }

    public static Scheduler fromExecutor(Executor executor) {
        return fromExecutor(executor, false);
    }

    public static Scheduler fromExecutorService(ExecutorService executorService) {
        return fromExecutorService(executorService, "anonymousExecutor@" + Integer.toHexString(System.identityHashCode(executorService)));
    }

    public static void handleError(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        Throwable thUnwrap = Exceptions.unwrap(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadCurrentThread.getUncaughtExceptionHandler();
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(threadCurrentThread, thUnwrap);
        } else {
            LOGGER.error("Scheduler worker failed with an uncaught exception", thUnwrap);
        }
        BiConsumer<Thread, ? super Throwable> biConsumer = onHandleErrorHook;
        if (biConsumer != null) {
            biConsumer.accept(threadCurrentThread, thUnwrap);
        }
    }

    public static Scheduler immediate() {
        return ImmediateScheduler.instance();
    }

    public static boolean isInNonBlockingThread() {
        return isNonBlockingThread(Thread.currentThread());
    }

    public static boolean isNonBlockingThread(Thread thread) {
        return (thread instanceof NonBlocking) || nonBlockingThreadPredicate.test(thread);
    }

    public static Scheduler newBoundedElastic(int i10, int i11, String str) {
        return newBoundedElastic(i10, i11, str, 60, false);
    }

    public static Scheduler newParallel(String str) {
        return newParallel(str, DEFAULT_POOL_SIZE);
    }

    public static Scheduler newSingle(String str) {
        return newSingle(str, false);
    }

    public static void onHandleError(BiConsumer<Thread, ? super Throwable> biConsumer) {
        Objects.requireNonNull(biConsumer, "onHandleError");
        Logger logger = LOGGER;
        if (logger.isDebugEnabled()) {
            logger.debug("Hooking onHandleError anonymous part");
        }
        synchronized (logger) {
            LinkedHashMap<String, BiConsumer<Thread, Throwable>> linkedHashMap = onHandleErrorHooks;
            linkedHashMap.put(Schedulers.class.getName() + ".ON_HANDLE_ERROR_ANONYMOUS_PART", biConsumer);
            onHandleErrorHook = createOrAppendHandleError(linkedHashMap.values());
        }
    }

    public static Runnable onSchedule(Runnable runnable) {
        Function<Runnable, Runnable> function = onScheduleHook;
        return function != null ? function.apply(runnable) : runnable;
    }

    public static void onScheduleHook(String str, Function<Runnable, Runnable> function) {
        LinkedHashMap<String, Function<Runnable, Runnable>> linkedHashMap = onScheduleHooks;
        synchronized (linkedHashMap) {
            try {
                linkedHashMap.put(str, function);
                Function<Runnable, Runnable> functionAndThen = null;
                for (Function<Runnable, Runnable> function2 : linkedHashMap.values()) {
                    functionAndThen = functionAndThen == null ? function2 : functionAndThen.andThen(function2);
                }
                onScheduleHook = functionAndThen;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Scheduler parallel() {
        return cache(CACHED_PARALLEL, PARALLEL, PARALLEL_SUPPLIER);
    }

    public static void registerNonBlockingThreadPredicate(Predicate<Thread> predicate) {
        nonBlockingThreadPredicate = nonBlockingThreadPredicate.or(predicate);
    }

    public static BiFunction<Scheduler, ScheduledExecutorService, ScheduledExecutorService> removeExecutorServiceDecorator(String str) {
        BiFunction<Scheduler, ScheduledExecutorService, ScheduledExecutorService> biFunctionRemove;
        Map<String, BiFunction<Scheduler, ScheduledExecutorService, ScheduledExecutorService>> map = DECORATORS;
        synchronized (map) {
            biFunctionRemove = map.remove(str);
        }
        if (biFunctionRemove instanceof Disposable) {
            ((Disposable) biFunctionRemove).dispose();
        }
        return biFunctionRemove;
    }

    public static void resetFactory() {
        setFactory(DEFAULT);
    }

    public static void resetFrom(@Nullable Snapshot snapshot) {
        if (snapshot == null) {
            resetFactory();
            return;
        }
        CachedScheduler andSet = CACHED_BOUNDED_ELASTIC.getAndSet(snapshot.oldBoundedElasticScheduler);
        CachedScheduler andSet2 = CACHED_PARALLEL.getAndSet(snapshot.oldParallelScheduler);
        CachedScheduler andSet3 = CACHED_SINGLE.getAndSet(snapshot.oldSingleScheduler);
        factory = snapshot.oldFactory;
        if (andSet != null) {
            andSet._dispose();
        }
        if (andSet2 != null) {
            andSet2._dispose();
        }
        if (andSet3 != null) {
            andSet3._dispose();
        }
    }

    public static void resetNonBlockingThreadPredicate() {
        nonBlockingThreadPredicate = DEFAULT_NON_BLOCKING_THREAD_PREDICATE;
    }

    public static void resetOnHandleError() {
        Logger logger = LOGGER;
        if (logger.isDebugEnabled()) {
            logger.debug("Reset to factory defaults: onHandleError");
        }
        synchronized (logger) {
            onHandleErrorHooks.clear();
            onHandleErrorHook = null;
        }
    }

    public static void resetOnScheduleHook(String str) {
        LinkedHashMap<String, Function<Runnable, Runnable>> linkedHashMap = onScheduleHooks;
        synchronized (linkedHashMap) {
            try {
                linkedHashMap.remove(str);
                if (linkedHashMap.isEmpty()) {
                    onScheduleHook = Function.identity();
                } else {
                    Function<Runnable, Runnable> functionAndThen = null;
                    for (Function<Runnable, Runnable> function : linkedHashMap.values()) {
                        functionAndThen = functionAndThen == null ? function : functionAndThen.andThen(function);
                    }
                    onScheduleHook = functionAndThen;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void resetOnScheduleHooks() {
        LinkedHashMap<String, Function<Runnable, Runnable>> linkedHashMap = onScheduleHooks;
        synchronized (linkedHashMap) {
            linkedHashMap.clear();
            onScheduleHook = null;
        }
    }

    @Nullable
    public static final Object scanExecutor(Executor executor, Scannable.Attr attr) {
        if (executor instanceof DelegateServiceScheduler.UnsupportedScheduledExecutorService) {
            executor = ((DelegateServiceScheduler.UnsupportedScheduledExecutorService) executor).get();
        }
        if (executor instanceof Scannable) {
            return ((Scannable) executor).scanUnsafe(attr);
        }
        if (executor instanceof ExecutorService) {
            ExecutorService executorService = (ExecutorService) executor;
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(executorService.isTerminated());
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(executorService.isShutdown());
            }
        }
        if (!(executor instanceof ThreadPoolExecutor)) {
            return null;
        }
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
        if (attr == Scannable.Attr.CAPACITY) {
            return Integer.valueOf(threadPoolExecutor.getMaximumPoolSize());
        }
        if (attr == Scannable.Attr.BUFFERED) {
            return Integer.valueOf(Long.valueOf(threadPoolExecutor.getTaskCount() - threadPoolExecutor.getCompletedTaskCount()).intValue());
        }
        if (attr == Scannable.Attr.LARGE_BUFFERED) {
            return Long.valueOf(threadPoolExecutor.getTaskCount() - threadPoolExecutor.getCompletedTaskCount());
        }
        return null;
    }

    public static void setExecutorServiceDecorator(String str, BiFunction<Scheduler, ScheduledExecutorService, ScheduledExecutorService> biFunction) {
        Map<String, BiFunction<Scheduler, ScheduledExecutorService, ScheduledExecutorService>> map = DECORATORS;
        synchronized (map) {
            map.put(str, biFunction);
        }
    }

    public static void setFactory(Factory factory2) {
        Objects.requireNonNull(factory2, "factoryInstance");
        shutdownNow();
        factory = factory2;
    }

    public static Snapshot setFactoryWithSnapshot(Factory factory2) {
        Snapshot snapshot = new Snapshot(CACHED_BOUNDED_ELASTIC.getAndSet(null), CACHED_PARALLEL.getAndSet(null), CACHED_SINGLE.getAndSet(null), factory);
        setFactory(factory2);
        return snapshot;
    }

    public static void shutdownNow() {
        CachedScheduler andSet = CACHED_BOUNDED_ELASTIC.getAndSet(null);
        CachedScheduler andSet2 = CACHED_PARALLEL.getAndSet(null);
        CachedScheduler andSet3 = CACHED_SINGLE.getAndSet(null);
        if (andSet != null) {
            andSet._dispose();
        }
        if (andSet2 != null) {
            andSet2._dispose();
        }
        if (andSet3 != null) {
            andSet3._dispose();
        }
    }

    public static Scheduler single() {
        return cache(CACHED_SINGLE, "single", SINGLE_SUPPLIER);
    }

    public static Disposable workerSchedule(ScheduledExecutorService scheduledExecutorService, Disposable.Composite composite, Runnable runnable, long j10, TimeUnit timeUnit) {
        WorkerTask workerTask = new WorkerTask(onSchedule(runnable), composite);
        if (!composite.add(workerTask)) {
            throw Exceptions.failWithRejected();
        }
        try {
            workerTask.setFuture(j10 <= 0 ? scheduledExecutorService.submit((Callable) workerTask) : scheduledExecutorService.schedule((Callable) workerTask, j10, timeUnit));
            return workerTask;
        } catch (RejectedExecutionException e10) {
            workerTask.dispose();
            throw e10;
        }
    }

    public static Disposable workerSchedulePeriodically(ScheduledExecutorService scheduledExecutorService, Disposable.Composite composite, Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        Runnable runnableOnSchedule = onSchedule(runnable);
        if (j11 <= 0) {
            InstantPeriodicWorkerTask instantPeriodicWorkerTask = new InstantPeriodicWorkerTask(runnableOnSchedule, scheduledExecutorService, composite);
            if (!composite.add(instantPeriodicWorkerTask)) {
                throw Exceptions.failWithRejected();
            }
            try {
                instantPeriodicWorkerTask.setFirst(j10 <= 0 ? scheduledExecutorService.submit(instantPeriodicWorkerTask) : scheduledExecutorService.schedule(instantPeriodicWorkerTask, j10, timeUnit));
                return instantPeriodicWorkerTask;
            } catch (IllegalArgumentException | NullPointerException e10) {
                instantPeriodicWorkerTask.dispose();
                throw new RejectedExecutionException(e10);
            } catch (RejectedExecutionException e11) {
                instantPeriodicWorkerTask.dispose();
                throw e11;
            }
        }
        PeriodicWorkerTask periodicWorkerTask = new PeriodicWorkerTask(runnableOnSchedule, composite);
        if (!composite.add(periodicWorkerTask)) {
            throw Exceptions.failWithRejected();
        }
        try {
            periodicWorkerTask.setFuture(scheduledExecutorService.scheduleAtFixedRate(periodicWorkerTask, j10, j11, timeUnit));
            return periodicWorkerTask;
        } catch (IllegalArgumentException | NullPointerException e12) {
            periodicWorkerTask.dispose();
            throw new RejectedExecutionException(e12);
        } catch (RejectedExecutionException e13) {
            periodicWorkerTask.dispose();
            throw e13;
        }
    }

    public static Scheduler fromExecutor(Executor executor, boolean z10) {
        if (!z10 && (executor instanceof ExecutorService)) {
            return fromExecutorService((ExecutorService) executor);
        }
        ExecutorScheduler executorScheduler = new ExecutorScheduler(executor, z10);
        executorScheduler.init();
        return executorScheduler;
    }

    public static Scheduler newBoundedElastic(int i10, int i11, String str, int i12) {
        return newBoundedElastic(i10, i11, str, i12, false);
    }

    public static Scheduler newParallel(String str, int i10) {
        return newParallel(str, i10, false);
    }

    public static Scheduler newSingle(String str, boolean z10) {
        return newSingle(new ReactorThreadFactory(str, SingleScheduler.COUNTER, z10, true, new x()));
    }

    public static Scheduler single(Scheduler scheduler) {
        return new SingleWorkerScheduler(scheduler);
    }

    public static Scheduler fromExecutorService(ExecutorService executorService, String str) {
        DelegateServiceScheduler delegateServiceScheduler = new DelegateServiceScheduler(str, executorService);
        delegateServiceScheduler.init();
        return delegateServiceScheduler;
    }

    public static Scheduler newBoundedElastic(int i10, int i11, String str, int i12, boolean z10) {
        return newBoundedElastic(i10, i11, new ReactorThreadFactory(str, BoundedElasticScheduler.COUNTER, z10, false, new x()), i12);
    }

    public static Scheduler newParallel(String str, int i10, boolean z10) {
        return newParallel(i10, new ReactorThreadFactory(str, ParallelScheduler.COUNTER, z10, true, new x()));
    }

    public static Scheduler newSingle(ThreadFactory threadFactory) {
        Scheduler schedulerNewSingle = factory.newSingle(threadFactory);
        schedulerNewSingle.init();
        return schedulerNewSingle;
    }

    public static Scheduler newBoundedElastic(int i10, int i11, ThreadFactory threadFactory, int i12) {
        Scheduler schedulerNewBoundedElastic = factory.newBoundedElastic(i10, i11, threadFactory, i12);
        schedulerNewBoundedElastic.init();
        return schedulerNewBoundedElastic;
    }

    public static Scheduler newParallel(int i10, ThreadFactory threadFactory) {
        Scheduler schedulerNewParallel = factory.newParallel(i10, threadFactory);
        schedulerNewParallel.init();
        return schedulerNewParallel;
    }

    public static void resetOnHandleError(String str) {
        Logger logger = LOGGER;
        if (logger.isDebugEnabled()) {
            logger.debug("Remove onHandleError sub-hook {}", str);
        }
        synchronized (logger) {
            try {
                LinkedHashMap<String, BiConsumer<Thread, Throwable>> linkedHashMap = onHandleErrorHooks;
                if (linkedHashMap.remove(str) != null) {
                    onHandleErrorHook = createOrAppendHandleError(linkedHashMap.values());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void onHandleError(String str, BiConsumer<Thread, ? super Throwable> biConsumer) {
        Objects.requireNonNull(str, "key");
        Objects.requireNonNull(biConsumer, "onHandleError");
        Logger logger = LOGGER;
        if (logger.isDebugEnabled()) {
            logger.debug("Hooking onHandleError part with key {}", str);
        }
        synchronized (logger) {
            LinkedHashMap<String, BiConsumer<Thread, Throwable>> linkedHashMap = onHandleErrorHooks;
            linkedHashMap.put(str, biConsumer);
            onHandleErrorHook = createOrAppendHandleError(linkedHashMap.values());
        }
    }
}

package reactor.core.publisher;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxBufferPredicate;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxWindowPredicate<T> extends InternalFluxOperator<T, Flux<T>> implements Fuseable {
    final Supplier<? extends Queue<T>> groupQueueSupplier;
    final Supplier<? extends Queue<Flux<T>>> mainQueueSupplier;
    final FluxBufferPredicate.Mode mode;
    final Predicate<? super T> predicate;
    final int prefetch;

    public static final class WindowFlux<T> extends Flux<T> implements Fuseable, Fuseable.QueueSubscription<T>, InnerOperator<T, T> {
        volatile CoreSubscriber<? super T> actual;
        volatile boolean cancelled;
        volatile Context ctx = Context.empty();
        boolean deferred = true;
        volatile boolean done;
        volatile boolean enableOperatorFusion;
        Throwable error;
        volatile int once;
        volatile WindowPredicateMain<T> parent;
        int produced;
        final Queue<T> queue;
        volatile long requested;
        volatile int wip;
        static final AtomicReferenceFieldUpdater<WindowFlux, WindowPredicateMain> PARENT = AtomicReferenceFieldUpdater.newUpdater(WindowFlux.class, WindowPredicateMain.class, "parent");
        static final AtomicReferenceFieldUpdater<WindowFlux, CoreSubscriber> ACTUAL = AtomicReferenceFieldUpdater.newUpdater(WindowFlux.class, CoreSubscriber.class, "actual");
        static final AtomicIntegerFieldUpdater<WindowFlux> ONCE = AtomicIntegerFieldUpdater.newUpdater(WindowFlux.class, "once");
        static final AtomicIntegerFieldUpdater<WindowFlux> WIP = AtomicIntegerFieldUpdater.newUpdater(WindowFlux.class, "wip");
        static final AtomicLongFieldUpdater<WindowFlux> REQUESTED = AtomicLongFieldUpdater.newUpdater(WindowFlux.class, "requested");

        public WindowFlux(Queue<T> queue, WindowPredicateMain<T> windowPredicateMain) {
            this.queue = queue;
            this.parent = windowPredicateMain;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            WindowPredicateMain<T> windowPredicateMain = this.parent;
            if (windowPredicateMain != null && PARENT.compareAndSet(this, windowPredicateMain, null)) {
                if (WindowPredicateMain.WINDOW_COUNT.decrementAndGet(windowPredicateMain) == 0) {
                    windowPredicateMain.cancel();
                } else {
                    windowPredicateMain.f5825s.request(1L);
                }
            }
            if (this.enableOperatorFusion || WIP.getAndIncrement(this) != 0) {
                return;
            }
            Operators.onDiscardQueueWithClear(this.queue, this.ctx, null);
        }

        public boolean checkTerminated(boolean z10, boolean z11, Z9.d dVar, Queue<?> queue) {
            if (this.cancelled) {
                Operators.onDiscardQueueWithClear(queue, this.ctx, null);
                this.ctx = Context.empty();
                this.actual = null;
                return true;
            }
            if (!z10 || !z11) {
                return false;
            }
            Throwable th = this.error;
            this.ctx = Context.empty();
            this.actual = null;
            if (th != null) {
                dVar.onError(th);
            } else {
                dVar.onComplete();
            }
            return true;
        }

        @Override // java.util.Collection
        public void clear() {
            Operators.onDiscardQueueWithClear(this.queue, this.ctx, null);
        }

        public void drain() {
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            if (coreSubscriber == null || WIP.getAndIncrement(this) != 0) {
                return;
            }
            if (this.enableOperatorFusion) {
                drainFused(coreSubscriber);
            } else {
                drainRegular(coreSubscriber);
            }
        }

        public void drainFused(Z9.d dVar) {
            Queue<T> queue = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z10 = this.done;
                dVar.onNext(null);
                if (z10) {
                    this.ctx = Context.empty();
                    this.actual = null;
                    Throwable th = this.error;
                    if (th != null) {
                        dVar.onError(th);
                        return;
                    } else {
                        dVar.onComplete();
                        return;
                    }
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            Operators.onDiscardQueueWithClear(queue, this.ctx, null);
            this.ctx = Context.empty();
            this.actual = null;
        }

        public void drainRegular(Z9.d dVar) {
            Queue<T> queue = this.queue;
            int iAddAndGet = 1;
            do {
                long j5 = this.requested;
                long j6 = 0;
                while (j5 != j6) {
                    boolean z10 = this.done;
                    T tPoll = queue.poll();
                    boolean z11 = tPoll == null;
                    if (checkTerminated(z10, z11, dVar, queue)) {
                        return;
                    }
                    if (z11) {
                        break;
                    }
                    dVar.onNext(tPoll);
                    j6++;
                }
                if (j5 == j6 && checkTerminated(this.done, queue.isEmpty(), dVar, queue)) {
                    return;
                }
                if (j6 != 0) {
                    WindowPredicateMain<T> windowPredicateMain = this.parent;
                    if (windowPredicateMain != null) {
                        windowPredicateMain.f5825s.request(j6);
                    }
                    if (j5 != Long.MAX_VALUE) {
                        REQUESTED.addAndGet(this, -j6);
                    }
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.done = true;
            propagateTerminate();
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            propagateTerminate();
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            if (!this.queue.offer(t9)) {
                onError(Operators.onOperatorError(this, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t9, this.ctx));
            } else if (!this.enableOperatorFusion) {
                drain();
            } else if (coreSubscriber != null) {
                coreSubscriber.onNext(null);
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            T tPoll = this.queue.poll();
            if (tPoll != null) {
                this.produced++;
                return tPoll;
            }
            int i = this.produced;
            if (i != 0) {
                this.produced = 0;
                WindowPredicateMain<T> windowPredicateMain = this.parent;
                if (windowPredicateMain != null) {
                    windowPredicateMain.f5825s.request(i);
                }
            }
            return tPoll;
        }

        public void propagateTerminate() {
            WindowPredicateMain<T> windowPredicateMain = this.parent;
            if (windowPredicateMain == null || !PARENT.compareAndSet(this, windowPredicateMain, null)) {
                return;
            }
            windowPredicateMain.groupTerminated();
        }

        @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Operators.addCap(REQUESTED, this, j5);
                drain();
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.enableOperatorFusion = true;
            return 2;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.parent;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr != Scannable.Attr.BUFFERED) {
                return attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            Queue<T> queue = this.queue;
            return Integer.valueOf(queue == null ? 0 : queue.size());
        }

        @Override // java.util.Collection
        public int size() {
            return this.queue.size();
        }

        @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
        public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
            if (this.once != 0 || !ONCE.compareAndSet(this, 0, 1)) {
                coreSubscriber.onError(new IllegalStateException("This processor allows only a single Subscriber"));
                return;
            }
            coreSubscriber.onSubscribe(this);
            ACTUAL.lazySet(this, coreSubscriber);
            this.ctx = coreSubscriber.currentContext();
            drain();
        }
    }

    public static final class WindowPredicateMain<T> implements Fuseable.QueueSubscription<Flux<T>>, InnerOperator<T, Flux<T>> {
        final CoreSubscriber<? super Flux<T>> actual;
        volatile int cancelled;
        final Context ctx;
        volatile boolean done;
        volatile Throwable error;
        final Supplier<? extends Queue<T>> groupQueueSupplier;
        final FluxBufferPredicate.Mode mode;
        volatile boolean outputFused;
        final Predicate<? super T> predicate;
        final int prefetch;
        final Queue<Flux<T>> queue;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5825s;
        WindowFlux<T> window;
        volatile int windowCount;
        volatile int wip;
        static final AtomicIntegerFieldUpdater<WindowPredicateMain> WIP = AtomicIntegerFieldUpdater.newUpdater(WindowPredicateMain.class, "wip");
        static final AtomicLongFieldUpdater<WindowPredicateMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(WindowPredicateMain.class, "requested");
        static final AtomicReferenceFieldUpdater<WindowPredicateMain, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(WindowPredicateMain.class, Throwable.class, "error");
        static final AtomicIntegerFieldUpdater<WindowPredicateMain> CANCELLED = AtomicIntegerFieldUpdater.newUpdater(WindowPredicateMain.class, "cancelled");
        static final AtomicIntegerFieldUpdater<WindowPredicateMain> WINDOW_COUNT = AtomicIntegerFieldUpdater.newUpdater(WindowPredicateMain.class, "windowCount");

        public WindowPredicateMain(CoreSubscriber<? super Flux<T>> coreSubscriber, Queue<Flux<T>> queue, Supplier<? extends Queue<T>> supplier, int i, Predicate<? super T> predicate, FluxBufferPredicate.Mode mode) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.queue = queue;
            this.groupQueueSupplier = supplier;
            this.prefetch = i;
            this.predicate = predicate;
            this.mode = mode;
            WINDOW_COUNT.lazySet(this, 2);
            initializeWindow();
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Flux<T>> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
        public void cancel() {
            AtomicIntegerFieldUpdater<WindowPredicateMain> atomicIntegerFieldUpdater = CANCELLED;
            if (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                if (atomicIntegerFieldUpdater.get(this) == 2 && WINDOW_COUNT.get(this) == 0) {
                    this.f5825s.cancel();
                    cleanup();
                    return;
                }
                return;
            }
            if (WINDOW_COUNT.decrementAndGet(this) == 0) {
                this.f5825s.cancel();
                cleanup();
                return;
            }
            if (this.outputFused || WIP.getAndIncrement(this) != 0) {
                return;
            }
            WindowFlux<T> windowFlux = this.window;
            while (true) {
                Flux<T> fluxPoll = this.queue.poll();
                if (fluxPoll == null) {
                    break;
                } else {
                    ((WindowFlux) fluxPoll).cancel();
                }
            }
            if (windowFlux != null && windowFlux.deferred) {
                windowFlux.cancel();
            }
            if (WIP.decrementAndGet(this) != 0) {
                CANCELLED.set(this, 2);
                drainLoop();
            } else if (this.done || WINDOW_COUNT.get(this) != 0) {
                CANCELLED.set(this, 2);
            } else {
                this.f5825s.cancel();
                cleanup();
            }
        }

        public boolean checkTerminated(boolean z10, boolean z11, Z9.d dVar, Queue<Flux<T>> queue) {
            if (this.cancelled != 0) {
                queue.clear();
                return true;
            }
            if (!z10) {
                return false;
            }
            Throwable th = this.error;
            if (th != null && th != Exceptions.TERMINATED) {
                this.queue.clear();
                signalAsyncError();
                return true;
            }
            if (!z11) {
                return false;
            }
            dVar.onComplete();
            return true;
        }

        public void cleanup() {
            Predicate<? super T> predicate = this.predicate;
            if (predicate instanceof Disposable) {
                ((Disposable) predicate).dispose();
            }
        }

        @Override // java.util.Collection
        public void clear() {
            this.queue.clear();
        }

        public void drain() {
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainLoop();
            }
        }

        public void drainFused() {
            CoreSubscriber<? super Flux<T>> coreSubscriber = this.actual;
            Queue<Flux<T>> queue = this.queue;
            int iAddAndGet = 1;
            while (this.cancelled == 0) {
                boolean z10 = this.done;
                coreSubscriber.onNext(null);
                if (z10) {
                    if (this.error != null) {
                        signalAsyncError();
                        return;
                    } else {
                        coreSubscriber.onComplete();
                        return;
                    }
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            queue.clear();
        }

        public void drainLoop() {
            CoreSubscriber<? super Flux<T>> coreSubscriber = this.actual;
            Queue<Flux<T>> queue = this.queue;
            int iAddAndGet = 1;
            do {
                long j5 = this.requested;
                long j6 = 0;
                while (j6 != j5) {
                    boolean z10 = this.done;
                    Flux<T> fluxPoll = queue.poll();
                    boolean z11 = fluxPoll == null;
                    if (checkTerminated(z10, z11, coreSubscriber, queue)) {
                        return;
                    }
                    if (z11) {
                        break;
                    }
                    coreSubscriber.onNext(fluxPoll);
                    j6++;
                }
                if (j6 == j5 && checkTerminated(this.done, queue.isEmpty(), coreSubscriber, queue)) {
                    return;
                }
                if (j6 != 0) {
                    this.f5825s.request(j6);
                    if (j5 != Long.MAX_VALUE) {
                        REQUESTED.addAndGet(this, -j6);
                    }
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        public void groupTerminated() {
            if (this.windowCount == 0) {
                return;
            }
            this.window = null;
            if (WINDOW_COUNT.decrementAndGet(this) == 0) {
                this.f5825s.cancel();
                cleanup();
            }
        }

        public boolean handleDeferredWindow(@Nullable WindowFlux<T> windowFlux, T t9) {
            if (windowFlux == null || !windowFlux.deferred) {
                return true;
            }
            windowFlux.deferred = false;
            if (this.queue.offer(windowFlux)) {
                return true;
            }
            onError(Operators.onOperatorError(this, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t9, this.ctx));
            return false;
        }

        public void initializeWindow() {
            this.window = new WindowFlux<>(this.groupQueueSupplier.get(), this);
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            WindowFlux<T> windowFlux = this.window;
            return windowFlux == null ? Stream.empty() : Stream.of(windowFlux);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Nullable
        public WindowFlux<T> newWindowDeferred() {
            if (this.cancelled != 0) {
                return null;
            }
            WINDOW_COUNT.getAndIncrement(this);
            WindowFlux<T> windowFlux = new WindowFlux<>(this.groupQueueSupplier.get(), this);
            this.window = windowFlux;
            return windowFlux;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            cleanup();
            WindowFlux<T> windowFlux = this.window;
            if (windowFlux != null) {
                windowFlux.onComplete();
            }
            this.window = null;
            this.done = true;
            WINDOW_COUNT.decrementAndGet(this);
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (!Exceptions.addThrowable(ERROR, this, th)) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            this.done = true;
            cleanup();
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.ctx);
                return;
            }
            WindowFlux<T> windowFlux = this.window;
            try {
                boolean zTest = this.predicate.test(t9);
                if (handleDeferredWindow(windowFlux, t9)) {
                    drain();
                    FluxBufferPredicate.Mode mode = this.mode;
                    if (mode == FluxBufferPredicate.Mode.UNTIL && zTest) {
                        if (windowFlux.cancelled) {
                            Operators.onDiscard(t9, this.ctx);
                            this.f5825s.request(1L);
                        } else {
                            windowFlux.onNext(t9);
                        }
                        windowFlux.onComplete();
                        newWindowDeferred();
                        this.f5825s.request(1L);
                        return;
                    }
                    if (mode == FluxBufferPredicate.Mode.UNTIL_CUT_BEFORE && zTest) {
                        windowFlux.onComplete();
                        WindowFlux<T> windowFluxNewWindowDeferred = newWindowDeferred();
                        if (windowFluxNewWindowDeferred != null) {
                            windowFluxNewWindowDeferred.onNext(t9);
                            handleDeferredWindow(windowFluxNewWindowDeferred, t9);
                            drain();
                            return;
                        }
                        return;
                    }
                    if (mode == FluxBufferPredicate.Mode.WHILE && !zTest) {
                        windowFlux.onComplete();
                        newWindowDeferred();
                        Operators.onDiscard(t9, this.ctx);
                        this.f5825s.request(1L);
                        return;
                    }
                    if (!windowFlux.cancelled) {
                        windowFlux.onNext(t9);
                    } else {
                        Operators.onDiscard(t9, this.ctx);
                        this.f5825s.request(1L);
                    }
                }
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f5825s, th, t9, this.ctx));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5825s, eVar)) {
                this.f5825s = eVar;
                this.actual.onSubscribe(this);
                if (this.cancelled == 0) {
                    eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
                }
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Operators.addCap(REQUESTED, this, j5);
                drain();
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5825s;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled == 1);
            }
            return attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.prefetch) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.queue.size()) : attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public void signalAsyncError() {
            Throwable thTerminate = Exceptions.terminate(ERROR, this);
            this.windowCount = 0;
            WindowFlux<T> windowFlux = this.window;
            if (windowFlux != null) {
                windowFlux.onError(Exceptions.wrapSource(thTerminate));
            }
            this.actual.onError(thTerminate);
            this.window = null;
        }

        @Override // java.util.Collection
        public int size() {
            return this.queue.size();
        }

        @Override // java.util.Queue
        @Nullable
        public Flux<T> poll() {
            return this.queue.poll();
        }
    }

    public FluxWindowPredicate(Flux<? extends T> flux, Supplier<? extends Queue<Flux<T>>> supplier, Supplier<? extends Queue<T>> supplier2, int i, Predicate<? super T> predicate, FluxBufferPredicate.Mode mode) {
        super(Flux.from(flux));
        if (i <= 0) {
            throw new IllegalArgumentException(B7.a.h(i, "prefetch > 0 required but it was "));
        }
        Objects.requireNonNull(predicate, "predicate");
        this.predicate = predicate;
        Objects.requireNonNull(supplier, "mainQueueSupplier");
        this.mainQueueSupplier = supplier;
        Objects.requireNonNull(supplier2, "groupQueueSupplier");
        this.groupQueueSupplier = supplier2;
        this.mode = mode;
        this.prefetch = i;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return this.prefetch;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super Flux<T>> coreSubscriber) {
        return new WindowPredicateMain(coreSubscriber, this.mainQueueSupplier.get(), this.groupQueueSupplier, this.prefetch, this.predicate, this.mode);
    }
}

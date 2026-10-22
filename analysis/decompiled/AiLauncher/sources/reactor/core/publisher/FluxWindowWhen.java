package reactor.core.publisher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Sinks;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;

/* loaded from: classes5.dex */
final class FluxWindowWhen<T, U, V> extends InternalFluxOperator<T, Flux<T>> {
    final Function<? super U, ? extends qc.b<V>> end;
    final Supplier<? extends Queue<T>> processorQueueSupplier;
    final qc.b<U> start;

    public static final class WindowOperation<T, U> {
        final U open;

        /* renamed from: w, reason: collision with root package name */
        final Sinks.Many<T> f39610w;

        public WindowOperation(@Nullable Sinks.Many<T> many, @Nullable U u10) {
            this.f39610w = many;
            this.open = u10;
        }
    }

    public static final class WindowWhenCloseSubscriber<T, V> implements Disposable, qc.c<V> {
        static final AtomicReferenceFieldUpdater<WindowWhenCloseSubscriber, qc.d> SUBSCRIPTION = AtomicReferenceFieldUpdater.newUpdater(WindowWhenCloseSubscriber.class, qc.d.class, "subscription");
        boolean done;
        final WindowWhenMainSubscriber<T, ?, V> parent;
        volatile qc.d subscription;

        /* renamed from: w, reason: collision with root package name */
        final Sinks.Many<T> f39611w;

        public WindowWhenCloseSubscriber(WindowWhenMainSubscriber<T, ?, V> windowWhenMainSubscriber, Sinks.Many<T> many) {
            this.parent = windowWhenMainSubscriber;
            this.f39611w = many;
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            Operators.terminate(SUBSCRIPTION, this);
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return this.subscription == Operators.cancelledSubscription();
        }

        @Override // qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.close(this);
        }

        @Override // qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.parent.actual.currentContext());
            } else {
                this.done = true;
                this.parent.error(th);
            }
        }

        @Override // qc.c
        public void onNext(V v10) {
            if (this.done) {
                return;
            }
            this.done = true;
            dispose();
            this.parent.close(this);
        }

        @Override // qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(SUBSCRIPTION, this, dVar)) {
                this.subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public static final class WindowWhenMainSubscriber<T, U, V> extends QueueDrainSubscriber<T, Object, Flux<T>> {
        static final AtomicReferenceFieldUpdater<WindowWhenMainSubscriber, Disposable> BOUNDARY = AtomicReferenceFieldUpdater.newUpdater(WindowWhenMainSubscriber.class, Disposable.class, "boundary");
        static final AtomicLongFieldUpdater<WindowWhenMainSubscriber> OPEN_WINDOW_COUNT = AtomicLongFieldUpdater.newUpdater(WindowWhenMainSubscriber.class, "openWindowCount");
        volatile Disposable boundary;
        final Function<? super U, ? extends qc.b<V>> close;
        final qc.b<U> open;
        volatile long openWindowCount;
        final Supplier<? extends Queue<T>> processorQueueSupplier;
        final Disposable.Composite resources;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39612s;
        final List<Sinks.Many<T>> windows;

        public WindowWhenMainSubscriber(CoreSubscriber<? super Flux<T>> coreSubscriber, qc.b<U> bVar, Function<? super U, ? extends qc.b<V>> function, Supplier<? extends Queue<T>> supplier) {
            super(coreSubscriber, (Queue) Queues.unboundedMultiproducer().get());
            this.open = bVar;
            this.close = function;
            this.processorQueueSupplier = supplier;
            this.resources = Disposables.composite();
            this.windows = new ArrayList();
            OPEN_WINDOW_COUNT.lazySet(this, 1L);
        }

        @Override // reactor.core.publisher.QueueDrainSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.cancelled = true;
        }

        public void close(WindowWhenCloseSubscriber<T, V> windowWhenCloseSubscriber) {
            this.resources.remove(windowWhenCloseSubscriber);
            this.queue.offer(new WindowOperation(windowWhenCloseSubscriber.f39611w, null));
            if (enter()) {
                drainLoop();
            }
        }

        public void dispose() {
            this.resources.dispose();
            OperatorDisposables.dispose(BOUNDARY, this);
        }

        public void drainLoop() {
            Queue<U> queue = this.queue;
            CoreSubscriber<? super V> coreSubscriber = this.actual;
            List<Sinks.Many<T>> list = this.windows;
            int iLeave = 1;
            while (true) {
                boolean z10 = this.done;
                U uPoll = queue.poll();
                boolean z11 = uPoll == null;
                if (z10 && z11) {
                    dispose();
                    Throwable th = this.error;
                    if (th != null) {
                        Iterator<Sinks.Many<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().emitError(Exceptions.wrapSource(th), Sinks.EmitFailureHandler.FAIL_FAST);
                        }
                        this.actual.onError(th);
                    } else {
                        Iterator<Sinks.Many<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
                        }
                        this.actual.onComplete();
                    }
                    list.clear();
                    return;
                }
                if (z11) {
                    iLeave = leave(-iLeave);
                    if (iLeave == 0) {
                        return;
                    }
                } else if (uPoll instanceof WindowOperation) {
                    WindowOperation windowOperation = (WindowOperation) uPoll;
                    Sinks.Many<T> many = windowOperation.f39610w;
                    if (many != null) {
                        if (list.remove(many)) {
                            windowOperation.f39610w.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
                            if (OPEN_WINDOW_COUNT.decrementAndGet(this) == 0) {
                                dispose();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.cancelled) {
                        Sinks.Many<T> manyOnBackpressureBuffer = Sinks.unsafe().many().unicast().onBackpressureBuffer(this.processorQueueSupplier.get());
                        long jRequested = requested();
                        if (jRequested != 0) {
                            list.add(manyOnBackpressureBuffer);
                            coreSubscriber.onNext(manyOnBackpressureBuffer.asFlux());
                            if (jRequested != Long.MAX_VALUE) {
                                produced(1L);
                            }
                            try {
                                qc.b<V> bVarApply = this.close.apply(windowOperation.open);
                                Objects.requireNonNull(bVarApply, "The publisher supplied is null");
                                qc.b<V> bVar = bVarApply;
                                WindowWhenCloseSubscriber windowWhenCloseSubscriber = new WindowWhenCloseSubscriber(this, manyOnBackpressureBuffer);
                                if (this.resources.add(windowWhenCloseSubscriber)) {
                                    OPEN_WINDOW_COUNT.getAndIncrement(this);
                                    Operators.toFluxOrMono(bVar).subscribe(windowWhenCloseSubscriber);
                                }
                            } catch (Throwable th2) {
                                this.cancelled = true;
                                coreSubscriber.onError(th2);
                            }
                        } else {
                            this.cancelled = true;
                            coreSubscriber.onError(Exceptions.failWithOverflow("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator<Sinks.Many<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().emitNext(uPoll, Sinks.EmitFailureHandler.FAIL_FAST);
                    }
                }
            }
        }

        public void error(Throwable th) {
            this.f39612s.cancel();
            this.resources.dispose();
            OperatorDisposables.dispose(BOUNDARY, this);
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.QueueDrainSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            if (OPEN_WINDOW_COUNT.decrementAndGet(this) == 0) {
                this.resources.dispose();
            }
        }

        @Override // reactor.core.publisher.QueueDrainSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            if (OPEN_WINDOW_COUNT.decrementAndGet(this) == 0) {
                this.resources.dispose();
            }
        }

        @Override // reactor.core.publisher.QueueDrainSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            if (fastEnter()) {
                Iterator<Sinks.Many<T>> it = this.windows.iterator();
                while (it.hasNext()) {
                    it.next().emitNext(t10, Sinks.EmitFailureHandler.FAIL_FAST);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(t10);
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39612s, dVar)) {
                this.f39612s = dVar;
                dVar.request(Long.MAX_VALUE);
            }
        }

        public void open(U u10) {
            this.queue.offer(new WindowOperation(null, u10));
            if (enter()) {
                drainLoop();
            }
        }

        @Override // reactor.core.publisher.QueueDrainSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            requested(j10);
        }

        @Override // reactor.core.publisher.QueueDrainSubscriber, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class WindowWhenOpenSubscriber<T, U> implements Disposable, qc.c<U> {
        static final AtomicReferenceFieldUpdater<WindowWhenOpenSubscriber, qc.d> SUBSCRIPTION = AtomicReferenceFieldUpdater.newUpdater(WindowWhenOpenSubscriber.class, qc.d.class, "subscription");
        boolean done;
        final WindowWhenMainSubscriber<T, U, ?> parent;
        volatile qc.d subscription;

        public WindowWhenOpenSubscriber(WindowWhenMainSubscriber<T, U, ?> windowWhenMainSubscriber) {
            this.parent = windowWhenMainSubscriber;
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            Operators.terminate(SUBSCRIPTION, this);
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return this.subscription == Operators.cancelledSubscription();
        }

        @Override // qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.onComplete();
        }

        @Override // qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.parent.actual.currentContext());
            } else {
                this.done = true;
                this.parent.error(th);
            }
        }

        @Override // qc.c
        public void onNext(U u10) {
            if (this.done) {
                return;
            }
            this.parent.open(u10);
        }

        @Override // qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(SUBSCRIPTION, this, dVar)) {
                this.subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FluxWindowWhen(Flux<? extends T> flux, qc.b<U> bVar, Function<? super U, ? extends qc.b<V>> function, Supplier<? extends Queue<T>> supplier) {
        super(flux);
        Objects.requireNonNull(bVar, "start");
        this.start = Operators.toFluxOrMono(bVar);
        Objects.requireNonNull(function, com.stepos.ailauncher.container.wallpaper.a.PHASE_END);
        this.end = function;
        Objects.requireNonNull(supplier, "processorQueueSupplier");
        this.processorQueueSupplier = supplier;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return Integer.MAX_VALUE;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    @Nullable
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super Flux<T>> coreSubscriber) {
        WindowWhenMainSubscriber windowWhenMainSubscriber = new WindowWhenMainSubscriber(coreSubscriber, this.start, this.end, this.processorQueueSupplier);
        coreSubscriber.onSubscribe(windowWhenMainSubscriber);
        if (windowWhenMainSubscriber.cancelled) {
            return null;
        }
        WindowWhenOpenSubscriber windowWhenOpenSubscriber = new WindowWhenOpenSubscriber(windowWhenMainSubscriber);
        if (!WindowWhenMainSubscriber.BOUNDARY.compareAndSet(windowWhenMainSubscriber, null, windowWhenOpenSubscriber)) {
            return null;
        }
        WindowWhenMainSubscriber.OPEN_WINDOW_COUNT.incrementAndGet(windowWhenMainSubscriber);
        this.start.subscribe(windowWhenOpenSubscriber);
        return windowWhenMainSubscriber;
    }
}

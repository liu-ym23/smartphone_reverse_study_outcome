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

/* loaded from: classes4.dex */
final class FluxWindowWhen<T, U, V> extends InternalFluxOperator<T, Flux<T>> {
    final Function<? super U, ? extends Z9.c> end;
    final Supplier<? extends Queue<T>> processorQueueSupplier;
    final Z9.c start;

    public static final class WindowOperation<T, U> {
        final U open;

        /* renamed from: w, reason: collision with root package name */
        final Sinks.Many<T> f5828w;

        public WindowOperation(@Nullable Sinks.Many<T> many, @Nullable U u) {
            this.f5828w = many;
            this.open = u;
        }
    }

    public static final class WindowWhenCloseSubscriber<T, V> implements Disposable, Z9.d {
        static final AtomicReferenceFieldUpdater<WindowWhenCloseSubscriber, Z9.e> SUBSCRIPTION = AtomicReferenceFieldUpdater.newUpdater(WindowWhenCloseSubscriber.class, Z9.e.class, "subscription");
        boolean done;
        final WindowWhenMainSubscriber<T, ?, V> parent;
        volatile Z9.e subscription;

        /* renamed from: w, reason: collision with root package name */
        final Sinks.Many<T> f5829w;

        public WindowWhenCloseSubscriber(WindowWhenMainSubscriber<T, ?, V> windowWhenMainSubscriber, Sinks.Many<T> many) {
            this.parent = windowWhenMainSubscriber;
            this.f5829w = many;
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            Operators.terminate(SUBSCRIPTION, this);
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return this.subscription == Operators.cancelledSubscription();
        }

        @Override // Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.close(this);
        }

        @Override // Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.parent.actual.currentContext());
            } else {
                this.done = true;
                this.parent.error(th);
            }
        }

        @Override // Z9.d
        public void onNext(V v10) {
            if (this.done) {
                return;
            }
            this.done = true;
            dispose();
            this.parent.close(this);
        }

        @Override // Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.setOnce(SUBSCRIPTION, this, eVar)) {
                this.subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public static final class WindowWhenMainSubscriber<T, U, V> extends QueueDrainSubscriber<T, Object, Flux<T>> {
        static final AtomicReferenceFieldUpdater<WindowWhenMainSubscriber, Disposable> BOUNDARY = AtomicReferenceFieldUpdater.newUpdater(WindowWhenMainSubscriber.class, Disposable.class, "boundary");
        static final AtomicLongFieldUpdater<WindowWhenMainSubscriber> OPEN_WINDOW_COUNT = AtomicLongFieldUpdater.newUpdater(WindowWhenMainSubscriber.class, "openWindowCount");
        volatile Disposable boundary;
        final Function<? super U, ? extends Z9.c> close;
        final Z9.c open;
        volatile long openWindowCount;
        final Supplier<? extends Queue<T>> processorQueueSupplier;
        final Disposable.Composite resources;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5830s;
        final List<Sinks.Many<T>> windows;

        public WindowWhenMainSubscriber(CoreSubscriber<? super Flux<T>> coreSubscriber, Z9.c cVar, Function<? super U, ? extends Z9.c> function, Supplier<? extends Queue<T>> supplier) {
            super(coreSubscriber, (Queue) Queues.unboundedMultiproducer().get());
            this.open = cVar;
            this.close = function;
            this.processorQueueSupplier = supplier;
            this.resources = Disposables.composite();
            this.windows = new ArrayList();
            OPEN_WINDOW_COUNT.lazySet(this, 1L);
        }

        @Override // reactor.core.publisher.QueueDrainSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.cancelled = true;
        }

        public void close(WindowWhenCloseSubscriber<T, V> windowWhenCloseSubscriber) {
            this.resources.remove(windowWhenCloseSubscriber);
            this.queue.offer(new WindowOperation(windowWhenCloseSubscriber.f5829w, null));
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
                    Sinks.Many<T> many = windowOperation.f5828w;
                    if (many != null) {
                        if (list.remove(many)) {
                            windowOperation.f5828w.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
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
                                Z9.c cVarApply = this.close.apply(windowOperation.open);
                                Objects.requireNonNull(cVarApply, "The publisher supplied is null");
                                Z9.c cVar = cVarApply;
                                WindowWhenCloseSubscriber windowWhenCloseSubscriber = new WindowWhenCloseSubscriber(this, manyOnBackpressureBuffer);
                                if (this.resources.add(windowWhenCloseSubscriber)) {
                                    OPEN_WINDOW_COUNT.getAndIncrement(this);
                                    Operators.toFluxOrMono(cVar).subscribe(windowWhenCloseSubscriber);
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
            this.f5830s.cancel();
            this.resources.dispose();
            OperatorDisposables.dispose(BOUNDARY, this);
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.QueueDrainSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
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

        @Override // reactor.core.publisher.QueueDrainSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
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

        @Override // reactor.core.publisher.QueueDrainSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            if (fastEnter()) {
                Iterator<Sinks.Many<T>> it = this.windows.iterator();
                while (it.hasNext()) {
                    it.next().emitNext(t9, Sinks.EmitFailureHandler.FAIL_FAST);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(t9);
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5830s, eVar)) {
                this.f5830s = eVar;
                eVar.request(Long.MAX_VALUE);
            }
        }

        public void open(U u) {
            this.queue.offer(new WindowOperation(null, u));
            if (enter()) {
                drainLoop();
            }
        }

        @Override // reactor.core.publisher.QueueDrainSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            requested(j5);
        }

        @Override // reactor.core.publisher.QueueDrainSubscriber, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class WindowWhenOpenSubscriber<T, U> implements Disposable, Z9.d {
        static final AtomicReferenceFieldUpdater<WindowWhenOpenSubscriber, Z9.e> SUBSCRIPTION = AtomicReferenceFieldUpdater.newUpdater(WindowWhenOpenSubscriber.class, Z9.e.class, "subscription");
        boolean done;
        final WindowWhenMainSubscriber<T, U, ?> parent;
        volatile Z9.e subscription;

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

        @Override // Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.onComplete();
        }

        @Override // Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.parent.actual.currentContext());
            } else {
                this.done = true;
                this.parent.error(th);
            }
        }

        @Override // Z9.d
        public void onNext(U u) {
            if (this.done) {
                return;
            }
            this.parent.open(u);
        }

        @Override // Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.setOnce(SUBSCRIPTION, this, eVar)) {
                this.subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FluxWindowWhen(Flux<? extends T> flux, Z9.c cVar, Function<? super U, ? extends Z9.c> function, Supplier<? extends Queue<T>> supplier) {
        super(flux);
        Objects.requireNonNull(cVar, "start");
        this.start = Operators.toFluxOrMono(cVar);
        Objects.requireNonNull(function, "end");
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
        if (!windowWhenMainSubscriber.cancelled) {
            WindowWhenOpenSubscriber windowWhenOpenSubscriber = new WindowWhenOpenSubscriber(windowWhenMainSubscriber);
            if (WindowWhenMainSubscriber.BOUNDARY.compareAndSet(windowWhenMainSubscriber, null, windowWhenOpenSubscriber)) {
                WindowWhenMainSubscriber.OPEN_WINDOW_COUNT.incrementAndGet(windowWhenMainSubscriber);
                this.start.subscribe(windowWhenOpenSubscriber);
                return windowWhenMainSubscriber;
            }
        }
        return null;
    }
}

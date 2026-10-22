package reactor.core.publisher;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxConcatMap;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxMergeSequential<T, R> extends InternalFluxOperator<T, R> {
    final FluxConcatMap.ErrorMode errorMode;
    final Function<? super T, ? extends qc.b<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;
    final Supplier<Queue<MergeSequentialInner<R>>> queueSupplier;

    public static final class MergeSequentialInner<R> implements InnerConsumer<R> {
        static final AtomicReferenceFieldUpdater<MergeSequentialInner, qc.d> SUBSCRIPTION = AtomicReferenceFieldUpdater.newUpdater(MergeSequentialInner.class, qc.d.class, "subscription");
        volatile boolean done;
        int fusionMode;
        final int limit;
        final MergeSequentialMain<?, R> parent;
        final int prefetch;
        long produced;
        volatile Queue<R> queue;
        volatile qc.d subscription;

        public MergeSequentialInner(MergeSequentialMain<?, R> mergeSequentialMain, int i10) {
            this.parent = mergeSequentialMain;
            this.prefetch = i10;
            this.limit = Operators.unboundedOrLimit(i10);
        }

        public void cancel() {
            Operators.set(SUBSCRIPTION, this, Operators.cancelledSubscription());
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        public boolean isDone() {
            return this.done;
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.parent.innerError(this, th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(R r10) {
            if (this.fusionMode == 0) {
                this.parent.innerNext(this, r10);
            } else {
                this.parent.drain();
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(SUBSCRIPTION, this, dVar)) {
                if (dVar instanceof Fuseable.QueueSubscription) {
                    Fuseable.QueueSubscription queueSubscription = (Fuseable.QueueSubscription) dVar;
                    int iRequestFusion = queueSubscription.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.fusionMode = iRequestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.innerComplete(this);
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.fusionMode = iRequestFusion;
                        this.queue = queueSubscription;
                        dVar.request(Operators.unboundedOrPrefetch(this.prefetch));
                        return;
                    }
                }
                this.queue = (Queue) Queues.get(this.prefetch).get();
                dVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        public Queue<R> queue() {
            return this.queue;
        }

        public void requestOne() {
            if (this.fusionMode != 1) {
                long j10 = this.produced + 1;
                if (j10 != this.limit) {
                    this.produced = j10;
                } else {
                    this.produced = 0L;
                    this.subscription.request(j10);
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.subscription;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                if (!this.done || (this.queue != null && !this.queue.isEmpty())) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.subscription == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.queue != null ? this.queue.size() : 0);
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.valueOf(this.prefetch);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }

        public void setDone() {
            this.done = true;
        }
    }

    public static final class MergeSequentialMain<T, R> implements InnerOperator<T, R> {
        final CoreSubscriber<? super R> actual;
        volatile boolean cancelled;
        MergeSequentialInner<R> current;
        volatile boolean done;
        volatile Throwable error;
        final FluxConcatMap.ErrorMode errorMode;
        final Function<? super T, ? extends qc.b<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39533s;
        final Queue<MergeSequentialInner<R>> subscribers;
        volatile int wip;
        static final AtomicReferenceFieldUpdater<MergeSequentialMain, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(MergeSequentialMain.class, Throwable.class, "error");
        static final AtomicIntegerFieldUpdater<MergeSequentialMain> WIP = AtomicIntegerFieldUpdater.newUpdater(MergeSequentialMain.class, "wip");
        static final AtomicLongFieldUpdater<MergeSequentialMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(MergeSequentialMain.class, "requested");

        public MergeSequentialMain(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends qc.b<? extends R>> function, int i10, int i11, FluxConcatMap.ErrorMode errorMode, Supplier<Queue<MergeSequentialInner<R>>> supplier) {
            this.actual = coreSubscriber;
            this.mapper = function;
            this.maxConcurrency = i10;
            this.prefetch = i11;
            this.errorMode = errorMode;
            this.subscribers = supplier.get();
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f39533s.cancel();
            drainAndCancel();
        }

        public void cancelAll() {
            MergeSequentialInner<R> mergeSequentialInner = this.current;
            if (mergeSequentialInner != null) {
                mergeSequentialInner.cancel();
            }
            while (true) {
                MergeSequentialInner<R> mergeSequentialInnerPoll = this.subscribers.poll();
                if (mergeSequentialInnerPoll == null) {
                    return;
                } else {
                    mergeSequentialInnerPoll.cancel();
                }
            }
        }

        public void drain() {
            MergeSequentialInner<R> mergeSequentialInnerPoll;
            long j10;
            long j11;
            boolean z10;
            Queue<R> queue;
            Throwable th;
            Throwable th2;
            Throwable th3;
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            MergeSequentialInner<R> mergeSequentialInner = this.current;
            CoreSubscriber<? super R> coreSubscriber = this.actual;
            FluxConcatMap.ErrorMode errorMode = this.errorMode;
            int iAddAndGet = 1;
            while (true) {
                long j12 = this.requested;
                if (mergeSequentialInner != null) {
                    mergeSequentialInnerPoll = mergeSequentialInner;
                } else {
                    if (errorMode != FluxConcatMap.ErrorMode.END && (th3 = this.error) != null) {
                        cancelAll();
                        coreSubscriber.onError(th3);
                        return;
                    }
                    boolean z11 = this.done;
                    mergeSequentialInnerPoll = this.subscribers.poll();
                    if (z11 && mergeSequentialInnerPoll == null) {
                        Throwable th4 = this.error;
                        if (th4 != null) {
                            coreSubscriber.onError(th4);
                            return;
                        } else {
                            coreSubscriber.onComplete();
                            return;
                        }
                    }
                    if (mergeSequentialInnerPoll != null) {
                        this.current = mergeSequentialInnerPoll;
                    }
                }
                if (mergeSequentialInnerPoll == null || (queue = mergeSequentialInnerPoll.queue()) == null) {
                    j10 = 0;
                    j11 = 0;
                    z10 = false;
                } else {
                    j11 = 0;
                    while (true) {
                        if (j11 == j12) {
                            j10 = 0;
                            break;
                        }
                        if (this.cancelled) {
                            cancelAll();
                            return;
                        }
                        if (errorMode == FluxConcatMap.ErrorMode.IMMEDIATE && (th2 = this.error) != null) {
                            this.current = null;
                            mergeSequentialInnerPoll.cancel();
                            cancelAll();
                            coreSubscriber.onError(th2);
                            return;
                        }
                        boolean zIsDone = mergeSequentialInnerPoll.isDone();
                        j10 = 0;
                        try {
                            R rPoll = queue.poll();
                            boolean z12 = rPoll == null;
                            if (zIsDone && z12) {
                                this.current = null;
                                this.f39533s.request(1L);
                                mergeSequentialInnerPoll = null;
                                z10 = true;
                                break;
                            }
                            if (z12) {
                                break;
                            }
                            coreSubscriber.onNext(rPoll);
                            j11++;
                            mergeSequentialInnerPoll.requestOne();
                        } catch (Throwable th5) {
                            this.current = null;
                            mergeSequentialInnerPoll.cancel();
                            Throwable thOnOperatorError = Operators.onOperatorError(th5, this.actual.currentContext());
                            cancelAll();
                            coreSubscriber.onError(thOnOperatorError);
                            return;
                        }
                    }
                    z10 = false;
                    if (j11 == j12) {
                        if (this.cancelled) {
                            cancelAll();
                            return;
                        }
                        if (errorMode == FluxConcatMap.ErrorMode.IMMEDIATE && (th = this.error) != null) {
                            this.current = null;
                            mergeSequentialInnerPoll.cancel();
                            cancelAll();
                            coreSubscriber.onError(th);
                            return;
                        }
                        boolean zIsDone2 = mergeSequentialInnerPoll.isDone();
                        boolean zIsEmpty = queue.isEmpty();
                        if (zIsDone2 && zIsEmpty) {
                            this.current = null;
                            this.f39533s.request(1L);
                            mergeSequentialInnerPoll = null;
                            z10 = true;
                        }
                    }
                }
                if (j11 != j10 && j12 != Long.MAX_VALUE) {
                    REQUESTED.addAndGet(this, -j11);
                }
                if (!z10 && (iAddAndGet = WIP.addAndGet(this, -iAddAndGet)) == 0) {
                    return;
                } else {
                    mergeSequentialInner = mergeSequentialInnerPoll;
                }
            }
        }

        public void drainAndCancel() {
            if (WIP.getAndIncrement(this) == 0) {
                do {
                    cancelAll();
                } while (WIP.decrementAndGet(this) != 0);
            }
        }

        public void innerComplete(MergeSequentialInner<R> mergeSequentialInner) {
            mergeSequentialInner.setDone();
            drain();
        }

        public void innerError(MergeSequentialInner<R> mergeSequentialInner, Throwable th) {
            Throwable thOnNextInnerError = Operators.onNextInnerError(th, currentContext(), this.f39533s);
            if (thOnNextInnerError == null) {
                mergeSequentialInner.setDone();
                drain();
            } else {
                if (!Exceptions.addThrowable(ERROR, this, thOnNextInnerError)) {
                    Operators.onErrorDropped(thOnNextInnerError, this.actual.currentContext());
                    return;
                }
                mergeSequentialInner.setDone();
                if (this.errorMode != FluxConcatMap.ErrorMode.END) {
                    this.f39533s.cancel();
                }
                drain();
            }
        }

        public void innerNext(MergeSequentialInner<R> mergeSequentialInner, R r10) {
            if (mergeSequentialInner.queue().offer(r10)) {
                drain();
            } else {
                mergeSequentialInner.cancel();
                onError(Operators.onOperatorError(null, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), r10, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(this.subscribers.peek());
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (!Exceptions.addThrowable(ERROR, this, th)) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            try {
                qc.b<? extends R> bVarApply = this.mapper.apply(t10);
                Objects.requireNonNull(bVarApply, "publisher");
                CorePublisher fluxOrMono = Operators.toFluxOrMono(bVarApply);
                MergeSequentialInner<R> mergeSequentialInner = new MergeSequentialInner<>(this, this.prefetch);
                if (this.cancelled) {
                    return;
                }
                if (this.subscribers.offer(mergeSequentialInner)) {
                    if (this.cancelled) {
                        return;
                    }
                    fluxOrMono.subscribe((qc.c) mergeSequentialInner);
                    if (this.cancelled) {
                        mergeSequentialInner.cancel();
                        drainAndCancel();
                        return;
                    }
                    return;
                }
                int size = this.subscribers.size();
                mergeSequentialInner.cancel();
                drainAndCancel();
                onError(Operators.onOperatorError(this.f39533s, new IllegalStateException("Too many subscribers for fluxMergeSequential on item: " + t10 + "; subscribers: " + size), t10, this.actual.currentContext()));
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f39533s, th, t10, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39533s, dVar)) {
                this.f39533s = dVar;
                this.actual.onSubscribe(this);
                int i10 = this.maxConcurrency;
                dVar.request(i10 == Integer.MAX_VALUE ? Long.MAX_VALUE : i10);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
                drain();
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39533s;
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
            }
            if (attr != Scannable.Attr.TERMINATED) {
                if (attr == Scannable.Attr.DELAY_ERROR) {
                    return Boolean.valueOf(this.errorMode != FluxConcatMap.ErrorMode.IMMEDIATE);
                }
                return attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.maxConcurrency) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.subscribers.size()) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            if (this.done && this.subscribers.isEmpty()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    public FluxMergeSequential(Flux<? extends T> flux, Function<? super T, ? extends qc.b<? extends R>> function, int i10, int i11, FluxConcatMap.ErrorMode errorMode) {
        this(flux, function, i10, i11, errorMode, Queues.get(Math.max(i11, i10)));
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        if (FluxFlatMap.trySubscribeScalarMap(this.source, coreSubscriber, this.mapper, false, false)) {
            return null;
        }
        return new MergeSequentialMain(coreSubscriber, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode, this.queueSupplier);
    }

    public FluxMergeSequential(Flux<? extends T> flux, Function<? super T, ? extends qc.b<? extends R>> function, int i10, int i11, FluxConcatMap.ErrorMode errorMode, Supplier<Queue<MergeSequentialInner<R>>> supplier) {
        super(flux);
        if (i11 <= 0) {
            throw new IllegalArgumentException("prefetch > 0 required but it was " + i11);
        }
        if (i10 > 0) {
            Objects.requireNonNull(function, "mapper");
            this.mapper = function;
            this.maxConcurrency = i10;
            this.prefetch = i11;
            this.errorMode = errorMode;
            this.queueSupplier = supplier;
            return;
        }
        throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i10);
    }
}

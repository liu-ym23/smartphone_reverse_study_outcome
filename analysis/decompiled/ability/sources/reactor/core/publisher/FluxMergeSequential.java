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

/* loaded from: classes4.dex */
final class FluxMergeSequential<T, R> extends InternalFluxOperator<T, R> {
    final FluxConcatMap.ErrorMode errorMode;
    final Function<? super T, ? extends Z9.c> mapper;
    final int maxConcurrency;
    final int prefetch;
    final Supplier<Queue<MergeSequentialInner<R>>> queueSupplier;

    public static final class MergeSequentialInner<R> implements InnerConsumer<R> {
        static final AtomicReferenceFieldUpdater<MergeSequentialInner, Z9.e> SUBSCRIPTION = AtomicReferenceFieldUpdater.newUpdater(MergeSequentialInner.class, Z9.e.class, "subscription");
        volatile boolean done;
        int fusionMode;
        final int limit;
        final MergeSequentialMain<?, R> parent;
        final int prefetch;
        long produced;
        volatile Queue<R> queue;
        volatile Z9.e subscription;

        public MergeSequentialInner(MergeSequentialMain<?, R> mergeSequentialMain, int i) {
            this.parent = mergeSequentialMain;
            this.prefetch = i;
            this.limit = Operators.unboundedOrLimit(i);
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.parent.innerError(this, th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(R r5) {
            if (this.fusionMode == 0) {
                this.parent.innerNext(this, r5);
            } else {
                this.parent.drain();
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.setOnce(SUBSCRIPTION, this, eVar)) {
                if (eVar instanceof Fuseable.QueueSubscription) {
                    Fuseable.QueueSubscription queueSubscription = (Fuseable.QueueSubscription) eVar;
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
                        eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
                        return;
                    }
                }
                this.queue = (Queue) Queues.get(this.prefetch).get();
                eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        public Queue<R> queue() {
            return this.queue;
        }

        public void requestOne() {
            if (this.fusionMode != 1) {
                long j5 = this.produced + 1;
                if (j5 != this.limit) {
                    this.produced = j5;
                } else {
                    this.produced = 0L;
                    this.subscription.request(j5);
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
        final Function<? super T, ? extends Z9.c> mapper;
        final int maxConcurrency;
        final int prefetch;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5763s;
        final Queue<MergeSequentialInner<R>> subscribers;
        volatile int wip;
        static final AtomicReferenceFieldUpdater<MergeSequentialMain, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(MergeSequentialMain.class, Throwable.class, "error");
        static final AtomicIntegerFieldUpdater<MergeSequentialMain> WIP = AtomicIntegerFieldUpdater.newUpdater(MergeSequentialMain.class, "wip");
        static final AtomicLongFieldUpdater<MergeSequentialMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(MergeSequentialMain.class, "requested");

        public MergeSequentialMain(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends Z9.c> function, int i, int i6, FluxConcatMap.ErrorMode errorMode, Supplier<Queue<MergeSequentialInner<R>>> supplier) {
            this.actual = coreSubscriber;
            this.mapper = function;
            this.maxConcurrency = i;
            this.prefetch = i6;
            this.errorMode = errorMode;
            this.subscribers = supplier.get();
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f5763s.cancel();
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
            long j5;
            long j6;
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
                long j10 = this.requested;
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
                    j5 = 0;
                    j6 = 0;
                    z10 = false;
                } else {
                    j6 = 0;
                    while (true) {
                        if (j6 == j10) {
                            j5 = 0;
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
                        j5 = 0;
                        try {
                            R rPoll = queue.poll();
                            boolean z12 = rPoll == null;
                            if (zIsDone && z12) {
                                this.current = null;
                                this.f5763s.request(1L);
                                mergeSequentialInnerPoll = null;
                                z10 = true;
                                break;
                            }
                            if (z12) {
                                break;
                            }
                            coreSubscriber.onNext(rPoll);
                            j6++;
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
                    if (j6 == j10) {
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
                            this.f5763s.request(1L);
                            mergeSequentialInnerPoll = null;
                            z10 = true;
                        }
                    }
                }
                if (j6 != j5 && j10 != Long.MAX_VALUE) {
                    REQUESTED.addAndGet(this, -j6);
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
            Throwable thOnNextInnerError = Operators.onNextInnerError(th, currentContext(), this.f5763s);
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
                    this.f5763s.cancel();
                }
                drain();
            }
        }

        public void innerNext(MergeSequentialInner<R> mergeSequentialInner, R r5) {
            if (mergeSequentialInner.queue().offer(r5)) {
                drain();
            } else {
                mergeSequentialInner.cancel();
                onError(Operators.onOperatorError(null, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), r5, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(this.subscribers.peek());
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (!Exceptions.addThrowable(ERROR, this, th)) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            try {
                Z9.c cVarApply = this.mapper.apply(t9);
                Objects.requireNonNull(cVarApply, "publisher");
                CorePublisher fluxOrMono = Operators.toFluxOrMono(cVarApply);
                MergeSequentialInner<R> mergeSequentialInner = new MergeSequentialInner<>(this, this.prefetch);
                if (this.cancelled) {
                    return;
                }
                if (this.subscribers.offer(mergeSequentialInner)) {
                    if (this.cancelled) {
                        return;
                    }
                    fluxOrMono.subscribe((Z9.d) mergeSequentialInner);
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
                onError(Operators.onOperatorError(this.f5763s, new IllegalStateException("Too many subscribers for fluxMergeSequential on item: " + t9 + "; subscribers: " + size), t9, this.actual.currentContext()));
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f5763s, th, t9, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5763s, eVar)) {
                this.f5763s = eVar;
                this.actual.onSubscribe(this);
                int i = this.maxConcurrency;
                eVar.request(i == Integer.MAX_VALUE ? Long.MAX_VALUE : i);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Operators.addCap(REQUESTED, this, j5);
                drain();
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5763s;
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

    public FluxMergeSequential(Flux<? extends T> flux, Function<? super T, ? extends Z9.c> function, int i, int i6, FluxConcatMap.ErrorMode errorMode) {
        this(flux, function, i, i6, errorMode, Queues.get(Math.max(i6, i)));
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

    public FluxMergeSequential(Flux<? extends T> flux, Function<? super T, ? extends Z9.c> function, int i, int i6, FluxConcatMap.ErrorMode errorMode, Supplier<Queue<MergeSequentialInner<R>>> supplier) {
        super(flux);
        if (i6 <= 0) {
            throw new IllegalArgumentException(B7.a.h(i6, "prefetch > 0 required but it was "));
        }
        if (i > 0) {
            Objects.requireNonNull(function, "mapper");
            this.mapper = function;
            this.maxConcurrency = i;
            this.prefetch = i6;
            this.errorMode = errorMode;
            this.queueSupplier = supplier;
            return;
        }
        throw new IllegalArgumentException(B7.a.h(i, "maxConcurrency > 0 required but it was "));
    }
}

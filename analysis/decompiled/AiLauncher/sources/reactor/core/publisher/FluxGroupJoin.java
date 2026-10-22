package reactor.core.publisher;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Sinks;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends InternalFluxOperator<TLeft, R> {
    final Function<? super TLeft, ? extends qc.b<TLeftEnd>> leftEnd;
    final qc.b<? extends TRight> other;
    final Supplier<? extends Queue<TRight>> processorQueueSupplier;
    final BiFunction<? super TLeft, ? super Flux<TRight>, ? extends R> resultSelector;
    final Function<? super TRight, ? extends qc.b<TRightEnd>> rightEnd;

    public static final class GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> implements JoinSupport<R> {
        volatile int active;
        final CoreSubscriber<? super R> actual;
        final Disposable.Composite cancellations = Disposables.composite();
        volatile Throwable error;
        final Function<? super TLeft, ? extends qc.b<TLeftEnd>> leftEnd;
        int leftIndex;
        final Map<Integer, Sinks.Many<TRight>> lefts;
        final Supplier<? extends Queue<TRight>> processorQueueSupplier;
        final Queue<Object> queue;
        final BiPredicate<Object, Object> queueBiOffer;
        volatile long requested;
        final BiFunction<? super TLeft, ? super Flux<TRight>, ? extends R> resultSelector;
        final Function<? super TRight, ? extends qc.b<TRightEnd>> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights;
        volatile int wip;
        static final AtomicIntegerFieldUpdater<GroupJoinSubscription> WIP = AtomicIntegerFieldUpdater.newUpdater(GroupJoinSubscription.class, "wip");
        static final AtomicIntegerFieldUpdater<GroupJoinSubscription> ACTIVE = AtomicIntegerFieldUpdater.newUpdater(GroupJoinSubscription.class, "active");
        static final AtomicLongFieldUpdater<GroupJoinSubscription> REQUESTED = AtomicLongFieldUpdater.newUpdater(GroupJoinSubscription.class, "requested");
        static final AtomicReferenceFieldUpdater<GroupJoinSubscription, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(GroupJoinSubscription.class, Throwable.class, "error");
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;

        public GroupJoinSubscription(CoreSubscriber<? super R> coreSubscriber, Function<? super TLeft, ? extends qc.b<TLeftEnd>> function, Function<? super TRight, ? extends qc.b<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flux<TRight>, ? extends R> biFunction, Supplier<? extends Queue<TRight>> supplier) {
            this.actual = coreSubscriber;
            this.processorQueueSupplier = supplier;
            Queue<Object> queue = (Queue) Queues.unboundedMultiproducer().get();
            this.queue = queue;
            this.queueBiOffer = (BiPredicate) queue;
            this.lefts = new LinkedHashMap();
            this.rights = new LinkedHashMap();
            this.leftEnd = function;
            this.rightEnd = function2;
            this.resultSelector = biFunction;
            ACTIVE.lazySet(this, 2);
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.FluxGroupJoin.JoinSupport, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            if (this.cancellations.isDisposed()) {
                return;
            }
            this.cancellations.dispose();
            if (WIP.getAndIncrement(this) == 0) {
                this.queue.clear();
            }
        }

        public void drain() {
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            Queue<Object> queue = this.queue;
            CoreSubscriber<? super R> coreSubscriber = this.actual;
            int iAddAndGet = 1;
            while (!this.cancellations.isDisposed()) {
                if (this.error != null) {
                    queue.clear();
                    this.cancellations.dispose();
                    errorAll(coreSubscriber);
                    return;
                }
                boolean z10 = this.active == 0;
                Integer num = (Integer) queue.poll();
                boolean z11 = num == null;
                if (z10 && z11) {
                    Iterator<Sinks.Many<TRight>> it = this.lefts.values().iterator();
                    while (it.hasNext()) {
                        it.next().emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
                    }
                    this.lefts.clear();
                    this.rights.clear();
                    this.cancellations.dispose();
                    coreSubscriber.onComplete();
                    return;
                }
                if (z11) {
                    iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    Object objPoll = queue.poll();
                    if (num == LEFT_VALUE) {
                        Sinks.Many manyOnBackpressureBuffer = Sinks.unsafe().many().unicast().onBackpressureBuffer(this.processorQueueSupplier.get());
                        int i10 = this.leftIndex;
                        this.leftIndex = i10 + 1;
                        this.lefts.put(Integer.valueOf(i10), manyOnBackpressureBuffer);
                        try {
                            qc.b<TLeftEnd> bVarApply = this.leftEnd.apply(objPoll);
                            Objects.requireNonNull(bVarApply, "The leftEnd returned a null Publisher");
                            qc.b<TLeftEnd> bVar = bVarApply;
                            LeftRightEndSubscriber leftRightEndSubscriber = new LeftRightEndSubscriber(this, true, i10);
                            this.cancellations.add(leftRightEndSubscriber);
                            Operators.toFluxOrMono(bVar).subscribe((qc.c) leftRightEndSubscriber);
                            if (this.error != null) {
                                this.cancellations.dispose();
                                queue.clear();
                                errorAll(coreSubscriber);
                                return;
                            }
                            try {
                                R rApply = this.resultSelector.apply(objPoll, manyOnBackpressureBuffer.asFlux());
                                Objects.requireNonNull(rApply, "The resultSelector returned a null value");
                                if (this.requested == 0) {
                                    Exceptions.addThrowable(ERROR, this, Exceptions.failWithOverflow());
                                    errorAll(coreSubscriber);
                                    return;
                                } else {
                                    coreSubscriber.onNext(rApply);
                                    Operators.produced(REQUESTED, this, 1L);
                                    Iterator<TRight> it2 = this.rights.values().iterator();
                                    while (it2.hasNext()) {
                                        manyOnBackpressureBuffer.emitNext(it2.next(), Sinks.EmitFailureHandler.FAIL_FAST);
                                    }
                                }
                            } catch (Throwable th) {
                                Exceptions.addThrowable(ERROR, this, Operators.onOperatorError(this, th, manyOnBackpressureBuffer, this.actual.currentContext()));
                                errorAll(coreSubscriber);
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.addThrowable(ERROR, this, Operators.onOperatorError(this, th2, objPoll, this.actual.currentContext()));
                            errorAll(coreSubscriber);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i11 = this.rightIndex;
                        this.rightIndex = i11 + 1;
                        this.rights.put(Integer.valueOf(i11), objPoll);
                        try {
                            qc.b<TRightEnd> bVarApply2 = this.rightEnd.apply(objPoll);
                            Objects.requireNonNull(bVarApply2, "The rightEnd returned a null Publisher");
                            qc.b<TRightEnd> bVar2 = bVarApply2;
                            LeftRightEndSubscriber leftRightEndSubscriber2 = new LeftRightEndSubscriber(this, false, i11);
                            this.cancellations.add(leftRightEndSubscriber2);
                            Operators.toFluxOrMono(bVar2).subscribe((qc.c) leftRightEndSubscriber2);
                            if (this.error != null) {
                                queue.clear();
                                this.cancellations.dispose();
                                errorAll(coreSubscriber);
                                return;
                            } else {
                                Iterator<Sinks.Many<TRight>> it3 = this.lefts.values().iterator();
                                while (it3.hasNext()) {
                                    it3.next().emitNext(objPoll, Sinks.EmitFailureHandler.FAIL_FAST);
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.addThrowable(ERROR, this, Operators.onOperatorError(this, th3, objPoll, this.actual.currentContext()));
                            errorAll(coreSubscriber);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        LeftRightEndSubscriber leftRightEndSubscriber3 = (LeftRightEndSubscriber) objPoll;
                        Sinks.Many<TRight> manyRemove = this.lefts.remove(Integer.valueOf(leftRightEndSubscriber3.index));
                        this.cancellations.remove(leftRightEndSubscriber3);
                        if (manyRemove != null) {
                            manyRemove.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
                        }
                    } else if (num == RIGHT_CLOSE) {
                        LeftRightEndSubscriber leftRightEndSubscriber4 = (LeftRightEndSubscriber) objPoll;
                        this.rights.remove(Integer.valueOf(leftRightEndSubscriber4.index));
                        this.cancellations.remove(leftRightEndSubscriber4);
                    }
                }
            }
            queue.clear();
        }

        public void errorAll(qc.c<?> cVar) {
            Throwable thTerminate = Exceptions.terminate(ERROR, this);
            Iterator<Sinks.Many<TRight>> it = this.lefts.values().iterator();
            while (it.hasNext()) {
                it.next().emitError(thTerminate, Sinks.EmitFailureHandler.FAIL_FAST);
            }
            this.lefts.clear();
            this.rights.clear();
            cVar.onError(thTerminate);
        }

        @Override // reactor.core.publisher.FluxGroupJoin.JoinSupport
        public void innerClose(boolean z10, LeftRightEndSubscriber leftRightEndSubscriber) {
            this.queueBiOffer.test(z10 ? LEFT_CLOSE : RIGHT_CLOSE, leftRightEndSubscriber);
            drain();
        }

        @Override // reactor.core.publisher.FluxGroupJoin.JoinSupport
        public void innerCloseError(Throwable th) {
            if (Exceptions.addThrowable(ERROR, this, th)) {
                drain();
            } else {
                Operators.onErrorDropped(th, this.actual.currentContext());
            }
        }

        @Override // reactor.core.publisher.FluxGroupJoin.JoinSupport
        public void innerComplete(LeftRightSubscriber leftRightSubscriber) {
            this.cancellations.remove(leftRightSubscriber);
            ACTIVE.decrementAndGet(this);
            drain();
        }

        @Override // reactor.core.publisher.FluxGroupJoin.JoinSupport
        public void innerError(Throwable th) {
            if (!Exceptions.addThrowable(ERROR, this, th)) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                ACTIVE.decrementAndGet(this);
                drain();
            }
        }

        @Override // reactor.core.publisher.FluxGroupJoin.JoinSupport
        public void innerValue(boolean z10, Object obj) {
            this.queueBiOffer.test(z10 ? LEFT_VALUE : RIGHT_VALUE, obj);
            drain();
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.concat(this.lefts.values().stream().map(new Function() { // from class: reactor.core.publisher.I0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Scannable.from((Sinks.Many) obj);
                }
            }), Scannable.from(this.cancellations).inners());
        }

        @Override // reactor.core.publisher.FluxGroupJoin.JoinSupport, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.requested);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancellations.isDisposed());
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.queue.size() / 2);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.active == 0);
            }
            return attr == Scannable.Attr.ERROR ? this.error : super.scanUnsafe(attr);
        }
    }

    public interface JoinSupport<T> extends InnerProducer<T> {
        @Override // reactor.core.publisher.InnerProducer, qc.d
        /* synthetic */ void cancel();

        void innerClose(boolean z10, LeftRightEndSubscriber leftRightEndSubscriber);

        void innerCloseError(Throwable th);

        void innerComplete(LeftRightSubscriber leftRightSubscriber);

        void innerError(Throwable th);

        void innerValue(boolean z10, Object obj);

        @Override // reactor.core.publisher.InnerProducer, qc.d
        /* synthetic */ void request(long j10);
    }

    public static final class LeftRightEndSubscriber implements InnerConsumer<Object>, Disposable {
        static final AtomicReferenceFieldUpdater<LeftRightEndSubscriber, qc.d> SUBSCRIPTION = AtomicReferenceFieldUpdater.newUpdater(LeftRightEndSubscriber.class, qc.d.class, "subscription");
        final int index;
        final boolean isLeft;
        final JoinSupport<?> parent;
        volatile qc.d subscription;

        public LeftRightEndSubscriber(JoinSupport<?> joinSupport, boolean z10, int i10) {
            this.parent = joinSupport;
            this.isLeft = z10;
            this.index = i10;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.actual().currentContext();
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            Operators.terminate(SUBSCRIPTION, this);
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return Operators.cancelledSubscription() == this.subscription;
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(Object obj) {
            if (Operators.terminate(SUBSCRIPTION, this)) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(SUBSCRIPTION, this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.subscription;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(isDisposed());
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public static final class LeftRightSubscriber implements InnerConsumer<Object>, Disposable {
        static final AtomicReferenceFieldUpdater<LeftRightSubscriber, qc.d> SUBSCRIPTION = AtomicReferenceFieldUpdater.newUpdater(LeftRightSubscriber.class, qc.d.class, "subscription");
        final boolean isLeft;
        final JoinSupport<?> parent;
        volatile qc.d subscription;

        public LeftRightSubscriber(JoinSupport<?> joinSupport, boolean z10) {
            this.parent = joinSupport;
            this.isLeft = z10;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.actual().currentContext();
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            Operators.terminate(SUBSCRIPTION, this);
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return Operators.cancelledSubscription() == this.subscription;
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(Object obj) {
            this.parent.innerValue(this.isLeft, obj);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(SUBSCRIPTION, this, dVar)) {
                dVar.request(Long.MAX_VALUE);
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
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(isDisposed());
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public FluxGroupJoin(Flux<TLeft> flux, qc.b<? extends TRight> bVar, Function<? super TLeft, ? extends qc.b<TLeftEnd>> function, Function<? super TRight, ? extends qc.b<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flux<TRight>, ? extends R> biFunction, Supplier<? extends Queue<Object>> supplier, Supplier<? extends Queue<TRight>> supplier2) {
        super(flux);
        Objects.requireNonNull(bVar, "other");
        this.other = Operators.toFluxOrMono(bVar);
        Objects.requireNonNull(function, "leftEnd");
        this.leftEnd = function;
        Objects.requireNonNull(function2, "rightEnd");
        this.rightEnd = function2;
        Objects.requireNonNull(supplier2, "processorQueueSupplier");
        this.processorQueueSupplier = supplier2;
        Objects.requireNonNull(biFunction, "resultSelector");
        this.resultSelector = biFunction;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super TLeft> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        GroupJoinSubscription groupJoinSubscription = new GroupJoinSubscription(coreSubscriber, this.leftEnd, this.rightEnd, this.resultSelector, this.processorQueueSupplier);
        coreSubscriber.onSubscribe(groupJoinSubscription);
        LeftRightSubscriber leftRightSubscriber = new LeftRightSubscriber(groupJoinSubscription, true);
        groupJoinSubscription.cancellations.add(leftRightSubscriber);
        LeftRightSubscriber leftRightSubscriber2 = new LeftRightSubscriber(groupJoinSubscription, false);
        groupJoinSubscription.cancellations.add(leftRightSubscriber2);
        this.source.subscribe((CoreSubscriber) leftRightSubscriber);
        this.other.subscribe(leftRightSubscriber2);
        return null;
    }
}

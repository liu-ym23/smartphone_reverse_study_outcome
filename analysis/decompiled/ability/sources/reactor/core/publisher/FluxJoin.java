package reactor.core.publisher;

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
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.FluxGroupJoin;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;

/* loaded from: classes4.dex */
final class FluxJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends InternalFluxOperator<TLeft, R> {
    final Function<? super TLeft, ? extends Z9.c> leftEnd;
    final Z9.c other;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
    final Function<? super TRight, ? extends Z9.c> rightEnd;

    public static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> implements FluxGroupJoin.JoinSupport<R> {
        volatile int active;
        final CoreSubscriber<? super R> actual;
        final Disposable.Composite cancellations = Disposables.composite();
        volatile Throwable error;
        final Function<? super TLeft, ? extends Z9.c> leftEnd;
        int leftIndex;
        final Map<Integer, TLeft> lefts;
        final Queue<Object> queue;
        final BiPredicate<Object, Object> queueBiOffer;
        volatile long requested;
        final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final Function<? super TRight, ? extends Z9.c> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights;
        volatile int wip;
        static final AtomicIntegerFieldUpdater<JoinSubscription> WIP = AtomicIntegerFieldUpdater.newUpdater(JoinSubscription.class, "wip");
        static final AtomicIntegerFieldUpdater<JoinSubscription> ACTIVE = AtomicIntegerFieldUpdater.newUpdater(JoinSubscription.class, "active");
        static final AtomicLongFieldUpdater<JoinSubscription> REQUESTED = AtomicLongFieldUpdater.newUpdater(JoinSubscription.class, "requested");
        static final AtomicReferenceFieldUpdater<JoinSubscription, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(JoinSubscription.class, Throwable.class, "error");
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;

        public JoinSubscription(CoreSubscriber<? super R> coreSubscriber, Function<? super TLeft, ? extends Z9.c> function, Function<? super TRight, ? extends Z9.c> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.actual = coreSubscriber;
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

        @Override // reactor.core.publisher.FluxGroupJoin.JoinSupport, reactor.core.publisher.InnerProducer, Z9.e
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
            int i;
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            Queue<Object> queue = this.queue;
            CoreSubscriber<? super R> coreSubscriber = this.actual;
            boolean z10 = true;
            int iAddAndGet = 1;
            while (!this.cancellations.isDisposed()) {
                if (this.error != null) {
                    queue.clear();
                    this.cancellations.dispose();
                    errorAll(coreSubscriber);
                    return;
                }
                boolean z11 = this.active == 0 ? z10 : false;
                Integer num = (Integer) queue.poll();
                boolean z12 = num == null ? z10 : false;
                if (z11 && z12) {
                    this.lefts.clear();
                    this.rights.clear();
                    this.cancellations.dispose();
                    coreSubscriber.onComplete();
                    return;
                }
                if (z12) {
                    iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    Object objPoll = queue.poll();
                    if (num == LEFT_VALUE) {
                        int i6 = this.leftIndex;
                        this.leftIndex = i6 + 1;
                        this.lefts.put(Integer.valueOf(i6), objPoll);
                        try {
                            Z9.c cVarApply = this.leftEnd.apply(objPoll);
                            Objects.requireNonNull(cVarApply, "The leftEnd returned a null Publisher");
                            Z9.c cVar = cVarApply;
                            FluxGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber = new FluxGroupJoin.LeftRightEndSubscriber(this, z10, i6);
                            this.cancellations.add(leftRightEndSubscriber);
                            Operators.toFluxOrMono(cVar).subscribe((Z9.d) leftRightEndSubscriber);
                            if (this.error != null) {
                                queue.clear();
                                this.cancellations.dispose();
                                errorAll(coreSubscriber);
                                return;
                            }
                            long j5 = this.requested;
                            i = iAddAndGet;
                            long j6 = 0;
                            for (TRight tright : this.rights.values()) {
                                try {
                                    R rApply = this.resultSelector.apply(objPoll, tright);
                                    Objects.requireNonNull(rApply, "The resultSelector returned a null value");
                                    if (j6 == j5) {
                                        Exceptions.addThrowable(ERROR, this, Exceptions.failWithOverflow("Could not emit value due to lack of requests"));
                                        queue.clear();
                                        this.cancellations.dispose();
                                        errorAll(coreSubscriber);
                                        return;
                                    }
                                    coreSubscriber.onNext(rApply);
                                    j6++;
                                } catch (Throwable th) {
                                    Exceptions.addThrowable(ERROR, this, Operators.onOperatorError(this, th, tright, this.actual.currentContext()));
                                    errorAll(coreSubscriber);
                                    return;
                                }
                            }
                            if (j6 != 0) {
                                Operators.produced(REQUESTED, this, j6);
                            }
                        } catch (Throwable th2) {
                            Exceptions.addThrowable(ERROR, this, Operators.onOperatorError(this, th2, objPoll, this.actual.currentContext()));
                            errorAll(coreSubscriber);
                            return;
                        }
                    } else {
                        i = iAddAndGet;
                        if (num == RIGHT_VALUE) {
                            int i10 = this.rightIndex;
                            this.rightIndex = i10 + 1;
                            this.rights.put(Integer.valueOf(i10), objPoll);
                            try {
                                Z9.c cVarApply2 = this.rightEnd.apply(objPoll);
                                Objects.requireNonNull(cVarApply2, "The rightEnd returned a null Publisher");
                                Z9.c cVar2 = cVarApply2;
                                FluxGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber2 = new FluxGroupJoin.LeftRightEndSubscriber(this, false, i10);
                                this.cancellations.add(leftRightEndSubscriber2);
                                Operators.toFluxOrMono(cVar2).subscribe((Z9.d) leftRightEndSubscriber2);
                                if (this.error != null) {
                                    queue.clear();
                                    this.cancellations.dispose();
                                    errorAll(coreSubscriber);
                                    return;
                                }
                                long j10 = this.requested;
                                long j11 = 0;
                                for (TLeft tleft : this.lefts.values()) {
                                    try {
                                        R rApply2 = this.resultSelector.apply(tleft, objPoll);
                                        Objects.requireNonNull(rApply2, "The resultSelector returned a null value");
                                        if (j11 == j10) {
                                            Exceptions.addThrowable(ERROR, this, Exceptions.failWithOverflow("Could not emit value due to lack of requests"));
                                            queue.clear();
                                            this.cancellations.dispose();
                                            errorAll(coreSubscriber);
                                            return;
                                        }
                                        coreSubscriber.onNext(rApply2);
                                        j11++;
                                    } catch (Throwable th3) {
                                        Exceptions.addThrowable(ERROR, this, Operators.onOperatorError(this, th3, tleft, this.actual.currentContext()));
                                        errorAll(coreSubscriber);
                                        return;
                                    }
                                }
                                if (j11 != 0) {
                                    Operators.produced(REQUESTED, this, j11);
                                }
                            } catch (Throwable th4) {
                                Exceptions.addThrowable(ERROR, this, Operators.onOperatorError(this, th4, objPoll, this.actual.currentContext()));
                                errorAll(coreSubscriber);
                                return;
                            }
                        } else if (num == LEFT_CLOSE) {
                            FluxGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber3 = (FluxGroupJoin.LeftRightEndSubscriber) objPoll;
                            this.lefts.remove(Integer.valueOf(leftRightEndSubscriber3.index));
                            this.cancellations.remove(leftRightEndSubscriber3);
                        } else if (num == RIGHT_CLOSE) {
                            FluxGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber4 = (FluxGroupJoin.LeftRightEndSubscriber) objPoll;
                            this.rights.remove(Integer.valueOf(leftRightEndSubscriber4.index));
                            this.cancellations.remove(leftRightEndSubscriber4);
                        }
                    }
                    iAddAndGet = i;
                    z10 = true;
                }
            }
            queue.clear();
        }

        public void errorAll(Z9.d dVar) {
            Throwable thTerminate = Exceptions.terminate(ERROR, this);
            this.lefts.clear();
            this.rights.clear();
            dVar.onError(thTerminate);
        }

        @Override // reactor.core.publisher.FluxGroupJoin.JoinSupport
        public void innerClose(boolean z10, FluxGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber) {
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
        public void innerComplete(FluxGroupJoin.LeftRightSubscriber leftRightSubscriber) {
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
            return Scannable.from(this.cancellations).inners();
        }

        @Override // reactor.core.publisher.FluxGroupJoin.JoinSupport, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Operators.addCap(REQUESTED, this, j5);
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
            return attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxJoin(Flux<TLeft> flux, Z9.c cVar, Function<? super TLeft, ? extends Z9.c> function, Function<? super TRight, ? extends Z9.c> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(flux);
        Objects.requireNonNull(cVar, "other");
        this.other = Operators.toFluxOrMono(cVar);
        Objects.requireNonNull(function, "leftEnd");
        this.leftEnd = function;
        Objects.requireNonNull(function2, "rightEnd");
        this.rightEnd = function2;
        Objects.requireNonNull(biFunction, "resultSelector");
        this.resultSelector = biFunction;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super TLeft> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        JoinSubscription joinSubscription = new JoinSubscription(coreSubscriber, this.leftEnd, this.rightEnd, this.resultSelector);
        coreSubscriber.onSubscribe(joinSubscription);
        FluxGroupJoin.LeftRightSubscriber leftRightSubscriber = new FluxGroupJoin.LeftRightSubscriber(joinSubscription, true);
        joinSubscription.cancellations.add(leftRightSubscriber);
        FluxGroupJoin.LeftRightSubscriber leftRightSubscriber2 = new FluxGroupJoin.LeftRightSubscriber(joinSubscription, false);
        joinSubscription.cancellations.add(leftRightSubscriber2);
        this.source.subscribe((CoreSubscriber) leftRightSubscriber);
        this.other.subscribe(leftRightSubscriber2);
        return null;
    }
}

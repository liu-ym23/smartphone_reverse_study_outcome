package reactor.core.publisher;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxFirstWithValue<T> extends Flux<T> implements SourceProducer<T> {
    final Z9.c[] array;
    final Iterable<? extends Z9.c> iterable;

    public static final class FirstValuesEmittingSubscriber<T> extends Operators.DeferredSubscription implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        final int index;
        final RaceValuesCoordinator<T> parent;
        boolean won;

        public FirstValuesEmittingSubscriber(CoreSubscriber<? super T> coreSubscriber, RaceValuesCoordinator<T> raceValuesCoordinator, int i) {
            this.actual = coreSubscriber;
            this.parent = raceValuesCoordinator;
            this.index = i;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.won) {
                this.actual.onComplete();
            } else {
                recordTerminalSignals(new NoSuchElementException(androidx.appfunctions.metadata.a.o(new StringBuilder("source at index "), " completed empty", this.index)));
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else {
                recordTerminalSignals(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.won) {
                this.actual.onNext(t9);
            } else if (this.parent.tryWin(this.index)) {
                this.won = true;
                this.actual.onNext(t9);
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            set(eVar);
        }

        public void recordTerminalSignals(Throwable th) {
            RaceValuesCoordinator<T> raceValuesCoordinator = this.parent;
            raceValuesCoordinator.errorsOrCompleteEmpty[this.index] = th;
            if (RaceValuesCoordinator.ERRORS_OR_COMPLETED_EMPTY.incrementAndGet(raceValuesCoordinator) == this.parent.subscribers.length) {
                NoSuchElementException noSuchElementException = new NoSuchElementException("All sources completed with error or without values");
                noSuchElementException.initCause(Exceptions.multiple(this.parent.errorsOrCompleteEmpty));
                this.actual.onError(noSuchElementException);
            }
        }

        @Override // reactor.core.publisher.Operators.DeferredSubscription, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5876s : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.parent.cancelled) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class RaceValuesCoordinator<T> implements Z9.e, Scannable {
        volatile boolean cancelled;
        final Throwable[] errorsOrCompleteEmpty;
        volatile int nbErrorsOrCompletedEmpty;
        final FirstValuesEmittingSubscriber<T>[] subscribers;
        volatile int winner = Integer.MIN_VALUE;
        static final AtomicIntegerFieldUpdater<RaceValuesCoordinator> WINNER = AtomicIntegerFieldUpdater.newUpdater(RaceValuesCoordinator.class, "winner");
        static final AtomicIntegerFieldUpdater<RaceValuesCoordinator> ERRORS_OR_COMPLETED_EMPTY = AtomicIntegerFieldUpdater.newUpdater(RaceValuesCoordinator.class, "nbErrorsOrCompletedEmpty");

        public RaceValuesCoordinator(int i) {
            this.subscribers = new FirstValuesEmittingSubscriber[i];
            this.errorsOrCompleteEmpty = new Throwable[i];
        }

        @Override // Z9.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            int i = this.winner;
            if (i >= 0) {
                this.subscribers[i].cancel();
                return;
            }
            for (FirstValuesEmittingSubscriber<T> firstValuesEmittingSubscriber : this.subscribers) {
                firstValuesEmittingSubscriber.cancel();
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) this.subscribers);
        }

        @Override // Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                int i = this.winner;
                if (i >= 0) {
                    this.subscribers[i].request(j5);
                    return;
                }
                for (FirstValuesEmittingSubscriber<T> firstValuesEmittingSubscriber : this.subscribers) {
                    firstValuesEmittingSubscriber.request(j5);
                }
            }
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled);
            }
            return null;
        }

        public void subscribe(Z9.c[] cVarArr, int i, CoreSubscriber<? super T> coreSubscriber) {
            for (int i6 = 0; i6 < i; i6++) {
                this.subscribers[i6] = new FirstValuesEmittingSubscriber<>(coreSubscriber, this, i6);
            }
            coreSubscriber.onSubscribe(this);
            Operators.toFluxOrMono(cVarArr);
            for (int i10 = 0; i10 < i && !this.cancelled && this.winner == Integer.MIN_VALUE; i10++) {
                Z9.c cVar = cVarArr[i10];
                if (cVar == null) {
                    coreSubscriber.onError(new NullPointerException(androidx.appfunctions.metadata.a.i(i10, "The ", " th Publisher source is null")));
                    return;
                }
                cVar.subscribe(this.subscribers[i10]);
            }
        }

        public boolean tryWin(int i) {
            int i6 = 0;
            if (this.winner != Integer.MIN_VALUE || !WINNER.compareAndSet(this, Integer.MIN_VALUE, i)) {
                return false;
            }
            while (true) {
                FirstValuesEmittingSubscriber<T>[] firstValuesEmittingSubscriberArr = this.subscribers;
                if (i6 >= firstValuesEmittingSubscriberArr.length) {
                    return true;
                }
                if (i6 != i) {
                    firstValuesEmittingSubscriberArr[i6].cancel();
                    this.errorsOrCompleteEmpty[i6] = null;
                }
                i6++;
            }
        }
    }

    private FluxFirstWithValue(Z9.c[] cVarArr) {
        Objects.requireNonNull(cVarArr, "array");
        this.array = cVarArr;
        this.iterable = null;
    }

    @SafeVarargs
    @Nullable
    public final FluxFirstWithValue<T> firstValuedAdditionalSources(Z9.c... cVarArr) {
        Objects.requireNonNull(cVarArr, "others");
        if (cVarArr.length == 0) {
            return this;
        }
        Z9.c[] cVarArr2 = this.array;
        if (cVarArr2 == null) {
            return null;
        }
        int length = cVarArr2.length;
        int length2 = cVarArr.length;
        Z9.c[] cVarArr3 = new Z9.c[length + length2];
        System.arraycopy(cVarArr2, 0, cVarArr3, 0, length);
        System.arraycopy(cVarArr, 0, cVarArr3, length, length2);
        return new FluxFirstWithValue<>(cVarArr3);
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        int length;
        Z9.c[] cVarArr = this.array;
        if (cVarArr == null) {
            cVarArr = new Z9.c[8];
            try {
                Iterator<? extends Z9.c> it = this.iterable.iterator();
                Objects.requireNonNull(it, "The iterator returned is null");
                Iterator<? extends Z9.c> it2 = it;
                length = 0;
                while (it2.hasNext()) {
                    try {
                        try {
                            Z9.c next = it2.next();
                            Objects.requireNonNull(next, "The Publisher returned by the iterator is null");
                            Z9.c cVar = next;
                            if (length == cVarArr.length) {
                                Z9.c[] cVarArr2 = new Z9.c[(length >> 2) + length];
                                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                                cVarArr = cVarArr2;
                            }
                            cVarArr[length] = cVar;
                            length++;
                        } catch (Throwable th) {
                            com.stepos.statsrpk.service.c.t(coreSubscriber, th, coreSubscriber);
                            return;
                        }
                    } catch (Throwable th2) {
                        com.stepos.statsrpk.service.c.t(coreSubscriber, th2, coreSubscriber);
                        return;
                    }
                }
            } catch (Throwable th3) {
                com.stepos.statsrpk.service.c.t(coreSubscriber, th3, coreSubscriber);
                return;
            }
        } else {
            length = cVarArr.length;
        }
        if (length == 0) {
            Operators.complete(coreSubscriber);
            return;
        }
        if (length != 1) {
            new RaceValuesCoordinator(length).subscribe(cVarArr, length, coreSubscriber);
            return;
        }
        Flux fluxFrom = Flux.from(cVarArr[0]);
        if (fluxFrom == null) {
            Operators.error(coreSubscriber, new NullPointerException("The single source Publisher is null"));
        } else {
            fluxFrom.subscribe((Z9.d) coreSubscriber);
        }
    }

    @SafeVarargs
    public FluxFirstWithValue(Z9.c cVar, Z9.c... cVarArr) {
        Objects.requireNonNull(cVar, "first");
        Objects.requireNonNull(cVarArr, "others");
        Z9.c[] cVarArr2 = new Z9.c[cVarArr.length + 1];
        cVarArr2[0] = cVar;
        System.arraycopy(cVarArr, 0, cVarArr2, 1, cVarArr.length);
        this.array = cVarArr2;
        this.iterable = null;
    }

    public FluxFirstWithValue(Iterable<? extends Z9.c> iterable) {
        this.array = null;
        Objects.requireNonNull(iterable);
        this.iterable = iterable;
    }
}

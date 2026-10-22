package reactor.core.publisher;

import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
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

/* loaded from: classes5.dex */
final class FluxFirstWithValue<T> extends Flux<T> implements SourceProducer<T> {
    final qc.b<? extends T>[] array;
    final Iterable<? extends qc.b<? extends T>> iterable;

    public static final class FirstValuesEmittingSubscriber<T> extends Operators.DeferredSubscription implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        final int index;
        final RaceValuesCoordinator<T> parent;
        boolean won;

        public FirstValuesEmittingSubscriber(CoreSubscriber<? super T> coreSubscriber, RaceValuesCoordinator<T> raceValuesCoordinator, int i10) {
            this.actual = coreSubscriber;
            this.parent = raceValuesCoordinator;
            this.index = i10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.won) {
                this.actual.onComplete();
                return;
            }
            recordTerminalSignals(new NoSuchElementException("source at index " + this.index + " completed empty"));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else {
                recordTerminalSignals(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.won) {
                this.actual.onNext(t10);
            } else if (this.parent.tryWin(this.index)) {
                this.won = true;
                this.actual.onNext(t10);
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            set(dVar);
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
            return attr == Scannable.Attr.PARENT ? this.f39688s : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.parent.cancelled) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class RaceValuesCoordinator<T> implements qc.d, Scannable {
        volatile boolean cancelled;
        final Throwable[] errorsOrCompleteEmpty;
        volatile int nbErrorsOrCompletedEmpty;
        final FirstValuesEmittingSubscriber<T>[] subscribers;
        volatile int winner = Integer.MIN_VALUE;
        static final AtomicIntegerFieldUpdater<RaceValuesCoordinator> WINNER = AtomicIntegerFieldUpdater.newUpdater(RaceValuesCoordinator.class, "winner");
        static final AtomicIntegerFieldUpdater<RaceValuesCoordinator> ERRORS_OR_COMPLETED_EMPTY = AtomicIntegerFieldUpdater.newUpdater(RaceValuesCoordinator.class, "nbErrorsOrCompletedEmpty");

        public RaceValuesCoordinator(int i10) {
            this.subscribers = new FirstValuesEmittingSubscriber[i10];
            this.errorsOrCompleteEmpty = new Throwable[i10];
        }

        @Override // qc.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            int i10 = this.winner;
            if (i10 >= 0) {
                this.subscribers[i10].cancel();
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

        @Override // qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                int i10 = this.winner;
                if (i10 >= 0) {
                    this.subscribers[i10].request(j10);
                    return;
                }
                for (FirstValuesEmittingSubscriber<T> firstValuesEmittingSubscriber : this.subscribers) {
                    firstValuesEmittingSubscriber.request(j10);
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

        public void subscribe(qc.b<? extends T>[] bVarArr, int i10, CoreSubscriber<? super T> coreSubscriber) {
            for (int i11 = 0; i11 < i10; i11++) {
                this.subscribers[i11] = new FirstValuesEmittingSubscriber<>(coreSubscriber, this, i11);
            }
            coreSubscriber.onSubscribe(this);
            Operators.toFluxOrMono(bVarArr);
            for (int i12 = 0; i12 < i10 && !this.cancelled && this.winner == Integer.MIN_VALUE; i12++) {
                qc.b<? extends T> bVar = bVarArr[i12];
                if (bVar == null) {
                    coreSubscriber.onError(new NullPointerException("The " + i12 + " th Publisher source is null"));
                    return;
                }
                bVar.subscribe(this.subscribers[i12]);
            }
        }

        public boolean tryWin(int i10) {
            int i11 = 0;
            if (this.winner != Integer.MIN_VALUE || !WINNER.compareAndSet(this, Integer.MIN_VALUE, i10)) {
                return false;
            }
            while (true) {
                FirstValuesEmittingSubscriber<T>[] firstValuesEmittingSubscriberArr = this.subscribers;
                if (i11 >= firstValuesEmittingSubscriberArr.length) {
                    return true;
                }
                if (i11 != i10) {
                    firstValuesEmittingSubscriberArr[i11].cancel();
                    this.errorsOrCompleteEmpty[i11] = null;
                }
                i11++;
            }
        }
    }

    private FluxFirstWithValue(qc.b<? extends T>[] bVarArr) {
        Objects.requireNonNull(bVarArr, "array");
        this.array = bVarArr;
        this.iterable = null;
    }

    @SafeVarargs
    @Nullable
    public final FluxFirstWithValue<T> firstValuedAdditionalSources(qc.b<? extends T>... bVarArr) {
        Objects.requireNonNull(bVarArr, "others");
        if (bVarArr.length == 0) {
            return this;
        }
        qc.b<? extends T>[] bVarArr2 = this.array;
        if (bVarArr2 == null) {
            return null;
        }
        int length = bVarArr2.length;
        int length2 = bVarArr.length;
        qc.b[] bVarArr3 = new qc.b[length + length2];
        System.arraycopy(bVarArr2, 0, bVarArr3, 0, length);
        System.arraycopy(bVarArr, 0, bVarArr3, length, length2);
        return new FluxFirstWithValue<>(bVarArr3);
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        int length;
        qc.b<? extends T>[] bVarArr = this.array;
        if (bVarArr == null) {
            bVarArr = new qc.b[8];
            try {
                Iterator<? extends qc.b<? extends T>> it = this.iterable.iterator();
                Objects.requireNonNull(it, "The iterator returned is null");
                Iterator<? extends qc.b<? extends T>> it2 = it;
                length = 0;
                while (it2.hasNext()) {
                    try {
                        try {
                            qc.b<? extends T> next = it2.next();
                            Objects.requireNonNull(next, "The Publisher returned by the iterator is null");
                            qc.b<? extends T> bVar = next;
                            if (length == bVarArr.length) {
                                qc.b<? extends T>[] bVarArr2 = new qc.b[(length >> 2) + length];
                                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                                bVarArr = bVarArr2;
                            }
                            bVarArr[length] = bVar;
                            length++;
                        } catch (Throwable th) {
                            Operators.error(coreSubscriber, Operators.onOperatorError(th, coreSubscriber.currentContext()));
                            return;
                        }
                    } catch (Throwable th2) {
                        Operators.error(coreSubscriber, Operators.onOperatorError(th2, coreSubscriber.currentContext()));
                        return;
                    }
                }
            } catch (Throwable th3) {
                Operators.error(coreSubscriber, Operators.onOperatorError(th3, coreSubscriber.currentContext()));
                return;
            }
        } else {
            length = bVarArr.length;
        }
        if (length == 0) {
            Operators.complete(coreSubscriber);
            return;
        }
        if (length != 1) {
            new RaceValuesCoordinator(length).subscribe(bVarArr, length, coreSubscriber);
            return;
        }
        Flux fluxFrom = Flux.from(bVarArr[0]);
        if (fluxFrom == null) {
            Operators.error(coreSubscriber, new NullPointerException("The single source Publisher is null"));
        } else {
            fluxFrom.subscribe((qc.c) coreSubscriber);
        }
    }

    @SafeVarargs
    public FluxFirstWithValue(qc.b<? extends T> bVar, qc.b<? extends T>... bVarArr) {
        Objects.requireNonNull(bVar, AMapLocationStaticsEntity.FIRST_LOCATE);
        Objects.requireNonNull(bVarArr, "others");
        qc.b<? extends T>[] bVarArr2 = new qc.b[bVarArr.length + 1];
        bVarArr2[0] = bVar;
        System.arraycopy(bVarArr, 0, bVarArr2, 1, bVarArr.length);
        this.array = bVarArr2;
        this.iterable = null;
    }

    public FluxFirstWithValue(Iterable<? extends qc.b<? extends T>> iterable) {
        this.array = null;
        Objects.requireNonNull(iterable);
        this.iterable = iterable;
    }
}

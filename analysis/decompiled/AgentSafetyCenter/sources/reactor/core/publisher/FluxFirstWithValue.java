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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxFirstWithValue<T> extends Flux<T> implements SourceProducer<T> {
    final qd.c[] array;
    final Iterable<? extends qd.c> iterable;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.won) {
                this.actual.onComplete();
            } else {
                recordTerminalSignals(new NoSuchElementException(k0.a.r(new StringBuilder("source at index "), this.index, " completed empty")));
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else {
                recordTerminalSignals(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.won) {
                this.actual.onNext(t10);
            } else if (this.parent.tryWin(this.index)) {
                this.won = true;
                this.actual.onNext(t10);
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
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
            return attr == Scannable.Attr.PARENT ? this.f10744s : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.parent.cancelled) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class RaceValuesCoordinator<T> implements qd.e, Scannable {
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

        @Override // qd.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            int i = this.winner;
            FirstValuesEmittingSubscriber<T>[] firstValuesEmittingSubscriberArr = this.subscribers;
            if (i >= 0) {
                firstValuesEmittingSubscriberArr[i].cancel();
                return;
            }
            for (FirstValuesEmittingSubscriber<T> firstValuesEmittingSubscriber : firstValuesEmittingSubscriberArr) {
                firstValuesEmittingSubscriber.cancel();
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) this.subscribers);
        }

        @Override // qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                int i = this.winner;
                FirstValuesEmittingSubscriber<T>[] firstValuesEmittingSubscriberArr = this.subscribers;
                if (i >= 0) {
                    firstValuesEmittingSubscriberArr[i].request(j10);
                    return;
                }
                for (FirstValuesEmittingSubscriber<T> firstValuesEmittingSubscriber : firstValuesEmittingSubscriberArr) {
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

        public void subscribe(qd.c[] cVarArr, int i, CoreSubscriber<? super T> coreSubscriber) {
            for (int i3 = 0; i3 < i; i3++) {
                this.subscribers[i3] = new FirstValuesEmittingSubscriber<>(coreSubscriber, this, i3);
            }
            coreSubscriber.onSubscribe(this);
            Operators.toFluxOrMono(cVarArr);
            for (int i10 = 0; i10 < i && !this.cancelled && this.winner == Integer.MIN_VALUE; i10++) {
                qd.c cVar = cVarArr[i10];
                if (cVar == null) {
                    coreSubscriber.onError(new NullPointerException(k0.a.k(i10, "The ", " th Publisher source is null")));
                    return;
                }
                cVar.subscribe(this.subscribers[i10]);
            }
        }

        public boolean tryWin(int i) {
            int i3 = 0;
            if (this.winner != Integer.MIN_VALUE || !WINNER.compareAndSet(this, Integer.MIN_VALUE, i)) {
                return false;
            }
            while (true) {
                FirstValuesEmittingSubscriber<T>[] firstValuesEmittingSubscriberArr = this.subscribers;
                if (i3 >= firstValuesEmittingSubscriberArr.length) {
                    return true;
                }
                if (i3 != i) {
                    firstValuesEmittingSubscriberArr[i3].cancel();
                    this.errorsOrCompleteEmpty[i3] = null;
                }
                i3++;
            }
        }
    }

    @SafeVarargs
    public FluxFirstWithValue(qd.c cVar, qd.c... cVarArr) {
        Objects.requireNonNull(cVar, "first");
        Objects.requireNonNull(cVarArr, "others");
        qd.c[] cVarArr2 = new qd.c[cVarArr.length + 1];
        cVarArr2[0] = cVar;
        System.arraycopy(cVarArr, 0, cVarArr2, 1, cVarArr.length);
        this.array = cVarArr2;
        this.iterable = null;
    }

    @SafeVarargs
    @Nullable
    public final FluxFirstWithValue<T> firstValuedAdditionalSources(qd.c... cVarArr) {
        Objects.requireNonNull(cVarArr, "others");
        if (cVarArr.length == 0) {
            return this;
        }
        qd.c[] cVarArr2 = this.array;
        if (cVarArr2 == null) {
            return null;
        }
        int length = cVarArr2.length;
        int length2 = cVarArr.length;
        qd.c[] cVarArr3 = new qd.c[length + length2];
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
        qd.c[] cVarArr = this.array;
        if (cVarArr == null) {
            cVarArr = new qd.c[8];
            try {
                Iterator<? extends qd.c> it = this.iterable.iterator();
                Objects.requireNonNull(it, "The iterator returned is null");
                Iterator<? extends qd.c> it2 = it;
                length = 0;
                while (it2.hasNext()) {
                    try {
                        try {
                            qd.c next = it2.next();
                            Objects.requireNonNull(next, "The Publisher returned by the iterator is null");
                            qd.c cVar = next;
                            if (length == cVarArr.length) {
                                qd.c[] cVarArr2 = new qd.c[(length >> 2) + length];
                                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                                cVarArr = cVarArr2;
                            }
                            cVarArr[length] = cVar;
                            length++;
                        } catch (Throwable th) {
                            k0.a.B(coreSubscriber, th, coreSubscriber);
                            return;
                        }
                    } catch (Throwable th2) {
                        k0.a.B(coreSubscriber, th2, coreSubscriber);
                        return;
                    }
                }
            } catch (Throwable th3) {
                k0.a.B(coreSubscriber, th3, coreSubscriber);
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
            fluxFrom.subscribe((qd.d) coreSubscriber);
        }
    }

    private FluxFirstWithValue(qd.c[] cVarArr) {
        Objects.requireNonNull(cVarArr, "array");
        this.array = cVarArr;
        this.iterable = null;
    }

    public FluxFirstWithValue(Iterable<? extends qd.c> iterable) {
        this.array = null;
        Objects.requireNonNull(iterable);
        this.iterable = iterable;
    }
}

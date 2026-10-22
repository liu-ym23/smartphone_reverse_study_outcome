package reactor.core.publisher;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class FluxFirstWithSignal<T> extends Flux<T> implements SourceProducer<T> {
    final qc.b<? extends T>[] array;
    final Iterable<? extends qc.b<? extends T>> iterable;

    public static final class FirstEmittingSubscriber<T> extends Operators.DeferredSubscription implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        final int index;
        final RaceCoordinator<T> parent;
        boolean won;

        public FirstEmittingSubscriber(CoreSubscriber<? super T> coreSubscriber, RaceCoordinator<T> raceCoordinator, int i10) {
            this.actual = coreSubscriber;
            this.parent = raceCoordinator;
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
            } else if (this.parent.tryWin(this.index)) {
                this.won = true;
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else if (this.parent.tryWin(this.index)) {
                this.won = true;
                this.actual.onError(th);
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

        @Override // reactor.core.publisher.Operators.DeferredSubscription, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39688s : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.parent.cancelled) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class RaceCoordinator<T> implements qc.d, Scannable {
        static final AtomicIntegerFieldUpdater<RaceCoordinator> WINNER = AtomicIntegerFieldUpdater.newUpdater(RaceCoordinator.class, "winner");
        volatile boolean cancelled;
        final FirstEmittingSubscriber<T>[] subscribers;
        volatile int winner = Integer.MIN_VALUE;

        public RaceCoordinator(int i10) {
            this.subscribers = new FirstEmittingSubscriber[i10];
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
            for (FirstEmittingSubscriber<T> firstEmittingSubscriber : this.subscribers) {
                firstEmittingSubscriber.cancel();
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
                for (FirstEmittingSubscriber<T> firstEmittingSubscriber : this.subscribers) {
                    firstEmittingSubscriber.request(j10);
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled);
            }
            return null;
        }

        public void subscribe(qc.b<? extends T>[] bVarArr, int i10, CoreSubscriber<? super T> coreSubscriber) {
            FirstEmittingSubscriber<T>[] firstEmittingSubscriberArr = this.subscribers;
            for (int i11 = 0; i11 < i10; i11++) {
                firstEmittingSubscriberArr[i11] = new FirstEmittingSubscriber<>(coreSubscriber, this, i11);
            }
            coreSubscriber.onSubscribe(this);
            for (int i12 = 0; i12 < i10 && !this.cancelled && this.winner == Integer.MIN_VALUE; i12++) {
                qc.b<? extends T> bVar = bVarArr[i12];
                if (bVar == null) {
                    if (WINNER.compareAndSet(this, Integer.MIN_VALUE, -1)) {
                        coreSubscriber.onError(new NullPointerException("The " + i12 + " th Publisher source is null"));
                        return;
                    }
                    return;
                }
                bVar.subscribe(firstEmittingSubscriberArr[i12]);
            }
        }

        public boolean tryWin(int i10) {
            if (this.winner != Integer.MIN_VALUE || !WINNER.compareAndSet(this, Integer.MIN_VALUE, i10)) {
                return false;
            }
            FirstEmittingSubscriber<T>[] firstEmittingSubscriberArr = this.subscribers;
            int length = firstEmittingSubscriberArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                if (i11 != i10) {
                    firstEmittingSubscriberArr[i11].cancel();
                }
            }
            return true;
        }
    }

    @SafeVarargs
    public FluxFirstWithSignal(qc.b<? extends T>... bVarArr) {
        Objects.requireNonNull(bVarArr, "array");
        this.array = bVarArr;
        this.iterable = null;
    }

    @Nullable
    public FluxFirstWithSignal<T> orAdditionalSource(qc.b<? extends T> bVar) {
        qc.b<? extends T>[] bVarArr = this.array;
        if (bVarArr == null) {
            return null;
        }
        int length = bVarArr.length;
        qc.b[] bVarArr2 = new qc.b[length + 1];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
        bVarArr2[length] = bVar;
        return new FluxFirstWithSignal<>(bVarArr2);
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
            Operators.toFluxOrMono(bVarArr);
            new RaceCoordinator(length).subscribe(bVarArr, length, coreSubscriber);
            return;
        }
        qc.b<? extends T> bVar2 = bVarArr[0];
        if (bVar2 == null) {
            Operators.error(coreSubscriber, new NullPointerException("The single source Publisher is null"));
        } else {
            Operators.toFluxOrMono(bVar2).subscribe((qc.c) coreSubscriber);
        }
    }

    public FluxFirstWithSignal(Iterable<? extends qc.b<? extends T>> iterable) {
        this.array = null;
        Objects.requireNonNull(iterable);
        this.iterable = iterable;
    }
}

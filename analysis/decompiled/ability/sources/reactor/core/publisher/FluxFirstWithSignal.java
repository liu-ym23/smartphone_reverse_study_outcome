package reactor.core.publisher;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxFirstWithSignal<T> extends Flux<T> implements SourceProducer<T> {
    final Z9.c[] array;
    final Iterable<? extends Z9.c> iterable;

    public static final class FirstEmittingSubscriber<T> extends Operators.DeferredSubscription implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        final int index;
        final RaceCoordinator<T> parent;
        boolean won;

        public FirstEmittingSubscriber(CoreSubscriber<? super T> coreSubscriber, RaceCoordinator<T> raceCoordinator, int i) {
            this.actual = coreSubscriber;
            this.parent = raceCoordinator;
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
            } else if (this.parent.tryWin(this.index)) {
                this.won = true;
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else if (this.parent.tryWin(this.index)) {
                this.won = true;
                this.actual.onError(th);
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

        @Override // reactor.core.publisher.Operators.DeferredSubscription, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5876s : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.parent.cancelled) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class RaceCoordinator<T> implements Z9.e, Scannable {
        static final AtomicIntegerFieldUpdater<RaceCoordinator> WINNER = AtomicIntegerFieldUpdater.newUpdater(RaceCoordinator.class, "winner");
        volatile boolean cancelled;
        final FirstEmittingSubscriber<T>[] subscribers;
        volatile int winner = Integer.MIN_VALUE;

        public RaceCoordinator(int i) {
            this.subscribers = new FirstEmittingSubscriber[i];
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
            for (FirstEmittingSubscriber<T> firstEmittingSubscriber : this.subscribers) {
                firstEmittingSubscriber.cancel();
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
                for (FirstEmittingSubscriber<T> firstEmittingSubscriber : this.subscribers) {
                    firstEmittingSubscriber.request(j5);
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

        public void subscribe(Z9.c[] cVarArr, int i, CoreSubscriber<? super T> coreSubscriber) {
            FirstEmittingSubscriber<T>[] firstEmittingSubscriberArr = this.subscribers;
            for (int i6 = 0; i6 < i; i6++) {
                firstEmittingSubscriberArr[i6] = new FirstEmittingSubscriber<>(coreSubscriber, this, i6);
            }
            coreSubscriber.onSubscribe(this);
            for (int i10 = 0; i10 < i && !this.cancelled && this.winner == Integer.MIN_VALUE; i10++) {
                Z9.c cVar = cVarArr[i10];
                if (cVar == null) {
                    if (WINNER.compareAndSet(this, Integer.MIN_VALUE, -1)) {
                        coreSubscriber.onError(new NullPointerException(androidx.appfunctions.metadata.a.i(i10, "The ", " th Publisher source is null")));
                        return;
                    }
                    return;
                }
                cVar.subscribe(firstEmittingSubscriberArr[i10]);
            }
        }

        public boolean tryWin(int i) {
            if (this.winner != Integer.MIN_VALUE || !WINNER.compareAndSet(this, Integer.MIN_VALUE, i)) {
                return false;
            }
            FirstEmittingSubscriber<T>[] firstEmittingSubscriberArr = this.subscribers;
            int length = firstEmittingSubscriberArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                if (i6 != i) {
                    firstEmittingSubscriberArr[i6].cancel();
                }
            }
            return true;
        }
    }

    @SafeVarargs
    public FluxFirstWithSignal(Z9.c... cVarArr) {
        Objects.requireNonNull(cVarArr, "array");
        this.array = cVarArr;
        this.iterable = null;
    }

    @Nullable
    public FluxFirstWithSignal<T> orAdditionalSource(Z9.c cVar) {
        Z9.c[] cVarArr = this.array;
        if (cVarArr == null) {
            return null;
        }
        int length = cVarArr.length;
        Z9.c[] cVarArr2 = new Z9.c[length + 1];
        System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
        cVarArr2[length] = cVar;
        return new FluxFirstWithSignal<>(cVarArr2);
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
            Operators.toFluxOrMono(cVarArr);
            new RaceCoordinator(length).subscribe(cVarArr, length, coreSubscriber);
            return;
        }
        Z9.c cVar2 = cVarArr[0];
        if (cVar2 == null) {
            Operators.error(coreSubscriber, new NullPointerException("The single source Publisher is null"));
        } else {
            Operators.toFluxOrMono(cVar2).subscribe((Z9.d) coreSubscriber);
        }
    }

    public FluxFirstWithSignal(Iterable<? extends Z9.c> iterable) {
        this.array = null;
        Objects.requireNonNull(iterable);
        this.iterable = iterable;
    }
}

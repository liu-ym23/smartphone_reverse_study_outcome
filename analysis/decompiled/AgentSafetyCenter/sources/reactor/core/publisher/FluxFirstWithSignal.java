package reactor.core.publisher;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxFirstWithSignal<T> extends Flux<T> implements SourceProducer<T> {
    final qd.c[] array;
    final Iterable<? extends qd.c> iterable;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.won) {
                this.actual.onComplete();
            } else if (this.parent.tryWin(this.index)) {
                this.won = true;
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else if (this.parent.tryWin(this.index)) {
                this.won = true;
                this.actual.onError(th);
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

        @Override // reactor.core.publisher.Operators.DeferredSubscription, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10744s : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.parent.cancelled) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class RaceCoordinator<T> implements qd.e, Scannable {
        static final AtomicIntegerFieldUpdater<RaceCoordinator> WINNER = AtomicIntegerFieldUpdater.newUpdater(RaceCoordinator.class, "winner");
        volatile boolean cancelled;
        final FirstEmittingSubscriber<T>[] subscribers;
        volatile int winner = Integer.MIN_VALUE;

        public RaceCoordinator(int i) {
            this.subscribers = new FirstEmittingSubscriber[i];
        }

        @Override // qd.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            int i = this.winner;
            FirstEmittingSubscriber<T>[] firstEmittingSubscriberArr = this.subscribers;
            if (i >= 0) {
                firstEmittingSubscriberArr[i].cancel();
                return;
            }
            for (FirstEmittingSubscriber<T> firstEmittingSubscriber : firstEmittingSubscriberArr) {
                firstEmittingSubscriber.cancel();
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
                FirstEmittingSubscriber<T>[] firstEmittingSubscriberArr = this.subscribers;
                if (i >= 0) {
                    firstEmittingSubscriberArr[i].request(j10);
                    return;
                }
                for (FirstEmittingSubscriber<T> firstEmittingSubscriber : firstEmittingSubscriberArr) {
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

        public void subscribe(qd.c[] cVarArr, int i, CoreSubscriber<? super T> coreSubscriber) {
            FirstEmittingSubscriber<T>[] firstEmittingSubscriberArr = this.subscribers;
            for (int i3 = 0; i3 < i; i3++) {
                firstEmittingSubscriberArr[i3] = new FirstEmittingSubscriber<>(coreSubscriber, this, i3);
            }
            coreSubscriber.onSubscribe(this);
            for (int i10 = 0; i10 < i && !this.cancelled && this.winner == Integer.MIN_VALUE; i10++) {
                qd.c cVar = cVarArr[i10];
                if (cVar == null) {
                    if (WINNER.compareAndSet(this, Integer.MIN_VALUE, -1)) {
                        coreSubscriber.onError(new NullPointerException(k0.a.k(i10, "The ", " th Publisher source is null")));
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
            for (int i3 = 0; i3 < length; i3++) {
                if (i3 != i) {
                    firstEmittingSubscriberArr[i3].cancel();
                }
            }
            return true;
        }
    }

    @SafeVarargs
    public FluxFirstWithSignal(qd.c... cVarArr) {
        Objects.requireNonNull(cVarArr, "array");
        this.array = cVarArr;
        this.iterable = null;
    }

    @Nullable
    public FluxFirstWithSignal<T> orAdditionalSource(qd.c cVar) {
        qd.c[] cVarArr = this.array;
        if (cVarArr == null) {
            return null;
        }
        int length = cVarArr.length;
        qd.c[] cVarArr2 = new qd.c[length + 1];
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
            Operators.toFluxOrMono(cVarArr);
            new RaceCoordinator(length).subscribe(cVarArr, length, coreSubscriber);
            return;
        }
        qd.c cVar2 = cVarArr[0];
        if (cVar2 == null) {
            Operators.error(coreSubscriber, new NullPointerException("The single source Publisher is null"));
        } else {
            Operators.toFluxOrMono(cVar2).subscribe((qd.d) coreSubscriber);
        }
    }

    public FluxFirstWithSignal(Iterable<? extends qd.c> iterable) {
        this.array = null;
        Objects.requireNonNull(iterable);
        this.iterable = iterable;
    }
}

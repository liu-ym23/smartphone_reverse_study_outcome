package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class MonoIgnoreThen<T> extends Mono<T> implements Scannable {
    final Z9.c[] ignore;
    final Mono<T> last;

    public static final class ThenIgnoreMain<T> implements InnerOperator<T, T> {
        static final int CANCELLED = 128;
        static final int HAS_COMPLETION = 16;
        static final int HAS_REQUEST = 2;
        static final int HAS_SUBSCRIPTION = 4;
        static final int HAS_VALUE = 8;
        private static final AtomicIntegerFieldUpdater<ThenIgnoreMain> STATE = AtomicIntegerFieldUpdater.newUpdater(ThenIgnoreMain.class, "state");
        Z9.e activeSubscription;
        final CoreSubscriber<? super T> actual;
        boolean done;
        final Z9.c[] ignoreMonos;
        int index;
        final Mono<T> lastMono;
        volatile int state;
        T value;

        public ThenIgnoreMain(CoreSubscriber<? super T> coreSubscriber, Z9.c[] cVarArr, Mono<T> mono) {
            this.actual = coreSubscriber;
            this.ignoreMonos = cVarArr;
            this.lastMono = mono;
        }

        public static boolean hasRequest(int i) {
            return (i & 2) == 2;
        }

        public static boolean hasSubscription(int i) {
            return (i & 4) == 4;
        }

        public static boolean hasValue(int i) {
            return (i & 8) == 8;
        }

        public static boolean isCancelled(int i) {
            return i == 128;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (hasSubscription(markCancelled())) {
                this.activeSubscription.cancel();
            }
        }

        public final void complete(T t9) {
            int i;
            do {
                i = this.state;
                if (isCancelled(i)) {
                    Operators.onDiscard(t9, this.actual.currentContext());
                    return;
                } else {
                    if (hasRequest(i) && STATE.compareAndSet(this, i, i | 24)) {
                        CoreSubscriber<? super T> coreSubscriber = this.actual;
                        coreSubscriber.onNext(t9);
                        coreSubscriber.onComplete();
                        return;
                    }
                    this.value = t9;
                }
            } while (!STATE.compareAndSet(this, i, i | 24));
        }

        public final int markCancelled() {
            int i;
            do {
                i = this.state;
                if (i == 128) {
                    break;
                }
            } while (!STATE.compareAndSet(this, i, 128));
            return i;
        }

        public final int markHasSubscription() {
            int i;
            do {
                i = this.state;
                if (i == 128 || (i & 4) == 4) {
                    break;
                }
            } while (!STATE.compareAndSet(this, i, i | 4));
            return i;
        }

        public final int markUnsubscribed() {
            int i;
            do {
                i = this.state;
                if (isCancelled(i) || !hasSubscription(i)) {
                    break;
                }
            } while (!STATE.compareAndSet(this, i, i & (-5)));
            return i;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            if (this.index == this.ignoreMonos.length) {
                this.done = true;
                this.actual.onComplete();
            } else {
                if (isCancelled(markUnsubscribed())) {
                    return;
                }
                this.activeSubscription = null;
                this.index++;
                subscribeNext();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, actual().currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onDiscard(t9, currentContext());
            } else if (this.index != this.ignoreMonos.length) {
                Operators.onDiscard(t9, currentContext());
            } else {
                this.done = true;
                complete(t9);
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.activeSubscription, eVar)) {
                this.activeSubscription = eVar;
                if (isCancelled(markHasSubscription())) {
                    eVar.cancel();
                } else {
                    eVar.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            int i;
            if (Operators.validate(j5)) {
                do {
                    i = this.state;
                    if (isCancelled(i) || hasRequest(i)) {
                        return;
                    }
                } while (!STATE.compareAndSet(this, i, i | 2));
                if (hasValue(i)) {
                    CoreSubscriber<? super T> coreSubscriber = this.actual;
                    coreSubscriber.onNext(this.value);
                    coreSubscriber.onComplete();
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.activeSubscription : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(isCancelled(this.state)) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void subscribeNext() {
            Z9.c[] cVarArr = this.ignoreMonos;
            while (true) {
                int i = this.index;
                if (i == cVarArr.length) {
                    Mono<T> mono = this.lastMono;
                    if (!(mono instanceof Callable)) {
                        Operators.toFluxOrMono(mono).subscribe((CoreSubscriber) this);
                        return;
                    }
                    if (isCancelled(this.state)) {
                        return;
                    }
                    try {
                        Object objCall = ((Callable) mono).call();
                        if (objCall != null) {
                            onNext(objCall);
                        }
                        onComplete();
                        return;
                    } catch (Throwable th) {
                        onError(Operators.onOperatorError(th, currentContext()));
                        return;
                    }
                }
                Z9.c cVar = cVarArr[i];
                if (!(cVar instanceof Callable)) {
                    Operators.toFluxOrMono(cVar).subscribe((Z9.d) this);
                    return;
                } else {
                    if (isCancelled(this.state)) {
                        return;
                    }
                    try {
                        Operators.onDiscard(((Callable) cVar).call(), currentContext());
                        this.index = i + 1;
                    } catch (Throwable th2) {
                        onError(Operators.onOperatorError(th2, currentContext()));
                        return;
                    }
                }
            }
        }
    }

    public MonoIgnoreThen(Z9.c[] cVarArr, Mono<T> mono) {
        Objects.requireNonNull(cVarArr, "ignore");
        this.ignore = cVarArr;
        Objects.requireNonNull(mono, "last");
        this.last = mono;
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    public <U> MonoIgnoreThen<U> shift(Mono<U> mono) {
        Objects.requireNonNull(mono, "newLast");
        Z9.c[] cVarArr = this.ignore;
        int length = cVarArr.length;
        Z9.c[] cVarArr2 = new Z9.c[length + 1];
        System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
        cVarArr2[length] = this.last;
        return new MonoIgnoreThen<>(cVarArr2, mono);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        ThenIgnoreMain thenIgnoreMain = new ThenIgnoreMain(coreSubscriber, this.ignore, this.last);
        coreSubscriber.onSubscribe(thenIgnoreMain);
        thenIgnoreMain.subscribeNext();
    }
}

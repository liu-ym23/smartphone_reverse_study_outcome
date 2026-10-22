package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoIgnoreThen<T> extends Mono<T> implements Scannable {
    final qd.c[] ignore;
    final Mono<T> last;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ThenIgnoreMain<T> implements InnerOperator<T, T> {
        static final int CANCELLED = 128;
        static final int HAS_COMPLETION = 16;
        static final int HAS_REQUEST = 2;
        static final int HAS_SUBSCRIPTION = 4;
        static final int HAS_VALUE = 8;
        private static final AtomicIntegerFieldUpdater<ThenIgnoreMain> STATE = AtomicIntegerFieldUpdater.newUpdater(ThenIgnoreMain.class, "state");
        qd.e activeSubscription;
        final CoreSubscriber<? super T> actual;
        boolean done;
        final qd.c[] ignoreMonos;
        int index;
        final Mono<T> lastMono;
        volatile int state;
        T value;

        public ThenIgnoreMain(CoreSubscriber<? super T> coreSubscriber, qd.c[] cVarArr, Mono<T> mono) {
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
            return i == CANCELLED;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            if (hasSubscription(markCancelled())) {
                this.activeSubscription.cancel();
            }
        }

        public final void complete(T t10) {
            int i;
            do {
                i = this.state;
                if (isCancelled(i)) {
                    Operators.onDiscard(t10, this.actual.currentContext());
                    return;
                } else {
                    if (hasRequest(i) && STATE.compareAndSet(this, i, i | 24)) {
                        CoreSubscriber<? super T> coreSubscriber = this.actual;
                        coreSubscriber.onNext(t10);
                        coreSubscriber.onComplete();
                        return;
                    }
                    this.value = t10;
                }
            } while (!STATE.compareAndSet(this, i, i | 24));
        }

        public final int markCancelled() {
            int i;
            do {
                i = this.state;
                if (i == CANCELLED) {
                    break;
                }
            } while (!STATE.compareAndSet(this, i, CANCELLED));
            return i;
        }

        public final int markHasSubscription() {
            int i;
            do {
                i = this.state;
                if (i == CANCELLED || (i & 4) == 4) {
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, actual().currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onDiscard(t10, currentContext());
            } else if (this.index != this.ignoreMonos.length) {
                Operators.onDiscard(t10, currentContext());
            } else {
                this.done = true;
                complete(t10);
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.activeSubscription, eVar)) {
                this.activeSubscription = eVar;
                if (isCancelled(markHasSubscription())) {
                    eVar.cancel();
                } else {
                    eVar.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            int i;
            if (Operators.validate(j10)) {
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
            qd.c[] cVarArr = this.ignoreMonos;
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
                qd.c cVar = cVarArr[i];
                if (!(cVar instanceof Callable)) {
                    Operators.toFluxOrMono(cVar).subscribe((qd.d) this);
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

    public MonoIgnoreThen(qd.c[] cVarArr, Mono<T> mono) {
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
        qd.c[] cVarArr = this.ignore;
        int length = cVarArr.length;
        qd.c[] cVarArr2 = new qd.c[length + 1];
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

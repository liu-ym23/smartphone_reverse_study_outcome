package reactor.core.publisher;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class MonoIgnoreThen<T> extends Mono<T> implements Scannable {
    final qc.b<?>[] ignore;
    final Mono<T> last;

    public static final class ThenIgnoreMain<T> implements InnerOperator<T, T> {
        static final int CANCELLED = 128;
        static final int HAS_COMPLETION = 16;
        static final int HAS_REQUEST = 2;
        static final int HAS_SUBSCRIPTION = 4;
        static final int HAS_VALUE = 8;
        private static final AtomicIntegerFieldUpdater<ThenIgnoreMain> STATE = AtomicIntegerFieldUpdater.newUpdater(ThenIgnoreMain.class, VoiceWakeupReceiver.EXTRA_STATE);
        qc.d activeSubscription;
        final CoreSubscriber<? super T> actual;
        boolean done;
        final qc.b<?>[] ignoreMonos;
        int index;
        final Mono<T> lastMono;
        volatile int state;
        T value;

        public ThenIgnoreMain(CoreSubscriber<? super T> coreSubscriber, qc.b<?>[] bVarArr, Mono<T> mono) {
            this.actual = coreSubscriber;
            this.ignoreMonos = bVarArr;
            this.lastMono = mono;
        }

        public static boolean hasRequest(int i10) {
            return (i10 & 2) == 2;
        }

        public static boolean hasSubscription(int i10) {
            return (i10 & 4) == 4;
        }

        public static boolean hasValue(int i10) {
            return (i10 & 8) == 8;
        }

        public static boolean isCancelled(int i10) {
            return i10 == 128;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            if (hasSubscription(markCancelled())) {
                this.activeSubscription.cancel();
            }
        }

        public final void complete(T t10) {
            int i10;
            do {
                i10 = this.state;
                if (isCancelled(i10)) {
                    Operators.onDiscard(t10, this.actual.currentContext());
                    return;
                } else {
                    if (hasRequest(i10) && STATE.compareAndSet(this, i10, i10 | 24)) {
                        CoreSubscriber<? super T> coreSubscriber = this.actual;
                        coreSubscriber.onNext(t10);
                        coreSubscriber.onComplete();
                        return;
                    }
                    this.value = t10;
                }
            } while (!STATE.compareAndSet(this, i10, i10 | 24));
        }

        public final int markCancelled() {
            int i10;
            do {
                i10 = this.state;
                if (i10 == 128) {
                    break;
                }
            } while (!STATE.compareAndSet(this, i10, 128));
            return i10;
        }

        public final int markHasSubscription() {
            int i10;
            do {
                i10 = this.state;
                if (i10 == 128 || (i10 & 4) == 4) {
                    break;
                }
            } while (!STATE.compareAndSet(this, i10, i10 | 4));
            return i10;
        }

        public final int markUnsubscribed() {
            int i10;
            do {
                i10 = this.state;
                if (isCancelled(i10) || !hasSubscription(i10)) {
                    break;
                }
            } while (!STATE.compareAndSet(this, i10, i10 & (-5)));
            return i10;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, actual().currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
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

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.activeSubscription, dVar)) {
                this.activeSubscription = dVar;
                if (isCancelled(markHasSubscription())) {
                    dVar.cancel();
                } else {
                    dVar.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            int i10;
            if (Operators.validate(j10)) {
                do {
                    i10 = this.state;
                    if (isCancelled(i10) || hasRequest(i10)) {
                        return;
                    }
                } while (!STATE.compareAndSet(this, i10, i10 | 2));
                if (hasValue(i10)) {
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
            qc.b<?>[] bVarArr = this.ignoreMonos;
            while (true) {
                int i10 = this.index;
                if (i10 == bVarArr.length) {
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
                qc.b<?> bVar = bVarArr[i10];
                if (!(bVar instanceof Callable)) {
                    Operators.toFluxOrMono(bVar).subscribe((qc.c) this);
                    return;
                } else {
                    if (isCancelled(this.state)) {
                        return;
                    }
                    try {
                        Operators.onDiscard(((Callable) bVar).call(), currentContext());
                        this.index = i10 + 1;
                    } catch (Throwable th2) {
                        onError(Operators.onOperatorError(th2, currentContext()));
                        return;
                    }
                }
            }
        }
    }

    public MonoIgnoreThen(qc.b<?>[] bVarArr, Mono<T> mono) {
        Objects.requireNonNull(bVarArr, "ignore");
        this.ignore = bVarArr;
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
        qc.b<?>[] bVarArr = this.ignore;
        int length = bVarArr.length;
        qc.b[] bVarArr2 = new qc.b[length + 1];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
        bVarArr2[length] = this.last;
        return new MonoIgnoreThen<>(bVarArr2, mono);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        ThenIgnoreMain thenIgnoreMain = new ThenIgnoreMain(coreSubscriber, this.ignore, this.last);
        coreSubscriber.onSubscribe(thenIgnoreMain);
        thenIgnoreMain.subscribeNext();
    }
}

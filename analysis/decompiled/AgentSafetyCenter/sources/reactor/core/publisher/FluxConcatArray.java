package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxConcatArray<T> extends Flux<T> implements SourceProducer<T> {
    final qd.c[] array;
    final boolean delayError;
    static final Object WORKING = new Object();
    static final Object DONE = new Object();

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ConcatArrayDelayErrorSubscriber<T> extends ThreadLocal<Object> implements InnerOperator<T, T>, SubscriptionAware {
        final CoreSubscriber<? super T> actual;
        volatile boolean cancelled;
        volatile Throwable error;
        int index;
        long produced;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10595s;
        final qd.c[] sources;
        static final AtomicLongFieldUpdater<ConcatArrayDelayErrorSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(ConcatArrayDelayErrorSubscriber.class, "requested");
        static final AtomicReferenceFieldUpdater<ConcatArrayDelayErrorSubscriber, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(ConcatArrayDelayErrorSubscriber.class, Throwable.class, "error");

        public ConcatArrayDelayErrorSubscriber(CoreSubscriber<? super T> coreSubscriber, qd.c[] cVarArr) {
            this.actual = coreSubscriber;
            this.sources = cVarArr;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            remove();
            this.cancelled = true;
            if ((this.requested & Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f10595s.cancel();
            }
            Throwable thTerminate = Exceptions.terminate(ERROR, this);
            if (thTerminate != null) {
                Operators.onErrorDropped(thTerminate, this.actual.currentContext());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (get() == FluxConcatArray.WORKING) {
                set(FluxConcatArray.DONE);
                return;
            }
            qd.c[] cVarArr = this.sources;
            do {
                set(FluxConcatArray.WORKING);
                int i = this.index;
                if (i == cVarArr.length) {
                    remove();
                    Throwable thTerminate = Exceptions.terminate(ERROR, this);
                    if (thTerminate == Exceptions.TERMINATED) {
                        return;
                    }
                    CoreSubscriber<? super T> coreSubscriber = this.actual;
                    if (thTerminate != null) {
                        coreSubscriber.onError(thTerminate);
                        return;
                    } else {
                        coreSubscriber.onComplete();
                        return;
                    }
                }
                qd.c cVar = cVarArr[i];
                if (cVar == null) {
                    remove();
                    if (this.cancelled) {
                        return;
                    }
                    NullPointerException nullPointerException = new NullPointerException(k0.a.k(i, "Source Publisher at index ", " is null"));
                    AtomicReferenceFieldUpdater<ConcatArrayDelayErrorSubscriber, Throwable> atomicReferenceFieldUpdater = ERROR;
                    if (!Exceptions.addThrowable(atomicReferenceFieldUpdater, this, nullPointerException)) {
                        Operators.onErrorDropped(nullPointerException, this.actual.currentContext());
                        return;
                    }
                    Throwable thTerminate2 = Exceptions.terminate(atomicReferenceFieldUpdater, this);
                    if (thTerminate2 == Exceptions.TERMINATED) {
                        return;
                    }
                    this.actual.onError(thTerminate2);
                    return;
                }
                long j10 = this.produced;
                if (j10 != 0) {
                    this.produced = 0L;
                    FluxConcatArray.deactivateAndProduce(j10, REQUESTED, this);
                }
                this.index = i + 1;
                if (this.cancelled) {
                    return;
                } else {
                    Operators.toFluxOrMono(cVar).subscribe((qd.d) this);
                }
            } while (get() == FluxConcatArray.DONE);
            remove();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (Exceptions.addThrowable(ERROR, this, th)) {
                onComplete();
            } else {
                remove();
                Operators.onErrorDropped(th, this.actual.currentContext());
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            this.produced++;
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (this.cancelled) {
                remove();
                eVar.cancel();
                return;
            }
            qd.e eVar2 = this.f10595s;
            this.f10595s = eVar;
            if (eVar2 == null) {
                this.actual.onSubscribe(this);
                return;
            }
            long jActivateAndGetRequested = FluxConcatArray.activateAndGetRequested(REQUESTED, this);
            if (jActivateAndGetRequested > 0) {
                eVar.request(jActivateAndGetRequested);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            qd.e eVarAddCapAndGetSubscription = FluxConcatArray.addCapAndGetSubscription(j10, REQUESTED, this);
            if (eVarAddCapAndGetSubscription == null) {
                return;
            }
            eVarAddCapAndGetSubscription.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.DELAY_ERROR) {
                return Boolean.TRUE;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.error == Exceptions.TERMINATED);
            }
            if (attr != Scannable.Attr.ERROR) {
                return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : attr == Scannable.Attr.PARENT ? this.f10595s : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : super.scanUnsafe(attr);
            }
            if (this.error != Exceptions.TERMINATED) {
                return this.error;
            }
            return null;
        }

        @Override // reactor.core.publisher.FluxConcatArray.SubscriptionAware
        public qd.e upstream() {
            return this.f10595s;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ConcatArraySubscriber<T> extends ThreadLocal<Object> implements InnerOperator<T, T>, SubscriptionAware {
        static final AtomicLongFieldUpdater<ConcatArraySubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(ConcatArraySubscriber.class, "requested");
        final CoreSubscriber<? super T> actual;
        volatile boolean cancelled;
        int index;
        long produced;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10596s;
        final qd.c[] sources;

        public ConcatArraySubscriber(CoreSubscriber<? super T> coreSubscriber, qd.c[] cVarArr) {
            this.actual = coreSubscriber;
            this.sources = cVarArr;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            remove();
            this.cancelled = true;
            if ((this.requested & Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f10596s.cancel();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (get() == FluxConcatArray.WORKING) {
                set(FluxConcatArray.DONE);
                return;
            }
            qd.c[] cVarArr = this.sources;
            do {
                set(FluxConcatArray.WORKING);
                int i = this.index;
                if (i == cVarArr.length) {
                    remove();
                    if (this.cancelled) {
                        return;
                    }
                    this.actual.onComplete();
                    return;
                }
                qd.c cVar = cVarArr[i];
                if (cVar == null) {
                    remove();
                    if (this.cancelled) {
                        return;
                    }
                    this.actual.onError(new NullPointerException(k0.a.k(i, "Source Publisher at index ", " is null")));
                    return;
                }
                long j10 = this.produced;
                if (j10 != 0) {
                    this.produced = 0L;
                    FluxConcatArray.deactivateAndProduce(j10, REQUESTED, this);
                }
                this.index = i + 1;
                if (this.cancelled) {
                    return;
                } else {
                    Operators.toFluxOrMono(cVar).subscribe((qd.d) this);
                }
            } while (get() == FluxConcatArray.DONE);
            remove();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            remove();
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            this.produced++;
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (this.cancelled) {
                remove();
                eVar.cancel();
                return;
            }
            qd.e eVar2 = this.f10596s;
            this.f10596s = eVar;
            if (eVar2 == null) {
                this.actual.onSubscribe(this);
                return;
            }
            long jActivateAndGetRequested = FluxConcatArray.activateAndGetRequested(REQUESTED, this);
            if (jActivateAndGetRequested > 0) {
                eVar.request(jActivateAndGetRequested);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            qd.e eVarAddCapAndGetSubscription = FluxConcatArray.addCapAndGetSubscription(j10, REQUESTED, this);
            if (eVarAddCapAndGetSubscription == null) {
                return;
            }
            eVarAddCapAndGetSubscription.request(j10);
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : attr == Scannable.Attr.PARENT ? this.f10596s : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : super.scanUnsafe(attr);
        }

        @Override // reactor.core.publisher.FluxConcatArray.SubscriptionAware
        public qd.e upstream() {
            return this.f10596s;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface SubscriptionAware {
        qd.e upstream();
    }

    @SafeVarargs
    public FluxConcatArray(boolean z10, qd.c... cVarArr) {
        Objects.requireNonNull(cVarArr, "array");
        this.array = cVarArr;
        this.delayError = z10;
    }

    public static <T> long activateAndGetRequested(AtomicLongFieldUpdater<T> atomicLongFieldUpdater, T t10) {
        while (true) {
            long j10 = atomicLongFieldUpdater.get(t10);
            long j11 = j10 & Long.MAX_VALUE;
            AtomicLongFieldUpdater<T> atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            T t11 = t10;
            if (atomicLongFieldUpdater2.compareAndSet(t11, j10, j11)) {
                return j11;
            }
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
            t10 = t11;
        }
    }

    /* JADX WARN: Incorrect types in method signature: <T::Lreactor/core/publisher/FluxConcatArray$SubscriptionAware;>(JLjava/util/concurrent/atomic/AtomicLongFieldUpdater<TT;>;TT;)Lqd/e; */
    @Nullable
    public static qd.e addCapAndGetSubscription(long j10, AtomicLongFieldUpdater atomicLongFieldUpdater, SubscriptionAware subscriptionAware) {
        qd.e eVarUpstream;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(subscriptionAware);
            eVarUpstream = subscriptionAware.upstream();
            long j12 = j11 & Long.MAX_VALUE;
            long j13 = j11 & Long.MIN_VALUE;
            if (j12 != Long.MAX_VALUE) {
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = atomicLongFieldUpdater;
                SubscriptionAware subscriptionAware2 = subscriptionAware;
                if (!atomicLongFieldUpdater2.compareAndSet(subscriptionAware2, j11, Operators.addCap(j12, j10) | j13)) {
                    atomicLongFieldUpdater = atomicLongFieldUpdater2;
                    subscriptionAware = subscriptionAware2;
                } else if (j13 == Long.MIN_VALUE) {
                    return null;
                }
            } else if (j13 == Long.MIN_VALUE) {
                return null;
            }
        }
        return eVarUpstream;
    }

    public static <T> void deactivateAndProduce(long j10, AtomicLongFieldUpdater<T> atomicLongFieldUpdater, T t10) {
        while (true) {
            long j11 = atomicLongFieldUpdater.get(t10);
            AtomicLongFieldUpdater<T> atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            T t11 = t10;
            if (atomicLongFieldUpdater2.compareAndSet(t11, j11, j11 == Long.MAX_VALUE ? -1L : (j11 - j10) | Long.MIN_VALUE)) {
                return;
            }
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
            t10 = t11;
        }
    }

    public FluxConcatArray<T> concatAdditionalSourceFirst(qd.c cVar) {
        qd.c[] cVarArr = this.array;
        int length = cVarArr.length;
        qd.c[] cVarArr2 = new qd.c[length + 1];
        System.arraycopy(cVarArr, 0, cVarArr2, 1, length);
        cVarArr2[0] = cVar;
        return new FluxConcatArray<>(this.delayError, cVarArr2);
    }

    public FluxConcatArray<T> concatAdditionalSourceLast(qd.c cVar) {
        qd.c[] cVarArr = this.array;
        int length = cVarArr.length;
        qd.c[] cVarArr2 = new qd.c[length + 1];
        System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
        cVarArr2[length] = cVar;
        return new FluxConcatArray<>(this.delayError, cVarArr2);
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.DELAY_ERROR ? Boolean.valueOf(this.delayError) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        qd.c[] cVarArr = this.array;
        if (cVarArr.length == 0) {
            Operators.complete(coreSubscriber);
            return;
        }
        if (cVarArr.length != 1) {
            if (this.delayError) {
                new ConcatArrayDelayErrorSubscriber(coreSubscriber, cVarArr).onComplete();
                return;
            } else {
                new ConcatArraySubscriber(coreSubscriber, cVarArr).onComplete();
                return;
            }
        }
        qd.c cVar = cVarArr[0];
        if (cVar == null) {
            Operators.error(coreSubscriber, new NullPointerException("The single source Publisher is null"));
        } else {
            Operators.toFluxOrMono(cVar).subscribe((qd.d) coreSubscriber);
        }
    }
}

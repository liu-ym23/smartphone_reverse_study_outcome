package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class FluxConcatArray<T> extends Flux<T> implements SourceProducer<T> {
    final qc.b<? extends T>[] array;
    final boolean delayError;
    static final Object WORKING = new Object();
    static final Object DONE = new Object();

    public static final class ConcatArrayDelayErrorSubscriber<T> extends ThreadLocal<Object> implements InnerOperator<T, T>, SubscriptionAware {
        final CoreSubscriber<? super T> actual;
        volatile boolean cancelled;
        volatile Throwable error;
        int index;
        long produced;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39483s;
        final qc.b<? extends T>[] sources;
        static final AtomicLongFieldUpdater<ConcatArrayDelayErrorSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(ConcatArrayDelayErrorSubscriber.class, "requested");
        static final AtomicReferenceFieldUpdater<ConcatArrayDelayErrorSubscriber, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(ConcatArrayDelayErrorSubscriber.class, Throwable.class, "error");

        public ConcatArrayDelayErrorSubscriber(CoreSubscriber<? super T> coreSubscriber, qc.b<? extends T>[] bVarArr) {
            this.actual = coreSubscriber;
            this.sources = bVarArr;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            remove();
            this.cancelled = true;
            if ((this.requested & Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f39483s.cancel();
            }
            Throwable thTerminate = Exceptions.terminate(ERROR, this);
            if (thTerminate != null) {
                Operators.onErrorDropped(thTerminate, this.actual.currentContext());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (get() == FluxConcatArray.WORKING) {
                set(FluxConcatArray.DONE);
                return;
            }
            qc.b<? extends T>[] bVarArr = this.sources;
            do {
                set(FluxConcatArray.WORKING);
                int i10 = this.index;
                if (i10 == bVarArr.length) {
                    remove();
                    Throwable thTerminate = Exceptions.terminate(ERROR, this);
                    if (thTerminate == Exceptions.TERMINATED) {
                        return;
                    }
                    if (thTerminate != null) {
                        this.actual.onError(thTerminate);
                        return;
                    } else {
                        this.actual.onComplete();
                        return;
                    }
                }
                qc.b<? extends T> bVar = bVarArr[i10];
                if (bVar == null) {
                    remove();
                    if (this.cancelled) {
                        return;
                    }
                    NullPointerException nullPointerException = new NullPointerException("Source Publisher at index " + i10 + " is null");
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
                this.index = i10 + 1;
                if (this.cancelled) {
                    return;
                } else {
                    Operators.toFluxOrMono(bVar).subscribe((qc.c) this);
                }
            } while (get() == FluxConcatArray.DONE);
            remove();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (Exceptions.addThrowable(ERROR, this, th)) {
                onComplete();
            } else {
                remove();
                Operators.onErrorDropped(th, this.actual.currentContext());
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.produced++;
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (this.cancelled) {
                remove();
                dVar.cancel();
                return;
            }
            qc.d dVar2 = this.f39483s;
            this.f39483s = dVar;
            if (dVar2 == null) {
                this.actual.onSubscribe(this);
                return;
            }
            long jActivateAndGetRequested = FluxConcatArray.activateAndGetRequested(REQUESTED, this);
            if (jActivateAndGetRequested > 0) {
                dVar.request(jActivateAndGetRequested);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            qc.d dVarAddCapAndGetSubscription = FluxConcatArray.addCapAndGetSubscription(j10, REQUESTED, this);
            if (dVarAddCapAndGetSubscription == null) {
                return;
            }
            dVarAddCapAndGetSubscription.request(j10);
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
                return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : attr == Scannable.Attr.PARENT ? this.f39483s : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : super.scanUnsafe(attr);
            }
            if (this.error != Exceptions.TERMINATED) {
                return this.error;
            }
            return null;
        }

        @Override // reactor.core.publisher.FluxConcatArray.SubscriptionAware
        public qc.d upstream() {
            return this.f39483s;
        }
    }

    public static final class ConcatArraySubscriber<T> extends ThreadLocal<Object> implements InnerOperator<T, T>, SubscriptionAware {
        static final AtomicLongFieldUpdater<ConcatArraySubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(ConcatArraySubscriber.class, "requested");
        final CoreSubscriber<? super T> actual;
        volatile boolean cancelled;
        int index;
        long produced;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39484s;
        final qc.b<? extends T>[] sources;

        public ConcatArraySubscriber(CoreSubscriber<? super T> coreSubscriber, qc.b<? extends T>[] bVarArr) {
            this.actual = coreSubscriber;
            this.sources = bVarArr;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            remove();
            this.cancelled = true;
            if ((this.requested & Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f39484s.cancel();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (get() == FluxConcatArray.WORKING) {
                set(FluxConcatArray.DONE);
                return;
            }
            qc.b<? extends T>[] bVarArr = this.sources;
            do {
                set(FluxConcatArray.WORKING);
                int i10 = this.index;
                if (i10 == bVarArr.length) {
                    remove();
                    if (this.cancelled) {
                        return;
                    }
                    this.actual.onComplete();
                    return;
                }
                qc.b<? extends T> bVar = bVarArr[i10];
                if (bVar == null) {
                    remove();
                    if (this.cancelled) {
                        return;
                    }
                    this.actual.onError(new NullPointerException("Source Publisher at index " + i10 + " is null"));
                    return;
                }
                long j10 = this.produced;
                if (j10 != 0) {
                    this.produced = 0L;
                    FluxConcatArray.deactivateAndProduce(j10, REQUESTED, this);
                }
                this.index = i10 + 1;
                if (this.cancelled) {
                    return;
                } else {
                    Operators.toFluxOrMono(bVar).subscribe((qc.c) this);
                }
            } while (get() == FluxConcatArray.DONE);
            remove();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            remove();
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.produced++;
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (this.cancelled) {
                remove();
                dVar.cancel();
                return;
            }
            qc.d dVar2 = this.f39484s;
            this.f39484s = dVar;
            if (dVar2 == null) {
                this.actual.onSubscribe(this);
                return;
            }
            long jActivateAndGetRequested = FluxConcatArray.activateAndGetRequested(REQUESTED, this);
            if (jActivateAndGetRequested > 0) {
                dVar.request(jActivateAndGetRequested);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            qc.d dVarAddCapAndGetSubscription = FluxConcatArray.addCapAndGetSubscription(j10, REQUESTED, this);
            if (dVarAddCapAndGetSubscription == null) {
                return;
            }
            dVarAddCapAndGetSubscription.request(j10);
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : attr == Scannable.Attr.PARENT ? this.f39484s : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : super.scanUnsafe(attr);
        }

        @Override // reactor.core.publisher.FluxConcatArray.SubscriptionAware
        public qc.d upstream() {
            return this.f39484s;
        }
    }

    public interface SubscriptionAware {
        qc.d upstream();
    }

    @SafeVarargs
    public FluxConcatArray(boolean z10, qc.b<? extends T>... bVarArr) {
        Objects.requireNonNull(bVarArr, "array");
        this.array = bVarArr;
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

    /* JADX WARN: Incorrect types in method signature: <T::Lreactor/core/publisher/FluxConcatArray$SubscriptionAware;>(JLjava/util/concurrent/atomic/AtomicLongFieldUpdater<TT;>;TT;)Lqc/d; */
    @Nullable
    public static qc.d addCapAndGetSubscription(long j10, AtomicLongFieldUpdater atomicLongFieldUpdater, SubscriptionAware subscriptionAware) {
        qc.d dVarUpstream;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(subscriptionAware);
            dVarUpstream = subscriptionAware.upstream();
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
        return dVarUpstream;
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

    public FluxConcatArray<T> concatAdditionalSourceFirst(qc.b<? extends T> bVar) {
        qc.b<? extends T>[] bVarArr = this.array;
        int length = bVarArr.length;
        qc.b[] bVarArr2 = new qc.b[length + 1];
        System.arraycopy(bVarArr, 0, bVarArr2, 1, length);
        bVarArr2[0] = bVar;
        return new FluxConcatArray<>(this.delayError, bVarArr2);
    }

    public FluxConcatArray<T> concatAdditionalSourceLast(qc.b<? extends T> bVar) {
        qc.b<? extends T>[] bVarArr = this.array;
        int length = bVarArr.length;
        qc.b[] bVarArr2 = new qc.b[length + 1];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
        bVarArr2[length] = bVar;
        return new FluxConcatArray<>(this.delayError, bVarArr2);
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.DELAY_ERROR ? Boolean.valueOf(this.delayError) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        qc.b<? extends T>[] bVarArr = this.array;
        if (bVarArr.length == 0) {
            Operators.complete(coreSubscriber);
            return;
        }
        if (bVarArr.length != 1) {
            if (this.delayError) {
                new ConcatArrayDelayErrorSubscriber(coreSubscriber, bVarArr).onComplete();
                return;
            } else {
                new ConcatArraySubscriber(coreSubscriber, bVarArr).onComplete();
                return;
            }
        }
        qc.b<? extends T> bVar = bVarArr[0];
        if (bVar == null) {
            Operators.error(coreSubscriber, new NullPointerException("The single source Publisher is null"));
        } else {
            Operators.toFluxOrMono(bVar).subscribe((qc.c) coreSubscriber);
        }
    }
}

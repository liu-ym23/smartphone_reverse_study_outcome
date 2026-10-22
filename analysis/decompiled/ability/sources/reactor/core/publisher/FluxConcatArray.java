package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxConcatArray<T> extends Flux<T> implements SourceProducer<T> {
    final Z9.c[] array;
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
        Z9.e f5713s;
        final Z9.c[] sources;
        static final AtomicLongFieldUpdater<ConcatArrayDelayErrorSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(ConcatArrayDelayErrorSubscriber.class, "requested");
        static final AtomicReferenceFieldUpdater<ConcatArrayDelayErrorSubscriber, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(ConcatArrayDelayErrorSubscriber.class, Throwable.class, "error");

        public ConcatArrayDelayErrorSubscriber(CoreSubscriber<? super T> coreSubscriber, Z9.c[] cVarArr) {
            this.actual = coreSubscriber;
            this.sources = cVarArr;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            remove();
            this.cancelled = true;
            if ((this.requested & Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f5713s.cancel();
            }
            Throwable thTerminate = Exceptions.terminate(ERROR, this);
            if (thTerminate != null) {
                Operators.onErrorDropped(thTerminate, this.actual.currentContext());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (get() == FluxConcatArray.WORKING) {
                set(FluxConcatArray.DONE);
                return;
            }
            Z9.c[] cVarArr = this.sources;
            do {
                set(FluxConcatArray.WORKING);
                int i = this.index;
                if (i == cVarArr.length) {
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
                Z9.c cVar = cVarArr[i];
                if (cVar == null) {
                    remove();
                    if (this.cancelled) {
                        return;
                    }
                    NullPointerException nullPointerException = new NullPointerException(androidx.appfunctions.metadata.a.i(i, "Source Publisher at index ", " is null"));
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
                long j5 = this.produced;
                if (j5 != 0) {
                    this.produced = 0L;
                    FluxConcatArray.deactivateAndProduce(j5, REQUESTED, this);
                }
                this.index = i + 1;
                if (this.cancelled) {
                    return;
                } else {
                    Operators.toFluxOrMono(cVar).subscribe((Z9.d) this);
                }
            } while (get() == FluxConcatArray.DONE);
            remove();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (Exceptions.addThrowable(ERROR, this, th)) {
                onComplete();
            } else {
                remove();
                Operators.onErrorDropped(th, this.actual.currentContext());
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.produced++;
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (this.cancelled) {
                remove();
                eVar.cancel();
                return;
            }
            Z9.e eVar2 = this.f5713s;
            this.f5713s = eVar;
            if (eVar2 == null) {
                this.actual.onSubscribe(this);
                return;
            }
            long jActivateAndGetRequested = FluxConcatArray.activateAndGetRequested(REQUESTED, this);
            if (jActivateAndGetRequested > 0) {
                eVar.request(jActivateAndGetRequested);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            Z9.e eVarAddCapAndGetSubscription = FluxConcatArray.addCapAndGetSubscription(j5, REQUESTED, this);
            if (eVarAddCapAndGetSubscription == null) {
                return;
            }
            eVarAddCapAndGetSubscription.request(j5);
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
                return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : attr == Scannable.Attr.PARENT ? this.f5713s : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : super.scanUnsafe(attr);
            }
            if (this.error != Exceptions.TERMINATED) {
                return this.error;
            }
            return null;
        }

        @Override // reactor.core.publisher.FluxConcatArray.SubscriptionAware
        public Z9.e upstream() {
            return this.f5713s;
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
        Z9.e f5714s;
        final Z9.c[] sources;

        public ConcatArraySubscriber(CoreSubscriber<? super T> coreSubscriber, Z9.c[] cVarArr) {
            this.actual = coreSubscriber;
            this.sources = cVarArr;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            remove();
            this.cancelled = true;
            if ((this.requested & Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f5714s.cancel();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (get() == FluxConcatArray.WORKING) {
                set(FluxConcatArray.DONE);
                return;
            }
            Z9.c[] cVarArr = this.sources;
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
                Z9.c cVar = cVarArr[i];
                if (cVar == null) {
                    remove();
                    if (this.cancelled) {
                        return;
                    }
                    this.actual.onError(new NullPointerException(androidx.appfunctions.metadata.a.i(i, "Source Publisher at index ", " is null")));
                    return;
                }
                long j5 = this.produced;
                if (j5 != 0) {
                    this.produced = 0L;
                    FluxConcatArray.deactivateAndProduce(j5, REQUESTED, this);
                }
                this.index = i + 1;
                if (this.cancelled) {
                    return;
                } else {
                    Operators.toFluxOrMono(cVar).subscribe((Z9.d) this);
                }
            } while (get() == FluxConcatArray.DONE);
            remove();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            remove();
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.produced++;
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (this.cancelled) {
                remove();
                eVar.cancel();
                return;
            }
            Z9.e eVar2 = this.f5714s;
            this.f5714s = eVar;
            if (eVar2 == null) {
                this.actual.onSubscribe(this);
                return;
            }
            long jActivateAndGetRequested = FluxConcatArray.activateAndGetRequested(REQUESTED, this);
            if (jActivateAndGetRequested > 0) {
                eVar.request(jActivateAndGetRequested);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            Z9.e eVarAddCapAndGetSubscription = FluxConcatArray.addCapAndGetSubscription(j5, REQUESTED, this);
            if (eVarAddCapAndGetSubscription == null) {
                return;
            }
            eVarAddCapAndGetSubscription.request(j5);
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : attr == Scannable.Attr.PARENT ? this.f5714s : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : super.scanUnsafe(attr);
        }

        @Override // reactor.core.publisher.FluxConcatArray.SubscriptionAware
        public Z9.e upstream() {
            return this.f5714s;
        }
    }

    public interface SubscriptionAware {
        Z9.e upstream();
    }

    @SafeVarargs
    public FluxConcatArray(boolean z10, Z9.c... cVarArr) {
        Objects.requireNonNull(cVarArr, "array");
        this.array = cVarArr;
        this.delayError = z10;
    }

    public static <T> long activateAndGetRequested(AtomicLongFieldUpdater<T> atomicLongFieldUpdater, T t9) {
        while (true) {
            long j5 = atomicLongFieldUpdater.get(t9);
            long j6 = j5 & Long.MAX_VALUE;
            AtomicLongFieldUpdater<T> atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            T t10 = t9;
            if (atomicLongFieldUpdater2.compareAndSet(t10, j5, j6)) {
                return j6;
            }
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
            t9 = t10;
        }
    }

    /* JADX WARN: Incorrect types in method signature: <T::Lreactor/core/publisher/FluxConcatArray$SubscriptionAware;>(JLjava/util/concurrent/atomic/AtomicLongFieldUpdater<TT;>;TT;)LZ9/e; */
    @Nullable
    public static Z9.e addCapAndGetSubscription(long j5, AtomicLongFieldUpdater atomicLongFieldUpdater, SubscriptionAware subscriptionAware) {
        Z9.e eVarUpstream;
        while (true) {
            long j6 = atomicLongFieldUpdater.get(subscriptionAware);
            eVarUpstream = subscriptionAware.upstream();
            long j10 = j6 & Long.MAX_VALUE;
            long j11 = j6 & Long.MIN_VALUE;
            if (j10 != Long.MAX_VALUE) {
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = atomicLongFieldUpdater;
                SubscriptionAware subscriptionAware2 = subscriptionAware;
                if (!atomicLongFieldUpdater2.compareAndSet(subscriptionAware2, j6, Operators.addCap(j10, j5) | j11)) {
                    atomicLongFieldUpdater = atomicLongFieldUpdater2;
                    subscriptionAware = subscriptionAware2;
                } else if (j11 == Long.MIN_VALUE) {
                    return null;
                }
            } else if (j11 == Long.MIN_VALUE) {
                return null;
            }
        }
        return eVarUpstream;
    }

    public static <T> void deactivateAndProduce(long j5, AtomicLongFieldUpdater<T> atomicLongFieldUpdater, T t9) {
        while (true) {
            long j6 = atomicLongFieldUpdater.get(t9);
            AtomicLongFieldUpdater<T> atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            T t10 = t9;
            if (atomicLongFieldUpdater2.compareAndSet(t10, j6, j6 == Long.MAX_VALUE ? -1L : (j6 - j5) | Long.MIN_VALUE)) {
                return;
            }
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
            t9 = t10;
        }
    }

    public FluxConcatArray<T> concatAdditionalSourceFirst(Z9.c cVar) {
        Z9.c[] cVarArr = this.array;
        int length = cVarArr.length;
        Z9.c[] cVarArr2 = new Z9.c[length + 1];
        System.arraycopy(cVarArr, 0, cVarArr2, 1, length);
        cVarArr2[0] = cVar;
        return new FluxConcatArray<>(this.delayError, cVarArr2);
    }

    public FluxConcatArray<T> concatAdditionalSourceLast(Z9.c cVar) {
        Z9.c[] cVarArr = this.array;
        int length = cVarArr.length;
        Z9.c[] cVarArr2 = new Z9.c[length + 1];
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
        Z9.c[] cVarArr = this.array;
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
        Z9.c cVar = cVarArr[0];
        if (cVar == null) {
            Operators.error(coreSubscriber, new NullPointerException("The single source Publisher is null"));
        } else {
            Operators.toFluxOrMono(cVar).subscribe((Z9.d) coreSubscriber);
        }
    }
}

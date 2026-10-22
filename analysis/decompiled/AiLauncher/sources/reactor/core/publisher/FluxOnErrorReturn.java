package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.Predicate;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class FluxOnErrorReturn<T> extends InternalFluxOperator<T, T> {

    @Nullable
    final T fallbackValue;

    @Nullable
    final Predicate<? super Throwable> resumableErrorPredicate;

    public static final class ReturnSubscriber<T> implements InnerOperator<T, T> {
        static final AtomicLongFieldUpdater<ReturnSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(ReturnSubscriber.class, "requested");
        private static final byte STATE_CANCELLED = -3;
        private static final byte STATE_PENDING_FALLBACK = -1;
        private static final byte STATE_TERMINATED = -2;
        final CoreSubscriber<? super T> actual;

        @Nullable
        final T fallbackValue;
        volatile long requested;

        @Nullable
        final Predicate<? super Throwable> resumableErrorPredicate;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39541s;
        final boolean trackRequestWhenFallbackDeferred;

        public ReturnSubscriber(CoreSubscriber<? super T> coreSubscriber, @Nullable Predicate<? super Throwable> predicate, @Nullable T t10, boolean z10) {
            this.actual = coreSubscriber;
            this.resumableErrorPredicate = predicate;
            this.fallbackValue = t10;
            this.trackRequestWhenFallbackDeferred = z10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            if (REQUESTED.getAndSet(this, -3L) != -3) {
                this.f39541s.cancel();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.requested != -3) {
                REQUESTED.set(this, -2L);
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            Predicate<? super Throwable> predicate = this.resumableErrorPredicate;
            if (predicate != null && !predicate.test(th)) {
                if (this.requested != -3) {
                    REQUESTED.set(this, -2L);
                    this.actual.onError(th);
                    return;
                }
                return;
            }
            if (this.fallbackValue == null) {
                if (this.requested != -3) {
                    REQUESTED.set(this, -2L);
                    this.actual.onComplete();
                    return;
                }
                return;
            }
            if (this.requested > 0) {
                REQUESTED.set(this, -2L);
                this.actual.onNext(this.fallbackValue);
                this.actual.onComplete();
                return;
            }
            AtomicLongFieldUpdater<ReturnSubscriber> atomicLongFieldUpdater = REQUESTED;
            if (atomicLongFieldUpdater.compareAndSet(this, 0L, -1L) || this.requested <= 0) {
                return;
            }
            atomicLongFieldUpdater.set(this, -2L);
            this.actual.onNext(this.fallbackValue);
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            producedOne();
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39541s, dVar)) {
                this.f39541s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        public void producedOne() {
            while (true) {
                AtomicLongFieldUpdater<ReturnSubscriber> atomicLongFieldUpdater = REQUESTED;
                long j10 = atomicLongFieldUpdater.get(this);
                if (j10 == Long.MAX_VALUE || j10 <= 0) {
                    return;
                }
                ReturnSubscriber<T> returnSubscriber = this;
                if (atomicLongFieldUpdater.compareAndSet(returnSubscriber, j10, j10 - 1)) {
                    return;
                } else {
                    this = returnSubscriber;
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            while (true) {
                AtomicLongFieldUpdater<ReturnSubscriber> atomicLongFieldUpdater = REQUESTED;
                long j11 = atomicLongFieldUpdater.get(this);
                if (j11 == Long.MAX_VALUE || j11 < -1) {
                    return;
                }
                if (j11 == -1) {
                    ReturnSubscriber<T> returnSubscriber = this;
                    if (atomicLongFieldUpdater.compareAndSet(returnSubscriber, j11, -2L)) {
                        T t10 = returnSubscriber.fallbackValue;
                        if (t10 != null) {
                            returnSubscriber.actual.onNext(t10);
                        }
                        returnSubscriber.actual.onComplete();
                        if (returnSubscriber.trackRequestWhenFallbackDeferred) {
                            returnSubscriber.f39541s.request(j10);
                            returnSubscriber.f39541s.cancel();
                            return;
                        }
                        return;
                    }
                    return;
                }
                ReturnSubscriber<T> returnSubscriber2 = this;
                if (atomicLongFieldUpdater.compareAndSet(returnSubscriber2, j11, Operators.addCap(j11, j10))) {
                    returnSubscriber2.f39541s.request(j10);
                    return;
                }
                this = returnSubscriber2;
            }
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.f39541s;
            }
            long j10 = this.requested;
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(j10 == -3);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(j10 == -2);
            }
            if (attr != Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return super.scanUnsafe(attr);
            }
            if (j10 <= 0) {
                j10 = 0;
            }
            return Long.valueOf(j10);
        }
    }

    public FluxOnErrorReturn(Flux<? extends T> flux, @Nullable Predicate<? super Throwable> predicate, @Nullable T t10) {
        super(flux);
        this.resumableErrorPredicate = predicate;
        this.fallbackValue = t10;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new ReturnSubscriber(coreSubscriber, this.resumableErrorPredicate, this.fallbackValue, false);
    }
}

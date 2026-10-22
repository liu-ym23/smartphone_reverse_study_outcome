package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.Predicate;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
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
        Z9.e f5771s;
        final boolean trackRequestWhenFallbackDeferred;

        public ReturnSubscriber(CoreSubscriber<? super T> coreSubscriber, @Nullable Predicate<? super Throwable> predicate, @Nullable T t9, boolean z10) {
            this.actual = coreSubscriber;
            this.resumableErrorPredicate = predicate;
            this.fallbackValue = t9;
            this.trackRequestWhenFallbackDeferred = z10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (REQUESTED.getAndSet(this, -3L) != -3) {
                this.f5771s.cancel();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.requested != -3) {
                REQUESTED.set(this, -2L);
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            producedOne();
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5771s, eVar)) {
                this.f5771s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        public void producedOne() {
            while (true) {
                AtomicLongFieldUpdater<ReturnSubscriber> atomicLongFieldUpdater = REQUESTED;
                long j5 = atomicLongFieldUpdater.get(this);
                if (j5 == Long.MAX_VALUE || j5 <= 0) {
                    return;
                }
                ReturnSubscriber<T> returnSubscriber = this;
                if (atomicLongFieldUpdater.compareAndSet(returnSubscriber, j5, j5 - 1)) {
                    return;
                } else {
                    this = returnSubscriber;
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            while (true) {
                AtomicLongFieldUpdater<ReturnSubscriber> atomicLongFieldUpdater = REQUESTED;
                long j6 = atomicLongFieldUpdater.get(this);
                if (j6 == Long.MAX_VALUE || j6 < -1) {
                    return;
                }
                if (j6 == -1) {
                    ReturnSubscriber<T> returnSubscriber = this;
                    if (atomicLongFieldUpdater.compareAndSet(returnSubscriber, j6, -2L)) {
                        T t9 = returnSubscriber.fallbackValue;
                        if (t9 != null) {
                            returnSubscriber.actual.onNext(t9);
                        }
                        returnSubscriber.actual.onComplete();
                        if (returnSubscriber.trackRequestWhenFallbackDeferred) {
                            returnSubscriber.f5771s.request(j5);
                            returnSubscriber.f5771s.cancel();
                            return;
                        }
                        return;
                    }
                    return;
                }
                ReturnSubscriber<T> returnSubscriber2 = this;
                if (atomicLongFieldUpdater.compareAndSet(returnSubscriber2, j6, Operators.addCap(j6, j5))) {
                    returnSubscriber2.f5771s.request(j5);
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
                return this.f5771s;
            }
            long j5 = this.requested;
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(j5 == -3);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(j5 == -2);
            }
            if (attr != Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return super.scanUnsafe(attr);
            }
            if (j5 <= 0) {
                j5 = 0;
            }
            return Long.valueOf(j5);
        }
    }

    public FluxOnErrorReturn(Flux<? extends T> flux, @Nullable Predicate<? super Throwable> predicate, @Nullable T t9) {
        super(flux);
        this.resumableErrorPredicate = predicate;
        this.fallbackValue = t9;
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

package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.Predicate;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxOnErrorReturn<T> extends InternalFluxOperator<T, T> {

    @Nullable
    final T fallbackValue;

    @Nullable
    final Predicate<? super Throwable> resumableErrorPredicate;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
        qd.e f10651s;
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            if (REQUESTED.getAndSet(this, -3L) != -3) {
                this.f10651s.cancel();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.requested != -3) {
                REQUESTED.set(this, -2L);
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
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
            T t10 = this.fallbackValue;
            long j10 = this.requested;
            if (t10 == null) {
                if (j10 != -3) {
                    REQUESTED.set(this, -2L);
                    this.actual.onComplete();
                    return;
                }
                return;
            }
            if (j10 > 0) {
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            producedOne();
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10651s, eVar)) {
                this.f10651s = eVar;
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
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
                            returnSubscriber.f10651s.request(j10);
                            returnSubscriber.f10651s.cancel();
                            return;
                        }
                        return;
                    }
                    return;
                }
                ReturnSubscriber<T> returnSubscriber2 = this;
                if (atomicLongFieldUpdater.compareAndSet(returnSubscriber2, j11, Operators.addCap(j11, j10))) {
                    returnSubscriber2.f10651s.request(j10);
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
                return this.f10651s;
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

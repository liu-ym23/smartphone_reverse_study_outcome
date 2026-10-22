package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxDefaultIfEmpty<T> extends InternalFluxOperator<T, T> {
    final T value;

    public static final class DefaultIfEmptySubscriber<T> extends Operators.BaseFluxToMonoOperator<T, T> {
        static final AtomicReferenceFieldUpdater<DefaultIfEmptySubscriber, Object> FALLBACK_VALUE = AtomicReferenceFieldUpdater.newUpdater(DefaultIfEmptySubscriber.class, Object.class, "fallbackValue");
        boolean done;
        volatile T fallbackValue;
        boolean hasValue;

        public DefaultIfEmptySubscriber(CoreSubscriber<? super T> coreSubscriber, T t9) {
            super(coreSubscriber);
            FALLBACK_VALUE.lazySet(this, t9);
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator
        public T accumulatedValue() {
            T t9 = this.fallbackValue;
            if (t9 == null || !FALLBACK_VALUE.compareAndSet(this, t9, null)) {
                return null;
            }
            return t9;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            super.cancel();
            T t9 = this.fallbackValue;
            if (t9 == null || !FALLBACK_VALUE.compareAndSet(this, t9, null)) {
                return;
            }
            Operators.onDiscard(t9, this.actual.currentContext());
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            if (this.hasValue) {
                this.actual.onComplete();
            } else {
                completePossiblyEmpty();
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            T t9;
            if (this.done) {
                return;
            }
            this.done = true;
            if (!this.hasValue && (t9 = this.fallbackValue) != null && FALLBACK_VALUE.compareAndSet(this, t9, null)) {
                Operators.onDiscard(th, this.actual.currentContext());
            }
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (!this.hasValue) {
                this.hasValue = true;
                T t10 = this.fallbackValue;
                if (t10 != null && FALLBACK_VALUE.compareAndSet(this, t10, null)) {
                    Operators.onDiscard(t10, this.actual.currentContext());
                }
            }
            this.actual.onNext(t9);
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (!this.hasRequest) {
                this.hasRequest = true;
                int i = this.state;
                if (i != 1 && Operators.BaseFluxToMonoOperator.STATE.compareAndSet(this, i, i | 1) && i > 1) {
                    Object obj = this.fallbackValue;
                    if (obj == null || !FALLBACK_VALUE.compareAndSet(this, obj, null)) {
                        return;
                    }
                    this.actual.onNext(obj);
                    this.actual.onComplete();
                    return;
                }
            }
            this.f5875s.request(j5);
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : super.scanUnsafe(attr);
        }
    }

    public FluxDefaultIfEmpty(Flux<? extends T> flux, T t9) {
        super(flux);
        Objects.requireNonNull(t9, "value");
        this.value = t9;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new DefaultIfEmptySubscriber(coreSubscriber, this.value);
    }
}

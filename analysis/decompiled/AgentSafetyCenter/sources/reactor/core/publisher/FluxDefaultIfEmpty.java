package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxDefaultIfEmpty<T> extends InternalFluxOperator<T, T> {
    final T value;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class DefaultIfEmptySubscriber<T> extends Operators.BaseFluxToMonoOperator<T, T> {
        static final AtomicReferenceFieldUpdater<DefaultIfEmptySubscriber, Object> FALLBACK_VALUE = AtomicReferenceFieldUpdater.newUpdater(DefaultIfEmptySubscriber.class, Object.class, "fallbackValue");
        boolean done;
        volatile T fallbackValue;
        boolean hasValue;

        public DefaultIfEmptySubscriber(CoreSubscriber<? super T> coreSubscriber, T t10) {
            super(coreSubscriber);
            FALLBACK_VALUE.lazySet(this, t10);
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator
        public T accumulatedValue() {
            T t10 = this.fallbackValue;
            if (t10 == null || !FALLBACK_VALUE.compareAndSet(this, t10, null)) {
                return null;
            }
            return t10;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            super.cancel();
            T t10 = this.fallbackValue;
            if (t10 == null || !FALLBACK_VALUE.compareAndSet(this, t10, null)) {
                return;
            }
            Operators.onDiscard(t10, this.actual.currentContext());
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
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

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            T t10;
            if (this.done) {
                return;
            }
            this.done = true;
            if (!this.hasValue && (t10 = this.fallbackValue) != null && FALLBACK_VALUE.compareAndSet(this, t10, null)) {
                Operators.onDiscard(th, this.actual.currentContext());
            }
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (!this.hasValue) {
                this.hasValue = true;
                T t11 = this.fallbackValue;
                if (t11 != null && FALLBACK_VALUE.compareAndSet(this, t11, null)) {
                    Operators.onDiscard(t11, this.actual.currentContext());
                }
            }
            this.actual.onNext(t10);
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
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
            this.f10743s.request(j10);
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : super.scanUnsafe(attr);
        }
    }

    public FluxDefaultIfEmpty(Flux<? extends T> flux, T t10) {
        super(flux);
        Objects.requireNonNull(t10, "value");
        this.value = t10;
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

package reactor.core.publisher;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class FluxDefaultIfEmpty<T> extends InternalFluxOperator<T, T> {
    final T value;

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

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            super.cancel();
            T t10 = this.fallbackValue;
            if (t10 == null || !FALLBACK_VALUE.compareAndSet(this, t10, null)) {
                return;
            }
            Operators.onDiscard(t10, this.actual.currentContext());
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
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

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
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

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
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

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (!this.hasRequest) {
                this.hasRequest = true;
                int i10 = this.state;
                if (i10 != 1 && Operators.BaseFluxToMonoOperator.STATE.compareAndSet(this, i10, i10 | 1) && i10 > 1) {
                    Object obj = this.fallbackValue;
                    if (obj == null || !FALLBACK_VALUE.compareAndSet(this, obj, null)) {
                        return;
                    }
                    this.actual.onNext(obj);
                    this.actual.onComplete();
                    return;
                }
            }
            this.f39687s.request(j10);
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : super.scanUnsafe(attr);
        }
    }

    public FluxDefaultIfEmpty(Flux<? extends T> flux, T t10) {
        super(flux);
        Objects.requireNonNull(t10, UxipConstants.f30680s);
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

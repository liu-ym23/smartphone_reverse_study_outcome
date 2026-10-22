package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class MonoElementAt<T> extends MonoFromFluxOperator<T, T> implements Fuseable {
    final T defaultValue;
    final long index;

    public static final class ElementAtSubscriber<T> extends Operators.BaseFluxToMonoOperator<T, T> {

        @Nullable
        final T defaultValue;
        boolean done;
        long index;
        final long target;

        public ElementAtSubscriber(CoreSubscriber<? super T> coreSubscriber, long j5, @Nullable T t9) {
            super(coreSubscriber);
            this.index = j5;
            this.target = j5;
            this.defaultValue = t9;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator
        public T accumulatedValue() {
            return this.defaultValue;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            if (this.defaultValue != null) {
                completePossiblyEmpty();
                return;
            }
            long j5 = this.target - this.index;
            this.actual.onError(Operators.onOperatorError(new IndexOutOfBoundsException("source had " + j5 + " elements, expected at least " + (this.target + 1)), this.actual.currentContext()));
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            long j5 = this.index;
            if (j5 != 0) {
                this.index = j5 - 1;
                Operators.onDiscard(t9, this.actual.currentContext());
            } else {
                this.done = true;
                this.f5875s.cancel();
                this.actual.onNext(t9);
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : super.scanUnsafe(attr);
        }
    }

    public MonoElementAt(Flux<? extends T> flux, long j5) {
        super(flux);
        if (j5 < 0) {
            throw new IndexOutOfBoundsException(androidx.compose.foundation.b.p(j5, "index >= required but it was "));
        }
        this.index = j5;
        this.defaultValue = null;
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new ElementAtSubscriber(coreSubscriber, this.index, this.defaultValue);
    }

    public MonoElementAt(Flux<? extends T> flux, long j5, T t9) {
        super(flux);
        if (j5 >= 0) {
            this.index = j5;
            Objects.requireNonNull(t9, "defaultValue");
            this.defaultValue = t9;
            return;
        }
        throw new IndexOutOfBoundsException(androidx.compose.foundation.b.p(j5, "index >= required but it was "));
    }
}

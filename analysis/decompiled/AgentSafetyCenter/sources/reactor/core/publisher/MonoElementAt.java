package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoElementAt<T> extends MonoFromFluxOperator<T, T> implements Fuseable {
    final T defaultValue;
    final long index;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ElementAtSubscriber<T> extends Operators.BaseFluxToMonoOperator<T, T> {

        @Nullable
        final T defaultValue;
        boolean done;
        long index;
        final long target;

        public ElementAtSubscriber(CoreSubscriber<? super T> coreSubscriber, long j10, @Nullable T t10) {
            super(coreSubscriber);
            this.index = j10;
            this.target = j10;
            this.defaultValue = t10;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator
        public T accumulatedValue() {
            return this.defaultValue;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            if (this.defaultValue != null) {
                completePossiblyEmpty();
                return;
            }
            long j10 = this.target - this.index;
            this.actual.onError(Operators.onOperatorError(new IndexOutOfBoundsException("source had " + j10 + " elements, expected at least " + (this.target + 1)), this.actual.currentContext()));
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            long j10 = this.index;
            if (j10 != 0) {
                this.index = j10 - 1;
                Operators.onDiscard(t10, this.actual.currentContext());
            } else {
                this.done = true;
                this.f10743s.cancel();
                this.actual.onNext(t10);
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : super.scanUnsafe(attr);
        }
    }

    public MonoElementAt(Flux<? extends T> flux, long j10, T t10) {
        super(flux);
        if (j10 < 0) {
            g5.f.q(k0.a.m("index >= required but it was ", j10));
            throw null;
        }
        this.index = j10;
        Objects.requireNonNull(t10, "defaultValue");
        this.defaultValue = t10;
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new ElementAtSubscriber(coreSubscriber, this.index, this.defaultValue);
    }

    public MonoElementAt(Flux<? extends T> flux, long j10) {
        super(flux);
        if (j10 >= 0) {
            this.index = j10;
            this.defaultValue = null;
        } else {
            g5.f.q(k0.a.m("index >= required but it was ", j10));
            throw null;
        }
    }
}

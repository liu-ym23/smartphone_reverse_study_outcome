package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoHasElements<T> extends MonoFromFluxOperator<T, Boolean> implements Fuseable {
    public MonoHasElements(Flux<? extends T> flux) {
        super(flux);
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super Boolean> coreSubscriber) {
        return new HasElementsSubscriber(coreSubscriber);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class HasElementsSubscriber<T> extends Operators.BaseFluxToMonoOperator<T, Boolean> {
        boolean done;

        public HasElementsSubscriber(CoreSubscriber<? super Boolean> coreSubscriber) {
            super(coreSubscriber);
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            completePossiblyEmpty();
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, currentContext());
            } else {
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            Operators.onDiscard(t10, currentContext());
            if (this.done) {
                return;
            }
            this.f10743s.cancel();
            this.done = true;
            this.actual.onNext(Boolean.TRUE);
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : super.scanUnsafe(attr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator
        public Boolean accumulatedValue() {
            return Boolean.FALSE;
        }
    }
}

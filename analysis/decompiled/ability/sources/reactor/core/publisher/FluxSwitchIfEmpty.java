package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;

/* loaded from: classes4.dex */
final class FluxSwitchIfEmpty<T> extends InternalFluxOperator<T, T> {
    final Z9.c other;

    public static final class SwitchIfEmptySubscriber<T> extends Operators.MultiSubscriptionSubscriber<T, T> {
        boolean once;
        final Z9.c other;

        public SwitchIfEmptySubscriber(CoreSubscriber<? super T> coreSubscriber, Z9.c cVar) {
            super(coreSubscriber);
            this.other = cVar;
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.once) {
                this.actual.onComplete();
            } else {
                this.once = true;
                this.other.subscribe(this);
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (!this.once) {
                this.once = true;
            }
            this.actual.onNext(t9);
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxSwitchIfEmpty(Flux<? extends T> flux, Z9.c cVar) {
        super(flux);
        Objects.requireNonNull(cVar, "other");
        this.other = Operators.toFluxOrMono(cVar);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        SwitchIfEmptySubscriber switchIfEmptySubscriber = new SwitchIfEmptySubscriber(coreSubscriber, this.other);
        coreSubscriber.onSubscribe(switchIfEmptySubscriber);
        return switchIfEmptySubscriber;
    }
}

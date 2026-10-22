package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxDelaySubscription;

/* loaded from: classes5.dex */
final class MonoDelaySubscription<T, U> extends InternalMonoOperator<T, T> implements Consumer<FluxDelaySubscription.DelaySubscriptionOtherSubscriber<T, U>> {
    final qc.b<U> other;

    public MonoDelaySubscription(Mono<? extends T> mono, qc.b<U> bVar) {
        super(mono);
        Objects.requireNonNull(bVar, "other");
        this.other = Operators.toFluxOrMono(bVar);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        this.other.subscribe(new FluxDelaySubscription.DelaySubscriptionOtherSubscriber(coreSubscriber, this));
        return null;
    }

    @Override // java.util.function.Consumer
    public void accept(FluxDelaySubscription.DelaySubscriptionOtherSubscriber<T, U> delaySubscriptionOtherSubscriber) {
        this.source.subscribe((CoreSubscriber) new FluxDelaySubscription.DelaySubscriptionMainSubscriber(delaySubscriptionOtherSubscriber.actual, delaySubscriptionOtherSubscriber));
    }
}

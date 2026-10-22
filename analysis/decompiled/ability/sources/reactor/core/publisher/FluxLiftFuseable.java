package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxHide;
import reactor.core.publisher.Operators;

/* loaded from: classes4.dex */
final class FluxLiftFuseable<I, O> extends InternalFluxOperator<I, O> implements Fuseable {
    final Operators.LiftFunction<I, O> liftFunction;

    public FluxLiftFuseable(Z9.c cVar, Operators.LiftFunction<I, O> liftFunction) {
        super(Flux.from(cVar));
        this.liftFunction = liftFunction;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.from(this.source).scanUnsafe(attr) : attr == Scannable.Attr.LIFTER ? this.liftFunction.name : super.scanUnsafe(attr);
    }

    @Override // reactor.core.Scannable
    public String stepName() {
        Flux<? extends I> flux = this.source;
        return flux instanceof Scannable ? Scannable.from(flux).stepName() : super.stepName();
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super I> subscribeOrReturn(CoreSubscriber<? super O> coreSubscriber) {
        CoreSubscriber<? super I> coreSubscriberApply = this.liftFunction.lifter.apply(this.source, coreSubscriber);
        Objects.requireNonNull(coreSubscriberApply, "Lifted subscriber MUST NOT be null");
        return (!(coreSubscriber instanceof Fuseable.QueueSubscription) || (coreSubscriberApply instanceof Fuseable.QueueSubscription)) ? coreSubscriberApply : new FluxHide.SuppressFuseableSubscriber(coreSubscriberApply);
    }
}

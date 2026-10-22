package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;

/* loaded from: classes5.dex */
final class FluxLift<I, O> extends InternalFluxOperator<I, O> {
    final Operators.LiftFunction<I, O> liftFunction;

    public FluxLift(qc.b<I> bVar, Operators.LiftFunction<I, O> liftFunction) {
        super(Flux.from(bVar));
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
        return coreSubscriberApply;
    }
}

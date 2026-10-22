package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxHide;
import reactor.core.publisher.Operators;

/* loaded from: classes5.dex */
final class MonoLiftFuseable<I, O> extends InternalMonoOperator<I, O> implements Fuseable {
    final Operators.LiftFunction<I, O> liftFunction;

    public MonoLiftFuseable(qc.b<I> bVar, Operators.LiftFunction<I, O> liftFunction) {
        super(Mono.from(bVar));
        this.liftFunction = liftFunction;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.from(this.source).scanUnsafe(attr) : attr == Scannable.Attr.LIFTER ? this.liftFunction.name : super.scanUnsafe(attr);
    }

    @Override // reactor.core.Scannable
    public String stepName() {
        Mono<? extends I> mono = this.source;
        return mono instanceof Scannable ? Scannable.from(mono).stepName() : super.stepName();
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super I> subscribeOrReturn(CoreSubscriber<? super O> coreSubscriber) {
        CoreSubscriber<? super I> coreSubscriberApply = this.liftFunction.lifter.apply(this.source, coreSubscriber);
        Objects.requireNonNull(coreSubscriberApply, "Lifted subscriber MUST NOT be null");
        return (!(coreSubscriber instanceof Fuseable.QueueSubscription) || (coreSubscriberApply instanceof Fuseable.QueueSubscription)) ? coreSubscriberApply : new FluxHide.SuppressFuseableSubscriber(coreSubscriberApply);
    }
}

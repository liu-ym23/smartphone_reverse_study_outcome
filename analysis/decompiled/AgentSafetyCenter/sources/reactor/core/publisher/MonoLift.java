package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoLift<I, O> extends InternalMonoOperator<I, O> {
    final Operators.LiftFunction<I, O> liftFunction;

    public MonoLift(qd.c cVar, Operators.LiftFunction<I, O> liftFunction) {
        super(Mono.from(cVar));
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
        return coreSubscriberApply;
    }
}

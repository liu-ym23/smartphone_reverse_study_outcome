package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxHide;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class ConnectableLiftFuseable<I, O> extends InternalConnectableFluxOperator<I, O> implements Scannable, Fuseable {
    final Operators.LiftFunction<I, O> liftFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectableLiftFuseable(ConnectableFlux<I> connectableFlux, Operators.LiftFunction<I, O> liftFunction) {
        super(connectableFlux);
        Objects.requireNonNull(connectableFlux, "source");
        this.liftFunction = liftFunction;
    }

    @Override // reactor.core.publisher.ConnectableFlux
    public void connect(Consumer<? super Disposable> consumer) {
        this.source.connect(consumer);
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return this.source.getPrefetch();
    }

    @Override // reactor.core.publisher.InternalConnectableFluxOperator, reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.source.getPrefetch()) : attr == Scannable.Attr.PARENT ? this.source : attr == Scannable.Attr.RUN_STYLE ? Scannable.from(this.source).scanUnsafe(attr) : attr == Scannable.Attr.LIFTER ? this.liftFunction.name : super.scanUnsafe(attr);
    }

    @Override // reactor.core.Scannable
    public String stepName() {
        ConnectableFlux<I> connectableFlux = this.source;
        return connectableFlux instanceof Scannable ? Scannable.from(connectableFlux).stepName() : super.stepName();
    }

    @Override // reactor.core.publisher.InternalConnectableFluxOperator, reactor.core.publisher.OptimizableOperator
    public final CoreSubscriber<? super I> subscribeOrReturn(CoreSubscriber<? super O> coreSubscriber) {
        CoreSubscriber<? super I> coreSubscriberApply = this.liftFunction.lifter.apply(this.source, coreSubscriber);
        Objects.requireNonNull(coreSubscriberApply, "Lifted subscriber MUST NOT be null");
        return (!(coreSubscriber instanceof Fuseable.QueueSubscription) || (coreSubscriberApply instanceof Fuseable.QueueSubscription)) ? coreSubscriberApply : new FluxHide.SuppressFuseableSubscriber(coreSubscriberApply);
    }
}

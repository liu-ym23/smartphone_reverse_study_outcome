package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;

/* loaded from: classes4.dex */
final class FluxDoOnEachFuseable<T> extends InternalFluxOperator<T, T> implements Fuseable {
    final Consumer<? super Signal<T>> onSignal;

    public FluxDoOnEachFuseable(Flux<? extends T> flux, Consumer<? super Signal<T>> consumer) {
        super(flux);
        Objects.requireNonNull(consumer, "onSignal");
        this.onSignal = consumer;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return FluxDoOnEach.createSubscriber(coreSubscriber, this.onSignal, true, false);
    }
}

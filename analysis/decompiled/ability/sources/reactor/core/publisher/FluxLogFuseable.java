package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxPeekFuseable;

/* loaded from: classes4.dex */
final class FluxLogFuseable<T> extends InternalFluxOperator<T, T> implements Fuseable {
    final SignalPeek<T> log;

    public FluxLogFuseable(Flux<? extends T> flux, SignalPeek<T> signalPeek) {
        super(flux);
        this.log = signalPeek;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new FluxPeekFuseable.PeekFuseableConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this.log) : new FluxPeekFuseable.PeekFuseableSubscriber(coreSubscriber, this.log);
    }
}

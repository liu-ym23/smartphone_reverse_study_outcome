package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxPeekFuseable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
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
        boolean z10 = coreSubscriber instanceof Fuseable.ConditionalSubscriber;
        SignalPeek<T> signalPeek = this.log;
        return z10 ? new FluxPeekFuseable.PeekFuseableConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, signalPeek) : new FluxPeekFuseable.PeekFuseableSubscriber(coreSubscriber, signalPeek);
    }
}

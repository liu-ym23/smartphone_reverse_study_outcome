package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxPeekFuseable;

/* loaded from: classes4.dex */
final class MonoLogFuseable<T> extends InternalMonoOperator<T, T> implements Fuseable {
    final SignalPeek<T> log;

    public MonoLogFuseable(Mono<? extends T> mono, SignalPeek<T> signalPeek) {
        super(mono);
        this.log = signalPeek;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new FluxPeekFuseable.PeekFuseableConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this.log) : new FluxPeekFuseable.PeekFuseableSubscriber(coreSubscriber, this.log);
    }
}

package reactor.core.publisher;

import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxExpand;

/* loaded from: classes5.dex */
final class MonoExpand<T> extends FluxFromMonoOperator<T, T> {
    final boolean breadthFirst;
    final int capacityHint;
    final Function<? super T, ? extends qc.b<? extends T>> expander;

    public MonoExpand(Mono<T> mono, Function<? super T, ? extends qc.b<? extends T>> function, boolean z10, int i10) {
        super(mono);
        this.expander = function;
        this.breadthFirst = z10;
        this.capacityHint = i10;
    }

    @Override // reactor.core.publisher.FluxFromMonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.FluxFromMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        if (!this.breadthFirst) {
            FluxExpand.ExpandDepthSubscription expandDepthSubscription = new FluxExpand.ExpandDepthSubscription(coreSubscriber, this.expander, this.capacityHint);
            expandDepthSubscription.source = this.source;
            coreSubscriber.onSubscribe(expandDepthSubscription);
            return null;
        }
        FluxExpand.ExpandBreathSubscriber expandBreathSubscriber = new FluxExpand.ExpandBreathSubscriber(coreSubscriber, this.expander, this.capacityHint);
        expandBreathSubscriber.queue.offer(this.source);
        coreSubscriber.onSubscribe(expandBreathSubscriber);
        expandBreathSubscriber.drainQueue();
        return null;
    }
}

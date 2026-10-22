package reactor.core.publisher;

import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxExpand;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoExpand<T> extends FluxFromMonoOperator<T, T> {
    final boolean breadthFirst;
    final int capacityHint;
    final Function<? super T, ? extends qd.c> expander;

    public MonoExpand(Mono<T> mono, Function<? super T, ? extends qd.c> function, boolean z10, int i) {
        super(mono);
        this.expander = function;
        this.breadthFirst = z10;
        this.capacityHint = i;
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

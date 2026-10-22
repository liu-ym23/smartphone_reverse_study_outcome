package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxSourceMonoFuseable<I> extends FluxFromMonoOperator<I, I> implements Fuseable {
    public FluxSourceMonoFuseable(Mono<? extends I> mono) {
        super(mono);
    }

    @Override // reactor.core.publisher.FluxFromMonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.from(this.source).scanUnsafe(attr) : super.scanUnsafe(attr);
    }

    @Override // reactor.core.Scannable
    public String stepName() {
        boolean z10 = this.source instanceof Scannable;
        Mono<? extends I> mono = this.source;
        if (z10) {
            return "FluxFromMono(" + Scannable.from(mono).stepName() + ")";
        }
        return "FluxFromMono(" + mono.toString() + ")";
    }

    @Override // reactor.core.publisher.FluxFromMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super I> subscribeOrReturn(CoreSubscriber<? super I> coreSubscriber) {
        return coreSubscriber;
    }
}

package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxSourceFuseable<I> extends Flux<I> implements Fuseable, SourceProducer<I>, OptimizableOperator<I, I> {

    @Nullable
    final OptimizableOperator<?, I> optimizableOperator;
    final Z9.c source;

    public FluxSourceFuseable(Z9.c cVar) {
        Objects.requireNonNull(cVar);
        this.source = cVar;
        if (cVar instanceof OptimizableOperator) {
            this.optimizableOperator = (OptimizableOperator) cVar;
        } else {
            this.optimizableOperator = null;
        }
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public final OptimizableOperator<?, ? extends I> nextOptimizableSource() {
        return this.optimizableOperator;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.PREFETCH ? Integer.valueOf(getPrefetch()) : attr == Scannable.Attr.PARENT ? this.source : attr == Scannable.Attr.RUN_STYLE ? Scannable.from(this.source).scanUnsafe(attr) : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public final CorePublisher<? extends I> source() {
        return this;
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super I> coreSubscriber) {
        this.source.subscribe(coreSubscriber);
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super I> subscribeOrReturn(CoreSubscriber<? super I> coreSubscriber) {
        return coreSubscriber;
    }
}

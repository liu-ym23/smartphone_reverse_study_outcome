package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class MonoSourceFuseable<I> extends Mono<I> implements Fuseable, Scannable, OptimizableOperator<I, I> {

    @Nullable
    final OptimizableOperator<?, I> optimizableOperator;
    final Z9.c source;

    public MonoSourceFuseable(Z9.c cVar) {
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

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.from(this.source).scanUnsafe(attr);
        }
        return null;
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public final CorePublisher<? extends I> source() {
        return this;
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super I> coreSubscriber) {
        this.source.subscribe(coreSubscriber);
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public final CoreSubscriber<? super I> subscribeOrReturn(CoreSubscriber<? super I> coreSubscriber) {
        return coreSubscriber;
    }
}

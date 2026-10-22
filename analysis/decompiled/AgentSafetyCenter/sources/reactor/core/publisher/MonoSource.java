package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoSource<I> extends Mono<I> implements Scannable, SourceProducer<I>, OptimizableOperator<I, I> {

    @Nullable
    final OptimizableOperator<?, I> optimizableOperator;
    final qd.c source;

    public MonoSource(qd.c cVar) {
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
        return attr == Scannable.Attr.PARENT ? this.source : attr == Scannable.Attr.RUN_STYLE ? Scannable.from(this.source).scanUnsafe(attr) : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super I> coreSubscriber) {
        this.source.subscribe(coreSubscriber);
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super I> subscribeOrReturn(CoreSubscriber<? super I> coreSubscriber) {
        return coreSubscriber;
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public final CorePublisher<? extends I> source() {
        return this;
    }
}

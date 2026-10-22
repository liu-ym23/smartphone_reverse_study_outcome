package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
abstract class MonoFromFluxOperator<I, O> extends Mono<O> implements Scannable, OptimizableOperator<O, I> {

    @Nullable
    final OptimizableOperator<?, I> optimizableOperator;
    protected final Flux<? extends I> source;

    /* JADX WARN: Multi-variable type inference failed */
    public MonoFromFluxOperator(Flux<? extends I> flux) {
        Objects.requireNonNull(flux);
        this.source = flux;
        if (flux instanceof OptimizableOperator) {
            this.optimizableOperator = (OptimizableOperator) flux;
        } else {
            this.optimizableOperator = null;
        }
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public final OptimizableOperator<?, ? extends I> nextOptimizableSource() {
        return this.optimizableOperator;
    }

    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.MAX_VALUE;
        }
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public final CorePublisher<? extends I> source() {
        return this.source;
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public final void subscribe(CoreSubscriber<? super O> coreSubscriber) {
        CoreSubscriber coreSubscriberRestoreContextOnSubscriberIfPublisherNonInternal = coreSubscriber;
        while (true) {
            try {
                CoreSubscriber<? super I> coreSubscriberSubscribeOrReturn = this.subscribeOrReturn(coreSubscriberRestoreContextOnSubscriberIfPublisherNonInternal);
                if (coreSubscriberSubscribeOrReturn == null) {
                    return;
                }
                OptimizableOperator<?, ? extends I> optimizableOperatorNextOptimizableSource = this.nextOptimizableSource();
                if (optimizableOperatorNextOptimizableSource == null) {
                    coreSubscriberRestoreContextOnSubscriberIfPublisherNonInternal = Operators.restoreContextOnSubscriberIfPublisherNonInternal(this.source(), coreSubscriberSubscribeOrReturn);
                    this.source().subscribe((CoreSubscriber<? super Object>) coreSubscriberRestoreContextOnSubscriberIfPublisherNonInternal);
                    return;
                } else {
                    this = optimizableOperatorNextOptimizableSource;
                    coreSubscriberRestoreContextOnSubscriberIfPublisherNonInternal = coreSubscriberSubscribeOrReturn;
                }
            } catch (Throwable th) {
                Operators.reportThrowInSubscribe(coreSubscriberRestoreContextOnSubscriberIfPublisherNonInternal, th);
                return;
            }
        }
    }

    @Nullable
    public abstract CoreSubscriber<? super I> subscribeOrReturn(CoreSubscriber<? super O> coreSubscriber);
}

package reactor.core.publisher;

import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
abstract class InternalFluxOperator<I, O> extends FluxOperator<I, O> implements Scannable, OptimizableOperator<O, I> {

    @Nullable
    final OptimizableOperator<?, I> optimizableOperator;

    /* JADX WARN: Multi-variable type inference failed */
    public InternalFluxOperator(Flux<? extends I> flux) {
        super(flux);
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

    @Override // reactor.core.publisher.FluxOperator, reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.PREFETCH ? Integer.valueOf(getPrefetch()) : attr == Scannable.Attr.PARENT ? this.source : attr == InternalProducerAttr.INSTANCE ? Boolean.TRUE : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.OptimizableOperator
    public final CorePublisher<? extends I> source() {
        return this.source;
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
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
                    CorePublisher<? extends I> corePublisherSource = this.source();
                    coreSubscriberRestoreContextOnSubscriberIfPublisherNonInternal = Operators.restoreContextOnSubscriberIfPublisherNonInternal(corePublisherSource, coreSubscriberSubscribeOrReturn);
                    corePublisherSource.subscribe((CoreSubscriber<? super Object>) coreSubscriberRestoreContextOnSubscriberIfPublisherNonInternal);
                    return;
                }
                this = optimizableOperatorNextOptimizableSource;
                coreSubscriberRestoreContextOnSubscriberIfPublisherNonInternal = coreSubscriberSubscribeOrReturn;
            } catch (Throwable th) {
                Operators.reportThrowInSubscribe(coreSubscriberRestoreContextOnSubscriberIfPublisherNonInternal, th);
                return;
            }
        }
    }

    @Nullable
    public abstract CoreSubscriber<? super I> subscribeOrReturn(CoreSubscriber<? super O> coreSubscriber) throws Throwable;
}

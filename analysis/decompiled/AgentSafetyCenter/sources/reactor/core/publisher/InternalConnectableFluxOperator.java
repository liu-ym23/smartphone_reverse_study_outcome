package reactor.core.publisher;

import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
abstract class InternalConnectableFluxOperator<I, O> extends ConnectableFlux<O> implements Scannable, OptimizableOperator<O, I> {

    @Nullable
    final OptimizableOperator<?, I> optimizableOperator;
    final ConnectableFlux<I> source;

    /* JADX WARN: Multi-variable type inference failed */
    public InternalConnectableFluxOperator(ConnectableFlux<I> connectableFlux) {
        this.source = connectableFlux;
        if (connectableFlux instanceof OptimizableOperator) {
            this.optimizableOperator = (OptimizableOperator) connectableFlux;
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
            return Integer.valueOf(getPrefetch());
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
    public abstract CoreSubscriber<? super I> subscribeOrReturn(CoreSubscriber<? super O> coreSubscriber);
}

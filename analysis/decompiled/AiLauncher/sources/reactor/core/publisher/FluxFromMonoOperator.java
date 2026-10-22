package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
abstract class FluxFromMonoOperator<I, O> extends Flux<O> implements Scannable, OptimizableOperator<O, I> {

    @Nullable
    final OptimizableOperator<?, I> optimizableOperator;
    protected final Mono<? extends I> source;

    /* JADX WARN: Multi-variable type inference failed */
    public FluxFromMonoOperator(Mono<? extends I> mono) {
        Objects.requireNonNull(mono);
        this.source = mono;
        if (mono instanceof OptimizableOperator) {
            this.optimizableOperator = (OptimizableOperator) mono;
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

    @Override // reactor.core.publisher.OptimizableOperator
    @Nullable
    public abstract CoreSubscriber<? super I> subscribeOrReturn(CoreSubscriber<? super O> coreSubscriber) throws Throwable;
}

package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* loaded from: classes5.dex */
final class FluxDeferContextual<T> extends Flux<T> implements SourceProducer<T> {
    final Function<ContextView, ? extends qc.b<? extends T>> contextualPublisherFactory;

    public FluxDeferContextual(Function<ContextView, ? extends qc.b<? extends T>> function) {
        Objects.requireNonNull(function, "contextualPublisherFactory");
        this.contextualPublisherFactory = function;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        Context contextCurrentContext = coreSubscriber.currentContext();
        try {
            qc.b<? extends T> bVarApply = this.contextualPublisherFactory.apply(contextCurrentContext.readOnly());
            Objects.requireNonNull(bVarApply, "The Publisher returned by the contextualPublisherFactory is null");
            Operators.toFluxOrMono(bVarApply).subscribe((CoreSubscriber) coreSubscriber);
        } catch (Throwable th) {
            Operators.error(coreSubscriber, Operators.onOperatorError(th, contextCurrentContext));
        }
    }
}

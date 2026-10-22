package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxDeferContextual<T> extends Flux<T> implements SourceProducer<T> {
    final Function<ContextView, ? extends qd.c> contextualPublisherFactory;

    public FluxDeferContextual(Function<ContextView, ? extends qd.c> function) {
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
            qd.c cVarApply = this.contextualPublisherFactory.apply(contextCurrentContext.readOnly());
            Objects.requireNonNull(cVarApply, "The Publisher returned by the contextualPublisherFactory is null");
            Operators.toFluxOrMono(cVarApply).subscribe((CoreSubscriber) coreSubscriber);
        } catch (Throwable th) {
            Operators.error(coreSubscriber, Operators.onOperatorError(th, contextCurrentContext));
        }
    }
}

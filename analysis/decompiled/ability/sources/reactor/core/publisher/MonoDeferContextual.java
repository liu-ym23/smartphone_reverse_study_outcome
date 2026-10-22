package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* loaded from: classes4.dex */
final class MonoDeferContextual<T> extends Mono<T> implements SourceProducer<T> {
    final Function<ContextView, ? extends Mono<? extends T>> contextualMonoFactory;

    public MonoDeferContextual(Function<ContextView, ? extends Mono<? extends T>> function) {
        Objects.requireNonNull(function, "contextualMonoFactory");
        this.contextualMonoFactory = function;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        Context contextCurrentContext = coreSubscriber.currentContext();
        try {
            Mono<? extends T> monoApply = this.contextualMonoFactory.apply(contextCurrentContext);
            Objects.requireNonNull(monoApply, "The Mono returned by the contextualMonoFactory is null");
            Operators.toFluxOrMono(monoApply).subscribe((CoreSubscriber) coreSubscriber);
        } catch (Throwable th) {
            Operators.error(coreSubscriber, Operators.onOperatorError(th, contextCurrentContext));
        }
    }
}

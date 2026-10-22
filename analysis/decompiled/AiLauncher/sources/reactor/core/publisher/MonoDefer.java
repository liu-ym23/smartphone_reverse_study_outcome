package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;

/* loaded from: classes5.dex */
final class MonoDefer<T> extends Mono<T> implements SourceProducer<T> {
    final Supplier<? extends Mono<? extends T>> supplier;

    public MonoDefer(Supplier<? extends Mono<? extends T>> supplier) {
        Objects.requireNonNull(supplier, "supplier");
        this.supplier = supplier;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        try {
            Mono<? extends T> mono = this.supplier.get();
            Objects.requireNonNull(mono, "The Mono returned by the supplier is null");
            Mono.fromDirect(mono).subscribe((CoreSubscriber) coreSubscriber);
        } catch (Throwable th) {
            Operators.error(coreSubscriber, Operators.onOperatorError(th, coreSubscriber.currentContext()));
        }
    }
}

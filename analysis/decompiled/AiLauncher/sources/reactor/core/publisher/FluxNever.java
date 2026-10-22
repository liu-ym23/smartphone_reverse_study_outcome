package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;

/* loaded from: classes5.dex */
final class FluxNever extends Flux<Object> implements SourceProducer<Object> {
    static final qc.b<Object> INSTANCE = new FluxNever();

    public static <T> Flux<T> instance() {
        return (Flux) INSTANCE;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super Object> coreSubscriber) {
        coreSubscriber.onSubscribe(Operators.emptySubscription());
    }
}

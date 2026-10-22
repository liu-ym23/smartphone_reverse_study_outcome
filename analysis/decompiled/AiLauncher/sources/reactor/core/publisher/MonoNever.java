package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;

/* loaded from: classes5.dex */
final class MonoNever extends Mono<Object> implements SourceProducer<Object> {
    static final Mono<Object> INSTANCE = new MonoNever();

    public static <T> Mono<T> instance() {
        return (Mono<T>) INSTANCE;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super Object> coreSubscriber) {
        coreSubscriber.onSubscribe(Operators.emptySubscription());
    }
}

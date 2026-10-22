package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxEmpty extends Flux<Object> implements Fuseable.ScalarCallable<Object>, SourceProducer<Object> {
    private static final Flux<Object> INSTANCE = new FluxEmpty();

    private FluxEmpty() {
    }

    public static <T> Flux<T> instance() {
        return (Flux<T>) INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    @Nullable
    public Object call() throws Exception {
        return null;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super Object> coreSubscriber) {
        Operators.complete(coreSubscriber);
    }
}

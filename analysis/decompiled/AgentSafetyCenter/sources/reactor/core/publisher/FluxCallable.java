package reactor.core.publisher;

import java.util.concurrent.Callable;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.MonoCallable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxCallable<T> extends Flux<T> implements Callable<T>, Fuseable, SourceProducer<T> {
    final Callable<T> callable;

    public FluxCallable(Callable<T> callable) {
        this.callable = callable;
    }

    @Override // java.util.concurrent.Callable
    @Nullable
    public T call() {
        return this.callable.call();
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        coreSubscriber.onSubscribe(new MonoCallable.MonoCallableSubscription(coreSubscriber, this.callable));
    }
}

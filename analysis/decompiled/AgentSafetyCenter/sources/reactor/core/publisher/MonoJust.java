package reactor.core.publisher;

import java.time.Duration;
import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoJust<T> extends Mono<T> implements Fuseable.ScalarCallable<T>, Fuseable, SourceProducer<T> {
    final T value;

    public MonoJust(T t10) {
        Objects.requireNonNull(t10, "value");
        this.value = t10;
    }

    @Override // reactor.core.publisher.Mono
    public T block(Duration duration) {
        return this.value;
    }

    @Override // java.util.concurrent.Callable
    public T call() {
        return this.value;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.BUFFERED) {
            return 1;
        }
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        coreSubscriber.onSubscribe(Operators.scalarSubscription(coreSubscriber, this.value));
    }

    @Override // reactor.core.publisher.Mono
    public T block() {
        return this.value;
    }
}

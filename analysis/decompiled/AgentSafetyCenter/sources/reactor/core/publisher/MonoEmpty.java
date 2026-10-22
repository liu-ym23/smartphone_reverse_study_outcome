package reactor.core.publisher;

import java.time.Duration;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoEmpty extends Mono<Object> implements Fuseable.ScalarCallable<Object>, SourceProducer<Object> {
    static final qd.c INSTANCE = new MonoEmpty();

    public static <T> Mono<T> instance() {
        return (Mono) INSTANCE;
    }

    @Override // reactor.core.publisher.Mono
    @Nullable
    public Object block() {
        return null;
    }

    @Override // java.util.concurrent.Callable
    @Nullable
    public Object call() {
        return null;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super Object> coreSubscriber) {
        Operators.complete(coreSubscriber);
    }

    @Override // reactor.core.publisher.Mono
    @Nullable
    public Object block(Duration duration) {
        return null;
    }
}

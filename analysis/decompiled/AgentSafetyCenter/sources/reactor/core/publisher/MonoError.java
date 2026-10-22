package reactor.core.publisher;

import java.time.Duration;
import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoError<T> extends Mono<T> implements Fuseable.ScalarCallable, SourceProducer<T> {
    final Throwable error;

    public MonoError(Throwable th) {
        Objects.requireNonNull(th, "error");
        this.error = th;
    }

    @Override // reactor.core.publisher.Mono
    public T block(Duration duration) {
        throw Exceptions.propagate(this.error);
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        Throwable th = this.error;
        if (th instanceof Exception) {
            throw ((Exception) th);
        }
        throw Exceptions.propagate(th);
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        Operators.error(coreSubscriber, this.error);
    }

    @Override // reactor.core.publisher.Mono
    public T block() {
        throw Exceptions.propagate(this.error);
    }
}

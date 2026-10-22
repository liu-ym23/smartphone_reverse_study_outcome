package reactor.core.publisher;

import java.time.Duration;
import java.util.Objects;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoErrorSupplied<T> extends Mono<T> implements Fuseable.ScalarCallable<T>, SourceProducer<T> {
    final Supplier<? extends Throwable> errorSupplier;

    public MonoErrorSupplied(Supplier<? extends Throwable> supplier) {
        Objects.requireNonNull(supplier, "errorSupplier");
        this.errorSupplier = supplier;
    }

    @Override // reactor.core.publisher.Mono
    public T block(Duration duration) {
        Throwable th = this.errorSupplier.get();
        Objects.requireNonNull(th, "the errorSupplier returned null");
        throw Exceptions.propagate(th);
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        Throwable th = this.errorSupplier.get();
        Objects.requireNonNull(th, "the errorSupplier returned null");
        Throwable th2 = th;
        if (th2 instanceof Exception) {
            throw ((Exception) th2);
        }
        throw Exceptions.propagate(th2);
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        Throwable th = this.errorSupplier.get();
        Objects.requireNonNull(th, "the errorSupplier returned null");
        Operators.error(coreSubscriber, th);
    }

    @Override // reactor.core.publisher.Mono
    public T block() {
        Throwable th = this.errorSupplier.get();
        Objects.requireNonNull(th, "the errorSupplier returned null");
        throw Exceptions.propagate(th);
    }
}

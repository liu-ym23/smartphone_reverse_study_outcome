package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;

/* loaded from: classes4.dex */
final class FluxErrorSupplied<T> extends Flux<T> implements Fuseable.ScalarCallable, SourceProducer<T> {
    final Supplier<? extends Throwable> errorSupplier;

    public FluxErrorSupplied(Supplier<? extends Throwable> supplier) {
        Objects.requireNonNull(supplier, "errorSupplier");
        this.errorSupplier = supplier;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        Throwable th = this.errorSupplier.get();
        Objects.requireNonNull(th, "errorSupplier produced a null Throwable");
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

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        Throwable th = this.errorSupplier.get();
        Objects.requireNonNull(th, "errorSupplier produced a null Throwable");
        Operators.error(coreSubscriber, th);
    }
}

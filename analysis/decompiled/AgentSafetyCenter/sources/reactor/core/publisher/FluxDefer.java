package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxDefer<T> extends Flux<T> implements SourceProducer<T> {
    final Supplier<? extends qd.c> supplier;

    public FluxDefer(Supplier<? extends qd.c> supplier) {
        Objects.requireNonNull(supplier, "supplier");
        this.supplier = supplier;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        try {
            qd.c cVar = this.supplier.get();
            Objects.requireNonNull(cVar, "The Publisher returned by the supplier is null");
            Flux.from(cVar).subscribe((CoreSubscriber) coreSubscriber);
        } catch (Throwable th) {
            k0.a.B(coreSubscriber, th, coreSubscriber);
        }
    }
}

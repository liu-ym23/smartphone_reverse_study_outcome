package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;

/* loaded from: classes4.dex */
final class FluxDefer<T> extends Flux<T> implements SourceProducer<T> {
    final Supplier<? extends Z9.c> supplier;

    public FluxDefer(Supplier<? extends Z9.c> supplier) {
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
            Z9.c cVar = this.supplier.get();
            Objects.requireNonNull(cVar, "The Publisher returned by the supplier is null");
            Flux.from(cVar).subscribe((CoreSubscriber) coreSubscriber);
        } catch (Throwable th) {
            com.stepos.statsrpk.service.c.t(coreSubscriber, th, coreSubscriber);
        }
    }
}

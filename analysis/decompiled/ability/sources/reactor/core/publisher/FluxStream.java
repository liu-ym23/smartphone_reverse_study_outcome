package reactor.core.publisher;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;

/* loaded from: classes4.dex */
final class FluxStream<T> extends Flux<T> implements Fuseable, SourceProducer<T> {
    final Supplier<? extends Stream<? extends T>> streamSupplier;

    public FluxStream(Supplier<? extends Stream<? extends T>> supplier) {
        Objects.requireNonNull(supplier, "streamSupplier");
        this.streamSupplier = supplier;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        try {
            Stream<? extends T> stream = this.streamSupplier.get();
            Objects.requireNonNull(stream, "The stream supplier returned a null Stream");
            Stream<? extends T> stream2 = stream;
            try {
                Spliterator<? extends T> spliterator = stream2.spliterator();
                Objects.requireNonNull(spliterator, "The stream returned a null Spliterator");
                FluxIterable.subscribe(coreSubscriber, spliterator, spliterator.hasCharacteristics(64), new G(stream2, 3));
            } catch (Throwable th) {
                com.stepos.statsrpk.service.c.t(coreSubscriber, th, coreSubscriber);
            }
        } catch (Throwable th2) {
            com.stepos.statsrpk.service.c.t(coreSubscriber, th2, coreSubscriber);
        }
    }
}

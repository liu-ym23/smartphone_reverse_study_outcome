package reactor.core.publisher;

import java.lang.invoke.VarHandle;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
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
                Spliterator<? extends T> spliterator2 = spliterator;
                boolean zHasCharacteristics = spliterator2.hasCharacteristics(64);
                h0 h0Var = new h0(3);
                h0Var.f10799f = stream2;
                VarHandle.storeStoreFence();
                FluxIterable.subscribe(coreSubscriber, spliterator2, zHasCharacteristics, h0Var);
            } catch (Throwable th) {
                k0.a.B(coreSubscriber, th, coreSubscriber);
            }
        } catch (Throwable th2) {
            k0.a.B(coreSubscriber, th2, coreSubscriber);
        }
    }
}

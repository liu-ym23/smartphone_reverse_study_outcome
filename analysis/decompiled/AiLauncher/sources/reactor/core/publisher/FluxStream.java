package reactor.core.publisher;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;

/* loaded from: classes5.dex */
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
            final Stream<? extends T> stream2 = stream;
            try {
                Spliterator<? extends T> spliterator = stream2.spliterator();
                Objects.requireNonNull(spliterator, "The stream returned a null Spliterator");
                Spliterator<? extends T> spliterator2 = spliterator;
                FluxIterable.subscribe(coreSubscriber, spliterator2, spliterator2.hasCharacteristics(64), new Runnable() { // from class: reactor.core.publisher.S0
                    @Override // java.lang.Runnable
                    public final void run() {
                        stream2.close();
                    }
                });
            } catch (Throwable th) {
                Operators.error(coreSubscriber, Operators.onOperatorError(th, coreSubscriber.currentContext()));
            }
        } catch (Throwable th2) {
            Operators.error(coreSubscriber, Operators.onOperatorError(th2, coreSubscriber.currentContext()));
        }
    }
}

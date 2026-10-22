package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class FluxAutoConnect<T> extends Flux<T> implements Scannable {
    static final AtomicIntegerFieldUpdater<FluxAutoConnect> REMAINING = AtomicIntegerFieldUpdater.newUpdater(FluxAutoConnect.class, "remaining");
    final Consumer<? super Disposable> cancelSupport;
    volatile int remaining;
    final ConnectableFlux<? extends T> source;

    public FluxAutoConnect(ConnectableFlux<? extends T> connectableFlux, int i10, Consumer<? super Disposable> consumer) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("n > required but it was " + i10);
        }
        Objects.requireNonNull(connectableFlux, "source");
        this.source = ConnectableFlux.from((ConnectableFlux) connectableFlux);
        Objects.requireNonNull(consumer, "cancelSupport");
        this.cancelSupport = consumer;
        REMAINING.lazySet(this, i10);
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return this.source.getPrefetch();
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.valueOf(getPrefetch());
        }
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        if (attr == Scannable.Attr.CAPACITY) {
            return Integer.valueOf(this.remaining);
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        this.source.subscribe((CoreSubscriber<? super Object>) coreSubscriber);
        if (this.remaining <= 0 || REMAINING.decrementAndGet(this) != 0) {
            return;
        }
        this.source.connect(this.cancelSupport);
    }
}

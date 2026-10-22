package reactor.core.publisher;

import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxAutoConnectFuseable<T> extends Flux<T> implements Scannable, Fuseable {
    static final AtomicIntegerFieldUpdater<FluxAutoConnectFuseable> REMAINING = AtomicIntegerFieldUpdater.newUpdater(FluxAutoConnectFuseable.class, "remaining");
    final Consumer<? super Disposable> cancelSupport;
    volatile int remaining;
    final ConnectableFlux<? extends T> source;

    public FluxAutoConnectFuseable(ConnectableFlux<? extends T> connectableFlux, int i, Consumer<? super Disposable> consumer) {
        if (i <= 0) {
            throw new IllegalArgumentException(B7.a.h(i, "n > required but it was "));
        }
        Objects.requireNonNull(connectableFlux, AgentBusWakeContract.EXTRA_SOURCE);
        this.source = ConnectableFlux.from((ConnectableFlux) connectableFlux);
        Objects.requireNonNull(consumer, "cancelSupport");
        this.cancelSupport = consumer;
        REMAINING.lazySet(this, i);
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

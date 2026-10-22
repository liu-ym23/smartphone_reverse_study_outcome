package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;

/* loaded from: classes4.dex */
class ParallelFluxRestoringThreadLocals<T> extends ParallelFlux<T> implements Scannable {
    private final ParallelFlux<? extends T> source;

    public ParallelFluxRestoringThreadLocals(ParallelFlux<? extends T> parallelFlux) {
        this.source = parallelFlux;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.valueOf(getPrefetch());
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public void subscribe(CoreSubscriber<? super T>[] coreSubscriberArr) {
        this.source.subscribe(Operators.restoreContextOnSubscribers(this.source, coreSubscriberArr));
    }
}

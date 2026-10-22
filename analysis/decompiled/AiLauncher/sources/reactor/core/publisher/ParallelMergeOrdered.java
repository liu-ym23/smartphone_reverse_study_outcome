package reactor.core.publisher;

import java.util.Comparator;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxMergeComparing;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class ParallelMergeOrdered<T> extends Flux<T> implements Scannable {
    final int prefetch;
    final ParallelFlux<? extends T> source;
    final Comparator<? super T> valueComparator;

    public ParallelMergeOrdered(ParallelFlux<? extends T> parallelFlux, int i10, Comparator<? super T> comparator) {
        if (i10 > 0) {
            this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
            this.prefetch = i10;
            this.valueComparator = comparator;
        } else {
            throw new IllegalArgumentException("prefetch > 0 required but it was " + i10);
        }
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return this.prefetch;
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.valueOf(this.prefetch);
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
        FluxMergeComparing.MergeOrderedMainProducer mergeOrderedMainProducer = new FluxMergeComparing.MergeOrderedMainProducer(coreSubscriber, this.valueComparator, this.prefetch, this.source.parallelism(), true, true);
        coreSubscriber.onSubscribe(mergeOrderedMainProducer);
        this.source.subscribe(mergeOrderedMainProducer.subscribers);
    }
}

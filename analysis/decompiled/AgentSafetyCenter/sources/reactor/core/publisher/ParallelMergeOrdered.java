package reactor.core.publisher;

import java.util.Comparator;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxMergeComparing;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class ParallelMergeOrdered<T> extends Flux<T> implements Scannable {
    final int prefetch;
    final ParallelFlux<? extends T> source;
    final Comparator<? super T> valueComparator;

    public ParallelMergeOrdered(ParallelFlux<? extends T> parallelFlux, int i, Comparator<? super T> comparator) {
        if (i <= 0) {
            g5.f.s(k0.a.j(i, "prefetch > 0 required but it was "));
            throw null;
        }
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
        this.prefetch = i;
        this.valueComparator = comparator;
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

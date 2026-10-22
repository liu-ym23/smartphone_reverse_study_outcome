package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;

/* loaded from: classes5.dex */
final class ParallelArraySource<T> extends ParallelFlux<T> implements SourceProducer<T> {
    final qc.b<T>[] sources;

    public ParallelArraySource(qc.b<T>[] bVarArr) {
        if (bVarArr == null || bVarArr.length == 0) {
            throw new IllegalArgumentException("Zero publishers not supported");
        }
        this.sources = bVarArr;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public int parallelism() {
        return this.sources.length;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.ParallelFlux
    public void subscribe(CoreSubscriber<? super T>[] coreSubscriberArr) {
        if (validate(coreSubscriberArr)) {
            int length = coreSubscriberArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                Flux.from(this.sources[i10]).subscribe((CoreSubscriber) coreSubscriberArr[i10]);
            }
        }
    }
}

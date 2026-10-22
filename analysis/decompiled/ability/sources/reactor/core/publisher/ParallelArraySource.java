package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;

/* loaded from: classes4.dex */
final class ParallelArraySource<T> extends ParallelFlux<T> implements SourceProducer<T> {
    final Z9.c[] sources;

    public ParallelArraySource(Z9.c[] cVarArr) {
        if (cVarArr == null || cVarArr.length == 0) {
            throw new IllegalArgumentException("Zero publishers not supported");
        }
        this.sources = cVarArr;
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
            for (int i = 0; i < length; i++) {
                Flux.from(this.sources[i]).subscribe((CoreSubscriber) coreSubscriberArr[i]);
            }
        }
    }
}

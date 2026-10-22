package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class ParallelArraySource<T> extends ParallelFlux<T> implements SourceProducer<T> {
    final qd.c[] sources;

    public ParallelArraySource(qd.c[] cVarArr) {
        if (cVarArr == null || cVarArr.length == 0) {
            g5.f.s("Zero publishers not supported");
            throw null;
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

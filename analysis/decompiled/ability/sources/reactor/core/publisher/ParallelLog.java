package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxPeek;
import reactor.core.publisher.FluxPeekFuseable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class ParallelLog<T> extends ParallelFlux<T> implements Scannable {
    final SignalPeek<T> log;
    final ParallelFlux<T> source;

    public ParallelLog(ParallelFlux<T> parallelFlux, SignalPeek<T> signalPeek) {
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
        this.log = signalPeek;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public int getPrefetch() {
        return this.source.getPrefetch();
    }

    @Override // reactor.core.publisher.ParallelFlux
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // reactor.core.Scannable
    @Nullable
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
        if (validate(coreSubscriberArr)) {
            int length = coreSubscriberArr.length;
            CoreSubscriber<? super T>[] coreSubscriberArr2 = new CoreSubscriber[length];
            boolean z10 = coreSubscriberArr[0] instanceof Fuseable.ConditionalSubscriber;
            for (int i = 0; i < length; i++) {
                if (z10) {
                    coreSubscriberArr2[i] = new FluxPeekFuseable.PeekConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriberArr[i], this.log);
                } else {
                    coreSubscriberArr2[i] = new FluxPeek.PeekSubscriber(coreSubscriberArr[i], this.log);
                }
            }
            this.source.subscribe(coreSubscriberArr2);
        }
    }
}

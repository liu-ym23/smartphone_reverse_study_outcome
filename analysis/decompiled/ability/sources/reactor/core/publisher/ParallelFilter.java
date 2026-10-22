package reactor.core.publisher;

import java.util.function.Predicate;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxFilter;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class ParallelFilter<T> extends ParallelFlux<T> implements Scannable {
    final Predicate<? super T> predicate;
    final ParallelFlux<T> source;

    public ParallelFilter(ParallelFlux<T> parallelFlux, Predicate<? super T> predicate) {
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
        this.predicate = predicate;
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
                    coreSubscriberArr2[i] = new FluxFilter.FilterConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriberArr[i], this.predicate);
                } else {
                    coreSubscriberArr2[i] = new FluxFilter.FilterSubscriber(coreSubscriberArr[i], this.predicate);
                }
            }
            this.source.subscribe(coreSubscriberArr2);
        }
    }
}

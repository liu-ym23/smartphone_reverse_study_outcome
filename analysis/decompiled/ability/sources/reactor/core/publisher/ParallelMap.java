package reactor.core.publisher;

import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxMap;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class ParallelMap<T, R> extends ParallelFlux<R> implements Scannable {
    final Function<? super T, ? extends R> mapper;
    final ParallelFlux<T> source;

    public ParallelMap(ParallelFlux<T> parallelFlux, Function<? super T, ? extends R> function) {
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
        this.mapper = function;
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
    public void subscribe(CoreSubscriber<? super R>[] coreSubscriberArr) {
        if (validate(coreSubscriberArr)) {
            int length = coreSubscriberArr.length;
            CoreSubscriber<? super T>[] coreSubscriberArr2 = new CoreSubscriber[length];
            boolean z10 = coreSubscriberArr[0] instanceof Fuseable.ConditionalSubscriber;
            for (int i = 0; i < length; i++) {
                if (z10) {
                    coreSubscriberArr2[i] = new FluxMap.MapConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriberArr[i], this.mapper);
                } else {
                    coreSubscriberArr2[i] = new FluxMap.MapSubscriber(coreSubscriberArr[i], this.mapper);
                }
            }
            this.source.subscribe(coreSubscriberArr2);
        }
    }
}

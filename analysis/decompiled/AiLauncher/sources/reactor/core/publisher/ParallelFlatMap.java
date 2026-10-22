package reactor.core.publisher;

import java.util.Queue;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxFlatMap;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class ParallelFlatMap<T, R> extends ParallelFlux<R> implements Scannable {
    final boolean delayError;
    final Supplier<? extends Queue<R>> innerQueueSupplier;
    final Supplier<? extends Queue<R>> mainQueueSupplier;
    final Function<? super T, ? extends qc.b<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;
    final ParallelFlux<T> source;

    public ParallelFlatMap(ParallelFlux<T> parallelFlux, Function<? super T, ? extends qc.b<? extends R>> function, boolean z10, int i10, Supplier<? extends Queue<R>> supplier, int i11, Supplier<? extends Queue<R>> supplier2) {
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
        this.mapper = function;
        this.delayError = z10;
        this.maxConcurrency = i10;
        this.mainQueueSupplier = supplier;
        this.prefetch = i11;
        this.innerQueueSupplier = supplier2;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public int getPrefetch() {
        return this.prefetch;
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
        if (attr == Scannable.Attr.DELAY_ERROR) {
            return Boolean.valueOf(this.delayError);
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
            for (int i10 = 0; i10 < length; i10++) {
                coreSubscriberArr2[i10] = new FluxFlatMap.FlatMapMain(coreSubscriberArr[i10], this.mapper, this.delayError, this.maxConcurrency, this.mainQueueSupplier, this.prefetch, this.innerQueueSupplier);
            }
            this.source.subscribe(coreSubscriberArr2);
        }
    }
}

package reactor.core.publisher;

import java.util.Objects;
import java.util.Queue;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxConcatMap;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class ParallelConcatMap<T, R> extends ParallelFlux<R> implements Scannable {
    final FluxConcatMap.ErrorMode errorMode;
    final Function<? super T, ? extends qd.c> mapper;
    final int prefetch;
    final Supplier<? extends Queue<T>> queueSupplier;
    final ParallelFlux<T> source;

    public ParallelConcatMap(ParallelFlux<T> parallelFlux, Function<? super T, ? extends qd.c> function, Supplier<? extends Queue<T>> supplier, int i, FluxConcatMap.ErrorMode errorMode) {
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
        Objects.requireNonNull(function, "mapper");
        this.mapper = function;
        Objects.requireNonNull(supplier, "queueSupplier");
        this.queueSupplier = supplier;
        this.prefetch = i;
        Objects.requireNonNull(errorMode, "errorMode");
        this.errorMode = errorMode;
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
            return Boolean.valueOf(this.errorMode != FluxConcatMap.ErrorMode.IMMEDIATE);
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
            for (int i = 0; i < length; i++) {
                coreSubscriberArr2[i] = FluxConcatMap.subscriber(coreSubscriberArr[i], this.mapper, this.queueSupplier, this.prefetch, this.errorMode);
            }
            this.source.subscribe(coreSubscriberArr2);
        }
    }
}

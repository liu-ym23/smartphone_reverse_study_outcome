package reactor.core.publisher;

import java.util.Objects;
import java.util.Queue;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxArray;
import reactor.core.publisher.FluxFlatMap;

/* loaded from: classes4.dex */
final class FluxMerge<T> extends Flux<T> implements SourceProducer<T> {
    final boolean delayError;
    final Supplier<? extends Queue<T>> innerQueueSupplier;
    final Supplier<? extends Queue<T>> mainQueueSupplier;
    final int maxConcurrency;
    final int prefetch;
    final Z9.c[] sources;

    public FluxMerge(Z9.c[] cVarArr, boolean z10, int i, Supplier<? extends Queue<T>> supplier, int i6, Supplier<? extends Queue<T>> supplier2) {
        if (i6 <= 0) {
            throw new IllegalArgumentException(B7.a.h(i6, "prefetch > 0 required but it was "));
        }
        if (i <= 0) {
            throw new IllegalArgumentException(B7.a.h(i, "maxConcurrency > 0 required but it was "));
        }
        Objects.requireNonNull(cVarArr, "sources");
        Z9.c[] cVarArr2 = cVarArr;
        this.sources = cVarArr2;
        Operators.toFluxOrMono(cVarArr2);
        this.delayError = z10;
        this.maxConcurrency = i;
        this.prefetch = i6;
        Objects.requireNonNull(supplier, "mainQueueSupplier");
        this.mainQueueSupplier = supplier;
        Objects.requireNonNull(supplier2, "innerQueueSupplier");
        this.innerQueueSupplier = supplier2;
    }

    public FluxMerge<T> mergeAdditionalSource(Z9.c cVar, IntFunction<Supplier<? extends Queue<T>>> intFunction) {
        Supplier<? extends Queue<T>> supplierApply;
        Z9.c[] cVarArr = this.sources;
        int length = cVarArr.length;
        Z9.c[] cVarArr2 = new Z9.c[length + 1];
        System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
        cVarArr2[length] = cVar;
        int i = this.maxConcurrency;
        if (i != Integer.MAX_VALUE) {
            i++;
            supplierApply = intFunction.apply(i);
        } else {
            supplierApply = this.mainQueueSupplier;
        }
        return new FluxMerge<>(cVarArr2, this.delayError, i, supplierApply, this.prefetch, this.innerQueueSupplier);
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.DELAY_ERROR ? Boolean.valueOf(this.delayError) : attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.prefetch) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        FluxFlatMap.FlatMapMain flatMapMain = new FluxFlatMap.FlatMapMain(coreSubscriber, Flux.identityFunction(), this.delayError, this.maxConcurrency, this.mainQueueSupplier, this.prefetch, this.innerQueueSupplier);
        flatMapMain.onSubscribe(new FluxArray.ArraySubscription(flatMapMain, this.sources));
    }
}

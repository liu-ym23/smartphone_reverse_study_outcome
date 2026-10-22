package reactor.core.publisher;

import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import java.util.Objects;
import java.util.Queue;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxArray;
import reactor.core.publisher.FluxFlatMap;

/* loaded from: classes5.dex */
final class FluxMerge<T> extends Flux<T> implements SourceProducer<T> {
    final boolean delayError;
    final Supplier<? extends Queue<T>> innerQueueSupplier;
    final Supplier<? extends Queue<T>> mainQueueSupplier;
    final int maxConcurrency;
    final int prefetch;
    final qc.b<? extends T>[] sources;

    public FluxMerge(qc.b<? extends T>[] bVarArr, boolean z10, int i10, Supplier<? extends Queue<T>> supplier, int i11, Supplier<? extends Queue<T>> supplier2) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("prefetch > 0 required but it was " + i11);
        }
        if (i10 <= 0) {
            throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i10);
        }
        Objects.requireNonNull(bVarArr, SystemDeleteBroadcastReceiver.EXTRA_SOURCES);
        qc.b<? extends T>[] bVarArr2 = bVarArr;
        this.sources = bVarArr2;
        Operators.toFluxOrMono(bVarArr2);
        this.delayError = z10;
        this.maxConcurrency = i10;
        this.prefetch = i11;
        Objects.requireNonNull(supplier, "mainQueueSupplier");
        this.mainQueueSupplier = supplier;
        Objects.requireNonNull(supplier2, "innerQueueSupplier");
        this.innerQueueSupplier = supplier2;
    }

    public FluxMerge<T> mergeAdditionalSource(qc.b<? extends T> bVar, IntFunction<Supplier<? extends Queue<T>>> intFunction) {
        Supplier<? extends Queue<T>> supplierApply;
        qc.b<? extends T>[] bVarArr = this.sources;
        int length = bVarArr.length;
        qc.b[] bVarArr2 = new qc.b[length + 1];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
        bVarArr2[length] = bVar;
        int i10 = this.maxConcurrency;
        if (i10 != Integer.MAX_VALUE) {
            i10++;
            supplierApply = intFunction.apply(i10);
        } else {
            supplierApply = this.mainQueueSupplier;
        }
        return new FluxMerge<>(bVarArr2, this.delayError, i10, supplierApply, this.prefetch, this.innerQueueSupplier);
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

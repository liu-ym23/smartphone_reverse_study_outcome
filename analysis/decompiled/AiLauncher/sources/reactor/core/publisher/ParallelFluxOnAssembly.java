package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxOnAssembly;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class ParallelFluxOnAssembly<T> extends ParallelFlux<T> implements Fuseable, AssemblyOp, Scannable {
    final ParallelFlux<T> source;
    final FluxOnAssembly.AssemblySnapshot stacktrace;

    public ParallelFluxOnAssembly(ParallelFlux<T> parallelFlux, FluxOnAssembly.AssemblySnapshot assemblySnapshot) {
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
        this.stacktrace = assemblySnapshot;
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
        if (attr == Scannable.Attr.ACTUAL_METADATA) {
            return Boolean.valueOf(!this.stacktrace.isCheckpoint);
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.Scannable
    public String stepName() {
        return this.stacktrace.operatorAssemblyInformation();
    }

    @Override // reactor.core.publisher.ParallelFlux
    public void subscribe(CoreSubscriber<? super T>[] coreSubscriberArr) {
        if (validate(coreSubscriberArr)) {
            int length = coreSubscriberArr.length;
            CoreSubscriber<? super T>[] coreSubscriberArr2 = new CoreSubscriber[length];
            for (int i10 = 0; i10 < length; i10++) {
                CoreSubscriber<? super T> coreSubscriber = coreSubscriberArr[i10];
                coreSubscriberArr2[i10] = coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new FluxOnAssembly.OnAssemblyConditionalSubscriber<>((Fuseable.ConditionalSubscriber) coreSubscriber, this.stacktrace, this.source, this) : new FluxOnAssembly.OnAssemblySubscriber<>(coreSubscriber, this.stacktrace, this.source, this);
            }
            this.source.subscribe(coreSubscriberArr2);
        }
    }

    @Override // reactor.core.publisher.ParallelFlux
    public String toString() {
        return this.stacktrace.operatorAssemblyInformation();
    }
}

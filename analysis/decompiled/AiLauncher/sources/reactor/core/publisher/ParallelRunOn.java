package reactor.core.publisher;

import java.util.Queue;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxPublishOn;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class ParallelRunOn<T> extends ParallelFlux<T> implements Scannable {
    final int prefetch;
    final Supplier<Queue<T>> queueSupplier;
    final Scheduler scheduler;
    final ParallelFlux<? extends T> source;

    public ParallelRunOn(ParallelFlux<? extends T> parallelFlux, Scheduler scheduler, int i10, Supplier<Queue<T>> supplier) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("prefetch > 0 required but it was " + i10);
        }
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
        this.scheduler = scheduler;
        this.prefetch = i10;
        this.queueSupplier = supplier;
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
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.ASYNC;
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
            CoreSubscriber<? super Object>[] coreSubscriberArr2 = new CoreSubscriber[length];
            boolean z10 = coreSubscriberArr[0] instanceof Fuseable.ConditionalSubscriber;
            for (int i10 = 0; i10 < length; i10++) {
                Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
                if (z10) {
                    Fuseable.ConditionalSubscriber conditionalSubscriber = (Fuseable.ConditionalSubscriber) coreSubscriberArr[i10];
                    Scheduler scheduler = this.scheduler;
                    int i11 = this.prefetch;
                    coreSubscriberArr2[i10] = new FluxPublishOn.PublishOnConditionalSubscriber(conditionalSubscriber, scheduler, workerCreateWorker, true, i11, i11, this.queueSupplier);
                } else {
                    CoreSubscriber<? super T> coreSubscriber = coreSubscriberArr[i10];
                    Scheduler scheduler2 = this.scheduler;
                    int i12 = this.prefetch;
                    coreSubscriberArr2[i10] = new FluxPublishOn.PublishOnSubscriber(coreSubscriber, scheduler2, workerCreateWorker, true, i12, i12, this.queueSupplier);
                }
            }
            this.source.subscribe(coreSubscriberArr2);
        }
    }
}

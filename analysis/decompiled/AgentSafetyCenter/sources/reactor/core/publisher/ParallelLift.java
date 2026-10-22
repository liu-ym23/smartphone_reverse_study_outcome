package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class ParallelLift<I, O> extends ParallelFlux<O> implements Scannable {
    final Operators.LiftFunction<I, O> liftFunction;
    final ParallelFlux<I> source;

    public ParallelLift(ParallelFlux<I> parallelFlux, Operators.LiftFunction<I, O> liftFunction) {
        Objects.requireNonNull(parallelFlux, "source");
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
        this.liftFunction = liftFunction;
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
            return Scannable.from(this.source).scanUnsafe(attr);
        }
        if (attr == Scannable.Attr.LIFTER) {
            return this.liftFunction.name;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.Scannable
    public String stepName() {
        ParallelFlux<I> parallelFlux = this.source;
        return parallelFlux instanceof Scannable ? Scannable.from(parallelFlux).stepName() : super.stepName();
    }

    @Override // reactor.core.publisher.ParallelFlux
    public void subscribe(CoreSubscriber<? super O>[] coreSubscriberArr) {
        int iParallelism = parallelism();
        CoreSubscriber<? super I>[] coreSubscriberArr2 = new CoreSubscriber[iParallelism];
        for (int i = 0; i < iParallelism; i++) {
            CoreSubscriber<? super I> coreSubscriberApply = this.liftFunction.lifter.apply(this.source, coreSubscriberArr[i]);
            Objects.requireNonNull(coreSubscriberApply, "Lifted subscriber MUST NOT be null");
            coreSubscriberArr2[i] = coreSubscriberApply;
        }
        this.source.subscribe(coreSubscriberArr2);
    }
}

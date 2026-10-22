package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxTake;

/* loaded from: classes4.dex */
final class FluxTakeFuseable<T> extends InternalFluxOperator<T, T> implements Fuseable {
    final long n;

    public FluxTakeFuseable(Flux<? extends T> flux, long j5) {
        super(flux);
        if (j5 < 0) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "n >= 0 required but it was "));
        }
        this.n = j5;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new FluxTake.TakeFuseableSubscriber(coreSubscriber, this.n);
    }
}

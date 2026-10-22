package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxTake;

/* loaded from: classes5.dex */
final class FluxTakeFuseable<T> extends InternalFluxOperator<T, T> implements Fuseable {

    /* renamed from: n, reason: collision with root package name */
    final long f39585n;

    public FluxTakeFuseable(Flux<? extends T> flux, long j10) {
        super(flux);
        if (j10 >= 0) {
            this.f39585n = j10;
            return;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j10);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new FluxTake.TakeFuseableSubscriber(coreSubscriber, this.f39585n);
    }
}

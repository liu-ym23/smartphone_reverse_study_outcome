package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxTake;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxTakeFuseable<T> extends InternalFluxOperator<T, T> implements Fuseable {

    /* renamed from: n, reason: collision with root package name */
    final long f10690n;

    public FluxTakeFuseable(Flux<? extends T> flux, long j10) {
        super(flux);
        if (j10 >= 0) {
            this.f10690n = j10;
        } else {
            g5.f.s(k0.a.m("n >= 0 required but it was ", j10));
            throw null;
        }
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new FluxTake.TakeFuseableSubscriber(coreSubscriber, this.f10690n);
    }
}

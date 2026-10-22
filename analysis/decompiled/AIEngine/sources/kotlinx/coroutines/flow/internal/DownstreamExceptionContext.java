package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.d;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownstreamExceptionContext implements d {
    private final /* synthetic */ d $$delegate_0;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f10113e;

    public DownstreamExceptionContext(Throwable th, d dVar) {
        this.$$delegate_0 = dVar;
        this.f10113e = th;
    }

    @Override // kotlin.coroutines.d
    public <R> R fold(R r, p<? super R, ? super d.a, ? extends R> pVar) {
        return (R) this.$$delegate_0.fold(r, pVar);
    }

    @Override // kotlin.coroutines.d
    public <E extends d.a> E get(d.b<E> bVar) {
        return (E) this.$$delegate_0.get(bVar);
    }

    @Override // kotlin.coroutines.d
    public d minusKey(d.b<?> bVar) {
        return this.$$delegate_0.minusKey(bVar);
    }

    @Override // kotlin.coroutines.d
    public d plus(d dVar) {
        return this.$$delegate_0.plus(dVar);
    }
}

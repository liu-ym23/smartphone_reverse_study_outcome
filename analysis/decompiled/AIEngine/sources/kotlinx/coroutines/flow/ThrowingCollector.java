package kotlinx.coroutines.flow;

import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ThrowingCollector implements FlowCollector<Object> {

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f10112e;

    public ThrowingCollector(Throwable th) {
        this.f10112e = th;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, qb.b<? super n> bVar) throws Throwable {
        throw this.f10112e;
    }
}

package kotlinx.coroutines;

import kotlin.coroutines.d;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class UndispatchedMarker implements d.a, d.b<UndispatchedMarker> {
    public static final UndispatchedMarker INSTANCE = new UndispatchedMarker();

    private UndispatchedMarker() {
    }

    @Override // kotlin.coroutines.d
    public <R> R fold(R r, p<? super R, ? super d.a, ? extends R> pVar) {
        return (R) d.a.C0103a.a(this, r, pVar);
    }

    @Override // kotlin.coroutines.d
    public <E extends d.a> E get(d.b<E> bVar) {
        return (E) d.a.C0103a.b(this, bVar);
    }

    @Override // kotlin.coroutines.d
    public d minusKey(d.b<?> bVar) {
        return d.a.C0103a.c(this, bVar);
    }

    @Override // kotlin.coroutines.d
    public d plus(d dVar) {
        return d.a.C0103a.d(dVar, this);
    }

    @Override // kotlin.coroutines.d.a
    public d.b<?> getKey() {
        return this;
    }
}

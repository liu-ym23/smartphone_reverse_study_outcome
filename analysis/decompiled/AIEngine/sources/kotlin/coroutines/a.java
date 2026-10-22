package kotlin.coroutines;

import kotlin.coroutines.d;
import kotlin.jvm.internal.g;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a implements d.a {
    private final d.b<?> key;

    public a(d.b<?> key) {
        g.f(key, "key");
        this.key = key;
    }

    @Override // kotlin.coroutines.d
    public <R> R fold(R r, p<? super R, ? super d.a, ? extends R> pVar) {
        return (R) d.a.C0103a.a(this, r, pVar);
    }

    @Override // kotlin.coroutines.d
    public <E extends d.a> E get(d.b<E> bVar) {
        return (E) d.a.C0103a.b(this, bVar);
    }

    @Override // kotlin.coroutines.d.a
    public d.b<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.d
    public d minusKey(d.b<?> bVar) {
        return d.a.C0103a.c(this, bVar);
    }

    @Override // kotlin.coroutines.d
    public d plus(d dVar) {
        return d.a.C0103a.d(dVar, this);
    }
}

package androidx.room;

import kotlin.coroutines.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n implements d.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2577a = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements d.b<n> {
    }

    @Override // kotlin.coroutines.d
    public final <R> R fold(R r, zb.p<? super R, ? super d.a, ? extends R> pVar) {
        return (R) d.a.C0103a.a(this, r, pVar);
    }

    @Override // kotlin.coroutines.d
    public final <E extends d.a> E get(d.b<E> bVar) {
        return (E) d.a.C0103a.b(this, bVar);
    }

    @Override // kotlin.coroutines.d.a
    public final d.b<n> getKey() {
        return f2577a;
    }

    @Override // kotlin.coroutines.d
    public final kotlin.coroutines.d minusKey(d.b<?> bVar) {
        return d.a.C0103a.c(this, bVar);
    }

    @Override // kotlin.coroutines.d
    public final kotlin.coroutines.d plus(kotlin.coroutines.d dVar) {
        return d.a.C0103a.d(dVar, this);
    }
}

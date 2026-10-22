package u;

import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l<K, V> extends mb.e<V> {

    /* renamed from: a, reason: collision with root package name */
    public final f<K, V> f13122a;

    public l(f<K, V> fVar) {
        this.f13122a = fVar;
    }

    @Override // mb.e
    public final int a() {
        return this.f13122a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(V v3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f13122a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f13122a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        s[] sVarArr = new s[8];
        for (int i10 = 0; i10 < 8; i10++) {
            sVarArr[i10] = new u(1);
        }
        return new k(this.f13122a, sVarArr);
    }
}

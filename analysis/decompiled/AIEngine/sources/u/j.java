package u;

import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j<K, V> extends mb.h<K> {

    /* renamed from: a, reason: collision with root package name */
    public final f<K, V> f13121a;

    public j(f<K, V> fVar) {
        this.f13121a = fVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(K k9) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f13121a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f13121a.containsKey(obj);
    }

    @Override // mb.h
    public final int getSize() {
        return this.f13121a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<K> iterator() {
        s[] sVarArr = new s[8];
        for (int i10 = 0; i10 < 8; i10++) {
            sVarArr[i10] = new u(0);
        }
        return new k(this.f13121a, sVarArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        f<K, V> fVar = this.f13121a;
        if (!fVar.containsKey(obj)) {
            return false;
        }
        fVar.remove(obj);
        return true;
    }
}

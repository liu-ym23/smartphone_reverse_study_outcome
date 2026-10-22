package u;

import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class f<K, V> extends mb.g<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public d<K, V> f13111a;

    /* renamed from: b, reason: collision with root package name */
    public w.b f13112b;

    /* renamed from: c, reason: collision with root package name */
    public r<K, V> f13113c;

    /* renamed from: d, reason: collision with root package name */
    public V f13114d;

    /* renamed from: e, reason: collision with root package name */
    public int f13115e;
    public int h;

    public d<K, V> a() {
        r<K, V> rVar = this.f13113c;
        d<K, V> dVar = this.f13111a;
        if (rVar != dVar.f13106a) {
            this.f13112b = new w.b();
            dVar = new d<>(this.f13113c, size());
        }
        this.f13111a = dVar;
        return dVar;
    }

    public final void b(int i10) {
        this.h = i10;
        this.f13115e++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f13113c = r.f13126e;
        b(0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f13113c.d(obj != null ? obj.hashCode() : 0, 0, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        return (V) this.f13113c.g(obj != null ? obj.hashCode() : 0, 0, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k9, V v3) {
        this.f13114d = null;
        this.f13113c = this.f13113c.l(k9 != null ? k9.hashCode() : 0, k9, v3, 0, this);
        return this.f13114d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        d<K, V> dVarA = null;
        d<K, V> dVar = map instanceof d ? (d) map : null;
        if (dVar == null) {
            f fVar = map instanceof f ? (f) map : null;
            if (fVar != null) {
                dVarA = fVar.a();
            }
        } else {
            dVarA = dVar;
        }
        if (dVarA == null) {
            super.putAll(map);
            return;
        }
        w.a aVar = new w.a();
        aVar.f13527a = 0;
        int size = size();
        r<K, V> rVar = this.f13113c;
        r<K, V> rVar2 = dVarA.f13106a;
        kotlin.jvm.internal.g.d(rVar2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.f13113c = rVar.m(rVar2, 0, aVar, this);
        int i10 = (dVarA.f13107b + size) - aVar.f13527a;
        if (size != i10) {
            b(i10);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        this.f13114d = null;
        r<K, V> rVarN = this.f13113c.n(obj != null ? obj.hashCode() : 0, obj, 0, this);
        if (rVarN == null) {
            rVarN = r.f13126e;
        }
        this.f13113c = rVarN;
        return this.f13114d;
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        int size = size();
        r<K, V> rVarO = this.f13113c.o(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        if (rVarO == null) {
            rVarO = r.f13126e;
        }
        this.f13113c = rVarO;
        return size != size();
    }
}

package j0;

import b0.e3;
import b0.w1;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class g extends d7.i {

    /* renamed from: f, reason: collision with root package name */
    public i0.b f5077f = new i0.b();

    /* renamed from: g, reason: collision with root package name */
    public g0.k f5078g;

    /* renamed from: h, reason: collision with root package name */
    public Object f5079h;

    /* renamed from: i, reason: collision with root package name */
    public int f5080i;

    /* renamed from: j, reason: collision with root package name */
    public int f5081j;

    /* renamed from: k, reason: collision with root package name */
    public h f5082k;

    public g(h hVar) {
        this.f5078g = hVar.f3673f;
        this.f5081j = hVar.f3674g;
        this.f5082k = hVar;
    }

    public final h a() {
        g0.k kVar = this.f5078g;
        h hVar = this.f5082k;
        if (kVar != hVar.f3673f) {
            this.f5077f = new i0.b();
            hVar = new h(this.f5078g, size());
        }
        this.f5082k = hVar;
        return hVar;
    }

    public final boolean c(Object obj) {
        return this.f5078g.d(obj != null ? obj.hashCode() : 0, 0, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f5078g = g0.k.f3687e;
        f(0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof w1) {
            return c((w1) obj);
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof e3) {
            return super.containsValue((e3) obj);
        }
        return false;
    }

    public final Object d(Object obj) {
        return this.f5078g.g(obj != null ? obj.hashCode() : 0, 0, obj);
    }

    public final Object e(Object obj) {
        this.f5079h = null;
        g0.k kVarN = this.f5078g.n(obj != null ? obj.hashCode() : 0, obj, 0, this);
        if (kVarN == null) {
            kVarN = g0.k.f3687e;
        }
        this.f5078g = kVarN;
        return this.f5079h;
    }

    public final void f(int i2) {
        this.f5081j = i2;
        this.f5080i++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof w1) {
            return (e3) d((w1) obj);
        }
        return null;
    }

    @Override // d7.i
    public final Set getEntries() {
        return new g0.f(0, this);
    }

    @Override // d7.i
    public final Set getKeys() {
        return new g0.f(1, this);
    }

    @Override // java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof w1) ? obj2 : (e3) super.getOrDefault((w1) obj, (e3) obj2);
    }

    @Override // d7.i
    public final int getSize() {
        return this.f5081j;
    }

    @Override // d7.i
    public final Collection getValues() {
        return new e7.i(1, this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        this.f5079h = null;
        this.f5078g = this.f5078g.l(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        return this.f5079h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [g0.c] */
    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        h hVarA = null;
        h hVar = map instanceof g0.c ? (g0.c) map : null;
        if (hVar == null) {
            g gVar = map instanceof g ? (g) map : null;
            if (gVar != null) {
                hVarA = gVar.a();
            }
        } else {
            hVarA = hVar;
        }
        if (hVarA == null) {
            super.putAll(map);
            return;
        }
        i0.a aVar = new i0.a();
        aVar.f4393a = 0;
        int size = size();
        g0.k kVar = this.f5078g;
        g0.k kVar2 = hVarA.f3673f;
        q7.k.c(kVar2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.f5078g = kVar.m(kVar2, 0, aVar, this);
        int i2 = (hVarA.f3674g + size) - aVar.f4393a;
        if (size != i2) {
            f(i2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        if (obj instanceof w1) {
            return (e3) e((w1) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        int size = size();
        g0.k kVarO = this.f5078g.o(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        if (kVarO == null) {
            kVarO = g0.k.f3687e;
        }
        this.f5078g = kVarO;
        return size != size();
    }
}

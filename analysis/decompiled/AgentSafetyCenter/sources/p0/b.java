package p0;

import java.lang.invoke.VarHandle;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class b implements Map, zb.a {

    /* renamed from: g, reason: collision with root package name */
    public static final b f9657g = new b(j.f9671e, 0);

    /* renamed from: c, reason: collision with root package name */
    public final j f9658c;

    /* renamed from: f, reason: collision with root package name */
    public final int f9659f;

    public b(j jVar, int i) {
        this.f9658c = jVar;
        this.f9659f = i;
    }

    public final b a(Object obj, q0.a aVar) {
        wd.a aVarU = this.f9658c.u(obj, obj != null ? obj.hashCode() : 0, 0, aVar);
        return aVarU == null ? this : new b((j) aVarU.f15390g, this.f9659f + aVarU.f15389f);
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f9658c.d(obj != null ? obj.hashCode() : 0, 0, obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Set setEntrySet = entrySet();
        if (setEntrySet.isEmpty()) {
            return false;
        }
        Iterator it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (yb.k.a(((Map.Entry) it.next()).getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        g gVar = new g(0);
        gVar.f9669g = this;
        VarHandle.storeStoreFence();
        return gVar;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this.f9659f != map.size()) {
            return false;
        }
        Set<Map.Entry> setEntrySet = map.entrySet();
        if ((setEntrySet instanceof Collection) && setEntrySet.isEmpty()) {
            return true;
        }
        for (Map.Entry entry : setEntrySet) {
            if (entry != null) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                Object obj2 = get(key);
                if (yb.k.a(value, obj2) && (obj2 != null || containsKey(key))) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.f9658c.g(obj != null ? obj.hashCode() : 0, 0, obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f9659f == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        g gVar = new g(1);
        gVar.f9669g = this;
        VarHandle.storeStoreFence();
        return gVar;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        return this.f9659f;
    }

    public final String toString() {
        Set setEntrySet = entrySet();
        a9.e eVar = new a9.e(12);
        eVar.f257f = this;
        VarHandle.storeStoreFence();
        return kb.l.B0(setEntrySet, ", ", "{", "}", eVar, 24);
    }

    @Override // java.util.Map
    public final Collection values() {
        i iVar = new i();
        iVar.f9670f = this;
        VarHandle.storeStoreFence();
        return iVar;
    }
}

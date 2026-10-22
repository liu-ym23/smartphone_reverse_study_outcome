package p;

import java.lang.invoke.VarHandle;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r implements Map, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public f0 f9617c;

    /* renamed from: f, reason: collision with root package name */
    public g f9618f;

    /* renamed from: g, reason: collision with root package name */
    public g f9619g;

    /* renamed from: h, reason: collision with root package name */
    public r0 f9620h;

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Object compute(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Object computeIfAbsent(Object obj, Function function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f9617c.c(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.f9617c.d(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        g gVar = this.f9618f;
        if (gVar != null) {
            return gVar;
        }
        f0 f0Var = this.f9617c;
        f0Var.getClass();
        g gVar2 = new g(0);
        gVar2.f9559f = f0Var;
        VarHandle.storeStoreFence();
        this.f9618f = gVar2;
        return gVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        return yb.k.a(this.f9617c, ((r) obj).f9617c);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return this.f9617c.g(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f9617c.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f9617c.i();
    }

    @Override // java.util.Map
    public final Set keySet() {
        g gVar = this.f9619g;
        if (gVar != null) {
            return gVar;
        }
        f0 f0Var = this.f9617c;
        f0Var.getClass();
        g gVar2 = new g(1);
        gVar2.f9559f = f0Var;
        VarHandle.storeStoreFence();
        this.f9619g = gVar2;
        return gVar2;
    }

    @Override // java.util.Map
    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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
    public final Object putIfAbsent(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Object replace(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        return this.f9617c.f9556e;
    }

    public final String toString() {
        return this.f9617c.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        r0 r0Var = this.f9620h;
        if (r0Var != null) {
            return r0Var;
        }
        f0 f0Var = this.f9617c;
        f0Var.getClass();
        r0 r0Var2 = new r0(0);
        r0Var2.f9622f = f0Var;
        VarHandle.storeStoreFence();
        this.f9620h = r0Var2;
        return r0Var2;
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

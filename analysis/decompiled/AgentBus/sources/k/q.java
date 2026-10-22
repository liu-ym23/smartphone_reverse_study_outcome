package k;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

/* loaded from: classes.dex */
public final class q implements Map, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final a0 f5519f;

    /* renamed from: g, reason: collision with root package name */
    public g f5520g;

    /* renamed from: h, reason: collision with root package name */
    public g f5521h;

    /* renamed from: i, reason: collision with root package name */
    public j0 f5522i;

    public q(a0 a0Var) {
        q7.k.e(a0Var, "parent");
        this.f5519f = a0Var;
    }

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
        return this.f5519f.c(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.f5519f.d(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        g gVar = this.f5520g;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this.f5519f, 0);
        this.f5520g = gVar2;
        return gVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        return q7.k.a(this.f5519f, ((q) obj).f5519f);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return this.f5519f.g(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f5519f.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f5519f.i();
    }

    @Override // java.util.Map
    public final Set keySet() {
        g gVar = this.f5521h;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this.f5519f, 1);
        this.f5521h = gVar2;
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
        return this.f5519f.f5450e;
    }

    public final String toString() {
        return this.f5519f.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        j0 j0Var = this.f5522i;
        if (j0Var != null) {
            return j0Var;
        }
        j0 j0Var2 = new j0(this.f5519f);
        this.f5522i = j0Var2;
        return j0Var2;
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

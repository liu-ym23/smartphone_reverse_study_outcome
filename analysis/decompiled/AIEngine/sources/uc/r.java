package uc;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class r extends g implements Map<String, g>, ac.a {
    public static final a Companion = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, g> f13221a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public final pc.a<r> serializer() {
            return s.f13222a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(Map<String, ? extends g> content) {
        kotlin.jvm.internal.g.f(content, "content");
        this.f13221a = content;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ g compute(String str, BiFunction<? super String, ? super g, ? extends g> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ g computeIfAbsent(String str, Function<? super String, ? extends g> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ g computeIfPresent(String str, BiFunction<? super String, ? super g, ? extends g> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return this.f13221a.containsKey((String) obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        return this.f13221a.containsValue((g) obj);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, g>> entrySet() {
        return this.f13221a.entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return kotlin.jvm.internal.g.b(this.f13221a, obj);
    }

    @Override // java.util.Map
    public final g get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return this.f13221a.get((String) obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f13221a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f13221a.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.f13221a.keySet();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ g merge(String str, g gVar, BiFunction<? super g, ? super g, ? extends g> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ g put(String str, g gVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends g> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ g putIfAbsent(String str, g gVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final g remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ g replace(String str, g gVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super g, ? extends g> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        return this.f13221a.size();
    }

    public final String toString() {
        return kotlin.collections.a.z0(this.f13221a.entrySet(), ",", "{", "}", new n9.d(3), 24);
    }

    @Override // java.util.Map
    public final Collection<g> values() {
        return this.f13221a.values();
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(String str, g gVar, g gVar2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

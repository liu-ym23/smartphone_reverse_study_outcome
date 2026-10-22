package C9;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final class x extends l implements Map<String, l>, T7.a {
    public static final w Companion = new w();

    /* renamed from: a, reason: collision with root package name */
    public final Map f335a;

    public x(Map content) {
        kotlin.jvm.internal.k.f(content, "content");
        this.f335a = content;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ l compute(String str, BiFunction<? super String, ? super l, ? extends l> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ l computeIfAbsent(String str, Function<? super String, ? extends l> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ l computeIfPresent(String str, BiFunction<? super String, ? super l, ? extends l> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String key = (String) obj;
        kotlin.jvm.internal.k.f(key, "key");
        return this.f335a.containsKey(key);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l value = (l) obj;
        kotlin.jvm.internal.k.f(value, "value");
        return this.f335a.containsValue(value);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, l>> entrySet() {
        return this.f335a.entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return kotlin.jvm.internal.k.b(this.f335a, obj);
    }

    @Override // java.util.Map
    public final l get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String key = (String) obj;
        kotlin.jvm.internal.k.f(key, "key");
        return (l) this.f335a.get(key);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f335a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f335a.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.f335a.keySet();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ l merge(String str, l lVar, BiFunction<? super l, ? super l, ? extends l> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ l put(String str, l lVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends l> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ l putIfAbsent(String str, l lVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final l remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ l replace(String str, l lVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super l, ? extends l> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        return this.f335a.size();
    }

    public final String toString() {
        return D7.v.I0(this.f335a.entrySet(), ",", "{", "}", new Ba.f(2), 24);
    }

    @Override // java.util.Map
    public final Collection<l> values() {
        return this.f335a.values();
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(String str, l lVar, l lVar2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

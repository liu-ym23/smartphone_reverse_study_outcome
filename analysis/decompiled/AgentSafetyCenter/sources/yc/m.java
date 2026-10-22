package yc;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends f implements Map<String, f>, zb.a {
    public static final l Companion = new l();

    /* renamed from: c, reason: collision with root package name */
    public Map f16112c;

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ f compute(String str, BiFunction<? super String, ? super f, ? extends f> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ f computeIfAbsent(String str, Function<? super String, ? extends f> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ f computeIfPresent(String str, BiFunction<? super String, ? super f, ? extends f> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return this.f16112c.containsKey((String) obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        return this.f16112c.containsValue((f) obj);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, f>> entrySet() {
        return this.f16112c.entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return yb.k.a(this.f16112c, obj);
    }

    @Override // java.util.Map
    public final f get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return (f) this.f16112c.get((String) obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f16112c.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f16112c.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.f16112c.keySet();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ f merge(String str, f fVar, BiFunction<? super f, ? super f, ? extends f> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ f put(String str, f fVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends f> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ f putIfAbsent(String str, f fVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final f remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ f replace(String str, f fVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super f, ? extends f> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        return this.f16112c.size();
    }

    public final String toString() {
        return kb.l.B0(this.f16112c.entrySet(), ",", "{", "}", new t0.d(11), 24);
    }

    @Override // java.util.Map
    public final Collection<f> values() {
        return this.f16112c.values();
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(String str, f fVar, f fVar2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

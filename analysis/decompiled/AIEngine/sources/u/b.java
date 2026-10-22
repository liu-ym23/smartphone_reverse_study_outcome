package u;

import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class b<K, V> implements Map.Entry<K, V>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final K f13101a;

    /* renamed from: b, reason: collision with root package name */
    public final V f13102b;

    public b(K k9, V v3) {
        this.f13101a = k9;
        this.f13102b = v3;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        Map.Entry entry = obj instanceof Map.Entry ? (Map.Entry) obj : null;
        return entry != null && kotlin.jvm.internal.g.b(entry.getKey(), this.f13101a) && kotlin.jvm.internal.g.b(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f13101a;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.f13102b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        K k9 = this.f13101a;
        int iHashCode = k9 != null ? k9.hashCode() : 0;
        V value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public V setValue(V v3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f13101a);
        sb2.append('=');
        sb2.append(getValue());
        return sb2.toString();
    }
}

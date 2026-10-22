package androidx.collection;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010!J\u0015\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010$J\u0015\u0010%\u001a\u00020\u001e2\u0006\u0010 \u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010$J\u0013\u0010&\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0002J\b\u0010)\u001a\u00020\u001aH\u0016J\b\u0010*\u001a\u00020+H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Landroidx/collection/MapWrapper;", "K", "V", "", "parent", "Landroidx/collection/ScatterMap;", "<init>", "(Landroidx/collection/ScatterMap;)V", "_entries", "Landroidx/collection/Entries;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "_keys", "Landroidx/collection/Keys;", "keys", "getKeys", "_values", "Landroidx/collection/Values;", "values", "", "getValues", "()Ljava/util/Collection;", "size", "", "getSize", "()I", "isEmpty", "", MonitorConstants.CONNECT_TYPE_GET, "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "containsValue", "value", "(Ljava/lang/Object;)Z", "containsKey", "equals", "other", "", "hashCode", "toString", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
class MapWrapper<K, V> implements Map<K, V>, KMappedMarker {
    private Entries<K, V> _entries;
    private Keys<K, V> _keys;
    private Values<K, V> _values;
    private final ScatterMap<K, V> parent;

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V compute(K r100, BiFunction<? super K, ? super V, ? extends V> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V computeIfAbsent(K r100, Function<? super K, ? extends V> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V computeIfPresent(K r100, BiFunction<? super K, ? super V, ? extends V> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V merge(K r100, V r101, BiFunction<? super V, ? super V, ? extends V> r102) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V put(K r100, V r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V putIfAbsent(K r100, V r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean remove(Object r100, Object r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V replace(K r100, V r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean replace(K r100, V r101, V r102) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Set<Map.Entry<K, V>> getEntries() {
        Entries<K, V> r100 = this._entries;
        if (r100 != null) goto L7;
        Entries<K, V> r101 = new Entries(this.parent);
        this._entries = r101;
        return r101;
    L7:
        return r100;
    }

    public Set<K> getKeys() {
        Keys<K, V> r100 = this._keys;
        if (r100 != null) goto L7;
        Keys<K, V> r101 = new Keys(this.parent);
        this._keys = r101;
        return r101;
    L7:
        return r100;
    }

    public int getSize() {
        return this.parent._size;
    }

    public Collection<V> getValues() {
        Values<K, V> r100 = this._values;
        if (r100 != null) goto L7;
        Values<K, V> r101 = new Values(this.parent);
        this._values = r101;
        return r101;
    L7:
        return r100;
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.parent.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.parent.isEmpty();
    }

    public String toString() {
        return this.parent.toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public MapWrapper(ScatterMap<K, V> r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.parent = r100;
    }

    @Override // java.util.Map
    public boolean containsKey(Object r100) {
        return this.parent.containsKey(r100);
    }

    @Override // java.util.Map
    public boolean containsValue(Object r100) {
        return this.parent.containsValue(r100);
    }

    @Override // java.util.Map
    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.parent, ((MapWrapper) r100).parent);
    }

    @Override // java.util.Map
    public V get(Object r100) {
        return this.parent.get(r100);
    }
}

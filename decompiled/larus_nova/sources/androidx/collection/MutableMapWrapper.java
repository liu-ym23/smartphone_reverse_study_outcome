package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0017\u0010\u001c\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\u001b2\u0014\u0010 \u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!H\u0016J\u001f\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010$R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Landroidx/collection/MutableMapWrapper;", "K", "V", "Landroidx/collection/MapWrapper;", "", "parent", "Landroidx/collection/MutableScatterMap;", "<init>", "(Landroidx/collection/MutableScatterMap;)V", "_entries", "Landroidx/collection/MutableEntries;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "_keys", "Landroidx/collection/MutableKeys;", "keys", "getKeys", "_values", "Landroidx/collection/MutableValues;", "values", "", "getValues", "()Ljava/util/Collection;", "clear", "", "remove", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MutableMapWrapper<K, V> extends MapWrapper<K, V> implements KMutableMap {
    private MutableEntries<K, V> _entries;
    private MutableKeys<K, V> _keys;
    private MutableValues<K, V> _values;
    private final MutableScatterMap<K, V> parent;

    @Override // androidx.collection.MapWrapper, java.util.Map
    public void clear() {
        this.parent.clear();
    }

    @Override // androidx.collection.MapWrapper
    public Set<Map.Entry<K, V>> getEntries() {
        MutableEntries<K, V> r100 = this._entries;
        if (r100 != null) goto L7;
        MutableEntries<K, V> r101 = new MutableEntries(this.parent);
        this._entries = r101;
        return r101;
    L7:
        return r100;
    }

    @Override // androidx.collection.MapWrapper
    public Set<K> getKeys() {
        MutableKeys<K, V> r100 = this._keys;
        if (r100 != null) goto L7;
        MutableKeys<K, V> r101 = new MutableKeys(this.parent);
        this._keys = r101;
        return r101;
    L7:
        return r100;
    }

    @Override // androidx.collection.MapWrapper
    public Collection<V> getValues() {
        MutableValues<K, V> r100 = this._values;
        if (r100 != null) goto L7;
        MutableValues<K, V> r101 = new MutableValues(this.parent);
        this._values = r101;
        return r101;
    L7:
        return r100;
    }

    public MutableMapWrapper(MutableScatterMap<K, V> r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
        this.parent = r100;
    }

    @Override // androidx.collection.MapWrapper, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Iterator<Map.Entry<? extends K, ? extends V>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r102 = r101.next();
        K r103 = r102.getKey();
        V r104 = r102.getValue();
        this.parent.set(r103, r104);
        goto L4
    }

    @Override // androidx.collection.MapWrapper, java.util.Map
    public V remove(Object r100) {
        return this.parent.remove(r100);
    }

    @Override // androidx.collection.MapWrapper, java.util.Map
    public V put(K r100, V r101) {
        return this.parent.put(r100, r101);
    }
}

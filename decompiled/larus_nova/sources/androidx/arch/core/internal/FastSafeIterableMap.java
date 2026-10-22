package androidx.arch.core.internal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    private final HashMap<K, SafeIterableMap.Entry<K, V>> mHashMap;

    public FastSafeIterableMap() {
        this.mHashMap = new HashMap();
    }

    public Map.Entry<K, V> ceil(K r100) {
        if (contains(r100) == true) goto L5;
        return null;
    L5:
        return this.mHashMap.get(r100).mPrevious;
    }

    public boolean contains(K r100) {
        return this.mHashMap.containsKey(r100);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public SafeIterableMap.Entry<K, V> get(K r100) {
        return this.mHashMap.get(r100);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V remove(K r100) {
        V r101 = (V) super.remove(r100);
        this.mHashMap.remove(r100);
        return r101;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V putIfAbsent(K r100, V r101) {
        SafeIterableMap.Entry<K, V> r102 = get(r100);
        if (r102 != null) goto L5;
        this.mHashMap.put(r100, put(r100, r101));
        return null;
    L5:
        return r102.mValue;
    }
}

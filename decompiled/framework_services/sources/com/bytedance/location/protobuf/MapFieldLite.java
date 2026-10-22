package com.bytedance.location.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {
    private static final MapFieldLite<?, ?> EMPTY_MAP_FIELD = null;
    private boolean isMutable;

    private MapFieldLite() {
        this.isMutable = true;
    }

    private MapFieldLite(Map<K, V> mapData) {
        super(mapData);
        this.isMutable = true;
    }

    static {
        EMPTY_MAP_FIELD = new MapFieldLite();
        EMPTY_MAP_FIELD.makeImmutable();
    }

    public static <K, V> MapFieldLite<K, V> emptyMapField() {
        return (MapFieldLite<K, V>) EMPTY_MAP_FIELD;
    }

    public void mergeFrom(MapFieldLite<K, V> other) {
        ensureMutable();
        if (other.isEmpty() == true) goto L6;
        putAll(other);
        return;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (isEmpty() == false) goto L6;
        return Collections.emptySet();
    L6:
        return super.entrySet();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        ensureMutable();
        super.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K r2, V r3) {
        ensureMutable();
        Internal.checkNotNull(r2);
        Internal.checkNotNull(r3);
        return (V) super.put(r2, r3);
    }

    public V put(Map.Entry<K, V> entry) {
        return put(entry.getKey(), entry.getValue());
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> m) {
        ensureMutable();
        checkForNullKeysAndValues(m);
        super.putAll(m);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object r2) {
        ensureMutable();
        return (V) super.remove(r2);
    }

    private static void checkForNullKeysAndValues(Map<?, ?> m) {
        Iterator<?> r0 = m.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Object key = r0.next();
        Internal.checkNotNull(key);
        Internal.checkNotNull(m.get(key));
        goto L4
    }

    private static boolean equals(Object a, Object b) {
        if ((a instanceof byte[]) == false) goto L9;
        if ((b instanceof byte[]) == false) goto L9;
        return Arrays.equals((byte[]) a, (byte[]) b);
    L9:
        return a.equals(b);
    }

    static <K, V> boolean equals(Map<K, V> a, Map<K, V> b) {
        if (a != b) goto L6;
        return true;
    L6:
        if (a.size() == b.size()) goto L8;
        return false;
    L8:
        Iterator<Map.Entry<K, V>> r1 = a.entrySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L18;
        Map.Entry<K, V> entry = r1.next();
        if (b.containsKey(entry.getKey()) == false) goto L13;
        if (equals(entry.getValue(), b.get(entry.getKey())) == true) goto L10;
        return false;
    L13:
        return false;
    L18:
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object object) {
        if ((object instanceof Map) == true) goto L5;
    L7:
        return false;
    L5:
        if (equals(this, (Map) object) == false) goto L7;
        return true;
    }

    private static int calculateHashCodeForObject(Object a) {
        if ((a instanceof byte[]) == false) goto L7;
        return Internal.hashCode((byte[]) a);
    L7:
        if ((a instanceof Internal.EnumLite) == true) goto L11;
        return a.hashCode();
    L11:
        throw new UnsupportedOperationException();
    }

    static <K, V> int calculateHashCodeForMap(Map<K, V> a) {
        int result = 0;
        Iterator<Map.Entry<K, V>> r1 = a.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<K, V> entry = r1.next();
        result = result + (calculateHashCodeForObject(entry.getKey()) ^ calculateHashCodeForObject(entry.getValue()));
        goto L4
    L6:
        return result;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return calculateHashCodeForMap(this);
    }

    private static Object copy(Object object) {
        if ((object instanceof byte[]) == false) goto L6;
        byte[] data = (byte[]) object;
        return Arrays.copyOf(data, data.length);
    L6:
        return object;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> Map<K, V> copy(Map<K, V> r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<K, V>> r1 = r5.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<K, V> r2 = r1.next();
        r0.put(r2.getKey(), copy(r2.getValue()));
        goto L4
    L6:
        return r0;
    }

    public MapFieldLite<K, V> mutableCopy() {
        if (isEmpty() == false) goto L6;
        return new MapFieldLite();
    L6:
        return new MapFieldLite(this);
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    private void ensureMutable() {
        if (isMutable() == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }
}

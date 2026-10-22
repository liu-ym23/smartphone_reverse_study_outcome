package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C1359w;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: b, reason: collision with root package name */
    public static final MapFieldLite f13460b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f13461a;

    static {
        MapFieldLite mapFieldLite = new MapFieldLite();
        f13460b = mapFieldLite;
        mapFieldLite.t();
    }

    private MapFieldLite() {
        this.f13461a = true;
    }

    public static <K, V> int d(Map<K, V> map) {
        int iG = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            iG += g(entry.getValue()) ^ g(entry.getKey());
        }
        return iG;
    }

    public static int g(Object obj) {
        if (obj instanceof byte[]) {
            return C1359w.d((byte[]) obj);
        }
        if (obj instanceof C1359w.c) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    public static void h(Map<?, ?> map) {
        for (Object obj : map.keySet()) {
            C1359w.a(obj);
            C1359w.a(map.get(obj));
        }
    }

    public static <K, V> MapFieldLite<K, V> i() {
        return f13460b;
    }

    public static boolean n(Object obj, Object obj2) {
        return ((obj instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) obj, (byte[]) obj2) : obj.equals(obj2);
    }

    public static <K, V> boolean q(Map<K, V> map, Map<K, V> map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !n(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        j();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.EMPTY_SET : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && q(this, (Map) obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return d(this);
    }

    public final void j() {
        if (!s()) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        j();
        C1359w.a(k10);
        C1359w.a(v10);
        return (V) super.put(k10, v10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        j();
        h(map);
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        j();
        return (V) super.remove(obj);
    }

    public boolean s() {
        return this.f13461a;
    }

    public void t() {
        this.f13461a = false;
    }

    public void u(MapFieldLite<K, V> mapFieldLite) {
        j();
        if (mapFieldLite.isEmpty()) {
            return;
        }
        putAll(mapFieldLite);
    }

    public MapFieldLite<K, V> v() {
        return isEmpty() ? new MapFieldLite<>() : new MapFieldLite<>(this);
    }

    public MapFieldLite(Map<K, V> map) {
        super(map);
        this.f13461a = true;
    }
}

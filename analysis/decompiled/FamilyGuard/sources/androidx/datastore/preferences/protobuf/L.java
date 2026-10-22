package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.A;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class L<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: b, reason: collision with root package name */
    private static final L f9952b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f9953a;

    static {
        L l5 = new L();
        f9952b = l5;
        l5.l();
    }

    private L() {
        this.f9953a = true;
    }

    static <K, V> int b(Map<K, V> map) {
        int iD = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            iD += d(entry.getValue()) ^ d(entry.getKey());
        }
        return iD;
    }

    private static int d(Object obj) {
        if (obj instanceof byte[]) {
            return A.d((byte[]) obj);
        }
        if (obj instanceof A.c) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    private static void e(Map<?, ?> map) {
        for (Object obj : map.keySet()) {
            A.a(obj);
            A.a(map.get(obj));
        }
    }

    public static <K, V> L<K, V> g() {
        return f9952b;
    }

    private void h() {
        if (!k()) {
            throw new UnsupportedOperationException();
        }
    }

    private static boolean i(Object obj, Object obj2) {
        return ((obj instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) obj, (byte[]) obj2) : obj.equals(obj2);
    }

    static <K, V> boolean j(Map<K, V> map, Map<K, V> map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !i(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        h();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.EMPTY_SET : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && j(this, (Map) obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return b(this);
    }

    public boolean k() {
        return this.f9953a;
    }

    public void l() {
        this.f9953a = false;
    }

    public void n(L<K, V> l5) {
        h();
        if (l5.isEmpty()) {
            return;
        }
        putAll(l5);
    }

    public L<K, V> p() {
        return isEmpty() ? new L<>() : new L<>(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K k5, V v5) {
        h();
        A.a(k5);
        A.a(v5);
        return (V) super.put(k5, v5);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        h();
        e(map);
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        h();
        return (V) super.remove(obj);
    }

    private L(Map<K, V> map) {
        super(map);
        this.f9953a = true;
    }
}

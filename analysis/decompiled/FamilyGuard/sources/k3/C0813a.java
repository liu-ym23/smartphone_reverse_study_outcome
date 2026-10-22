package k3;

import java.util.HashMap;
import java.util.Map;

/* renamed from: k3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0813a {

    /* renamed from: k3.a$a, reason: collision with other inner class name */
    public interface InterfaceC0222a<V> {
        V a(V v5, V v6);
    }

    public static <K, V> V a(Map<K, V> map, K k5, V v5) {
        return map.getOrDefault(k5, v5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> Map<K, V> b(Map<K, V> map, Map<K, V> map2, InterfaceC0222a<V> interfaceC0222a) {
        if (map == null) {
            return map2;
        }
        if (map2 == null) {
            return map;
        }
        HashMap map3 = new HashMap();
        map3.putAll(map);
        for (K k5 : map2.keySet()) {
            if (map3.containsKey(k5)) {
                V v5 = map2.get(k5);
                Object obj = map3.get(k5);
                if (v5 == null) {
                    map3.put(k5, obj);
                } else if (obj == null) {
                    map3.put(k5, v5);
                } else {
                    map3.put(k5, interfaceC0222a.a(v5, obj));
                }
            } else {
                map3.put(k5, map2.get(k5));
            }
        }
        return map3;
    }
}

package kotlin.collections;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import mb.u;
import mb.v;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class b extends v {
    public static <K, V> Map<K, V> d0() {
        EmptyMap emptyMap = EmptyMap.f10002a;
        g.d(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    public static Object e0(Object obj, Map map) {
        g.f(map, "<this>");
        if (map instanceof u) {
            return ((u) map).d();
        }
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }

    public static <K, V> LinkedHashMap<K, V> f0(Pair<? extends K, ? extends V>... pairArr) {
        LinkedHashMap<K, V> linkedHashMap = new LinkedHashMap<>(v.a0(pairArr.length));
        l0(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static <K, V> Map<K, V> g0(Pair<? extends K, ? extends V>... pairArr) {
        if (pairArr.length <= 0) {
            return d0();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(v.a0(pairArr.length));
        l0(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static Map h0(String str, Map map) {
        g.f(map, "<this>");
        LinkedHashMap linkedHashMapO0 = o0(map);
        linkedHashMapO0.remove(str);
        return i0(linkedHashMapO0);
    }

    public static final Map i0(LinkedHashMap linkedHashMap) {
        int size = linkedHashMap.size();
        return size != 0 ? size != 1 ? linkedHashMap : v.c0(linkedHashMap) : d0();
    }

    public static LinkedHashMap j0(Map map, Map map2) {
        g.f(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static <K, V> Map<K, V> k0(Map<? extends K, ? extends V> map, Pair<? extends K, ? extends V> pair) {
        g.f(map, "<this>");
        if (map.isEmpty()) {
            return v.b0(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.f9985a, pair.f9986b);
        return linkedHashMap;
    }

    public static final void l0(AbstractMap abstractMap, Pair[] pairArr) {
        for (Pair pair : pairArr) {
            abstractMap.put(pair.f9985a, pair.f9986b);
        }
    }

    public static Map m0(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return d0();
        }
        if (size == 1) {
            return v.b0((Pair) arrayList.get(0));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(v.a0(arrayList.size()));
        int size2 = arrayList.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj = arrayList.get(i10);
            i10++;
            Pair pair = (Pair) obj;
            linkedHashMap.put(pair.f9985a, pair.f9986b);
        }
        return linkedHashMap;
    }

    public static <K, V> Map<K, V> n0(Map<? extends K, ? extends V> map) {
        g.f(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? o0(map) : v.c0(map) : d0();
    }

    public static LinkedHashMap o0(Map map) {
        g.f(map, "<this>");
        return new LinkedHashMap(map);
    }
}

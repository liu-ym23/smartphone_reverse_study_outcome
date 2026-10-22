package kotlin.collections;

import D7.H;
import M0.i;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public abstract class a extends i {
    public static Map M() {
        EmptyMap emptyMap = EmptyMap.f4894a;
        k.d(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    public static Object N(Object obj, Map map) {
        k.f(map, "<this>");
        if (map instanceof H) {
            return ((H) map).c();
        }
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException(androidx.compose.foundation.b.s(obj, "Key ", " is missing in the map."));
    }

    public static LinkedHashMap O(Pair... pairArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(P(pairArr.length));
        W(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static int P(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map Q(Pair pair) {
        k.f(pair, "pair");
        Map mapSingletonMap = Collections.singletonMap(pair.f4886a, pair.b);
        k.e(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static Map R(Pair... pairArr) {
        if (pairArr.length <= 0) {
            return M();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(P(pairArr.length));
        W(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static LinkedHashMap S(Pair... pairArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(P(pairArr.length));
        W(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static LinkedHashMap T(Map map, Map map2) {
        k.f(map, "<this>");
        k.f(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static Map U(Map map, Pair pair) {
        k.f(map, "<this>");
        if (map.isEmpty()) {
            return Q(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.f4886a, pair.b);
        return linkedHashMap;
    }

    public static void V(Map map, Iterable pairs) {
        k.f(map, "<this>");
        k.f(pairs, "pairs");
        Iterator it = pairs.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            map.put(pair.f4886a, pair.b);
        }
    }

    public static void W(Map map, Pair[] pairs) {
        k.f(map, "<this>");
        k.f(pairs, "pairs");
        for (Pair pair : pairs) {
            map.put(pair.f4886a, pair.b);
        }
    }

    public static Map X(Iterable iterable) {
        k.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            V(linkedHashMap, iterable);
            int size = linkedHashMap.size();
            return size != 0 ? size != 1 ? linkedHashMap : b0(linkedHashMap) : M();
        }
        Collection collection = (Collection) iterable;
        int size2 = collection.size();
        if (size2 == 0) {
            return M();
        }
        if (size2 == 1) {
            return Q((Pair) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(P(collection.size()));
        V(linkedHashMap2, iterable);
        return linkedHashMap2;
    }

    public static Map Y(Map map) {
        k.f(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? a0(map) : b0(map) : M();
    }

    public static Map Z(Pair[] pairArr) {
        k.f(pairArr, "<this>");
        int length = pairArr.length;
        if (length == 0) {
            return M();
        }
        if (length == 1) {
            return Q(pairArr[0]);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(P(pairArr.length));
        W(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static LinkedHashMap a0(Map map) {
        k.f(map, "<this>");
        return new LinkedHashMap(map);
    }

    public static final Map b0(Map map) {
        k.f(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        k.e(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }
}

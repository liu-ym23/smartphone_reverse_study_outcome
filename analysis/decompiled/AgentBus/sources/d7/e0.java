package d7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class e0 extends ib.c {
    public static Object Q(Object obj, Map map) {
        q7.k.e(map, "<this>");
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }

    public static LinkedHashMap R(c7.j... jVarArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(S(jVarArr.length));
        Y(linkedHashMap, jVarArr);
        return linkedHashMap;
    }

    public static int S(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map T(c7.j jVar) {
        q7.k.e(jVar, "pair");
        Map mapSingletonMap = Collections.singletonMap(jVar.f1973f, jVar.f1974g);
        q7.k.d(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static Map U(c7.j... jVarArr) {
        if (jVarArr.length <= 0) {
            return a0.f2944f;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(S(jVarArr.length));
        Y(linkedHashMap, jVarArr);
        return linkedHashMap;
    }

    public static LinkedHashMap V(c7.j... jVarArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(S(jVarArr.length));
        Y(linkedHashMap, jVarArr);
        return linkedHashMap;
    }

    public static LinkedHashMap W(Map map, Map map2) {
        q7.k.e(map, "<this>");
        q7.k.e(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static Map X(Map map, c7.j jVar) {
        if (map.isEmpty()) {
            return T(jVar);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(jVar.f1973f, jVar.f1974g);
        return linkedHashMap;
    }

    public static final void Y(HashMap map, c7.j[] jVarArr) {
        for (c7.j jVar : jVarArr) {
            map.put(jVar.f1973f, jVar.f1974g);
        }
    }

    public static Map Z(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return a0.f2944f;
        }
        if (size == 1) {
            return T((c7.j) arrayList.get(0));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(S(arrayList.size()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c7.j jVar = (c7.j) it.next();
            linkedHashMap.put(jVar.f1973f, jVar.f1974g);
        }
        return linkedHashMap;
    }

    public static Map a0(Map map) {
        q7.k.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? b0(map) : c0(map) : a0.f2944f;
    }

    public static LinkedHashMap b0(Map map) {
        q7.k.e(map, "<this>");
        return new LinkedHashMap(map);
    }

    public static final Map c0(Map map) {
        q7.k.e(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        q7.k.d(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }
}

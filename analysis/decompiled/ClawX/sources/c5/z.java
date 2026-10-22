package c5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class z extends b8.h {
    public static Object S(Map map, Object obj) {
        kotlin.jvm.internal.p.e(map, "<this>");
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }

    public static int T(int i8) {
        if (i8 < 0) {
            return i8;
        }
        if (i8 < 3) {
            return i8 + 1;
        }
        if (i8 < 1073741824) {
            return (int) ((i8 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map U(b5.g... gVarArr) {
        if (gVarArr.length <= 0) {
            return t.f1093a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(T(gVarArr.length));
        X(gVarArr, linkedHashMap);
        return linkedHashMap;
    }

    public static Map V(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return t.f1093a;
        }
        if (size == 1) {
            b5.g pair = (b5.g) arrayList.get(0);
            kotlin.jvm.internal.p.e(pair, "pair");
            Map mapSingletonMap = Collections.singletonMap(pair.f892a, pair.f893b);
            kotlin.jvm.internal.p.d(mapSingletonMap, "singletonMap(...)");
            return mapSingletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(T(arrayList.size()));
        int size2 = arrayList.size();
        int i8 = 0;
        while (i8 < size2) {
            Object obj = arrayList.get(i8);
            i8++;
            b5.g gVar = (b5.g) obj;
            linkedHashMap.put(gVar.f892a, gVar.f893b);
        }
        return linkedHashMap;
    }

    public static Map W(Map map) {
        kotlin.jvm.internal.p.e(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return t.f1093a;
        }
        if (size != 1) {
            return new LinkedHashMap(map);
        }
        kotlin.jvm.internal.p.e(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        kotlin.jvm.internal.p.d(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }

    public static final void X(b5.g[] gVarArr, LinkedHashMap linkedHashMap) {
        for (b5.g gVar : gVarArr) {
            linkedHashMap.put(gVar.f892a, gVar.f893b);
        }
    }
}

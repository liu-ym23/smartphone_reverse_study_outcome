package kb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class w extends x {
    public static Object M(Map map, Object obj) {
        map.getClass();
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }

    public static Map N(jb.g... gVarArr) {
        if (gVarArr.length <= 0) {
            return t.f7405c;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(x.L(gVarArr.length));
        O(linkedHashMap, gVarArr);
        return linkedHashMap;
    }

    public static final void O(HashMap map, jb.g[] gVarArr) {
        for (jb.g gVar : gVarArr) {
            map.put(gVar.f6759c, gVar.f6760f);
        }
    }

    public static List P(LinkedHashMap linkedHashMap) {
        if (linkedHashMap.size() != 0) {
            Iterator it = linkedHashMap.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!it.hasNext()) {
                    return ac.a.E(new jb.g(entry.getKey(), entry.getValue()));
                }
                ArrayList arrayList = new ArrayList(linkedHashMap.size());
                arrayList.add(new jb.g(entry.getKey(), entry.getValue()));
                do {
                    Map.Entry entry2 = (Map.Entry) it.next();
                    arrayList.add(new jb.g(entry2.getKey(), entry2.getValue()));
                } while (it.hasNext());
                return arrayList;
            }
        }
        return s.f7404c;
    }

    public static Map Q(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return t.f7405c;
        }
        int i = 0;
        if (size == 1) {
            jb.g gVar = (jb.g) arrayList.get(0);
            gVar.getClass();
            Map mapSingletonMap = Collections.singletonMap(gVar.f6759c, gVar.f6760f);
            mapSingletonMap.getClass();
            return mapSingletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(x.L(arrayList.size()));
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            jb.g gVar2 = (jb.g) obj;
            linkedHashMap.put(gVar2.f6759c, gVar2.f6760f);
        }
        return linkedHashMap;
    }

    public static Map R(Map map) {
        map.getClass();
        int size = map.size();
        if (size == 0) {
            return t.f7405c;
        }
        if (size != 1) {
            return new LinkedHashMap(map);
        }
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        mapSingletonMap.getClass();
        return mapSingletonMap;
    }
}

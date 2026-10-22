package g4;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: g4.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1455b {
    public static LinkedHashMap a(Object obj) {
        Map map = obj instanceof Map ? (Map) obj : null;
        if (map == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key instanceof String) {
                linkedHashMap.put(key, value);
            }
        }
        return linkedHashMap;
    }
}

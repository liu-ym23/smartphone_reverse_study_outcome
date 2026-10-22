package u4;

import com.stepos.agentcache.core.ServiceContract;
import d7.a0;
import java.util.Map;

/* loaded from: classes.dex */
public final class i {
    public static String a(c5.b bVar) {
        q7.k.e(bVar, "frame");
        Object obj = bVar.f1897b.get("params");
        Map map = obj instanceof Map ? (Map) obj : null;
        if (map != null) {
            Object obj2 = map.get("_meta");
            Map map2 = obj2 instanceof Map ? (Map) obj2 : null;
            if (map2 != null) {
                Object obj3 = map2.get("trace");
                Map map3 = obj3 instanceof Map ? (Map) obj3 : null;
                if (map3 != null) {
                    Object obj4 = map3.get(ServiceContract.RequiredKeys.TRACE_ID);
                    if (obj4 instanceof String) {
                        return (String) obj4;
                    }
                }
            }
        }
        return null;
    }

    public static e7.g b(String str, Map map, String str2, String str3, e7.g gVar, int i2) {
        if ((i2 & 2) != 0) {
            map = null;
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        Map map2 = gVar;
        if ((i2 & 16) != 0) {
            map2 = a0.f2944f;
        }
        q7.k.e(str, "nodeLabel");
        q7.k.e(str2, "sessionId");
        e7.g gVar2 = new e7.g();
        gVar2.put("node", str);
        if (str3 != null) {
            gVar2.put("status", str3);
        }
        gVar2.put("sessionId", str2);
        gVar2.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        if (map != null) {
            gVar2.put("frame", map);
        }
        gVar2.putAll(map2);
        return gVar2.c();
    }
}

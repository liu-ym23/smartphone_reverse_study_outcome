package N3;

import D7.q;
import D7.v;
import android.util.Log;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f1007a = {"metas", "entries", GuiTaskProgressKt.GuiTaskProgress_KEY_EXTRAS};

    public static LinkedHashMap a(Object obj) {
        List list;
        Object objB;
        String string;
        LinkedHashMap linkedHashMap = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            list = (List) obj;
        } else {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                for (int i = 0; i < 3; i++) {
                    Object obj2 = map.get(f1007a[i]);
                    List list2 = obj2 instanceof List ? (List) obj2 : null;
                    if (list2 != null) {
                        list = list2;
                        break;
                    }
                }
            } else {
                try {
                    Log.w("AppFunctionsMetaParser", "parse: unsupported _meta type ".concat(obj.getClass().getName()));
                } catch (RuntimeException unused) {
                }
            }
            list = null;
        }
        List list3 = list;
        if (list3 != null && !list3.isEmpty()) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : list) {
                Map map2 = obj3 instanceof Map ? (Map) obj3 : null;
                if (map2 != null && (objB = b(map2.get("key"))) != null && (string = objB.toString()) != null) {
                    if (string.length() <= 0) {
                        string = null;
                    }
                    if (string != null && map2.containsKey("value")) {
                        linkedHashMap2.put(string, b(map2.get("value")));
                    }
                }
            }
            if (!linkedHashMap2.isEmpty()) {
                linkedHashMap = linkedHashMap2;
            }
        }
        if (linkedHashMap == null && list != null && !list.isEmpty()) {
            try {
                Log.w("AppFunctionsMetaParser", "parse: _meta list present but no valid key/value pairs: <redacted>");
            } catch (RuntimeException unused2) {
            }
        }
        return linkedHashMap;
    }

    public static Object b(Object obj) {
        if (obj != null) {
            if (obj instanceof List) {
                Object objC0 = v.C0((List) obj);
                if (objC0 != null) {
                    return b(objC0);
                }
            } else {
                if (!(obj instanceof Object[])) {
                    return obj;
                }
                Object objN0 = q.n0((Object[]) obj);
                if (objN0 != null) {
                    return b(objN0);
                }
            }
        }
        return null;
    }
}

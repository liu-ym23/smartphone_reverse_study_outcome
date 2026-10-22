package cd;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    public static final <K, V> JSONObject a(Map<K, ? extends V> r100) {
        return new JSONObject(r100);
    L5:
        return new JSONObject();
    }

    public static final String b(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L10:
        if (r100 == false) goto L12;
        return null;
    L12:
        List r111 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
        if (r111.size() >= 2) goto L16;
        return null;
    L16:
        return ((String) ListProtector.get(r111, 0)) + "." + ((String) ListProtector.get(r111, 1)) + ".c0.d0";
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L10
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "DO NOT USE", replaceWith = @ReplaceWith(expression = "buildJSONObject", imports = {}))
    public static final <K, V> JSONObject c(Map<K, ? extends V> r100) {
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<K, ? extends V>> r102 = r100.entrySet().iterator();     // Catch: Throwable -> L14
    L5:
        if (r102.hasNext() == false) goto L13;
        Map.Entry<K, ? extends V> r103 = r102.next();     // Catch: Throwable -> L14
        K r104 = r103.getKey();     // Catch: Throwable -> L14
        if ((r104 instanceof String) == true) goto L9;
        r104 = (K) null;
    L9:
        String r105 = r104;     // Catch: Throwable -> L14
        if (r105 == null) goto L5;
        r101.put(r105, r103.getValue());     // Catch: Throwable -> L14
    L13:
        return r101;
    }

    public static final List<Object> d(JSONArray r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        Object r104 = r100.get(r103);     // Catch: Exception -> L13
        if ((r104 instanceof JSONArray) == false) goto L8;
        r104 = d((JSONArray) r104);     // Catch: Exception -> L13
    L10:
        r101.add(r104);     // Catch: Exception -> L13
        goto L11
    L8:
        if ((r104 instanceof JSONObject) == false) goto L10;
        r104 = e((JSONObject) r104);     // Catch: Exception -> L13
    L11:
        r103 = r103 + 1;
        goto L3
    L12:
        return r101;
    }

    public static final Map<String, Object> e(JSONObject r100) {
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next();     // Catch: Exception -> L13
        Object r104 = r100.get(r103);     // Catch: Exception -> L13
        if ((r104 instanceof JSONArray) == false) goto L9;
        r104 = d((JSONArray) r104);     // Catch: Exception -> L13
    L11:
        r101.put(r103, r104);     // Catch: Exception -> L13
        goto L4
    L9:
        if ((r104 instanceof JSONObject) == false) goto L11;
        r104 = e((JSONObject) r104);     // Catch: Exception -> L13
        goto L11
    L14:
        return r101;
    }
}

package cc4;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class j {
    public static Map<String, Long> a(long r110, JSONArray r111, String r112, String r113) {
        HashMap r100 = new HashMap();
        if (r111 != null) goto L5;
    L64:
        return r100;
    L5:
        if (r111.length() <= 0) goto L64;
        int r114 = 0;
        long r115 = -1;
        if ("nocaptcha".equals(r112) == false) goto L36;
        HashMap r101 = new HashMap();
        if ("pre_collect".equals(r113) == false) goto L22;
        long r102 = 0;
    L12:
        if (r114 >= r111.length()) goto L18;
        JSONObject r103 = r111.optJSONObject(r114);
        if (r103 == null) goto L16;
        r102 = r102 + r103.optLong("et");
    L16:
        r114 = r114 + 1;
        goto L12
    L18:
        if (r110 <= 0) goto L20;
        r115 = r102 / r110;
    L20:
        r101.put("zenith", Long.valueOf(r115));
    L34:
        return r101;
    L22:
        if ("async_collect".equals(r113) == false) goto L34;
        long r104 = 0;
    L25:
        if (r114 >= r111.length()) goto L31;
        JSONObject r105 = r111.optJSONObject(r114);
        if (r105 == null) goto L29;
        r104 = r104 + r105.optLong("t");
    L29:
        r114 = r114 + 1;
        goto L25
    L31:
        if (r110 <= 0) goto L33;
        r115 = r104 / r110;
    L33:
        r101.put("tranquility", Long.valueOf(r115));
        goto L34
    L36:
        if ("nocaptcha_collect".equals(r112) == false) goto L64;
        HashMap r106 = new HashMap();
        if ("pre_collect".equals(r113) == false) goto L51;
        long r107 = 0;
    L41:
        if (r114 >= r111.length()) goto L47;
        JSONObject r108 = r111.optJSONObject(r114);
        if (r108 == null) goto L45;
        r107 = r107 + r108.optLong("et");
    L45:
        r114 = r114 + 1;
        goto L41
    L47:
        if (r110 <= 0) goto L49;
        r115 = r107 % r110;
    L49:
        r106.put("renaissance", Long.valueOf(r115));
    L63:
        return r106;
    L51:
        if ("async_collect".equals(r113) == false) goto L63;
        long r109 = 0;
    L54:
        if (r114 >= r111.length()) goto L60;
        JSONObject r116 = r111.optJSONObject(r114);
        if (r116 == null) goto L58;
        r109 = r109 + r116.optLong("t");
    L58:
        r114 = r114 + 1;
        goto L54
    L60:
        if (r110 <= 0) goto L62;
        r115 = r109 % r110;
    L62:
        r106.put("miraculous", Long.valueOf(r115));
        goto L63
    }
}

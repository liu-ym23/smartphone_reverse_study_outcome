package r3;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static JSONObject a(JSONObject r10, JSONObject r11) {
        if (r10 == null) goto L15;
        if (r11 == null) goto L15;
        Iterator<String> r12 = r11.keys();
        if (r12 != null) goto L10;
        return null;
    L10:
        if (r12.hasNext() == false) goto L14;
        String r13 = r12.next();
        if (r11.isNull(r13) == true) goto L10;
        r10.put(r13, r11.opt(r13));
        goto L10
    L14:
        return r10;
    L15:
        return null;
    }

    public static void b(JSONObject r10, JSONObject r11) {
        if (r11 == null) goto L20;
        if (r10 == null) goto L29;
        Iterator<String> r12 = r11.keys();
    L7:
        if (r12.hasNext() == false) goto L30;
        String[] r13 = r12.next().split("#");
        int r14 = 0;
        JSONObject r15 = r10;
    L10:
        if (r14 >= (r13.length - 1)) goto L18;
        if (r15.has(r13[r14]) == false) goto L17;
        if (r15.get(r13[r14]).getClass().equals(JSONObject.class) == false) goto L17;
        r15 = r15.getJSONObject(r13[r14]);
        r14 = r14 + 1;
    L17:
        r15 = null;
    L18:
        if (r15 == null) goto L7;
        r15.remove(r13[r13.length - 1]);
        goto L7
    L30:
        return;
    L29:
        return;
    }

    public static boolean c(JSONArray r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.length() == 0) goto L7;
        return false;
    }

    public static boolean d(JSONObject r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.length() == 0) goto L7;
        return false;
    }

    public static void e(JSONObject r10, JSONObject r11) {
        if (r11 == null) goto L18;
        if (r10 == null) goto L23;
        Iterator<String> r12 = r11.keys();
    L7:
        if (r12.hasNext() == false) goto L24;
        String r13 = r12.next();
        String[] r14 = r13.split("#");
        int r15 = 0;
        JSONObject r16 = r10;
    L10:
        if (r15 >= (r14.length - 1)) goto L17;
        if (r16.has(r14[r15]) == true) goto L14;
    L15:
        r16.put(r14[r15], new JSONObject());
    L16:
        r16 = r16.getJSONObject(r14[r15]);
        r15 = r15 + 1;
        goto L10
    L14:
        if (r16.get(r14[r15]).getClass().equals(JSONObject.class) == true) goto L16;
    L17:
        r16.put(r14[r14.length - 1], r11.get(r13));
        goto L7
    L24:
        return;
    L23:
        return;
    }

    public static int f(JSONObject r10, String r11, String r12) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        JSONObject r13 = r10.optJSONObject(r11);
        if (r13 != null) goto L9;
        return 0;
    L9:
        return r13.optInt(r12, 0);
    }

    public static JSONObject g(JSONObject r10, String r11, String r12) {
        if (r10 != null) goto L5;
        return null;
    L5:
        JSONObject r13 = r10.optJSONObject(r11);
        if (r13 != null) goto L9;
        return null;
    L9:
        return r13.optJSONObject(r12);
    }

    public static JSONObject h(JSONObject r10, String r11, String r12, String r13) {
        JSONObject r14 = g(r10, r11, r12);
        if (r14 != null) goto L7;
        return null;
    L7:
        return r14.optJSONObject(r13);
    }

    public static int i(JSONObject r10, String r11) {
    L8:
        e = move-exception;
        s3.a.c("JsonUtils", "removeInt", e);
        return 0;
    L4:
        if (r10.has(r11) == true) goto L6;
        return 0;
    L6:
        int r12 = r10.getInt(r11);     // Catch: Exception -> L8
        r10.remove(r11);     // Catch: Exception -> L8
        return r12;
    }

    public static long j(JSONObject r10, String r11) {
    L8:
        e = move-exception;
        s3.a.c("JsonUtils", "removeLong", e);
        return 0;
    L4:
        if (r10.has(r11) == true) goto L6;
        return 0;
    L6:
        long r12 = r10.getLong(r11);     // Catch: Exception -> L8
        r10.remove(r11);     // Catch: Exception -> L8
        return r12;
    }

    public static String k(JSONObject r10, String r11) {
    L8:
        e = move-exception;
        s3.a.c("JsonUtils", "removeString", e);
        return null;
    L4:
        if (r10.has(r11) == true) goto L6;
        return null;
    L6:
        String r12 = r10.getString(r11);     // Catch: Exception -> L8
        r10.remove(r11);     // Catch: Exception -> L8
        return r12;
    }

    public static JSONObject l(JSONObject r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Iterator<String> r11 = r10.keys();
        if (r11 != null) goto L27;
        return null;
    L27:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L26
    L9:
        if (r11.hasNext() == false) goto L25;
        String r13 = r11.next();     // Catch: Exception -> L26
        Object r14 = r10.opt(r13);     // Catch: Exception -> L26
        if ((r14 instanceof JSONObject) == true) goto L13;
        if ((r14 instanceof JSONArray) == true) goto L18;
        r12.put(r13, r14);     // Catch: Exception -> L26
        goto L9
    L18:
        JSONArray r15 = (JSONArray) r14;     // Catch: Exception -> L26
        JSONArray r16 = new JSONArray();     // Catch: Exception -> L26
        int r17 = 0;
    L20:
        if (r17 >= r15.length()) goto L22;
        r16.put(r15.get(r17));     // Catch: Exception -> L26
        r17 = r17 + 1;     // Catch: Exception -> L26
        goto L20
    L22:
        r12.put(r13, r16);     // Catch: Exception -> L26
        goto L9
    L13:
        JSONObject r18 = m((JSONObject) r14);     // Catch: Exception -> L26
        if (r18 == null) goto L9;
        r12.put(r13, r18);     // Catch: Exception -> L26
        goto L9
    L25:
        return r12;
    L26:
        return r10;
    }

    public static JSONObject m(JSONObject r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Iterator<String> r11 = r10.keys();
        if (r11 != null) goto L15;
        return null;
    L15:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L14
    L10:
        if (r11.hasNext() == false) goto L13;
        String r13 = r11.next();     // Catch: Exception -> L14
        r12.put(r13, r10.opt(r13));     // Catch: Exception -> L14
        goto L10
    L13:
        return r12;
    L14:
        return r10;
    }
}

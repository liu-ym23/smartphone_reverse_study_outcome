package bz2;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class e {
    public static JSONObject j(String r100) {
    L8:
        c.a();
        return new JSONObject();
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return new JSONObject();
    L7:
        return new JSONObject(r100);
    }

    public static void a(JSONObject r100, JSONObject r101) {
        if (r100 == null) goto L16;
        if (r101 == null) goto L17;
        Iterator<String> r102 = r101.keys();     // Catch: Exception -> L10
    L7:
        if (r102.hasNext() == false) goto L18;
        String r103 = r102.next();     // Catch: Exception -> L10
        h(r100, r103, d(r101, r103));     // Catch: Exception -> L10
        goto L7
    L18:
        return;
    L10:
        c.a();
        return;
    L17:
        return;
    }

    public static JSONObject c(JSONObject r100, String r101) {
        if (r100 != null) goto L5;
        return new JSONObject();
    L5:
        return r100.optJSONObject(r101);
    }

    public static Object d(JSONObject r100, String r101) {
        if (r100 != null) goto L5;
        return new Object();
    L5:
        return r100.opt(r101);
    }

    public static String e(JSONObject r100, String r101) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.optString(r101, "");
    }

    public static boolean b(JSONObject r100, String r101, Boolean r102) {
        return r100.optBoolean(r101, r102.booleanValue());
    }

    public static void f(JSONObject r100, String r101, int r102) {
        r100.put(r101, r102);     // Catch: Exception -> L4
        return;
    L4:
        c.a();
    }

    public static void g(JSONObject r100, String r101, long r102) {
        r100.put(r101, r102);     // Catch: Exception -> L4
        return;
    L4:
        c.a();
    }

    public static void h(JSONObject r100, String r101, Object r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        c.a();
    }

    public static void i(JSONObject r100, String r101, String r102) {
        r100.put(r101, r102);     // Catch: Exception -> L4
        return;
    L4:
        c.a();
    }
}

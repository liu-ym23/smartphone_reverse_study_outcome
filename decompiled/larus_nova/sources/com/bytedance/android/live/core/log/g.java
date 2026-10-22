package com.bytedance.android.live.core.log;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public abstract class g {
    public g() {
    }

    public abstract JSONObject h();

    public static JSONObject l(Map r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r101 = new JSONObject();
        Iterator r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        Map.Entry r103 = (Map.Entry) r102.next();     // Catch: Exception -> L10
        r101.put((String) r103.getKey(), r103.getValue());     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L7
    L12:
        return r101;
    }

    public static void a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        ALogger.d(r100, r101);
        return;
    }

    public static void c(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        ALogger.e(r100, r101);
        return;
    }

    public static void e(String r100, Throwable r101) {
        if (TextUtils.isEmpty(r100) == true) goto L8;
        if (r101 == null) goto L9;
        ALogger.e(r100, r101);
        return;
    L9:
        return;
    }

    public static void i(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        ALogger.i(r100, r101);
        return;
    }

    public static void m(int r100, StackTraceElement[] r101) {
        ALogger.stacktrace(r100, "ttlive_exception", r101);
    }

    public static void n(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        ALogger.w(r100, r101);
        return;
    }

    public final void b(final String r100, final Map<String, ?> r101) {
        if (TextUtils.isEmpty(r100) == true) goto L8;
        if (r101 == null) goto L9;
        ALogger.d(r100, new e(this, r100, r101));
        return;
    L9:
        return;
    }

    public final void f(String r100, Map<String, ?> r101) {
        if (TextUtils.isEmpty(r100) == true) goto L8;
        if (r101 == null) goto L9;
        ALogger.e(r100, g(r100, l(r101)));
        return;
    L9:
        return;
    }

    public final String g(String r100, JSONObject r101) {
        JSONObject r102 = new JSONObject();
        JSONObject r103 = h();
        r102.put("tag", r100);     // Catch: Exception -> L8
        if (r103 == null) goto L6;
        r102.put("params", h());     // Catch: Exception -> L8
    L6:
        r102.put("data", r101.toString());     // Catch: Exception -> L8
    L11:
        return r102.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public final void j(String r100, Map<String, ?> r101) {
        if (TextUtils.isEmpty(r100) == true) goto L8;
        if (r101 == null) goto L9;
        k(r100, l(r101));
        return;
    L9:
        return;
    }

    public final void k(String r100, JSONObject r101) {
        if (TextUtils.isEmpty(r100) == true) goto L8;
        if (r101 == null) goto L9;
        ALogger.i(r100, g(r100, r101));
        return;
    L9:
        return;
    }

    public static void d(String r100, String r101, Throwable r102) {
        if (TextUtils.isEmpty(r100) == true) goto L8;
        if (r102 == null) goto L9;
        ALogger.e(r100, r101, r102);
        return;
    L9:
        return;
    }
}

package com.apm.lite.k;

import android.text.TextUtils;
import com.apm.lite.CrashType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class r {
    public static void a(k1.a r100, k1.c r101, CrashType r110) {
        JSONObject r102 = r100.f501330a;
        if (r102 == null) goto L22;
        if (r110 == null) goto L26;
        long r103 = r102.optLong("crash_time");
        String r104 = com.apm.lite.e.d().a();
        if (r103 > 0) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r110.getName()) == true) goto L24;
        String r111 = "android__" + r104 + "_" + r103 + "_" + r110;     // Catch: JSONException -> L17
        if (r101 == null) goto L15;
        r102 = r101.f501337a;     // Catch: JSONException -> L17
        if (r102 != null) goto L15;
        return;
    L15:
        r102.put("unique_key", r111);     // Catch: JSONException -> L17
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L24:
        return;
    L26:
        return;
    }
}

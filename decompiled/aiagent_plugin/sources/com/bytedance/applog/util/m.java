package com.bytedance.applog.util;

import android.text.TextUtils;
import com.bytedance.bdturing.localstorage.DbHelper;
import org.json.JSONObject;

/* JADX INFO: compiled from: SensitiveUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    public static JSONObject a(JSONObject r4) {
        JSONObject r1 = r4.optJSONObject("oaid");     // Catch: Exception -> L9
        if (r1 == null) goto L11;
        String r2 = r1.optString(DbHelper.COL_ID, null);     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r2) == true) goto L11;
        r4.put("oaid", r2);     // Catch: Exception -> L9
    L11:
        return r4;
    L9:
        e = move-exception;
        com.bytedance.applog.log.m.a().a("transferHeader failed", e, new Object[0]);
        goto L11
    }
}

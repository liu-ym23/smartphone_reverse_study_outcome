package com.ss.android.common.applog;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: compiled from: TeaUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class ad {
    public static long a() {
        return System.currentTimeMillis();
    }

    public static boolean a(Object r0, Object r1) {
        if (r0 != null) goto L7;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r0.equals(r1);
    }

    public static long a(JSONObject r2, String r3) {
        if (r2 != null) goto L9;
        return 0;
    L9:
        return Long.valueOf(r2.optString(r3)).longValue();
    L11:
        return 0;
    }

    public static SimpleDateFormat a(String r2) {
        SimpleDateFormat r0 = new SimpleDateFormat(r2, Locale.US);
        r0.setTimeZone(TimeZone.getTimeZone("UTC+8"));
        return r0;
    }
}

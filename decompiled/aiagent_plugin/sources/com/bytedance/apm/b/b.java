package com.bytedance.apm.b;

import com.bytedance.apm.util.u;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: AlogMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(String r2, Throwable r3) {
        if (com.bytedance.apm.c.i() == false) goto L10;
        String[] r0 = new String[2];
        r0[0] = r2;
        if (r3 == null) goto L7;
        String r4 = r3.getMessage();
    L8:
        r0[1] = r4;
        com.bytedance.apm.h.e.c("AlogUploadTag", r0);
        return;
    L7:
        r4 = "";
        goto L8
    }

    public static void a(String r1) {
        a(r1, null);
    }

    public static JSONObject a(boolean r1, int r2, Exception r3, JSONObject r4) {
        if (r4 != null) goto L11;
        r4 = new JSONObject();
    L11:
        r4.put("success", r1);     // Catch: Exception -> L8
        r4.put(MonitorConstants.CODE, r2);     // Catch: Exception -> L8
        if (r3 == null) goto L10;
        r4.put("exception", r3.getMessage() + u.a(r3));     // Catch: Exception -> L8
        r4.put("exception_object", r3);     // Catch: Exception -> L8
    L10:
        return r4;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}

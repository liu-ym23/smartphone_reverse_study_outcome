package com.bytedance.crash.dumper;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppVersion.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(long r2, long r4, long r6, String r8) {
        if (r2 != 0) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r8) == true) goto L14;
        JSONObject r0 = new JSONObject();
        r0.put("version_code", r2);     // Catch: Throwable -> L11
        r0.put("update_version_code", r4);     // Catch: Throwable -> L11
        r0.put("version_name", r8);     // Catch: Throwable -> L11
        r0.put("manifest_version_code", r6);     // Catch: Throwable -> L11
        return r0.toString();
    L15:
        return null;
    L14:
        return null;
    }

    public static void a(File r6) {
        com.bytedance.crash.monitor.a r0 = com.bytedance.crash.monitor.h.a();
        if (r0 != null) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        if (r0.i() == 0) goto L11;
        if (TextUtils.isEmpty(r0.l()) == true) goto L11;
        r1.put("version_code", r0.i());     // Catch: Throwable -> L14
        r1.put("update_version_code", r0.j());     // Catch: Throwable -> L14
        r1.put("version_name", r0.l());     // Catch: Throwable -> L14
        r1.put(WsConstants.KEY_APP_VERSION, r0.l());     // Catch: Throwable -> L14
        r1.put("manifest_version_code", r0.k());     // Catch: Throwable -> L14
    L11:
        if (r1.length() <= 0) goto L17;
        com.bytedance.crash.o.i.c(new File(r6, "version.json"), r1.toString());
        return;
    }

    public static boolean a(JSONObject r2, File r3) {
        String r4 = com.bytedance.crash.o.i.d(new File(r3, "version.json"));
        if (r4 != null) goto L10;
        return false;
    L10:
        JSONObject r0 = new JSONObject(r4);     // Catch: Throwable -> L9
        com.bytedance.crash.o.l.b(r2, r0);     // Catch: Throwable -> L9
        com.bytedance.crash.o.r.a("AppVersion:load", r0);     // Catch: Throwable -> L9
        return true;
    L12:
        return false;
    }
}

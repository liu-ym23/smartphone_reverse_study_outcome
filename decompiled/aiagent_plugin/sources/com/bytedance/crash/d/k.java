package com.bytedance.crash.d;

import android.os.Process;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.crash.CrashSummary;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.o.o;
import com.bytedance.crash.o.r;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ProtectorManager.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    private static final String TAG = "ProtectorManager";

    public static void a() {
        File r0 = new File(com.bytedance.crash.i.d(), "protector");
        if (r0.exists() == true) goto L5;
        return;
    L5:
        File[] r1 = r0.listFiles();
        if (r1 == null) goto L10;
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L12;
        a(r1[r3]);
        r3 = r3 + 1;
        goto L8
    L12:
        return;
    }

    private static boolean a(File r11) {
        long r3 = System.currentTimeMillis();
        r.b(TAG, "upload " + r11.getAbsolutePath());     // Catch: Exception -> L20
        com.bytedance.crash.monitor.a r6 = com.bytedance.crash.monitor.h.a();     // Catch: Exception -> L20
        if (r6 != null) goto L6;
        return false;
    L6:
        JSONObject r4 = Header.a(r6, r3, CrashType.NATIVE_CUSTOMIZE, Process.myPid()).b();     // Catch: Exception -> L20
        CrashSummary r5 = CrashSummary.loadFromDirectory(r11);     // Catch: Exception -> L20
        if (r5 != null) goto L10;
        r.c(TAG, "upload delete dir" + r11.getAbsolutePath());     // Catch: Exception -> L20
        com.bytedance.crash.o.i.c(r11);     // Catch: Exception -> L20
        return false;
    L10:
        JSONObject r7 = r5.assemblyCrashBody(r6).c();     // Catch: Exception -> L20
        r7.put("event_type", "native_exception");     // Catch: Exception -> L20
        r7.put("message", "protector");     // Catch: Exception -> L20
        r7.put("log_type", "1");     // Catch: Exception -> L20
        r7.put(DBHelper.COL_TIME, System.currentTimeMillis());     // Catch: Exception -> L20
        r7.put("exception_type", 1);     // Catch: Exception -> L20
        String r8 = r5.getStackTrace();     // Catch: Exception -> L20
        if (r8 == null) goto L13;
        r7.put("class_ref", "Native");     // Catch: Exception -> L20
        r7.put("method", "Native");     // Catch: Exception -> L20
        r7.put("is_core", 1);     // Catch: Exception -> L20
        r7.put("line_num", -1);     // Catch: Exception -> L20
        r7.put("ensure_type", "EnsureNotReachHere");     // Catch: Exception -> L20
        r7.put("crash_lib_uuid", o.a().d(r8));     // Catch: Exception -> L20
        r7.put("stack", r8);     // Catch: Exception -> L20
        r7.put("has_dump", "true");     // Catch: Exception -> L20
    L13:
        JSONObject r0 = r7.optJSONObject("filters");     // Catch: Exception -> L20
        if (r0 != null) goto L16;
        r0 = new JSONObject();     // Catch: Exception -> L20
        r7.put("filters", r0);     // Catch: Exception -> L20
    L16:
        com.bytedance.crash.a.b.a(r6, r5, r11, r0);     // Catch: Exception -> L20
        JSONArray r1 = new JSONArray();     // Catch: Exception -> L20
        r1.put(r7);     // Catch: Exception -> L20
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L20
        r2.put("data", r1);     // Catch: Exception -> L20
        r2.put("header", r4);     // Catch: Exception -> L20
        boolean r9 = com.bytedance.crash.upload.b.a("ensure_zip", com.bytedance.crash.upload.o.a(com.bytedance.crash.config.f.h(), r4), r2.toString(), b(r11)).a();     // Catch: Exception -> L20
        if (r9 == false) goto L19;
        r.a(TAG, "upload success");     // Catch: Exception -> L20
        com.bytedance.crash.o.j.a(r11);     // Catch: Exception -> L20
    L19:
        return r9;
    L20:
        return false;
    }

    private static List<File> b(File r6) {
        ArrayList r0 = new ArrayList();
        File[] r7 = r6.listFiles();
        if (r7 == null) goto L15;
        int r1 = r7.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L15;
        File r3 = r7[r2];
        String r4 = r3.getName();
        if (r4.endsWith(".summary") == true) goto L14;
        if (r4.endsWith(".json") == true) goto L14;
        if (r4.endsWith(".inf") == true) goto L14;
        r0.add(r3);
    L14:
        r2 = r2 + 1;
    L15:
        return r0;
    }
}

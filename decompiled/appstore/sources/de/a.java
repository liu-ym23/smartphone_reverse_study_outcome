package de;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Process;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.olog.OLog;
import com.slardaros.client.d;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static void a(JSONObject r10) {
        Context r11 = d.b();     // Catch: Throwable -> L4
        PackageInfo r12 = r11.getPackageManager().getPackageInfo(r11.getPackageName(), 0);     // Catch: Throwable -> L4
        r10.put("app_name", r11.getPackageName());     // Catch: Throwable -> L4
        r10.put("app_version", String.valueOf(r12.versionCode));     // Catch: Throwable -> L4
        r10.put("process_name", b());     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        OLog.d("Slardaros_Agent", "addCommonCategories: " + e.getMessage());
    }

    public static String b() {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L16
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L8
    L5:
        int r12 = r10.read();     // Catch: Throwable -> L8
        if (r12 <= 0) goto L10;
        r11.append((char) r12);     // Catch: Throwable -> L8
        goto L5
    L10:
        String r13 = r11.toString();     // Catch: Throwable -> L8
        r10.close();     // Catch: Exception -> L13
    L15:
        return r13;
    L13:
        e = move-exception;
        OLog.e("Slardaros_Agent", "getCurProcessNameFromProc: " + e.getMessage());
    L8:
        Throwable th = th;
    L39:
        OLog.e("Slardaros_Agent", "getCurProcessNameFromProc: " + th.getMessage());     // Catch: Throwable -> L26
        if (r10 == null) goto L46;
        r10.close();     // Catch: Exception -> L22
        return "unknown";
    L22:
        e = move-exception;
        OLog.e("Slardaros_Agent", "getCurProcessNameFromProc: " + e.getMessage());
        return "unknown";
    L46:
        return "unknown";
    L26:
        th = move-exception;
        if (r10 != null) goto L41;
    L32:
        throw th;
    L41:
        r10.close();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        OLog.e("Slardaros_Agent", "getCurProcessNameFromProc: " + e.getMessage());
    L16:
        th = move-exception;
        r10 = null;
        th = th;
        goto L39
    }

    public static void c(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        if (d.b() != null) goto L5;
        return;
    L5:
        a(r11);
        JSONObject r14 = new JSONObject();
        r14.put("category", r11);     // Catch: Exception -> L8
        r14.put("metrics", r12);     // Catch: Exception -> L8
        r14.put("client_timestamp", System.currentTimeMillis());     // Catch: Exception -> L8
        r14.put("log_type", "flexible");     // Catch: Exception -> L8
        r14.put("event_name", r10);     // Catch: Exception -> L8
        r14.put(WsConstants.KEY_EXTRA, r13);     // Catch: Exception -> L8
    L10:
        Intent r15 = new Intent("com.slardaros.metricevent.action");
        r15.putExtra(ServerElements.CODE, 0);
        r15.putExtra("event_name", r10);
        r15.putExtra("json_string", r14.toString());
        d.b().sendBroadcast(r15, "com.slardaros.METRIC_EVENT_PERMISSION");
        return;
    L8:
        e = move-exception;
        OLog.d("Slardaros_Agent", "generateTTNetMetricsObj: " + e.getMessage());
        goto L10
    }
}

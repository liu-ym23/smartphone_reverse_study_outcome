package com.bytedance.crash;

import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.services.apm.api.IApmAgent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: CrashAgent.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(CrashType r7, long r8, JSONObject r10) {
        if (r7 != CrashType.ANR) goto L5;
        boolean r0 = !TextUtils.isEmpty(r10.optString("anr_info"));
    L6:
        String r11 = ActivityLifecycle.c(r10);
        n r1 = i.j();     // Catch: Exception -> L25
        if (r1 != null) goto L12;
        IApmAgent r3 = (IApmAgent) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IApmAgent.class), IApmAgent.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L25
        if (r3 != null) goto L13;
        return;
    L13:
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L25
        r4.put("app_exit_metrics", r7.getName());     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r11) == true) goto L17;
        r4.put(DBHelper.BATTERY_COL_SCENE, r11);     // Catch: Exception -> L25
    L17:
        if (r7 != CrashType.ANR) goto L19;
        r4.put("has_anr_info", r0);     // Catch: Exception -> L25
    L19:
        r4.put("crash_time", r8);     // Catch: Exception -> L25
        if (r1 == null) goto L23;
        r1.a("hmd_app_exit_reason", r4, null, null);     // Catch: Exception -> L25
        return;
    L23:
        r3.monitorEvent("hmd_app_exit_reason", r4, null, null);     // Catch: Exception -> L25
        return;
    L12:
        r3 = null;
        goto L13
    L28:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void a(String r4, JSONObject r5, JSONObject r6, JSONObject r7) {
        n r0 = i.j();     // Catch: Exception -> L11
        IApmAgent r1 = null;
        if (r0 != null) goto L7;
        r1 = (IApmAgent) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IApmAgent.class), IApmAgent.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L11
        if (r1 != null) goto L7;
        return;
    L7:
        if (r0 == null) goto L9;
        r0.a(r4, r5, r6, r7);     // Catch: Exception -> L11
        return;
    L9:
        r1.monitorEvent(r4, r5, r6, r7);     // Catch: Exception -> L11
        return;
    }
}

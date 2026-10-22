package com.bytedance.memory.d;

import android.text.TextUtils;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.b;
import com.bytedance.services.slardar.config.IConfigManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L12;
        return;
    L12:
        IApmAgent r0 = (IApmAgent) ZeusTransformUtils.preCheckCast(d.a(IApmAgent.class), IApmAgent.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9
        if (r0 == null) goto L14;
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L9
        r1.put(r3, 1);     // Catch: Exception -> L9
        r0.monitorEvent("memory_dump_event", r1, null, null);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public static void b(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L12;
        return;
    L12:
        IApmAgent r0 = (IApmAgent) ZeusTransformUtils.preCheckCast(d.a(IApmAgent.class), IApmAgent.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9
        if (r0 == null) goto L14;
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L9
        r1.put(r4, 1);     // Catch: Exception -> L9
        r0.monitorEvent(b.g().a("memory_dump_event").a(r1).a(true).a());     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public static void a(String r3, long r4) {
        if (TextUtils.isEmpty(r3) == false) goto L12;
        return;
    L12:
        IApmAgent r0 = (IApmAgent) ZeusTransformUtils.preCheckCast(d.a(IApmAgent.class), IApmAgent.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9
        if (r0 == null) goto L14;
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L9
        r1.put(r3, r4);     // Catch: Exception -> L9
        r0.monitorEvent("memory_dump_event", null, r1, null);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean c(String r2) {
        if (a("performance_modules", "memory", r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (com.bytedance.memory.a.a.c().b() == true) goto L8;
        return false;
    }

    public static boolean d(String r2) {
        return a("performance_modules", "memory", r2);
    }

    public static boolean e(String r2) {
        return a("custom_event_settings", "allow_service_name", r2);
    }

    public static boolean a(String r4, String r5, String r6) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L22:
        return false;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L22;
        if (TextUtils.isEmpty(r6) == true) goto L22;
        IConfigManager r0 = (IConfigManager) ZeusTransformUtils.preCheckCast(d.a(IConfigManager.class), IConfigManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L20
        if (r0 == null) goto L25;
        JSONObject r7 = r0.getConfigJSON(r4);     // Catch: Exception -> L20
        if (r7 == null) goto L26;
        JSONObject r8 = r7.optJSONObject(r5);     // Catch: Exception -> L20
        if (r8 == null) goto L27;
        if (r8.optInt(r6, 0) == 1) goto L19;
        return false;
    L19:
        return true;
    L27:
        return false;
    L26:
        return false;
    L25:
        return false;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }
}

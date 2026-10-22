package com.bytedance.crash.dumper;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonParamInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void a(File r10) {
        com.bytedance.crash.monitor.a r3 = com.bytedance.crash.monitor.h.a();
        if (r3 != null) goto L5;
        return;
    L5:
        JSONObject r4 = new JSONObject();
        Map<String, Object> r5 = r3.b();
        if (r5 == null) goto L33;
        Iterator<String> r6 = r5.keySet().iterator();     // Catch: Exception -> L29
    L9:
        if (r6.hasNext() == false) goto L14;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L29
        if (r5.get(r7) == null) goto L9;
        r4.put(r7, r5.get(r7));     // Catch: Exception -> L29
        goto L9
    L14:
        if (r5.containsKey("version_name") == false) goto L17;
        r4.put("crash_version_name", r5.get("version_name"));     // Catch: Exception -> L29
    L17:
        if (r5.containsKey("update_version_code") == false) goto L20;
        r4.put("crash_update_version_code", r5.get("update_version_code"));     // Catch: Exception -> L29
    L20:
        if (r5.containsKey("version_code") == false) goto L33;
        r4.put("crash_version_code", r5.get("version_code"));     // Catch: Exception -> L29
    L33:
        JSONObject r0 = r3.o();     // Catch: Exception -> L30
        if (r0 == null) goto L26;
        r4.put("mp_params", r0);     // Catch: Exception -> L30
    L26:
        if (r4.length() <= 0) goto L40;
        com.bytedance.crash.o.i.c(new File(r10, "common_params.json"), r4.toString());
        return;
    }

    public static boolean a(JSONObject r2, File r3) {
        String r4 = com.bytedance.crash.o.i.d(new File(r3, "common_params.json"));
        if (r4 != null) goto L10;
        return false;
    L10:
        com.bytedance.crash.o.l.b(r2, new JSONObject(r4));     // Catch: Throwable -> L9
        return true;
    L12:
        return false;
    }
}

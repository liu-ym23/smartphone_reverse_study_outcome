package com.bytedance.common.utility;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    private j() {
    }

    public static boolean a(String r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        if (r0.length() == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean a(String r1, String r2) {
        if (a(r1) == true) goto L5;
    L6:
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.equals(r2) == false) goto L10;
    L9:
        return true;
    L5:
        if (a(r2) == true) goto L9;
        goto L6
    }

    public static String a(Map<String, String> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L17;
        return null;
    L17:
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L16
        Iterator r3 = r8.keySet().iterator();     // Catch: Exception -> L16
    L7:
        if (r3.hasNext() == false) goto L14;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L16
        String r5 = (String) ZeusTransformUtils.preCheckCast(r8.get(r4), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L16
        if (a(r4) == true) goto L7;
        if (a(r5) == true) goto L7;
        r2.put(r4, r5);     // Catch: Exception -> L16
        goto L7
    L14:
        return r2.toString();
    L16:
        return null;
    }
}

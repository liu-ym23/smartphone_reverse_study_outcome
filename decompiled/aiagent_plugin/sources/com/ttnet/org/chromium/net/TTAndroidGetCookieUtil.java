package com.ttnet.org.chromium.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class TTAndroidGetCookieUtil {
    public TTAndroidGetCookieUtil() {
    }

    public static String getCookieHeader(String r6) {
        HashMap r0 = new HashMap();
        StringBuilder r1 = new StringBuilder();
        CookieHandler r2 = CookieHandler.getDefault();     // Catch: Exception -> L27
        if (r2 == null) goto L7;
        Map<String, List<String>> r7 = r2.get(new URI(r6), r0);     // Catch: Exception -> L27
    L8:
        if (r7 == null) goto L26;
        if (r7.size() <= 0) goto L26;
        Iterator<Map.Entry<String, List<String>>> r8 = r7.entrySet().iterator();
    L13:
        if (r8.hasNext() == false) goto L26;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if ("Cookie".equalsIgnoreCase((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin")) == false) goto L13;
        if (((List) ZeusTransformUtils.preCheckCast(r3.getValue(), List.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L13;
        int r4 = 0;
        Iterator r5 = ((List) ZeusTransformUtils.preCheckCast(r3.getValue(), List.class, "com.obric.aiagent.plugin")).iterator();
    L20:
        if (r5.hasNext() == false) goto L13;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");
        if (r4 <= 0) goto L24;
        r1.append("; ");
    L24:
        r1.append(r9);
        r4 = r4 + 1;
    L26:
        return r1.toString();
    L7:
        r7 = null;
    L28:
        return r1.toString();
    }
}

package com.bytedance.apm6.util;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: UrlUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f5487a = 1;

    static {
    }

    public static String a(String r8, Map<String, String> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        if (TextUtils.isDigitsOnly(r8) == true) goto L27;
        if (r10 == null) goto L27;
        if (r10.isEmpty() == true) goto L27;
        if (r8.indexOf("?") >= 0) goto L12;
        r8 = r8 + "?";
    L12:
        if (r8.endsWith("?") == false) goto L14;
        r8 = r8 + a("sdk_version", "UTF-8") + "=" + a(String.valueOf(f5487a), "UTF-8");
    L15:
        if (r10 == null) goto L27;
        if (r10.size() <= 0) goto L27;
        Iterator r2 = r10.entrySet().iterator();
    L20:
        if (r2.hasNext() == false) goto L27;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r10.get(r3.getKey()) == null) goto L20;
        if (r8.endsWith("?") == true) goto L25;
        r8 = r8 + "&" + a(r3.getKey().toString(), "UTF-8") + "=" + a(((String) ZeusTransformUtils.preCheckCast(r10.get(r3.getKey()), String.class, "com.obric.aiagent.plugin")).toString(), "UTF-8");
        goto L20
    L25:
        r8 = r8 + a(r3.getKey().toString(), "UTF-8") + "=" + a(((String) ZeusTransformUtils.preCheckCast(r10.get(r3.getKey()), String.class, "com.obric.aiagent.plugin")).toString(), "UTF-8");
        goto L20
    L14:
        r8 = r8 + "&" + a("sdk_version", "UTF-8") + "=" + a(String.valueOf(f5487a), "UTF-8");
    L27:
        return r8;
    }

    private static String a(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "UTF-8";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}

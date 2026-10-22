package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class HttpDnsUtil {
    private static final String TAG = "HttpDnsUtil";

    static {
    }

    public HttpDnsUtil() {
    }

    public static boolean isValidHost(String r5) {
        if (r5 == null) goto L31;
        char[] r6 = r5.toCharArray();
        if (r6.length <= 0) goto L31;
        if (r6.length > 255) goto L31;
        int r1 = r6.length;
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L29;
        char r3 = r6[r2];
        if (r3 < 'A') goto L16;
        if (r3 > 'Z') goto L16;
    L28:
        r2 = r2 + 1;
    L16:
        if (r3 < 'a') goto L20;
        if (r3 <= 'z') goto L28;
    L20:
        if (r3 < '0') goto L24;
        if (r3 <= '9') goto L28;
    L24:
        if (r3 == '.') goto L28;
        if (r3 == '-') goto L28;
        return false;
    L29:
        return true;
    L31:
        return false;
    }

    public static String transHostList2String(List<String> r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L7:
        if (r1 >= r3.size()) goto L13;
        r0.append(r3.get(r1));
        if (r1 == (r3.size() - 1)) goto L11;
        r0.append(',');
    L11:
        r1 = r1 + 1;
        goto L7
    L13:
        return r0.toString();
    }
}

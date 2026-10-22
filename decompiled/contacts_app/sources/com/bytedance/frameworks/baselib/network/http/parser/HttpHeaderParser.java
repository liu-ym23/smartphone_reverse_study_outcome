package com.bytedance.frameworks.baselib.network.http.parser;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HttpHeaderParser {
    public HttpHeaderParser() {
    }

    public static String parseCharset(Map<String, String> r5, String r6) {
        String r1 = r5.get("Content-Type");
        if (TextUtils.isEmpty(r1) == false) goto L5;
        r1 = r5.get("Content-Type".toLowerCase());
    L5:
        if (r1 == null) goto L16;
        String[] r7 = r1.split(";");
        int r2 = 1;
    L8:
        if (r2 >= r7.length) goto L16;
        String[] r3 = r7[r2].trim().split("=");
        if (r3.length != 2) goto L15;
        if (r3[0].equals("charset") == false) goto L15;
        return r3[1];
    L15:
        r2 = r2 + 1;
    L16:
        return r6;
    }

    public static String parseCharset(Map<String, String> r1) {
        return parseCharset(r1, "ISO-8859-1");
    }
}

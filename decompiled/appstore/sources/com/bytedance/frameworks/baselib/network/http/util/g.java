package com.bytedance.frameworks.baselib.network.http.util;

import java.net.URI;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static URI a(String r10) {
        if (com.bytedance.common.utility.e.b(r10) == false) goto L15;
        return null;
    L15:
        int r11 = r10.indexOf("?");     // Catch: Exception -> L9
        if (r11 <= 0) goto L11;
        r10 = r10.substring(0, r11);     // Catch: Exception -> L9
    L11:
        return URI.create(r10);
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static URI b(String r10) {
        if (com.bytedance.common.utility.e.b(r10) == false) goto L12;
        return null;
    L12:
        return new URI(r10);
    L8:
        return URI.create(r10.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return a(r10);
    }
}

package com.bytedance.apm.util;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class y {
    public static String a(String r10, Map r11) {
        if (TextUtils.isDigitsOnly(r10) == true) goto L26;
        if (r11 == null) goto L26;
        if (r11.isEmpty() == true) goto L26;
        if (r10.indexOf("?") >= 0) goto L12;
        r10 = r10 + "?";
    L12:
        if (r10.endsWith("?") == false) goto L14;
        r10 = r10 + b(WsConstants.KEY_SDK_VERSION, "UTF-8") + "=" + b(String.valueOf(400), "UTF-8");
    L16:
        if (r11.size() <= 0) goto L26;
        Iterator r12 = r11.entrySet().iterator();
    L19:
        if (r12.hasNext() == false) goto L26;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (r11.get(r13.getKey()) == null) goto L19;
        if (r10.endsWith("?") == true) goto L24;
        r10 = r10 + "&" + b(r13.getKey().toString(), "UTF-8") + "=" + b(((String) r11.get(r13.getKey())).toString(), "UTF-8");
        goto L19
    L24:
        r10 = r10 + b(r13.getKey().toString(), "UTF-8") + "=" + b(((String) r11.get(r13.getKey())).toString(), "UTF-8");
        goto L19
    L14:
        r10 = r10 + "&" + b(WsConstants.KEY_SDK_VERSION, "UTF-8") + "=" + b(String.valueOf(400), "UTF-8");
    L26:
        return r10;
    }

    public static String b(String r10, String r11) {
        if (r11 != null) goto L10;
        r11 = "UTF-8";
    L10:
        return URLEncoder.encode(r10, r11);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String c(String r10) {
        if (r10 != null) goto L12;
        return null;
    L12:
        URL r11 = new URL(r10);     // Catch: MalformedURLException -> L11
        StringBuffer r12 = new StringBuffer();
        r12.append(r11.getProtocol());
        r12.append("://");
        r12.append(r11.getHost());
        if (r11.getPort() == (-1)) goto L9;
        r12.append(":");
        r12.append(r11.getPort());
    L9:
        r12.append(r11.getPath());
        return r12.toString();
    L11:
        return null;
    }
}

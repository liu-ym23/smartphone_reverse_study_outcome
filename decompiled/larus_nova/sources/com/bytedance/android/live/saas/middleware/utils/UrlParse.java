package com.bytedance.android.live.saas.middleware.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes47.dex */
public class UrlParse {
    public UrlParse() {
    }

    public static String getUrlHostAndPath(String r100) {
        if (r100.contains("?") == true) goto L5;
        return r100;
    L5:
        return r100.substring(0, r100.indexOf("?"));
    }

    public static String getUrlParamStr(String r100) {
        URL r101 = stringToURL(r100);
        if (r101 != null) goto L10;
        return "";
    L10:
        return r101.getQuery();
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static HashMap<String, String> getUrlParams(String r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        URL r102 = stringToURL(r100);
        if (r102 != null) goto L25;
        return r101;
    L25:
        String r103 = r102.getQuery();     // Catch: Exception -> L22
        if (r103 != null) goto L10;
        return r101;
    L10:
        if (r103.contains("url=") == false) goto L13;
        int r104 = r103.indexOf("url=");     // Catch: Exception -> L22
        r101.put("url", URLDecoder.decode(r103.substring(r104 + 4), "UTF-8"));     // Catch: Exception -> L22
        r103 = r103.substring(0, r104);     // Catch: Exception -> L22
    L13:
        if (r103.length() <= 0) goto L24;
        String[] r105 = r103.split("&");     // Catch: Exception -> L22
        int r106 = r105.length;     // Catch: Exception -> L22
        int r107 = 0;
    L15:
        if (r107 >= r106) goto L24;
        String r108 = r105[r107];     // Catch: Exception -> L22
        int r109 = r108.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L22
        if (r109 <= 0) goto L21;
        if (r109 >= (r108.length() - 1)) goto L21;
        r101.put(URLDecoder.decode(r108.substring(0, r109), "UTF-8"), URLDecoder.decode(r108.substring(r109 + 1), "UTF-8"));     // Catch: Exception -> L22
    L21:
        r107 = r107 + 1;
    L24:
        return r101;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    private static URL stringToURL(String r100) {
        if (r100 != null) goto L5;
    L13:
        return null;
    L5:
        if (r100.length() == 0) goto L13;
        if (r100.contains("://") == false) goto L13;
        return new URL("http" + r100.substring(r100.indexOf("://")));
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static int getIntUriParam(Uri r100, String r101) {
        if (r100 == null) goto L18;
        if (r101 == null) goto L18;
        if (r101.length() == 0) goto L18;
        String r102 = UriProtector.getQueryParameter(r100, r101);     // Catch: Exception -> L16
        if (r102 != null) goto L11;
    L15:
        return 0;
    L11:
        if (r102.length() == 0) goto L15;
        return CastIntegerProtector.parseInt(r102);
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        return 0;
    }

    public static String getUriParam(Uri r100, String r101) {
        if (r100 == null) goto L13;
        if (r101 != null) goto L6;
        return "";
    L6:
        if (r101.length() == 0) goto L15;
        String r102 = UriProtector.getQueryParameter(r100, r101);
        if (r102 != null) goto L12;
        return "";
    L12:
        return r102;
    L15:
        return "";
    L13:
        return "";
    }
}

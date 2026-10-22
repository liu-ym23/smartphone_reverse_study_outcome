package com.amap.api.col.s;

import com.amap.api.services.core.ServiceSettings;

/* JADX INFO: loaded from: classes28.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f26600a = null;

    static {
        f26600a = new String[]{"com.amap.api.services", "com.amap.api.search.admic"};
    }

    public static String a() {
        if (ServiceSettings.getInstance().getProtocol() != 1) goto L6;
        return "http://restsdk.amap.com/v3";
    L6:
        return "https://restsdk.amap.com/v3";
    }

    public static String b() {
        if (ServiceSettings.getInstance().getProtocol() != 1) goto L6;
        return "http://restsdk.amap.com/v4";
    L6:
        return "https://restsdk.amap.com/v4";
    }

    public static String c() {
        if (ServiceSettings.getInstance().getProtocol() != 1) goto L6;
        return "http://yuntuapi.amap.com";
    L6:
        return "https://yuntuapi.amap.com";
    }

    public static String d() {
        if (ServiceSettings.getInstance().getProtocol() != 1) goto L6;
        return "http://restsdk.amap.com/rest/me/cpoint";
    L6:
        return "https://restsdk.amap.com/rest/me/cpoint";
    }

    public static String e() {
        if (ServiceSettings.getInstance().getProtocol() != 1) goto L6;
        return "http://m5.amap.com/ws/mapapi/shortaddress/transform";
    L6:
        return "https://m5.amap.com/ws/mapapi/shortaddress/transform";
    }

    public static br a(boolean r100) {
        return new br.a("sea", "7.7.0", "AMAP SDK Android Search 7.7.0").a(f26600a).a(r100).a("7.7.0").a();
    L5:
        e = move-exception;
        i.a(e, "ConfigableConst", "getSDKInfo");
        return null;
    }
}

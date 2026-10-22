package com.amap.api.col.s;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public final class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static de f26044a;

    private static String a(String r100, boolean r101) {
        String r102 = "";
        int r103 = r100.indexOf("?");     // Catch: Throwable -> L11
        int r104 = r100.length();     // Catch: Throwable -> L11
        if (r103 <= 0) goto L9;
        String r105 = r100.substring(0, r103);     // Catch: Throwable -> L11
        int r106 = r103 + 1;     // Catch: Throwable -> L11
        if (r106 >= r104) goto L8;
        r102 = r100.substring(r106);     // Catch: Throwable -> L11
    L8:
        r100 = r105;
    L9:
        return "{\"RequestPath\":\"" + r100 + "\",\"RequestParm\":\"" + r102 + "\",\"IsCacheRequest\":" + r101 + com.alipay.sdk.m.u.i.f25855d;
    L11:
        th = move-exception;
        i.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
        return null;
    }

    private static String a(String r100, long r101, boolean r102) {
        return "{\"RequestPath\":\"" + r100 + "\",\"ResponseTime\":" + r101 + ",\"Success\":" + r102 + com.alipay.sdk.m.u.i.f25855d;
    L5:
        th = move-exception;
        i.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
        return null;
    }

    public static void a(Context r100, String r101, boolean r102) {
        String r103 = a(r101, r102);     // Catch: Throwable -> L9
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.length() <= 0) goto L15;
        de r104 = new de(r100, "sea", "7.7.0", "O006");     // Catch: Throwable -> L9
        r104.a(r103);     // Catch: Throwable -> L9
        df.a(r104, r100);     // Catch: Throwable -> L9
        return;
    L15:
        return;
    L9:
        th = move-exception;
        i.a(th, "StatisticsUtil", "recordResponseAction");
    }

    public static void a(Context r100, String r101, long r102, boolean r103) {
        String r104 = a(r101, r102, r103);     // Catch: Throwable -> L12
        if (r104 != null) goto L5;
        return;
    L5:
        if (r104.length() > 0) goto L8;
        return;
    L8:
        if (f26044a != null) goto L10;
        f26044a = new de(r100, "sea", "7.7.0", "O002");     // Catch: Throwable -> L12
    L10:
        f26044a.a(r104);     // Catch: Throwable -> L12
        df.a(f26044a, r100);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        i.a(th, "StatisticsUtil", "recordResponseAction");
    }
}

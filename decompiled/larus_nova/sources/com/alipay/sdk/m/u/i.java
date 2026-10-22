package com.alipay.sdk.m.u;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes28.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25852a = "pref_trade_token";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f25853b = ";";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f25854c = "result={";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f25855d = "}";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f25856e = "trade_token=\"";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f25857f = "\"";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f25858g = "trade_token=";

    public i() {
    }

    public static String a(String r100) {
        String r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        String[] r102 = r100.split(f25853b);
        int r103 = 0;
    L7:
        if (r103 >= r102.length) goto L25;
        if (r102[r103].startsWith(f25854c) == false) goto L24;
        if (r102[r103].endsWith(f25855d) == false) goto L24;
        String r104 = r102[r103];
        String[] r105 = r104.substring(8, r104.length() - 1).split("&");
        int r106 = 0;
    L14:
        if (r106 >= r105.length) goto L24;
        if (r105[r106].startsWith(f25856e) == false) goto L21;
        if (r105[r106].endsWith("\"") == false) goto L21;
        String r107 = r105[r106];
        r101 = r107.substring(13, r107.length() - 1);
    L21:
        if (r105[r106].startsWith(f25858g) == true) goto L22;
        r106 = r106 + 1;
        goto L14
    L22:
        r101 = r105[r106].substring(12);
    L24:
        r103 = r103 + 1;
        goto L7
    L25:
        return r101;
    }

    public static String a(com.alipay.sdk.m.s.a r100, Context r101) {
        String r102 = j.a(r100, r101, f25852a, "");
        e.b(com.alipay.sdk.m.l.a.A, "get trade token: " + r102);
        return r102;
    }

    public static void a(com.alipay.sdk.m.s.a r100, Context r101, String r102) {
        String r103 = a(r102);     // Catch: Throwable -> L9
        e.b(com.alipay.sdk.m.l.a.A, "trade token: " + r103);     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r103) == true) goto L14;
        j.b(r100, r101, f25852a, r103);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        com.alipay.sdk.m.k.a.a(r100, "biz", com.alipay.sdk.m.k.b.I, th);
        e.a(th);
    }
}

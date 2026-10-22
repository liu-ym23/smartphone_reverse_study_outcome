package com.alipay.apmobilesecuritysdk.b;

import com.alipay.sdk.m.d0.d;

/* JADX INFO: loaded from: classes28.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f25086b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25087a;

    static {
        f25086b = new a();
    }

    public a() {
        this.f25087a = 0;
    }

    public static a a() {
        return f25086b;
    }

    public static String a(String r100, String r101) {
        return r100 + r101;
    }

    public final void a(int r100) {
        this.f25087a = r100;
    }

    public final int b() {
        return this.f25087a;
    }

    public final String c() {
        String r100 = d.a();
        if (com.alipay.sdk.m.z.a.b(r100) == false) goto L5;
        return r100;
    L5:
        int r101 = this.f25087a;
        if (r101 != 1) goto L8;
        String r102 = "://mobilegw.stable.alipay.net/mgw.htm";
    L17:
        return a("http", r102);
    L8:
        if (r101 != 2) goto L10;
        return "https://mobilegwpre.alipay.com/mgw.htm";
    L10:
        if (r101 != 3) goto L12;
        r102 = "://mobilegw-1-64.test.alipay.net/mgw.htm";
        goto L17
    L12:
        if (r101 == 4) goto L15;
        return "https://mobilegw.alipay.com/mgw.htm";
    L15:
        r102 = "://mobilegw.aaa.alipay.net/mgw.htm";
        goto L17
    }
}

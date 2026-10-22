package com.baidu.mshield.rp;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.utility.c;

/* JADX INFO: loaded from: classes39.dex */
public class a {
    public static String a(Context r100) {
        String r101 = "";
        com.baidu.mshield.sharedpreferences.a r102 = com.baidu.mshield.sharedpreferences.a.a(r100);     // Catch: Throwable -> L11
        String r103 = r102.m();     // Catch: Throwable -> L11
    L9:
        th = th;
        r101 = r103;
    L12:
        com.baidu.mshield.utility.a.a(th);
        return r101;
    L5:
        if (TextUtils.isEmpty(r103) == true) goto L7;
        r102.g("");     // Catch: Throwable -> L9
    L7:
        return c.a(r100);
    L11:
        th = th;
        goto L12
    }

    public static String b(Context r100) {
        String r101 = "";
        com.baidu.mshield.sharedpreferences.a r102 = com.baidu.mshield.sharedpreferences.a.a(r100);     // Catch: Throwable -> L11
        String r103 = r102.s();     // Catch: Throwable -> L11
    L9:
        th = th;
        r101 = r103;
    L12:
        com.baidu.mshield.utility.a.a(th);
        return r101;
    L5:
        if (TextUtils.isEmpty(r103) == true) goto L7;
        r102.k("");     // Catch: Throwable -> L9
    L7:
        return c.e(r100);
    L11:
        th = th;
        goto L12
    }

    public static String c(Context r100) {
        String r101 = "";
        com.baidu.mshield.sharedpreferences.a r102 = com.baidu.mshield.sharedpreferences.a.a(r100);     // Catch: Throwable -> L11
        String r103 = r102.u();     // Catch: Throwable -> L11
    L9:
        th = th;
        r101 = r103;
    L12:
        com.baidu.mshield.utility.a.a(th);
        return r101;
    L5:
        if (TextUtils.isEmpty(r103) == true) goto L7;
        r102.l("");     // Catch: Throwable -> L9
    L7:
        return c.f(r100);
    L11:
        th = th;
        goto L12
    }
}

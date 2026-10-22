package com.baidu.mshield.x0.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mshield.x0.EngineImpl;

/* JADX INFO: loaded from: classes39.dex */
public final class e {
    public static String a(Context r100) {
        return EngineImpl.getInstance(r100).getPropertyByType("arid");
    }

    public static String b(Context r100) {
        com.baidu.mshield.x0.l.c r101 = new com.baidu.mshield.x0.l.c(r100);     // Catch: Throwable -> L23
        String r102 = r101.f();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r102) == true) goto L7;
        return r102;
    L7:
        if (Build.VERSION.SDK_INT <= 25) goto L9;
        return "";
    L9:
        String r103 = a(r100);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty("") == true) goto L12;
    L14:
        byte[] r104 = (":" + r103).getBytes();     // Catch: Throwable -> L23
        int r105 = 0;
    L16:
        if (r105 >= r104.length) goto L18;
        r104[r105] = (byte) (r104[r105] ^ 246);     // Catch: Throwable -> L23
        r105 = r105 + 1;     // Catch: Throwable -> L23
        goto L16
    L18:
        String r106 = com.baidu.mshield.b.f.e.c(r104);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r106) == false) goto L21;
        return "";
    L21:
        r101.f(r106);     // Catch: Throwable -> L23
        return r106;
    L12:
        if (TextUtils.isEmpty(r103) == false) goto L14;
        return "";
    L23:
        th = move-exception;
        d.a(th);
        return "";
    }
}

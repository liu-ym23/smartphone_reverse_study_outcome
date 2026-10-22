package com.alipay.sdk.m.b0;

import java.io.File;

/* JADX INFO: loaded from: classes28.dex */
public final class b {
    public static String a(String r100) {
        String r101 = f.a(r100);     // Catch: Throwable -> L4
    L6:
        if (com.alipay.sdk.m.z.a.a(r101) == true) goto L8;
        return r101;
    L8:
        return c.a(".SystemConfig" + File.separator + r100);
    L4:
        r101 = "";
        goto L6
    }
}

package com.baidu.xclient.gdid.j;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes39.dex */
public class a {
    public static String a(Context r100) {
        String r101 = com.baidu.mshield.b.b.a.c(r100);     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return com.baidu.mshield.b.b.a.b(r100);
    L11:
        return r101;
    L6:
        th = move-exception;
        d.a(th);
        return "";
    }
}

package com.bytedance.android.shopping.store.tabkit.ssr;

import java.security.MessageDigest;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    static {
    }

    public static String a(byte[] r100) {
        Object r101 = null;
        if (r100 != null) goto L21;
        return null;
    L21:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        byte[] r103 = MessageDigest.getInstance("SHA-256").digest(r100);     // Catch: Throwable -> L13
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L13
        int r105 = r103.length;     // Catch: Throwable -> L13
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L11;
        String r107 = Integer.toHexString(r103[r106] & UByte.MAX_VALUE);     // Catch: Throwable -> L13
        if (r107.length() != 1) goto L10;
        r104.append('0');     // Catch: Throwable -> L13
    L10:
        r104.append(r107);     // Catch: Throwable -> L13
        r106 = r106 + 1;     // Catch: Throwable -> L13
        goto L6
    L11:
        Object r108 = Result.m9449constructorimpl(r104.toString());     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r108) == true) goto L20;
        r101 = r108;
    L20:
        return (String) r101;
    L13:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }
}

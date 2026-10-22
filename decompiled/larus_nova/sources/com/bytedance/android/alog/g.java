package com.bytedance.android.alog;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;

/* JADX INFO: loaded from: classes43.dex */
public final class g {
    public static String a() {
        BufferedReader r100 = null;
        BufferedReader r101 = new BufferedReader(new PolarisFileReaderWrapper("/proc/self/cmdline"));     // Catch: Throwable -> L13 Exception -> L17
        String r102 = r101.readLine();     // Catch: Throwable -> L10 Exception -> L12
        if (TextUtils.isEmpty(r102) == true) goto L24;
        String r103 = r102.trim();     // Catch: Throwable -> L10 Exception -> L12
        if (TextUtils.isEmpty(r103) == true) goto L24;
        r101.close();     // Catch: Exception -> L21
    L9:
        return r103;
    L24:
        r101.close();     // Catch: Exception -> L22
    L20:
        return null;
    L10:
        th = move-exception;
        th = th;
        r100 = r101;
    L14:
        if (r100 != null) goto L28;
    L16:
        throw th;
    L28:
        r100.close();     // Catch: Exception -> L23
    L18:
        if (r101 == null) goto L20;
    L17:
        r101 = null;
    L13:
        th = th;
        goto L14
    }
}

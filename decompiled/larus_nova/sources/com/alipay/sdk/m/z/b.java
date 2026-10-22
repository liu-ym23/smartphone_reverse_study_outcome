package com.alipay.sdk.m.z;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes28.dex */
public final class b {
    public static String a(String r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        BufferedReader r103 = null;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100, r101);     // Catch: Throwable -> L14 IOException -> L19
        if (r104.exists() == true) goto L6;
        return null;
    L6:
        BufferedReader r105 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(r104), "UTF-8"));     // Catch: Throwable -> L14 IOException -> L19
    L33:
        String r106 = r105.readLine();     // Catch: Throwable -> L11 IOException -> L13
        if (r106 == null) goto L27;
        r102.append(r106);     // Catch: Throwable -> L11 IOException -> L13
    L27:
        r105.close();     // Catch: Throwable -> L25
    L24:
        return r102.toString();
    L13:
        r103 = r105;
    L11:
        Throwable th10 = th;
        r103 = r105;
    L16:
        if (r103 == null) goto L36;
        r103.close();     // Catch: Throwable -> L26
        throw th10;
    L37:
        throw th10;
    L36:
        throw th10;
    L14:
        th = move-exception;
        th10 = th;
    L20:
        if (r103 == null) goto L24;
        r105 = r103;
        goto L27
    }
}

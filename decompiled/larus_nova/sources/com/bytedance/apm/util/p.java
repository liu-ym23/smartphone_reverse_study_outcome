package com.bytedance.apm.util;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f190678a;

    public static String a() {
        String r100 = f190678a;
        if (TextUtils.isEmpty(r100) == true) goto L5;
        return r100;
    L5:
        BufferedReader r101 = null;
        String r102 = null;
        BufferedReader r103 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L15
        StringBuilder r104 = new StringBuilder(32);     // Catch: Throwable -> L13
    L8:
        int r105 = r103.read();     // Catch: Throwable -> L13
        if (r105 <= 0) goto L11;
        r104.append((char) r105);     // Catch: Throwable -> L13
        goto L8
    L11:
        r102 = r104.toString();     // Catch: Throwable -> L13
    L14:
        String r106 = r102;
        r101 = r103;
    L16:
        d27.d.a(r101);
        f190678a = r106;
        if (r106 != null) goto L25;
        return "";
    L25:
        return r106;
    L15:
        r106 = null;
        goto L16
    }
}

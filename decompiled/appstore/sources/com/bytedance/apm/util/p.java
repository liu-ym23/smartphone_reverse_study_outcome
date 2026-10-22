package com.bytedance.apm.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f6667a;

    static {
    }

    public static String a(Context r10) {
        String r11 = f6667a;
        if (TextUtils.isEmpty(r11) == true) goto L5;
        return r11;
    L5:
        String r12 = b();
        f6667a = r12;
        if (r12 != null) goto L9;
        return "";
    L9:
        return r12;
    }

    public static String b() {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r11 = new StringBuilder(32);     // Catch: Throwable -> L14
    L5:
        int r12 = r10.read();     // Catch: Throwable -> L14
        if (r12 <= 0) goto L8;
        r11.append((char) r12);     // Catch: Throwable -> L14
        goto L5
    L8:
        String r13 = r11.toString();     // Catch: Throwable -> L14
        i5.d.b(r10);
        return r13;
    L12:
        i5.d.b(r10);
        return null;
    L11:
        r10 = null;
        goto L12
    }
}

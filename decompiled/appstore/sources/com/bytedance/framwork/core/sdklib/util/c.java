package com.bytedance.framwork.core.sdklib.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f7550a;

    static {
    }

    public static String a(Context r10) {
        String r11 = f7550a;
        if (TextUtils.isEmpty(r11) == true) goto L5;
        return r11;
    L5:
        String r12 = b();
        f7550a = r12;
        return r12;
    }

    public static String b() {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r12 = r10.read();     // Catch: Throwable -> L16
        if (r12 <= 0) goto L8;
        r11.append((char) r12);     // Catch: Throwable -> L16
        goto L5
    L8:
        String r13 = r11.toString();     // Catch: Throwable -> L16
        r10.close();     // Catch: Exception -> L15
    L10:
        return r13;
    L12:
        if (r10 != null) goto L22;
    L14:
        return null;
    L22:
        r10.close();     // Catch: Exception -> L17
    L11:
        r10 = null;
        goto L12
    }
}

package com.bytedance.reparo.d;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.crash.o.r;
import com.bytedance.security.zenmobile.io.SensitiveType;

/* JADX INFO: compiled from: CpuUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f9344a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f9345b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f9346c = -1;

    static {
    }

    private static String c() {
        if (f9344a != null) goto L24;
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L21
        if (Build.VERSION.SDK_INT >= 21) goto L7;
    L15:
        r1 = new StringBuilder(Build.CPU_ABI);     // Catch: Exception -> L21
    L17:
        if (TextUtils.isEmpty(r1.toString()) == false) goto L19;
        f9344a = SensitiveType.UNKNOWN;     // Catch: Exception -> L21
    L19:
        f9344a = r1.toString();     // Catch: Exception -> L21
        goto L24
    L7:
        if (Build.SUPPORTED_ABIS.length <= 0) goto L15;
        int r2 = 0;
    L10:
        if (r2 >= Build.SUPPORTED_ABIS.length) goto L17;
        r1.append(Build.SUPPORTED_ABIS[r2]);     // Catch: Exception -> L21
        if (r2 == (Build.SUPPORTED_ABIS.length - 1)) goto L14;
        r1.append(", ");     // Catch: Exception -> L21
    L14:
        r2 = r2 + 1;     // Catch: Exception -> L21
    L21:
        e = move-exception;
        r.a(e);
        f9344a = SensitiveType.UNKNOWN;
    L24:
        return f9344a;
    }

    public static boolean a() {
        if (f9345b != (-1)) goto L6;
        f9345b = c().contains("64") ? 1 : 0;
    L6:
        if (f9345b == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean b() {
        if (f9346c != (-1)) goto L6;
        f9346c = c().contains("86") ? 1 : 0;
    L6:
        if (f9346c == 1) goto L10;
        return false;
    L10:
        return true;
    }
}

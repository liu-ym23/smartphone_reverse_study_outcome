package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f18942a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f18943b;

    static {
        f18942a = new Object();
    }

    public static void a(StringBuilder r10) {
        r10.append(" Cronet/");
        r10.append("TTNetVersion:b58f3ed1 2022-10-24 QuicVersion:b314d107 2021-11-24");
    }

    public static String b(Context r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append(r10.getPackageName());
        r11.append('/');
        r11.append(d(r10));
        r11.append(" (Linux; U; Android ");
        r11.append(Build.VERSION.RELEASE);
        r11.append("; ");
        r11.append(Locale.getDefault().toString());
        String r12 = Build.MODEL;
        if (r12.length() <= 0) goto L5;
        r11.append("; ");
        r11.append(r12);
    L5:
        String r13 = Build.ID;
        if (r13.length() <= 0) goto L8;
        r11.append("; Build/");
        r11.append(r13);
    L8:
        r11.append(";");
        a(r11);
        r11.append(')');
        return r11.toString();
    }

    public static String c(Context r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append(r10.getPackageName());
        a(r11);
        return r11.toString();
    }

    public static int d(Context r10) {
        Object r11 = f18942a;
        monitor-enter(r11);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f18943b == 0) goto L20;
    L14:
        int r12 = f18943b;     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return r12;
    L20:
        f18943b = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0).versionCode;     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L12
    L13:
        throw new IllegalStateException("Cannot determine package version");     // Catch: Throwable -> L10
    }
}

package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: compiled from: UserAgent.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f38117a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f38118b;

    static {
        f38117a = new Object();
    }

    public static String a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        StringBuilder r0 = new StringBuilder();
        r0.append(r4.getPackageName());
        r0.append('/');
        r0.append(c(r4));
        r0.append(" (Linux; U; Android ");
        r0.append(Build.VERSION.RELEASE);
        r0.append("; ");
        r0.append(Locale.getDefault().toString());
        String r1 = Build.MODEL;
        if (r1.length() <= 0) goto L5;
        r0.append("; ");
        r0.append(r1);
    L5:
        String r5 = Build.ID;
        if (r5.length() <= 0) goto L8;
        r0.append("; Build/");
        r0.append(r5);
    L8:
        r0.append(";");
        a(r0);
        r0.append(')');
        return r0.toString();
    }

    static String b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        StringBuilder r0 = new StringBuilder();
        r0.append(r3.getPackageName());
        a(r0);
        return r0.toString();
    }

    private static int c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Object r0 = f38117a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f38118b == 0) goto L18;
    L9:
        int r5 = f38118b;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r5;
    L18:
        f38118b = r4.getPackageManager().getPackageInfo(r4.getPackageName(), 0).versionCode;     // Catch: PackageManager.NameNotFoundException -> L15 Throwable -> L12
        goto L9
    }

    private static void a(StringBuilder r1) {
        r1.append(" Cronet/");
        r1.append("TTNetVersion:c4385650 2026-06-11 QuicVersion:db931b8e 2026-06-08");
    }
}

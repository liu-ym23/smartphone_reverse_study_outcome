package com.bytedance.crash.config;

import android.text.TextUtils;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: NpthBuildConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f7298a;

    static {
        String r0 = a("4.2.2-rc.4-pico", "cnNoasanInnerFull".toLowerCase());
        if (TextUtils.isEmpty(r0) == true) goto L5;
        f7298a = r0;
        return;
    L5:
        f7298a = "4.2.2-rc.4-pico";
    }

    public static String a(String r5, String r6) {
        String[] r1 = r5.split("-");     // Catch: Throwable -> L17
        String r2 = "";
        if (r1.length != 2) goto L6;
        r2 = r5.split("-")[1];     // Catch: Throwable -> L17
    L6:
        String r7 = a(r1[0]);     // Catch: Throwable -> L17
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L17
        r3.append(r7);     // Catch: Throwable -> L17
        if (r6.contains("oversea") == false) goto L10;
        r3.append(".oversea");     // Catch: Throwable -> L17
    L10:
        if (r6.contains("lite") == false) goto L13;
        r3.append(".lite");     // Catch: Throwable -> L17
    L13:
        if (TextUtils.isEmpty(r2) == true) goto L15;
        r3.append("-");     // Catch: Throwable -> L17
        r3.append(r2);     // Catch: Throwable -> L17
    L15:
        return r3.toString();
    L17:
        th = move-exception;
        a("NpthBuildConfig", th.toString(), th);
        return null;
    }

    public static String a(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r1 = 1;
        if (Character.isDigit(r5.charAt(r5.length() - 1)) == false) goto L8;
        return r5;
    L8:
        StringBuilder r0 = new StringBuilder();
        char r2 = r5.charAt(0);
    L10:
        if (r1 >= r5.length()) goto L17;
        char r3 = r5.charAt(r1);
        if (Character.isDigit(r5.charAt(r1)) == true) goto L15;
        if (r3 != '.') goto L17;
    L15:
        r0.append(r2);
        r1 = r1 + 1;
        r2 = r3;
    L17:
        return r0.toString();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}

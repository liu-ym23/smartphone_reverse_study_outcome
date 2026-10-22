package com.alipay.sdk.m.u;

import com.alipay.sdk.interior.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes28.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Log.ISdkLogCallback f25808a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f25809b = "alipaysdk";

    public e() {
    }

    public static void a(String r100) {
        Log.ISdkLogCallback r101 = f25808a;     // Catch: Throwable -> L10
        if (r101 != null) goto L8;
        return;
    L8:
        r101.onLogLine(String.format("[AlipaySDK] %s %s", new Object[]{new SimpleDateFormat("hh:mm:ss.SSS", Locale.getDefault()).format(new Date()), r100}));     // Catch: Throwable -> L10
        return;
    }

    public static String b(Throwable r100) {
        StringWriter r101 = new StringWriter();
        r100.printStackTrace(new PrintWriter(r101));
        return r101.toString();
    }

    public static void a(Throwable r100) {
        if (r100 != null) goto L7;
        return;
    L7:
        a(b(r100));     // Catch: Throwable -> L6
        return;
    }

    public static void a(Log.ISdkLogCallback r100) {
        f25808a = r100;
    }

    public static String a(String r100, String r101) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        return String.format("[%s][%s]", new Object[]{r100, r101});
    }

    public static void b(String r100, String r101) {
        a(a(r100, r101));
    }

    public static void c(String r100, String r101) {
        a(a(r100, r101));
    }

    public static void d(String r100, String r101) {
        a(a(r100, r101));
    }

    public static void e(String r100, String r101) {
        a(a(r100, r101));
    }

    public static void a(String r100, String r101, Throwable r102) {
        a(a(r100, r101) + " " + b(r102));
    }
}

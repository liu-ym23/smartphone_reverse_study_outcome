package com.baidu.mapsdkplatform.comapi.a.a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* loaded from: classes.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private static int f7842a = 10240;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f7843b = false;

    /* renamed from: c, reason: collision with root package name */
    private String f7844c;

    /* renamed from: d, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f7845d;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f7846a = new a();
    }

    public static a a() {
        return b.f7846a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (f7843b) {
            return;
        }
        f7843b = true;
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f7845d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private a() {
        this.f7844c = "";
        this.f7845d = Thread.getDefaultUncaughtExceptionHandler();
    }

    public void a(String str) {
        this.f7844c = str;
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof a) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private void a(Throwable th) {
        String str;
        if (th == null) {
            return;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            Throwable cause = th.getCause();
            if (cause != null) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            String string = stringWriter.toString();
            if (string.isEmpty()) {
                return;
            }
            int length = string.length();
            int i4 = f7842a;
            if (length > i4) {
                string = string.substring(0, i4);
            }
            if (string.contains("BDMapSDKException")) {
                return;
            }
            if ((string.contains("com.baidu.platform") || string.contains("com.baidu.mapsdkplatform") || string.contains("com.baidu.baidunavis") || string.contains("com.baidu.navisdk") || string.contains("com.baidu.navcore")) && (str = this.f7844c) != null && !str.isEmpty()) {
                com.baidu.mapsdkplatform.comapi.a.a.b.c().a(this.f7844c + (System.currentTimeMillis() / 1000) + ".txt", string);
            }
        } catch (Exception unused) {
        }
    }
}

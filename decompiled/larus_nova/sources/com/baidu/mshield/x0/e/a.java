package com.baidu.mshield.x0.e;

import android.text.TextUtils;
import com.baidu.mshield.x0.d.d;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes39.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f32502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f32503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f32504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f32505d;

    public synchronized void b() {
        monitor-enter(this);
        Thread.UncaughtExceptionHandler r100 = this.f32503b;     // Catch: Throwable -> L7
        if (r100 == null) goto L9;
        Thread.setDefaultUncaughtExceptionHandler(r100);     // Catch: Throwable -> L7
        this.f32503b = null;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    static {
        f32502a = new a();
    }

    public a() {
    }

    public static a a() {
        return f32502a;
    }

    public synchronized void a(b r100) {
        monitor-enter(this);
        this.f32505d = r100;     // Catch: Throwable -> L19
        if (r100 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r100.a() == true) goto L12;
        monitor-exit(this);
        return;
    L12:
        if (this.f32504c == false) goto L16;
        monitor-exit(this);
        return;
    L16:
        this.f32504c = true;     // Catch: Throwable -> L19
        this.f32503b = Thread.getDefaultUncaughtExceptionHandler();     // Catch: Throwable -> L19
        Thread.setDefaultUncaughtExceptionHandler(this);     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final String a(Throwable r100) {
        StringWriter r101 = new StringWriter();     // Catch: Throwable -> L7
        PrintWriter r102 = new PrintWriter(r101);     // Catch: Throwable -> L7
        r100.printStackTrace(r102);     // Catch: Throwable -> L6
        String r103 = r101.toString();     // Catch: Throwable -> L6
        r102.close();
        return r103;
    L8:
        if (r102 == null) goto L16;
        r102.close();
        return "";
    L16:
        return "";
    L7:
        r102 = null;
        goto L8
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r100, Throwable r101) {
        String r102 = a(r101);     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r102) == false) goto L5;
    L16:
        Thread.UncaughtExceptionHandler r103 = this.f32503b;
        if (r103 == null) goto L22;
        r103.uncaughtException(r100, r101);
        return;
    L22:
        return;
    L5:
        if (r102.contains("mshield") == false) goto L7;
    L10:
        b r104 = this.f32505d;     // Catch: Throwable -> L14
        if (r104 == null) goto L16;
        r104.a(r102);     // Catch: Throwable -> L14
        goto L16
    L7:
        if (r102.contains("WebViewProvider") == true) goto L10;
        if (r102.contains("createWebView") == false) goto L16;
    L14:
        th = move-exception;
        d.a(th);
        goto L16
    }
}

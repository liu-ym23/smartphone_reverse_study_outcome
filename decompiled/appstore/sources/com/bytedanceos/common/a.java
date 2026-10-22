package com.bytedanceos.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import com.bytedanceos.common.toolbox.c0;
import com.bytedanceos.common.toolbox.j;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f9583a;

    public a() {
    }

    public void a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.PrintWriter] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.File] */
    public void b(Throwable r10) {
        String r11 = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date(System.currentTimeMillis()));
        if (BaseApplication.c().o() == false) goto L5;
        String r12 = "appstore_crash_" + r11 + ".txt";
    L6:
        PrintWriter r13 = Environment.getExternalStorageDirectory();
        PrintWriter r14 = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(r13, r12)), c0.e())));     // Catch: Throwable -> L16 PackageManager.NameNotFoundException -> L18 IOException -> L20
    L35:
        r14.print("OS Version: ");     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L12 IOException -> L14
        r14.println(com.bytedanceos.common.toolbox.e.U(true));     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L12 IOException -> L14
        PackageInfo r15 = BaseApplication.c().getPackageManager().getPackageInfo(BaseApplication.c().getPackageName(), 0);     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L12 IOException -> L14
        r14.print("App Name: ");     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L12 IOException -> L14
        r14.println(r15.versionName);     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L12 IOException -> L14
        r14.print("App Version: ");     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L12 IOException -> L14
        r14.println(r15.versionCode);     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L12 IOException -> L14
        r14.println();     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L12 IOException -> L14
        r10.printStackTrace(r14);     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L12 IOException -> L14
        r13 = r14;
    L9:
        r13.close();
        return;
    L12:
        PackageManager.NameNotFoundException e10 = e;
    L22:
        e10.printStackTrace();     // Catch: Throwable -> L10
        if (r14 == null) goto L37;
        r13 = r14;
        goto L9
    L37:
        return;
    L14:
        IOException e11 = e;
    L25:
        e11.printStackTrace();     // Catch: Throwable -> L10
        r13 = r14;
        if (r14 != null) goto L9;
        return;
    L10:
        Throwable th = th;
    L29:
        if (r13 == 0) goto L31;
        r13.close();
    L31:
        throw th;
    L18:
        e = move-exception;
        r14 = null;
        e10 = e;
    L20:
        e = move-exception;
        r14 = null;
        e11 = e;
    L16:
        th = move-exception;
        r13 = 0;
        th = th;
        goto L29
    L5:
        r12 = "gamestore_crash_" + r11 + ".txt";
        goto L6
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r10, Throwable r11) {
        System.gc();
        j.n("catch exception:");
        r11.printStackTrace();
        if ((r11 instanceof OutOfMemoryError) == false) goto L5;
        com.bytedanceos.common.toolbox.e.P0("catch exception", false);
    L6:
        Thread.UncaughtExceptionHandler r12 = this.f9583a;
        if (r12 == null) goto L9;
        r12.uncaughtException(r10, r11);
        return;
    L9:
        r11.printStackTrace();
        j.a("exit process");
        System.exit(1);
        return;
    L5:
        b(r11);
        goto L6
    }
}

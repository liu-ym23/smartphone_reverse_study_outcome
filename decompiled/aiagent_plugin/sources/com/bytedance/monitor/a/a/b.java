package com.bytedance.monitor.a.a;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.monitor.a.d;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SafelyLibraryLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<String> f8878a;

    static {
        f8878a = new ArrayList();
    }

    public static synchronized boolean a(Context r6, String r7) {
        monitor-enter(b.class);
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (f8878a.contains(r7) == false) goto L38;
        monitor-exit(b.class);
        return true;
    L38:
        System.loadLibrary(r7);     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
        f8878a.add(r7);     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
    L28:
        monitor-exit(b.class);
        return true;
    L14:
        e = move-exception;
        File r4 = b(r8, r7);     // Catch: Throwable -> L32
        if (r4 != null) goto L20;
        return false;
    L20:
        if (r4.exists() == false) goto L22;
        r4.delete();     // Catch: Throwable -> L32
    L22:
        String r9 = a(r8, r7, r4);     // Catch: Throwable -> L32
        if (r9 == null) goto L35;
        a("loadLibrary", e.getMessage() + "[" + r9 + "]");     // Catch: Throwable -> L32
        return false;
    L35:
        System.load(r4.getAbsolutePath());     // Catch: Throwable -> L30
        f8878a.add(r7);     // Catch: Throwable -> L30
    L31:
        return false;
    L13:
        return false;
    L32:
        th = move-exception;
        throw th;
    }

    private static File a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.getFilesDir() == null) goto L13;
        File r0 = new File(r3.getFilesDir(), "libso");
        if (r0.exists() == true) goto L10;
        d.a(r0.getAbsolutePath());
    L10:
        return r0;
    L13:
        return null;
    }

    private static File b(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        String r5 = System.mapLibraryName(r3);
        File r6 = a(r4);
        if (r6 != null) goto L5;
        return null;
    L5:
        return new File(r6, r5);
    }

    public static String a(Context r7, String r8, File r9) {
        FileOutputStream r2 = null;
        ZipFile r3 = new ZipFile(new File(((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin")).getApplicationInfo().sourceDir), 1);     // Catch: Throwable -> L33
        ZipEntry r10 = r3.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(r8));     // Catch: Throwable -> L31
        if (r10 != null) goto L17;
        int r11 = Build.CPU_ABI.indexOf(45);     // Catch: Throwable -> L31
        StringBuilder r1 = new StringBuilder().append("lib/");     // Catch: Throwable -> L31
        String r5 = Build.CPU_ABI;     // Catch: Throwable -> L31
        if (r11 > 0) goto L10;
        r11 = Build.CPU_ABI.length();     // Catch: Throwable -> L31
    L10:
        String r12 = r1.append(r5.substring(0, r11)).append("/").append(System.mapLibraryName(r8)).toString();     // Catch: Throwable -> L31
        ZipEntry r13 = r3.getEntry(r12);     // Catch: Throwable -> L31
        if (r13 != null) goto L16;
        String r14 = "Library entry not found:" + r12;     // Catch: Throwable -> L31
        d.a(null);
        d.a(null);
    L14:
        d.a(r3);
        return r14;
    L16:
        r10 = r13;
    L17:
        r9.createNewFile();     // Catch: Throwable -> L31
        InputStream r15 = r3.getInputStream(r10);     // Catch: Throwable -> L31
        FileOutputStream r16 = new FileOutputStream(r9);     // Catch: Throwable -> L29
        byte[] r0 = new byte[4096];     // Catch: Throwable -> L27
    L21:
        int r4 = r15.read(r0);     // Catch: Throwable -> L27
        if (r4 <= 0) goto L24;
        r16.write(r0, 0, r4);     // Catch: Throwable -> L27
        goto L21
    L24:
        d.a(r9.getAbsolutePath(), 493);     // Catch: Throwable -> L27
        d.a(r16);
        d.a(r15);
        d.a(r3);
        return null;
    L27:
        th = move-exception;
        r2 = r16;
        InputStream r17 = r15;
        th = th;
    L43:
        r14 = th.getMessage();     // Catch: Throwable -> L37
        d.a(r2);
        d.a(r17);
    L37:
        th = move-exception;
        d.a(r2);
        d.a(r17);
        d.a(r3);
        throw th;
    L29:
        th = move-exception;
        r17 = r15;
        th = th;
    L31:
        th = th;
        r17 = null;
    L33:
        th = th;
        r17 = null;
        r3 = null;
        goto L43
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}

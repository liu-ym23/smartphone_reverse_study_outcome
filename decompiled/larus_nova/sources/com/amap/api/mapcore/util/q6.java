package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes28.dex */
public class q6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f27892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Vector<w5> f27893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f27894c = 0;

    public static class a extends a9 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f27895b;

        @Override // com.amap.api.mapcore.util.a9
        public final void runTask() {
            u6.b(this.f27895b);     // Catch: Throwable -> L4 RejectedExecutionException -> L7
            u6.d(this.f27895b);     // Catch: Throwable -> L4 RejectedExecutionException -> L7
            u6.c(this.f27895b);     // Catch: Throwable -> L4 RejectedExecutionException -> L7
            i8.a(this.f27895b);     // Catch: Throwable -> L4 RejectedExecutionException -> L7
            g8.a(this.f27895b);     // Catch: Throwable -> L4 RejectedExecutionException -> L7
            return;
        L4:
            th = move-exception;
            t6.a(th, "Lg", "proL");
            return;
        }

        public a(Context r100) {
            this.f27895b = r100;
        }
    }

    static {
        f27893b = new Vector();
    }

    public static List<w5> a() {
        Looper r100 = Looper.getMainLooper();     // Catch: Throwable -> L10
        monitor-enter(r100);     // Catch: Throwable -> L10
        Vector<w5> r101 = f27893b;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        return f27893b;
    }

    public static void a(Context r100) {
    L7:
        th = move-exception;
        t6.a(th, "Lg", "proL");
        return;
    L3:
        if ((System.currentTimeMillis() - f27892a) >= 60000) goto L5;
        return;
    L5:
        f27892a = System.currentTimeMillis();     // Catch: Throwable -> L7
        z8.f().d(new a(r100));     // Catch: Throwable -> L7
    }

    public static void a(w5 r100) {
        Looper r101 = Looper.getMainLooper();     // Catch: Throwable -> L17
        monitor-enter(r101);     // Catch: Throwable -> L17
        if (r100 != null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L8:
        if (f27893b.contains(r100) == false) goto L11;
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L11:
        f27893b.add(r100);     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    }

    public static boolean a(String[] r100, String r101) {
        if (r100 == null) goto L21;
        if (r101 == null) goto L21;
        int r102 = r100.length;     // Catch: Throwable -> L19
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L21;
        String r104 = r100[r103];     // Catch: Throwable -> L19
        r101 = r101.trim();     // Catch: Throwable -> L19
        if (r101.startsWith("at ") == false) goto L18;
        if (r101.contains(r104 + ".") == false) goto L18;
        if (r101.endsWith(")") == false) goto L18;
        if (r101.contains("uncaughtException") == true) goto L18;
        return true;
    L18:
        r103 = r103 + 1;
    L19:
        th = move-exception;
        th.printStackTrace();
    L21:
        return false;
    }

    public static String b(Context r100, String r101) {
        return r100.getSharedPreferences("AMSKLG_CFG", 0).getString(r101, "");
    }

    public static String a(Context r100, String r101) {
        return r100.getFilesDir().getAbsolutePath() + "/a/" + r101;
    }
}

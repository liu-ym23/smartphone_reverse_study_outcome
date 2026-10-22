package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes28.dex */
public final class ce {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f26386a = "/a/";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f26387b = "b";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String f26388c = "c";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String f26389d = "d";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f26390e = "s";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f26391f = "g";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f26392g = "h";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f26393h = "e";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f26394i = "f";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f26395j = "j";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f26396k = "k";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static long f26397l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static Vector<br> f26398m;

    static {
        f26398m = new Vector();
    }

    public static List<br> a() {
        Looper r100 = Looper.getMainLooper();     // Catch: Throwable -> L10
        monitor-enter(r100);     // Catch: Throwable -> L10
        Vector<br> r101 = f26398m;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        return f26398m;
    }

    public static void a(final Context r100) {
    L12:
        th = move-exception;
        cg.c(th, "Lg", "proL");
        return;
    L3:
        if ((System.currentTimeMillis() - f26397l) >= 60000) goto L5;
        return;
    L5:
        f26397l = System.currentTimeMillis();     // Catch: Throwable -> L12
        ExecutorService r101 = cg.c();     // Catch: Throwable -> L12
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.isShutdown() == true) goto L18;
        r101.submit(new AnonymousClass1(r100));     // Catch: Throwable -> L12
        return;
    }

    public static void a(br r100) {
        Looper r101 = Looper.getMainLooper();     // Catch: Throwable -> L17
        monitor-enter(r101);     // Catch: Throwable -> L17
        if (r100 != null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L8:
        if (f26398m.contains(r100) == false) goto L11;
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L11:
        f26398m.add(r100);     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    }

    public static boolean a(String[] r100, String r101) {
        if (r100 == null) goto L28;
        if (r101 == null) goto L28;
        String[] r102 = r101.split("\n");     // Catch: Throwable -> L26
        int r103 = r102.length;     // Catch: Throwable -> L26
        int r104 = 0;
    L7:
        boolean r105 = true;
        if (r104 >= r103) goto L20;
        String r106 = r102[r104].trim();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r106) == false) goto L12;
    L16:
        r105 = false;
    L17:
        if (r105 == true) goto L18;
        r104 = r104 + 1;     // Catch: Throwable -> L26
        goto L7
    L18:
        return false;
    L12:
        if (r106.startsWith("at ") == false) goto L16;
        if (r106.contains("uncaughtException") == false) goto L16;
    L20:
        int r107 = r102.length;     // Catch: Throwable -> L26
        int r108 = 0;
    L21:
        if (r108 >= r107) goto L28;
        if (b(r100, r102[r108].trim()) == true) goto L24;
        r108 = r108 + 1;
        goto L21
    L24:
        return true;
    L26:
        th = move-exception;
        th.printStackTrace();
    L28:
        return false;
    }

    public static boolean b(String[] r100, String r101) {
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

    public static String c(Context r100, String r101) {
        return r100.getFilesDir().getAbsolutePath() + f26386a + r101;
    }

    public static String a(Context r100, String r101) {
        return r100.getSharedPreferences("AMSKLG_CFG", 0).getString(r101, "");
    }

    public static void b(Context r100, String r101) {
        SharedPreferences.Editor r102 = r100.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r102.remove(r101);
        r102.apply();
    }

    public static void a(Context r100, String r101, String r102) {
        SharedPreferences.Editor r103 = r100.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r103.putString(r101, r102);
        r103.apply();
    }
}

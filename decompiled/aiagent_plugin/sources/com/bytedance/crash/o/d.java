package com.bytedance.crash.o;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: DateUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static DateFormat f7658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static DateFormat f7659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static DateFormat f7660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static DateFormat f7661d;

    public static DateFormat a() {
        if (f7658a != null) goto L6;
        f7658a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    L6:
        return f7658a;
    }

    public static DateFormat b() {
        if (f7659b != null) goto L6;
        f7659b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
    L6:
        return f7659b;
    }

    public static DateFormat c() {
        if (f7660c != null) goto L6;
        f7660c = new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss", Locale.getDefault());
    L6:
        return f7660c;
    }

    public static DateFormat d() {
        if (f7661d != null) goto L6;
        f7661d = new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss.SSS", Locale.getDefault());
    L6:
        return f7661d;
    }

    public static long a(String r2) {
        Date r3 = b().parse(r2);
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.getTime();
    }

    public static String a(long r2) {
        return b().format(new Date(r2));
    }

    public static String b(long r2) {
        return a().format(new Date(r2));
    }
}

package com.blankj.utilcode.util;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f6220b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f6221a;

    static {
        f6220b = new HashMap();
    }

    public e(String r10, int r11) {
        this.f6221a = Utils.c().getSharedPreferences(r10, r11);
    }

    public static e a(String r10) {
        return b(r10, 0);
    }

    public static e b(String r10, int r11) {
        if (e(r10) == false) goto L5;
        r10 = "spUtils";
    L5:
        Map r12 = f6220b;
        e r13 = (e) r12.get(r10);
        if (r13 == null) goto L8;
    L18:
        return r13;
    L8:
        monitor-enter(e.class);
        r13 = (e) r12.get(r10);     // Catch: Throwable -> L12
        if (r13 != null) goto L14;
        r13 = new e(r10, r11);     // Catch: Throwable -> L12
        r12.put(r10, r13);     // Catch: Throwable -> L12
    L14:
        monitor-exit(e.class);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public static boolean e(String r10) {
        if (r10 != null) goto L5;
        return true;
    L5:
        int r11 = r10.length();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        if (Character.isWhitespace(r10.charAt(r12)) == false) goto L9;
        r12 = r12 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public String c(String r10) {
        return d(r10, "");
    }

    public String d(String r10, String r11) {
        return this.f6221a.getString(r10, r11);
    }
}

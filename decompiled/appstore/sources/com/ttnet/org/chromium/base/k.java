package com.ttnet.org.chromium.base;

import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f18328a = 4;

    static {
    }

    public static void a(String r10, String r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (f18328a > 3) goto L8;
        Log.d(r10, r11);
        return;
    }

    public static boolean b() {
        if (f18328a > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static void c(int r10) {
        f18328a = r10;
    }
}

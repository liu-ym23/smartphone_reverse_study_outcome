package com.bytedance.thanos.hdiff;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class HDifferHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f11205a = -1.0f;

    private static native int patch(String r0, String r1, String r2);

    public HDifferHelper() {
    }

    static {
        System.loadLibrary("hdiffpatch");
    }

    public static synchronized int a(String r2, String r3, String r4) {
        monitor-enter(HDifferHelper.class);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L25;
        if (TextUtils.isEmpty(r3) == true) goto L25;
        if (TextUtils.isEmpty(r4) == true) goto L25;
        if (new File(r2).exists() == true) goto L17;
        monitor-exit(HDifferHelper.class);
        return 302;
    L17:
        if (new File(r3).exists() == false) goto L19;
        int r5 = patch(r2, r3, r4);     // Catch: Throwable -> L27
        monitor-exit(HDifferHelper.class);
        return r5;
    L19:
        monitor-exit(HDifferHelper.class);
        return 303;
    L25:
        monitor-exit(HDifferHelper.class);
        return 301;
    }
}

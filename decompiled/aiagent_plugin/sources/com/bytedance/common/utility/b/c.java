package com.bytedance.common.utility.b;

import com.bytedance.common.utility.Logger;

/* JADX INFO: compiled from: SystemPropertiesUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    private static final String TAG = "SystemPropertiesUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f6712a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f6713b;

    static {
        f6713b = new b();
    }

    public static String a(String r3) {
        if (f6712a == false) goto L9;
        return f6713b.a(r3);
    L6:
        th = move-exception;
        Logger.e(TAG, "android.os.SystemProperties reflect fail.", th);
        return a.a(r3);
    L9:
        return a.a(r3);
    }
}

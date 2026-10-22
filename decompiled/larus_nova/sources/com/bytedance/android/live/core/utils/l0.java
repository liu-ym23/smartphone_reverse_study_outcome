package com.bytedance.android.live.core.utils;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;

/* JADX INFO: loaded from: classes45.dex */
public final class l0 {
    public static void a(PolarisFileOutputStreamWrapper r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.close();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        th.toString();
    }
}

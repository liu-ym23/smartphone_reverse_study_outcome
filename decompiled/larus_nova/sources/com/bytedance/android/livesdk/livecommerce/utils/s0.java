package com.bytedance.android.livesdk.livecommerce.utils;

import android.os.Handler;

/* JADX INFO: loaded from: classes10.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f153114a;

    public static boolean a() {
        Handler r100 = k.f153092a;
        long r101 = System.currentTimeMillis();
        if (Math.abs(r101 - f153114a) < 2000) goto L6;
        f153114a = r101;
        return true;
    L6:
        return false;
    }
}

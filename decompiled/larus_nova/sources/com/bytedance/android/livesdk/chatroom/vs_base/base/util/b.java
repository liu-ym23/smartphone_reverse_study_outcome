package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f117923a;

    public static boolean a() {
        long r100 = SystemClock.uptimeMillis();
        long r101 = r100 - f117923a;
        f117923a = r100;
        if (r101 <= 500) goto L5;
        return true;
    L5:
        return false;
    }
}

package com.ttnet.org.chromium.base;

import android.os.SystemClock;

/* JADX INFO: compiled from: TimeUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static a f37775a;

    /* JADX INFO: compiled from: TimeUtils.java */
    interface a {
        long a();
    }

    public static long a() {
        a r0 = f37775a;
        if (r0 == null) goto L7;
        return r0.a() / 1000000;
    L7:
        return SystemClock.elapsedRealtime();
    }
}

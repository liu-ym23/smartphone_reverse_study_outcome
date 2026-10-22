package com.bytedance.android.live.recharge.deal;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f89705a = 0;

    static {
        f89705a = com.bytedance.android.live.recharge.model.g.f90033a.e3();
    }

    public static final boolean a(a r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        com.bytedance.live.kmp.util.c r101 = com.bytedance.live.kmp.util.c.f255167a;
        if ((System.currentTimeMillis() - r100.f89695c) >= f89705a) goto L8;
        boolean r102 = true;
    L10:
        if (r100.f89694b.o() == 0) goto L12;
        boolean r103 = true;
    L14:
        if (r100.f89693a.f89723c > 0) goto L16;
        boolean r104 = true;
    L17:
        if (r102 == false) goto L22;
        if (r103 == false) goto L23;
        if (r104 == false) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L22:
        return false;
    L16:
        r104 = false;
        goto L17
    L12:
        r103 = false;
        goto L14
    L8:
        r102 = false;
        goto L10
    }
}

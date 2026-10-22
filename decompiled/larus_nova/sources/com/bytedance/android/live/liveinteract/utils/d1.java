package com.bytedance.android.live.liveinteract.utils;

/* JADX INFO: loaded from: classes46.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f78757a = 0;

    static {
    }

    public static boolean a(Integer r100, Integer r101) {
        if (((Boolean) vm2.e.B.getValue(null, vm2.e.f556037a[26])).booleanValue() == true) goto L5;
        return false;
    L5:
        if (r100 != null) goto L8;
    L9:
        if (r100 != null) goto L12;
    L13:
        if (r101 != null) goto L16;
    L17:
        if (r101 != null) goto L20;
        return false;
    L20:
        if (r101.intValue() != 13) goto L23;
    L21:
        return true;
    L23:
        return false;
    L16:
        if (r101.intValue() == 14) goto L21;
    L12:
        if (r100.intValue() == 23) goto L21;
    L8:
        if (r100.intValue() == 24) goto L21;
        goto L9
    }
}

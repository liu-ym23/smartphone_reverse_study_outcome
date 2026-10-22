package com.bytedance.android.livesdk.ktvimpl.base;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f142400a = 0;

    public static int a() {
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L6;
        return com.bytedance.android.livesdk.sharedpref.c.F.getValue().intValue();
    L6:
        return com.bytedance.android.livesdk.sharedpref.c.G.getValue().intValue();
    }

    static {
    }
}

package com.bytedance.android.gamecp.business.gamedetail.util;

/* JADX INFO: loaded from: classes44.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f55637a = 0;

    public static float a(float r100, float r101, float r102) {
        if (r102 > r100) goto L6;
        float r103 = 0.0f;
    L9:
        if (r103 > 0) goto L12;
        return 0.0f;
    L12:
        if (r103 < 1) goto L15;
        return 1.0f;
    L15:
        return r103;
    L6:
        if (r102 < r101) goto L17;
        r103 = 1.0f;
        goto L9
    L17:
        return (r102 - r100) / (r101 - r100);
    }

    static {
    }
}

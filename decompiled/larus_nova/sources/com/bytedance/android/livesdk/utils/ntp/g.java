package com.bytedance.android.livesdk.utils.ntp;

import android.content.Context;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f159100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f159101b;

    public static int a(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (r100.getResources() == null) goto L13;
        int r101 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r101 > 0) goto L10;
        return 0;
    L10:
        return r100.getResources().getDimensionPixelSize(r101);
    L13:
        return 0;
    }
}

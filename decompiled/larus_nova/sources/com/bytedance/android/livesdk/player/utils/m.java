package com.bytedance.android.livesdk.player.utils;

import com.ss.android.download.api.constant.BaseConstants;

/* JADX INFO: loaded from: classes11.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f156220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f156221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f156222c = null;

    public m() {
    }

    public static long a(long r100, long r101) {
        long r102 = r101 - r100;
        if (r102 <= BaseConstants.Time.HOUR) goto L5;
        return -1;
    L5:
        if (r101 >= r100) goto L7;
        return -1;
    L7:
        if (r100 > 0) goto L9;
        return -1;
    L9:
        if (r101 <= 0) goto L16;
        return r102;
    L16:
        return -1;
    }

    static {
        f156222c = new m();
        f156221b = -1;
    }
}

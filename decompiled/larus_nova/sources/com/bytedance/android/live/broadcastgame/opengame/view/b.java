package com.bytedance.android.live.broadcastgame.opengame.view;

import com.bytedance.android.livesdk.utils.r1;

/* JADX INFO: loaded from: classes45.dex */
public final class b {
    public static final String a(long r100) {
        if (r100 >= 10000) goto L6;
        return String.valueOf(r100);
    L6:
        if (r100 >= 100000000) goto L9;
        return r1.b("%.1f", new Object[]{Double.valueOf((r100 * 1.0d) / 10000.0d)}) + "万";
    L9:
        return r1.b("%.1f", new Object[]{Double.valueOf((r100 * 1.0d) / 1.0E8d)}) + "亿";
    }
}

package com.bytedance.android.livesdk.chatroom.vs_base.util;

import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.ss.ttm.player.C;

/* JADX INFO: loaded from: classes8.dex */
public final class l {
    public static String a(long r110) {
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.f117920a == false) goto L7;
        return IESUIUtils.getDisplayCount(r110, "w");
    L7:
        if (r110 >= 10000) goto L10;
        return String.valueOf(r110);
    L10:
        if (r110 >= 100000) goto L13;
        return n.a("%.1f", new Object[]{Double.valueOf((r110 * 1.0d) / 10000.0d)}) + "万";
    L13:
        if (r110 >= 1000000) goto L16;
        return n.a("%.0f", new Object[]{Double.valueOf((r110 * 1.0d) / 10000.0d)}) + "万";
    L16:
        if (r110 >= StackLeakChecker.CHECK_INTERVAL_10_SEC) goto L19;
        return n.a("%.0f", new Object[]{Double.valueOf((r110 * 1.0d) / 10000.0d)}) + "万";
    L19:
        if (r110 >= 100000000) goto L22;
        return n.a("%.1f", new Object[]{Double.valueOf((r110 * 1.0d) / 1.0E7d)}) + "千万";
    L22:
        if (r110 >= C.NANOS_PER_SECOND) goto L25;
        return n.a("%.1f", new Object[]{Double.valueOf((r110 * 1.0d) / 1.0E8d)}) + "亿";
    L25:
        return n.a("%.0f", new Object[]{Double.valueOf((r110 * 1.0d) / 1.0E8d)}) + "亿";
    }
}

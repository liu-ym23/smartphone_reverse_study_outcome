package com.bytedance.android.live.revenuelink;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k {
    public static g a(String r110, LiveTracingMonitorKt.EventModule r111, Map r112, int r113, String r114, String r115, long r116, int r117) {
        if ((r117 & 8) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r117 & 16) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r117 & 32) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r117 & 64) == 0) goto L17;
        long r103 = 0;
    L18:
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r111, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r112, "index");
        return new g(r110, r111, r112, r100, r101, r102, r103);
    L17:
        r103 = r116;
        goto L18
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}

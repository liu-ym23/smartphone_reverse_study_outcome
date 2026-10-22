package com.bytedance.android.livesdk.livecommerce.playback.card.widget;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class e {
    public e() {
    }

    public static boolean a(String r100, String r101) {
        float r102 = CastFloatProtector.parseFloat(r100);     // Catch: Exception -> L9
        float r103 = CastFloatProtector.parseFloat(r101);     // Catch: Exception -> L9
        if (r103 != r102) goto L7;
        return false;
    L7:
        if (r103 <= 0) goto L18;
        return true;
    L18:
        return false;
    L9:
        e = move-exception;
        String r104 = e.getMessage();
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        ECExceptionMonitor.c(r104);
        return false;
    }
}

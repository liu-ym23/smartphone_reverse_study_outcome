package com.bytedance.safetyguard.lxc.internal.d;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: ProxyWriter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class z {
    private static final String TAG = "ProxyWriter";

    public static final int a(byte[] r4) {
        d.h.b.o.e(r4, "payload");
        if (r4.length != 4) goto L10;
        int r5 = ByteBuffer.wrap(r4).order(ByteOrder.BIG_ENDIAN).getInt();
        if (r5 <= 0) goto L8;
        return r5;
    L8:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("WINDOW_UPDATE delta must be positive", null, 2, null);
    L10:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("WINDOW_UPDATE payload must be uint32", null, 2, null);
    }
}

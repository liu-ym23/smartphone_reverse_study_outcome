package com.bytedance.android.anniex.container.util;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;

/* JADX INFO: loaded from: classes43.dex */
public final class b {
    public static final ia.c a(IBDXBridgeContext r100) {
        if (r100 == null) goto L8;
        m16.b r101 = (m16.b) r100.getService(m16.b.class);
        if (r101 == null) goto L10;
        ia.c r102 = (ia.c) r101.c(ia.c.class);
        if ((r102 instanceof ia.d) == false) goto L11;
        return r102;
    L11:
        return null;
    L10:
        return null;
    L8:
        return null;
    }

    public static final ia.c b(IBDXBridgeContext r100) {
        if (r100 == null) goto L8;
        m16.b r101 = (m16.b) r100.getService(m16.b.class);
        if (r101 == null) goto L10;
        ia.c r102 = (ia.c) r101.c(ia.c.class);
        if ((r102 instanceof com.bytedance.android.anniex.container.d) == false) goto L11;
        return r102;
    L11:
        return null;
    L10:
        return null;
    L8:
        return null;
    }
}

package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class p0 extends a<am2.z> {
    public p0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        am2.z r102 = (am2.z) r101;
        super.u(r100, r102);
        if (r102 != null) goto L6;
        return;
    L6:
        if (r100.containsKey(com.bytedance.android.ec.core.event.a.KEY_STAGING_FLAG) == false) goto L9;
        r100.remove(com.bytedance.android.ec.core.event.a.KEY_STAGING_FLAG);
        return;
    }
}

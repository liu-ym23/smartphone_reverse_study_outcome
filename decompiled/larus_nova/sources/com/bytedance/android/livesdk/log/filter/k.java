package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class k extends a<am2.h> {
    public k() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        am2.h r102 = (am2.h) r101;
        super.u(r100, r102);
        if (r102 == null) goto L7;
        r100.put("status", null);
        return;
    }
}

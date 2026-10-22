package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class j extends a<am2.g> {
    public j() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        am2.g r102 = (am2.g) r101;
        super.u(r100, r102);
        if (r102 == null) goto L7;
        r100.put("gesture_id", String.valueOf(0));
        return;
    }
}

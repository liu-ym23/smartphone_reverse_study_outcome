package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends a<am2.a> {
    public b() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        am2.a r102 = (am2.a) r101;
        super.u(r100, r102);
        if (r102 == null) goto L7;
        r100.put("action_type", null);
        return;
    }
}

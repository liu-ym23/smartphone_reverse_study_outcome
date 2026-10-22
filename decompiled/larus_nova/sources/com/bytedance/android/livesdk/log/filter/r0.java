package com.bytedance.android.livesdk.log.filter;

import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class r0 extends a<am2.d0> {
    public r0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        am2.d0 r102 = (am2.d0) r101;
        super.u(r100, r102);
        if (r102 == null) goto L7;
        r100.put(EventConstant.Key.RETAIN_PROMPT, null);
        return;
    }
}

package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class e0 extends a<am2.r> {
    public e0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        am2.r r102 = (am2.r) r101;
        super.u(r100, r102);
        if (r102 == null) goto L14;
        r100.put("windows_type", String.valueOf(r102.f4330a));
        r100.put("initial_page", r102.f4331b);
        r100.put("trigger_scene", r102.f4332c);
        if ("content".equals(r102.f4331b) == true) goto L8;
        return;
    L8:
        if (r102.f4333d == false) goto L10;
        String r103 = "1";
    L11:
        r100.put("is_auto_play", r103);
        return;
    L10:
        r103 = "0";
        goto L11
    }
}

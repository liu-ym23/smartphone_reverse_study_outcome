package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class d extends a<am2.c> {
    public d() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        am2.c r102 = (am2.c) r101;
        super.u(r100, r102);
        if (r102 == null) goto L12;
        String r103 = r102.f4271a;
        if (r103 == null) goto L10;
        if (r100 == null) goto L11;
        String r104 = (String) r100.put("click_user_position", r103);
        return;
    L11:
        return;
    L10:
        return;
    }
}

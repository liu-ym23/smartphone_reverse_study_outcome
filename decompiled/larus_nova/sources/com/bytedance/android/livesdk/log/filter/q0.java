package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class q0 extends a<am2.c0> {
    public q0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        am2.c0 r102 = (am2.c0) r101;
        super.u(r100, r102);
        if (r102 == null) goto L11;
        am2.l r103 = r102.f4273a;
        if (r103 == null) goto L12;
        if (r100 == null) goto L8;
        String r104 = (String) r100.put("pk_id", String.valueOf(r103.f4297e));
    L8:
        if (r100 == null) goto L13;
        String r105 = (String) r100.put("connection_type", r103.f4296d);
        return;
    L13:
        return;
    L12:
        return;
    }
}

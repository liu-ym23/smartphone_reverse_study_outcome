package com.bytedance.android.livesdk.interactivity.api.entity;

import com.bytedance.android.live.base.model.message.a5;

/* JADX INFO: loaded from: classes9.dex */
public final class q implements am3.c<RiskAdviseSyncData> {
    public q() {
    }

    @Override // am3.c
    public final RiskAdviseSyncData decode(am3.g r100) throws Exception {
        RiskAdviseSyncData r101 = new RiskAdviseSyncData();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.createTime = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.adviseText = (a5) vh7.f.a(r100, a5.class);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }
}

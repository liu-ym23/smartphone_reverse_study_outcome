package com.bytedance.android.live.liveinteract.plantform.model;

/* JADX INFO: loaded from: classes46.dex */
public final class r1 implements am3.c<WaitingListUserInfo> {
    public r1() {
    }

    @Override // am3.c
    public final WaitingListUserInfo decode(am3.g r100) throws Exception {
        WaitingListUserInfo r101 = new WaitingListUserInfo();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        r101.applyTimeSec = Long.valueOf(r100.j());
        goto L3
    L9:
        r101.fuzzyFanTicketStr = am3.h.c(r100);
        goto L3
    L10:
        r101.last7DaysGiftCountTxt = am3.h.c(r100);
        goto L3
    L11:
        r101.applyReason = am3.h.c(r100);
        goto L3
    L12:
        r101.isMutualFollow = am3.h.a(r100);
        goto L3
    L13:
        r101.hasExpired = am3.h.a(r100);
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L14:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }
}

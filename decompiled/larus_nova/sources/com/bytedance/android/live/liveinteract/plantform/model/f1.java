package com.bytedance.android.live.liveinteract.plantform.model;

/* JADX INFO: loaded from: classes46.dex */
public final class f1 implements am3.c<InviteListUserInfo> {
    public f1() {
    }

    @Override // am3.c
    public final InviteListUserInfo decode(am3.g r100) throws Exception {
        InviteListUserInfo r101 = new InviteListUserInfo();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.last7DaysGiftCountTxt = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.fuzzyFanTicket = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.isActive = am3.h.a(r100);
        goto L3
    L11:
        am3.h.d(r104, r100);
        goto L3
    L15:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }
}

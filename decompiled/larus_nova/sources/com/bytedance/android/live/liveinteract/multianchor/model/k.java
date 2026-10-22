package com.bytedance.android.live.liveinteract.multianchor.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes46.dex */
public final class k implements am3.c<ListUserExtra> {
    public k() {
    }

    @Override // am3.c
    public final ListUserExtra decode(am3.g r100) throws Exception {
        ListUserExtra r101 = new ListUserExtra();
        r101.setThreadSafe(false);
        r101.rankContributorOpenIds = new ArrayList();
        r101.rankUserIds = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L22;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 5000) goto L7;
        r101.rankContributorOpenIds.add(am3.h.c(r100));
        goto L3
    L7:
        switch(r103) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            default: goto L8;
        };
    L9:
        r101.listUserRole = r100.i();
        goto L3
    L10:
        r101.rankUserIds.add(Long.valueOf(r100.j()));
        goto L3
    L11:
        r101.fanTicketRealStr = am3.h.c(r100);
        goto L3
    L12:
        r101.fanTicketFuzzyStr = am3.h.c(r100);
        goto L3
    L13:
        r101.currentTime = r100.j();
        goto L3
    L14:
        r101.expectLeaveTime = r100.j();
        goto L3
    L15:
        r101.joinChannelTime = r100.j();
        goto L3
    L16:
        r101.devicePlatform = am3.h.c(r100);
        goto L3
    L17:
        r101.clientVersion = r100.j();
        goto L3
    L18:
        r101.appId = r100.j();
        goto L3
    L19:
        r101.isHost = am3.h.a(r100);
        goto L3
    L20:
        r101.fanTicket = r100.j();
        goto L3
    L8:
        am3.h.d(r104, r100);
        goto L3
    L22:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }
}

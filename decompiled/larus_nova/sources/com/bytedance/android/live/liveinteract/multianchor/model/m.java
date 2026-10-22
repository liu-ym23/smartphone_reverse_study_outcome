package com.bytedance.android.live.liveinteract.multianchor.model;

/* JADX INFO: loaded from: classes46.dex */
public final class m implements am3.c<ListUserLinkmicContent> {
    public m() {
    }

    @Override // am3.c
    public final ListUserLinkmicContent decode(am3.g r100) throws Exception {
        ListUserLinkmicContent r101 = new ListUserLinkmicContent();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L24;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.resourceId = r100.j();
        goto L3
    L8:
        if (r103 != 3) goto L10;
        r101.role = r100.i();
        goto L3
    L10:
        if (r103 != 4) goto L11;
        r101.mGameName = am3.h.c(r100);
        goto L3
    L11:
        switch(r103) {
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            case 11: goto L16;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L13;
            default: goto L12;
        };
    L13:
        r101.virtualTool = am3.h.c(r100);
        goto L3
    L14:
        r101.liveRoomMode = r100.j();
        goto L3
    L15:
        r101.hostSwitch = am3.h.a(r100);
        goto L3
    L16:
        r101.hostLabelNameColor = am3.h.c(r100);
        goto L3
    L17:
        r101.hostLabelBackgroundColor = am3.h.c(r100);
        goto L3
    L18:
        r101.hostLabelName = am3.h.c(r100);
        goto L3
    L19:
        r101.anchorAuthRole = r100.i();
        goto L3
    L20:
        r101.mAnchorLinkMicIdInfo = (AnchorLinkMicIdInfo) vh7.f.a(r100, AnchorLinkMicIdInfo.class);
        goto L3
    L12:
        am3.h.d(r104, r100);
        goto L3
    L24:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }
}

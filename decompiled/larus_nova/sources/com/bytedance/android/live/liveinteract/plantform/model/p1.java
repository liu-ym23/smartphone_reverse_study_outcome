package com.bytedance.android.live.liveinteract.plantform.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes46.dex */
public final class p1 implements am3.c<RoomLinkerContent> {
    public p1() {
    }

    public static RoomLinkerContent a(am3.g r100) throws Exception {
        RoomLinkerContent r101 = new RoomLinkerContent();
        r101.setThreadSafe(false);
        r101.linkedUsers = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L16;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 5000) goto L7;
        r101.anchorId = am3.h.c(r100);
        goto L3
    L7:
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        r101.roomLiveMode = r100.j();
        goto L3
    L10:
        r101.mVersion = r100.j();
        goto L3
    L11:
        r101.mIsGuestAnchorBackground = (int) r100.j();
        goto L3
    L12:
        r101.mAnchorId = r100.j();
        goto L3
    L13:
        r101.mRoomLinkSilenceStatus = r100.i();
        goto L3
    L14:
        r101.linkedUsers.add((com.bytedance.android.livesdk.link.model.bridge.k) vh7.f.a(r100, com.bytedance.android.livesdk.link.model.bridge.k.class));
        goto L3
    L8:
        am3.h.d(r104, r100);
        goto L3
    L16:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    @Override // am3.c
    public final RoomLinkerContent decode(am3.g r100) throws Exception {
        return a(r100);
    }
}

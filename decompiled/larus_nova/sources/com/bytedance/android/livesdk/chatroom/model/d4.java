package com.bytedance.android.livesdk.chatroom.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class d4 implements am3.c<BannerInRoomCollection.BannerInfo> {
    public d4() {
    }

    @Override // am3.c
    public final BannerInRoomCollection.BannerInfo decode(am3.g r100) throws Exception {
        BannerInRoomCollection.BannerInfo r101 = new BannerInRoomCollection.BannerInfo();
        r101.setThreadSafe(false);
        r101.bannerList = new ArrayList();
        r101.tokenList = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        r101.tokenList.add(am3.h.c(r100));
        goto L3
    L9:
        r101.containerType = (int) r100.j();
        goto L3
    L10:
        r101.lynxUrl = am3.h.c(r100);
        goto L3
    L11:
        r101.width = (int) r100.j();
        goto L3
    L12:
        r101.height = (int) r100.j();
        goto L3
    L13:
        r101.collapseInfo = c4.a(r100);
        goto L3
    L14:
        r101.animationImage = (py.k) vh7.f.a(r100, py.k.class);
        goto L3
    L15:
        r101.bannerList.add((com.bytedance.android.livesdk.gift.model.b1) vh7.f.a(r100, com.bytedance.android.livesdk.gift.model.b1.class));
        goto L3
    L16:
        r101.h5Url = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L17:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }
}

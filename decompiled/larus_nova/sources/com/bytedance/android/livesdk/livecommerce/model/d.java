package com.bytedance.android.livesdk.livecommerce.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements am3.c<ECV2AuctionInfo> {
    public d() {
    }

    public static ECV2AuctionInfo a(am3.g r100) throws Exception {
        ECV2AuctionInfo r101 = new ECV2AuctionInfo();
        r101.incrPriceList = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
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
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        r101.bizId = r100.i();
        goto L3
    L8:
        r101.endTime = r100.j();
        goto L3
    L9:
        r101.productId = r100.j();
        goto L3
    L10:
        r101.buttonLabel = am3.h.c(r100);
        goto L3
    L11:
        r101.incrPriceList.add(b.a(r100));
        goto L3
    L12:
        r101.currentUserInfo = c.a(r100);
        goto L3
    L13:
        r101.jumpUrl = am3.h.c(r100);
        goto L3
    L14:
        r101.status = r100.i();
        goto L3
    L15:
        r101.priceLabel = am3.h.c(r100);
        goto L3
    L16:
        r101.price = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2AuctionInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}

package com.bytedance.android.livesdk.livecommerce.model;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements am3.c<ECV2AuctionInfo.ECV2AuctionIncrPrice> {
    public b() {
    }

    public static ECV2AuctionInfo.ECV2AuctionIncrPrice a(am3.g r100) throws Exception {
        ECV2AuctionInfo.ECV2AuctionIncrPrice r101 = new ECV2AuctionInfo.ECV2AuctionIncrPrice();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.price = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.range = r100.j();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2AuctionInfo.ECV2AuctionIncrPrice decode(am3.g r100) throws Exception {
        return a(r100);
    }
}

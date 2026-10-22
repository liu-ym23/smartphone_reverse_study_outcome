package com.bytedance.android.livesdk.chatroom.model;

/* JADX INFO: loaded from: classes7.dex */
public final class e4 implements am3.c<BannerInRoomCollection> {
    public e4() {
    }

    public static BannerInRoomCollection a(am3.g r100) throws Exception {
        BannerInRoomCollection r101 = new BannerInRoomCollection();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L19;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            default: goto L7;
        };
    L8:
        r101.retainConsult = (BannerInRoomCollection.BannerInfo) vh7.f.a(r100, BannerInRoomCollection.BannerInfo.class);
        goto L3
    L9:
        r101.activityVSBottomRight = (BannerInRoomCollection.BannerInfo) vh7.f.a(r100, BannerInRoomCollection.BannerInfo.class);
        goto L3
    L10:
        r101.activityInteractive = (BannerInRoomCollection.BannerInfo) vh7.f.a(r100, BannerInRoomCollection.BannerInfo.class);
        goto L3
    L11:
        r101.activityVSInteractive = (BannerInRoomCollection.BannerInfo) vh7.f.a(r100, BannerInRoomCollection.BannerInfo.class);
        goto L3
    L12:
        r101.sceneBanner = (BannerInRoomCollection.BannerInfo) vh7.f.a(r100, BannerInRoomCollection.BannerInfo.class);
        goto L3
    L13:
        r101.topLeftActivityBanner = (BannerInRoomCollection.BannerInfo) vh7.f.a(r100, BannerInRoomCollection.BannerInfo.class);
        goto L3
    L14:
        r101.activityTopRightBanner = (BannerInRoomCollection.BannerInfo) vh7.f.a(r100, BannerInRoomCollection.BannerInfo.class);
        goto L3
    L15:
        r101.middleBanner = (BannerInRoomCollection.BannerInfo) vh7.f.a(r100, BannerInRoomCollection.BannerInfo.class);
        goto L3
    L16:
        r101.giftPanelBanner = (BannerInRoomCollection.BannerInfo) vh7.f.a(r100, BannerInRoomCollection.BannerInfo.class);
        goto L3
    L17:
        r101.bottomRightBanner = (BannerInRoomCollection.BannerInfo) vh7.f.a(r100, BannerInRoomCollection.BannerInfo.class);
        goto L3
    L18:
        r101.topRightBanner = (BannerInRoomCollection.BannerInfo) vh7.f.a(r100, BannerInRoomCollection.BannerInfo.class);
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L19:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    @Override // am3.c
    public final BannerInRoomCollection decode(am3.g r100) throws Exception {
        return a(r100);
    }
}

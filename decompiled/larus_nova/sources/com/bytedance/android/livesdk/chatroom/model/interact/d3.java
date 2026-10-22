package com.bytedance.android.livesdk.chatroom.model.interact;

/* JADX INFO: loaded from: classes7.dex */
public final class d3 implements am3.c<MultiLiveCoreInfo> {
    public d3() {
    }

    public static MultiLiveCoreInfo a(am3.g r100) throws Exception {
        MultiLiveCoreInfo r101 = new MultiLiveCoreInfo();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        r101.videoPositionLiveCoreInfo = new VideoPositionLiveCoreInfo(r100);
        goto L3
    L9:
        r101.videoDuoBattleLiveCoreInfo = (VideoDuoBattleLiveCoreInfo) vh7.f.a(r100, VideoDuoBattleLiveCoreInfo.class);
        goto L3
    L10:
        r101.singingChallengeLiveCoreInfo = (SingingChallengeLiveCoreInfo) vh7.f.a(r100, SingingChallengeLiveCoreInfo.class);
        goto L3
    L11:
        r101.multiAnchorLiveCoreInfo = (MultiAnchorLinkmicLiveCoreInfo) vh7.f.a(r100, MultiAnchorLinkmicLiveCoreInfo.class);
        goto L3
    L12:
        r101.ktvLiveCoreInfo = (KTVLiveCoreInfo) vh7.f.a(r100, KTVLiveCoreInfo.class);
        goto L3
    L13:
        r101.videoEqualRoomLiveCoreInfo = new VideoEqualRoomLiveCoreInfo(r100);
        goto L3
    L14:
        r101.scene = r100.i();
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L15:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    @Override // am3.c
    public final MultiLiveCoreInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}

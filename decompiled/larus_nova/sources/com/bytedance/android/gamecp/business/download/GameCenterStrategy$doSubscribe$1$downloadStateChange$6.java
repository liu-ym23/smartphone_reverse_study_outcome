package com.bytedance.android.gamecp.business.download;

import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class GameCenterStrategy$doSubscribe$1$downloadStateChange$6 implements com.bytedance.android.gamecp.base.core.service.depend.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GameCenterStrategy$doSubscribe$1 f52415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ dw.a f52416b;

    @Override // com.bytedance.android.gamecp.base.core.service.depend.b
    public final void onAirCompressFailed() {
        yr.c.a("GameCenterStrategy", "onAirCompressFailed");
        UtilityKotlinExtentionsKt.g(0, false, false, new GameCenterStrategy$doSubscribe$1$downloadStateChange$6$onAirCompressFailed$1(this), 7);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.b
    public final void onAirCompressSuccess(int r100) {
        yr.c.a("GameCenterStrategy", "onAirCompressSuccess checkSumAndChannelInfoErrno:" + r100);
        UtilityKotlinExtentionsKt.g(0, false, false, new GameCenterStrategy$doSubscribe$1$downloadStateChange$6$onAirCompressSuccess$1(this), 7);
    }

    public GameCenterStrategy$doSubscribe$1$downloadStateChange$6(GameCenterStrategy$doSubscribe$1 r100, dw.a r101) {
        this.f52415a = r100;
        this.f52416b = r101;
    }
}

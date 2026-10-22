package com.bytedance.android.gamecp.hybrid_impl.jsb;

import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
public final class a5 implements com.bytedance.android.gamecp.base.core.service.depend.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z4 f57492a;

    @Override // com.bytedance.android.gamecp.base.core.service.depend.r
    public final void onShowEntrance(boolean r100) {
    }

    public a5(z4 r100) {
        this.f57492a = r100;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.r
    public final void onStatusChanged(int r100) {
        OpenGameRankPromotePanelResultModel.a r101 = new OpenGameRankPromotePanelResultModel.a();
        r101.a(Integer.valueOf(r100));
        z4 r102 = this.f57492a;
        OpenGameRankPromotePanelResultModel r103 = new OpenGameRankPromotePanelResultModel();
        r103.a(OpenGameRankPromotePanelResultModel.Code.Success);
        r103.b(r101);
        Unit r104 = Unit.INSTANCE;
        r102.finishWithResult(r103);
    }
}

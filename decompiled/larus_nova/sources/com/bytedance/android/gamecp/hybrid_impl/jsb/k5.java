package com.bytedance.android.gamecp.hybrid_impl.jsb;

import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
public final class k5 implements com.bytedance.android.gamecp.base.core.service.depend.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j5 f57525a;

    @Override // com.bytedance.android.gamecp.base.core.service.depend.e
    public final void onContinue() {
        yr.b.b(4, "RESOURCE_DOWNLOAD_ACTION", "performGameResourceDownloadAction onContinue");
        j5 r100 = this.f57525a;
        GamePerformGameResourceDownloadActionResultModel r101 = new GamePerformGameResourceDownloadActionResultModel();
        r101.a(GamePerformGameResourceDownloadActionResultModel.Code.Success);
        Unit r102 = Unit.INSTANCE;
        r100.finishWithResult(r101);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.e
    public final void onWaitWifi() {
        yr.b.b(4, "RESOURCE_DOWNLOAD_ACTION", "performGameResourceDownloadAction onWaitWifi");
        j5 r100 = this.f57525a;
        GamePerformGameResourceDownloadActionResultModel r101 = new GamePerformGameResourceDownloadActionResultModel();
        r101.a(GamePerformGameResourceDownloadActionResultModel.Code.Failed);
        GamePerformGameResourceDownloadActionResultModel.a r102 = new GamePerformGameResourceDownloadActionResultModel.a();
        r102.a(10002);
        Unit r103 = Unit.INSTANCE;
        r101.b(r102);
        r100.finishWithResult(r101);
    }

    public k5(j5 r100) {
        this.f57525a = r100;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.e
    public final void onError(Integer r100, String r101) {
        yr.b.b(6, "RESOURCE_DOWNLOAD_ACTION", "performGameResourceDownloadAction error =" + r100 + " ，msg =" + r101);
        j5 r102 = this.f57525a;
        GamePerformGameResourceDownloadActionResultModel r103 = new GamePerformGameResourceDownloadActionResultModel();
        r103.a(GamePerformGameResourceDownloadActionResultModel.Code.Failed);
        GamePerformGameResourceDownloadActionResultModel.a r104 = new GamePerformGameResourceDownloadActionResultModel.a();
        r104.a(r100);
        r104.b(r101);
        Unit r105 = Unit.INSTANCE;
        r103.b(r104);
        r102.finishWithResult(r103);
    }
}

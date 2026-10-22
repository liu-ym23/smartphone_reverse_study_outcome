package com.bytedance.android.gamecp.hybrid_impl.jsb;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class z2 implements com.bytedance.android.gamecp.base.core.service.depend.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y2 f57551a;

    @Override // com.bytedance.android.gamecp.base.core.service.depend.f
    public final void onSuccess() {
        y2 r100 = this.f57551a;
        GamePromoteAutoDownloadResultModel r101 = new GamePromoteAutoDownloadResultModel();
        r101.a(GamePromoteAutoDownloadResultModel.Code.Success);
        Unit r102 = Unit.INSTANCE;
        r100.finishWithResult(r101);
    }

    public z2(y2 r100) {
        this.f57551a = r100;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.f
    public final void onFail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorInfo");
        y2 r101 = this.f57551a;
        GamePromoteAutoDownloadResultModel r102 = new GamePromoteAutoDownloadResultModel();
        r102.a(GamePromoteAutoDownloadResultModel.Code.Failed);
        r102.b(r100);
        Unit r103 = Unit.INSTANCE;
        r101.finishWithResult(r102);
    }
}

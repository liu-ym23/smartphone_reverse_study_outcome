package com.bytedance.android.gamecp.hybrid_impl.jsb;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d3 implements com.bytedance.android.gamecp.base.core.service.depend.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b3 f57495a;

    @Override // com.bytedance.android.gamecp.base.core.service.depend.k
    public final void onSuccess() {
        b3 r100 = this.f57495a;
        GamePromoteReserveResultModel r101 = new GamePromoteReserveResultModel();
        r101.a(GamePromoteReserveResultModel.Code.Success);
        Unit r102 = Unit.INSTANCE;
        r100.finishWithResult(r101);
    }

    public d3(b3 r100) {
        this.f57495a = r100;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.k
    public final void onFail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorInfo");
        b3 r101 = this.f57495a;
        GamePromoteReserveResultModel r102 = new GamePromoteReserveResultModel();
        r102.a(GamePromoteReserveResultModel.Code.Failed);
        r102.b(r100);
        Unit r103 = Unit.INSTANCE;
        r101.finishWithResult(r102);
    }
}

package com.bytedance.android.gamecp.hybrid_impl.jsb;

import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
public final class o5 implements qv.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n5 f57528a;

    @Override // qv.a
    public final void onSuccess() {
        n5 r100 = this.f57528a;
        PopGameCPTuringVerifyViewResultModel r101 = new PopGameCPTuringVerifyViewResultModel();
        r101.a(PopGameCPTuringVerifyViewResultModel.Code.Success);
        PopGameCPTuringVerifyViewResultModel.a r102 = new PopGameCPTuringVerifyViewResultModel.a();
        r102.a(Boolean.TRUE);
        Unit r103 = Unit.INSTANCE;
        r101.b(r102);
        r100.finishWithResult(r101);
    }

    public o5(n5 r100) {
        this.f57528a = r100;
    }

    @Override // qv.a
    public final void onFailure(int r100) {
        n5 r101 = this.f57528a;
        PopGameCPTuringVerifyViewResultModel r102 = new PopGameCPTuringVerifyViewResultModel();
        r102.a(PopGameCPTuringVerifyViewResultModel.Code.Success);
        PopGameCPTuringVerifyViewResultModel.a r103 = new PopGameCPTuringVerifyViewResultModel.a();
        r103.a(Boolean.FALSE);
        Unit r104 = Unit.INSTANCE;
        r102.b(r103);
        r101.finishWithResult(r102);
    }
}

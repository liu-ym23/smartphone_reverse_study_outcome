package com.bytedance.android.gamecp.hybrid_impl.jsb;

import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
public final class g2 implements qv.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f2 f57504a;

    public g2(f2 r100) {
        this.f57504a = r100;
    }

    @Override // qv.d
    public final void onFail(int r100, String r101) {
        f2 r102 = this.f57504a;
        OpenHeliumGameResultModel r103 = new OpenHeliumGameResultModel();
        r103.a(OpenHeliumGameResultModel.Code.Failed);
        Unit r104 = Unit.INSTANCE;
        r102.finishWithResult(r103);
    }
}

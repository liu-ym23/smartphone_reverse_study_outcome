package com.bytedance.android.gamecp.hybrid_impl.jsb;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c3 implements com.bytedance.android.gamecp.base.core.service.depend.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b3 f57494a;

    public c3(b3 r100) {
        this.f57494a = r100;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.q
    public final void onFail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorInfo");
        b3 r101 = this.f57494a;
        GamePromoteReserveResultModel r102 = new GamePromoteReserveResultModel();
        r102.a(GamePromoteReserveResultModel.Code.Failed);
        r102.b(r100);
        Unit r103 = Unit.INSTANCE;
        r101.finishWithResult(r102);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.q
    public final void onSuccess(JSONObject r100) {
        b3 r101 = this.f57494a;
        GamePromoteReserveResultModel r102 = new GamePromoteReserveResultModel();
        r102.a(GamePromoteReserveResultModel.Code.Success);
        if (r100 == null) goto L5;
        r102.c(r100.optString("reserve_response"));
    L5:
        Unit r103 = Unit.INSTANCE;
        r101.finishWithResult(r102);
    }
}

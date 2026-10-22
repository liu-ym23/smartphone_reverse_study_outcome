package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.GetUserInfoResultModel;
import com.bytedance.android.annie.service.userinfo.IUserInfoService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "getUserInfo")
public final class g0 extends e7.j<JsonObject, GetUserInfoResultModel> {
    public g0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IUserInfoService r102 = (IUserInfoService) Annie.getService(IUserInfoService.class, r101.a());
        GetUserInfoResultModel r103 = new GetUserInfoResultModel();
        r102.hasLogin();
        r103.a(GetUserInfoResultModel.Code.Success);
        r103.c("Call Success !");
        r103.b(Boolean.FALSE);
        r103.d(new GetUserInfoResultModel.a());
        finishWithResult(r103);
    }
}

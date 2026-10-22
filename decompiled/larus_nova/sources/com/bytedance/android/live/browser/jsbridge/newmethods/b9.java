package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.CloseShelfManagementPageResultModel;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "closeShelfManagementPage")
public final class b9 extends w20.z<JsonObject, CloseShelfManagementPageResultModel> {
    public b9() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ((IOpenPlatformAnchorService) jc1.k.n(IOpenPlatformAnchorService.class)).closeShelfManagementPage();
        finishWithSuccess();
    }
}

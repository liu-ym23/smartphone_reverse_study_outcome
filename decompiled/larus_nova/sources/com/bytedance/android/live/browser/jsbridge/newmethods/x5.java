package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.AddAnchorResultModel;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "addAnchor")
public final class x5 extends w20.d<JsonObject, AddAnchorResultModel> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public x5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        JsonObject r102 = (JsonObject) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostBusiness r103 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        if (r103 == null) goto L5;
        r103.addAnchorToPublishVideo(r102);
    L5:
        finishWithSuccess();
    }
}

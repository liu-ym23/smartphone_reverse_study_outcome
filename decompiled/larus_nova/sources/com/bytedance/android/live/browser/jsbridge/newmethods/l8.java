package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.OpenAnchorInputDialogResultModel;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openAnchorInputDialog")
public final class l8 extends w20.d4<w20.bc, OpenAnchorInputDialogResultModel> {
    public l8() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.bc r102 = (w20.bc) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        LivePluginSPIManager.f85856e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new k8(r101, r102)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("OpenAnchorInputDialogMethod");
    }
}

package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.OpenExplainCardSettingDialogResultModel;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openExplainCardSettingDialog")
public final class g9 extends w20.i4<w20.hc, OpenExplainCardSettingDialogResultModel> {
    public g9() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.hc r102 = (w20.hc) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ((IOpenPlatformAnchorService) jc1.k.n(IOpenPlatformAnchorService.class)).openExplainCardSettingDialog(com.bytedance.android.livesdk.utils.s2.a(GsonProtectorUtils.toJson(GsonHelper.get(), r102)));
        finishWithSuccess();
    }
}

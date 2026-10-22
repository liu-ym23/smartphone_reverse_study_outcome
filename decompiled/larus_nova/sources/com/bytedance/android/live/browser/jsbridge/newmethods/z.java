package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.AdLiveUpdateFeedResultModel;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "adLiveUpdateFeed")
public final class z extends w20.b<w20.h7, AdLiveUpdateFeedResultModel> {
    public z() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((w20.h7) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (jc1.k.f(ILiveDouPlusService.class) == null) goto L6;
        ((ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class)).notifyAdxCoinTaskCompleted();
        return;
    }
}

package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "preDownloadGame")
public final class v9 extends p<w9, PreDownloadGameResultModel> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public v9() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w9 r102 = (w9) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        if (NetworkUtils.isWifi(r101.getContext()) == false) goto L9;
        IHostLiveOpenPlatform r104 = TTLiveSDK.hostService().hostOpenPlatform();
        if (r104 == null) goto L10;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r104.preloadMiniGame(r103);
    L10:
        finishWithSuccess();
        return;
    L9:
        finishWithFailure(new Throwable("This device is not in wifi environment!"));
        goto L10
    }
}

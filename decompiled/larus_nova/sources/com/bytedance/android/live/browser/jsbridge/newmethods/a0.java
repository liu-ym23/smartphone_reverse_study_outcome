package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.AdTrackInfoFromCidResultModel;
import com.bytedance.android.livesdkapi.business.ILiveAdMiddleWareService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "adTrackInfoFromCid")
public final class a0 extends w20.c<w20.i7, AdTrackInfoFromCidResultModel> {
    public a0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.i7 r102 = (w20.i7) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        finishWithFailure(new IllegalArgumentException("cid is empty"));
        return;
    L11:
        JSONObject r105 = ((ILiveAdMiddleWareService) jc1.k.n(ILiveAdMiddleWareService.class)).getAdInfo(r103);
        if (r105 != null) goto L19;
        finishWithFailure(new IllegalArgumentException("adInfo is empty"));
        return;
    L19:
        AdTrackInfoFromCidResultModel r106 = new AdTrackInfoFromCidResultModel();     // Catch: Exception -> L16
        r106.a(r105.optString("cid"));     // Catch: Exception -> L16
        r106.c(r105.optString("log_extra"));     // Catch: Exception -> L16
        r106.b(AdTrackInfoFromCidResultModel.Code.Success);     // Catch: Exception -> L16
        Unit r107 = Unit.INSTANCE;     // Catch: Exception -> L16
        finishWithResult(r106);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        finishWithFailure(e);
        return;
    L5:
        if (r103.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}

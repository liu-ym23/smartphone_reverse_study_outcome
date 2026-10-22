package com.bytedance.android.livesdk.jsbridge.methods;

import android.view.View;
import com.bytedance.android.live.browser.GsonMap;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "localLife.setBcmParam")
public final class b4 extends m<w1, LocalLifeSetBcmParamResultModel> {
    public b4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w1 r102 = (w1) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostLiveLocalLife r103 = (IHostLiveLocalLife) jc1.k.f(IHostLiveLocalLife.class);
        if (r103 != null) goto L5;
        finishWithFailure();
        return;
    L5:
        View r104 = r101.f249269d;
        if (r104 != null) goto L8;
        finishWithFailure();
        return;
    L8:
        JsonObject r105 = r102.a();
        if (r105 != null) goto L11;
        finishWithFailure();
        return;
    L11:
        GsonMap r106 = UtilsKt.i(r105);
        LinkedHashMap r107 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r108 = r106.entrySet().iterator();
    L13:
        if (r108.hasNext() == false) goto L20;
        Map.Entry<String, Object> r109 = r108.next();
        if (r109.getValue() == null) goto L17;
        boolean r110 = true;
    L18:
        if (r110 == false) goto L13;
        r107.put(r109.getKey(), r109.getValue());
        goto L13
    L17:
        r110 = false;
        goto L18
    L20:
        r103.setBcmParams(r104, r107);
        LocalLifeSetBcmParamResultModel r111 = new LocalLifeSetBcmParamResultModel();
        r111.a(LocalLifeSetBcmParamResultModel.Code.Success);
        Unit r112 = Unit.INSTANCE;
        finishWithResult(r111);
    }
}

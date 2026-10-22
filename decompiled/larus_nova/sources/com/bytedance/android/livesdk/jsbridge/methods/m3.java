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
@XBridgeMethod(biz = "webcast", name = "localLife.registerBtmPage")
public final class m3 extends l<v1, LocalLifeRegisterBtmPageResultModel> {
    public m3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        v1 r102 = (v1) r100;
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
        String r105 = r102.b();
        if (r105 != null) goto L11;
        finishWithFailure();
        return;
    L11:
        JsonObject r106 = r102.a();
        if (r106 == null) goto L22;
        GsonMap r107 = UtilsKt.i(r106);
        LinkedHashMap r108 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r109 = r107.entrySet().iterator();
    L15:
        if (r109.hasNext() == false) goto L24;
        Map.Entry<String, Object> r110 = r109.next();
        if (r110.getValue() == null) goto L19;
        boolean r111 = true;
    L20:
        if (r111 == false) goto L15;
        r108.put(r110.getKey(), r110.getValue());
        goto L15
    L19:
        r111 = false;
    L24:
        if (r103.registerBtmPage(r104, r105, r102.c(), r108) == false) goto L26;
        LocalLifeRegisterBtmPageResultModel r112 = new LocalLifeRegisterBtmPageResultModel();
        r112.a(LocalLifeRegisterBtmPageResultModel.Code.Success);
        Unit r113 = Unit.INSTANCE;
        finishWithResult(r112);
        return;
    L26:
        finishWithFailure(new Throwable("register btm page failed"));
        return;
    L22:
        r108 = null;
        goto L24
    }
}

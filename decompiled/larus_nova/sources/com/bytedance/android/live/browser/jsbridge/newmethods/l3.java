package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.os.Bundle;
import com.bytedance.android.live.browser.jsbridge.base.FormatOpenSchemaResultModel;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "format.openSchema")
public final class l3 extends w20.q0<w20.v8, FormatOpenSchemaResultModel> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public l3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.v8 r102 = (w20.v8) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L13;
        ((IMiddlewareHostAction) jc1.k.n(IMiddlewareHostAction.class)).handleSchema(r101.getContext(), r102.a(), new Bundle());
        return;
    L13:
        return;
    L5:
        if (r103.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}

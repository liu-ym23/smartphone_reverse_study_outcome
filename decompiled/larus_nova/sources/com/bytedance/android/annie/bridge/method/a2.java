package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.ScanCodeResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "scanCode")
public final class a2 extends e7.y<e7.u0, ScanCodeResultModel> {
    public a2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        e7.u0 r102 = (e7.u0) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Boolean r103 = r102.a();
        if (r103 == null) goto L5;
        r103.booleanValue();
    L5:
        ((u9.c) Annie.getService$default(u9.c.class, null, 2, null)).e1(r101.getContext(), new z1(this));
    }
}

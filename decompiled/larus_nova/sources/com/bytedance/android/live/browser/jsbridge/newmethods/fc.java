package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "setMemoryByContainer")
public final class fc extends w<gc, SetMemoryByContainerResultModel> {
    public fc() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        gc r102 = (gc) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r102.a() != null) goto L5;
        finishWithFailure();
        return;
    L5:
        List<String> r103 = r102.a();
        if (r103 == null) goto L15;
        Map<String, String> r104 = com.bytedance.android.livesdk.utils.s0.f159156a;
        List<String> r105 = r102.b();
        Intrinsics.checkNotNullParameter(r103, "keys");
        int r106 = r103.size();
        int r107 = 0;
    L8:
        if (r107 >= r106) goto L15;
        Map<String, String> r108 = com.bytedance.android.livesdk.utils.s0.f159156a;
        Object r109 = ListProtector.get(r103, r107);
        if (r105 == null) goto L13;
        String r110 = (String) ListProtector.get(r105, r107);
        if (r110 == null) goto L13;
    L14:
        ((HashMap) r108).put(r109, r110);
        r107 = r107 + 1;
    L13:
        r110 = "";
    L15:
        finishWithSuccess();
    }
}

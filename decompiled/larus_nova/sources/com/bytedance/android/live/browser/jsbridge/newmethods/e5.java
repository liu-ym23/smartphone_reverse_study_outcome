package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetPersonCardInfoResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getPersonCardInfo")
public final class e5 extends w20.q1<w20.q9, GetPersonCardInfoResultModel> {
    public e5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.q9 r102 = (w20.q9) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        ns0.a r105 = ns0.c.a();
        if (r105 == null) goto L8;
        ps0.c r106 = r105.getPersonCardData(r103);
    L9:
        if (r106 == null) goto L12;
        String r107 = r106.f530411b;
        if (r107 == null) goto L12;
    L13:
        if (r106 == null) goto L18;
        String r108 = r106.f530410a;
        if (r108 == null) goto L18;
        r104 = r108;
    L18:
        GetPersonCardInfoResultModel r109 = new GetPersonCardInfoResultModel();
        GetPersonCardInfoResultModel.a r110 = new GetPersonCardInfoResultModel.a();
        r110.b(r104);
        r110.a(r107);
        Unit r111 = Unit.INSTANCE;
        r109.a(r110);
        finishWithResult(r109);
        return;
    L12:
        r107 = "";
        goto L13
    L8:
        r106 = null;
        goto L9
    }
}

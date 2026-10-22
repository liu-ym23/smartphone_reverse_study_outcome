package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.CreateVipEmojiByTemplateResultModel;
import com.bytedance.android.live.profit.api.IProfitServiceExternal;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "createVipEmojiByTemplate")
public final class k2 extends w20.j0<w20.p8, CreateVipEmojiByTemplateResultModel> {
    public k2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.p8 r102 = (w20.p8) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IProfitServiceExternal r103 = (IProfitServiceExternal) jc1.k.n(IProfitServiceExternal.class);
        String r104 = r102.b();
        String r105 = "";
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        String r106 = r102.a();
        if (r106 == null) goto L9;
        r105 = r106;
    L9:
        r103.showVipEmojiTemplatePanel(r104, r105);
        CreateVipEmojiByTemplateResultModel r107 = new CreateVipEmojiByTemplateResultModel();
        r107.a(CreateVipEmojiByTemplateResultModel.Code.Success);
        r107.b("success");
        Unit r108 = Unit.INSTANCE;
        finishWithResult(r107);
    }
}

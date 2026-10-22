package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.ChangePpeEnvResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "changePpeEnv")
public final class q1 extends w20.o<w20.x7, ChangePpeEnvResultModel> {
    public q1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.x7 r102 = (w20.x7) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        ChangePpeEnvResultModel r105 = new ChangePpeEnvResultModel();
        r105.a(ChangePpeEnvResultModel.Code.Failed);
        Unit r106 = Unit.INSTANCE;
        finishWithResult(r105);
        return;
    L11:
        la0.a r107 = (la0.a) jc1.k.f(la0.a.class);
        if (r107 == null) goto L14;
        r107.G4();
    L14:
        ChangePpeEnvResultModel r108 = new ChangePpeEnvResultModel();
        r108.a(ChangePpeEnvResultModel.Code.Success);
        Unit r109 = Unit.INSTANCE;
        finishWithResult(r108);
        return;
    L5:
        if (r103.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}

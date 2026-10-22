package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.text.TextUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "popGameCPTuringVerifyView")
public final class n5 extends t0<p5, PopGameCPTuringVerifyViewResultModel> {

    public static final class a {
    }

    static {
    }

    public n5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        p5 r102 = (p5) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        if (TextUtils.isEmpty(r103) == false) goto L5;
        PopGameCPTuringVerifyViewResultModel r104 = new PopGameCPTuringVerifyViewResultModel();
        r104.a(PopGameCPTuringVerifyViewResultModel.Code.Success);
        PopGameCPTuringVerifyViewResultModel.a r105 = new PopGameCPTuringVerifyViewResultModel.a();
        r105.a(Boolean.FALSE);
        Unit r106 = Unit.INSTANCE;
        r104.b(r105);
        finishWithResult(r104);
        return;
    L5:
        com.bytedance.android.gamecp.host_api.a.b().getHostVerifyService().Z1(com.bytedance.android.gamecp.common.utils.s1.a(r101.getContext()), r103, new o5(this));
    }
}

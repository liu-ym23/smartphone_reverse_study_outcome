package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "getPushOpenType")
public final class b1 extends f<JsonObject, GetPushOpenTypeResultModel> {
    public b1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostBusiness r102 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        if (r102 == null) goto L5;
        Pair<Integer, String> r103 = r102.getLivePushOpenType();
    L6:
        if (r103 == null) goto L14;
        Integer r104 = r103.getFirst();
        if (r104 != null) goto L11;
    L13:
        GetPushOpenTypeResultModel r105 = new GetPushOpenTypeResultModel();
        r105.a(GetPushOpenTypeResultModel.Code.Success);
        GetPushOpenTypeResultModel.a r106 = new GetPushOpenTypeResultModel.a();
        r106.a(r103.getFirst());
        Unit r107 = Unit.INSTANCE;
        r105.b(r106);
        finishWithResult(r105);
        return;
    L11:
        if (r104.intValue() != (-1)) goto L13;
    L14:
        finishWithFailure();
        return;
    L5:
        r103 = null;
        goto L6
    }
}

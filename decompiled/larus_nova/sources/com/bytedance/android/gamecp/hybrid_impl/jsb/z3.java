package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "getGameCPReceivedGift")
public final class z3 extends d0<a4, GetGameCPReceivedGiftResultModel> {

    public static final class a {
    }

    static {
    }

    public z3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        a4 r102 = (a4) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("getGameCPReceivedGift", GsonProtectorUtils.toJson(new Gson(), r102));
        if (r102.a() != null) goto L5;
        GetGameCPReceivedGiftResultModel r103 = new GetGameCPReceivedGiftResultModel();
        r103.a(GetGameCPReceivedGiftResultModel.Code.Failed);
        r103.b();
        r103.c("params error");
        Unit r104 = Unit.INSTANCE;
        finishWithResult(r103);
        return;
    L5:
        GetGameCPReceivedGiftResultModel r105 = new GetGameCPReceivedGiftResultModel();
        r105.a(GetGameCPReceivedGiftResultModel.Code.Success);
        r105.b();
        r105.c("giftId null");
        Unit r106 = Unit.INSTANCE;
        finishWithResult(r105);
    }
}

package com.bytedance.android.livesdk.jsbridge.methods;

import android.view.View;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "unRegisterLiveLifeMsgCenter")
public final class q4 extends t<r4, UnRegisterLiveLifeMsgCenterResultModel> {
    public q4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, final CallContext r101) {
        r4 r102 = (r4) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostLiveLocalLife r103 = (IHostLiveLocalLife) jc1.k.n(IHostLiveLocalLife.class);
        String r104 = r102.a();
        JsonObject r105 = r102.b();
        if (r105 == null) goto L9;
        View r106 = r101.f249269d;
        if (r106 == null) goto L7;
        int r107 = r106.hashCode();
    L8:
        r105.addProperty("containerID", String.valueOf(r107));
        Unit r108 = Unit.INSTANCE;
    L10:
        int r109 = r103.unRegisterLiveLifeMsgCenter(r104, r105, new UnRegisterLiveLifeMsgCenterMethod$invoke$result$2(r101));
        UnRegisterLiveLifeMsgCenterResultModel r110 = new UnRegisterLiveLifeMsgCenterResultModel();
        if (r109 != 1) goto L13;
        UnRegisterLiveLifeMsgCenterResultModel.Code r111 = UnRegisterLiveLifeMsgCenterResultModel.Code.Success;
    L14:
        r110.a(r111);
        Unit r112 = Unit.INSTANCE;
        finishWithResult(r110);
        return;
    L13:
        r111 = UnRegisterLiveLifeMsgCenterResultModel.Code.Failed;
        goto L14
    L7:
        r107 = 0;
        goto L8
    L9:
        r105 = null;
        goto L10
    }
}

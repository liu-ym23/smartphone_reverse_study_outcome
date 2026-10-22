package com.bytedance.android.livesdk.jsbridge.methods;

import android.view.View;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "postLiveLifeMsg")
public final class e3 extends p<f3, PostLiveLifeMsgResultModel> {
    public e3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, final CallContext r101) {
        f3 r102 = (f3) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostLiveLocalLife r103 = (IHostLiveLocalLife) jc1.k.n(IHostLiveLocalLife.class);
        String r104 = r102.a();
        JsonObject r105 = r102.b();
        Integer r106 = null;
        if (r105 == null) goto L9;
        View r107 = r101.f249269d;
        if (r107 == null) goto L7;
        int r108 = r107.hashCode();
    L8:
        r105.addProperty("containerID", String.valueOf(r108));
        Unit r109 = Unit.INSTANCE;
    L10:
        JsonObject r110 = r103.postMsg(r104, r105, r102.c(), new PostLiveLifeMsgMethod$invoke$result$2(r101));
        JsonElement r111 = r110.get("status");
        if (r111 == null) goto L13;
        r106 = Integer.valueOf(r111.getAsInt());
    L13:
        PostLiveLifeMsgResultModel r112 = new PostLiveLifeMsgResultModel();
        if (r106 != null) goto L17;
    L19:
        PostLiveLifeMsgResultModel.Code r113 = PostLiveLifeMsgResultModel.Code.Failed;
    L20:
        r112.a(r113);
        PostLiveLifeMsgResultModel.a r114 = new PostLiveLifeMsgResultModel.a();
        r114.a(r110.get("data"));
        Unit r115 = Unit.INSTANCE;
        r112.b(r114);
        finishWithResult(r112);
        return;
    L17:
        if (r106.intValue() != 1) goto L19;
        r113 = PostLiveLifeMsgResultModel.Code.Success;
        goto L20
    L7:
        r108 = 0;
        goto L8
    L9:
        r105 = null;
        goto L10
    }
}

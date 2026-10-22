package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "getLiveLocalLifeRoomInfo")
public final class z0 extends e<JsonObject, GetLiveLocalLifeRoomInfoResultModel> {
    public z0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r101.getContext() instanceof FragmentActivity) == false) goto L18;
        ILiveService r102 = TTLiveService.getLiveService();
        if (r102 == null) goto L13;
        ILiveLocalLifeService r103 = (ILiveLocalLifeService) r102.liveLocalLifeService(ILiveLocalLifeService.class);
        if (r103 == null) goto L13;
        Context r104 = r101.getContext();
        if (r104 == null) goto L12;
        JSONObject r105 = r103.getCurrentRoomInfo((FragmentActivity) r104);
    L14:
        if (r105 != null) goto L16;
        finishWithFailure(new Throwable("context is not FragmentActivity"));
        return;
    L16:
        GetLiveLocalLifeRoomInfoResultModel r106 = new GetLiveLocalLifeRoomInfoResultModel();
        r106.a(GetLiveLocalLifeRoomInfoResultModel.Code.Success);
        GetLiveLocalLifeRoomInfoResultModel.a r107 = new GetLiveLocalLifeRoomInfoResultModel.a();
        r107.a(1);
        r107.b(r105.toString());
        Unit r108 = Unit.INSTANCE;
        r106.b(r107);
        finishWithResult(r106);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L13:
        r105 = null;
        goto L14
    }
}

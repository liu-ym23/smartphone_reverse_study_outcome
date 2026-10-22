package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.event.RoomBannerBarEvent;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "activityNameBar")
public final class r3 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public r3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Logger.i("RoomBannerBarMethod", r102.toString());
        RoomBannerBarEvent r103 = (RoomBannerBarEvent) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r102.toString(), RoomBannerBarEvent.class);
        if (r103 == null) goto L6;
        xs2.b.a().post(r103);
        return;
    }
}

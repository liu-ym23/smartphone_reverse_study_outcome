package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "setRoomInfoBannerSize")
public final class ic extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public ic() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "size");
        Intrinsics.checkNotNullParameter(r101, "p1");
        int r103 = r102.optInt("width");
        int r104 = r102.optInt("height");
        xs2.b.a().post(new com.bytedance.android.livesdk.event.f0(r103, r104));
        return Unit.INSTANCE;
    }
}

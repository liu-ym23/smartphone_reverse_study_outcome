package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livesdk.chatroom.event.TopRightBannerAdjustEvent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "setTopRightBannerWidth")
public final class p4 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public p4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        Integer r103 = Integer.valueOf(r102.optInt("width"));
        if (r103.intValue() < 0) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == true) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L12;
        xs2.b.a().post(new TopRightBannerAdjustEvent(r103.intValue()));
    L12:
        return null;
    L5:
        r104 = false;
        goto L7
    }
}

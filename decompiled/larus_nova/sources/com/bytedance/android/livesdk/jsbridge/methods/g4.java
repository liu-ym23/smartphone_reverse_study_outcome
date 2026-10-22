package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "shakeShortTouch")
public final class g4 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public g4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "callContext");
        xs2.b.a().post(new zg1.v(1, r102.optInt("type"), null));
        return null;
    }
}

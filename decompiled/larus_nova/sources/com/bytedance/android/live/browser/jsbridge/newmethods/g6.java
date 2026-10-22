package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendPokemon")
public final class g6 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public g6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) throws Exception {
        xs2.b r102 = xs2.b.a();
        JSONObjectProtectorUtils.getLong(r100, ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID);
        r102.post(new b30.x());
        return null;
    }
}

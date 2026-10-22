package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "addRedDot")
public final class b0 extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    public static final class a {

        @SerializedName(MapController.ITEM_LAYER_TAG)
        String item;

        @SerializedName("type")
        String type;

        public a() {
        }
    }

    public b0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(a r100, CallContext r101) throws Exception {
        a r102 = r100;
        if (TextUtils.equals(r102.type, NewBroadcastMonitor.STAGE.TOOLBAR) == false) goto L8;
        if (TextUtils.equals(r102.item, PbRequest.SwitchType.GIFT) == false) goto L14;
        xs2.b.a().post(new zg1.g0(1, 1));
        return null;
    L14:
        return null;
    L8:
        if (TextUtils.equals(r102.type, "gift_panel") == true) goto L10;
        return null;
    L10:
        if (TextUtils.equals(r102.item, "prop") == false) goto L17;
        xs2.b.a().post(new zg1.g0(2, 1));
        return null;
    L17:
        return null;
    }
}

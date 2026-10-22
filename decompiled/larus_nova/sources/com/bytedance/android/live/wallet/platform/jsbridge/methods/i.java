package com.bytedance.android.live.wallet.platform.jsbridge.methods;

import android.content.Context;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@XBridgeMethod(biz = "webcast", name = "ttpay")
public final class i extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public i() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r110, CallContext r111) {
        JSONObject r112 = r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r100 = r111.getContext();
        JSONObject r113 = r112.optJSONObject("sdk_info");
        int r101 = r112.optInt("service", -1);
        String r102 = "";
        String r103 = r112.optString("sub_way", "");
        String r104 = r112.optString("ext", SliceInitService.DEFAULT_SWITCH);
        String r105 = r112.optString(AppConstants.BUNDLE_REFERER, "");
        int r114 = v.f91009a;
        v.e("wallet_pay_alog_tag", "start ttpay");
        int r115 = fd1.b.f476458a;
        JSONObject r116 = new JSONObject();
        JSONObject r106 = new JSONObject();
        JSONObject r107 = new JSONObject();
        Intrinsics.checkNotNullParameter("ttpay_method_invoke", "serviceName");
        Intrinsics.checkNotNullParameter(r116, "category");
        Intrinsics.checkNotNullParameter(r106, "metric");
        Intrinsics.checkNotNullParameter(r107, "extraLog");
        LiveSlardarMonitor.monitorEvent("ttpay_method_invoke", r116, r106, r107);
        com.bytedance.android.live.wallet.d r117 = com.bytedance.android.live.recharge.core.f.b(RechargeServices.b());
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put("channel", ((wh6.a) vh6.c.b(wh6.a.class)).getChannel());
        r108.put(WsConstants.KEY_INSTALL_ID, jta.g.e());
        LinkedHashMap r109 = new LinkedHashMap();
        String r118 = ((dr2.c) vh6.c.b(dr2.c.class)).getSessionId();
        if (r118 == null) goto L6;
        r102 = r118;
    L6:
        r109.put(InteractConst.INTENT_SESSION_ID, r102);
        r117.x0(r100, r108, r109, r113.toString(), r101, r103, r104, r105, String.valueOf(((wh6.a) vh6.c.b(wh6.a.class)).Xe()), new h(this));
    }
}

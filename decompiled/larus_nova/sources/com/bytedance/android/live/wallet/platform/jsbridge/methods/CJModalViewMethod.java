package com.bytedance.android.live.wallet.platform.jsbridge.methods;

import android.content.Context;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@XBridgeMethod(biz = "webcast", name = "CJModalView")
public class CJModalViewMethod extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

    public class a implements zv0.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJModalViewMethod f102751a;

        public a(CJModalViewMethod r100) {
            this.f102751a = r100;
        }

        @Override // zv0.l
        public final void a(zv0.m r100) {
            JSONObject r101 = new JSONObject();
            r101.put("code", 1);     // Catch: JSONException -> L7
            r101.put("status_code", r100.f573678b);     // Catch: JSONException -> L7
            Map<String, String> r102 = r100.f573677a;     // Catch: JSONException -> L7
            if (r102 == null) goto L9;
            JSONObject r103 = new JSONObject(r102.get("pay_info"));     // Catch: JSONException -> L7
            r101.put("amount", r103.optString("amount"));     // Catch: JSONException -> L7
            r101.put("paytype", r103.optString("paytype"));     // Catch: JSONException -> L7
        L9:
            CJModalViewMethod.access$000(this.f102751a, r101);
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
            goto L9
        }

        @Override // zv0.l
        public final void onEvent(String r100, Map<String, String> r101) {
            ed1.a.b(r100, r101);
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public void onTerminate() {
    }

    public CJModalViewMethod() {
    }

    public static /* synthetic */ void access$000(CJModalViewMethod r100, Object r101) {
        r100.finishWithResult(r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(JSONObject r110, CallContext r111) throws Exception {
        JSONObject r100 = JSONObjectProtectorUtils.getJSONObject(r110, "order_info");
        JSONObject r101 = new JSONObject();
        r101.put("default_channel", r110.optString("default_channel"));
        r101.put("channels", r110.optJSONArray("channels"));
        String r102 = r110.optString("nav_bar_color", "#ffffff");
        com.bytedance.android.live.wallet.d r103 = com.bytedance.android.live.recharge.core.f.b(RechargeServices.b());
        Context r104 = r111.getContext();
        String r105 = r110.optString("url");
        int r106 = r110.optInt("style");
        r110.optInt("hide_status_bar");
        r103.w1(r104, r100, r101, r105, r106, r102, new a(this));
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public /* bridge */ /* synthetic */ void invoke(JSONObject r100, CallContext r101) throws Exception {
        invoke2(r100, r101);
    }
}

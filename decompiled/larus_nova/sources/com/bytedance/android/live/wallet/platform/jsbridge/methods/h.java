package com.bytedance.android.live.wallet.platform.jsbridge.methods;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.revenue.common.v;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f102755a;

    public h(i r100) {
        this.f102755a = r100;
    }

    @Override // com.bytedance.android.live.wallet.platform.jsbridge.methods.g
    public final void a(int r100, String r101) {
        int r102 = v.f91009a;
        v.e("wallet_pay_alog_tag", "ttpay onCallBack code: " + r100 + " msg: " + r101);
        JSONObject r103 = new JSONObject();
        r103.put("code", r100);
        r103.put("msg", r101);
        int r104 = fd1.b.f476458a;
        JSONObject r105 = new JSONObject();
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter("ttpay_method_invoke_callback_success", "serviceName");
        Intrinsics.checkNotNullParameter(r105, "category");
        Intrinsics.checkNotNullParameter(r106, "metric");
        Intrinsics.checkNotNullParameter(r103, "extraLog");
        LiveSlardarMonitor.monitorEvent("ttpay_method_invoke_callback_success", r105, r106, r103);
        JSONObject r107 = new JSONObject();
        r107.put("data", r103);
        this.f102755a.finishWithResult(r107);
    }
}

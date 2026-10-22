package com.bytedance.android.live.wallet.platform.jsbridge.methods;

import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.livesdk.utils.r2;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements com.bytedance.android.live.wallet.e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f102756a;

    @Override // com.bytedance.android.live.wallet.e.b
    public final void b(int r100) {
    }

    public k(j r100) {
        this.f102756a = r100;
    }

    @Override // com.bytedance.android.live.wallet.e.b
    public final void a(com.bytedance.android.live.wallet.e.c r100) {
        com.bytedance.android.live.wallet.e.a r101 = r100.f102674e;
        if (r101 == null) goto L5;
        String r102 = r101.f102668e;
    L6:
        String r103 = "";
        if (r2.a(r102) == true) goto L9;
    L23:
        JSONObject r104 = new JSONObject();
        d60.b.a(r104, "pay_code", Integer.valueOf(r100.f102670a));
        String r105 = r100.f102671b;
        if (r105 != null) goto L26;
        r105 = "";
    L26:
        d60.b.a(r104, "pay_msg", r105);
        String r106 = r100.f102672c;
        if (r106 != null) goto L29;
        r106 = "";
    L29:
        d60.b.a(r104, "recharge_order_id", r106);
        com.bytedance.android.live.wallet.e.a r107 = r100.f102674e;
        if (r107 == null) goto L37;
        HashMap<String, String> r108 = r107.f102669f;
        if (r108 == null) goto L37;
        String r109 = r108.get("failure_code");
        if (r109 == null) goto L37;
        r103 = r109;
    L37:
        d60.b.a(r104, "failure_code", r103);
        com.bytedance.android.live.wallet.e.a r110 = r100.f102674e;
        if (r110 == null) goto L42;
        HashMap<String, String> r111 = r110.f102669f;
        if (r111 == null) goto L42;
        d60.b.a(r104, "result_extra", JsonUtil.toJSONString(r111));
    L42:
        this.f102756a.finishWithResult(r104);
        return;
    L9:
        if (r100.f102670a != 6) goto L23;
        com.bytedance.android.live.recharge.platform.service.m r112 = com.bytedance.android.live.recharge.core.f.h(RechargeServices.b());
        com.bytedance.android.live.wallet.e.a r113 = r100.f102674e;
        if (r113 == null) goto L14;
        String r114 = r113.f102668e;
        if (r114 == null) goto L14;
    L15:
        com.bytedance.android.live.wallet.e.a r115 = r100.f102674e;
        if (r115 == null) goto L21;
        String r116 = r115.f102667d;
        if (r116 == null) goto L21;
        r103 = r116;
    L21:
        r112.X0(r114, new JSONObject(r103));
        return;
    L14:
        r114 = "";
        goto L15
    L5:
        r102 = null;
        goto L6
    }
}

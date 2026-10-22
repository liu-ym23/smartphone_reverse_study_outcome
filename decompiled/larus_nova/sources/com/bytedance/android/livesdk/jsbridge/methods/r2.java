package com.bytedance.android.livesdk.jsbridge.methods;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "openLiveLifeGrouponPage")
public final class r2 extends n<s2, OpenLiveLifeGrouponPageResultModel> {
    public r2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        s2 r102 = (s2) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r101.getContext() instanceof FragmentActivity) == false) goto L17;
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("page_source", r102.a());
        r103.put("page_type", r102.b());
        LinkedHashMap r104 = new LinkedHashMap();
        s2.a r105 = r102.c();
        String r106 = null;
        if (r105 == null) goto L7;
        String r107 = r105.a();
    L8:
        r104.put("coupon_ids", r107);
        s2.a r108 = r102.c();
        if (r108 == null) goto L11;
        String r109 = r108.c();
    L12:
        r104.put("from_position", r109);
        s2.a r110 = r102.c();
        if (r110 == null) goto L15;
        r106 = r110.b();
    L15:
        r104.put("extra_request_params", r106);
        Unit r111 = Unit.INSTANCE;
        r103.put("params", r104);
        ((IHostLiveLocalLife) jc1.k.n(IHostLiveLocalLife.class)).openLiveLifeGrouponPage(r103);
        OpenLiveLifeGrouponPageResultModel r112 = new OpenLiveLifeGrouponPageResultModel();
        r112.a(OpenLiveLifeGrouponPageResultModel.Code.Success);
        r112.b("success");
        finishWithResult(r112);
        return;
    L11:
        r109 = null;
        goto L12
    L7:
        r107 = null;
        goto L8
    }
}

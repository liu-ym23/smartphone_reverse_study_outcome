package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.OpenEmojiPanelResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openEmojiPanel")
public final class r8 extends w20.h4<w20.gc, OpenEmojiPanelResultModel> {
    public r8() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.gc r102 = (w20.gc) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r103 = l42.a.f507334u;
        Boolean r104 = Boolean.TRUE;
        r103.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r103, r104);
        b30.k r105 = new b30.k(r102.a(), r102.b(), r102.c());
        xs2.b.a().post(r105);
        if (com.bytedance.android.livesdk.s4.f157858a.getValue().booleanValue() == false) goto L8;
        LinkedHashMap r106 = new LinkedHashMap();
        String r107 = r102.c();
        if (r107 != null) goto L7;
        r107 = "";
    L7:
        r106.put("request_source", r107);
        r106.put("jsb_name", "openEmojiPanel");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_jsb_usage_stat", r106, new Object[0]);
    L8:
        finishWithSuccess();
    }
}

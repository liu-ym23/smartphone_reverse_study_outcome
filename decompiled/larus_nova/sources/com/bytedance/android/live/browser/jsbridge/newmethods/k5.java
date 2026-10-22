package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "hideLiveFloatWindow")
public final class k5 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.browser.webview.fragment.l f63503a;

    public k5(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        this.f63503a = (com.bytedance.android.live.browser.webview.fragment.l) r100.c(com.bytedance.android.live.browser.webview.fragment.l.class);
    }

    public k5(com.bytedance.android.live.browser.webview.fragment.l r100) {
        Intrinsics.checkNotNullParameter(r100, "control");
        this.f63503a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(JSONObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.live.browser.webview.fragment.l r102 = this.f63503a;
        if (r102 == null) goto L5;
        r102.hideLiveFloatWindow();
    L5:
        int r103 = a6.f63292a;
        JSONObject r104 = new JSONObject();
        r104.put("code", 0);
        return r104;
    }
}

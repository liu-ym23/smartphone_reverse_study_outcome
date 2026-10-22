package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "isLiveFloatWindowShow")
public final class t5 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.browser.webview.fragment.l f63676a;

    public t5(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        this.f63676a = (com.bytedance.android.live.browser.webview.fragment.l) r100.c(com.bytedance.android.live.browser.webview.fragment.l.class);
    }

    public t5(com.bytedance.android.live.browser.webview.fragment.l r100) {
        Intrinsics.checkNotNullParameter(r100, "control");
        this.f63676a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(JSONObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = a6.f63292a;
        JSONObject r103 = new JSONObject();
        boolean r104 = false;
        r103.put("code", 0);
        com.bytedance.android.live.browser.webview.fragment.l r105 = this.f63676a;
        if (r105 == null) goto L5;
        r104 = r105.isShowLiveFloatWindow();
    L5:
        r103.put("value", r104);
        return r103;
    }
}

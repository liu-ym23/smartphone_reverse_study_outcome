package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "showLiveFloatWindow")
public final class yc extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.browser.webview.fragment.l f63734a;

    public yc(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        this.f63734a = (com.bytedance.android.live.browser.webview.fragment.l) r100.c(com.bytedance.android.live.browser.webview.fragment.l.class);
    }

    public yc(com.bytedance.android.live.browser.webview.fragment.l r100) {
        Intrinsics.checkNotNullParameter(r100, "control");
        this.f63734a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.live.browser.webview.fragment.l r103 = this.f63734a;
        if (r103 == null) goto L5;
        r103.showLiveFloatWindow(r102);
    L5:
        int r104 = a6.f63292a;
        JSONObject r105 = new JSONObject();
        r105.put("code", 0);
        return r105;
    }
}

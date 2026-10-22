package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.webkit.WebView;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "webviewNavigation")
public final class de extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f63349a;

    public static final class a {
    }

    static {
    }

    public de(WebView r100) {
        this.f63349a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.optString("type");
        int r104 = 0;
        if (r103 == null) goto L25;
        int r105 = r103.hashCode();
        if (r105 == (-892481550)) goto L23;
        if (r105 == (-677145915)) goto L18;
        if (r105 != 3015911) goto L25;
        if (r103.equals("back") == false) goto L25;
        WebView r106 = this.f63349a;
        if (r106 == null) goto L24;
        r106.goBack();
    L24:
        int r107 = 1;
    L26:
        JSONObject r108 = new JSONObject();
        r108.put("code", r107);
        JSONObject r109 = new JSONObject();
        WebView r110 = this.f63349a;
        if (r110 != null) goto L29;
    L31:
        int r111 = 0;
    L32:
        r109.put("canGoBack", r111);
        WebView r112 = this.f63349a;
        if (r112 != null) goto L35;
    L37:
        r109.put("canGoForward", r104);
        r108.put("data", r109);
        return r108;
    L35:
        if (r112.canGoForward() != true) goto L37;
        r104 = 1;
        goto L37
    L29:
        if (r110.canGoBack() != true) goto L31;
        r111 = 1;
        goto L32
    L18:
        if (r103.equals("forward") == false) goto L25;
        WebView r113 = this.f63349a;
        if (r113 == null) goto L24;
        r113.goForward();
        goto L24
    L23:
        if (r103.equals("status") == true) goto L24;
    L25:
        r107 = 0;
        goto L26
    }
}

package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "monitorLynx")
public final class y7 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {

    public static class a extends my2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f63732a;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.newmethods.y7$a$a, reason: collision with other inner class name */
        public class C1043a extends sy2.c {
            public C1043a() {
            }
        }

        public a() {
            if (sy2.e.f543865c == null) goto L5;
        L14:
            sy2.e r100 = sy2.e.f543865c;
            r100.f543866a = "";
            HashMap r101 = (HashMap) sy2.e.f543864b;
            r101.clear();
            r101.put("pv", String.format("tt%s_webview_timing_monitor_pv_service", new Object[]{r100.f543866a}));
            r101.put("overview", String.format("tt%s_webview_timing_monitor_overview_service", new Object[]{r100.f543866a}));
            r101.put("performance", String.format("tt%s_webview_timing_monitor_performance_service", new Object[]{r100.f543866a}));
            r101.put("resource", String.format("tt%s_webview_timing_monitor_resource_service", new Object[]{r100.f543866a}));
            r101.put("error", String.format("tt%s_webview_timing_monitor_error_service", new Object[]{r100.f543866a}));
            r101.put("diff", String.format("tt%s_webview_timing_monitor_diff_service", new Object[]{r100.f543866a}));
            r101.put("custom", String.format("tt%s_webview_timing_monitor_custom_service", new Object[]{r100.f543866a}));
            r101.put("newcustom", String.format("bd%s_hybrid_monitor_custom_service", new Object[]{r100.f543866a}));
            new C1043a();
            String.valueOf(((IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class)).appId());
            return;
        L5:
            monitor-enter(sy2.e.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (sy2.e.f543865c != null) goto L9;
            sy2.e.f543865c = new sy2.e();     // Catch: Throwable -> L11
        L9:
            monitor-exit(sy2.e.class);     // Catch: Throwable -> L11
            goto L14
        }
    }

    public y7() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) throws Exception {
        JSONObject r102 = r100;
        String r103 = r102.optString("url");
        r102.optJSONObject("metrics");
        JSONObject r104 = r102.optJSONObject("extra");
        if (r104 == null) goto L5;
        r104.optString(ReportCardMonitorPlugin.EVENT_NAME);
    L5:
        Object r105 = sy2.d.a();
        if (a.f63732a == null) goto L8;
    L17:
        ((sy2.b) r105).getClass();
        ((sy2.d) sy2.d.a()).getClass();
        if (r103 != null) goto L20;
    L26:
        return null;
    L20:
        if (r103.length() == 0) goto L26;
        URL r106 = new URL(r103);     // Catch: Exception -> L24
        r106.getHost();     // Catch: Exception -> L24
        r106.getPath();     // Catch: Exception -> L24
        throw null;
    L24:
        new String[]{"", ""};
        throw null;
    L8:
        monitor-enter(a.class);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (a.f63732a != null) goto L12;
        a.f63732a = new a();     // Catch: Throwable -> L14
    L12:
        monitor-exit(a.class);     // Catch: Throwable -> L14
        goto L17
    }
}

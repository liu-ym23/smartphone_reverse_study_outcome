package B2;

import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.monitor.logger.MonitorLog;
import com.bytedance.android.monitor.webview.TTLiveWebViewMonitorJsBridge;
import com.bytedance.android.monitor.webview.WebViewMonitorHelper;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.zyql.agentfront.bean.ToolContent;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f186a;
    public final /* synthetic */ String b;
    public final /* synthetic */ TTLiveWebViewMonitorJsBridge c;

    public /* synthetic */ d(TTLiveWebViewMonitorJsBridge tTLiveWebViewMonitorJsBridge, String str, int i) {
        this.f186a = i;
        this.c = tTLiveWebViewMonitorJsBridge;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f186a) {
            case 0:
                try {
                    WebViewMonitorHelper.b.initTime((WebView) this.c.mWebViewRef.get(), this.b);
                    break;
                } catch (Throwable unused) {
                    return;
                }
            default:
                TTLiveWebViewMonitorJsBridge tTLiveWebViewMonitorJsBridge = this.c;
                try {
                    JSONObject jSONObjectL0 = S0.b.l0(this.b);
                    String strOptString = jSONObjectL0.optString("performance", "");
                    String strOptString2 = S0.b.l0(strOptString).optString("serviceType", "");
                    String strOptString3 = jSONObjectL0.optString(ToolContent.TYPE_RESOURCE, "");
                    String strOptString4 = S0.b.l0(strOptString3).optString("serviceType", "");
                    String strOptString5 = jSONObjectL0.optString(BffConstant.Type.Url, "");
                    MonitorLog.d("TTLiveWebViewMonitorJsBridge", "reportPageLatestData : " + strOptString5);
                    WebViewMonitorHelper.b.cover((WebView) tTLiveWebViewMonitorJsBridge.mWebViewRef.get(), strOptString5, strOptString2, strOptString);
                    WebViewMonitorHelper.b.reportDirectly((WebView) tTLiveWebViewMonitorJsBridge.mWebViewRef.get(), strOptString4, strOptString3);
                    String strOptString6 = jSONObjectL0.optString("needReport", "");
                    if (!TextUtils.isEmpty(strOptString6) && strOptString6.equals("true")) {
                        WebViewMonitorHelper.getInstance().reportTruly((WebView) tTLiveWebViewMonitorJsBridge.mWebViewRef.get());
                        break;
                    }
                } catch (Throwable unused2) {
                    return;
                }
                break;
        }
    }
}

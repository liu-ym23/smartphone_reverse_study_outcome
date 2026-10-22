package B2;

import android.webkit.WebView;
import com.bytedance.android.monitor.webview.TTLiveWebViewMonitorJsBridge;
import com.bytedance.android.monitor.webview.WebViewMonitorHelper;
import com.stepos.agentframework.adapter.bff.BffConstant;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f184a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ TTLiveWebViewMonitorJsBridge d;

    public /* synthetic */ b(TTLiveWebViewMonitorJsBridge tTLiveWebViewMonitorJsBridge, String str, String str2, int i) {
        this.f184a = i;
        this.d = tTLiveWebViewMonitorJsBridge;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f184a) {
            case 0:
                String str = this.b;
                try {
                    WebViewMonitorHelper.b.cover((WebView) this.d.mWebViewRef.get(), S0.b.l0(str).optString(BffConstant.Type.Url, ""), this.c, str);
                    break;
                } catch (Throwable unused) {
                    return;
                }
            default:
                try {
                    WebViewMonitorHelper.b.reportDirectly((WebView) this.d.mWebViewRef.get(), this.b, this.c);
                    break;
                } catch (Throwable unused2) {
                    return;
                }
        }
    }
}

package B2;

import android.webkit.WebView;
import com.apm.insight.MonitorCrash;
import com.bytedance.android.monitor.webview.TTLiveWebViewMonitorJsBridge;
import com.bytedance.android.monitor.webview.WebViewMonitorHelper;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f185a = 1;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Serializable e;
    public final /* synthetic */ Object f;

    public c(MonitorCrash monitorCrash, Throwable th, String str, Map map, String str2) {
        this.d = monitorCrash;
        this.e = th;
        this.b = str;
        this.f = map;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f185a) {
            case 0:
                try {
                    WebViewMonitorHelper.getInstance().customReport((WebView) ((TTLiveWebViewMonitorJsBridge) this.f).mWebViewRef.get(), this.b, this.c, (String) this.d, (String) this.e);
                    break;
                } catch (Throwable unused) {
                    return;
                }
            default:
                S0.b.B0((MonitorCrash) this.d, (Throwable) this.e, this.b, (Map) this.f, this.c);
                break;
        }
    }

    public c(TTLiveWebViewMonitorJsBridge tTLiveWebViewMonitorJsBridge, String str, String str2, String str3, String str4) {
        this.f = tTLiveWebViewMonitorJsBridge;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }
}

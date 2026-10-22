package androidx.webkit.internal;

import android.webkit.ServiceWorkerClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class FrameworkServiceWorkerClient extends ServiceWorkerClient {
    private final androidx.webkit.d mImpl;

    public FrameworkServiceWorkerClient(androidx.webkit.d r1) {
        this.mImpl = r1;
    }

    @Override // android.webkit.ServiceWorkerClient
    public WebResourceResponse shouldInterceptRequest(WebResourceRequest r3) {
        WebResourceRequest r4 = (WebResourceRequest) ZeusTransformUtils.wrapperContextForParams(r3, WebResourceRequest.class, "com.obric.aiagent.plugin");
        return this.mImpl.a(r4);
    }
}

package androidx.webkit.internal;

import android.webkit.ServiceWorkerClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.webkit.ServiceWorkerClientCompat;

/* JADX INFO: loaded from: classes17.dex */
public class FrameworkServiceWorkerClient extends ServiceWorkerClient {
    private final ServiceWorkerClientCompat mImpl;

    public FrameworkServiceWorkerClient(ServiceWorkerClientCompat r100) {
        this.mImpl = r100;
    }

    @Override // android.webkit.ServiceWorkerClient
    public WebResourceResponse shouldInterceptRequest(WebResourceRequest r100) {
        return this.mImpl.shouldInterceptRequest(r100);
    }
}

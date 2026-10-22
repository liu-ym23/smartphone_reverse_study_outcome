package androidx.webkit;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;

/* JADX INFO: loaded from: classes17.dex */
public abstract class ServiceWorkerClientCompat {
    public ServiceWorkerClientCompat() {
    }

    public abstract WebResourceResponse shouldInterceptRequest(WebResourceRequest r100);
}

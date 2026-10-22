package androidx.webkit;

import android.webkit.WebResourceRequest;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.ApiHelperForN;
import androidx.webkit.internal.WebResourceRequestAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;

/* JADX INFO: loaded from: classes17.dex */
public class WebResourceRequestCompat {
    private WebResourceRequestCompat() {
    }

    private static WebResourceRequestAdapter getAdapter(WebResourceRequest r100) {
        return WebViewGlueCommunicator.getCompatConverter().convertWebResourceRequest(r100);
    }

    public static boolean isRedirect(WebResourceRequest r100) {
        ApiFeature.N r101 = WebViewFeatureInternal.WEB_RESOURCE_REQUEST_IS_REDIRECT;
        if (r101.isSupportedByFramework() == false) goto L7;
        return ApiHelperForN.isRedirect(r100);
    L7:
        if (r101.isSupportedByWebView() == false) goto L11;
        return getAdapter(r100).isRedirect();
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}

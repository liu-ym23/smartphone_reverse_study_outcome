package androidx.webkit;

import android.app.PendingIntent;
import android.os.Build;
import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.internal.n;
import androidx.webkit.internal.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebViewClientBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public class WebViewClientCompat extends WebViewClient implements WebViewClientBoundaryInterface {
    private static final String[] sSupportedFeatures = null;

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public void onPageCommitVisible(WebView r1, String r2) {
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public void onReceivedHttpError(WebView r1, WebResourceRequest r2, WebResourceResponse r3) {
        WebResourceRequest r0 = (WebResourceRequest) ZeusTransformUtils.wrapperContextForParams(r2, WebResourceRequest.class, "com.obric.aiagent.plugin");
    }

    @Override // org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public boolean onWebAuthnIntent(WebView r1, PendingIntent r2, InvocationHandler r3) {
        InvocationHandler r0 = (InvocationHandler) ZeusTransformUtils.wrapperContextForParams(r3, InvocationHandler.class, "com.obric.aiagent.plugin");
        return false;
    }

    public WebViewClientCompat() {
    }

    static {
        sSupportedFeatures = new String[]{"VISUAL_STATE_CALLBACK", "RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_HTTP_ERROR", "SHOULD_OVERRIDE_WITH_REDIRECTS", "SAFE_BROWSING_HIT"};
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public final String[] getSupportedFeatures() {
        return sSupportedFeatures;
    }

    @Override // org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public final void onReceivedError(WebView r3, WebResourceRequest r4, InvocationHandler r5) {
        onReceivedError(r3, (WebResourceRequest) ZeusTransformUtils.wrapperContextForParams(r4, WebResourceRequest.class, "com.obric.aiagent.plugin"), new n((InvocationHandler) ZeusTransformUtils.wrapperContextForParams(r5, InvocationHandler.class, "com.obric.aiagent.plugin")));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r3, WebResourceRequest r4, WebResourceError r5) {
        WebResourceRequest r6 = (WebResourceRequest) ZeusTransformUtils.wrapperContextForParams(r4, WebResourceRequest.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        onReceivedError(r3, r6, new n(r5));
    }

    public void onReceivedError(WebView r3, WebResourceRequest r4, h r5) {
        WebResourceRequest r6 = (WebResourceRequest) ZeusTransformUtils.wrapperContextForParams(r4, WebResourceRequest.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        return;
    L6:
        if (k.a("WEB_RESOURCE_ERROR_GET_CODE") == true) goto L8;
        return;
    L8:
        if (k.a("WEB_RESOURCE_ERROR_GET_DESCRIPTION") == true) goto L11;
        return;
    L11:
        if (androidx.webkit.internal.b.a(r6) == false) goto L15;
        onReceivedError(r3, r5.a(), r5.b().toString(), androidx.webkit.internal.b.b(r6).toString());
        return;
    }

    @Override // org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public final void onSafeBrowsingHit(WebView r3, WebResourceRequest r4, int r5, InvocationHandler r6) {
        onSafeBrowsingHit(r3, (WebResourceRequest) ZeusTransformUtils.wrapperContextForParams(r4, WebResourceRequest.class, "com.obric.aiagent.plugin"), r5, new androidx.webkit.internal.k((InvocationHandler) ZeusTransformUtils.wrapperContextForParams(r6, InvocationHandler.class, "com.obric.aiagent.plugin")));
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView r3, WebResourceRequest r4, int r5, SafeBrowsingResponse r6) {
        onSafeBrowsingHit(r3, (WebResourceRequest) ZeusTransformUtils.wrapperContextForParams(r4, WebResourceRequest.class, "com.obric.aiagent.plugin"), r5, new androidx.webkit.internal.k(r6));
    }

    public void onSafeBrowsingHit(WebView r1, WebResourceRequest r2, int r3, c r4) {
        WebResourceRequest r0 = (WebResourceRequest) ZeusTransformUtils.wrapperContextForParams(r2, WebResourceRequest.class, "com.obric.aiagent.plugin");
        if (k.a("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL") == false) goto L7;
        r4.a(true);
        return;
    L7:
        throw p.a();
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public boolean shouldOverrideUrlLoading(WebView r3, WebResourceRequest r4) {
        WebResourceRequest r5 = (WebResourceRequest) ZeusTransformUtils.wrapperContextForParams(r4, WebResourceRequest.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 21) goto L7;
        return false;
    L7:
        return shouldOverrideUrlLoading(r3, androidx.webkit.internal.b.b(r5).toString());
    }
}

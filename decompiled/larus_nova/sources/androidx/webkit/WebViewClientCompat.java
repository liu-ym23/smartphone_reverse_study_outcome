package androidx.webkit;

import android.app.PendingIntent;
import android.os.Build;
import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.internal.ApiHelperForLollipop;
import androidx.webkit.internal.SafeBrowsingResponseImpl;
import androidx.webkit.internal.WebResourceErrorImpl;
import androidx.webkit.internal.WebViewFeatureInternal;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebViewClientBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class WebViewClientCompat extends WebViewClient implements WebViewClientBoundaryInterface {
    private static final String[] sSupportedFeatures = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SafeBrowsingThreat {
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public void onPageCommitVisible(WebView r100, String r101) {
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
    }

    @Override // org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public boolean onWebAuthnIntent(WebView r100, PendingIntent r101, InvocationHandler r102) {
        return false;
    }

    static {
        sSupportedFeatures = new String[]{WebViewFeature.VISUAL_STATE_CALLBACK, WebViewFeature.RECEIVE_WEB_RESOURCE_ERROR, WebViewFeature.RECEIVE_HTTP_ERROR, WebViewFeature.SHOULD_OVERRIDE_WITH_REDIRECTS, WebViewFeature.SAFE_BROWSING_HIT};
    }

    public WebViewClientCompat() {
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public final String[] getSupportedFeatures() {
        return sSupportedFeatures;
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        return shouldOverrideUrlLoading(r100, ApiHelperForLollipop.getUrl(r101).toString());
    }

    public void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceErrorCompat r102) {
        if (WebViewFeature.isFeatureSupported(WebViewFeature.WEB_RESOURCE_ERROR_GET_CODE) == true) goto L5;
        return;
    L5:
        if (WebViewFeature.isFeatureSupported(WebViewFeature.WEB_RESOURCE_ERROR_GET_DESCRIPTION) == true) goto L8;
        return;
    L8:
        if (ApiHelperForLollipop.isForMainFrame(r101) == false) goto L12;
        onReceivedError(r100, r102.getErrorCode(), r102.getDescription().toString(), ApiHelperForLollipop.getUrl(r101).toString());
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        onReceivedError(r100, r101, new WebResourceErrorImpl(r102));
    }

    @Override // org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public final void onReceivedError(WebView r100, WebResourceRequest r101, InvocationHandler r102) {
        onReceivedError(r100, r101, new WebResourceErrorImpl(r102));
    }

    public void onSafeBrowsingHit(WebView r100, WebResourceRequest r101, int r102, SafeBrowsingResponseCompat r103) {
        if (WebViewFeature.isFeatureSupported(WebViewFeature.SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL) == false) goto L7;
        r103.showInterstitial(true);
        return;
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView r100, WebResourceRequest r101, int r102, SafeBrowsingResponse r103) {
        onSafeBrowsingHit(r100, r101, r102, new SafeBrowsingResponseImpl(r103));
    }

    @Override // org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public final void onSafeBrowsingHit(WebView r100, WebResourceRequest r101, int r102, InvocationHandler r103) {
        onSafeBrowsingHit(r100, r101, r102, new SafeBrowsingResponseImpl(r103));
    }
}

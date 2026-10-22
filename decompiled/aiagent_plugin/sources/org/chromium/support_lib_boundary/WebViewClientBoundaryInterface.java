package org.chromium.support_lib_boundary;

import android.app.PendingIntent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;

/* JADX INFO: loaded from: classes5.dex */
public interface WebViewClientBoundaryInterface extends FeatureFlagHolderBoundaryInterface {
    void onPageCommitVisible(WebView r1, String r2);

    void onReceivedError(WebView r1, WebResourceRequest r2, InvocationHandler r3);

    void onReceivedHttpError(WebView r1, WebResourceRequest r2, WebResourceResponse r3);

    void onSafeBrowsingHit(WebView r1, WebResourceRequest r2, int r3, InvocationHandler r4);

    boolean onWebAuthnIntent(WebView r1, PendingIntent r2, InvocationHandler r3);

    boolean shouldOverrideUrlLoading(WebView r1, WebResourceRequest r2);
}

package b36;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ies.bullet.service.base.YieldError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class q extends WebViewClient {
    public q() {
    }

    public boolean a(WebView r100, l r101) {
        throw new YieldError("An operation is not implemented");
    }

    public WebResourceResponse b(WebView r100, k r101) {
        throw new YieldError("An operation is not implemented");
    }

    public boolean c(WebView r100, k r101) {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        if (r101 == null) goto L4;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        l r102 = new l(r101);
    L6:
        return a(r100, r102);
    L4:
        r102 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        if (r101 == null) goto L4;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        k r102 = new k(r101);
    L6:
        return b(r100, r102);
    L4:
        r102 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        if (r101 == null) goto L4;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        k r102 = new k(r101);
    L6:
        return c(r100, r102);
    L4:
        r102 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        if (r101 == null) goto L5;
        Intrinsics.checkNotNullParameter(r101, "<this>");
    L5:
        if (r102 == null) goto L8;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        if (r101 == null) goto L5;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return;
    }
}

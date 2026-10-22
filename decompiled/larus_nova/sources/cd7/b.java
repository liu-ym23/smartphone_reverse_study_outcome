package cd7;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebViewClient f23409a;

    public b(WebViewClient r100) {
        this.f23409a = r100;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView r100, String r101) {
        WebViewClient r102 = this.f23409a;
        if (r102 == null) goto L5;
        r102.onLoadResource(r100, r101);
        return;
    L5:
        super.onLoadResource(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r100, String r101) {
        WebViewClient r102 = this.f23409a;
        if (r102 != null) goto L5;
    L8:
        super.onPageCommitVisible(r100, r101);
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        r102.onPageCommitVisible(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        WebViewClient r102 = this.f23409a;
        if (r102 == null) goto L5;
        r102.onPageFinished(r100, r101);
        return;
    L5:
        super.onPageFinished(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView r100, ClientCertRequest r101) {
        WebViewClient r102 = this.f23409a;
        if (r102 == null) goto L6;
        r102.onReceivedClientCertRequest(r100, r101);
        return;
    L6:
        super.onReceivedClientCertRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        WebViewClient r102 = this.f23409a;
        if (r102 == null) goto L9;
        if (Build.VERSION.SDK_INT < 26) goto L9;
        return r102.onRenderProcessGone(r100, r101);
    L9:
        return super.onRenderProcessGone(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView r100, KeyEvent r101) {
        WebViewClient r102 = this.f23409a;
        if (r102 == null) goto L5;
        r102.onUnhandledKeyEvent(r100, r101);
        return;
    L5:
        super.onUnhandledKeyEvent(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
        WebViewClient r102 = this.f23409a;
        if (r102 == null) goto L8;
        WebResourceResponse r103 = r102.shouldInterceptRequest(r100, r101);
        if (r103 == null) goto L8;
        return r103;
    L8:
        return super.shouldInterceptRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView r100, KeyEvent r101) {
        WebViewClient r102 = this.f23409a;
        if (r102 == null) goto L6;
        return r102.shouldOverrideKeyEvent(r100, r101);
    L6:
        return super.shouldOverrideKeyEvent(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        String r102 = yc7.b.f567209a;
        yc7.b.b(yc7.b.a(r100), r101, null);
        int r103 = zc7.a.f571273a;
        if (zc7.b.f571274a == false) goto L9;
        Iterator r104 = ((ArrayList) zc7.b.f571275b).iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ((zc7.c) r104.next()).a();
    L9:
        WebViewClient r105 = this.f23409a;
        if (r105 == null) goto L12;
        boolean r106 = r105.shouldOverrideUrlLoading(r100, r101);
    L13:
        if (r106 == true) goto L15;
        return false;
    L15:
        return true;
    L12:
        r106 = super.shouldOverrideUrlLoading(r100, r101);
        goto L13
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        WebViewClient r102 = this.f23409a;
        if (r102 == null) goto L7;
        return r102.shouldInterceptRequest(r100, r101);
    L7:
        return super.shouldInterceptRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        if (r100 == null) goto L8;
        String r102 = yc7.b.f567209a;
        c r103 = yc7.b.a(r100);
        if (r101 == null) goto L6;
        Uri r104 = r101.getUrl();
    L7:
        yc7.b.b(r103, String.valueOf(r104), null);
        goto L8
    L6:
        r104 = null;
    L8:
        WebViewClient r105 = this.f23409a;
        if (r105 == null) goto L13;
        return r105.shouldOverrideUrlLoading(r100, r101);
    L13:
        return super.shouldOverrideUrlLoading(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView r100, String r101, boolean r102) {
        WebViewClient r103 = this.f23409a;
        if (r103 == null) goto L5;
        r103.doUpdateVisitedHistory(r100, r101, r102);
        return;
    L5:
        super.doUpdateVisitedHistory(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(WebView r100, Message r101, Message r102) {
        WebViewClient r103 = this.f23409a;
        if (r103 == null) goto L5;
        r103.onFormResubmission(r100, r101, r102);
        return;
    L5:
        super.onFormResubmission(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        int r103 = zc7.a.f571273a;
        if (zc7.b.f571274a == false) goto L8;
        Iterator r104 = ((ArrayList) zc7.b.f571275b).iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        ((zc7.c) r104.next()).onPageStarted(r101);
    L8:
        WebViewClient r105 = this.f23409a;
        if (r105 == null) goto L11;
        r105.onPageStarted(r100, r101, r102);
        return;
    L11:
        super.onPageStarted(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        WebViewClient r103 = this.f23409a;
        if (r103 != null) goto L5;
    L8:
        super.onReceivedError(r100, r101, r102);
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        r103.onReceivedError(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        WebViewClient r103 = this.f23409a;
        if (r103 != null) goto L5;
    L8:
        super.onReceivedHttpError(r100, r101, r102);
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        r103.onReceivedHttpError(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
        WebViewClient r103 = this.f23409a;
        if (r103 == null) goto L5;
        r103.onReceivedSslError(r100, r101, r102);
        return;
    L5:
        super.onReceivedSslError(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(WebView r100, float r101, float r102) {
        WebViewClient r103 = this.f23409a;
        if (r103 == null) goto L5;
        r103.onScaleChanged(r100, r101, r102);
        return;
    L5:
        super.onScaleChanged(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView r100, Message r101, Message r102) {
        WebViewClient r103 = this.f23409a;
        if (r103 == null) goto L5;
        r103.onTooManyRedirects(r100, r101, r102);
        return;
    L5:
        super.onTooManyRedirects(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, int r101, String r102, String r103) {
        WebViewClient r104 = this.f23409a;
        if (r104 == null) goto L5;
        r104.onReceivedError(r100, r101, r102, r103);
        return;
    L5:
        super.onReceivedError(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView r100, HttpAuthHandler r101, String r102, String r103) {
        WebViewClient r104 = this.f23409a;
        if (r104 == null) goto L5;
        r104.onReceivedHttpAuthRequest(r100, r101, r102, r103);
        return;
    L5:
        super.onReceivedHttpAuthRequest(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView r100, String r101, String r102, String r103) {
        WebViewClient r104 = this.f23409a;
        if (r104 == null) goto L5;
        r104.onReceivedLoginRequest(r100, r101, r102, r103);
        return;
    L5:
        super.onReceivedLoginRequest(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView r100, WebResourceRequest r101, int r102, SafeBrowsingResponse r103) {
        WebViewClient r104 = this.f23409a;
        if (r104 == null) goto L5;
        r104.onSafeBrowsingHit(r100, r101, r102, r103);
        return;
    L5:
        super.onSafeBrowsingHit(r100, r101, r102, r103);
    }
}

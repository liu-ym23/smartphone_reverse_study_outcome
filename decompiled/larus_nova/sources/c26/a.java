package c26;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import b36.q;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebViewClient f22199a;

    public a(WebViewClient r100) {
        Intrinsics.checkNotNullParameter(r100, "webViewClient");
        this.f22199a = r100;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView r100, String r101) {
        this.f22199a.onLoadResource(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r100, String r101) {
        this.f22199a.onPageCommitVisible(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        this.f22199a.onPageFinished(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView r100, ClientCertRequest r101) {
        this.f22199a.onReceivedClientCertRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView r100, KeyEvent r101) {
        this.f22199a.onUnhandledKeyEvent(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView r100, KeyEvent r101) {
        return this.f22199a.shouldOverrideKeyEvent(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView r100, String r101, boolean r102) {
        this.f22199a.doUpdateVisitedHistory(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(WebView r100, Message r101, Message r102) {
        this.f22199a.onFormResubmission(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        this.f22199a.onPageStarted(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
        this.f22199a.onReceivedSslError(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(WebView r100, float r101, float r102) {
        this.f22199a.onScaleChanged(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public final void onTooManyRedirects(WebView r100, Message r101, Message r102) {
        this.f22199a.onTooManyRedirects(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public final void onReceivedError(WebView r100, int r101, String r102, String r103) {
        this.f22199a.onReceivedError(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView r100, HttpAuthHandler r101, String r102, String r103) {
        this.f22199a.onReceivedHttpAuthRequest(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView r100, String r101, String r102, String r103) {
        this.f22199a.onReceivedLoginRequest(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView r100, WebResourceRequest r101, int r102, SafeBrowsingResponse r103) {
        this.f22199a.onSafeBrowsingHit(r100, r101, r102, r103);
    }
}

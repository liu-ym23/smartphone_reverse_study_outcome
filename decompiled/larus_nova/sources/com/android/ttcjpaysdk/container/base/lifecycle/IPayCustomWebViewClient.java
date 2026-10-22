package com.android.ttcjpaysdk.container.base.lifecycle;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J.\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u0015\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000f\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u001c\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/container/base/lifecycle/IPayCustomWebViewClient;", "", "onLoadResource", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "errorCode", "", "description", "failingUrl", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "shouldInterceptRequest", "shouldOverrideUrlLoading", "", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IPayCustomWebViewClient {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onLoadResource(IPayCustomWebViewClient r100, WebView r101, String r102) {
        }

        public static void onPageFinished(IPayCustomWebViewClient r100, WebView r101, String r102) {
        }

        public static void onPageStarted(IPayCustomWebViewClient r100, WebView r101, String r102, Bitmap r103) {
        }

        public static void onReceivedError(IPayCustomWebViewClient r100, WebView r101, int r102, String r103, String r104) {
        }

        public static void onReceivedError(IPayCustomWebViewClient r100, WebView r101, WebResourceRequest r102, WebResourceError r103) {
        }

        public static void onReceivedHttpError(IPayCustomWebViewClient r100, WebView r101, WebResourceRequest r102, WebResourceResponse r103) {
        }

        public static void onReceivedSslError(IPayCustomWebViewClient r100, WebView r101, SslErrorHandler r102, SslError r103) {
        }

        public static void shouldInterceptRequest(IPayCustomWebViewClient r100, WebView r101, WebResourceRequest r102) {
        }

        public static void shouldInterceptRequest(IPayCustomWebViewClient r100, WebView r101, String r102) {
        }

        public static boolean shouldOverrideUrlLoading(IPayCustomWebViewClient r100, WebView r101, String r102) {
            return false;
        }
    }

    void onLoadResource(WebView r100, String r101);

    void onPageFinished(WebView r100, String r101);

    void onPageStarted(WebView r100, String r101, Bitmap r102);

    void onReceivedError(WebView r100, int r101, String r102, String r103);

    void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102);

    void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102);

    void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102);

    void shouldInterceptRequest(WebView r100, WebResourceRequest r101);

    void shouldInterceptRequest(WebView r100, String r101);

    boolean shouldOverrideUrlLoading(WebView r100, String r101);
}

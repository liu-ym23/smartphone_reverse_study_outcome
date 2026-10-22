package com.android.ttcjpaysdk.container.base.lifecycle;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.caijing.sdk.infra.base.api.hybridkit.ContainerErrorType;
import com.bytedance.caijing.sdk.infra.base.api.hybridkit.ContainerType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J(\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0016J \u0010\u0005\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/container/base/lifecycle/ILifecycleEngine;", "Lcom/android/ttcjpaysdk/container/base/lifecycle/IPayCustomWebViewClient;", "onClearContext", "", LiveCommonConstants.REASON_ON_DEDTROY, "onLoadFailed", "type", "Lcom/bytedance/caijing/sdk/infra/base/api/hybridkit/ContainerErrorType;", "ext", "", "", "", "url", "errorCode", "", "errorMsg", "onLoadFinish", "onLoadStart", "onPostKitCreated", "view", "onPreKitCreate", "onRuntimeReady", "containerType", "Lcom/bytedance/caijing/sdk/infra/base/api/hybridkit/ContainerType;", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ILifecycleEngine extends IPayCustomWebViewClient {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onClearContext(ILifecycleEngine r100) {
        }

        public static void onDestroy(ILifecycleEngine r100) {
        }

        public static void onLoadFailed(ILifecycleEngine r100, ContainerErrorType r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r101, "type");
        }

        public static void onLoadFailed(ILifecycleEngine r100, String r101, int r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "url");
            Intrinsics.checkNotNullParameter(r103, "errorMsg");
        }

        public static void onLoadFinish(ILifecycleEngine r100) {
        }

        public static void onLoadStart(ILifecycleEngine r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "url");
        }

        public static void onPostKitCreated(ILifecycleEngine r100, Object r101) {
            Intrinsics.checkNotNullParameter(r101, "view");
        }

        public static void onPreKitCreate(ILifecycleEngine r100) {
        }

        public static void onRuntimeReady(ILifecycleEngine r100, ContainerType r101) {
            Intrinsics.checkNotNullParameter(r101, "containerType");
        }

        public static void onLoadResource(ILifecycleEngine r100, WebView r101, String r102) {
            IPayCustomWebViewClient.DefaultImpls.onLoadResource(r100, r101, r102);
        }

        public static void onPageFinished(ILifecycleEngine r100, WebView r101, String r102) {
            IPayCustomWebViewClient.DefaultImpls.onPageFinished(r100, r101, r102);
        }

        public static void shouldInterceptRequest(ILifecycleEngine r100, WebView r101, WebResourceRequest r102) {
            IPayCustomWebViewClient.DefaultImpls.shouldInterceptRequest(r100, r101, r102);
        }

        public static boolean shouldOverrideUrlLoading(ILifecycleEngine r100, WebView r101, String r102) {
            return IPayCustomWebViewClient.DefaultImpls.shouldOverrideUrlLoading(r100, r101, r102);
        }

        public static void shouldInterceptRequest(ILifecycleEngine r100, WebView r101, String r102) {
            IPayCustomWebViewClient.DefaultImpls.shouldInterceptRequest(r100, r101, r102);
        }

        public static void onPageStarted(ILifecycleEngine r100, WebView r101, String r102, Bitmap r103) {
            IPayCustomWebViewClient.DefaultImpls.onPageStarted(r100, r101, r102, r103);
        }

        public static void onReceivedError(ILifecycleEngine r100, WebView r101, WebResourceRequest r102, WebResourceError r103) {
            IPayCustomWebViewClient.DefaultImpls.onReceivedError(r100, r101, r102, r103);
        }

        public static void onReceivedHttpError(ILifecycleEngine r100, WebView r101, WebResourceRequest r102, WebResourceResponse r103) {
            IPayCustomWebViewClient.DefaultImpls.onReceivedHttpError(r100, r101, r102, r103);
        }

        public static void onReceivedSslError(ILifecycleEngine r100, WebView r101, SslErrorHandler r102, SslError r103) {
            IPayCustomWebViewClient.DefaultImpls.onReceivedSslError(r100, r101, r102, r103);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onLoadFailed$default(ILifecycleEngine r100, ContainerErrorType r101, Map r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.onLoadFailed(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLoadFailed");
        }

        public static void onReceivedError(ILifecycleEngine r100, WebView r101, int r102, String r103, String r104) {
            IPayCustomWebViewClient.DefaultImpls.onReceivedError(r100, r101, r102, r103, r104);
        }
    }

    void onClearContext();

    void onDestroy();

    void onLoadFailed(ContainerErrorType r100, Map<String, ? extends Object> r101);

    void onLoadFailed(String r100, int r101, String r102);

    void onLoadFinish();

    void onLoadStart(String r100);

    void onPostKitCreated(Object r100);

    void onPreKitCreate();

    void onRuntimeReady(ContainerType r100);
}

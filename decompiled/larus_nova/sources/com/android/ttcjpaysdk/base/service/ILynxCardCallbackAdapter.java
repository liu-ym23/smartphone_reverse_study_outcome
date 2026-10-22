package com.android.ttcjpaysdk.base.service;

import android.view.View;
import ed4.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ILynxCardCallbackAdapter;", "Lcom/android/ttcjpaysdk/base/service/ICJExternalLynxCardCallback;", "onFallback", "", "onFirstScreen", "lynxView", "Landroid/view/View;", "onLoadFailed", "errMsg", "", "onLoadSuccess", "onPageStart", "url", "onReceivedError", "info", "onRuntimeReady", "onTemplateLoaded", "isOffline", "", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ILynxCardCallbackAdapter extends ICJExternalLynxCardCallback {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onFallback(ILynxCardCallbackAdapter r100) {
        }

        public static void onFirstScreen(ILynxCardCallbackAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "lynxView");
        }

        public static void onLoadFailed(ILynxCardCallbackAdapter r100, View r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "lynxView");
        }

        public static void onLoadSuccess(ILynxCardCallbackAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "lynxView");
        }

        public static void onPageStart(ILynxCardCallbackAdapter r100, View r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "lynxView");
        }

        public static void onReceivedError(ILynxCardCallbackAdapter r100, View r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "lynxView");
        }

        public static void onRuntimeReady(ILynxCardCallbackAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "lynxView");
        }

        public static void onTemplateLoaded(ILynxCardCallbackAdapter r100, View r101, boolean r102) {
        }

        public static void onReceivedLynxError(ILynxCardCallbackAdapter r100, View r101, e r102) {
            Intrinsics.checkNotNullParameter(r101, "lynxView");
            ICJExternalLynxCardCallback.DefaultImpls.onReceivedLynxError(r100, r101, r102);
        }
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJExternalLynxCardCallback
    void onFallback();

    @Override // com.android.ttcjpaysdk.base.service.ICJExternalLynxCardCallback
    void onFirstScreen(View r100);

    @Override // com.android.ttcjpaysdk.base.service.ICJExternalLynxCardCallback
    void onLoadFailed(View r100, String r101);

    @Override // com.android.ttcjpaysdk.base.service.ICJExternalLynxCardCallback
    void onLoadSuccess(View r100);

    @Override // com.android.ttcjpaysdk.base.service.ICJExternalLynxCardCallback
    void onPageStart(View r100, String r101);

    @Override // com.android.ttcjpaysdk.base.service.ICJExternalLynxCardCallback
    void onReceivedError(View r100, String r101);

    @Override // com.android.ttcjpaysdk.base.service.ICJExternalLynxCardCallback
    void onRuntimeReady(View r100);

    @Override // com.android.ttcjpaysdk.base.service.ICJExternalLynxCardCallback
    void onTemplateLoaded(View r100, boolean r101);
}

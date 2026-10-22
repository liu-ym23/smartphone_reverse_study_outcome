package com.android.ttcjpaysdk.base.service;

import android.view.View;
import ed4.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\tH&J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\tH&J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJExternalLynxCardCallback;", "", "", "onFallback", "Landroid/view/View;", "lynxView", "onFirstScreen", "onLoadSuccess", "onRuntimeReady", "", "url", "onPageStart", "info", "onReceivedError", "errMsg", "onLoadFailed", "", "isOffline", "onTemplateLoaded", "Led4/e;", "cjLynxError", "onReceivedLynxError", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface ICJExternalLynxCardCallback {

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onReceivedLynxError(ICJExternalLynxCardCallback r100, View r101, e r102) {
            Intrinsics.checkNotNullParameter(r101, "lynxView");
        }
    }

    void onFallback();

    void onFirstScreen(View r100);

    void onLoadFailed(View r100, String r101);

    void onLoadSuccess(View r100);

    void onPageStart(View r100, String r101);

    void onReceivedError(View r100, String r101);

    void onReceivedLynxError(View r100, e r101);

    void onRuntimeReady(View r100);

    void onTemplateLoaded(View r100, boolean r101);
}

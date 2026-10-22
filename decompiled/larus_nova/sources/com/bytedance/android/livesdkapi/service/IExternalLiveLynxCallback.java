package com.bytedance.android.livesdkapi.service;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\tH&J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IExternalLiveLynxCallback;", "", "onFallback", "", "onFirstScreen", "lynxView", "Landroid/view/View;", "onLoadFailed", "errMsg", "", "onLoadSuccess", "onPageStart", "url", "onReceivedError", "info", "onRuntimeReady", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalLiveLynxCallback {
    void onFallback();

    void onFirstScreen(View r100);

    void onLoadFailed(View r100, String r101);

    void onLoadSuccess(View r100);

    void onPageStart(View r100, String r101);

    void onReceivedError(View r100, String r101);

    void onRuntimeReady(View r100);
}

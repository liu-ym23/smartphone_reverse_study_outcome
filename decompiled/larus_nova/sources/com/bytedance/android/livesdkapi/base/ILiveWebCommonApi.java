package com.bytedance.android.livesdkapi.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/base/ILiveWebCommonApi;", "", "setOnPageLoadListener", "", "listener", "Lcom/bytedance/android/livesdkapi/base/ILiveWebCommonApi$OnPageLoadListener;", "OnPageLoadListener", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveWebCommonApi {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/base/ILiveWebCommonApi$OnPageLoadListener;", "", "onPageFinished", "", "onPageReceivedError", "errorCode", "", "onPageStarted", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface OnPageLoadListener {
        void onPageFinished();

        void onPageReceivedError(int r100);

        void onPageStarted();
    }

    void setOnPageLoadListener(OnPageLoadListener r100);
}

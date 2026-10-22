package com.bytedance.android.livesdkapi.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IMiddlewareCommodityNoFilterUploadCallBack;", "", "onFail", "", "onSuccess", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareCommodityNoFilterUploadCallBack {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onFail(IMiddlewareCommodityNoFilterUploadCallBack r100) {
        }

        public static void onSuccess(IMiddlewareCommodityNoFilterUploadCallBack r100) {
        }
    }

    void onFail();

    void onSuccess();
}

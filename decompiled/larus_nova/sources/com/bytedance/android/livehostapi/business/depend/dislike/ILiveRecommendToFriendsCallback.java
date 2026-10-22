package com.bytedance.android.livehostapi.business.depend.dislike;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/dislike/ILiveRecommendToFriendsCallback;", "", "onFailed", "", "onLiveRecommendSuccess", "status", "", "onSuccess", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveRecommendToFriendsCallback {
    void onFailed();

    void onLiveRecommendSuccess(long r100);

    void onSuccess(long r100);
}

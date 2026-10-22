package com.bytedance.android.livehostapi.business.depend.dislike;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/dislike/ILiveRecommendToFriendsDialogListener;", "", "onConfirm", "", "onDismiss", SendEventContainerMethodParamModel.EventKinds.onShow, "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveRecommendToFriendsDialogListener {
    void onConfirm();

    void onDismiss();

    void onShow();
}

package com.bytedance.android.livesdkapi.urge;

import androidx.fragment.app.DialogFragment;
import com.alipay.sdk.m.x.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u0014J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\rH&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\rH&J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\rH&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/urge/IUrgeGiftPanel;", "", "asFragment", "Landroidx/fragment/app/DialogFragment;", "setCallback", "", "callback", "Lcom/bytedance/android/livesdkapi/urge/IUrgeGiftPanel$ICallback;", "setIsRewarded", "isRewarded", "", d.f25925o, "title", "", "setToUserId", "toUserId", "setToUserSecId", "toUserSecId", "setUserId", "userId", "ICallback", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IUrgeGiftPanel {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/urge/IUrgeGiftPanel$ICallback;", "", "onCancel", "", "onInsufficientFund", "onSuccess", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ICallback {
        void onCancel();

        void onInsufficientFund();

        void onSuccess();
    }

    DialogFragment asFragment();

    void setCallback(ICallback r100);

    void setIsRewarded(boolean r100);

    void setTitle(String r100);

    void setToUserId(String r100);

    void setToUserSecId(String r100);

    void setUserId(String r100);
}

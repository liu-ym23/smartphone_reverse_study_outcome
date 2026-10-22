package com.android.ttcjpaysdk.base.service;

import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.base.ui.data.CJPayNoPwdPayInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\nJ\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayBindCardPayConfirmService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "showPayConfirm", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "confirmInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayNoPwdPayInfo;", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBindCardPayConfirmService$ConfirmCallback;", "ConfirmCallback", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayBindCardPayConfirmService extends ICJPayService {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayBindCardPayConfirmService$ConfirmCallback;", "", "onClose", "", "onConfirm", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ConfirmCallback {
        void onClose();

        void onConfirm();
    }

    boolean showPayConfirm(FragmentActivity r100, CJPayNoPwdPayInfo r101, ConfirmCallback r102);
}

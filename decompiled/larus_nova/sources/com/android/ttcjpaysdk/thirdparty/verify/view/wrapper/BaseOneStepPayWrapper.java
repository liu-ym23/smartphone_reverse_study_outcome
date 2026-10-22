package com.android.ttcjpaysdk.thirdparty.verify.view.wrapper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.service.bean.VoucherDialogExpandResult;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/wrapper/BaseOneStepPayWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "contentView", "Landroid/view/View;", "resId", "", "(Landroid/view/View;I)V", "actionListener", "Lcom/android/ttcjpaysdk/thirdparty/verify/view/wrapper/BaseOneStepPayWrapper$OneStepActionListener;", "getActionListener", "()Lcom/android/ttcjpaysdk/thirdparty/verify/view/wrapper/BaseOneStepPayWrapper$OneStepActionListener;", "setActionListener", "(Lcom/android/ttcjpaysdk/thirdparty/verify/view/wrapper/BaseOneStepPayWrapper$OneStepActionListener;)V", "getDiscountInfo", "", "getNoticeLabelForLog", "getPanelView", "getTopLeftBubbleTitleForLog", "hideVerifyDescRegion", "", LiveCommonConstants.REASON_ON_DEDTROY, "setOneStepActionListener", "callback", "showConfirmLoading", "enable", "", "updateWithExpandedData", "expandedResult", "Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult;", "OneStepActionListener", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseOneStepPayWrapper extends BaseWrapper {
    private OneStepActionListener actionListener;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/wrapper/BaseOneStepPayWrapper$OneStepActionListener;", "", "onClose", "", "onConfirm", "onPayWithDowngrade", "payType", "", "onSelectNotShowAgain", "isChecked", "", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OneStepActionListener {
        void onClose();

        void onConfirm();

        void onPayWithDowngrade(String r100);

        void onSelectNotShowAgain(boolean r100);
    }

    public String getDiscountInfo() {
        return "";
    }

    public String getNoticeLabelForLog() {
        return "";
    }

    public View getPanelView() {
        return null;
    }

    public String getTopLeftBubbleTitleForLog() {
        return "";
    }

    public void hideVerifyDescRegion() {
    }

    public void onDestroy() {
    }

    public abstract void showConfirmLoading(boolean r100);

    public void updateWithExpandedData(VoucherDialogExpandResult r100) {
        Intrinsics.checkNotNullParameter(r100, "expandedResult");
    }

    public final OneStepActionListener getActionListener() {
        return this.actionListener;
    }

    public final void setActionListener(OneStepActionListener r100) {
        this.actionListener = r100;
    }

    public final void setOneStepActionListener(OneStepActionListener r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.actionListener = r100;
    }

    public BaseOneStepPayWrapper(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        super(r100);
        LayoutInflater.from(getContext()).inflate(r101, (ViewGroup) r100);
    }
}

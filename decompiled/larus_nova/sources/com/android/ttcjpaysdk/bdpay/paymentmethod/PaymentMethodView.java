package com.android.ttcjpaysdk.bdpay.paymentmethod;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.bdpay.paymentmethod.bean.MethodPayTypeInfo;
import com.android.ttcjpaysdk.bdpay.paymentmethod.bean.SetFirstPayTypeResponse;
import com.android.ttcjpaysdk.thirdparty.data.FrontPreTradeInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/paymentmethod/PaymentMethodView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onFailed", "", "errorCode", "", "errorMessage", "onSetFirstPayTypeFailed", "onSetFirstPayTypeSuccess", "result", "Lcom/android/ttcjpaysdk/bdpay/paymentmethod/bean/SetFirstPayTypeResponse;", "info", "Lcom/android/ttcjpaysdk/bdpay/paymentmethod/bean/MethodPayTypeInfo;", "isRefreshHomePage", "", "onSuccess", "Lcom/android/ttcjpaysdk/thirdparty/data/FrontPreTradeInfo;", "bdpay-paymentmethod_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PaymentMethodView extends MvpView {
    void onFailed(String r100, String r101);

    void onSetFirstPayTypeFailed(String r100, String r101);

    void onSetFirstPayTypeSuccess(SetFirstPayTypeResponse r100, MethodPayTypeInfo r101, boolean r102);

    void onSuccess(FrontPreTradeInfo r100);
}

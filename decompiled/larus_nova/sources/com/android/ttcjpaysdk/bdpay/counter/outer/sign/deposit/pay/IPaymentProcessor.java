package com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.pay;

import com.android.ttcjpaysdk.base.service.bean.OuterPayInnerBean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/pay/IPaymentProcessor;", "", "startPayment", "", "paymentParams", "Lcom/android/ttcjpaysdk/base/service/bean/OuterPayInnerBean;", "callback", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/pay/IPaymentCallback;", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IPaymentProcessor {
    void startPayment(OuterPayInnerBean r100, IPaymentCallback r101);
}

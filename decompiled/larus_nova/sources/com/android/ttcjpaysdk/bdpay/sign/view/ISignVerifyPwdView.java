package com.android.ttcjpaysdk.bdpay.sign.view;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.bdpay.sign.bean.BindBytePayBean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/sign/view/ISignVerifyPwdView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onVerifyFail", "", "errorCode", "", "errorMessage", "onVerifySuccess", "result", "Lcom/android/ttcjpaysdk/bdpay/sign/bean/BindBytePayBean;", "bdpay-sign_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ISignVerifyPwdView extends MvpView {
    void onVerifyFail(String r100, String r101);

    void onVerifySuccess(BindBytePayBean r100);
}

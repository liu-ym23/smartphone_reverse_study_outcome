package com.android.ttcjpaysdk.bdpay.outer.authorize.view;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.bdpay.outer.authorize.bean.CJPayBindAuthorizeBean;
import com.android.ttcjpaysdk.bdpay.outer.authorize.bean.CJPayBindBytePayBean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/outer/authorize/view/CJPayOuterAuthorizeView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onBindBytePayFail", "", "errorCode", "", "errorMessage", "onBindBytePaySuccess", "result", "Lcom/android/ttcjpaysdk/bdpay/outer/authorize/bean/CJPayBindBytePayBean;", "onFetchAuthProtocolFail", "onFetchAuthProtocolSuccess", "Lcom/android/ttcjpaysdk/bdpay/outer/authorize/bean/CJPayBindAuthorizeBean;", "bdpay-outer-authorize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJPayOuterAuthorizeView extends MvpView {
    void onBindBytePayFail(String r100, String r101);

    void onBindBytePaySuccess(CJPayBindBytePayBean r100);

    void onFetchAuthProtocolFail(String r100, String r101);

    void onFetchAuthProtocolSuccess(CJPayBindAuthorizeBean r100);
}

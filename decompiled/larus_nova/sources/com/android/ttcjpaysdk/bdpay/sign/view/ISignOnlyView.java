package com.android.ttcjpaysdk.bdpay.sign.view;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.bdpay.sign.bean.BindBytePayBean;
import com.android.ttcjpaysdk.bdpay.sign.bean.QuerySignInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/sign/view/ISignOnlyView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onBindPayFail", "", "errorCode", "", "errorMessage", "onBindPaySuccess", "result", "Lcom/android/ttcjpaysdk/bdpay/sign/bean/BindBytePayBean;", "onFetchSignInfoFail", "onFetchSignInfoSuccess", "Lcom/android/ttcjpaysdk/bdpay/sign/bean/QuerySignInfo;", "bdpay-sign_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ISignOnlyView extends MvpView {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onBindPayFail(ISignOnlyView r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "errorCode");
            Intrinsics.checkNotNullParameter(r102, "errorMessage");
        }

        public static void onBindPaySuccess(ISignOnlyView r100, BindBytePayBean r101) {
            Intrinsics.checkNotNullParameter(r101, "result");
        }
    }

    void onBindPayFail(String r100, String r101);

    void onBindPaySuccess(BindBytePayBean r100);

    void onFetchSignInfoFail(String r100, String r101);

    void onFetchSignInfoSuccess(QuerySignInfo r100);
}

package com.android.ttcjpaysdk.bdpay.sign.view;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.bdpay.sign.bean.QueryMemberPayResponse;
import com.android.ttcjpaysdk.bdpay.sign.bean.SetFirstPayResponse;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/sign/view/ISetPayOrderView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onFetchPayListFail", "", "errorCode", "", "errorMessage", "onFetchPayListSuccess", "bean", "Lcom/android/ttcjpaysdk/bdpay/sign/bean/QueryMemberPayResponse;", "onSetOrderSuccess", "Lcom/android/ttcjpaysdk/bdpay/sign/bean/SetFirstPayResponse;", "bdpay-sign_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ISetPayOrderView extends MvpView {
    void onFetchPayListFail(String r100, String r101);

    void onFetchPayListSuccess(QueryMemberPayResponse r100);

    void onSetOrderSuccess(SetFirstPayResponse r100);
}

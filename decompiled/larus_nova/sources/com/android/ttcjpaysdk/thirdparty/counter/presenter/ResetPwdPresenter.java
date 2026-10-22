package com.android.ttcjpaysdk.thirdparty.counter.presenter;

import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.thirdparty.counter.BdPayCounterContract;
import com.android.ttcjpaysdk.thirdparty.counter.model.ResetPwdModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/counter/presenter/ResetPwdPresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/thirdparty/counter/model/ResetPwdModel;", "Lcom/android/ttcjpaysdk/thirdparty/counter/BdPayCounterContract$ResultResetPwdView;", "()V", "queryResetPwdInfo", "", "bdpay-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ResetPwdPresenter extends BasePresenter<ResetPwdModel, BdPayCounterContract.ResultResetPwdView> {
    public final void queryResetPwdInfo() {
        ResetPwdModel r100 = getModel();
        if (r100 == null) goto L6;
        r100.request(new AnonymousClass1(this));
        return;
    }

    public ResetPwdPresenter() {
    }
}

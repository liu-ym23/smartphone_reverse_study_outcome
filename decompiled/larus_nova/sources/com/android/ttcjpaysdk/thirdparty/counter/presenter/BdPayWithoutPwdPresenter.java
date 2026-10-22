package com.android.ttcjpaysdk.thirdparty.counter.presenter;

import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.thirdparty.counter.BdPayCounterContract;
import com.android.ttcjpaysdk.thirdparty.counter.model.BdPayCounterModel;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;

/* JADX INFO: loaded from: classes39.dex */
public class BdPayWithoutPwdPresenter extends BasePresenter<BdPayCounterModel, BdPayCounterContract.ResultPasswordFreeView> {
    public BdPayWithoutPwdPresenter() {
    }

    public void amountUpgrade(CJPayCheckoutCounterResponseBean r100, CJPayHostInfo r101) {
        getModel().amountUpgrade(r100, r101, new AnonymousClass2(this));
    }

    public void openPayWithoutPwd(CJPayCheckoutCounterResponseBean r100, CJPayHostInfo r101) {
        getModel().openPayWithoutPwd(r100, r101, new AnonymousClass1(this));
    }
}

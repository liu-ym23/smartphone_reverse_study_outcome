package com.android.ttcjpaysdk.thirdparty.counter.presenter;

import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.thirdparty.counter.BdPayCounterContract;
import com.android.ttcjpaysdk.thirdparty.counter.model.BdPayCounterModel;

/* JADX INFO: loaded from: classes39.dex */
public class FastPayPaySignPresenter extends BasePresenter<BdPayCounterModel, BdPayCounterContract.FastPaySignView> {
    public void fastPaySigin() {
        getModel().fastPaySign(new AnonymousClass1(this));
    }

    public FastPayPaySignPresenter() {
    }
}

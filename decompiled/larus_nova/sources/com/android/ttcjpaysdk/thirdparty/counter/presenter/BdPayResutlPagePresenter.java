package com.android.ttcjpaysdk.thirdparty.counter.presenter;

import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.thirdparty.counter.BdPayCounterContract;
import com.android.ttcjpaysdk.thirdparty.counter.model.BdPayCounterModel;
import java.util.HashMap;

/* JADX INFO: loaded from: classes39.dex */
public class BdPayResutlPagePresenter extends BasePresenter<BdPayCounterModel, BdPayCounterContract.ResultPageBuyAgainInfoView> {
    public BdPayResutlPagePresenter() {
    }

    public void queryPromotionAfterPayInfo(HashMap<String, String> r100) {
        getModel().queryPromotionAfterPayInfo(r100, new AnonymousClass1(this));
    }
}

package com.android.ttcjpaysdk.thirdparty.front.counter.directbank.view;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.base.ui.data.CJPayTradeQueryByVerifyBean;

/* JADX INFO: loaded from: classes39.dex */
public interface DirectBankView extends MvpView {
    void onTradeQueryByVerifyFaceFail(String r100, String r101);

    void onTradeQueryByVerifyFaceSuccess(CJPayTradeQueryByVerifyBean r100);
}

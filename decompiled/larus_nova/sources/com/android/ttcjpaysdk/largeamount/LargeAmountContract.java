package com.android.ttcjpaysdk.largeamount;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.base.ui.data.CJPayTradeQueryByVerifyBean;
import com.android.ttcjpaysdk.largeamount.bean.CJPayFetchVerifyBean;

/* JADX INFO: loaded from: classes39.dex */
public class LargeAmountContract {

    public interface TradeQueryByVerifyIdentity extends MvpView {
        void onFetchVerifyInfoFail(String r100, String r101);

        void onFetchVerifyInfoSuccess(CJPayFetchVerifyBean r100);

        void onTradeQueryByVerifyIdentityFail(String r100, String r101);

        void onTradeQueryByVerifyIdentitySuccess(CJPayTradeQueryByVerifyBean r100);
    }

    public LargeAmountContract() {
    }
}

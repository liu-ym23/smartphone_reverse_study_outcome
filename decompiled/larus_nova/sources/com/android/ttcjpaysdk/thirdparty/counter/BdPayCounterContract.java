package com.android.ttcjpaysdk.thirdparty.counter;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.thirdparty.counter.data.CJPayResetPwdResponseBean;
import com.android.ttcjpaysdk.thirdparty.counter.data.FastPaySignBean;
import com.android.ttcjpaysdk.thirdparty.counter.data.QueryPromotionAfterPayInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayWithoutPwdResponse;

/* JADX INFO: loaded from: classes39.dex */
public class BdPayCounterContract {

    public interface FastPaySignView extends MvpView {
        void onFastPaySignFail(String r100, String r101);

        void onFastPaySignSuccess(FastPaySignBean r100);
    }

    public interface ResultPageBuyAgainInfoView extends MvpView {
        void onQueryPromotionAfterPayInfoFail(String r100, String r101);

        void onQueryPromotionAfterPayInfoSuccess(QueryPromotionAfterPayInfo r100);
    }

    public interface ResultPasswordFreeView extends MvpView {
        void onPasswordFreeFail(String r100, String r101);

        void onPasswordFreeSuccess(CJPayWithoutPwdResponse r100);
    }

    public interface ResultResetPwdView extends MvpView {
        void onFail(String r100, String r101);

        void onSuccess(CJPayResetPwdResponseBean r100);
    }

    public BdPayCounterContract() {
    }
}

package com.android.ttcjpaysdk.thirdparty.payagain;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.thirdparty.data.FrontPreTradeInfo;
import com.android.ttcjpaysdk.thirdparty.data.FrontVerifyPageInfo;

/* JADX INFO: loaded from: classes39.dex */
public interface PayAgainContract extends MvpView {

    public interface FetchMethodListView extends PayAgainContract {
        void onGetMethodListFailed(String r100, String r101);

        void onGetMethodListSuccess(FrontPreTradeInfo r100);
    }

    public interface TradeCreateAgainView extends PayAgainContract {
        void onCreateFailed(String r100, String r101);

        void onCreateSuccess(FrontVerifyPageInfo r100);
    }
}

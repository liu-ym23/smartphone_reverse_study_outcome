package com.android.ttcjpaysdk.thirdparty.verify.params;

import com.android.ttcjpaysdk.thirdparty.data.CJPayCardSignBizContentParams;
import com.android.ttcjpaysdk.thirdparty.data.CJPayProcessInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayRiskInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeConfirmBizContentBasicParams;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeConfirmBizContentParams;

/* JADX INFO: loaded from: classes39.dex */
public interface VerifyRequestParams {
    String getAppId();

    VerifyBizScene getBizScene();

    CJPayCardSignBizContentParams getCardSignBizContentParams();

    CJPayRiskInfo getHttpRiskInfo(boolean r100);

    String getMerchantId();

    CJPayProcessInfo getProcessInfo();

    CJPayTradeConfirmBizContentBasicParams getTradeConfirmBasicParams();

    CJPayTradeConfirmBizContentParams getTradeConfirmParams();
}

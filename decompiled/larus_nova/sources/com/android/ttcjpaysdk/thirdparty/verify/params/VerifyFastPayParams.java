package com.android.ttcjpaysdk.thirdparty.verify.params;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public interface VerifyFastPayParams {
    String getBankName();

    String getCardNoMask();

    String getFaceScene();

    JSONObject getFaceVerifyInfo();

    String getJumpUrl();

    String getMobileMask();

    String getOutTradeNo();

    String getPwdMsg();

    String getVerifyChannel();
}

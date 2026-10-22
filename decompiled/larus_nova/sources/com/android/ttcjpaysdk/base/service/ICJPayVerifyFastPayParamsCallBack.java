package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayVerifyFastPayParamsCallBack {
    String getAppId();

    String getBankName();

    String getButtonColor();

    String getCardNoMask();

    String getCertificateType();

    JSONObject getCommonLogParams();

    View.OnClickListener getErrorDialogClickListener(int r100, Dialog r101, Activity r102, String r103, String r104, String r105, View.OnClickListener r106);

    String getFaceScene();

    JSONObject getFaceVerifyInfo();

    JSONObject getHttpRiskInfo(boolean r100);

    String getJumpUrl();

    JSONObject getKeepDialogInfo();

    String getMerchantId();

    String getMobile();

    String getMobileMask();

    String getOutTradeNo();

    JSONObject getProcessInfo();

    String getPwdMsg();

    String getRealName();

    JSONObject getTradeConfirmParams();

    String getTradeNo();

    String getUid();

    String getVerifyChannel();

    boolean isCardInactive();

    JSONObject parseTradeConfirmResponse(JSONObject r100);
}

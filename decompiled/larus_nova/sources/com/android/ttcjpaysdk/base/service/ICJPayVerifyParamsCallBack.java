package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayVerifyParamsCallBack {
    Boolean fingerPrintIsWindowStyle();

    String getAddPwdUrl();

    String getAppId();

    String getAuthStatus();

    JSONObject getBackTopRightBtnInfo();

    ICJPayPaymentMethodService.IPaymentMethodBindCardCallback getBindCardCallback();

    JSONObject getBindCardInfo();

    String getButtonColor();

    JSONObject getCardSignBizContentParams();

    String getCertificateType();

    JSONObject getCommonLogParams();

    String getDMSessionId();

    View.OnClickListener getErrorDialogClickListener(int r100, Dialog r101, Activity r102, String r103, String r104, String r105, View.OnClickListener r106);

    JSONObject getForgetPwdParams();

    ICJPayPaymentMethodService.FromScene getFromScene();

    JSONObject getHostInfo();

    JSONObject getHttpRiskInfo(boolean r100);

    JSONObject getKeepDialogInfo();

    JSONObject getMemberVerifyInfo();

    String getMerchantId();

    String getMethod();

    String getMobile();

    JSONObject getNoPwdPayInfo();

    int getNoPwdPayStyle();

    JSONObject getOneStepGuideInfoParams();

    JSONObject getPayInfo();

    String getPayUid();

    JSONObject getProcessInfo();

    String getPwdStatus();

    String getQueryMethod();

    int getQueryResultTimes();

    String getRealName();

    int getShowNoPwdButton();

    String getSource();

    JSONObject getTopRightBtnInfo();

    JSONObject getTradeConfirmParams();

    JSONObject getTradeConfirmResponse();

    String getTradeNo();

    String getTradeNoForOneStep();

    String getUid();

    JSONObject getVerifyInfo();

    boolean isBindCard();

    boolean isCardInactive();

    JSONObject parseTradeConfirmResponse(JSONObject r100);

    void setRealVerifyType(int r100);

    void setRealVerifyTypeSupplementary(int r100);
}

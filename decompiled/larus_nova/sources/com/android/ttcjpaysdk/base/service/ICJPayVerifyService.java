package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayVerifyService extends ICJPayService {
    String getCheckList();

    JSONObject getVerifyInfoJson();

    void initVerifyComponents(Context r100, int r101, ICJPayVerifyParamsCallBack r102, ICJPayVerifyResultCallBack r103, ICJPayVerifyCardSignCallBack r104, ICJPayVerifyFingerprintCallBack r105, ICJPayVerifyOneStepPaymentCallBack r106, ICJPayVerifyNothingCallback r107, ICJPayVerifyAddPwdCallback r108, ICJPayVerifyStackStateCallback r110, ICJPayVerifyQueryListener r111);

    boolean isFingerprintPayDowngrade();

    boolean isLocalEnableFingerprint(Context r100, String r101, boolean r102);

    boolean isRelease();

    boolean onBackPressed();

    void release();

    void setFingerprintTokenCleared(Context r100, String r101, JSONObject r102, Boolean r103);

    void setPayMethod(String r100);

    void start(int r100, int r101, int r102, boolean r103);

    void stop();

    void updatePreBioParams(JSONObject r100);
}

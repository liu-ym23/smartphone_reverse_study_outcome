package com.android.ttcjpaysdk.base.service;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPaySupplementarySignCallBack {
    void onFirstInputCardInfo();

    void onFragmentNextBtnClick(int r100);

    void onGotoAgreementDetail(String r100, String r101);

    void onUpdateCardInfoResult(JSONObject r100);
}

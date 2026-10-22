package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayCounterService extends ICJPayService {

    public interface ICJPayCompleteCallBack {
        String getCheckList();

        void showAmountUpgradeGuide();

        void showFastPayMoreFragment(Serializable r100);

        void showFingerprintDegradeGuide();

        void showFingerprintGuide();

        void showPasswordFreeGuide();

        void showPreBioFingerprintGuide(int r100);
    }

    void bindTradeQueryBean(JSONObject r100);

    void bindTradeQueryData(JSONObject r100);

    Fragment getAmountUpgradeGuideFragment(JSONObject r100);

    Fragment getCompleteFragment(JSONObject r100);

    int getCompleteRemainTime();

    int getCompleteShowStyle();

    Fragment getFastPayGuideMoreFragment(JSONObject r100, Serializable r101);

    Fragment getFingerprintDegradeGuideFragment(JSONObject r100);

    Fragment getFingerprintGuideFragment(JSONObject r100);

    Fragment getFingerprintGuideFragment(JSONObject r100, String r101, JSONObject r102);

    Fragment getPasswordFreeGuideFragment(JSONObject r100);

    Fragment getPreBioFingerprintGuideFragment(JSONObject r100);

    String getSource();

    void hideResultPageMask(Object r100);

    boolean isAmountUpgradeGuideFragment(Fragment r100);

    boolean isFingerprintDegradeGuideFragment(Fragment r100);

    boolean isFingerprintGuideFragment(Fragment r100);

    boolean isPasswordFreeGuideFragment(Fragment r100);

    boolean isPayResultGuideFragment(Fragment r100);

    boolean isPreBioFingerprintGuideFragment(Fragment r100);

    void notifyCheckoutCounterResult(Context r100, Bundle r101);

    void notifyUnionPassEnd(Context r100);

    void release();

    void setCheckoutResponseBean(JSONObject r100, JSONObject r101);

    void setCompleteCallBack(ICJPayCompleteCallBack r100);

    void setSharedParams(Map<String, String> r100);

    void startCJPayCheckoutCounterActivity(Context r100, JSONObject r101);

    void statResultPage(Object r100, Object r101);

    boolean tryShowPromotionDialog();
}

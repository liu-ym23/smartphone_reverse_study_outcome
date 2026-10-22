package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.service.bean.CJPayProcessInfoBean;
import com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayObserver;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ICJPayIntegratedCounterService extends ICJPayService {
    public static final String INTENT_KEY_DATA_FROM_DY = "tt_cj_pay_data_from_dy";

    String getIntegratedCounterAppId();

    Map<String, String> getIntegratedCounterHttpData(Map<String, String> r100, String r101, String r102, String r103);

    Map<String, String> getIntegratedCounterHttpHeader(String r100, String r101);

    String getIntegratedCounterMerchantId();

    String getIntegratedCounterUrl(String r100, String r101);

    Object getIntegratedObserver();

    ITTCJPayComponent getPayComponent(IPayLifecycle r100);

    CJPayProcessInfoBean getProcessInfo();

    String getPromotionSource();

    void preLoad();

    void setIntegratedObserver(Object r100);

    void startIntegratedOuterPay(Activity r100, Intent r101, JSONObject r102, CJOuterPayCallback r103);

    void startNewCounterActivity(Context r100, String r101, JSONObject r102, CJContext r103);

    void startSignWithholding(Activity r100, String r101, JSONObject r102, JSONObject r103);

    void ttcjPayDoPay(String r100, int r101, String r102, String r103, String r104, IH5PayCallback r105);

    void ttcjPayInvokeInit();

    void ttcjPaySetHostInfo(CJPayHostInfo r100);

    void ttcjPaySetObserver(TTCJPayObserver r100);

    Boolean verifyScanResultSync(Context r100, String r101);
}

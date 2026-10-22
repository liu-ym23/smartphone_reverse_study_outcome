package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import com.android.ttcjpaysdk.base.service.bean.CJCallback;
import com.android.ttcjpaysdk.base.service.bean.ecom.EcOrderData;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ICJPayFrontCounterService extends ICJPayService {
    void createOrder(String r100, String r101, String r102, CJCallback<EcOrderData> r103, CJContext r104);

    void preLoad();

    void reportStartPayByCreateOrder();

    void startDirectPay(Context r100, String r101, JSONObject r102, JSONObject r103);

    void startNewET(Context r100, String r101, JSONObject r102, String r103, String r104, boolean r105, JSONObject r106, CJContext r107);

    void startNewStandard(Context r100, String r101, JSONObject r102, String r103, String r104, boolean r105, JSONObject r106, CJContext r107);
}

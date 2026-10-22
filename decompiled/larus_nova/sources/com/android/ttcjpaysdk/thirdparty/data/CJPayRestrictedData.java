package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayIgnore;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayRestrictedData implements CJPayObject {

    @CJPayIgnore
    public static final int FROM_COUNTER = 1000;

    @CJPayIgnore
    public static final int FROM_RECHARGE = 1001;

    @CJPayIgnore
    public static final int FROM_WITHDRAW = 1002;
    public String appId;
    public String bankCardId;
    public String certificateType;
    public ArrayList<CJPayDiscount> discounts;
    public String errorTipsColor;
    public int from;
    public String merchantId;
    public String mobile;
    public String payType;
    public String paymentMethod;
    public CJPayProcessInfo processInfo;
    public String pwd;
    public String realName;
    public long rechargeAmount;
    public String showStyle;
    public CJPayTradeInfo tradeInfo;

    public boolean isMainlandId() {
        return CJPayIdType.MAINLAND.equals(CJPayIdType.getTypeFromIdCode(this.certificateType));
    }

    public CJPayRestrictedData() {
        this.processInfo = new CJPayProcessInfo();
        this.tradeInfo = new CJPayTradeInfo();
        this.discounts = new ArrayList();
    }

    public static CJPayRestrictedData parseJson(JSONObject r100) {
        CJPayRestrictedData r101 = new CJPayRestrictedData();
        r101.errorTipsColor = r100.optString("errorTipsColor");
        r101.realName = r100.optString("realName");
        r101.mobile = r100.optString("mobile");
        r101.pwd = r100.optString("pwd");
        r101.payType = r100.optString("payType");
        r101.paymentMethod = r100.optString("paymentMethod");
        r101.bankCardId = r100.optString("bankCardId");
        r101.certificateType = r100.optString("certificateType");
        r101.appId = r100.optString("appId");
        r101.merchantId = r100.optString("merchantId");
        r101.showStyle = r100.optString("showStyle");
        r101.rechargeAmount = r100.optLong("rechargeAmount");
        r101.from = r100.optInt("from");
        r101.processInfo.parseProcessInfo(r100.optJSONObject("processInfo"));
        r101.tradeInfo.setDataForRestricted(r100.optString("tradeInfo"));
        JSONArray r102 = r100.optJSONArray("discountInfo");
        if (r102 == null) goto L8;
        int r103 = 0;
    L6:
        if (r103 >= r102.length()) goto L8;
        r101.discounts.add((CJPayDiscount) CJPayJsonParser.fromJson(r102.optJSONObject(r103), CJPayDiscount.class));
        r103 = r103 + 1;
    L8:
        return r101;
    }
}

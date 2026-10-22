package com.android.ttcjpaysdk.base.paymentbasis;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJPairObject;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayRequest {
    public String appId;
    public String callbackUrl;
    public String cloudUnionPayAppId;
    public String cloudUnionPayRequestData;
    public String cmbAppId;
    public String cmbRequestData;
    public boolean isUseForegroundDetect;
    public String nonceStr;
    public String orderInfo;
    public String partnerId;
    public String path;
    public String pkg;
    public String prepayId;
    public String sign;
    public String signType;
    public String timestamp;
    public String ttSign;
    public String ttSignType;
    public int type;
    public String url;
    public String userName;
    public String validateStr;

    public CJPayRequest() {
    }

    public boolean isAliParamsEmpty() {
        String r100 = this.url;
        if (r100 != null) goto L5;
        return true;
    L5:
        if (this.sign != null) goto L8;
        return true;
    L8:
        if (r100.isEmpty() == false) goto L10;
        return true;
    L10:
        if (this.sign.isEmpty() == true) goto L17;
        return false;
    L17:
        return true;
    }

    public boolean isWxMiniAppParamsEmpty() {
        if (this.userName != null) goto L5;
    L8:
        return true;
    L5:
        if (this.path == null) goto L8;
        return false;
    }

    public boolean isWxParamsEmpty() {
        String r100 = this.appId;
        if (r100 != null) goto L5;
        return true;
    L5:
        if (this.partnerId != null) goto L7;
        return true;
    L7:
        if (this.prepayId != null) goto L9;
        return true;
    L9:
        if (this.nonceStr != null) goto L11;
        return true;
    L11:
        if (this.timestamp != null) goto L13;
        return true;
    L13:
        if (this.sign != null) goto L16;
        return true;
    L16:
        if (r100.isEmpty() == false) goto L18;
        return true;
    L18:
        if (this.partnerId.isEmpty() == false) goto L20;
        return true;
    L20:
        if (this.prepayId.isEmpty() == false) goto L22;
        return true;
    L22:
        if (this.nonceStr.isEmpty() == false) goto L24;
        return true;
    L24:
        if (this.timestamp.isEmpty() == false) goto L26;
        return true;
    L26:
        if (this.sign.isEmpty() == true) goto L41;
        return false;
    L41:
        return true;
    }

    public static CJPayRequest parse(String r100) {
        CJPayRequest r101 = new CJPayRequest();
        JSONObject r102 = new JSONObject(r100).optJSONObject("data");     // Catch: Throwable -> L42
        if (r102 == null) goto L44;
        JSONObject r103 = r102.optJSONObject("sdk_info");     // Catch: Throwable -> L42
        JSONObject r104 = r102.optJSONObject("trade_info");     // Catch: Throwable -> L42
        if (r102.has("pay_way") == false) goto L9;
        r101.type = JSONObjectProtectorUtils.getInt(r102, "pay_way");     // Catch: Throwable -> L42
    L9:
        if (r103 == null) goto L24;
        r101.sign = r103.optString("sign");     // Catch: Throwable -> L42
        r101.isUseForegroundDetect = r103.optBoolean(ICJPayBasisPaymentService.USE_VISIBLE_CALLBACK);     // Catch: Throwable -> L42
        r101.pkg = r103.optString("package");     // Catch: Throwable -> L42
        r101.timestamp = r103.optString("timestamp");     // Catch: Throwable -> L42
        String r105 = r103.optString("partner_id");     // Catch: Throwable -> L42
        r101.partnerId = r105;     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r105) == false) goto L13;
        r101.partnerId = r103.optString(DyPayConstant.K_PAY_INFO_PARAM_PARTNERID);     // Catch: Throwable -> L42
    L13:
        String r106 = r103.optString("app_id");     // Catch: Throwable -> L42
        r101.appId = r106;     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r106) == false) goto L17;
        r101.appId = r103.optString("appid");     // Catch: Throwable -> L42
    L17:
        String r107 = r103.optString("prepay_id");     // Catch: Throwable -> L42
        r101.prepayId = r107;     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r107) == false) goto L20;
        r101.prepayId = r103.optString(DyPayConstant.K_PAY_INFO_PARAM_PREPAYID);     // Catch: Throwable -> L42
    L20:
        String r108 = r103.optString("nonce_str");     // Catch: Throwable -> L42
        r101.nonceStr = r108;     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r108) == false) goto L23;
        r101.nonceStr = r103.optString(DyPayConstant.K_PAY_INFO_PARAM_NONCESTR);     // Catch: Throwable -> L42
    L23:
        r101.signType = r103.optString("sign_type");     // Catch: Throwable -> L42
        r101.orderInfo = r103.optString("order_info");     // Catch: Throwable -> L42
        r101.url = r103.optString("url");     // Catch: Throwable -> L42
        r101.cmbAppId = r103.optString("appid");     // Catch: Throwable -> L42
        r101.cmbRequestData = r103.optString("from_html");     // Catch: Throwable -> L42
        r101.cloudUnionPayAppId = r103.optString("app_id");     // Catch: Throwable -> L42
        r101.cloudUnionPayRequestData = r103.toString();     // Catch: Throwable -> L42
        r101.userName = r103.optString(ITwitterService.ResponseConstants.USER_NAME);     // Catch: Throwable -> L42
        r101.path = r103.optString("path");     // Catch: Throwable -> L42
    L24:
        boolean r109 = true;
        if (r104 == null) goto L27;
        r101.ttSign = r104.optString("tt_sign");     // Catch: Throwable -> L42
        r101.callbackUrl = r104.optString("call_back_url");     // Catch: Throwable -> L42
        r101.type = r104.optInt("way", 1);     // Catch: Throwable -> L42
        r101.ttSignType = r104.optString("tt_sign_type");     // Catch: Throwable -> L42
    L27:
        if (r103 == null) goto L44;
        if (r104 == null) goto L44;
        ArrayList r110 = new ArrayList();     // Catch: Throwable -> L42
        JSONObject r111 = new JSONObject(r104.toString());     // Catch: Throwable -> L42
        r110.add(new CJPairObject("sign", r101.sign));     // Catch: Throwable -> L42
        r111.remove("tt_sign");     // Catch: Throwable -> L42
        r111.remove("tt_sign_type");     // Catch: Throwable -> L42
        Iterator<String> r112 = r111.keys();     // Catch: Throwable -> L42
    L31:
        if (r112.hasNext() == false) goto L33;
        String r113 = r112.next();     // Catch: Throwable -> L42
        r110.add(new CJPairObject(r113.toLowerCase(), r111.optString(r113, "")));     // Catch: Throwable -> L42
        goto L31
    L33:
        Collections.sort(r110, new AnonymousClass1());     // Catch: Throwable -> L42
        StringBuilder r114 = new StringBuilder();     // Catch: Throwable -> L42
        Iterator r115 = r110.iterator();     // Catch: Throwable -> L42
    L35:
        if (r115.hasNext() == false) goto L40;
        CJPairObject r116 = (CJPairObject) r115.next();     // Catch: Throwable -> L42
        if (r109 == true) goto L39;
        r114.append("&");     // Catch: Throwable -> L42
    L39:
        r114.append(r116.getName());     // Catch: Throwable -> L42
        r114.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L42
        r114.append(r116.getValue());     // Catch: Throwable -> L42
        r109 = false;
        goto L35
    L40:
        r101.validateStr = r114.toString();     // Catch: Throwable -> L42
    L44:
        return r101;
    L42:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayRequest#compare", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayRequest#compare", th);
        th.printStackTrace();
        goto L44
    }
}

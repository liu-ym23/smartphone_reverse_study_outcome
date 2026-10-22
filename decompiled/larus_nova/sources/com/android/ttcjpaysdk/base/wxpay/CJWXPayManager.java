package com.android.ttcjpaysdk.base.wxpay;

import android.app.Activity;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSessionManager;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayCallback;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayRequest;
import com.android.ttcjpaysdk.base.paymentbasis.CJPaySession;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJPayException;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJUnSupportedException;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJWXUnInstalledException;
import com.android.ttcjpaysdk.base.paymentbasis.constants.WXPayType;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.api.wxpay.WXPayService;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import ve4.a;

/* JADX INFO: loaded from: classes28.dex */
public class CJWXPayManager extends CJPayBaseSessionManager {
    private static CJWXPayManager sInstance;
    private Map<String, CJPaySession> mWxPaySessionMap;

    public static WXPayService getWxPayService() {
        a.f554342a.getClass();
        return (WXPayService) a.a(WXPayService.class);
    }

    public static CJWXPayManager inst() {
        if (sInstance != null) goto L6;
        sInstance = new CJWXPayManager();
    L6:
        return sInstance;
    }

    public CJWXPayManager() {
        this.mWxPaySessionMap = new HashMap();
    }

    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSessionManager
    public void endSession(CJPaySession r100) {
        if (r100 != this.mCurrentSession) goto L6;
        this.mCurrentSession = null;
    L6:
        if ((r100 instanceof CJWXPaySession) == false) goto L9;
        String r101 = ((CJWXPaySession) r100).getPrePayId();
        this.mWxPaySessionMap.remove(r101);
        return;
    }

    public CJPaySession getWxSession(String r100) {
        return this.mWxPaySessionMap.get(r100);
    }

    public String getWxVersion(int r100) {
        String r101 = Integer.toHexString(r100);
        if (r101.length() >= 2) goto L6;
        return "";
    L6:
        String r102 = r101.charAt(1) + ".";
        String r103 = r101.substring(2);
    L8:
        if (r103.length() <= 1) goto L11;
        r102 = r102 + CastIntegerProtector.parseInt(r103.substring(0, 2), 16) + ".";
        r103 = r103.substring(2);
        goto L8
    L11:
        return r102.substring(0, r102.length() - 1);
    }

    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSessionManager
    public CJPaySession newSession(Activity r100, String r101, String r110, CJPayCallback r111, ICJPayBasisPaymentService.OnPayResultCallback r112) throws CJWXUnInstalledException, CJUnSupportedException, CJPayException {
        this.mCurrentSession = null;
        WXPayService r102 = getWxPayService();
        Object r103 = r102.getWxApi(r100, r101);
        int r104 = 0;
        if (r103 == null) goto L5;
        boolean r105 = r102.registerApp(r103, r101);
        String r106 = getWxVersion(r102.getWXAppSupportAPI(r103));
    L6:
        JSONObject r107 = new JSONObject();
        r107.put(e.f25671s, "wxpay");     // Catch: Exception -> L12
        if (r105 == false) goto L10;
        r104 = 1;
    L10:
        r107.put("status", r104);     // Catch: Exception -> L12
        r107.put("is_install", 1);     // Catch: Exception -> L12
        r107.put("other_sdk_version", r106);     // Catch: Exception -> L12
    L14:
        if (r112 == null) goto L16;
        r112.onEvent("wallet_register_sdk", r107.toString());
    L16:
        CJPayRequest r108 = CJPayRequest.parse(r110);
        if (r108.isWxParamsEmpty() == true) goto L21;
        return newSession(r100, r103, r108, r111, r112);
    L21:
        throw new CJPayException(R.string.cj_pay_params_empty);
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJWXPayManager#JSONObject", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJWXPayManager#JSONObject", e);
        goto L14
    L5:
        r106 = "";
        r105 = false;
        goto L6
    }

    private CJPaySession newSession(Activity r110, Object r111, CJPayRequest r112, CJPayCallback r113, ICJPayBasisPaymentService.OnPayResultCallback r114) throws CJWXUnInstalledException, CJUnSupportedException {
        this.mCurrentSession = null;
        if (r112 != null) goto L6;
        return null;
    L6:
        if (r112.type != 1) goto L19;
        if (r111 == null) goto L17;
        if (getWxPayService().isWXAppInstalled(r111) == false) goto L17;
        if (r112.isUseForegroundDetect == false) goto L13;
        this.mCurrentSession = new CJWXPaySessionOpt(r110, r111, r112, r113, inst(), r114, WXPayType.APP.getValue());
    L14:
        this.mWxPaySessionMap.put(r112.prepayId, this.mCurrentSession);
        return this.mCurrentSession;
    L13:
        this.mCurrentSession = new CJWXPaySession(r111, r112, r113, inst(), r114, WXPayType.APP.getValue());
    L17:
        throw new CJWXUnInstalledException();
    L19:
        throw new CJUnSupportedException();
    }
}

package com.android.ttcjpaysdk.base.wxpay;

import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSession;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayCallback;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayRequest;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJWXPaySession extends CJPayBaseSession {
    private static final String TAG = "CJWXPaySession";
    private Object api;
    private String version;

    public void processPrePay() {
    }

    public void processWhenCallback() {
    }

    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPaySession
    public void release() {
    }

    public String getPrePayId() {
        CJPayRequest r100 = this.mRequest;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.prepayId;
    }

    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSession
    public void sendRequest() {
        CJLogger.d(TAG, "sendRequest sessionType:" + this.sessionType);
        new AnonymousClass1(this).start();
    }

    public Object getApi() {
        return this.api;
    }

    public String getSessionType() {
        return this.sessionType;
    }

    public static /* synthetic */ String access$000(CJWXPaySession r100) {
        return r100.sessionType;
    }

    public static /* synthetic */ String access$100(CJWXPaySession r100) {
        return r100.sessionType;
    }

    public static /* synthetic */ CJPayRequest access$1000(CJWXPaySession r100) {
        return r100.mRequest;
    }

    public static /* synthetic */ CJPayRequest access$1100(CJWXPaySession r100) {
        return r100.mRequest;
    }

    public static /* synthetic */ CJPayRequest access$1200(CJWXPaySession r100) {
        return r100.mRequest;
    }

    public static /* synthetic */ String access$1300(CJWXPaySession r100) {
        return r100.version;
    }

    public static /* synthetic */ long access$1400(CJWXPaySession r100) {
        return r100.startTime;
    }

    public static /* synthetic */ String access$1500(CJWXPaySession r100) {
        return r100.sessionType;
    }

    public static /* synthetic */ ICJPayBasisPaymentService.OnPayResultCallback access$1600(CJWXPaySession r100) {
        return r100.mOnPayResultCallback;
    }

    public static /* synthetic */ ICJPayBasisPaymentService.OnPayResultCallback access$1700(CJWXPaySession r100) {
        return r100.mOnPayResultCallback;
    }

    public static /* synthetic */ CJPayRequest access$200(CJWXPaySession r100) {
        return r100.mRequest;
    }

    public static /* synthetic */ Object access$400(CJWXPaySession r100) {
        return r100.api;
    }

    public static /* synthetic */ CJPayRequest access$500(CJWXPaySession r100) {
        return r100.mRequest;
    }

    public static /* synthetic */ CJPayRequest access$600(CJWXPaySession r100) {
        return r100.mRequest;
    }

    public static /* synthetic */ CJPayRequest access$700(CJWXPaySession r100) {
        return r100.mRequest;
    }

    public static /* synthetic */ CJPayRequest access$800(CJWXPaySession r100) {
        return r100.mRequest;
    }

    public static /* synthetic */ CJPayRequest access$900(CJWXPaySession r100) {
        return r100.mRequest;
    }

    private String appendPkgName(String r100) {
        return r100 + "&pkg_name=" + CJEnv.a().getPackageName();
    }

    public static /* synthetic */ String access$1302(CJWXPaySession r100, String r101) {
        r100.version = r101;
        return r101;
    }

    public static /* synthetic */ String access$300(CJWXPaySession r100, String r101) {
        return r100.appendPkgName(r101);
    }

    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSession
    public void onPayResult(String r100, CJPayCallback r101) {
        if ("0".equals(r100) == false) goto L6;
        String r102 = "success";
        int r103 = 0;
    L9:
        JSONObject r104 = new JSONObject();
        r104.put(e.f25671s, "wxpay");     // Catch: Exception -> L17
        r104.put("error_code", r100);     // Catch: Exception -> L17
        r104.put("error_message", r102);     // Catch: Exception -> L17
        r104.put("is_install", 1);     // Catch: Exception -> L17
        r104.put("other_sdk_version", this.version);     // Catch: Exception -> L17
        r104.put("trade_type", this.sessionType);     // Catch: Exception -> L17
        JSONObject r105 = CJPayCallBackCenter.getInstance().getTrackInfo();     // Catch: Exception -> L17
        if (r105 == null) goto L19;
        Iterator<String> r106 = r105.keys();     // Catch: Exception -> L17
    L14:
        if (r106.hasNext() == false) goto L19;
        String r107 = r106.next();     // Catch: Exception -> L17
        r104.put(r107, r105.optString(r107));     // Catch: Exception -> L17
    L19:
        ICJPayBasisPaymentService.OnPayResultCallback r108 = this.mOnPayResultCallback;
        if (r108 == null) goto L22;
        r108.onEvent("wallet_pay_callback", r104.toString());
    L22:
        processWhenCallback();
        r101.onPayResult(r103, r100);
        return;
    L17:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJWXPaySession#JSONObject", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJWXPaySession#JSONObject", e);
        goto L19
    L6:
        if ("-2".equals(r100) == false) goto L8;
        r102 = "cancel";
        r103 = 2;
        goto L9
    L8:
        r102 = "fail";
        r103 = 1;
        goto L9
    }

    public CJWXPaySession(Object r100, CJPayRequest r101, CJPayCallback r102, CJWXPayManager r103, ICJPayBasisPaymentService.OnPayResultCallback r104, String r105) {
        super(r101, r102, r103, r104);
        this.api = r100;
        this.sessionType = r105;
    }
}

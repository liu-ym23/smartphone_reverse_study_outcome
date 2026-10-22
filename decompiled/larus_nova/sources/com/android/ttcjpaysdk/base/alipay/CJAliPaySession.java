package com.android.ttcjpaysdk.base.alipay;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.m.p.e;
import com.alipay.sdk.m.u.i;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSession;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayCallback;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayRequest;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJAliPaySession extends CJPayBaseSession {
    private WeakReference<Activity> activityRef;
    private String aliSdkVersion;
    private Handler handler;

    public void processPrePay() {
    }

    public void processWhenCallback() {
    }

    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPaySession
    public void release() {
    }

    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSession
    public void sendRequest() {
        new AnonymousClass2(this).start();
    }

    public static /* synthetic */ WeakReference access$000(CJAliPaySession r100) {
        return r100.activityRef;
    }

    public static /* synthetic */ CJPayRequest access$100(CJAliPaySession r100) {
        return r100.mRequest;
    }

    public static /* synthetic */ CJPayRequest access$200(CJAliPaySession r100) {
        return r100.mRequest;
    }

    public static /* synthetic */ CJPayRequest access$300(CJAliPaySession r100) {
        return r100.mRequest;
    }

    public static /* synthetic */ CJPayRequest access$400(CJAliPaySession r100) {
        return r100.mRequest;
    }

    public static /* synthetic */ String access$500(CJAliPaySession r100) {
        return r100.aliSdkVersion;
    }

    public static /* synthetic */ ICJPayBasisPaymentService.OnPayResultCallback access$600(CJAliPaySession r100) {
        return r100.mOnPayResultCallback;
    }

    public static /* synthetic */ ICJPayBasisPaymentService.OnPayResultCallback access$700(CJAliPaySession r100) {
        return r100.mOnPayResultCallback;
    }

    public static /* synthetic */ Handler access$800(CJAliPaySession r100) {
        return r100.handler;
    }

    private JSONObject getPayResponse(String r100) {
        String r101 = getContent(r100, "alipay_trade_app_pay_response\":", i.f25855d);
        if (r101.isEmpty() == true) goto L10;
        r101 = r101.concat(i.f25855d);
    L10:
        return new JSONObject(r101);
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJAliPaySession#getPayResponse", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJAliPaySession#getPayResponse", e);
        e.printStackTrace();
        return new JSONObject();
    }

    private String getResultStatus(String r100) {
        return getContent(r100, "resultStatus={", i.f25855d);
    L4:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJAliPaySession#getResultStatus", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJAliPaySession#getResultStatus", th);
        return "";
    }

    public void init(Activity r100) {
        final Looper r101 = Looper.getMainLooper();
        this.handler = new AnonymousClass1(this, r101);
        this.activityRef = new WeakReference(r100);
    }

    public static /* synthetic */ String access$502(CJAliPaySession r100, String r101) {
        r100.aliSdkVersion = r101;
        return r101;
    }

    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSession
    public void onPayResult(String r100, CJPayCallback r110) {
        String r101 = getResultStatus(r100);
        int r102 = 0;
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L21:
        int r103 = 1;
    L22:
        JSONObject r104 = new JSONObject();
        r104.put(e.f25671s, "alipay");     // Catch: Exception -> L36
        r104.put("error_code", r101);     // Catch: Exception -> L36
        r104.put("error_message", r100);     // Catch: Exception -> L36
        if (CJAliPayUtils.isAliPayInstalled(this.activityRef.get()) == false) goto L26;
        r102 = 1;
    L26:
        r104.put("is_install", r102);     // Catch: Exception -> L36
        r104.put("other_sdk_version", this.aliSdkVersion);     // Catch: Exception -> L36
        JSONObject r105 = CJPayCallBackCenter.getInstance().getTrackInfo();     // Catch: Exception -> L36
        if (r105 == null) goto L33;
        Iterator<String> r106 = r105.keys();     // Catch: Exception -> L36
    L30:
        if (r106.hasNext() == false) goto L33;
        String r107 = r106.next();     // Catch: Exception -> L36
        r104.put(r107, r105.optString(r107));     // Catch: Exception -> L36
    L33:
        if ("4000".equals(r101) == false) goto L38;
        JSONObject r108 = getPayResponse(r100);     // Catch: Exception -> L36
        r104.put("sub_code", r108.optString("code"));     // Catch: Exception -> L36
        r104.put("sub_msg", r108.optString("sub_msg"));     // Catch: Exception -> L36
    L38:
        ICJPayBasisPaymentService.OnPayResultCallback r109 = this.mOnPayResultCallback;
        if (r109 == null) goto L41;
        r109.onEvent("wallet_pay_callback", r104.toString());
    L41:
        r110.onPayResult(r103, r101);
        return;
    L36:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJAliPaySession#JSONObject", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJAliPaySession#JSONObject", e);
        goto L38
    L5:
        if ("6001".equals(r101) == false) goto L8;
        r103 = 2;
        goto L22
    L8:
        if ("9000".equals(r101) == false) goto L11;
        r103 = 0;
        goto L22
    L11:
        if (CJPaySettingsManager.getInstance().isDegradeAliPayErrorCode() == true) goto L19;
        if ("8000".equals(r101) == false) goto L15;
    L20:
        r103 = 5;
        goto L22
    L15:
        if ("6004".equals(r101) == true) goto L20;
        if ("6006".equals(r101) == true) goto L20;
    L19:
        if ("7001".equals(r101) == false) goto L21;
        goto L20
    }

    private String getContent(String r100, String r101, String r102) {
        int r103 = r100.indexOf(r101);
        if (r103 >= 0) goto L6;
        return "";
    L6:
        int r104 = r103 + r101.length();
        if (r102 == null) goto L9;
        r100 = r100.substring(r104, r100.indexOf(r102, r104));     // Catch: Exception -> L11
    L14:
    L13:
        return r100;
    L9:
        r100 = r100.substring(r104);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJAliPaySession#getContent", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJAliPaySession#getContent", e);
        e.printStackTrace();
        goto L13
    }

    public CJAliPaySession(Activity r100, CJPayRequest r101, CJPayCallback r102, CJAliPayManager r103, ICJPayBasisPaymentService.OnPayResultCallback r104) {
        super(r101, r102, r103, r104);
        init(r100);
    }
}

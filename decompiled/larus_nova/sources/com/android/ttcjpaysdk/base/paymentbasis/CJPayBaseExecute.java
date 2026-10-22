package com.android.ttcjpaysdk.base.paymentbasis;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJPayException;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJUnSupportedException;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJWXUnInstalledException;
import com.android.ttcjpaysdk.base.paymentbasis.common.ThirdPartyPayLogUtils;
import com.android.ttcjpaysdk.base.paymentbasis.common.ThirdPartyPayUtils;
import com.android.ttcjpaysdk.base.router.CJRouteOutMonitorUtils;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public abstract class CJPayBaseExecute {
    private static final String TAG = "CJPayBaseExecute";
    protected WeakReference<Context> mContextRef;
    protected ICJPayBasisPaymentService.OnPayResultCallback mOnPayResultCallback;
    private ICJPayBasisPaymentService.OnResultCallback mOnResultCallback;
    protected JSONObject mParams;
    protected CJPayCallback mPayCallback;
    protected String mTradeType;
    protected int mType;
    protected String mWxAppId;
    private String method;
    private String routerCertId;

    public abstract CJPaySession getSession(Activity r100, String r101, CJPayCallback r102) throws CJWXUnInstalledException, CJUnSupportedException, CJPayException;

    public void executePay() {
        WeakReference<Context> r100 = this.mContextRef;
        if (r100 != null) goto L5;
    L9:
        Activity r101 = null;
    L11:
        if (this.mParams == null) goto L33;
        if (r101 == null) goto L33;
        this.mPayCallback = new AnonymousClass1(this);     // Catch: CJPayException -> L24 CJUnSupportedException -> L28 CJWXUnInstalledException -> L30
        HashMap r102 = new HashMap();     // Catch: CJPayException -> L24 CJUnSupportedException -> L28 CJWXUnInstalledException -> L30
        r102.put("merchant_id", ThirdPartyPayUtils.Companion.getMerchantId());     // Catch: CJPayException -> L24 CJUnSupportedException -> L28 CJWXUnInstalledException -> L30
        CJRouteOutMonitorUtils.INSTANCE.notifyRouteOutCertId(this.routerCertId, r102, r101);     // Catch: CJPayException -> L24 CJUnSupportedException -> L28 CJWXUnInstalledException -> L30
        CJPaySession r103 = getSession(r101, this.mParams.toString(), this.mPayCallback);     // Catch: CJPayException -> L24 CJUnSupportedException -> L28 CJWXUnInstalledException -> L30
        if (r103 == null) goto L22;
        r103.start();     // Catch: CJPayException -> L24 CJUnSupportedException -> L28 CJWXUnInstalledException -> L30
        ICJPayBasisPaymentService.OnPayResultCallback r104 = this.mOnPayResultCallback;     // Catch: CJPayException -> L24 CJUnSupportedException -> L28 CJWXUnInstalledException -> L30
        if (r104 != null) goto L20;
    L35:
        return;
    L20:
        if (this.mType != 3) goto L35;
        r104.onDisplayCMBEnterToast(r101.getApplicationContext(), this.mContextRef.get().getResources().getString(R.string.cj_pay_enter_info));     // Catch: CJPayException -> L24 CJUnSupportedException -> L28 CJWXUnInstalledException -> L30
        goto L35
    L22:
        CJLogger.b(TAG, "session is null");     // Catch: CJPayException -> L24 CJUnSupportedException -> L28 CJWXUnInstalledException -> L30
    L24:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBaseExecute#onPayResult", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBaseExecute#onPayResult", e);
        if (e.getErrResId() <= 0) goto L39;
        processException(1, e.getErrResId());
        return;
    L39:
        return;
    L28:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBaseExecute#processException", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBaseExecute#processException", e);
        processException(4, R.string.cj_pay_wx_unsupport);
        e.printStackTrace();
        return;
    L30:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBaseExecute#callBackPayResult", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBaseExecute#callBackPayResult", e);
        processException(3, R.string.cj_pay_wx_not_installed);
        e.printStackTrace();
        return;
    L33:
        processException(1, R.string.cj_pay_params_error);
        CJLogger.b(TAG, "executePay params is wrong");
        return;
    L5:
        if (r100.get() == null) goto L9;
        if ((this.mContextRef.get() instanceof Activity) == false) goto L9;
        r101 = (Activity) this.mContextRef.get();
        goto L11
    }

    public static /* synthetic */ String access$000(CJPayBaseExecute r100) {
        return r100.routerCertId;
    }

    private void processException(int r100, int r101) {
        WeakReference<Context> r102 = this.mContextRef;
        if (r102 != null) goto L5;
    L9:
        CJRouteOutMonitorUtils.INSTANCE.removeNotifiedRouteOutCertId(this.routerCertId);
        return;
    L5:
        if (r102.get() == null) goto L9;
        if (this.mOnPayResultCallback == null) goto L9;
        String r103 = this.mContextRef.get().getResources().getString(r101);
        this.mOnPayResultCallback.onShowErrorInfo(this.mContextRef.get(), r103);
        callBackPayResult(r100, r103, "");
        ThirdPartyPayLogUtils.Companion r104 = ThirdPartyPayLogUtils.Companion;
        r104.uploadPayResult(this.method, r103, this.mOnPayResultCallback);
        r104.monitorPayFailure(this.method, r103);
        goto L9
    }

    public void callBackPayResult(int r100, String r101, String r102) {
        CJLogger.d(TAG, "callBackPayResult code:" + r100 + ",msg:" + r101);
        if (this.mOnResultCallback == null) goto L17;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L12
        r103.put("code", r100);     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r101) == true) goto L8;
        r103.put("msg", r101);     // Catch: Exception -> L12
    L8:
        if (TextUtils.isEmpty(r102) == true) goto L10;
        r103.put("raw_code", r102);     // Catch: Exception -> L12
    L10:
        this.mOnResultCallback.onResult(r103);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBaseExecute#callBackPayResult", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBaseExecute#callBackPayResult", e);
        e.printStackTrace();
        return;
    }

    public CJPayBaseExecute(Context r100, String r101, JSONObject r102, ICJPayBasisPaymentService.OnPayResultCallback r103, ICJPayBasisPaymentService.OnResultCallback r104, int r105) {
        this.mContextRef = new WeakReference(r100);
        this.mWxAppId = r101;
        this.mParams = r102;
        this.mOnPayResultCallback = r103;
        this.mOnResultCallback = r104;
        this.mType = r105;
        if (r105 != 1) goto L5;
        this.method = "wxpay";
        this.routerCertId = CJRouteOutMonitorUtils.CERT_ID_WXPAY;
        return;
    L5:
        if (r105 != 2) goto L7;
        this.method = "alipay";
        this.routerCertId = CJRouteOutMonitorUtils.CERT_ID_ALIPAY;
        return;
    L7:
        if (r105 != 3) goto L9;
        this.method = "cmbpay";
        return;
    L9:
        if (r105 != 4) goto L19;
        this.method = "cloudunionpay";
        this.routerCertId = "41489154";
        return;
    }

    public CJPayBaseExecute(Context r100, String r101, JSONObject r102, ICJPayBasisPaymentService.OnPayResultCallback r103, ICJPayBasisPaymentService.OnResultCallback r104, int r105, String r106) {
        this(r100, r101, r102, r103, r104, r105);
        this.mTradeType = r106;
    }
}

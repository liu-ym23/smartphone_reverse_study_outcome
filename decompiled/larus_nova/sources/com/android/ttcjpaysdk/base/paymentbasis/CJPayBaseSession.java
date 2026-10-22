package com.android.ttcjpaysdk.base.paymentbasis;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJPayException;
import com.android.ttcjpaysdk.base.paymentbasis.constants.WXPayType;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public abstract class CJPayBaseSession implements CJPaySession {
    private static final String TAG = "CJPayBaseSession";
    private CJPayCallback mCallback;
    protected ICJPayBasisPaymentService.OnPayResultCallback mOnPayResultCallback;
    private CJPayBaseSessionManager mPayManager;
    protected CJPayRequest mRequest;
    protected String sessionType;
    protected long startTime;

    public abstract void onPayResult(String r100, CJPayCallback r101);

    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPaySession
    public void reportEvent(String r100, String r101) {
    }

    public abstract void sendRequest() throws CJPayException;

    public boolean validateRequest() {
        String r100 = this.sessionType;
        if (r100 != null) goto L5;
    L7:
        CJPayRequest r101 = this.mRequest;
        if (r101 != null) goto L10;
        return false;
    L10:
        if (TextUtils.isEmpty(r101.sign) == true) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r100.equals(WXPayType.MINIAPP.getValue()) == false) goto L7;
        return true;
    }

    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPaySession
    public final void start() throws CJPayException {
        this.startTime = System.currentTimeMillis();
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBaseSession#start", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBaseSession#start", e);
        this.mPayManager.endSession(this);
        throw e;
    L4:
        if (validateRequest() == false) goto L10;
        ICJPayBasisPaymentService.OnPayResultCallback r100 = this.mOnPayResultCallback;     // Catch: CJPayException -> L12
        if (r100 == null) goto L8;
        r100.onPayStart();     // Catch: CJPayException -> L12
    L8:
        sendRequest();     // Catch: CJPayException -> L12
        return;
    L10:
        CJLogger.b(TAG, "start cj_pay_params_error");     // Catch: CJPayException -> L12
        throw new CJPayException(R.string.cj_pay_params_error);     // Catch: CJPayException -> L12
    }

    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPaySession
    public final void notifyResult(String r100) {
        CJPayCallback r101 = this.mCallback;
        if (r101 == null) goto L5;
        onPayResult(r100, r101);
    L5:
        this.mPayManager.endSession(this);
    }

    public CJPayBaseSession(CJPayRequest r100, CJPayCallback r101, CJPayBaseSessionManager r102, ICJPayBasisPaymentService.OnPayResultCallback r103) {
        this.sessionType = "";
        this.mRequest = r100;
        this.mCallback = r101;
        this.mPayManager = r102;
        this.mOnPayResultCallback = r103;
    }
}

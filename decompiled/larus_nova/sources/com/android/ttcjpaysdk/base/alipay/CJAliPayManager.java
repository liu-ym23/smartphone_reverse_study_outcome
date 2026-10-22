package com.android.ttcjpaysdk.base.alipay;

import android.app.Activity;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSessionManager;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayCallback;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayRequest;
import com.android.ttcjpaysdk.base.paymentbasis.CJPaySession;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJPayException;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJUnSupportedException;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public final class CJAliPayManager extends CJPayBaseSessionManager {
    private static CJAliPayManager sInstance;

    public static CJAliPayManager inst() {
        if (sInstance != null) goto L6;
        sInstance = new CJAliPayManager();
    L6:
        return sInstance;
    }

    public CJAliPayManager() {
    }

    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSessionManager
    public void endSession(CJPaySession r100) {
        if (r100 != this.mCurrentSession) goto L6;
        this.mCurrentSession = null;
        return;
    }

    private CJPaySession newSession(Activity r100, CJPayRequest r101, CJPayCallback r110, ICJPayBasisPaymentService.OnPayResultCallback r111) throws CJUnSupportedException {
        this.mCurrentSession = null;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.type != 2) goto L15;
        if (r100 == null) goto L13;
        if (r101.isUseForegroundDetect == false) goto L11;
        this.mCurrentSession = new CJAliPaySessionOpt(r100, r101, r110, inst(), r111);
        goto L13
    L11:
        this.mCurrentSession = new CJAliPaySession(r100, r101, r110, inst(), r111);
    L13:
        return this.mCurrentSession;
    L15:
        throw new CJUnSupportedException();
    }

    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSessionManager
    public CJPaySession newSession(Activity r100, String r101, String r102, CJPayCallback r103, ICJPayBasisPaymentService.OnPayResultCallback r104) throws CJUnSupportedException, CJPayException {
        this.mCurrentSession = null;
        CJPayRequest r105 = CJPayRequest.parse(r102);
        if (r105.isAliParamsEmpty() == true) goto L7;
        return newSession(r100, r105, r103, r104);
    L7:
        throw new CJPayException(R.string.cj_pay_params_empty);
    }
}

package com.android.ttcjpaysdk.base.alipay;

import android.app.Activity;
import android.content.Context;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseExecute;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayCallback;
import com.android.ttcjpaysdk.base.paymentbasis.CJPaySession;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJPayException;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJUnSupportedException;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJAliPayExecute extends CJPayBaseExecute {
    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseExecute
    public CJPaySession getSession(Activity r100, String r101, CJPayCallback r102) throws CJUnSupportedException, CJPayException {
        return CJAliPayManager.inst().newSession(r100, this.mWxAppId, this.mParams.toString(), this.mPayCallback, this.mOnPayResultCallback);
    }

    public CJAliPayExecute(Context r100, String r101, JSONObject r110, ICJPayBasisPaymentService.OnPayResultCallback r111, ICJPayBasisPaymentService.OnResultCallback r112) {
        super(r100, r101, r110, r111, r112, 2);
    }
}

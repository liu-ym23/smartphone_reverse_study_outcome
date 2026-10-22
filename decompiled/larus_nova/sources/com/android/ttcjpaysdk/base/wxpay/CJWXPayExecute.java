package com.android.ttcjpaysdk.base.wxpay;

import android.app.Activity;
import android.content.Context;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseExecute;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayCallback;
import com.android.ttcjpaysdk.base.paymentbasis.CJPaySession;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJPayException;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJUnSupportedException;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJWXUnInstalledException;
import com.android.ttcjpaysdk.base.paymentbasis.constants.WXPayType;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.android.ttcjpaysdk.base.wxpay.miniapp.CJWXMiniAppPayManager;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJWXPayExecute extends CJPayBaseExecute {
    private static final String TAG = "CJWXPayExecute";

    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseExecute
    public CJPaySession getSession(Activity r100, String r101, CJPayCallback r102) throws CJWXUnInstalledException, CJUnSupportedException, CJPayException {
        CJLogger.d(TAG, "getSession mTradeType:" + this.mTradeType);
        String r103 = this.mTradeType;
        if (r103 == null) goto L9;
        if (r103.equals(WXPayType.MINIAPP.getValue()) == false) goto L9;
        return CJWXMiniAppPayManager.inst().newSession(r100, this.mWxAppId, this.mParams.toString(), this.mPayCallback, this.mOnPayResultCallback);
    L9:
        return CJWXPayManager.inst().newSession(r100, this.mWxAppId, this.mParams.toString(), this.mPayCallback, this.mOnPayResultCallback);
    }

    public CJWXPayExecute(Context r100, String r101, JSONObject r110, ICJPayBasisPaymentService.OnPayResultCallback r111, ICJPayBasisPaymentService.OnResultCallback r112) {
        super(r100, r101, r110, r111, r112, 1);
    }

    public CJWXPayExecute(Context r100, String r110, JSONObject r111, ICJPayBasisPaymentService.OnPayResultCallback r112, ICJPayBasisPaymentService.OnResultCallback r113, String r114) {
        super(r100, r110, r111, r112, r113, 1, r114);
    }
}

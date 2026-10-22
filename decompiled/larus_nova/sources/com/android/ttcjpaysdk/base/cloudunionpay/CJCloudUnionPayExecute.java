package com.android.ttcjpaysdk.base.cloudunionpay;

import android.app.Activity;
import android.content.Context;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseExecute;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayCallback;
import com.android.ttcjpaysdk.base.paymentbasis.CJPaySession;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B9\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fBK\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010J(\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/cloudunionpay/CJCloudUnionPayExecute;", "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayBaseExecute;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "wxAppId", "", "params", "Lorg/json/JSONObject;", "onPayResultCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;", "onResultCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnResultCallback;", "(Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnResultCallback;)V", "payType", "", "tradeType", "(Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnResultCallback;ILjava/lang/String;)V", "getSession", "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPaySession;", SocialConstants.PARAM_ACT, "Landroid/app/Activity;", "request", "cb", "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayCallback;", "base-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJCloudUnionPayExecute extends CJPayBaseExecute {
    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseExecute
    public CJPaySession getSession(Activity r100, String r101, CJPayCallback r102) {
        return CJCloudUnionPayManager.INSTANCE.newSession(r100, this.mWxAppId, this.mParams.toString(), this.mPayCallback, this.mOnPayResultCallback);
    }

    public CJCloudUnionPayExecute(Context r100, String r101, JSONObject r110, ICJPayBasisPaymentService.OnPayResultCallback r111, ICJPayBasisPaymentService.OnResultCallback r112) {
        super(r100, r101, r110, r111, r112, 4);
    }

    public CJCloudUnionPayExecute(Context r100, String r101, JSONObject r102, ICJPayBasisPaymentService.OnPayResultCallback r103, ICJPayBasisPaymentService.OnResultCallback r104, int r105, String r106) {
        super(r100, r101, r102, r103, r104, r105, r106);
    }
}

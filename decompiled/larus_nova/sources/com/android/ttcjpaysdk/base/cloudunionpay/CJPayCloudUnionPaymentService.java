package com.android.ttcjpaysdk.base.cloudunionpay;

import android.content.Context;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.paymentbasis.common.ThirdPartyPayLogUtils;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.android.ttcjpaysdk.base.service.ICJPayCloudUnionPaymentService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016JD\u0010\u0012\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/cloudunionpay/CJPayCloudUnionPaymentService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayCloudUnionPaymentService;", "()V", "executePay", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "wxAppId", "", "params", "Lorg/json/JSONObject;", "onPayResultCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnResultCallback;", "getPackageName", "isInstalled", "", "pay", "data", "paytype", "hostInfo", "releasePaySession", "base-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCloudUnionPaymentService implements ICJPayCloudUnionPaymentService {
    @Override // com.android.ttcjpaysdk.base.service.ICJPayService
    public String getPackageName() {
        return "base-pay-cloudunionpay";
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService
    public void releasePaySession() {
        CJCloudUnionPayManager.INSTANCE.releaseCurrentPaySession();
    }

    public CJPayCloudUnionPaymentService() {
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayCloudUnionPaymentService
    public boolean isInstalled(Context r100) {
        return CJCloudUnionPayUtils.INSTANCE.isInstalled(r100);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService
    public void executePay(Context r100, String r101, JSONObject r110, ICJPayBasisPaymentService.OnPayResultCallback r111, ICJPayBasisPaymentService.OnResultCallback r112) {
        new CJCloudUnionPayExecute(r100, r101, r110, r111, r112).executePay();
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService
    public void pay(Context r100, String r101, String r102, ICJPayBasisPaymentService.OnPayResultCallback r110, ICJPayBasisPaymentService.OnResultCallback r111, JSONObject r112) {
        if (r100 != null) goto L4;
    L8:
        ThirdPartyPayLogUtils.Companion.uploadPayResult("alipay", "context is null or data is empty", r110);
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L8;
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        JSONObject r113 = new JSONObject(r101);
        r113.put("sign", "sign");
        r103.put("sdk_info", r113);
        r103.put("pay_way", 4);
        r104.put("data", r103);
        new CJCloudUnionPayExecute(r100, "", r104, r110, r111).executePay();
    }
}

package com.android.ttcjpaysdk.base.cloudunionpay;

import android.app.Activity;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSessionManager;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayCallback;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayRequest;
import com.android.ttcjpaysdk.base.paymentbasis.CJPaySession;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJUnSupportedException;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J<\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/cloudunionpay/CJCloudUnionPayManager;", "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayBaseSessionManager;", "()V", "endSession", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPaySession;", "newSession", SocialConstants.PARAM_ACT, "Landroid/app/Activity;", "mWxAppId", "", "request", "cb", "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayCallback;", "onPayResultCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;", "base-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJCloudUnionPayManager extends CJPayBaseSessionManager {
    public static final CJCloudUnionPayManager INSTANCE = null;

    static {
        INSTANCE = new CJCloudUnionPayManager();
    }

    private CJCloudUnionPayManager() {
    }

    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSessionManager
    public void endSession(CJPaySession r100) {
        if (Intrinsics.areEqual(r100, this.mCurrentSession) == false) goto L6;
        this.mCurrentSession = null;
        return;
    }

    @Override // com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSessionManager
    public CJPaySession newSession(Activity r100, String r101, String r102, CJPayCallback r110, ICJPayBasisPaymentService.OnPayResultCallback r111) {
        this.mCurrentSession = null;
        CJPayRequest r103 = CJPayRequest.parse(r102);
        if (r103.type != 4) goto L9;
        if (r100 == null) goto L7;
        this.mCurrentSession = new CJCloudUnionPaySession(r100, r103, r110, this, r111);
    L7:
        return this.mCurrentSession;
    L9:
        throw new CJUnSupportedException();
    }
}

package com.android.ttcjpaysdk.base.wxpay;

import android.app.Activity;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayCallback;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayLifecycleCallbacks;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayRequest;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.obric.sva.sdk.utils.InteractConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/base/wxpay/CJWXPaySessionOpt;", "Lcom/android/ttcjpaysdk/base/wxpay/CJWXPaySession;", "activity", "Landroid/app/Activity;", "api", "", HiAnalyticsConstant.Direction.REQUEST, "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayRequest;", "cb", "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayCallback;", "pm", "Lcom/android/ttcjpaysdk/base/wxpay/CJWXPayManager;", "onPayResultCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;", InteractConst.WAKEUP_SESSION_TYPE, "", "(Landroid/app/Activity;Ljava/lang/Object;Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayRequest;Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayCallback;Lcom/android/ttcjpaysdk/base/wxpay/CJWXPayManager;Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;Ljava/lang/String;)V", "TAG", "getActivity", "()Landroid/app/Activity;", "hasCallback", "", "lifeCycleCallback", "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayLifecycleCallbacks;", "processPrePay", "", "processWhenCallback", "startLifecycleCallbacks", "stopLifecycleCallbacks", "base-pay-wxpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJWXPaySessionOpt extends CJWXPaySession {
    private final String TAG;
    private final Activity activity;
    private boolean hasCallback;
    private CJPayLifecycleCallbacks lifeCycleCallback;

    private final void stopLifecycleCallbacks() {
        CJLogger.d(this.TAG, "stopLifecycleCallbacks");
        if (this.lifeCycleCallback == null) goto L7;
        Activity r100 = this.activity;
        if (r100 == null) goto L7;
        r100.getApplication().unregisterActivityLifecycleCallbacks(this.lifeCycleCallback);
    L7:
        this.lifeCycleCallback = null;
    }

    @Override // com.android.ttcjpaysdk.base.wxpay.CJWXPaySession
    public void processPrePay() {
        CJLogger.d(this.TAG, "processPrePay");
        Activity r100 = this.activity;
        if (r100 == null) goto L6;
        startLifecycleCallbacks(r100);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.wxpay.CJWXPaySession
    public void processWhenCallback() {
        CJLogger.d(this.TAG, "processWhenCallback");
        this.hasCallback = true;
        stopLifecycleCallbacks();
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public static final /* synthetic */ boolean access$getHasCallback$p(CJWXPaySessionOpt r100) {
        return r100.hasCallback;
    }

    public static final /* synthetic */ ICJPayBasisPaymentService.OnPayResultCallback access$getMOnPayResultCallback$p$s732386909(CJWXPaySessionOpt r100) {
        return r100.mOnPayResultCallback;
    }

    public static final /* synthetic */ String access$getTAG$p(CJWXPaySessionOpt r100) {
        return r100.TAG;
    }

    public static final /* synthetic */ void access$stopLifecycleCallbacks(CJWXPaySessionOpt r100) {
        r100.stopLifecycleCallbacks();
    }

    private final void startLifecycleCallbacks(Activity r100) {
        CJLogger.d(this.TAG, "startLifecycleCallbacks");
        this.lifeCycleCallback = new CJPayLifecycleCallbacks(r100.getClass().getName(), new AnonymousClass1(this));
        r100.getApplication().registerActivityLifecycleCallbacks(this.lifeCycleCallback);
    }

    public CJWXPaySessionOpt(Activity r100, Object r101, CJPayRequest r110, CJPayCallback r111, CJWXPayManager r112, ICJPayBasisPaymentService.OnPayResultCallback r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, HiAnalyticsConstant.Direction.REQUEST);
        Intrinsics.checkNotNullParameter(r112, "pm");
        Intrinsics.checkNotNullParameter(r114, InteractConst.WAKEUP_SESSION_TYPE);
        super(r101, r110, r111, r112, r113, r114);
        this.activity = r100;
        this.TAG = "CJWXPaySessionOpt";
    }
}

package com.android.ttcjpaysdk.base.alipay;

import android.app.Activity;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayCallback;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayLifecycleCallbacks;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayRequest;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/base/alipay/CJAliPaySessionOpt;", "Lcom/android/ttcjpaysdk/base/alipay/CJAliPaySession;", SocialConstants.PARAM_ACT, "Landroid/app/Activity;", HiAnalyticsConstant.Direction.REQUEST, "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayRequest;", "cb", "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayCallback;", "pm", "Lcom/android/ttcjpaysdk/base/alipay/CJAliPayManager;", "onPayResultCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;", "(Landroid/app/Activity;Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayRequest;Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayCallback;Lcom/android/ttcjpaysdk/base/alipay/CJAliPayManager;Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;)V", "getAct", "()Landroid/app/Activity;", "hasCallback", "", "isFirstForeground", "lifeCycleCallback", "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayLifecycleCallbacks;", "processPrePay", "", "processWhenCallback", "startLifecycleCallbacks", "activity", "stopLifecycleCallbacks", "base-pay-alipay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJAliPaySessionOpt extends CJAliPaySession {
    private final Activity act;
    private boolean hasCallback;
    private boolean isFirstForeground;
    private CJPayLifecycleCallbacks lifeCycleCallback;

    @Override // com.android.ttcjpaysdk.base.alipay.CJAliPaySession
    public void processWhenCallback() {
        this.hasCallback = true;
        stopLifecycleCallbacks();
    }

    private final void stopLifecycleCallbacks() {
        if (this.lifeCycleCallback == null) goto L7;
        Activity r100 = this.act;
        if (r100 == null) goto L7;
        r100.getApplication().unregisterActivityLifecycleCallbacks(this.lifeCycleCallback);
    L7:
        this.lifeCycleCallback = null;
    }

    @Override // com.android.ttcjpaysdk.base.alipay.CJAliPaySession
    public void processPrePay() {
        Activity r100 = this.act;
        if (r100 == null) goto L6;
        startLifecycleCallbacks(r100);
        return;
    }

    public final Activity getAct() {
        return this.act;
    }

    public static final /* synthetic */ boolean access$getHasCallback$p(CJAliPaySessionOpt r100) {
        return r100.hasCallback;
    }

    public static final /* synthetic */ ICJPayBasisPaymentService.OnPayResultCallback access$getMOnPayResultCallback$p$s1125377166(CJAliPaySessionOpt r100) {
        return r100.mOnPayResultCallback;
    }

    public static final /* synthetic */ boolean access$isFirstForeground$p(CJAliPaySessionOpt r100) {
        return r100.isFirstForeground;
    }

    public static final /* synthetic */ void access$stopLifecycleCallbacks(CJAliPaySessionOpt r100) {
        r100.stopLifecycleCallbacks();
    }

    private final void startLifecycleCallbacks(Activity r100) {
        this.lifeCycleCallback = new CJPayLifecycleCallbacks(r100.getClass().getName(), new AnonymousClass1(this));
        r100.getApplication().registerActivityLifecycleCallbacks(this.lifeCycleCallback);
    }

    public static final /* synthetic */ void access$setFirstForeground$p(CJAliPaySessionOpt r100, boolean r101) {
        r100.isFirstForeground = r101;
    }

    public CJAliPaySessionOpt(Activity r100, CJPayRequest r101, CJPayCallback r102, CJAliPayManager r103, ICJPayBasisPaymentService.OnPayResultCallback r104) {
        Intrinsics.checkNotNullParameter(r101, HiAnalyticsConstant.Direction.REQUEST);
        Intrinsics.checkNotNullParameter(r103, "pm");
        super(r100, r101, r102, r103, r104);
        this.act = r100;
        this.isFirstForeground = true;
    }
}

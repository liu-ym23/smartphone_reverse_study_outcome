package com.android.ttcjpaysdk.base.wxpay;

import android.app.Activity;
import android.app.Application;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayLifecycleCallbacks;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.android.ttcjpaysdk.base.service.ICJPayH5Service;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u000fH\u0002R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/wxpay/CJWXPayH5Execute;", "", "activity", "Landroid/app/Activity;", "data", "Lorg/json/JSONObject;", "hostInfo", "onPayResultCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;", "(Landroid/app/Activity;Lorg/json/JSONObject;Lorg/json/JSONObject;Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "lifeCycleCallback", "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayLifecycleCallbacks;", "openH5WXMiniApp", "", "openH5WXPay", "unregisterLifecycleCallback", "base-pay-wxpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJWXPayH5Execute {
    private WeakReference<Activity> activityRef;
    private final JSONObject data;
    private final JSONObject hostInfo;
    private CJPayLifecycleCallbacks lifeCycleCallback;
    private final ICJPayBasisPaymentService.OnPayResultCallback onPayResultCallback;

    private final void unregisterLifecycleCallback() {
        Activity r100 = this.activityRef.get();
        if (r100 == null) goto L8;
        Application r101 = r100.getApplication();
        if (r101 == null) goto L9;
        r101.unregisterActivityLifecycleCallbacks(this.lifeCycleCallback);
        return;
    L9:
        return;
    }

    public final void openH5WXMiniApp() {
        ICJPayH5Service r100 = (ICJPayH5Service) CJPayServiceManager.getInstance().getIService(ICJPayH5Service.class);
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.activityRef.get() == null) goto L16;
        Activity r101 = this.activityRef.get();
        if (r101 == null) goto L11;
        Application r102 = r101.getApplication();
        if (r102 == null) goto L11;
        r102.registerActivityLifecycleCallbacks(this.lifeCycleCallback);
    L11:
        r100.openH5ForWXMiniApp(this.activityRef.get(), this.data, this.hostInfo);
        ICJPayBasisPaymentService.OnPayResultCallback r103 = this.onPayResultCallback;
        if (r103 == null) goto L17;
        r103.onEvent("wallet_rd_wx_h5pay_call", "");
        return;
    L17:
        return;
    }

    public final void openH5WXPay() {
        ICJPayH5Service r100 = (ICJPayH5Service) CJPayServiceManager.getInstance().getIService(ICJPayH5Service.class);
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.activityRef.get() == null) goto L16;
        Activity r101 = this.activityRef.get();
        if (r101 == null) goto L11;
        Application r102 = r101.getApplication();
        if (r102 == null) goto L11;
        r102.registerActivityLifecycleCallbacks(this.lifeCycleCallback);
    L11:
        r100.openH5ForWXPay(this.activityRef.get(), this.data, this.hostInfo, ICJPayH5Service.WxH5PayFrom.CJWXPayH5Execute);
        ICJPayBasisPaymentService.OnPayResultCallback r103 = this.onPayResultCallback;
        if (r103 == null) goto L17;
        r103.onEvent("wallet_rd_wx_h5pay_call", "");
        return;
    L17:
        return;
    }

    public static final /* synthetic */ ICJPayBasisPaymentService.OnPayResultCallback access$getOnPayResultCallback$p(CJWXPayH5Execute r100) {
        return r100.onPayResultCallback;
    }

    public static final /* synthetic */ void access$unregisterLifecycleCallback(CJWXPayH5Execute r100) {
        r100.unregisterLifecycleCallback();
    }

    public CJWXPayH5Execute(Activity r100, JSONObject r101, JSONObject r102, ICJPayBasisPaymentService.OnPayResultCallback r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.data = r101;
        this.hostInfo = r102;
        this.onPayResultCallback = r103;
        WeakReference<Activity> r104 = new WeakReference(r100);
        this.activityRef = r104;
        Activity r105 = r104.get();
        if (r105 == null) goto L5;
        String r106 = r105.getClass().getName();
    L6:
        if (r106 != null) goto L8;
        r106 = "";
    L8:
        this.lifeCycleCallback = new CJPayLifecycleCallbacks(r106, new AnonymousClass1(this));
        return;
    L5:
        r106 = null;
        goto L6
    }
}

package com.android.ttcjpaysdk.base.alipay;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayLifecycleCallbacks;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/base/alipay/CJAliPayH5Execute;", "", "activity", "Landroid/app/Activity;", "data", "Lorg/json/JSONObject;", "hostInfo", "onPayResultCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;", "(Landroid/app/Activity;Lorg/json/JSONObject;Lorg/json/JSONObject;Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "lifeCycleCallback", "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayLifecycleCallbacks;", "openH5AliPay", "", "payWithAlipayH5", "Landroid/content/Context;", "unregisterLifecycleCallback", "base-pay-alipay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJAliPayH5Execute {
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

    public final void openH5AliPay() {
        Activity r100 = this.activityRef.get();
        if (r100 == null) goto L8;
        Application r101 = r100.getApplication();
        if (r101 == null) goto L7;
        r101.registerActivityLifecycleCallbacks(this.lifeCycleCallback);
    L7:
        payWithAlipayH5(r100);
    L8:
        ICJPayBasisPaymentService.OnPayResultCallback r102 = this.onPayResultCallback;
        if (r102 == null) goto L12;
        r102.onEvent("wallet_rd_alipay_h5pay_call", "");
        return;
    }

    public static final /* synthetic */ ICJPayBasisPaymentService.OnPayResultCallback access$getOnPayResultCallback$p(CJAliPayH5Execute r100) {
        return r100.onPayResultCallback;
    }

    public static final /* synthetic */ void access$unregisterLifecycleCallback(CJAliPayH5Execute r100) {
        r100.unregisterLifecycleCallback();
    }

    private final void payWithAlipayH5(Context r100) {
        String r101 = JSONObjectProtectorUtils.getString(this.data, "url");     // Catch: Exception -> L7
        Intent r102 = new Intent(r100, AliPayH5Activity.class);     // Catch: Exception -> L7
        r102.putExtra("alipay_h5_url", r101);     // Catch: Exception -> L7
        if ((r100 instanceof Activity) == true) goto L5;
        r102.setFlags(268435456);     // Catch: Exception -> L7
    L5:
        r100.startActivity(r102);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJAliPayH5Execute#payWithAlipayH5", e);
        CJLogger.a("CJPayAliPaymentService", "payWithAlipayH5 error, " + e.getMessage());
    }

    public CJAliPayH5Execute(Activity r100, JSONObject r101, JSONObject r102, ICJPayBasisPaymentService.OnPayResultCallback r103) {
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

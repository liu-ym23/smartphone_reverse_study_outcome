package com.android.ttcjpaysdk.base.wxpay.miniapp;

import android.app.Activity;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayCallback;
import com.android.ttcjpaysdk.base.paymentbasis.CJPayRequest;
import com.android.ttcjpaysdk.base.paymentbasis.CJPaySession;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJPayException;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJUnSupportedException;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJWXUnInstalledException;
import com.android.ttcjpaysdk.base.paymentbasis.constants.WXPayType;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.android.ttcjpaysdk.base.wxpay.CJWXPayManager;
import com.android.ttcjpaysdk.base.wxpay.CJWXPaySession;
import com.android.ttcjpaysdk.base.wxpay.CJWXPaySessionOpt;
import com.bytedance.caijing.sdk.infra.base.api.wxpay.WXPayService;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.larus.nova.R;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J:\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/base/wxpay/miniapp/CJWXMiniAppPayManager;", "Lcom/android/ttcjpaysdk/base/wxpay/CJWXPayManager;", "()V", "TAG", "", "endSession", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPaySession;", "newSession", SocialConstants.PARAM_ACT, "Landroid/app/Activity;", "mWxAppId", "request", "cb", "Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayCallback;", "onPayResultCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;", "reportEvent", "api", "", "Companion", "base-pay-wxpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJWXMiniAppPayManager extends CJWXPayManager {
    public static final Companion Companion = null;
    private static CJWXMiniAppPayManager sInstance;
    private final String TAG;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/wxpay/miniapp/CJWXMiniAppPayManager$Companion;", "", "()V", "sInstance", "Lcom/android/ttcjpaysdk/base/wxpay/miniapp/CJWXMiniAppPayManager;", "inst", "base-pay-wxpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final CJWXMiniAppPayManager inst() {
            if (CJWXMiniAppPayManager.access$getSInstance$cp() != null) goto L5;
            CJWXMiniAppPayManager.access$setSInstance$cp(new CJWXMiniAppPayManager());
        L5:
            CJWXMiniAppPayManager r100 = CJWXMiniAppPayManager.access$getSInstance$cp();
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.android.ttcjpaysdk.base.wxpay.miniapp.CJWXMiniAppPayManager");
            return r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final CJWXMiniAppPayManager inst() {
        return Companion.inst();
    }

    public CJWXMiniAppPayManager() {
        this.TAG = "CJWXMiniAppPayManager";
    }

    public static final /* synthetic */ CJWXMiniAppPayManager access$getSInstance$cp() {
        return sInstance;
    }

    public static final /* synthetic */ void access$setSInstance$cp(CJWXMiniAppPayManager r100) {
        sInstance = r100;
    }

    @Override // com.android.ttcjpaysdk.base.wxpay.CJWXPayManager, com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSessionManager
    public void endSession(CJPaySession r100) {
        CJLogger.d(this.TAG, "endSession");
        if (Intrinsics.areEqual(r100, this.mCurrentSession) == false) goto L6;
        this.mCurrentSession = null;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int] */
    /* JADX WARN: Type inference failed for: r5v9 */
    private final void reportEvent(Object r100, String r101, ICJPayBasisPaymentService.OnPayResultCallback r102) {
        WXPayService r103 = CJWXPayManager.getWxPayService();
        if (r100 == null) goto L5;
        boolean r104 = r103.registerApp(r100, r101);
        String r105 = getWxVersion(r103.getWXAppSupportAPI(r100));
        ?? r106 = r104;
    L6:
        JSONObject r107 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r107, e.f25671s, "wxpay");
        KtSafeMethodExtensionKt.safePut(r107, "status", Integer.valueOf(r106));
        KtSafeMethodExtensionKt.safePut(r107, "is_install", 1);
        KtSafeMethodExtensionKt.safePut(r107, "other_sdk_version", r105);
        if (r102 == null) goto L10;
        r102.onEvent("wallet_register_sdk", r107.toString());
        return;
    L10:
        return;
    L5:
        r106 = 0;
        r105 = "";
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.wxpay.CJWXPayManager, com.android.ttcjpaysdk.base.paymentbasis.CJPayBaseSessionManager
    public CJPaySession newSession(Activity r110, String r111, String r112, CJPayCallback r113, ICJPayBasisPaymentService.OnPayResultCallback r114) {
        Object r100 = null;
        this.mCurrentSession = null;
        CJLogger.d(this.TAG, "mWxAppId:" + r111 + " request:" + r112);
        WXPayService r101 = CJWXPayManager.getWxPayService();
        if (r101 == null) goto L5;
        r100 = r101.getWxApi(r110, r111);
    L5:
        reportEvent(r100, r111, r114);
        CJPayRequest r115 = CJPayRequest.parse(r112);
        if (r115.isWxMiniAppParamsEmpty() == false) goto L8;
        CJLogger.b(this.TAG, "newSession isWxMiniAppParamsEmpty userName:" + r115.userName + ",path:" + r115.path);
        throw new CJPayException(R.string.cj_pay_params_empty);
    L8:
        if (r115.type != 1) goto L20;
        if (r100 != null) goto L11;
    L18:
        CJLogger.b(this.TAG, "newSession wx is uninstalled");
        throw new CJWXUnInstalledException();
    L11:
        if (CJWXPayManager.getWxPayService().isWXAppInstalled(r100) == false) goto L18;
        CJLogger.d(this.TAG, "newSession isUseForegroundDetect:" + r115.isUseForegroundDetect);
        if (r115.isUseForegroundDetect == false) goto L15;
        CJPaySession r116 = new CJWXPaySessionOpt(r110, r100, r115, r113, Companion.inst(), r114, WXPayType.MINIAPP.getValue());
    L16:
        this.mCurrentSession = r116;
        return r116;
    L15:
        r116 = new CJWXPaySession(r100, r115, r113, Companion.inst(), r114, WXPayType.MINIAPP.getValue());
        goto L16
    L20:
        CJLogger.b(this.TAG, "newSession req is null or type:" + Integer.valueOf(r115.type));
        throw new CJUnSupportedException();
    }
}

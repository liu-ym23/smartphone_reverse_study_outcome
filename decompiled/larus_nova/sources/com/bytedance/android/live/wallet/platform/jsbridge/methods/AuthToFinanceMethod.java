package com.bytedance.android.live.wallet.platform.jsbridge.methods;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@XBridgeMethod(biz = "webcast", name = "authCertifiToFinance")
public class AuthToFinanceMethod extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    public static class a {

        @SerializedName("app_id")
        private String appId;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName(BytedCertConstant.CertKey.IDENTITY_CODE)
        private String f102750id;

        @SerializedName("merchant_id")
        private String merchantId;

        @SerializedName(BytedCertConstant.CertKey.IDENTITY_NAME)
        private String name;

        public a() {
        }

        public final String e() {
            return this.appId;
        }

        public final String f() {
            return this.f102750id;
        }

        public final String g() {
            return this.merchantId;
        }

        public final String h() {
            return this.name;
        }

        public static /* synthetic */ String a(a r100) {
            return r100.f102750id;
        }

        public static /* synthetic */ String b(a r100) {
            return r100.name;
        }

        public static /* synthetic */ String c(a r100) {
            return r100.merchantId;
        }

        public static /* synthetic */ String d(a r100) {
            return r100.appId;
        }
    }

    public static /* synthetic */ void j(AuthToFinanceMethod r100, boolean r101) {
        r100.lambda$invoke$0(r101);
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public void onTerminate() {
    }

    public AuthToFinanceMethod() {
    }

    private boolean isValid(a r100) {
        if (r100 != null) goto L4;
    L12:
        return false;
    L4:
        if (TextUtils.isEmpty(a.a(r100)) == true) goto L12;
        if (TextUtils.isEmpty(a.b(r100)) == true) goto L12;
        if (TextUtils.isEmpty(a.c(r100)) == true) goto L12;
        if (TextUtils.isEmpty(a.d(r100)) == true) goto L12;
        return true;
    }

    private /* synthetic */ void lambda$invoke$0(boolean r100) {
        if (r100 == false) goto L5;
        callBack(0, null);
        return;
    L5:
        callBack(2, null);
    }

    private void callBack(int r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("code", 1);     // Catch: Exception -> L8
        r102.put("status_code", r100);     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r101) == true) goto L6;
        r102.put("error_message", r101);     // Catch: Exception -> L8
    L6:
        finishWithResult(r102);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        int r103 = v.f91009a;
        v.e("AuthToFinanceMethod", "jsb call back error occurs  " + e.getMessage());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(a r100, CallContext r101) throws Exception {
        if ((r101.getContext() instanceof Activity) == true) goto L5;
    L9:
        callBack(3, "参数错误");
        return;
    L5:
        if (isValid(r100) == false) goto L9;
        Activity r102 = ContextUtil.contextToActivity(r101.getContext());
        com.bytedance.android.live.recharge.core.f.b(RechargeServices.b()).x(r102, r100, new d(this));
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public /* bridge */ /* synthetic */ void invoke(a r100, CallContext r101) throws Exception {
        invoke2(r100, r101);
    }
}

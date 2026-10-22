package com.android.ttcjpaysdk.bdpay.outer.authorize.model;

import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.framework.mvp.base.MvpLogger;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u000eJ\"\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0003J.\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/outer/authorize/model/CJPayOuterAuthorizeLogger;", "Lcom/android/ttcjpaysdk/base/framework/mvp/base/MvpLogger;", "merchantId", "", "appId", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getMerchantId", "setMerchantId", "authPageClick", "", "buttonName", "authPageShow", "authResult", "result", "errorCode", "errorMsg", "monitorLog", "methodName", "errorMessage", "ext", "bdpay-outer-authorize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayOuterAuthorizeLogger implements MvpLogger {
    private final String TAG;
    private String appId;
    private String merchantId;

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayOuterAuthorizeLogger() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final void authPageShow() {
        JSONObject r100 = CJPayParamsUtils.getCommonLogParams(this.merchantId, this.appId);
        CJPayCallBackCenter.getInstance().onEvent("wallet_tixian_businesstopay_auth_show", new JSONObject[]{r100});
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final void authPageClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        JSONObject r101 = CJPayParamsUtils.getCommonLogParams(this.merchantId, this.appId);
        r101.put("button_name", r100);
        CJPayCallBackCenter.getInstance().onEvent("wallet_tixian_businesstopay_auth_click", new JSONObject[]{r101});
    }

    public final void setAppId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.appId = r100;
    }

    public final void setMerchantId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.merchantId = r100;
    }

    public CJPayOuterAuthorizeLogger(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "merchantId");
        Intrinsics.checkNotNullParameter(r101, "appId");
        this.merchantId = r100;
        this.appId = r101;
        this.TAG = "CJPayOuterAuthorizeActivity";
    }

    public final void authResult(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "errorCode");
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        JSONObject r103 = CJPayParamsUtils.getCommonLogParams(this.merchantId, this.appId);
        r103.put("result", r100);
        r103.put("error_code", r101);
        r103.put("error_message", r102);
        CJPayCallBackCenter.getInstance().onEvent("wallet_businesstopay_auth_result", new JSONObject[]{r103});
    }

    public /* synthetic */ CJPayOuterAuthorizeLogger(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }

    public final void monitorLog(String r100, String r101, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        CJPayCallBackCenter r102 = CJPayCallBackCenter.getInstance();
        String r103 = this.TAG;
        if (r101 != null) goto L5;
        String r104 = "";
    L6:
        if (r111 != null) goto L8;
        String r105 = "";
    L9:
        r102.uploadExceptionLog(r103, r100, r110, r104, r105);
        return;
    L8:
        r105 = r111;
        goto L9
    L5:
        r104 = r101;
        goto L6
    }

    public static /* synthetic */ void authResult$default(CJPayOuterAuthorizeLogger r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = "";
    L8:
        r100.authResult(r101, r102, r103);
    }

    public static /* synthetic */ void monitorLog$default(CJPayOuterAuthorizeLogger r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = "";
    L5:
        r100.monitorLog(r101, r102, r103, r104);
    }
}

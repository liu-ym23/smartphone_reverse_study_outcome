package com.android.ttcjpaysdk.bindcard.base.applog;

import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.framework.mvp.base.MvpLogger;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.bindcard.base.utils.BindCardCommonInfoUtil;
import com.android.ttcjpaysdk.bindcard.base.utils.CJPayBindCardLogUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004J\u001a\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\"\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/applog/VerifyPwdLogger;", "Lcom/android/ttcjpaysdk/base/framework/mvp/base/MvpLogger;", "()V", "appId", "", "commonParams", "Lorg/json/JSONObject;", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "isQuickBind", "", "merchantId", "vouchInfoStr", "forgetPwdClick", "", "initParams", "quickBind", "vr", "logUpload", "event", "extraObj", "pageShow", "pwdInput", "pwdModifyResult", "result", "", "code", "msg", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerifyPwdLogger implements MvpLogger {
    private String appId;
    private JSONObject commonParams;
    private CJPayHostInfo hostInfo;
    private boolean isQuickBind;
    private String merchantId;
    private String vouchInfoStr;

    public VerifyPwdLogger() {
    }

    public final void forgetPwdClick() {
        logUpload("wallet_modify_password_forget_click", null);
    }

    public final void pageShow() {
        logUpload("wallet_modify_password_imp", null);
    }

    public final void pwdInput() {
        logUpload("wallet_modify_password_input", null);
    }

    private final void logUpload(String r100, JSONObject r101) {
        JSONObject r102 = CJPayBindCardLogUtils.getBindCardBizLogParams();
        JSONObject r103 = null;
        if (this.isQuickBind == false) goto L10;
        String r104 = this.vouchInfoStr;     // Catch: JSONException -> L25
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("vouchInfoStr");     // Catch: JSONException -> L25
        r104 = null;
    L8:
        r102.put("activity_info", new JSONArray(r104));     // Catch: JSONException -> L25
    L10:
        if (this.isQuickBind == false) goto L12;
        int r105 = 1;
    L13:
        r102.put("is_onestep", r105);     // Catch: JSONException -> L25
        if (r101 == null) goto L19;
        Iterator<String> r106 = r101.keys();     // Catch: JSONException -> L25
    L17:
        if (r106.hasNext() == false) goto L19;
        String r107 = r106.next();     // Catch: JSONException -> L25
        r102.put(r107, JSONObjectProtectorUtils.getString(r101, r107));     // Catch: JSONException -> L25
    L19:
        JSONObject[] r108 = new JSONObject[2];     // Catch: JSONException -> L25
        JSONObject r109 = this.commonParams;     // Catch: JSONException -> L25
        if (r109 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("commonParams");     // Catch: JSONException -> L25
    L23:
        r108[0] = r103;     // Catch: JSONException -> L25
        r108[1] = r102;     // Catch: JSONException -> L25
        CJPayBindCardLogUtils.doReport(r100, r108);     // Catch: JSONException -> L25
        return;
    L22:
        r103 = r109;
        goto L23
    L12:
        r105 = 0;
    L25:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyPwdLogger#logUpload", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyPwdLogger#logUpload", e);
    }

    public final void initParams(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "vr");
        CJPayHostInfo r102 = BindCardCommonInfoUtil.INSTANCE.getHostInfo();
        this.hostInfo = r102;
        String r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("hostInfo");
        r102 = null;
    L5:
        String r104 = r102.merchantId;
        String r105 = "";
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        this.merchantId = r104;
        CJPayHostInfo r106 = this.hostInfo;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("hostInfo");
        r106 = null;
    L11:
        String r107 = r106.appId;
        if (r107 == null) goto L15;
        r105 = r107;
    L15:
        this.appId = r105;
        String r108 = this.merchantId;
        if (r108 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("merchantId");
        r108 = null;
    L18:
        String r109 = this.appId;
        if (r109 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("appId");
    L22:
        this.commonParams = CJPayParamsUtils.getCommonLogParams(r108, r103);
        this.isQuickBind = r100;
        this.vouchInfoStr = r101;
        return;
    L21:
        r103 = r109;
        goto L22
    }

    public final void pwdModifyResult(int r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("result", r100);     // Catch: JSONException -> L10
        if (r101 == null) goto L6;
        r103.put("error_code", r101);     // Catch: JSONException -> L10
    L6:
        if (r102 == null) goto L8;
        r103.put("error_message", r102);     // Catch: JSONException -> L10
    L8:
        logUpload("wallet_modify_password_result", r103);     // Catch: JSONException -> L10
        return;
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyPwdLogger#pwdModifyResult", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyPwdLogger#pwdModifyResult", e);
    }
}

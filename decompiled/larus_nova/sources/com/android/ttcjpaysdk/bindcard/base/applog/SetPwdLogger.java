package com.android.ttcjpaysdk.bindcard.base.applog;

import android.app.Activity;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.framework.mvp.base.MvpLogger;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPaySmsSignBean;
import com.android.ttcjpaysdk.bindcard.base.utils.BindCardCommonInfoUtil;
import com.android.ttcjpaysdk.bindcard.base.utils.CJPayBindCardLogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u001c\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\nJ\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\nJ\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\nJ\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/applog/SetPwdLogger;", "Lcom/android/ttcjpaysdk/base/framework/mvp/base/MvpLogger;", "()V", "commonParams", "Lorg/json/JSONObject;", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "mSmsSignBean", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPaySmsSignBean;", "initParams", "", "bean", "log", "event", "", "param", "pageShow", "pwdSetInput", "secondPwdCheck", "status", "", "secondPwdClick", "secondPwdSetError", "code", "msg", "secondPwdSetInput", "secondPwdSetSuccess", "secondPwdShow", "setCommonParams", "params", "setSourceForBindCardGift", "wallet_addbcard_page_toast_info", "activity", "Landroid/app/Activity;", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SetPwdLogger implements MvpLogger {
    private JSONObject commonParams;
    private CJPayHostInfo hostInfo;
    private CJPaySmsSignBean mSmsSignBean;

    public SetPwdLogger() {
    }

    public final void pageShow() {
        log$default(this, "wallet_set_password_imp", null, 2, null);
    }

    public final void pwdSetInput() {
        log$default(this, "wallet_set_password_input", null, 2, null);
    }

    public final void secondPwdClick() {
        log$default(this, "wallet_second_password_click", null, 2, null);
    }

    public final void secondPwdSetInput() {
        log$default(this, "wallet_second_password_input", null, 2, null);
    }

    public final void secondPwdSetSuccess() {
        log$default(this, "wallet_second_password_success_toast", null, 2, null);
    }

    public final void secondPwdShow() {
        log$default(this, "wallet_second_password_imp", null, 2, null);
    }

    private final void setCommonParams(JSONObject r100) {
    L26:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("SetPwdLogger#setCommonParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "SetPwdLogger#setCommonParams", e);
        return;
    L4:
        if (this.mSmsSignBean != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mSmsSignBean");     // Catch: Exception -> L26
    L6:
        CJPaySmsSignBean r101 = this.mSmsSignBean;     // Catch: Exception -> L26
        CJPaySmsSignBean r102 = null;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mSmsSignBean");     // Catch: Exception -> L26
        r101 = null;
    L10:
        if (TextUtils.isEmpty(r101.activity_info) == true) goto L16;
        CJPaySmsSignBean r103 = this.mSmsSignBean;     // Catch: Exception -> L26
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mSmsSignBean");     // Catch: Exception -> L26
        r103 = null;
    L14:
        r100.put("activity_info", new JSONArray(r103.activity_info));     // Catch: Exception -> L26
    L16:
        if (this.mSmsSignBean != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mSmsSignBean");     // Catch: Exception -> L26
    L18:
        CJPaySmsSignBean r104 = this.mSmsSignBean;     // Catch: Exception -> L26
        if (r104 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mSmsSignBean");     // Catch: Exception -> L26
    L23:
        if (r102.isUnionPay == false) goto L31;
        CJPayBindCardLogUtils.setAddCardTypeForUnionPay(r100);     // Catch: Exception -> L26
        return;
    L31:
        return;
    L21:
        r102 = r104;
        goto L23
    }

    private final void setSourceForBindCardGift(JSONObject r100) {
        setCommonParams(r100);
        if (TextUtils.isEmpty(CJPayBindCardLogUtils.getSource()) == false) goto L10;
        return;
    L10:
        r100.put("source", CJPayBindCardLogUtils.getSource());     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("SetPwdLogger#setSourceForBindCardGift", e);
        CJBasicCommonUtils.logCatch("CJCatch", "SetPwdLogger#setSourceForBindCardGift", e);
    }

    public final void initParams(CJPaySmsSignBean r100) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        CJPayHostInfo r101 = BindCardCommonInfoUtil.INSTANCE.getHostInfo();
        this.hostInfo = r101;
        this.mSmsSignBean = r100;
        JSONObject r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("hostInfo");
        r101 = null;
    L5:
        String r103 = r101.merchantId;
        String r104 = "";
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        CJPayHostInfo r105 = this.hostInfo;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("hostInfo");
        r105 = null;
    L11:
        String r106 = r105.appId;
        if (r106 == null) goto L15;
        r104 = r106;
    L15:
        JSONObject r107 = CJPayParamsUtils.getCommonLogParams(r103, r104);
        this.commonParams = r107;
        if (r107 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("commonParams");
    L19:
        setSourceForBindCardGift(r102);
        return;
    L18:
        r102 = r107;
        goto L19
    }

    public final void secondPwdCheck(int r100) {
        JSONObject r101 = new JSONObject();
        r101.put("status", r100);
        log("wallet_second_password_check", r101);
    }

    public final void wallet_addbcard_page_toast_info(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        JSONObject r101 = CJPayBindCardLogUtils.getBindCardBizLogParams();
        CJPaySmsSignBean r102 = this.mSmsSignBean;
        CJPaySmsSignBean r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSmsSignBean");
        r102 = null;
    L5:
        r101.put("bank_type", r102.card_info.getCardTypeStr(r100));
        CJPaySmsSignBean r104 = this.mSmsSignBean;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSmsSignBean");
        r104 = null;
    L8:
        r101.put("bank_name", r104.card_info.bank_name);
        CJPaySmsSignBean r105 = this.mSmsSignBean;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSmsSignBean");
    L12:
        r101.put("activity_info", new JSONArray(r103.activity_info));
        log("wallet_addbcard_page_toast_info", r101);
        return;
    L11:
        r103 = r105;
        goto L12
    }

    private final void log(String r100, JSONObject r101) {
        JSONObject r102 = null;
        if (r101 != null) goto L9;
        JSONObject[] r103 = new JSONObject[1];     // Catch: Exception -> L15
        JSONObject r104 = this.commonParams;     // Catch: Exception -> L15
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("commonParams");     // Catch: Exception -> L15
    L8:
        r103[0] = r102;     // Catch: Exception -> L15
        CJPayBindCardLogUtils.doReport(r100, r103);     // Catch: Exception -> L15
        return;
    L7:
        r102 = r104;
        goto L8
    L9:
        JSONObject[] r105 = new JSONObject[2];     // Catch: Exception -> L15
        JSONObject r106 = this.commonParams;     // Catch: Exception -> L15
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("commonParams");     // Catch: Exception -> L15
    L13:
        r105[0] = r102;     // Catch: Exception -> L15
        r105[1] = r101;     // Catch: Exception -> L15
        CJPayBindCardLogUtils.doReport(r100, r105);     // Catch: Exception -> L15
        return;
    L12:
        r102 = r106;
    L15:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("SetPwdLogger#log", e);
        CJBasicCommonUtils.logCatch("CJCatch", "SetPwdLogger#log", e);
    }

    public final void secondPwdSetError(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        JSONObject r102 = new JSONObject();
        r102.put("url", "bytepay.member_product.set_password");
        r102.put("fail_code", r100);
        r102.put("fail_reason", r101);
        log("wallet_second_password_error_info", r102);
    }

    public static /* synthetic */ void log$default(SetPwdLogger r100, String r101, JSONObject r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.log(r101, r102);
    }
}

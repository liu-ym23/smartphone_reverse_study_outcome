package com.android.ttcjpaysdk.bdpay.security.loading.data;

import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.ui.data.CJPaySecurityLoadingStyleInfo;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/security/loading/data/CJPaySecurityLoadingConstant;", "", "()V", "CJ_PAY_SECURITY_DIALOG_LOADING_COUNT_DOWN_BEFORE_TAG", "", "CJ_PAY_SECURITY_DIALOG_LOADING_COUNT_DOWN_NOPWD_COMBINE_BEFORE_TAG", "CJ_PAY_SECURITY_DIALOG_LOADING_COUNT_DOWN_NOPWD_COMBINE_PAY_TAG", "CJ_PAY_SECURITY_DIALOG_LOADING_COUNT_DOWN_NOPWD_COMBINE_PRE_TAG", "CJ_PAY_SECURITY_DIALOG_LOADING_COUNT_DOWN_PAY_TAG", "CJ_PAY_SECURITY_DIALOG_LOADING_COUNT_DOWN_PRE_TAG", "CJ_PAY_SECURITY_LOADING_BREATHE_STYLE", "CJ_PAY_SECURITY_LOADING_CRUDE_STYLE", "CJ_PAY_SECURITY_LOADING_PARAMS_CUSTOM_SCENE", "CJ_PAY_SECURITY_LOADING_PARAMS_FROM_STD", "CJ_PAY_SECURITY_LOADING_PARAMS_INFO", "CJ_PAY_SECURITY_LOADING_PARAMS_IS_PAY_NEW_CARD", "CJ_PAY_SECURITY_LOADING_PARAMS_IS_PWD_FREE_DEGRADE", "CJ_PAY_SECURITY_LOADING_PARAMS_LOADING_STATUS", "CJ_PAY_SECURITY_LOADING_PARAMS_SPECIAL_COPY_WRITING", "CJ_PAY_SECURITY_LOADING_PARAMS_TIME_OUT_MILLISECOND", "CJ_PAY_SECURITY_PANEL_LOADING_COUNT_DOWN_BEFORE_TAG", "CJ_PAY_SECURITY_PANEL_LOADING_COUNT_DOWN_PAY_TAG", "CJ_PAY_SECURITY_PANEL_LOADING_COUNT_DOWN_PRE_TAG", "checkLoadingInfoValid", "Lcom/android/ttcjpaysdk/base/ui/data/CJPaySecurityLoadingStyleInfo;", "loadingInfoStr", "bdpay-security-loading_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySecurityLoadingConstant {
    public static final String CJ_PAY_SECURITY_DIALOG_LOADING_COUNT_DOWN_BEFORE_TAG = "security_dialog_loading_count_down_before_tag";
    public static final String CJ_PAY_SECURITY_DIALOG_LOADING_COUNT_DOWN_NOPWD_COMBINE_BEFORE_TAG = "security_dialog_loading_count_down_nopwd_combine_before_tag";
    public static final String CJ_PAY_SECURITY_DIALOG_LOADING_COUNT_DOWN_NOPWD_COMBINE_PAY_TAG = "security_dialog_loading_NOPWD_COMBINE_count_down_nopwd_combine_pay_tag";
    public static final String CJ_PAY_SECURITY_DIALOG_LOADING_COUNT_DOWN_NOPWD_COMBINE_PRE_TAG = "security_dialog_loading_count_down_nopwd_combine_pre_tag";
    public static final String CJ_PAY_SECURITY_DIALOG_LOADING_COUNT_DOWN_PAY_TAG = "security_dialog_loading_count_down_pay_tag";
    public static final String CJ_PAY_SECURITY_DIALOG_LOADING_COUNT_DOWN_PRE_TAG = "security_dialog_loading_count_down_pre_tag";
    public static final String CJ_PAY_SECURITY_LOADING_BREATHE_STYLE = "breathe";
    public static final String CJ_PAY_SECURITY_LOADING_CRUDE_STYLE = "crude";
    public static final String CJ_PAY_SECURITY_LOADING_PARAMS_CUSTOM_SCENE = "security_loading_custom_scene";
    public static final String CJ_PAY_SECURITY_LOADING_PARAMS_FROM_STD = "security_loading_from_std";
    public static final String CJ_PAY_SECURITY_LOADING_PARAMS_INFO = "security_loading_info";
    public static final String CJ_PAY_SECURITY_LOADING_PARAMS_IS_PAY_NEW_CARD = "security_loading_is_pay_new_card";
    public static final String CJ_PAY_SECURITY_LOADING_PARAMS_IS_PWD_FREE_DEGRADE = "security_loading_is_pwd_free_degrade";
    public static final String CJ_PAY_SECURITY_LOADING_PARAMS_LOADING_STATUS = "security_loading_status";
    public static final String CJ_PAY_SECURITY_LOADING_PARAMS_SPECIAL_COPY_WRITING = "security_loading_special_copy_writing";
    public static final String CJ_PAY_SECURITY_LOADING_PARAMS_TIME_OUT_MILLISECOND = "security_loading_time_out_millisecond";
    public static final String CJ_PAY_SECURITY_PANEL_LOADING_COUNT_DOWN_BEFORE_TAG = "security_panel_loading_count_down_before_tag";
    public static final String CJ_PAY_SECURITY_PANEL_LOADING_COUNT_DOWN_PAY_TAG = "security_panel_loading_count_down_pay_tag";
    public static final String CJ_PAY_SECURITY_PANEL_LOADING_COUNT_DOWN_PRE_TAG = "security_panel_loading_count_down_pre_tag";
    public static final CJPaySecurityLoadingConstant INSTANCE = null;

    static {
        INSTANCE = new CJPaySecurityLoadingConstant();
    }

    private CJPaySecurityLoadingConstant() {
    }

    public final CJPaySecurityLoadingStyleInfo checkLoadingInfoValid(String r100) {
        JSONObject r101 = new JSONObject(r100).optJSONObject("loading_style_info");     // Catch: Exception -> L14
        if (r101 == null) goto L5;
        CJPaySecurityLoadingStyleInfo r102 = (CJPaySecurityLoadingStyleInfo) CJPayJsonParser.fromJson(r101.toString(), CJPaySecurityLoadingStyleInfo.class);     // Catch: Exception -> L14
    L6:
        if (r102 != null) goto L8;
        r102 = new CJPaySecurityLoadingStyleInfo();     // Catch: Exception -> L14
    L8:
        if (Intrinsics.areEqual(CJ_PAY_SECURITY_LOADING_BREATHE_STYLE, r102.loading_style) == true) goto L12;
        r102 = null;
    L12:
        if (r102 != null) goto L20;
        return null;
    L20:
        return r102;
    L5:
        r102 = null;
    L14:
        e = move-exception;
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySecurityLoadingConstant#checkLoadingInfoValid", e);
        return new CJPaySecurityLoadingStyleInfo();
    }
}

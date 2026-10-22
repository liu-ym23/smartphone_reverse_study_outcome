package com.android.ttcjpaysdk.bindcard.base.applog;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.framework.mvp.base.MvpLogger;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayBindCardParamsBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayBusiAuthorizeInfo;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayCardAddBean;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.android.ttcjpaysdk.bindcard.base.utils.BindCardCommonInfoUtil;
import com.android.ttcjpaysdk.bindcard.base.utils.CJPayBindCardLogUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/applog/CJPayBindCardKeepDialogLogger;", "Lcom/android/ttcjpaysdk/base/framework/mvp/base/MvpLogger;", "()V", "clickEvent", "", "showEvent", "uploadBCardInsuranceTitleEvent", "", "event", "discountStr", "btnName", "popType", "buttonStyle", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayBindCardKeepDialogLogger implements MvpLogger {
    public static final CJPayBindCardKeepDialogLogger INSTANCE = null;
    public static final String clickEvent = "wallet_addbcard_keep_pop_click";
    public static final String showEvent = "wallet_addbcard_keep_pop_show";

    static {
        INSTANCE = new CJPayBindCardKeepDialogLogger();
    }

    private CJPayBindCardKeepDialogLogger() {
    }

    @JvmStatic
    public static final void uploadBCardInsuranceTitleEvent(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "discountStr");
        Intrinsics.checkNotNullParameter(r102, "btnName");
        Intrinsics.checkNotNullParameter(r103, "popType");
        Intrinsics.checkNotNullParameter(r104, "buttonStyle");
        BindCardCommonInfoUtil r105 = BindCardCommonInfoUtil.INSTANCE;
        JSONObject r106 = CJPayParamsUtils.getCommonLogParams(r105.getMerchantId(), r105.getAppId());
        r106.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_POP_TYPE, r103);     // Catch: JSONException -> L41
        r106.put(BindCardPayConfirmConstants.Key.ACTIVITY_TITLE, r101);     // Catch: JSONException -> L41
        r106.put("button_style", r104);     // Catch: JSONException -> L41
        if (r102.length() <= 0) goto L6;
        boolean r107 = true;
    L7:
        if (r107 == false) goto L9;
        r106.put("button_name", r102);     // Catch: JSONException -> L41
    L9:
        CJPayCardAddBean r108 = r105.getCardAddBean();     // Catch: JSONException -> L41
        if (r108 == null) goto L38;
        CJPayBindCardParamsBean r109 = r108.url_params;     // Catch: JSONException -> L41
        if (r109 != null) goto L15;
    L25:
        CJPayBusiAuthorizeInfo r110 = r108.busi_authorize_info;     // Catch: JSONException -> L41
        if (r110 == null) goto L33;
        if (r110.is_need_authorize == false) goto L30;
        int r111 = 1;
    L31:
        r106.put("is_auth", r111);     // Catch: JSONException -> L41
        goto L33
    L30:
        r111 = 0;
    L33:
        if (r108.goSetPwd == false) goto L35;
        int r112 = 1;
    L37:
        if (r106.put("haspass", r112) == null) goto L38;
    L39:
        CJPayBindCardLogUtils.doReport(r100, new JSONObject[]{r106});     // Catch: JSONException -> L41
        return;
    L35:
        r112 = 0;
        goto L37
    L15:
        if (r109.isAuth() == false) goto L17;
        int r113 = 0;
    L18:
        r106.put("needidentify", r113);     // Catch: JSONException -> L41
        if (TextUtils.isEmpty(r109.mobile_mask) == true) goto L21;
    L23:
        int r114 = 1;
    L24:
        r106.put("is_showphone", r114);     // Catch: JSONException -> L41
        goto L25
    L21:
        if (TextUtils.isEmpty(r109.uid_mobile_mask) == false) goto L23;
        r114 = 0;
        goto L24
    L17:
        r113 = 1;
    L38:
        r106.put("haspass", 0);     // Catch: JSONException -> L41
        goto L39
    L6:
        r107 = false;
    L41:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBindCardKeepDialogLogger#uploadBCardInsuranceTitleEvent", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBindCardKeepDialogLogger#uploadBCardInsuranceTitleEvent", e);
    }
}

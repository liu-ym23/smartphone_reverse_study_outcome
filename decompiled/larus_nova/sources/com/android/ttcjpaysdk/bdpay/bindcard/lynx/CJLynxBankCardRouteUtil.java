package com.android.ttcjpaysdk.bdpay.bindcard.lynx;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.bindcard.base.utils.BindCardCommonInfoUtil;
import com.android.ttcjpaysdk.ttcjpayapi.IGeneralPay;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/bindcard/lynx/CJLynxBankCardRouteUtil;", "", "()V", "LYNX_MY_BANKCARD_URL", "", "TAG", "routeBankCardActivity", "", "activity", "Landroid/content/Context;", "nativeSchema", "bdpay-bindcard-lynx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJLynxBankCardRouteUtil {
    public static final CJLynxBankCardRouteUtil INSTANCE = null;
    private static final String LYNX_MY_BANKCARD_URL = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fcard_channel_lynx%2Fentry%2Ftemplate.js&hide_loading=1&show_error=1&trans_status_bar=1&hide_nav_bar=1&web_bg_color=transparent&width_percent=100&height_percent=100&open_animate=1&mask_alpha=0.1&gravity=center&mask_click_disable=0&top_level=1&host=aweme&engine_type=new&page_name=my_bank_card";
    public static final String TAG = "CJPayBankCardRouteUtil";

    static {
        INSTANCE = new CJLynxBankCardRouteUtil();
    }

    private CJLynxBankCardRouteUtil() {
    }

    @JvmStatic
    public static final void routeBankCardActivity(Context r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        String r100 = CJPaySettingsManager.getInstance().getLynxSchemaConfig().my_bank_card;
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        r100 = LYNX_MY_BANKCARD_URL;
    L8:
        String r102 = CJPayThemeManager.getInstance().getThemeType();
        Uri.Builder r103 = UriProtector.parse(r100).buildUpon();
        BindCardCommonInfoUtil r104 = BindCardCommonInfoUtil.INSTANCE;
        r103.appendQueryParameter("merchant_id", r104.getMerchantId());
        r103.appendQueryParameter("app_id", r104.getAppId());
        JSONObject r105 = CJPayCallBackCenter.getInstance().getTrackInfo();
        if (r105 == null) goto L12;
        String r106 = r105.toString();
        if (r106 == null) goto L12;
    L13:
        r103.appendQueryParameter("track_info", r106);
        r103.appendQueryParameter("theme", r102);
        if (Intrinsics.areEqual(r102, "light") == false) goto L16;
        String r107 = "black";
    L17:
        r103.appendQueryParameter(AppConstants.BUNDLE_STATUS_BAR_TEXT_COLOR, r107);
        if (r111 != null) goto L20;
    L28:
        String r112 = r103.toString();
        CJLogger.d(TAG, "my bankcard lynx schema is " + r112);
        if ((r110 instanceof Activity) == false) goto L37;
        IGeneralPay r108 = CJPayCallBackCenter.getInstance().getGeneralPay();
        if (r108 == null) goto L46;
        JSONObject r109 = new JSONObject();     // Catch: JSONException -> L34
        r109.put("schema", r112);     // Catch: JSONException -> L34
        r108.pay((Activity) r110, r109.toString(), 98, "", "", "", IGeneralPay.FromNative, CJPayHostInfo.Companion.copy(BindCardCommonInfoUtil.INSTANCE.getHostInfo()), CJLynxBankCardRouteUtil$routeBankCardActivity$1$1.INSTANCE);     // Catch: JSONException -> L34
        return;
    L34:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJLynxBankCardRouteUtil#routeBankCardActivity", e);
        CJLogger.d(TAG, "myBankCardSchema json exception is " + e);
        return;
    L46:
        return;
    L37:
        if (CJPayCallBackCenter.getInstance().getOpenSchemeWithContextInterface() == null) goto L40;
        CJPayCallBackCenter.getInstance().getOpenSchemeWithContextInterface().openScheme(r110, r112);
        return;
    L40:
        if (CJPayCallBackCenter.getInstance().getOpenSchemeInterface() == null) goto L49;
        CJPayCallBackCenter.getInstance().getOpenSchemeInterface().openScheme(r112);
        return;
    L49:
        return;
    L20:
        if ((!StringsKt.isBlank(r111)) == true) goto L23;
        r111 = null;
    L23:
        if (r111 == null) goto L28;
        Uri r113 = UriProtector.parse(r111);
        Iterator<T> r114 = UriProtector.getQueryParameterNames(r113).iterator();
    L26:
        if (r114.hasNext() == false) goto L28;
        String r115 = (String) r114.next();
        r103.appendQueryParameter(r115, UriProtector.getQueryParameter(r113, r115));
        goto L26
    L16:
        r107 = "white";
    L12:
        r106 = new JSONObject().toString();
        goto L13
    L5:
        r101 = false;
        goto L6
    }

    public static /* synthetic */ void routeBankCardActivity$default(Context r100, String r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        routeBankCardActivity(r100, r101);
    }
}

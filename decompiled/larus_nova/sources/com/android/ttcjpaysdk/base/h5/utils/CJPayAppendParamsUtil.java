package com.android.ttcjpaysdk.base.h5.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.statusbar.CJPayImmersedStatusBarUtils;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayAppendParamsUtil {
    public CJPayAppendParamsUtil() {
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_base_h5_utils_CJPayAppendParamsUtil_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static String getStatusHeightWithJson(int r100) {
        Context r101 = CJPayHostInfo.applicationContext;     // Catch: Exception -> L6
        if (r101 == null) goto L12;
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L6
        r102.put("statusbar_height", (int) (CJPayImmersedStatusBarUtils.getStatusBarHeight(r101) / INVOKEVIRTUAL_com_android_ttcjpaysdk_base_h5_utils_CJPayAppendParamsUtil_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101.getResources()).density));     // Catch: Exception -> L6
        return CJPayBasicUtils.getSafeUrlBase64(Base64.encodeToString(r102.toString().getBytes(), 2));
    L12:
        return "";
    L6:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayAppendParamsUtil#getStatusHeightWithJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayAppendParamsUtil#getStatusHeightWithJson", e);
        e.printStackTrace();
        return "";
    }

    public static StringBuilder appendCommonParamsToUrl(String r100, int r101) {
        StringBuilder r102 = new StringBuilder(r100);
        if (r100.contains("?") == true) goto L5;
        String r103 = "?fullpage=";
    L6:
        r102.append(r103);
        r102.append(r101);
        r102.append("&device_info=");
        r102.append(getStatusHeightWithJson(r101));
        return r102;
    L5:
        r103 = "&fullpage=";
        goto L6
    }

    public static String appendParamsForModalWV(String r100, int r101) {
        StringBuilder r102 = new StringBuilder(r100);
        if (TextUtils.isEmpty(r100) == true) goto L20;
        Set<String> r103 = UriProtector.getQueryParameterNames(UriProtector.parse(r100));
        if (r103 != null) goto L7;
    L18:
        r102 = appendCommonParamsToUrl(r100, r101);
        goto L20
    L7:
        if (r103.isEmpty() == true) goto L18;
        if (r103.contains("fullpage") == true) goto L16;
        if (r100.contains("?") == true) goto L13;
        String r104 = "?fullpage=";
    L14:
        r102.append(r104);
        r102.append(r101);
        goto L16
    L13:
        r104 = "&fullpage=";
    L16:
        if (r103.contains("device_info") == true) goto L20;
        r102.append("&device_info=");
        r102.append(getStatusHeightWithJson(r101));
    L20:
        return r102.toString();
    }
}

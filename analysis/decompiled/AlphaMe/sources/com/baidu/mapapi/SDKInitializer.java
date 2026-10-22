package com.baidu.mapapi;

import android.content.Context;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.Initializer;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import java.util.Map;

/* loaded from: classes.dex */
public class SDKInitializer {
    public static final String SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR = "network error";
    public static final String SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR = "permission check error";
    public static final String SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK = "permission check ok";
    public static final String SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE = "error_code";
    public static final String SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE = "error_message";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f5963b;

    /* renamed from: a, reason: collision with root package name */
    private static CoordType f5962a = CoordType.BD09LL;

    /* renamed from: c, reason: collision with root package name */
    private static Map<Object, String> f5964c = null;

    private SDKInitializer() {
    }

    public static boolean getAgreePrivacy() {
        return Initializer.isAgreePrivacyMode();
    }

    public static CommonInfo getCommonInfo() {
        return Initializer.getCommonInfo();
    }

    public static CoordType getCoordType() {
        return f5962a;
    }

    public static boolean getDebugMode() {
        return f5963b;
    }

    public static void initialize(Context context) {
        Initializer.initialize(context, false, null, null, null, null);
    }

    public static boolean isHttpsEnable() {
        return HttpClient.isHttpsEnable;
    }

    public static boolean isInitialized() {
        return Initializer.isInitialized();
    }

    public static void onBackground() {
        Initializer.onBackground();
    }

    public static void onForeground() {
        Initializer.onForeground();
    }

    public static void setAgreePrivacy(Context context, boolean z4) {
        Initializer.setPrivacyMode(context, z4);
    }

    public static void setApiKey(String str) {
        PermissionCheck.setApiKey(str);
    }

    public static void setCommonInfo(CommonInfo commonInfo) {
        Initializer.setCommonInfo(commonInfo);
    }

    public static void setCoordType(CoordType coordType) {
        f5962a = coordType;
    }

    public static void setDebugMode(boolean z4) {
        f5963b = z4;
    }

    public static void setHttpsEnable(boolean z4) {
    }

    public static void unRegisterNetworkCallback() {
        if (Initializer.isInitialized()) {
            com.baidu.platform.comapi.util.NetworkUtil.unregisterNetworkCallback();
        }
    }

    public static void initialize(Context context, ISDKInitializerListener iSDKInitializerListener) {
        Initializer.initialize(context, false, null, null, null, iSDKInitializerListener);
    }

    public static void initialize(String str, Context context) {
        Initializer.initialize(context, false, null, str, null, null);
    }

    public static void initialize(Context context, boolean z4, String str, String str2) {
        Initializer.initialize(context, z4, str, str2, null, null);
    }
}

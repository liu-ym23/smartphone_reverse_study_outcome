package com.baidu.mapapi;

import android.content.Context;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.Initializer;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class SDKInitializer {
    public static final String SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR = "network error";
    public static final String SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR = "permission check error";
    public static final String SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK = "permission check ok";
    public static final String SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE = "error_code";
    public static final String SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE = "error_message";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static CoordType f30504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f30505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<Object, String> f30506c;

    public static void setHttpsEnable(boolean r100) {
    }

    static {
        f30504a = CoordType.BD09LL;
        f30506c = null;
    }

    public static boolean getAgreePrivacy() {
        return Initializer.isAgreePrivacyMode();
    }

    public static CommonInfo getCommonInfo() {
        return Initializer.getCommonInfo();
    }

    public static boolean isInitialized() {
        return Initializer.isInitialized();
    }

    public static void unRegisterNetworkCallback() {
        if (Initializer.isInitialized() == false) goto L6;
        com.baidu.platform.comapi.util.NetworkUtil.unregisterNetworkCallback();
        return;
    }

    private SDKInitializer() {
    }

    public static CoordType getCoordType() {
        return f30504a;
    }

    public static boolean getDebugMode() {
        return f30505b;
    }

    public static boolean isHttpsEnable() {
        return HttpClient.isHttpsEnable;
    }

    public static void onBackground() {
        Initializer.onBackground();
    }

    public static void onForeground() {
        Initializer.onForeground();
    }

    public static void addAuthResultListener(RequestAuthResultListener r100) {
        Initializer.addAuthResultListener(r100);
    }

    public static void initialize(Context r100) {
        Initializer.initialize(r100, false, null, null, null, null);
    }

    public static void removeAuthResultListener(RequestAuthResultListener r100) {
        Initializer.removeAuthResultListener(r100);
    }

    public static void setApiKey(String r100) {
        PermissionCheck.setApiKey(r100);
    }

    public static void setCommonInfo(CommonInfo r100) {
        Initializer.setCommonInfo(r100);
    }

    public static void setCoordType(CoordType r100) {
        f30504a = r100;
    }

    public static void setDebugMode(boolean r100) {
        f30505b = r100;
    }

    public static void initialize(Context r100, ISDKInitializerListener r101) {
        Initializer.initialize(r100, false, null, null, null, r101);
    }

    public static void setAgreePrivacy(Context r100, boolean r101) {
        Initializer.setPrivacyMode(r100, r101);
    }

    public static void initialize(String r100, Context r101) {
        Initializer.initialize(r101, false, null, r100, null, null);
    }

    public static void initialize(Context r100, boolean r101, String r102, String r103) {
        Initializer.initialize(r100, r101, r102, r103, null, null);
    }
}

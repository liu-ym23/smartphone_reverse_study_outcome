package com.obric.matrix.platform.sdk.ones.internal.monitor;

import android.content.Context;
import android.util.Log;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.obric.matrix.platform.sdk.ones.BuildConfig;
import com.obric.matrix.platform.sdk.ones.IMatrixBridge;
import com.obric.matrix.platform.sdk.ones.MatrixOnesSdk;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: SdkMonitorManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0010H\u0002J\u0006\u0010\u001e\u001a\u00020\u001aJ\u0016\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"J&\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/monitor/SdkMonitorManager;", "", "()V", "KEY_APP_VERSION", "", "KEY_CHANNEL", "KEY_DEVICE_ID", "KEY_HOST_ID", "KEY_OVERSEA", "KEY_SDK_NAME", "KEY_SDK_VERSION", "KEY_SDK_VERSION_CODE", "TAG", "VALUE_IS_NOT_OVERSEA", "VALUE_IS_OVERSEA", "isInit", "", "sdkName", "getChannel", "getConfigUrl", "getReportUrl", "getSdkAid", "getSdkVersionCode", "", "getSdkVersionName", "initSDKMonitor", "", "context", "Landroid/content/Context;", "isOverSea", "reportSdkInitSuccess", "sdkMonitorEvent", "eventName", "category", "Lorg/json/JSONObject;", CommonKey.KEY_METRIC, "logExtr", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SdkMonitorManager {
    public static final SdkMonitorManager INSTANCE = null;
    private static final String KEY_APP_VERSION = "app_version";
    private static final String KEY_CHANNEL = "channel";
    private static final String KEY_DEVICE_ID = "device_id";
    private static final String KEY_HOST_ID = "host_aid";
    private static final String KEY_OVERSEA = "oversea";
    private static final String KEY_SDK_NAME = "sdk_name";
    private static final String KEY_SDK_VERSION = "sdk_version";
    private static final String KEY_SDK_VERSION_CODE = "sdk_version_code";
    private static final String TAG = "SdkMonitorManager";
    private static final String VALUE_IS_NOT_OVERSEA = "0";
    private static final String VALUE_IS_OVERSEA = "1";
    private static boolean isInit;
    private static String sdkName;

    /* JADX INFO: renamed from: $r8$lambda$5f4JdWFB-FGuBRPqxO-MQM7WqOE, reason: not valid java name */
    public static /* synthetic */ void m367$r8$lambda$5f4JdWFBFGuBRPqxOMQM7WqOE() {
        m368reportSdkInitSuccess$lambda1();
    }

    private final String getChannel() {
        return "release";
    }

    private final int getSdkVersionCode() {
        return BuildConfig.SDK_VERSION_CODE;
    }

    private final String getSdkVersionName() {
        return BuildConfig.SDK_VERSION_NAME;
    }

    private SdkMonitorManager() {
    }

    public static final /* synthetic */ boolean access$isOverSea(SdkMonitorManager r0) {
        return r0.isOverSea();
    }

    static {
        INSTANCE = new SdkMonitorManager();
        sdkName = "ones_sdk";
    }

    private final String getSdkAid() {
        isOverSea();
        return "568500";
    }

    private final String getConfigUrl() {
        if (isOverSea() == false) goto L5;
        return SdkMonitorConstants.SDK_MONITOR_CONFIG_URL_OVERSEA;
    L5:
        return SdkMonitorConstants.SDK_MONITOR_CONFIG_URL_CN;
    }

    private final String getReportUrl() {
        if (isOverSea() == false) goto L5;
        return SdkMonitorConstants.SDK_MONITOR_REPORT_URL_OVERSEA;
    L5:
        return SdkMonitorConstants.SDK_MONITOR_REPORT_URL_CN;
    }

    public final void initSDKMonitor(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        SDKMonitorUtils.setConfigUrl(getSdkAid(), CollectionsKt.listOf(getConfigUrl()));
        SDKMonitorUtils.setDefaultReportUrl(getSdkAid(), CollectionsKt.listOf(getReportUrl()));
        String r2 = null;
        MLog.d$default(TAG, "sdk aid " + getSdkAid() + " , config url " + getConfigUrl() + " \n , reporturl " + getReportUrl(), null, 4, null);
        JSONObject r0 = new JSONObject();
        IMatrixBridge r4 = MatrixOnesSdk.INSTANCE.getBridge$sdk_platform_ones_release();
        if (r4 == null) goto L5;
        String r5 = r4.did();
    L6:
        MLog.d$default(TAG, "device_id = " + r5, null, 4, null);
        String r6 = r5;
        if (r6 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        if (r7 == false) goto L16;
        isInit = false;
        return;
    L16:
        r0.put("device_id", r5);
        r0.put("sdk_version", getSdkVersionName());
        MLog.d$default(TAG, "sdk version = " + getSdkVersionName(), null, 4, null);
        IMatrixBridge r1 = MatrixOnesSdk.INSTANCE.getBridge$sdk_platform_ones_release();
        if (r1 == null) goto L19;
        String r3 = r1.appId();
    L20:
        r0.put("host_aid", r3);
        IMatrixBridge r8 = MatrixOnesSdk.INSTANCE.getBridge$sdk_platform_ones_release();
        if (r8 == null) goto L23;
        r2 = r8.appVersionCode();
    L23:
        r0.put("app_version", r2);
        r0.put("channel", getChannel());
        SDKMonitorUtils.initMonitor(r9, getSdkAid(), r0, new AnonymousClass1());
        isInit = true;
        return;
    L19:
        r3 = null;
        goto L20
    L9:
        if (r6.length() == 0) goto L12;
        r7 = false;
        goto L13
    L5:
        r5 = null;
        goto L6
    }

    public final void sdkMonitorEvent(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "category");
        sdkMonitorEvent(r3, r4, new JSONObject(), new JSONObject());
    }

    public final void sdkMonitorEvent(String r8, JSONObject r9, JSONObject r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r8, "eventName");
        Intrinsics.checkNotNullParameter(r9, "category");
        Intrinsics.checkNotNullParameter(r10, CommonKey.KEY_METRIC);
        Intrinsics.checkNotNullParameter(r11, "logExtr");
    L24:
        e = move-exception;
        MLog.d$default(TAG, "event report exception " + Log.getStackTraceString(e), null, 4, null);
        return;
    L4:
        if (isInit == true) goto L22;
        IMatrixBridge r5 = MatrixOnesSdk.INSTANCE.getBridge$sdk_platform_ones_release();     // Catch: Exception -> L24
        if (r5 == null) goto L8;
        String r6 = r5.did();     // Catch: Exception -> L24
    L9:
        MLog.d$default(TAG, "on event device_id = " + r6, null, 4, null);     // Catch: Exception -> L24
        String r7 = r6;     // Catch: Exception -> L24
        if (r7 != null) goto L12;
    L15:
        boolean r12 = true;
    L16:
        if (r12 == false) goto L19;
        isInit = false;     // Catch: Exception -> L24
        return;
    L19:
        Context r2 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();     // Catch: Exception -> L24
        if (r2 == null) goto L22;
        INSTANCE.initSDKMonitor(r2);     // Catch: Exception -> L24
        goto L22
    L12:
        if (r7.length() == 0) goto L15;
        r12 = false;
        goto L16
    L8:
        r6 = null;
    L22:
        r9.put(KEY_SDK_VERSION_CODE, getSdkVersionCode());     // Catch: Exception -> L24
        r9.put(KEY_SDK_NAME, sdkName);     // Catch: Exception -> L24
        MLog.d$default(TAG, "event " + r8 + ", category: " + r9 + ", metric " + r10 + ", logExtr " + r11, null, 4, null);     // Catch: Exception -> L24
        SDKMonitorUtils.getInstance(getSdkAid()).monitorEvent(r8, r9, r10, r11);     // Catch: Exception -> L24
    }

    public final void reportSdkInitSuccess() {
        new Thread(new SdkMonitorManager$$ExternalSyntheticLambda0()).start();     // Catch: Exception -> L4
        return;
    }

    /* JADX INFO: renamed from: reportSdkInitSuccess$lambda-1, reason: not valid java name */
    private static final void m368reportSdkInitSuccess$lambda1() {
        Thread.sleep(1000);
        INSTANCE.sdkMonitorEvent("matrix_sdk_init_success", new JSONObject(), new JSONObject(), new JSONObject());
    }

    private final boolean isOverSea() {
        IMatrixBridge r0 = MatrixOnesSdk.INSTANCE.getBridge$sdk_platform_ones_release();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isOverSea();
    }
}

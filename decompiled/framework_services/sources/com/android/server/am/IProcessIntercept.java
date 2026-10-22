package com.android.server.am;

import android.app.IApplicationThread;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.DebugSmtEx;
import android.view.WindowManager;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public interface IProcessIntercept {
    public static final int REASON_ACTIVITY_ALLOW_FOR_APP_WITH_SYSTEM_SIGN = 2;
    public static final int REASON_ACTIVITY_ALLOW_FOR_COMMON_WHITE_SET = 4;
    public static final int REASON_ACTIVITY_ALLOW_FOR_OPS_SETTINGS = 1;
    public static final int REASON_ACTIVITY_ALLOW_FOR_RELATED_TO_DEVICEOWNER = 3;
    public static final int REASON_ACTIVITY_ALLOW_FOR_WHITELIST = 7;
    public static final int REASON_ACTIVITY_NOT_ALLOW_FOR_CAMERA_PREKILL_RESTART = -8;
    public static final int REASON_ACTIVITY_NOT_ALLOW_FOR_SMFLAG_ACTIVITY = -6;
    public static final int REASON_ACTIVITY_NOT_ALLOW_FOR_UNNOTICEABLE_ACTIVITY = -5;
    public static final int REASON_ALLOW_DEFAULT = 0;
    public static final int REASON_BROADCAST_ALLOW_FOR_APP_WITH_SYSTEM_SIGN = 152;
    public static final int REASON_BROADCAST_ALLOW_FOR_COMMON_WHITE_SET = 154;
    public static final int REASON_BROADCAST_ALLOW_FOR_FROM_SYSTEMUI_A = 155;
    public static final int REASON_BROADCAST_ALLOW_FOR_FROM_SYSTEMUI_B = 158;
    public static final int REASON_BROADCAST_ALLOW_FOR_OPS_SETTINGS = 151;
    public static final int REASON_BROADCAST_ALLOW_FOR_RELATED_TO_DEVICEOWNER = 153;
    public static final int REASON_BROADCAST_ALLOW_FOR_RESULT_TO_LAUNCHER = 162;
    public static final int REASON_BROADCAST_ALLOW_FOR_WHITELIST = 161;
    public static final int REASON_BROADCAST_NOT_ALLOW_FOR_3RD_PROCESS_A = -157;
    public static final int REASON_BROADCAST_NOT_ALLOW_FOR_3RD_PROCESS_B = -159;
    public static final int REASON_BROADCAST_NOT_ALLOW_FOR_CAMERA_PREKILL_RESTART = -163;
    public static final int REASON_BROADCAST_NOT_ALLOW_FOR_GMS_RELATED = -160;
    public static final int REASON_BROADCAST_NOT_ALLOW_FOR_USED_TOOMUCH_CPU = -156;
    public static final int REASON_INSTRUMENTATION_ALLOW_FOR_DEFAULT = 202;
    public static final int REASON_INSTRUMENTATION_ALLOW_FOR_WHITELIST = 203;
    public static final int REASON_INSTRUMENTATION_NOT_ALLOW_FOR_ILLEGAL_START = -201;
    public static final int REASON_NOT_ALLOW_DEFAULT = -1;
    public static final int REASON_PROVIDER_ALLOW_FOR_APP_WITH_SYSTEM_SIGN = 53;
    public static final int REASON_PROVIDER_ALLOW_FOR_COMMON_WHITE_SET = 55;
    public static final int REASON_PROVIDER_ALLOW_FOR_OPS_SETTINGS = 51;
    public static final int REASON_PROVIDER_ALLOW_FOR_OVERSEA_VERSION = 52;
    public static final int REASON_PROVIDER_ALLOW_FOR_RELATED_TO_DEVICEOWNER = 54;
    public static final int REASON_PROVIDER_ALLOW_FOR_WHITELIST = 63;
    public static final int REASON_PROVIDER_NOT_ALLOW_FOR_3RD_PARTY_SWITCH = -61;
    public static final int REASON_PROVIDER_NOT_ALLOW_FOR_BLOCKNUMBER = -56;
    public static final int REASON_PROVIDER_NOT_ALLOW_FOR_CAMERA_PREKILL_RESTART = -64;
    public static final int REASON_PROVIDER_NOT_ALLOW_FOR_CONTACTS = -58;
    public static final int REASON_PROVIDER_NOT_ALLOW_FOR_DOCUMENTSUI = -57;
    public static final int REASON_PROVIDER_NOT_ALLOW_FOR_GMS_RELATED = -62;
    public static final int REASON_PROVIDER_NOT_ALLOW_FOR_ILLEGAL_START = -60;
    public static final int REASON_PROVIDER_NOT_ALLOW_FOR_PUSH_PROVIDER = -59;
    public static final int REASON_SERVICE_ALLOW_FOR_APP_WITH_SYSTEM_SIGN = 102;
    public static final int REASON_SERVICE_ALLOW_FOR_COMMON_WHITE_SET = 104;
    public static final int REASON_SERVICE_ALLOW_FOR_FOCUS_CALLING = 107;
    public static final int REASON_SERVICE_ALLOW_FOR_INPUTMETHOD = 105;
    public static final int REASON_SERVICE_ALLOW_FOR_OPS_SETTINGS = 101;
    public static final int REASON_SERVICE_ALLOW_FOR_RELATED_TO_DEVICEOWNER = 103;
    public static final int REASON_SERVICE_ALLOW_FOR_WHITELIST = 114;
    public static final int REASON_SERVICE_NOT_ALLOW_FOR_3RD_PROCESS = 115;
    public static final int REASON_SERVICE_NOT_ALLOW_FOR_APP_BLOCK_ITEM = -110;
    public static final int REASON_SERVICE_NOT_ALLOW_FOR_CAMERA_PREKILL_RESTART = -117;
    public static final int REASON_SERVICE_NOT_ALLOW_FOR_GMS_RELATED = -113;
    public static final int REASON_SERVICE_NOT_ALLOW_FOR_GOODSTART_IN_BG = -108;
    public static final int REASON_SERVICE_NOT_ALLOW_FOR_ILLEGAL_START = -112;
    public static final int REASON_SERVICE_NOT_ALLOW_FOR_JOBSERVICE = -106;
    public static final int REASON_SERVICE_NOT_ALLOW_FOR_PROC_BLOCK_ITEM = -109;
    public static final int REASON_SERVICE_NOT_ALLOW_FOR_SELFRESCUE_ACTION = -116;
    public static final int REASON_SERVICE_NOT_ALLOW_FOR_SYNCADAPTER_OR_NOTILISTENER = -111;
    public static final int SHOW_BROADCAST_INTERCEPT_LOG = 3003;
    public static final int SHOW_INTERCEPT_LOG = 3000;
    public static final int SHOW_PROVIDER_INTERCEPT_LOG = 3001;
    public static final int SHOW_SERVICES_INTERCEPT_LOG = 3002;
    public static final String VPN_SERVICE_OFF = "vpn_service_off";

    default void init(ActivityManagerService ams) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isProviderAllowStart(ProcessRecord caller, ContentProviderRecord cpr, int callingUid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return true;
    }

    default HashSet<String> getPushServiceNames() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default HashSet<String> getPushServiceActions() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default HashSet<String> getPushProviderNames() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default boolean isActivityAllowStart(ActivityInfo activityInfo, String processName, int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return true;
    }

    default boolean isActivityAllowStart(String callingPackage, int callingPid, int callingUid, ActivityInfo activityInfo, Intent intent) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return true;
    }

    default boolean isBroadcastAllowStart(ResolveInfo receiver, BroadcastRecord r) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return true;
    }

    default boolean isServiceAllowStart(ProcessRecord caller, ServiceRecord target, Intent intent, int callingUid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return true;
    }

    default boolean isAllowStartInstrumentation(String packageName, String className, int callingUid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return true;
    }

    default boolean isShowInterceptLog() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return true;
    }

    default void switchInterceptLog() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void switchProviderInterceptLog() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void switchServicesInterceptLog() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void switchBroadcastInterceptLog() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updatePackagesKilledTimeIfNeeded(String packageName, int callingUid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updatePackagesKilledTimeByForceStop(String packageName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setDeviceOwnerUid(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void dispatchBlockedAuthes(IApplicationThread thread, String callerPackage) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void markAppForBecomeVisible(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void activityFinished(ActivityInfo activity) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void isOnePixelWindow(WindowManager.LayoutParams attrs, String title) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}

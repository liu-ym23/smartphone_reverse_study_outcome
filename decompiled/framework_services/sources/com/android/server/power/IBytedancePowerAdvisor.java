package com.android.server.power;

import android.os.DebugSmtEx;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public interface IBytedancePowerAdvisor {
    public static final int NAVIGATION_FGS_TYPE_CATEGORY_NAVIGATION = 2;
    public static final int NAVIGATION_FGS_TYPE_CATEGORY_TRANSPORT = 3;
    public static final int NAVIGATION_FGS_TYPE_GENERIC = 1;
    public static final int NAVIGATION_FGS_TYPE_NONE = 0;

    default void systemReady() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean powerFreezeUseScenes() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void noteIdleMaintenance(int idle, long maintenanceTime, boolean enable) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default HashMap<String, Integer> getTopNPowerPkgs(int type, int topN, int minCurrent, long startTime, long endTime) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return new HashMap();
    }

    default ArrayList<String> getTopPowerPkgs(int topN, int powerMw) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return new ArrayList();
    }

    default boolean isAllowBgPowerHigh(String pkgName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void notifyAppFirstFrame(String pkgName, int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyDisplayEvent(String ownerPackageName, int ownerUid, String displayName, int displayType, boolean isStart) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isBoostLimitForOAutoPkg(String pkgName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void notifyActivityEvent(int userId, String pkgName, String activityName, int event, String extraDisplayInfo) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateRequiredConstraint(int bitKey, boolean add) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyServiceConnEvent(boolean isConnect, int callerPid, String callerProcName, String action, int serviceUid, String servicePkg, String processName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyStatusBarDropStateChanged(boolean expanded) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteGpsChanged(int uid, boolean started) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteNavigationFgsNotificationChanged(int uid, String pkg, String key, int type, boolean active) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default float getCompatScaleFactor(String packageName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return -1.0f;
    }
}

package com.android.server.am;

import android.content.pm.ApplicationInfo;
import android.media.AudioPlaybackConfiguration;
import android.os.Bundle;
import android.os.DebugSmtEx;
import android.os.IBinder;
import android.util.Pair;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.utils.WatchedArrayMap;
import com.android.server.wm.ActivityRecord;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IAppRecordManagerService {
    public static final int EVENT_VD_REMOVE = 0;
    public static final int EVENT_VD_START = 1;

    default void startService(ActivityManagerService ams) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void initAppRecord(PackageManagerService pms, WatchedArrayMap<String, AndroidPackage> packages) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void processDie(int uid, int pid, String reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void CloseToHide(String pkgName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void processStart(ProcessRecord app, int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void removeIsolatedUid(int isolatedUid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addIsolatedUid(int isolatedUid, int appUid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void uidStartCamera(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void uidStopCamera(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void uidStartAudio(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void uidStopAudio(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void uidStartVideo(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void uidStopVideo(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onPlaybackConfigChanged(List<AudioPlaybackConfiguration> configs) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onFocusChanged(int uid, int pid, int displayId, boolean focus) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateVpnPackage(String vpnPackage) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setSystemAppProcState(ProcessRecord pr, int procState) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isSystemAppByPkgName(String pkgName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default int getActivityStartType(ActivityRecord r, boolean prefetchAffected) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default ActivityRecord.WindowStyle getCachedWindowStyle(String packageName, int theme, int userId) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default void cacheWindowStyleForPackage(String packageName, int userId) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void invalidateWindowStyleCache(String packageName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isGameApp(String pkgName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isGameApp(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isMainProcess(int uid, int pid, String procName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isGameApp(ProcessRecord pr) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isGmsApp(String pkgName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isGmsApp(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isGmsApp(ProcessRecord pr) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isNavigationApp(String pkgName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isNavigationApp(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isNavigationApp(ProcessRecord pr) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isSportApp(String pkgName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isVideoApp(String pkgName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isVideoApp(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isVideoApp(ProcessRecord pr) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isIMApp(String pkgName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isIMApp(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isIMApp(ProcessRecord pr) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isEmailApp(String pkgName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void onANRWarning(int pid, int timeoutStage) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default ApplicationInfo getApplicationInfoByPkg(String pkgName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default boolean isAppStackNew(String pkgName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void onMRStateChanged(boolean isMR) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onLocationTrackingStateChanged(boolean isLocationTracking) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onChargingStateChanged(boolean isCharging) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onImmersionChange(int immersiveValue) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateFloatingWindowUids(HashSet<Integer> floatingWindowUids) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateTopResumedComponent(String Component) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default String getProcNameByPid(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return "Unknown";
    }

    default Bundle getLastFocusInfo() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default void uidStartVibrator(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void uidStopVibrator(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteNotification(int uid, String pkg) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default Pair<Integer, Integer> getAppTypeByPkg(String pkgName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default Pair<Integer, Integer> getAppTypeByPid(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default Pair<Integer, Integer> getAppTypeByPr(ProcessRecord pr) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default void fgServiceEvent(ServiceRecord sr, boolean start) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onVirtualDisplayChanged(String ownerPackageName, int ownerUid, String mName, IBinder displayToken, int status) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}

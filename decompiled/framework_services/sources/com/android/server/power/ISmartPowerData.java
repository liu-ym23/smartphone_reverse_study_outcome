package com.android.server.power;

import android.content.Context;
import android.os.DebugSmtEx;
import android.os.WorkSource;
import com.android.server.power.teardown.PowerTeardownResult;
import com.android.server.power.teardown.swteardown.EventTeardownResult;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface ISmartPowerData {
    default void exitPCMode() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void enterPCMode() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void registerPushReceiver(Context context) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void handlePowerScenesData() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void systemReady(Context context) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setScreenBrightness(int brightness) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default String getSubInfo() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return "";
    }

    default void cancelCollectPowerLogLocked(String reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default ArrayList<String> getGpuInfo() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default void setLightsState(int id, int color) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setFlashlightState(boolean isOn) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setVibratorState(int uid, boolean isOn) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteStartGps(int uid, String packageName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteStopGps(int uid, String packageName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void appFrontEvent(int eventType, String packageName, int userId, String extraDisplayInfo) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteStateChanged(String name, int state, int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteSensorStateChange(int uid, int sensor, String type, String pkgName, boolean isStart) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteSyncStateChange(String name, int uid, boolean isStart) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteJobStateChange(String name, int uid, boolean isStart) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteFullWifiLockStateChange(int uid, boolean isStart) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteFullWifiLockStateChange(WorkSource ws, boolean isStart) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteWifiScanStateChange(int uid, boolean isStart) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteWifiScanStateChange(WorkSource ws, boolean isStart) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteWifiRssiChangedLocked(int newRssi) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteBleScanStarted(WorkSource ws, boolean isUnoptimized) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteBleScanStopped(WorkSource ws, boolean isUnoptimized) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteResetBleScan() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteBleConnectChanged(String pkgName, boolean connected) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteWakeupReason(String reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteWakupAlarm(String name, int uid, WorkSource workSource, String tag) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteLongPartialWakelock(String name, String historyName, int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteLongPartialWakelockStartFromSource(String name, String historyName, WorkSource workSource) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteLongPartialWakelockFinish(String name, String historyName, int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteLongPartialWakelockFinishFromSource(String name, String historyName, WorkSource workSource) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updatePowerCloseWifiEnableLocked(boolean isEnable) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void startScreenOffScene() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void enterDeepSleep() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void exitDeepSleep(int quitReason, boolean isShutdown) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addPowerKillInfo(String pkg, int killType, int isKill, int score, String reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void collectSystemLogs(PowerHighMonitor highMonitor) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addSleepModeInfo(int value, String payload) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void dumpAdspActiveMsg(boolean append) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addFirewallInfo(int value, String payload) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addPowerBgNetInfo(int value, String payload) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addLowTempLowPowerInfo(int value, String payload) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addBtSocketPowerInfo(int value, String payload) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addImKeyPrcoPowerInfo(int value, String payload) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addNfCtlApps(long timeStamp, boolean isCtl, String baseInfo, String highReason, String detectReason, String overPowerLevelReason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addPowerHighWarn(long timeStamp, String warnInfo) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addSilentApps(String pkgName, int uid, boolean isScnOn, long duration) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addDouLifePrediction(int batLevel, String params, int scrOnCurrent, int scrOnLife, int dailyCurrent, int dailyLife) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addSysPowerKitInfo(int type, String pkgName, String callingPkgName, int subType, long keepAliveTime, String reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notePowerSceneState(String pkgName, String mainScene, String subScene, int sceneState, String payload) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateAiModelInfo(Map<String, String[]> modelInfo) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default String[] getAllAppPowerList() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default long computePowerSavingModeBatteryTimeRemaining() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return -1;
    }

    default long computeBatteryTimeRemaining() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return -1;
    }

    default void noteVstSceneState(int state) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteImmersionChanged(int immersive) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateWifiState(boolean enable) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteSystemState(String params) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteVideoInfo(String data) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addSmallNetTrafficCount(int uid, int netType) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default PowerTeardownResult getTeardownResult(long start, long end, int batteryLevel, int deviceCurrent) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default long getTeardownTime() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default int getTeardownBatteryLevel() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return -1;
    }

    default void noteGpsSignalQuality(int level, double avgCn0) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default Map<SysEventResult.Type, Map<Object, SysEventResult>> getSysEventResults() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default void notePhoneSignalStrength(int level) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteBatterySaverState(int enable, String payload) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteWakeUpReason(int enable, String payload) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteHighLoadCtrlState(int enable, String payload) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteThermalStatusChanged(int newStatus, int oldStatus) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteThermalStatusCallbackFailed(String eventType, int status, int listenerUid, String listenerPackageName, String error) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean registerMonitorCallback(IMonitorCallback callback) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void unregisterMonitorCallback(IMonitorCallback callback) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteNfcConnect() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteCameraPowerInfo(int modeIndex, int cameraId, String pkg, int openStatus) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteHwCodecPowerInfo(int event, int uid, int pid, String codecName, long duration, int width, int height, int framerate, int lowLatencyMode) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyAppVisible(String packageName, boolean visible) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteScreenTempPolicy(boolean enable, String payload) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void highPowerWarn() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addDynamicResolutionInfo(boolean enable, String packageName, String resolution) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default EventTeardownResult.SubSysStatsInfo getScnOffSubSysSleepInfo() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default EventTeardownResult.SubSysStatsInfo getLatestSubSysSleepInfo() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }
}

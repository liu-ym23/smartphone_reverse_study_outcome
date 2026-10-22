package com.android.server.scene;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.NetworkInfo;
import android.os.Bundle;
import com.android.server.am.ActivityManagerService;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ZteSceneDecisionInternal {
    public abstract void addUseSurfaceViewPkgForSprd(String r1);

    public abstract String getAIPredictSceneResult(String r1, String r2);

    public abstract boolean isAppConnectedWearableDevice(int r1);

    public abstract boolean isDataUsageAnyWay(int r1);

    public abstract boolean isGameApp(String r1);

    public abstract boolean isGpsRunningOrShortPause(int r1, long r2);

    public abstract boolean isHeldStepCounterSensor(int r1);

    public abstract boolean isHeldWakeupSensor(int r1);

    public abstract boolean isInGameLauncher(String r1);

    public abstract boolean isPkgInWindowMode(String r1);

    public abstract boolean isProcConnectedWearableDevice(int r1);

    public abstract boolean isRecentMoving();

    public abstract boolean isSynchronizing(int r1);

    public abstract boolean isTransfering(int r1);

    public abstract boolean isTransfering(String r1);

    public abstract boolean isUploadingOrDownloading(int r1);

    public abstract boolean isWiFiP2PConnectedUid(int r1);

    public abstract void noteActivityStackRemoved(int r1);

    public abstract void noteAppBackground(int r1, String r2, int r3, String r4, long r5, int r7, String... r8);

    public abstract void noteAppForeground(int r1, String r2, String r3, int r4, String r5, int r6, String r7, long r8, boolean r10, Intent r11, String r12, String r13, boolean r14, String r15);

    public abstract void noteAppNotifyActivityResumed(int r1, int r2, int r3, String r4, String r5, int r6, int r7);

    public abstract void noteAppTransitionEnd();

    public abstract void noteAppTransitionStart();

    public abstract void noteChangeWindowingMode(int r1, int r2, int r3, String r4, String r5, int r6, int r7, int r8);

    public abstract void noteConfigurationChanged(Configuration r1);

    public abstract void noteDeviceIdleModeChanged(int r1, int r2);

    public abstract void noteDisplayDeviceEvent(int r1, String r2, String r3, float r4);

    public abstract void noteFocusChangedLw(String r1);

    public abstract void noteFreeFormWindowClose(int r1, int r2, String r3);

    public abstract void noteFreeFormWindowOpen(int r1, int r2, String r3);

    public abstract void noteFreeToFullEvent(int r1, int r2, String r3, String r4);

    public abstract void noteGustureHome();

    public abstract void noteKeyguardGoingAway();

    public abstract void noteMovedToDisplay(Bundle r1);

    public abstract void noteNotificationVisibilityChanged(String r1, boolean r2);

    public abstract void notePausingActivity(int r1, int r2, int r3, String r4, String r5, boolean r6, String r7, String r8, int r9);

    public abstract void notePkgForceStopped(String r1);

    public abstract void noteRemovingProcess(int r1, int r2, String r3, String r4);

    public abstract void noteResumedActivity(int r1, int r2, int r3, String r4, String r5, int r6, String r7, int r8);

    public abstract void noteResumedAppDie(int r1, int r2, String r3, String r4);

    public abstract void noteResumingActivityEvent(int r1, int r2, int r3, String r4, String r5, boolean r6, int r7, String r8, int r9);

    public abstract void noteScreenState(int r1);

    public abstract void noteStartActivity(String r1, String r2);

    public abstract void noteStartAudio(int r1);

    public abstract void noteStartVideo(int r1);

    public abstract void noteStartingProcess(int r1, int r2, String r3, String r4, String r5, String r6);

    public abstract void noteStopAudio(int r1);

    public abstract void noteStopVideo(int r1);

    public abstract void noteStoppingActivity(int r1, int r2, int r3, String r4, String r5, int r6);

    public abstract void noteToggleFreeformWindowingMode(int r1, int r2, int r3, String r4, String r5, String r6, int r7, int r8, int r9, int r10, String r11);

    public abstract void noteUserSwitchEvent(int r1, String r2);

    public abstract void noteVpnAppConnectState(int r1, NetworkInfo.DetailedState r2);

    public abstract void notifyUserOperateState();

    public abstract void registerNightModeStateListener(NightModeStateChangedListener r1);

    public abstract void registerSceneChangeListener(int r1, SceneChangeListener r2);

    public abstract void registerSysInfoChangedListener(SysInfoChangedListener r1);

    public abstract void removeUseSurfaceViewPkgForSprd(String r1);

    public abstract void shutdown();

    public abstract void systemReady(ActivityManagerService r1);

    public abstract void updateAppRunInfoToXml();

    public abstract void updateFromMDM(HashMap<String, String> r1);

    public abstract void updateInputMethodShowState(boolean r1);

    public abstract void updatePowerSaveModeState(boolean r1);

    public ZteSceneDecisionInternal() {
    }
}

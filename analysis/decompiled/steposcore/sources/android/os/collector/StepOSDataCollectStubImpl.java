package android.os.collector;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.media.alwayson.AlwaysOnVoiceManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.collector.config.StepOSAppClassifyConfig;
import android.os.collector.device.StepOSBatteryData;
import android.os.collector.device.StepOSCameraData;
import android.os.collector.device.StepOSCameraLightData;
import android.os.collector.device.StepOSNavigationData;
import android.os.collector.device.StepOSStorageData;
import android.os.collector.device.StepOSTelephoneData;
import android.os.collector.system.StepOSAnrData;
import android.os.collector.system.StepOSAppTagStateData;
import android.os.collector.system.StepOSAudioData;
import android.os.collector.system.StepOSCastData;
import android.os.collector.system.StepOSForegroundAppStateData;
import android.os.collector.system.StepOSMediaData;
import android.os.collector.system.StepOSMediaProjectionData;
import android.os.collector.system.StepOSPowerManagerStateData;
import android.os.collector.system.StepOSWakeLockData;
import android.os.collector.system.StepOSWatchdogData;
import android.os.collector.user.UserDataCollectors;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.util.SparseArray;
import com.android.internal.os.BackgroundThread;
import java.io.File;
import stepos.app.StepOSWindowManager;

/* loaded from: classes.dex */
public class StepOSDataCollectStubImpl implements IStepOSDataCollectStub {
    private static final int CAMERA_STATE_CLOSED = 3;
    private static final int CAMERA_STATE_OPEN = 0;
    private static final long STORAGE_BYTES_PER_GB = 1073741824;
    private static final String STORAGE_MOUNT_STATE_MOUNTED = "MOUNTED";
    private static final String STORAGE_MOUNT_STATE_REMOVED = "REMOVED";
    private static final String STORAGE_MOUNT_STATE_UNKNOWN = "UNKNOWN";
    private static final String STORAGE_MOUNT_STATE_UNMOUNTED = "UNMOUNTED";
    private static final String TAG = StepOSDataCollectStubImpl.class.getSimpleName();
    private final Object mAudioLock = new Object();
    private StepOSAudioData mLastAudioData = null;
    private final SparseArray<String> mActiveMirrorSessions = new SparseArray<>();

    public void onWriteBatteryData(int batteryLevel, int chargeState, int chargeType, float batteryTemperature, int batteryHealth, int remainingBatteryDuration, boolean isLowPowerModeEnabled) {
        StepOSBatteryData mStepOSBatteryData = new StepOSBatteryData(batteryLevel, parseChargeStatus(chargeState), parseChargeType(chargeType), batteryTemperature, parseBatteryHealth(batteryHealth), remainingBatteryDuration, isLowPowerModeEnabled);
        mStepOSBatteryData.write();
    }

    private static String parseChargeStatus(int status) {
        switch (status) {
            case 2:
                return "charging";
            case 3:
                return "discharging";
            case 4:
                return "not_charging";
            case 5:
                return "full";
            default:
                return "unknown";
        }
    }

    private static String parseChargeType(int type) {
        switch (type) {
            case 1:
                return "AC";
            case 2:
                return "USB";
            case 4:
                return "Wireless";
            case 8:
                return "Dock";
            default:
                return "none";
        }
    }

    private static int parseBatteryHealth(int health) {
        switch (health) {
            case 2:
                return 100;
            case 3:
                return 80;
            case 4:
            default:
                return 0;
            case 5:
                return 70;
            case 6:
                return 50;
            case 7:
                return 60;
        }
    }

    public void onCameraSessionStateChanged(String cameraId, final int newState, String clientName) {
        if (newState != 0 && newState != 3) {
            return;
        }
        final String id = cameraId != null ? cameraId : "";
        final String pkg = clientName != null ? clientName : "";
        BackgroundThread.getHandler().post(new Runnable() { // from class: android.os.collector.StepOSDataCollectStubImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                StepOSDataCollectStubImpl.lambda$onCameraSessionStateChanged$0(id, newState, pkg);
            }
        });
    }

    static /* synthetic */ void lambda$onCameraSessionStateChanged$0(String id, int status, String pkg) {
        try {
            new StepOSCameraData(id, status, pkg).write();
        } catch (Exception e) {
            Log.w(TAG, "Failed to write camera occupancy data", e);
        }
    }

    public void onWriteCameraLightData(String cameraId, int lightStatus) {
        StepOSCameraLightData mStepOSCameraLightData = new StepOSCameraLightData(cameraId, lightStatus);
        mStepOSCameraLightData.write();
    }

    public void onWriteTelephonyData(String networkType, String simState, String carrierName, int signalStrength, boolean isRoaming, boolean isDataConnected, boolean isAirplaneModeOn, String callState) {
        StepOSTelephoneData mStepOSTelephoneData = new StepOSTelephoneData(networkType, simState, carrierName, signalStrength, isRoaming, isDataConnected, isAirplaneModeOn, callState);
        mStepOSTelephoneData.write();
    }

    public void onWriteAudioData(int status, String packageName) {
        if (packageName == null || packageName.isEmpty()) {
            return;
        }
        synchronized (this.mAudioLock) {
            if (this.mLastAudioData != null && this.mLastAudioData.mStatus == status && packageName.equals(this.mLastAudioData.mPackage)) {
                return;
            }
            StepOSAudioData newData = new StepOSAudioData(status, packageName);
            this.mLastAudioData = newData;
            newData.write();
        }
    }

    public void onWriteVideoData(int mediaType, int status, int playerId, int deviceId) {
        StepOSMediaData mStepOSMediaData = new StepOSMediaData(mediaType, status, playerId, deviceId);
        mStepOSMediaData.write();
    }

    public void onWriteMediaCastData(boolean isCasting, String name) {
        StepOSCastData mStepOSCastData = new StepOSCastData(isCasting, name);
        mStepOSCastData.write();
    }

    public void onWritePowerManagerData(boolean isInDozeMode, boolean isInAppStandby, boolean dozeModeType, boolean isAppStandbyBucketsEnabled) {
        String str;
        String bgWakeRestriction;
        if (isInDozeMode) {
            str = dozeModeType ? "light_doze" : "deep_doze";
        } else {
            str = "none";
        }
        String dozeType = str;
        long dozeRemainTime = isInDozeMode ? 300L : -1L;
        if (isInDozeMode) {
            bgWakeRestriction = dozeModeType ? AlwaysOnVoiceManager.SCENE_TAG_NORMAL : "strict";
        } else {
            bgWakeRestriction = "relaxed";
        }
        StepOSPowerManagerStateData mStepOSPowerManagerStateData = new StepOSPowerManagerStateData(isInDozeMode, isInAppStandby, dozeType, dozeRemainTime, bgWakeRestriction, isAppStandbyBucketsEnabled, false);
        mStepOSPowerManagerStateData.write();
    }

    public void onWriteAnrData(String processName, String packageName, String reason, String traceFilePath, long timestampMs) {
        StepOSAnrData mStepOSAnrData = new StepOSAnrData(processName, packageName, reason, traceFilePath, timestampMs);
        mStepOSAnrData.write();
    }

    public void onWriteWatchDogData(String subject, long blockedDurationMs, String stackSummary, String logPath, long timestampMs) {
        StepOSWatchdogData mStepOSWatchdogData = new StepOSWatchdogData(subject, blockedDurationMs, stackSummary, logPath, timestampMs);
        mStepOSWatchdogData.write();
    }

    public void onWriteLowStorageData(Context context) {
        long blockSize;
        long internalAvail;
        int internalUsageRate;
        long externalTotal;
        long externalAvail;
        String externalMountState;
        long internalTotal;
        long internalTotal2;
        long appAvail;
        long appAvail2;
        if (context == null) {
            return;
        }
        long internalTotal3 = 0;
        long internalAvail2 = 0;
        int internalUsageRate2 = 0;
        long externalTotal2 = 0;
        long externalAvail2 = 0;
        String externalMountState2 = STORAGE_MOUNT_STATE_UNKNOWN;
        try {
            StatFs internalStatFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockSize2 = internalStatFs.getBlockSizeLong();
            long totalBlocks = internalStatFs.getBlockCountLong();
            long availBlocks = internalStatFs.getAvailableBlocksLong();
            internalTotal3 = (blockSize2 * totalBlocks) / STORAGE_BYTES_PER_GB;
            try {
                internalAvail2 = (blockSize2 * availBlocks) / STORAGE_BYTES_PER_GB;
                if (totalBlocks <= 0) {
                    internalTotal2 = internalTotal3;
                } else {
                    internalTotal2 = internalTotal3;
                    try {
                        internalUsageRate2 = (int) (((totalBlocks - availBlocks) * 100) / totalBlocks);
                    } catch (Exception e) {
                        internalTotal3 = internalTotal2;
                        blockSize = internalTotal3;
                        internalAvail = internalAvail2;
                        internalUsageRate = internalUsageRate2;
                        externalTotal = 0;
                        externalAvail = 0;
                        externalMountState = STORAGE_MOUNT_STATE_UNKNOWN;
                        internalTotal = 0;
                        StepOSStorageData mStepOSStorageData = new StepOSStorageData(blockSize, internalAvail, internalUsageRate, externalTotal, externalAvail, externalMountState, internalTotal);
                        mStepOSStorageData.write();
                    }
                }
                String state = Environment.getExternalStorageState();
                if ("mounted".equals(state)) {
                    try {
                        StatFs ext = new StatFs(Environment.getExternalStorageDirectory().getPath());
                        long extBlock = ext.getBlockSizeLong();
                        externalTotal2 = (ext.getBlockCountLong() * extBlock) / STORAGE_BYTES_PER_GB;
                        long externalAvail3 = (ext.getAvailableBlocksLong() * extBlock) / STORAGE_BYTES_PER_GB;
                        externalMountState2 = STORAGE_MOUNT_STATE_MOUNTED;
                        externalAvail2 = externalAvail3;
                    } catch (Exception e2) {
                        externalMountState2 = STORAGE_MOUNT_STATE_MOUNTED;
                    }
                } else if ("unmounted".equals(state)) {
                    externalMountState2 = STORAGE_MOUNT_STATE_UNMOUNTED;
                } else if ("removed".equals(state)) {
                    externalMountState2 = STORAGE_MOUNT_STATE_REMOVED;
                }
                try {
                    File appDir = context.getFilesDir();
                    if (appDir != null) {
                        StatFs appStat = new StatFs(appDir.getPath());
                        appAvail2 = (appStat.getBlockSizeLong() * appStat.getAvailableBlocksLong()) / STORAGE_BYTES_PER_GB;
                    } else {
                        appAvail2 = internalAvail2;
                    }
                    appAvail = appAvail2;
                } catch (Exception e3) {
                    appAvail = internalAvail2;
                }
                blockSize = internalTotal2;
                internalAvail = internalAvail2;
                internalUsageRate = internalUsageRate2;
                externalTotal = externalTotal2;
                externalAvail = externalAvail2;
                externalMountState = externalMountState2;
                internalTotal = appAvail;
            } catch (Exception e4) {
            }
        } catch (Exception e5) {
        }
        StepOSStorageData mStepOSStorageData2 = new StepOSStorageData(blockSize, internalAvail, internalUsageRate, externalTotal, externalAvail, externalMountState, internalTotal);
        mStepOSStorageData2.write();
    }

    public void onWriteMediaProjectionData(boolean isCasting, String packageName) {
        StepOSMediaProjectionData mStepOSMediaProjectionData = new StepOSMediaProjectionData(isCasting, packageName);
        mStepOSMediaProjectionData.write();
    }

    public void onWriteMirrorSessionData(int displayId, boolean started, String packageName) {
        String pkg;
        synchronized (this.mActiveMirrorSessions) {
            if (started) {
                if (this.mActiveMirrorSessions.indexOfKey(displayId) >= 0) {
                    return;
                }
                pkg = packageName != null ? packageName : "";
                this.mActiveMirrorSessions.put(displayId, pkg);
            } else {
                pkg = this.mActiveMirrorSessions.get(displayId);
                if (pkg == null) {
                    return;
                } else {
                    this.mActiveMirrorSessions.remove(displayId);
                }
            }
            onWriteMediaProjectionData(started, pkg);
        }
    }

    public void onWriteNavigationData(String packageName, int uid, boolean active, boolean isForeground, boolean isMockLocation) {
        StepOSNavigationData data = new StepOSNavigationData(packageName, uid, active, isForeground, isMockLocation);
        data.write();
    }

    public void onWriteForegroundAppStateData(String packageName, boolean enterForeground) {
        int appType = StepOSAppClassifyConfig.getInstance().getAppType(packageName);
        boolean isTopApp = StepOSAppClassifyConfig.getInstance().isTopApp(packageName);
        StepOSForegroundAppStateData data = new StepOSForegroundAppStateData(packageName, enterForeground, appType, isTopApp);
        data.write();
    }

    public void onWriteAppTagStateData(String packageName, int uid, boolean voiceChat, boolean videoChat, boolean cameraLive, boolean voiceChatFloat, boolean videoChatFloat, boolean videoPlayFloat, boolean floatOther) {
        StepOSAppTagStateData data = new StepOSAppTagStateData(packageName, uid, voiceChat, videoChat, cameraLive, voiceChatFloat, videoChatFloat, videoPlayFloat, floatOther);
        data.write();
    }

    public void onWriteClipboardChangeData(String sourcePackage, int sourceUid, ClipData clip) {
        UserDataCollectors.writeIfChanged(sourcePackage, clip);
    }

    public void onWriteAppUsageEvent(int eventType, String packageName, int userId, long timestampMs) throws Throwable {
        switch (eventType) {
            case 1:
                UserDataCollectors.onActivityResumed(packageName, userId, timestampMs);
                break;
            case 15:
                UserDataCollectors.onScreenChanged(true, timestampMs);
                break;
            case 16:
                UserDataCollectors.onScreenChanged(false, timestampMs);
                break;
            case 17:
                UserDataCollectors.onKeyguardChanged(true, timestampMs);
                break;
            case 18:
                UserDataCollectors.onKeyguardChanged(false, timestampMs);
                break;
        }
    }

    public void onWriteNotificationPostedData(StatusBarNotification sbn) {
        UserDataCollectors.onNotificationPosted(sbn);
    }

    public void onWriteForegroundWindowModeChange(String packageName, int uid, int activityType, boolean focusable, long timestampMs) throws Throwable {
        UserDataCollectors.onWindowModeChanged(packageName, uid, activityType, focusable, timestampMs);
    }

    public void onWriteWakeLockData(int uid, String packageName, String tag, final int flags, long timestampMs, final long holdDurationMs) {
        if ((65535 & flags) == 1) {
            return;
        }
        final String pkg = packageName != null ? packageName : "";
        final String lockTag = tag != null ? tag : "";
        BackgroundThread.getExecutor().execute(new Runnable() { // from class: android.os.collector.StepOSDataCollectStubImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                StepOSDataCollectStubImpl.lambda$onWriteWakeLockData$1(pkg, flags, holdDurationMs, lockTag);
            }
        });
    }

    static /* synthetic */ void lambda$onWriteWakeLockData$1(String pkg, int flags, long holdDurationMs, String lockTag) {
        try {
            StepOSWakeLockData data = new StepOSWakeLockData();
            data.mHolderPackageName = pkg;
            data.mWakeLockType = wakeLockTypeToString(flags);
            data.mHoldDuration = holdDurationMs;
            data.write();
            Log.d(TAG, "data: " + data.toString());
        } catch (Throwable t) {
            Log.e(TAG, "onWriteWakeLockData failed pkg=" + pkg + " tag=" + lockTag, t);
        }
    }

    private static String wakeLockTypeToString(int flags) {
        switch (65535 & flags) {
            case 1:
                return "partial";
            case 6:
                return "screen_dim";
            case 10:
                return "screen_bright";
            case StepOSWindowManager.STEPOS_FEATURE_DISABLE_ORIENTATION_EVENT /* 26 */:
                return "full";
            case 32:
                return "proximity_screen_off";
            default:
                return "unknown(0x" + Integer.toHexString(flags) + ")";
        }
    }

    public void onWriteShareData(Intent intent, ClipData clipData, String callerPkg, String targetPkg) {
        UserDataCollectors.onShareData(intent, clipData, callerPkg, targetPkg);
    }

    public void onWriteAlarmClockData(String packageName, long triggerAtMs, long timestampMs) throws Throwable {
        UserDataCollectors.onAlarmClockSet(packageName, triggerAtMs, timestampMs);
    }

    public void onWriteZenModeChangeData(int zenMode, int prevZenMode, String reason, long timestampMs) {
        UserDataCollectors.onZenModeChanged(zenMode, prevZenMode, reason, timestampMs);
    }

    public void onWriteMediaFileData(int fileType, String uri, String fileName, String filePath, long fileSize, String mimeType, String ownerPackage, long createdTimeMs, boolean isFromMediaScan, String scanCallerPackage) {
        UserDataCollectors.onMediaFileInsert(fileType, uri, fileName, filePath, fileSize, mimeType, ownerPackage, createdTimeMs, isFromMediaScan, scanCallerPackage);
    }
}

package com.stepos.powermonitor;

import android.content.Context;
import android.os.RemoteException;
import android.util.Slog;
import java.util.List;

/* loaded from: classes.dex */
public class StepOSPowerMonitorManager {
    public static final String POWER_MONITOR_SERVICE = "stepos.power_monitor";
    private static final String TAG = "StepOSPowerMonitorManager";
    private final Context mContext;
    private final IStepOSPowerMonitorManager mService;

    public StepOSPowerMonitorManager(Context context, IStepOSPowerMonitorManager service) {
        this.mContext = context;
        this.mService = service;
    }

    public List<StepOSAlarmInfo> getAlarmInfo() {
        if (this.mService == null) {
            return null;
        }
        try {
            return this.mService.getAlarmInfo();
        } catch (RemoteException e) {
            Slog.e(TAG, "getAlarmInfo", e);
            return null;
        }
    }

    public List<StepOSAppWakelockInfo> getAppWakelockInfo() {
        if (this.mService == null) {
            return null;
        }
        try {
            return this.mService.getAppWakelockInfo();
        } catch (RemoteException e) {
            Slog.e(TAG, "getAppWakelockInfo", e);
            return null;
        }
    }

    public List<StepOSGpsInfo> getGpsInfo() {
        if (this.mService == null) {
            return null;
        }
        try {
            return this.mService.getGpsInfo();
        } catch (RemoteException e) {
            Slog.e(TAG, "getGpsInfo", e);
            return null;
        }
    }

    public List<StepOSRpmInfo> getRpmRadioInfo() {
        if (this.mService == null) {
            return null;
        }
        try {
            return this.mService.getRpmRadioInfo();
        } catch (RemoteException e) {
            Slog.e(TAG, "getRpmRadioInfo", e);
            return null;
        }
    }

    public List<StepOSKernelWakelockInfo> getKernelWakelockInfo() {
        if (this.mService == null) {
            return null;
        }
        try {
            return this.mService.getKernelWakelockInfo();
        } catch (RemoteException e) {
            Slog.e(TAG, "getKernelWakelockInfo", e);
            return null;
        }
    }

    public List<StepOSKernelWakeupInfo> getKernelWakeupReasonStats() {
        if (this.mService == null) {
            return null;
        }
        try {
            return this.mService.getKernelWakeupReasonStats();
        } catch (RemoteException e) {
            Slog.e(TAG, "getKernelWakeupReasonStats", e);
            return null;
        }
    }

    public StepOSWifiInfo getWifiBatteryStats() {
        if (this.mService == null) {
            return null;
        }
        try {
            return this.mService.getWifiBatteryStats();
        } catch (RemoteException e) {
            Slog.e(TAG, "getWifiBatteryStats", e);
            return null;
        }
    }

    public List<StepOSAudioPlaybackInfo> getAudioPlaybackInfo() {
        if (this.mService == null) {
            return null;
        }
        try {
            return this.mService.getAudioPlaybackInfo();
        } catch (RemoteException e) {
            Slog.e(TAG, "getAudioPlaybackInfo", e);
            return null;
        }
    }

    public List<StepOSAudioRecorderInfo> getAudioRecorderInfo() {
        if (this.mService == null) {
            return null;
        }
        try {
            return this.mService.getAudioRecorderInfo();
        } catch (RemoteException e) {
            Slog.e(TAG, "getAudioRecorderInfo", e);
            return null;
        }
    }

    public List<StepOSJobExecutionInfo> getJobExecutionInfo() {
        if (this.mService == null) {
            return null;
        }
        try {
            return this.mService.getJobExecutionInfo();
        } catch (RemoteException e) {
            Slog.e(TAG, "getJobExecutionInfo", e);
            return null;
        }
    }

    public List<StepOSTrafficInfo> getTrafficInfo() {
        if (this.mService == null) {
            return null;
        }
        try {
            return this.mService.getTrafficInfo();
        } catch (RemoteException e) {
            Slog.e(TAG, "getTrafficInfo", e);
            return null;
        }
    }

    public StepOSDisplayMonitorInfo getDisplayMonitorInfo() {
        if (this.mService == null) {
            return null;
        }
        try {
            return this.mService.getDisplayMonitorInfo();
        } catch (RemoteException e) {
            Slog.e(TAG, "getDisplayMonitorInfo", e);
            return null;
        }
    }

    public void clearDisplayMonitor() {
        clearDisplayMonitor(0L);
    }

    public void clearDisplayMonitor(long consumedSnapshotWallMs) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.clearDisplayMonitor(consumedSnapshotWallMs);
        } catch (RemoteException e) {
            Slog.e(TAG, "clearDisplayMonitor", e);
        }
    }

    public void stopMonitor() {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.stopMonitor();
        } catch (RemoteException e) {
            Slog.e(TAG, "stopMonitor", e);
        }
    }
}

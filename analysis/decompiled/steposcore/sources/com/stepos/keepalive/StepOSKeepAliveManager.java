package com.stepos.keepalive;

import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import stepos.app.IStepOSActivityManager;

/* loaded from: classes.dex */
public class StepOSKeepAliveManager {
    public static final int ENABLE_ALIVE = 1;
    public static final int ENABLE_PERF = 2;
    private static final int MAX_TEMP_KEEP_ALIVE_TIME_MS = 7200000;
    private static final String TAG = "StepOSKeepAliveManager";
    private final IStepOSActivityManager mService;

    private static final class InstanceHolder {
        private static final StepOSKeepAliveManager INSTANCE = new StepOSKeepAliveManager();

        private InstanceHolder() {
        }
    }

    public static StepOSKeepAliveManager get() {
        StepOSKeepAliveManager manager = InstanceHolder.INSTANCE;
        if (manager.mService == null) {
            throw new IllegalStateException("StepOSActivityManager service is unavailable");
        }
        return manager;
    }

    private StepOSKeepAliveManager() {
        IStepOSActivityManager service = null;
        try {
            IBinder binder = ServiceManager.getService("activity");
            if (binder != null) {
                IBinder extension = binder.getExtension();
                service = IStepOSActivityManager.Stub.asInterface(extension);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get AMS extension", e);
        }
        this.mService = service;
    }

    public boolean setProcessTempKeepAlive(String processName, int keepAliveFlag, int maxTime) {
        Log.i(TAG, "setProcessTempKeepAlive: callingPid=" + Binder.getCallingPid() + ", callingUid=" + Binder.getCallingUid() + ", processName=" + processName + ", keepAliveFlag=" + keepAliveFlag + ", maxTime=" + maxTime);
        if (processName == null || processName.isEmpty()) {
            throw new IllegalArgumentException("processName must not be null or empty");
        }
        if (keepAliveFlag != 1 && keepAliveFlag != 2) {
            throw new IllegalArgumentException("keepAliveFlag is invalid: " + keepAliveFlag);
        }
        if (maxTime > MAX_TEMP_KEEP_ALIVE_TIME_MS) {
            throw new IllegalArgumentException("maxTime exceeds limit: " + maxTime + ", max allowed: " + MAX_TEMP_KEEP_ALIVE_TIME_MS);
        }
        if (this.mService == null) {
            Log.w(TAG, "setProcessTempKeepAlive: service not available");
            return false;
        }
        try {
            this.mService.setProcessTempKeepAlive(processName, keepAliveFlag, maxTime);
            Log.i(TAG, "setProcessTempKeepAlive: success");
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "setProcessTempKeepAlive: remote call failed", e);
            return false;
        }
    }

    public boolean endProcessTempKeepAlive(String processName, int keepAliveFlag) {
        Log.i(TAG, "endProcessTempKeepAlive: callingPid=" + Binder.getCallingPid() + ", callingUid=" + Binder.getCallingUid() + ", processName=" + processName + ", keepAliveFlag=" + keepAliveFlag);
        if (processName == null || processName.isEmpty()) {
            throw new IllegalArgumentException("processName must not be null or empty");
        }
        if (keepAliveFlag != 1 && keepAliveFlag != 2) {
            throw new IllegalArgumentException("keepAliveFlag is invalid: " + keepAliveFlag);
        }
        if (this.mService == null) {
            Log.w(TAG, "endProcessTempKeepAlive: service not available");
            return false;
        }
        try {
            this.mService.endProcessTempKeepAlive(processName, keepAliveFlag);
            Log.i(TAG, "endProcessTempKeepAlive: success");
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "endProcessTempKeepAlive: remote call failed", e);
            return false;
        }
    }
}

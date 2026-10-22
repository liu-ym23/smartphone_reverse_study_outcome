package com.stepos.exserviceui;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes.dex */
public class StepOSExServiceUiManager {
    public static final String SERVICE_NAME = "stepos_exserviceui";
    private static final String TAG = "StepOSExServiceUiManager";
    private final Context mContext;
    private final IStepOSExServiceUiManager mService;

    public StepOSExServiceUiManager(Context context, IStepOSExServiceUiManager service) {
        this.mContext = context.getApplicationContext();
        this.mService = service;
    }

    public boolean isServiceAvailable() {
        return this.mService != null;
    }

    public boolean registerCallback(String packageName, IExServiceUiCallback callback) {
        if (this.mService == null || callback == null) {
            Log.w(TAG, "registerCallback: service unavailable or callback null");
            return false;
        }
        try {
            return this.mService.registerCallback(packageName, callback);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean unregisterCallback(String packageName, IExServiceUiCallback callback) {
        if (this.mService == null || callback == null) {
            return false;
        }
        try {
            return this.mService.unregisterCallback(packageName, callback);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean reportUserAction(long eventId, int action) {
        if (this.mService == null) {
            Log.w(TAG, "reportUserAction: service unavailable");
            return false;
        }
        try {
            this.mService.reportUserAction(eventId, action);
            return true;
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }
}

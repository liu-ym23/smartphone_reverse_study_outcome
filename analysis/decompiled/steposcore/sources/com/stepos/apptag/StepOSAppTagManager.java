package com.stepos.apptag;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes.dex */
public class StepOSAppTagManager {
    public static final String SERVICE_NAME = "stepos_apptag";
    private static final String TAG = "StepOSAppTagManager";
    private final Context mContext;
    private final IStepOSAppTagManager mService;

    public StepOSAppTagManager(Context context, IStepOSAppTagManager service) {
        this.mContext = context;
        this.mService = service;
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getAppTagByUid(int uid) {
        try {
            return this.mService.getAppTagByUid(uid);
        } catch (RemoteException e) {
            Log.e(TAG, "getAppTagByUid failed", e);
            return 0;
        }
    }

    public int getAppTagByPackage(String packageName) {
        try {
            return this.mService.getAppTagByPackage(packageName);
        } catch (RemoteException e) {
            Log.e(TAG, "getAppTagByPackage failed", e);
            return 0;
        }
    }

    public int getAppTagByPid(int pid) {
        try {
            return this.mService.getAppTagByPid(pid);
        } catch (RemoteException e) {
            Log.e(TAG, "getAppTagByPid failed", e);
            return 0;
        }
    }

    public boolean isUidWakingState(int uid) {
        try {
            return this.mService.isUidWakingState(uid);
        } catch (RemoteException e) {
            Log.e(TAG, "isUidWakingState failed", e);
            return false;
        }
    }
}

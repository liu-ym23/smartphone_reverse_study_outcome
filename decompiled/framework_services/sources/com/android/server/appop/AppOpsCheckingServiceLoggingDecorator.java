package com.android.server.appop;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes.dex */
public class AppOpsCheckingServiceLoggingDecorator implements AppOpsCheckingServiceInterface {
    private static final String LOG_TAG = null;
    private final AppOpsCheckingServiceInterface mService;

    static {
        LOG_TAG = AppOpsCheckingServiceLoggingDecorator.class.getSimpleName();
    }

    public AppOpsCheckingServiceLoggingDecorator(AppOpsCheckingServiceInterface service) {
        this.mService = service;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void writeState() {
        Log.i(LOG_TAG, "writeState()");
        this.mService.writeState();
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void readState() {
        Log.i(LOG_TAG, "readState()");
        this.mService.readState();
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void shutdown() {
        Log.i(LOG_TAG, "shutdown()");
        this.mService.shutdown();
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void systemReady() {
        Log.i(LOG_TAG, "systemReady()");
        this.mService.systemReady();
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseIntArray getNonDefaultUidModes(int uid, String persistentDeviceId) {
        Log.i(LOG_TAG, "getNonDefaultUidModes(uid = " + uid + ")");
        return this.mService.getNonDefaultUidModes(uid, persistentDeviceId);
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseIntArray getNonDefaultPackageModes(String packageName, int userId) {
        Log.i(LOG_TAG, "getNonDefaultPackageModes(packageName = " + packageName + ", userId = " + userId + ") ");
        return this.mService.getNonDefaultPackageModes(packageName, userId);
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public int getUidMode(int uid, String persistentDeviceId, int op) {
        Log.i(LOG_TAG, "getUidMode(uid = " + uid + ", op = " + op + ")");
        return this.mService.getUidMode(uid, persistentDeviceId, op);
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean setUidMode(int uid, String persistentDeviceId, int op, int mode) {
        Log.i(LOG_TAG, "setUidMode(uid = " + uid + ", op = " + op + ", mode = " + mode + ")");
        return this.mService.setUidMode(uid, persistentDeviceId, op, mode);
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public int getPackageMode(String packageName, int op, int userId) {
        Log.i(LOG_TAG, "getPackageMode(packageName = " + packageName + ", op = " + op + ", userId = " + userId + ")");
        return this.mService.getPackageMode(packageName, op, userId);
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void setPackageMode(String packageName, int op, int mode, int userId) {
        Log.i(LOG_TAG, "setPackageMode(packageName = " + packageName + ", op = " + op + ", mode = " + mode + ", userId = " + userId + ")");
        this.mService.setPackageMode(packageName, op, mode, userId);
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean removePackage(String packageName, int userId) {
        Log.i(LOG_TAG, "removePackage(packageName = " + packageName + ", userId = " + userId + ")");
        return this.mService.removePackage(packageName, userId);
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void removeUid(int uid) {
        Log.i(LOG_TAG, "removeUid(uid = " + uid + ")");
        this.mService.removeUid(uid);
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void clearAllModes() {
        Log.i(LOG_TAG, "clearAllModes()");
        this.mService.clearAllModes();
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseBooleanArray getForegroundOps(int uid, String persistentDeviceId) {
        Log.i(LOG_TAG, "getForegroundOps(uid = " + uid + ")");
        return this.mService.getForegroundOps(uid, persistentDeviceId);
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseBooleanArray getForegroundOps(String packageName, int userId) {
        Log.i(LOG_TAG, "getForegroundOps(packageName = " + packageName + ", userId = " + userId + ")");
        return this.mService.getForegroundOps(packageName, userId);
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean addAppOpsModeChangedListener(AppOpsCheckingServiceInterface.AppOpsModeChangedListener listener) {
        Log.i(LOG_TAG, "addAppOpsModeChangedListener(listener = " + listener + ")");
        return this.mService.addAppOpsModeChangedListener(listener);
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean removeAppOpsModeChangedListener(AppOpsCheckingServiceInterface.AppOpsModeChangedListener listener) {
        Log.i(LOG_TAG, "removeAppOpsModeChangedListener(listener = " + listener + ")");
        return this.mService.removeAppOpsModeChangedListener(listener);
    }
}

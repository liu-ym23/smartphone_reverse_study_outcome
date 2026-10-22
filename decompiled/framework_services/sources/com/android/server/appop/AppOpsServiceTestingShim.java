package com.android.server.appop;

import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class AppOpsServiceTestingShim implements AppOpsCheckingServiceInterface {
    private AppOpsCheckingServiceInterface mNewImplementation;
    private AppOpsCheckingServiceInterface mOldImplementation;

    public AppOpsServiceTestingShim(AppOpsCheckingServiceInterface oldValImpl, AppOpsCheckingServiceInterface newImpl) {
        this.mOldImplementation = oldValImpl;
        this.mNewImplementation = newImpl;
    }

    private void signalImplDifference(String message) {
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void writeState() {
        this.mOldImplementation.writeState();
        this.mNewImplementation.writeState();
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void readState() {
        this.mOldImplementation.readState();
        this.mNewImplementation.readState();
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void shutdown() {
        this.mOldImplementation.shutdown();
        this.mNewImplementation.shutdown();
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void systemReady() {
        this.mOldImplementation.systemReady();
        this.mNewImplementation.systemReady();
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseIntArray getNonDefaultUidModes(int uid, String persistentDeviceId) {
        SparseIntArray oldVal = this.mOldImplementation.getNonDefaultUidModes(uid, persistentDeviceId);
        SparseIntArray newVal = this.mNewImplementation.getNonDefaultUidModes(uid, persistentDeviceId);
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getNonDefaultUidModes");
    L5:
        return newVal;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseIntArray getNonDefaultPackageModes(String packageName, int userId) {
        SparseIntArray oldVal = this.mOldImplementation.getNonDefaultPackageModes(packageName, userId);
        SparseIntArray newVal = this.mNewImplementation.getNonDefaultPackageModes(packageName, userId);
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getNonDefaultPackageModes");
    L5:
        return newVal;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public int getUidMode(int uid, String persistentDeviceId, int op) {
        int oldVal = this.mOldImplementation.getUidMode(uid, persistentDeviceId, op);
        int newVal = this.mNewImplementation.getUidMode(uid, persistentDeviceId, op);
        if (oldVal == newVal) goto L5;
        signalImplDifference("getUidMode");
    L5:
        return newVal;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean setUidMode(int uid, String persistentDeviceId, int op, int mode) {
        boolean oldVal = this.mOldImplementation.setUidMode(uid, persistentDeviceId, op, mode);
        boolean newVal = this.mNewImplementation.setUidMode(uid, persistentDeviceId, op, mode);
        if (oldVal == newVal) goto L5;
        signalImplDifference("setUidMode");
    L5:
        return newVal;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public int getPackageMode(String packageName, int op, int userId) {
        int oldVal = this.mOldImplementation.getPackageMode(packageName, op, userId);
        int newVal = this.mNewImplementation.getPackageMode(packageName, op, userId);
        if (oldVal == newVal) goto L5;
        signalImplDifference("getPackageMode");
    L5:
        return newVal;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void setPackageMode(String packageName, int op, int mode, int userId) {
        this.mOldImplementation.setPackageMode(packageName, op, mode, userId);
        this.mNewImplementation.setPackageMode(packageName, op, mode, userId);
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean removePackage(String packageName, int userId) {
        boolean oldVal = this.mOldImplementation.removePackage(packageName, userId);
        boolean newVal = this.mNewImplementation.removePackage(packageName, userId);
        if (oldVal == newVal) goto L5;
        signalImplDifference("removePackage");
    L5:
        return newVal;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void removeUid(int uid) {
        this.mOldImplementation.removeUid(uid);
        this.mNewImplementation.removeUid(uid);
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void clearAllModes() {
        this.mOldImplementation.clearAllModes();
        this.mNewImplementation.clearAllModes();
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseBooleanArray getForegroundOps(int uid, String persistentDeviceId) {
        SparseBooleanArray oldVal = this.mOldImplementation.getForegroundOps(uid, persistentDeviceId);
        SparseBooleanArray newVal = this.mNewImplementation.getForegroundOps(uid, persistentDeviceId);
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getForegroundOps");
    L5:
        return newVal;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseBooleanArray getForegroundOps(String packageName, int userId) {
        SparseBooleanArray oldVal = this.mOldImplementation.getForegroundOps(packageName, userId);
        SparseBooleanArray newVal = this.mNewImplementation.getForegroundOps(packageName, userId);
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getForegroundOps");
    L5:
        return newVal;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean addAppOpsModeChangedListener(AppOpsCheckingServiceInterface.AppOpsModeChangedListener listener) {
        boolean oldVal = this.mOldImplementation.addAppOpsModeChangedListener(listener);
        boolean newVal = this.mNewImplementation.addAppOpsModeChangedListener(listener);
        if (oldVal == newVal) goto L5;
        signalImplDifference("addAppOpsModeChangedListener");
    L5:
        return newVal;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean removeAppOpsModeChangedListener(AppOpsCheckingServiceInterface.AppOpsModeChangedListener listener) {
        boolean oldVal = this.mOldImplementation.removeAppOpsModeChangedListener(listener);
        boolean newVal = this.mNewImplementation.removeAppOpsModeChangedListener(listener);
        if (oldVal == newVal) goto L5;
        signalImplDifference("removeAppOpsModeChangedListener");
    L5:
        return newVal;
    }
}

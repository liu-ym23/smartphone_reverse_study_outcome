package com.android.server.appop;

import android.os.Trace;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes.dex */
public class AppOpsCheckingServiceTracingDecorator implements AppOpsCheckingServiceInterface {
    private static final long TRACE_TAG = 64;
    private final AppOpsCheckingServiceInterface mService;

    AppOpsCheckingServiceTracingDecorator(AppOpsCheckingServiceInterface appOpsCheckingServiceInterface) {
        this.mService = appOpsCheckingServiceInterface;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void writeState() {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#writeState");
        this.mService.writeState();     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void readState() {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#readState");
        this.mService.readState();     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void shutdown() {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#shutdown");
        this.mService.shutdown();     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void systemReady() {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#systemReady");
        this.mService.systemReady();     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseIntArray getNonDefaultUidModes(int uid, String persistentDeviceId) {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#getNonDefaultUidModes");
        SparseIntArray r0 = this.mService.getNonDefaultUidModes(uid, persistentDeviceId);     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseIntArray getNonDefaultPackageModes(String packageName, int userId) {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#getNonDefaultPackageModes");
        SparseIntArray r0 = this.mService.getNonDefaultPackageModes(packageName, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public int getUidMode(int uid, String persistentDeviceId, int op) {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#getUidMode");
        int r0 = this.mService.getUidMode(uid, persistentDeviceId, op);     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean setUidMode(int uid, String persistentDeviceId, int op, int mode) {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#setUidMode");
        boolean r0 = this.mService.setUidMode(uid, persistentDeviceId, op, mode);     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public int getPackageMode(String packageName, int op, int userId) {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#getPackageMode");
        int r0 = this.mService.getPackageMode(packageName, op, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void setPackageMode(String packageName, int op, int mode, int userId) {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#setPackageMode");
        this.mService.setPackageMode(packageName, op, mode, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean removePackage(String packageName, int userId) {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#removePackage");
        boolean r0 = this.mService.removePackage(packageName, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void removeUid(int uid) {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#removeUid");
        this.mService.removeUid(uid);     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void clearAllModes() {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#clearAllModes");
        this.mService.clearAllModes();     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseBooleanArray getForegroundOps(int uid, String persistentDeviceId) {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#getForegroundOps");
        SparseBooleanArray r0 = this.mService.getForegroundOps(uid, persistentDeviceId);     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseBooleanArray getForegroundOps(String packageName, int userId) {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#getForegroundOps");
        SparseBooleanArray r0 = this.mService.getForegroundOps(packageName, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean addAppOpsModeChangedListener(AppOpsCheckingServiceInterface.AppOpsModeChangedListener listener) {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#addAppOpsModeChangedListener");
        boolean r0 = this.mService.addAppOpsModeChangedListener(listener);     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean removeAppOpsModeChangedListener(AppOpsCheckingServiceInterface.AppOpsModeChangedListener listener) {
        Trace.traceBegin(64, "TaggedTracingAppOpsCheckingServiceInterfaceImpl#removeAppOpsModeChangedListener");
        boolean r0 = this.mService.removeAppOpsModeChangedListener(listener);     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }
}

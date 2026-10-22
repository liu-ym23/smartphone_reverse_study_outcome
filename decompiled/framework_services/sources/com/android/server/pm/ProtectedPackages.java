package com.android.server.pm;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.SparseArray;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ProtectedPackages {
    private String mDeviceOwnerPackage;
    private int mDeviceOwnerUserId;
    private final String mDeviceProvisioningPackage;
    private final SparseArray<Set<String>> mOwnerProtectedPackages;
    private SparseArray<String> mProfileOwnerPackages;

    public ProtectedPackages(Context context) {
        this.mOwnerProtectedPackages = new SparseArray();
        this.mDeviceProvisioningPackage = context.getResources().getString(R.string.config_mainDisplayShape);
    }

    public synchronized void setDeviceAndProfileOwnerPackages(int deviceOwnerUserId, String deviceOwnerPackage, SparseArray<String> profileOwnerPackages) {
        monitor-enter(this);
        this.mDeviceOwnerUserId = deviceOwnerUserId;     // Catch: Throwable -> L14
        SparseArray<String> r1 = null;
        if (deviceOwnerUserId != (-10000)) goto L6;
        String r0 = null;
    L7:
        this.mDeviceOwnerPackage = r0;     // Catch: Throwable -> L14
        if (profileOwnerPackages == null) goto L11;
        r1 = profileOwnerPackages.clone();     // Catch: Throwable -> L14
    L11:
        this.mProfileOwnerPackages = r1;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L6:
        r0 = deviceOwnerPackage;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized void setOwnerProtectedPackages(int userId, List<String> packageNames) {
        monitor-enter(this);
        if (packageNames != null) goto L7;
        this.mOwnerProtectedPackages.remove(userId);     // Catch: Throwable -> L5
    L8:
        monitor-exit(this);
        return;
    L7:
        this.mOwnerProtectedPackages.put(userId, new ArraySet(packageNames));     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    private synchronized boolean hasDeviceOwnerOrProfileOwner(int userId, String packageName) {
        monitor-enter(this);
        if (packageName != null) goto L27;
        monitor-exit(this);
        return false;
    L27:
    L15:
        th = move-exception;
        throw th;
    L8:
        if (this.mDeviceOwnerPackage == null) goto L18;
        if (this.mDeviceOwnerUserId != userId) goto L18;
        if (packageName.equals(this.mDeviceOwnerPackage) == false) goto L18;
        monitor-exit(this);
        return true;
    L18:
        if (this.mProfileOwnerPackages == null) goto L23;
        if (packageName.equals(this.mProfileOwnerPackages.get(userId)) == false) goto L23;
        monitor-exit(this);
        return true;
    L23:
        monitor-exit(this);
        return false;
    }

    public synchronized String getDeviceOwnerOrProfileOwnerPackage(int userId) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mDeviceOwnerUserId != userId) goto L11;
        String r0 = this.mDeviceOwnerPackage;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r0;
    L11:
        if (this.mProfileOwnerPackages != null) goto L15;
        monitor-exit(this);
        return null;
    L15:
        String r1 = this.mProfileOwnerPackages.get(userId);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r1;
    }

    private synchronized boolean isProtectedPackage(int userId, String packageName) {
        monitor-enter(this);
        if (packageName != null) goto L17;
    L14:
        boolean r0 = false;
    L15:
        monitor-exit(this);
        return r0;
    L17:
    L9:
        th = move-exception;
        throw th;
    L5:
        if (packageName.equals(this.mDeviceProvisioningPackage) == true) goto L11;
        if (isOwnerProtectedPackage(userId, packageName) == false) goto L14;
    L11:
        r0 = true;
        goto L15
    }

    private synchronized boolean isOwnerProtectedPackage(int userId, String packageName) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (hasProtectedPackages(userId) == false) goto L8;
        boolean r0 = isPackageProtectedForUser(userId, packageName);     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);
        return r0;
    L8:
        r0 = isPackageProtectedForUser(-1, packageName);     // Catch: Throwable -> L6
        goto L9
    }

    private synchronized boolean isPackageProtectedForUser(int userId, String packageName) {
        monitor-enter(this);
        int userIdx = this.mOwnerProtectedPackages.indexOfKey(userId);     // Catch: Throwable -> L8
        if (userIdx < 0) goto L10;
        if (this.mOwnerProtectedPackages.valueAt(userIdx).contains(packageName) == false) goto L10;
        boolean r1 = true;
    L11:
        monitor-exit(this);
        return r1;
    L10:
        r1 = false;
    L8:
        th = move-exception;
        throw th;
    }

    private synchronized boolean hasProtectedPackages(int userId) {
        monitor-enter(this);
        if (this.mOwnerProtectedPackages.indexOfKey(userId) < 0) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isPackageStateProtected(int userId, String packageName) {
        if (hasDeviceOwnerOrProfileOwner(userId, packageName) == false) goto L5;
    L8:
        return true;
    L5:
        if (isProtectedPackage(userId, packageName) == true) goto L8;
        return false;
    }

    public boolean isPackageDataProtected(int userId, String packageName) {
        if (hasDeviceOwnerOrProfileOwner(userId, packageName) == false) goto L5;
    L8:
        return true;
    L5:
        if (isProtectedPackage(userId, packageName) == true) goto L8;
        return false;
    }

    public synchronized boolean isDeviceProvisioningPackage(String packageName) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(this.mDeviceProvisioningPackage) == true) goto L10;
        if (Objects.equals(this.mDeviceProvisioningPackage, packageName) == false) goto L10;
        boolean r0 = true;
    L11:
        monitor-exit(this);
        return r0;
    L10:
        r0 = false;
        goto L11
    }
}

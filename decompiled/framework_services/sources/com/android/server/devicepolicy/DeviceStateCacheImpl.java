package com.android.server.devicepolicy;

import android.app.admin.DeviceStateCache;
import android.util.IndentingPrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceStateCacheImpl extends DeviceStateCache {
    public static final int NO_DEVICE_OWNER = -1;
    private Map<Integer, Boolean> mAffiliationWithDevice;
    private AtomicInteger mDeviceOwnerType;
    private Map<Integer, Boolean> mHasProfileOwner;
    private boolean mIsDeviceProvisioned;
    private final Object mLock;

    public DeviceStateCacheImpl() {
        this.mLock = new Object();
        this.mDeviceOwnerType = new AtomicInteger(-1);
        this.mHasProfileOwner = new ConcurrentHashMap();
        this.mAffiliationWithDevice = new ConcurrentHashMap();
        this.mIsDeviceProvisioned = false;
    }

    public boolean isDeviceProvisioned() {
        return this.mIsDeviceProvisioned;
    }

    public void setDeviceProvisioned(boolean provisioned) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIsDeviceProvisioned = provisioned;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setDeviceOwnerType(int deviceOwnerType) {
        this.mDeviceOwnerType.set(deviceOwnerType);
    }

    void setHasProfileOwner(int userId, boolean hasProfileOwner) {
        if (hasProfileOwner == false) goto L4;
        this.mHasProfileOwner.put(Integer.valueOf(userId), true);
        return;
    L4:
        this.mHasProfileOwner.remove(Integer.valueOf(userId));
    }

    void setHasAffiliationWithDevice(int userId, Boolean hasAffiliateProfileOwner) {
        if (hasAffiliateProfileOwner.booleanValue() == false) goto L5;
        this.mAffiliationWithDevice.put(Integer.valueOf(userId), true);
        return;
    L5:
        this.mAffiliationWithDevice.remove(Integer.valueOf(userId));
    }

    public boolean hasAffiliationWithDevice(int userId) {
        return this.mAffiliationWithDevice.getOrDefault(Integer.valueOf(userId), false).booleanValue();
    }

    public boolean isUserOrganizationManaged(int userHandle) {
        if (this.mHasProfileOwner.getOrDefault(Integer.valueOf(userHandle), false).booleanValue() == false) goto L5;
        return true;
    L5:
        if (hasEnterpriseDeviceOwner() == true) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean hasEnterpriseDeviceOwner() {
        if (this.mDeviceOwnerType.get() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void dump(IndentingPrintWriter pw) {
        pw.println("Device state cache:");
        pw.increaseIndent();
        pw.println("Device provisioned: " + this.mIsDeviceProvisioned);
        pw.println("Device Owner Type: " + this.mDeviceOwnerType.get());
        pw.println("Has PO:");
        Iterator<Integer> r0 = this.mHasProfileOwner.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Integer id = r0.next();
        pw.println("User " + id + ": " + this.mHasProfileOwner.get(id));
        goto L4
    L6:
        pw.decreaseIndent();
    }
}

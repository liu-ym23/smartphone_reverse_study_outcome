package com.android.server.recoverysystem.hal;

import android.hardware.boot.IBootControl;
import android.hardware.boot.V1_0.CommandResult;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
public class BootControlHIDL implements IBootControl {
    private static final String TAG = "BootControlHIDL";
    final android.hardware.boot.V1_1.IBootControl v1_1_hal;
    final android.hardware.boot.V1_2.IBootControl v1_2_hal;
    final android.hardware.boot.V1_0.IBootControl v1_hal;

    public static boolean isServicePresent() {
        android.hardware.boot.V1_0.IBootControl.getService(true);     // Catch: Throwable -> L5
        return true;
    L6:
        return false;
    }

    public static boolean isV1_2ServicePresent() {
        android.hardware.boot.V1_2.IBootControl.getService(true);     // Catch: Throwable -> L5
        return true;
    L6:
        return false;
    }

    public static BootControlHIDL getService() throws RemoteException {
        android.hardware.boot.V1_0.IBootControl v1_hal = android.hardware.boot.V1_0.IBootControl.getService(true);
        android.hardware.boot.V1_1.IBootControl v1_1_hal = android.hardware.boot.V1_1.IBootControl.castFrom(v1_hal);
        android.hardware.boot.V1_2.IBootControl v1_2_hal = android.hardware.boot.V1_2.IBootControl.castFrom(v1_hal);
        return new BootControlHIDL(v1_hal, v1_1_hal, v1_2_hal);
    }

    private BootControlHIDL(android.hardware.boot.V1_0.IBootControl v1_hal, android.hardware.boot.V1_1.IBootControl v1_1_hal, android.hardware.boot.V1_2.IBootControl v1_2_hal) throws RemoteException {
        this.v1_hal = v1_hal;
        this.v1_1_hal = v1_1_hal;
        this.v1_2_hal = v1_2_hal;
        if (v1_hal == null) goto L12;
        if (v1_2_hal == null) goto L7;
        Slog.i(TAG, "V1.2 version of BootControl HIDL HAL available, using V1.2");
        return;
    L7:
        if (v1_1_hal == null) goto L9;
        Slog.i(TAG, "V1.1 version of BootControl HIDL HAL available, using V1.1");
        return;
    L9:
        Slog.i(TAG, "V1.0 version of BootControl HIDL HAL available, using V1.0");
        return;
    L12:
        throw new RemoteException("Failed to find V1.0 BootControl HIDL");
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // android.hardware.boot.IBootControl
    public int getActiveBootSlot() throws RemoteException {
        if (this.v1_2_hal == null) goto L7;
        return this.v1_2_hal.getActiveBootSlot();
    L7:
        throw new RemoteException("getActiveBootSlot() requires V1.2 BootControl HAL");
    }

    @Override // android.hardware.boot.IBootControl
    public int getCurrentSlot() throws RemoteException {
        return this.v1_hal.getCurrentSlot();
    }

    @Override // android.hardware.boot.IBootControl
    public int getNumberSlots() throws RemoteException {
        return this.v1_hal.getNumberSlots();
    }

    @Override // android.hardware.boot.IBootControl
    public int getSnapshotMergeStatus() throws RemoteException {
        if (this.v1_1_hal == null) goto L7;
        return this.v1_1_hal.getSnapshotMergeStatus();
    L7:
        throw new RemoteException("getSnapshotMergeStatus() requires V1.1 BootControl HAL");
    }

    @Override // android.hardware.boot.IBootControl
    public String getSuffix(int slot) throws RemoteException {
        return this.v1_hal.getSuffix(slot);
    }

    @Override // android.hardware.boot.IBootControl
    public boolean isSlotBootable(int slot) throws RemoteException {
        int ret = this.v1_hal.isSlotBootable(slot);
        if (ret == (-1)) goto L9;
        if (ret == 0) goto L6;
        return true;
    L6:
        return false;
    L9:
        throw new RemoteException("isSlotBootable() failed, Slot %d might be invalid.".formatted(new Object[]{Integer.valueOf(slot)}));
    }

    @Override // android.hardware.boot.IBootControl
    public boolean isSlotMarkedSuccessful(int slot) throws RemoteException {
        int ret = this.v1_hal.isSlotMarkedSuccessful(slot);
        if (ret == (-1)) goto L9;
        if (ret == 0) goto L6;
        return true;
    L6:
        return false;
    L9:
        throw new RemoteException("isSlotMarkedSuccessful() failed, Slot %d might be invalid.".formatted(new Object[]{Integer.valueOf(slot)}));
    }

    @Override // android.hardware.boot.IBootControl
    public void markBootSuccessful() throws RemoteException {
        CommandResult res = this.v1_hal.markBootSuccessful();
        if (res.success == false) goto L6;
        return;
    L6:
        throw new RemoteException("Error markBootSuccessful() " + res.errMsg);
    }

    @Override // android.hardware.boot.IBootControl
    public void setActiveBootSlot(int slot) throws RemoteException {
        CommandResult res = this.v1_hal.setActiveBootSlot(slot);
        if (res.success == false) goto L6;
        return;
    L6:
        throw new RemoteException("Error setActiveBootSlot(%d) %s".formatted(new Object[]{Integer.valueOf(slot), res.errMsg}));
    }

    @Override // android.hardware.boot.IBootControl
    public void setSlotAsUnbootable(int slot) throws RemoteException {
        CommandResult res = this.v1_hal.setSlotAsUnbootable(slot);
        if (res.success == false) goto L6;
        return;
    L6:
        throw new RemoteException("Error setSlotAsUnbootable(%d) %s".formatted(new Object[]{Integer.valueOf(slot), res.errMsg}));
    }

    @Override // android.hardware.boot.IBootControl
    public void setSnapshotMergeStatus(int status) throws RemoteException {
        if (this.v1_1_hal == null) goto L10;
        if (this.v1_1_hal.setSnapshotMergeStatus(status) == false) goto L8;
        return;
    L8:
        throw new RemoteException("Error setSnapshotMergeStatus(%d)".formatted(new Object[]{Integer.valueOf(status)}));
    L10:
        throw new RemoteException("getSnapshotMergeStatus() requires V1.1 BootControl HAL");
    }

    @Override // android.hardware.boot.IBootControl
    public int getInterfaceVersion() throws RemoteException {
        return 1;
    }

    @Override // android.hardware.boot.IBootControl
    public String getInterfaceHash() throws RemoteException {
        return this.v1_hal.interfaceDescriptor();
    }
}

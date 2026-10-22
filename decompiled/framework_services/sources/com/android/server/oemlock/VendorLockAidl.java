package com.android.server.oemlock;

import android.content.Context;
import android.hardware.oemlock.IOemLock;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
class VendorLockAidl extends OemLock {
    private static final String TAG = "OemLock";
    private IOemLock mOemLock;

    static IOemLock getOemLockHalService() {
        return IOemLock.Stub.asInterface(ServiceManager.waitForDeclaredService(IOemLock.DESCRIPTOR + "/default"));
    }

    VendorLockAidl(Context context) {
        this.mOemLock = getOemLockHalService();
    }

    @Override // com.android.server.oemlock.OemLock
    String getLockName() {
        return this.mOemLock.getName();
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to get name from HAL", e);
        throw e.rethrowFromSystemServer();
    }

    @Override // com.android.server.oemlock.OemLock
    void setOemUnlockAllowedByCarrier(boolean allowed, byte[] signature) {
        if (signature != null) goto L7;
        int status = this.mOemLock.setOemUnlockAllowedByCarrier(allowed, new byte[0]);     // Catch: RemoteException -> L5
    L8:
        switch(status) {
            case 0: goto L17;
            case 1: goto L16;
            case 2: goto L10;
            default: goto L9;
        };     // Catch: RemoteException -> L5
    L9:
        Slog.e(TAG, "Unknown return value indicates code is out of sync with HAL");     // Catch: RemoteException -> L5
        goto L16
    L10:
        if (signature != null) goto L14;
        throw new IllegalArgumentException("Signature required for carrier unlock");     // Catch: RemoteException -> L5
    L14:
        throw new SecurityException("Invalid signature used in attempt to carrier unlock");     // Catch: RemoteException -> L5
    L17:
        Slog.i(TAG, "Updated carrier allows OEM lock state to: " + allowed);     // Catch: RemoteException -> L5
        return;
    L16:
        throw new RuntimeException("Failed to set carrier OEM unlock state");     // Catch: RemoteException -> L5
    L7:
        status = this.mOemLock.setOemUnlockAllowedByCarrier(allowed, signature);     // Catch: RemoteException -> L5
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to set carrier state with HAL", e);
        throw e.rethrowFromSystemServer();
    }

    @Override // com.android.server.oemlock.OemLock
    boolean isOemUnlockAllowedByCarrier() {
        return this.mOemLock.isOemUnlockAllowedByCarrier();
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to get carrier state from HAL");
        throw e.rethrowFromSystemServer();
    }

    @Override // com.android.server.oemlock.OemLock
    void setOemUnlockAllowedByDevice(boolean allowedByDevice) {
        this.mOemLock.setOemUnlockAllowedByDevice(allowedByDevice);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to set device state with HAL", e);
        throw e.rethrowFromSystemServer();
    }

    @Override // com.android.server.oemlock.OemLock
    boolean isOemUnlockAllowedByDevice() {
        return this.mOemLock.isOemUnlockAllowedByDevice();
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to get devie state from HAL");
        throw e.rethrowFromSystemServer();
    }
}

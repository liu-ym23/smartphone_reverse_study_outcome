package com.android.server.oemlock;

import android.content.Context;
import android.hardware.oemlock.V1_0.IOemLock;
import android.os.RemoteException;
import android.util.Slog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class VendorLockHidl extends OemLock {
    private static final String TAG = "OemLock";
    private Context mContext;
    private IOemLock mOemLock;

    public static /* synthetic */ void $r8$lambda$J0xDhXKOKFsnDjeONe3R4MXPypg(Integer[] r0, Boolean[] r1, int r2, boolean r3) {
        lambda$isOemUnlockAllowedByCarrier$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$eOi_ayoptw_9P3u_INg97xoCpUs(Integer[] r0, Boolean[] r1, int r2, boolean r3) {
        lambda$isOemUnlockAllowedByDevice$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$uRDVk7b7gmc4xqVSXUxClFklLYY(Integer[] r0, String[] r1, int r2, String r3) {
        lambda$getLockName$0(r0, r1, r2, r3);
    }

    static IOemLock getOemLockHalService() {
        return IOemLock.getService(true);
    L5:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    L9:
        Slog.i(TAG, "OemLock Hidl HAL not present on device");
        return null;
    }

    VendorLockHidl(Context context) {
        this.mContext = context;
        this.mOemLock = getOemLockHalService();
    }

    @Override // com.android.server.oemlock.OemLock
    String getLockName() {
        final String[] lockName = new String[1];
        final Integer[] requestStatus = new Integer[1];
        this.mOemLock.getName(new VendorLockHidl$$ExternalSyntheticLambda1(requestStatus, lockName));     // Catch: RemoteException -> L12
        switch(requestStatus[0].intValue()) {
            case 0: goto L11;
            case 1: goto L8;
            default: goto L6;
        };
    L6:
        Slog.e(TAG, "Unknown return value indicates code is out of sync with HAL");
        return null;
    L8:
        Slog.e(TAG, "Failed to get OEM lock name.");
        return null;
    L11:
        return lockName[0];
    L12:
        e = move-exception;
        Slog.e(TAG, "Failed to get name from HAL", e);
        throw e.rethrowFromSystemServer();
    }

    private static /* synthetic */ void lambda$getLockName$0(Integer[] requestStatus, String[] lockName, int status, String name) {
        requestStatus[0] = Integer.valueOf(status);
        lockName[0] = name;
    }

    @Override // com.android.server.oemlock.OemLock
    void setOemUnlockAllowedByCarrier(boolean allowed, byte[] signature) {
        ArrayList<Byte> signatureBytes = toByteArrayList(signature);     // Catch: RemoteException -> L6
        switch(this.mOemLock.setOemUnlockAllowedByCarrier(allowed, signatureBytes)) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L9;
            default: goto L5;
        };     // Catch: RemoteException -> L6
    L5:
        Slog.e(TAG, "Unknown return value indicates code is out of sync with HAL");     // Catch: RemoteException -> L6
        goto L15
    L16:
        Slog.i(TAG, "Updated carrier allows OEM lock state to: " + allowed);     // Catch: RemoteException -> L6
        return;
    L9:
        if (signatureBytes.isEmpty() == false) goto L13;
        throw new IllegalArgumentException("Signature required for carrier unlock");     // Catch: RemoteException -> L6
    L13:
        throw new SecurityException("Invalid signature used in attempt to carrier unlock");     // Catch: RemoteException -> L6
    L15:
        throw new RuntimeException("Failed to set carrier OEM unlock state");     // Catch: RemoteException -> L6
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed to set carrier state with HAL", e);
        throw e.rethrowFromSystemServer();
    }

    @Override // com.android.server.oemlock.OemLock
    boolean isOemUnlockAllowedByCarrier() {
        final Boolean[] allowedByCarrier = new Boolean[1];
        final Integer[] requestStatus = new Integer[1];
        this.mOemLock.isOemUnlockAllowedByCarrier(new VendorLockHidl$$ExternalSyntheticLambda0(requestStatus, allowedByCarrier));     // Catch: RemoteException -> L11
        switch(requestStatus[0].intValue()) {
            case 0: goto L10;
            case 1: goto L8;
            default: goto L6;
        };
    L6:
        Slog.e(TAG, "Unknown return value indicates code is out of sync with HAL");
    L8:
        throw new RuntimeException("Failed to get carrier OEM unlock state");
    L10:
        return allowedByCarrier[0].booleanValue();
    L11:
        e = move-exception;
        Slog.e(TAG, "Failed to get carrier state from HAL");
        throw e.rethrowFromSystemServer();
    }

    private static /* synthetic */ void lambda$isOemUnlockAllowedByCarrier$1(Integer[] requestStatus, Boolean[] allowedByCarrier, int status, boolean allowed) {
        requestStatus[0] = Integer.valueOf(status);
        allowedByCarrier[0] = Boolean.valueOf(allowed);
    }

    @Override // com.android.server.oemlock.OemLock
    void setOemUnlockAllowedByDevice(boolean allowedByDevice) {
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed to set device state with HAL", e);
        throw e.rethrowFromSystemServer();
    L4:
        switch(this.mOemLock.setOemUnlockAllowedByDevice(allowedByDevice)) {
            case 0: goto L10;
            case 1: goto L9;
            default: goto L5;
        };     // Catch: RemoteException -> L6
    L5:
        Slog.e(TAG, "Unknown return value indicates code is out of sync with HAL");     // Catch: RemoteException -> L6
        goto L9
    L10:
        Slog.i(TAG, "Updated device allows OEM lock state to: " + allowedByDevice);     // Catch: RemoteException -> L6
        return;
    L9:
        throw new RuntimeException("Failed to set device OEM unlock state");     // Catch: RemoteException -> L6
    }

    @Override // com.android.server.oemlock.OemLock
    boolean isOemUnlockAllowedByDevice() {
        final Boolean[] allowedByDevice = new Boolean[1];
        final Integer[] requestStatus = new Integer[1];
        this.mOemLock.isOemUnlockAllowedByDevice(new VendorLockHidl$$ExternalSyntheticLambda2(requestStatus, allowedByDevice));     // Catch: RemoteException -> L11
        switch(requestStatus[0].intValue()) {
            case 0: goto L10;
            case 1: goto L8;
            default: goto L6;
        };
    L6:
        Slog.e(TAG, "Unknown return value indicates code is out of sync with HAL");
    L8:
        throw new RuntimeException("Failed to get device OEM unlock state");
    L10:
        return allowedByDevice[0].booleanValue();
    L11:
        e = move-exception;
        Slog.e(TAG, "Failed to get devie state from HAL");
        throw e.rethrowFromSystemServer();
    }

    private static /* synthetic */ void lambda$isOemUnlockAllowedByDevice$2(Integer[] requestStatus, Boolean[] allowedByDevice, int status, boolean allowed) {
        requestStatus[0] = Integer.valueOf(status);
        allowedByDevice[0] = Boolean.valueOf(allowed);
    }

    private ArrayList<Byte> toByteArrayList(byte[] data) {
        if (data == null) goto L4;
        ArrayList<Byte> result = new ArrayList(data.length);
        int r1 = data.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        byte b = data[r2];
        result.add(Byte.valueOf(b));
        r2 = r2 + 1;
        goto L6
    L8:
        return result;
    L4:
        return new ArrayList();
    }
}

package com.android.server.oemlock;

import android.content.Context;
import android.os.UserHandle;
import android.os.UserManager;
import android.service.persistentdata.PersistentDataBlockManager;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
class PersistentDataBlockLock extends OemLock {
    private static final String TAG = "OemLock";
    private Context mContext;

    PersistentDataBlockLock(Context context) {
        this.mContext = context;
    }

    @Override // com.android.server.oemlock.OemLock
    String getLockName() {
        return "";
    }

    @Override // com.android.server.oemlock.OemLock
    void setOemUnlockAllowedByCarrier(boolean allowed, byte[] signature) {
        if (signature == null) goto L4;
        Slog.w(TAG, "Signature provided but is not being used");
    L4:
        UserManager.get(this.mContext).setUserRestriction("no_oem_unlock", !allowed, UserHandle.SYSTEM);
        if (allowed == true) goto L8;
        disallowUnlockIfNotUnlocked();
        return;
    }

    @Override // com.android.server.oemlock.OemLock
    boolean isOemUnlockAllowedByCarrier() {
        return !UserManager.get(this.mContext).hasUserRestriction("no_oem_unlock", UserHandle.SYSTEM);
    }

    @Override // com.android.server.oemlock.OemLock
    void setOemUnlockAllowedByDevice(boolean allowedByDevice) {
        PersistentDataBlockManager pdbm = (PersistentDataBlockManager) this.mContext.getSystemService("persistent_data_block");
        if (pdbm != null) goto L6;
        Slog.w(TAG, "PersistentDataBlock is not supported on this device");
        return;
    L6:
        pdbm.setOemUnlockEnabled(allowedByDevice);
    }

    @Override // com.android.server.oemlock.OemLock
    boolean isOemUnlockAllowedByDevice() {
        PersistentDataBlockManager pdbm = (PersistentDataBlockManager) this.mContext.getSystemService("persistent_data_block");
        if (pdbm != null) goto L7;
        Slog.w(TAG, "PersistentDataBlock is not supported on this device");
        return false;
    L7:
        return pdbm.getOemUnlockEnabled();
    }

    private void disallowUnlockIfNotUnlocked() {
        PersistentDataBlockManager pdbm = (PersistentDataBlockManager) this.mContext.getSystemService("persistent_data_block");
        if (pdbm != null) goto L7;
        Slog.w(TAG, "PersistentDataBlock is not supported on this device");
        return;
    L7:
        if (pdbm.getFlashLockState() == 0) goto L10;
        pdbm.setOemUnlockEnabled(false);
        return;
    }
}

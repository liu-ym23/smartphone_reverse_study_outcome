package com.android.server.locksettings;

import android.hardware.rebootescrow.IRebootEscrow;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ServiceSpecificException;
import android.util.Slog;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
class RebootEscrowProviderHalImpl implements RebootEscrowProviderInterface {
    private static final String TAG = "RebootEscrowProviderHal";
    private final Injector mInjector;

    static class Injector {
        Injector() {
        }

        public IRebootEscrow getRebootEscrow() {
            return IRebootEscrow.Stub.asInterface(ServiceManager.getService("android.hardware.rebootescrow.IRebootEscrow/default"));
        L5:
            Slog.i(RebootEscrowProviderHalImpl.TAG, "Device doesn't implement RebootEscrow HAL");
            return null;
        }
    }

    RebootEscrowProviderHalImpl() {
        this.mInjector = new Injector();
    }

    RebootEscrowProviderHalImpl(Injector injector) {
        this.mInjector = injector;
    }

    @Override // com.android.server.locksettings.RebootEscrowProviderInterface
    public int getType() {
        return 0;
    }

    @Override // com.android.server.locksettings.RebootEscrowProviderInterface
    public boolean hasRebootEscrowSupport() {
        if (this.mInjector.getRebootEscrow() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.locksettings.RebootEscrowProviderInterface
    public RebootEscrowKey getAndClearRebootEscrowKey(SecretKey decryptionKey) {
        IRebootEscrow rebootEscrow = this.mInjector.getRebootEscrow();
        if (rebootEscrow != null) goto L32;
        Slog.w(TAG, "Had reboot escrow data for users, but RebootEscrow HAL is unavailable");
        return null;
    L32:
        byte[] escrowKeyBytes = rebootEscrow.retrieveKey();     // Catch: ServiceSpecificException -> L10 RemoteException -> L12
        if (escrowKeyBytes != null) goto L15;
        Slog.w(TAG, "Had reboot escrow data for users, but could not retrieve key");     // Catch: ServiceSpecificException -> L10 RemoteException -> L12
        return null;
    L15:
        if (escrowKeyBytes.length == 32) goto L18;
        Slog.e(TAG, "IRebootEscrow returned key of incorrect size " + escrowKeyBytes.length);     // Catch: ServiceSpecificException -> L10 RemoteException -> L12
        return null;
    L18:
        int zero = 0;
        int i = 0;
    L20:
        if (i >= escrowKeyBytes.length) goto L23;
        zero = zero | escrowKeyBytes[i];     // Catch: ServiceSpecificException -> L10 RemoteException -> L12
        i = i + 1;     // Catch: ServiceSpecificException -> L10 RemoteException -> L12
        goto L20
    L23:
        if (zero != 0) goto L26;
        Slog.w(TAG, "IRebootEscrow returned an all-zeroes key");     // Catch: ServiceSpecificException -> L10 RemoteException -> L12
        return null;
    L26:
        rebootEscrow.storeKey(new byte[32]);     // Catch: ServiceSpecificException -> L10 RemoteException -> L12
        return RebootEscrowKey.fromKeyBytes(escrowKeyBytes);
    L10:
        e = move-exception;
        Slog.w(TAG, "Got service-specific exception: " + e.errorCode);
        return null;
    L30:
        Slog.w(TAG, "Could not retrieve escrow data");
        return null;
    }

    @Override // com.android.server.locksettings.RebootEscrowProviderInterface
    public void clearRebootEscrowKey() {
        IRebootEscrow rebootEscrow = this.mInjector.getRebootEscrow();
        if (rebootEscrow != null) goto L11;
        return;
    L11:
        rebootEscrow.storeKey(new byte[32]);     // Catch: Throwable -> L8
        return;
    L9:
        Slog.w(TAG, "Could not call RebootEscrow HAL to shred key");
    }

    @Override // com.android.server.locksettings.RebootEscrowProviderInterface
    public boolean storeRebootEscrowKey(RebootEscrowKey escrowKey, SecretKey encryptionKey) {
        IRebootEscrow rebootEscrow = this.mInjector.getRebootEscrow();
        if (rebootEscrow != null) goto L12;
        Slog.w(TAG, "Escrow marked as ready, but RebootEscrow HAL is unavailable");
        return false;
    L12:
        rebootEscrow.storeKey(escrowKey.getKeyBytes());     // Catch: Throwable -> L9
        Slog.i(TAG, "Reboot escrow key stored with RebootEscrow HAL");     // Catch: Throwable -> L9
        return true;
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed escrow secret to RebootEscrow HAL", e);
        return false;
    }
}

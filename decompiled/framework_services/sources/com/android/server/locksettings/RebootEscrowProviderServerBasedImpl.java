package com.android.server.locksettings;

import android.content.Context;
import android.os.RemoteException;
import android.provider.DeviceConfig;
import android.util.Slog;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
class RebootEscrowProviderServerBasedImpl implements RebootEscrowProviderInterface {
    private static final long DEFAULT_SERVER_BLOB_LIFETIME_IN_MILLIS = 600000;
    private static final long DEFAULT_SERVICE_TIMEOUT_IN_SECONDS = 10;
    private static final String TAG = "RebootEscrowProviderServerBased";
    private final Injector mInjector;
    private byte[] mServerBlob;
    private final LockSettingsStorage mStorage;

    static class Injector {
        private ResumeOnRebootServiceProvider.ResumeOnRebootServiceConnection mServiceConnection;

        /* JADX INFO: renamed from: -$$Nest$mgetServiceConnection, reason: not valid java name */
        static /* bridge */ /* synthetic */ ResumeOnRebootServiceProvider.ResumeOnRebootServiceConnection m5470$$Nest$mgetServiceConnection(Injector r0) {
            return r0.getServiceConnection();
        }

        Injector(Context context) {
            this.mServiceConnection = null;
            this.mServiceConnection = new ResumeOnRebootServiceProvider(context).getServiceConnection();
            if (this.mServiceConnection != null) goto L6;
            Slog.e(RebootEscrowProviderServerBasedImpl.TAG, "Failed to resolve resume on reboot server service.");
            return;
        }

        Injector(ResumeOnRebootServiceProvider.ResumeOnRebootServiceConnection serviceConnection) {
            this.mServiceConnection = null;
            this.mServiceConnection = serviceConnection;
        }

        private ResumeOnRebootServiceProvider.ResumeOnRebootServiceConnection getServiceConnection() {
            return this.mServiceConnection;
        }

        long getServiceTimeoutInSeconds() {
            return DeviceConfig.getLong("ota", "server_based_service_timeout_in_seconds", RebootEscrowProviderServerBasedImpl.DEFAULT_SERVICE_TIMEOUT_IN_SECONDS);
        }

        long getServerBlobLifetimeInMillis() {
            return DeviceConfig.getLong("ota", "server_based_server_blob_lifetime_in_millis", 600000);
        }
    }

    RebootEscrowProviderServerBasedImpl(Context context, LockSettingsStorage storage) {
        this(storage, new Injector(context));
    }

    RebootEscrowProviderServerBasedImpl(LockSettingsStorage storage, Injector injector) {
        this.mStorage = storage;
        this.mInjector = injector;
    }

    @Override // com.android.server.locksettings.RebootEscrowProviderInterface
    public int getType() {
        return 1;
    }

    @Override // com.android.server.locksettings.RebootEscrowProviderInterface
    public boolean hasRebootEscrowSupport() {
        if (Injector.m5470$$Nest$mgetServiceConnection(this.mInjector) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private byte[] unwrapServerBlob(byte[] serverBlob, SecretKey decryptionKey) throws TimeoutException, RemoteException, IOException {
        ResumeOnRebootServiceProvider.ResumeOnRebootServiceConnection serviceConnection = Injector.m5470$$Nest$mgetServiceConnection(this.mInjector);
        if (serviceConnection != null) goto L6;
        Slog.w(TAG, "Had reboot escrow data for users, but resume on reboot server service is unavailable");
        return null;
    L6:
        byte[] decryptedBlob = AesEncryptionUtil.decrypt(decryptionKey, serverBlob);
        if (decryptedBlob != null) goto L10;
        Slog.w(TAG, "Decrypted server blob should not be null");
        return null;
    L10:
        serviceConnection.bindToService(this.mInjector.getServiceTimeoutInSeconds());
        byte[] escrowKeyBytes = serviceConnection.unwrap(decryptedBlob, this.mInjector.getServiceTimeoutInSeconds());
        serviceConnection.unbindService();
        return escrowKeyBytes;
    }

    @Override // com.android.server.locksettings.RebootEscrowProviderInterface
    public RebootEscrowKey getAndClearRebootEscrowKey(SecretKey decryptionKey) throws IOException {
        if (this.mServerBlob != null) goto L5;
        this.mServerBlob = this.mStorage.readRebootEscrowServerBlob();
    L5:
        this.mStorage.removeRebootEscrowServerBlob();
        if (this.mServerBlob != null) goto L9;
        Slog.w(TAG, "Failed to read reboot escrow server blob from storage");
        return null;
    L9:
        if (decryptionKey != null) goto L12;
        Slog.w(TAG, "Failed to decrypt the escrow key; decryption key from keystore is null.");
        return null;
    L12:
        Slog.i(TAG, "Loaded reboot escrow server blob from storage");
        byte[] escrowKeyBytes = unwrapServerBlob(this.mServerBlob, decryptionKey);     // Catch: Throwable -> L17
        if (escrowKeyBytes != null) goto L20;
        Slog.w(TAG, "Decrypted reboot escrow key bytes should not be null");     // Catch: Throwable -> L17
        return null;
    L20:
        if (escrowKeyBytes.length == 32) goto L24;
        Slog.e(TAG, "Decrypted reboot escrow key has incorrect size " + escrowKeyBytes.length);     // Catch: Throwable -> L17
        return null;
    L24:
        return RebootEscrowKey.fromKeyBytes(escrowKeyBytes);
    L17:
        e = move-exception;
        Slog.w(TAG, "Failed to decrypt the server blob ", e);
        return null;
    }

    @Override // com.android.server.locksettings.RebootEscrowProviderInterface
    public void clearRebootEscrowKey() {
        this.mStorage.removeRebootEscrowServerBlob();
    }

    private byte[] wrapEscrowKey(byte[] escrowKeyBytes, SecretKey encryptionKey) throws TimeoutException, RemoteException, IOException {
        ResumeOnRebootServiceProvider.ResumeOnRebootServiceConnection serviceConnection = Injector.m5470$$Nest$mgetServiceConnection(this.mInjector);
        if (serviceConnection != null) goto L6;
        Slog.w(TAG, "Failed to encrypt the reboot escrow key: resume on reboot server service is unavailable");
        return null;
    L6:
        serviceConnection.bindToService(this.mInjector.getServiceTimeoutInSeconds());
        byte[] serverEncryptedBlob = serviceConnection.wrapBlob(escrowKeyBytes, this.mInjector.getServerBlobLifetimeInMillis(), this.mInjector.getServiceTimeoutInSeconds());
        serviceConnection.unbindService();
        if (serverEncryptedBlob != null) goto L11;
        Slog.w(TAG, "Server encrypted reboot escrow key cannot be null");
        return null;
    L11:
        return AesEncryptionUtil.encrypt(encryptionKey, serverEncryptedBlob);
    }

    @Override // com.android.server.locksettings.RebootEscrowProviderInterface
    public boolean storeRebootEscrowKey(RebootEscrowKey escrowKey, SecretKey encryptionKey) {
        this.mStorage.removeRebootEscrowServerBlob();
        byte[] wrappedBlob = wrapEscrowKey(escrowKey.getKeyBytes(), encryptionKey);     // Catch: Throwable -> L7
        if (wrappedBlob != null) goto L9;
        Slog.w(TAG, "Failed to encrypt the reboot escrow key");     // Catch: Throwable -> L7
        return false;
    L9:
        this.mStorage.writeRebootEscrowServerBlob(wrappedBlob);     // Catch: Throwable -> L7
        Slog.i(TAG, "Reboot escrow key encrypted and stored.");     // Catch: Throwable -> L7
        return true;
    L7:
        e = move-exception;
        Slog.w(TAG, "Failed to encrypt the reboot escrow key ", e);
        return false;
    }
}

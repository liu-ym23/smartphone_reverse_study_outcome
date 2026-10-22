package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.content.Context;
import android.hardware.biometrics.IInvalidationCallback;
import android.hardware.fingerprint.Fingerprint;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.sensors.InvalidationClient;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintInvalidationClient extends InvalidationClient<Fingerprint, AidlSession> {
    private static final String TAG = "FingerprintInvalidationClient";

    public FingerprintInvalidationClient(Context context, Supplier<AidlSession> lazyDaemon, int userId, int sensorId, BiometricLogger logger, BiometricContext biometricContext, Map<Integer, Long> authenticatorIds, IInvalidationCallback callback) {
        super(context, lazyDaemon, userId, sensorId, logger, biometricContext, authenticatorIds, callback);
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    protected void startHalOperation() {
        getFreshDaemon().getSession().invalidateAuthenticatorId();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        this.mCallback.onClientFinished(this, false);
    }
}

package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.content.Context;
import android.hardware.fingerprint.Fingerprint;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.sensors.BiometricUtils;
import com.android.server.biometrics.sensors.ClientMonitorCallbackConverter;
import com.android.server.biometrics.sensors.RemovalClient;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintRemovalClient extends RemovalClient<Fingerprint, AidlSession> {
    private static final String TAG = "FingerprintRemovalClient";
    private final int[] mBiometricIds;

    public FingerprintRemovalClient(Context context, Supplier<AidlSession> lazyDaemon, IBinder token, ClientMonitorCallbackConverter listener, int[] biometricIds, int userId, String owner, BiometricUtils<Fingerprint> utils, int sensorId, BiometricLogger logger, BiometricContext biometricContext, Map<Integer, Long> authenticatorIds, int reason) {
        super(context, lazyDaemon, token, listener, userId, owner, utils, sensorId, logger, biometricContext, authenticatorIds, reason);
        this.mBiometricIds = biometricIds;
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    protected void startHalOperation() {
        getFreshDaemon().getSession().removeEnrollments(this.mBiometricIds);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Remote exception when requesting remove", e);
        this.mCallback.onClientFinished(this, false);
    }
}

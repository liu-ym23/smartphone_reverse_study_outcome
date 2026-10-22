package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.content.Context;
import android.hardware.fingerprint.Fingerprint;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.sensors.BiometricUtils;
import com.android.server.biometrics.sensors.InternalEnumerateClient;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintInternalEnumerateClient extends InternalEnumerateClient<AidlSession> {
    private static final String TAG = "FingerprintInternalEnumerateClient";

    protected FingerprintInternalEnumerateClient(Context context, Supplier<AidlSession> lazyDaemon, IBinder token, int userId, String owner, List<Fingerprint> enrolledList, BiometricUtils<Fingerprint> utils, int sensorId, BiometricLogger logger, BiometricContext biometricContext) {
        super(context, lazyDaemon, token, userId, owner, enrolledList, utils, sensorId, logger, biometricContext);
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    protected void startHalOperation() {
        getFreshDaemon().getSession().enumerateEnrollments();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Remote exception when requesting enumerate", e);
        this.mCallback.onClientFinished(this, false);
    }

    @Override // com.android.server.biometrics.sensors.InternalEnumerateClient
    protected int getModality() {
        return 1;
    }
}

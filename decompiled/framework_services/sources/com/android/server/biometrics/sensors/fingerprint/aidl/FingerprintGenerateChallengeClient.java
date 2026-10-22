package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.sensors.ClientMonitorCallbackConverter;
import com.android.server.biometrics.sensors.GenerateChallengeClient;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintGenerateChallengeClient extends GenerateChallengeClient<AidlSession> {
    private static final String TAG = "FingerprintGenerateChallengeClient";

    public FingerprintGenerateChallengeClient(Context context, Supplier<AidlSession> lazyDaemon, IBinder token, ClientMonitorCallbackConverter listener, int userId, String owner, int sensorId, BiometricLogger biometricLogger, BiometricContext biometricContext) {
        super(context, lazyDaemon, token, listener, userId, owner, sensorId, biometricLogger, biometricContext);
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    protected void startHalOperation() {
        getFreshDaemon().getSession().generateChallenge();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Unable to generateChallenge", e);
        this.mCallback.onClientFinished(this, false);
    }

    void onChallengeGenerated(int sensorId, int userId, long challenge) {
        ClientMonitorCallbackConverter listener = getListener();     // Catch: RemoteException -> L4
        listener.onChallengeGenerated(sensorId, userId, challenge);     // Catch: RemoteException -> L4
        this.mCallback.onClientFinished(this, true);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Unable to send challenge", e);
        this.mCallback.onClientFinished(this, false);
    }
}

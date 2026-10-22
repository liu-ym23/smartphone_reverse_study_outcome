package com.android.server.biometrics.sensors.face.aidl;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.sensors.RevokeChallengeClient;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FaceRevokeChallengeClient extends RevokeChallengeClient<AidlSession> {
    private static final String TAG = "FaceRevokeChallengeClient";
    private final long mChallenge;

    public FaceRevokeChallengeClient(Context context, Supplier<AidlSession> lazyDaemon, IBinder token, int userId, String owner, int sensorId, BiometricLogger logger, BiometricContext biometricContext, long challenge) {
        super(context, lazyDaemon, token, userId, owner, sensorId, logger, biometricContext);
        this.mChallenge = challenge;
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    protected void startHalOperation() {
        getFreshDaemon().getSession().revokeChallenge(this.mChallenge);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Unable to revokeChallenge", e);
        this.mCallback.onClientFinished(this, false);
    }

    void onChallengeRevoked(int sensorId, int userId, long challenge) {
        if (challenge != this.mChallenge) goto L5;
        boolean success = true;
    L6:
        this.mCallback.onClientFinished(this, success);
        return;
    L5:
        success = false;
        goto L6
    }
}

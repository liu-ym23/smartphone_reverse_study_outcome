package com.android.server.biometrics.sensors.fingerprint;

import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintEnrollOptions;
import android.hardware.fingerprint.IFingerprintServiceReceiver;
import android.os.IBinder;
import android.pico.utils.IExtBase;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IExtFingerprintService extends IExtBase {
    default long enroll(IBinder token, byte[] hardwareAuthToken, int userId, IFingerprintServiceReceiver receiver, String opPackageName, int enrollReason, FingerprintEnrollOptions options) {
        return -1;
    }

    default int cancelEnrollment(IBinder token, long requestId) {
        return -1;
    }

    default void recordAuthInfo(long requestId, int sensorId) {
    }

    default int cancelAuthentication(IBinder token, long requestId) {
        return -1;
    }

    default int remove(IBinder token, int fingerId, int userId, IFingerprintServiceReceiver receiver, String opPackageName) {
        return -1;
    }

    default int rename(int fingerId, int userId, String name) {
        return -1;
    }

    default List<Fingerprint> getEnrolledFingerprints(int userId, String opPackageName) {
        return Collections.emptyList();
    }
}

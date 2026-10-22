package com.android.server.biometrics.sensors.fingerprint;

import android.hardware.biometrics.IInvalidationCallback;
import android.hardware.biometrics.ITestSession;
import android.hardware.biometrics.ITestSessionCallback;
import android.hardware.biometrics.fingerprint.PointerContext;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintAuthenticateOptions;
import android.hardware.fingerprint.FingerprintEnrollOptions;
import android.hardware.fingerprint.FingerprintSensorPropertiesInternal;
import android.hardware.fingerprint.IFingerprintServiceReceiver;
import android.hardware.fingerprint.IUdfpsOverlayController;
import android.os.IBinder;
import com.android.server.biometrics.sensors.BiometricServiceProvider;
import com.android.server.biometrics.sensors.ClientMonitorCallback;
import com.android.server.biometrics.sensors.ClientMonitorCallbackConverter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ServiceProvider extends BiometricServiceProvider<FingerprintSensorPropertiesInternal> {
    void cancelAuthentication(int r1, IBinder r2, long r3);

    void cancelEnrollment(int r1, IBinder r2, long r3);

    ITestSession createTestSession(int r1, ITestSessionCallback r2, String r3);

    List<Fingerprint> getEnrolledFingerprints(int r1, int r2);

    void onPointerDown(long r1, int r3, PointerContext r4);

    void onPointerUp(long r1, int r3, PointerContext r4);

    void onPowerPressed();

    void onUdfpsUiEvent(int r1, long r2, int r4);

    void rename(int r1, int r2, int r3, String r4);

    long scheduleAuthenticate(IBinder r1, long r2, int r4, ClientMonitorCallbackConverter r5, FingerprintAuthenticateOptions r6, boolean r7, int r8, boolean r9);

    void scheduleAuthenticate(IBinder r1, long r2, int r4, ClientMonitorCallbackConverter r5, FingerprintAuthenticateOptions r6, long r7, boolean r9, int r10, boolean r11);

    long scheduleEnroll(int r1, IBinder r2, byte[] r3, int r4, IFingerprintServiceReceiver r5, String r6, int r7, FingerprintEnrollOptions r8);

    long scheduleFingerDetect(IBinder r1, ClientMonitorCallbackConverter r2, FingerprintAuthenticateOptions r3, int r4);

    void scheduleGenerateChallenge(int r1, int r2, IBinder r3, IFingerprintServiceReceiver r4, String r5);

    void scheduleInternalCleanup(int r1, int r2, ClientMonitorCallback r3);

    void scheduleInternalCleanup(int r1, int r2, ClientMonitorCallback r3, boolean r4);

    void scheduleInvalidateAuthenticatorId(int r1, int r2, IInvalidationCallback r3);

    void scheduleRemove(int r1, IBinder r2, IFingerprintServiceReceiver r3, int r4, int r5, String r6);

    void scheduleRemoveAll(int r1, IBinder r2, IFingerprintServiceReceiver r3, int r4, String r5);

    void scheduleResetLockout(int r1, int r2, byte[] r3);

    void scheduleRevokeChallenge(int r1, int r2, IBinder r3, String r4, long r5);

    void setIgnoreDisplayTouches(long r1, int r3, boolean r4);

    void setUdfpsOverlayController(IUdfpsOverlayController r1);

    void startPreparedClient(int r1, int r2);

    default void scheduleWatchdog(int sensorId) {
    }

    default void simulateVhalFingerDown(int userId, int sensorId) {
    }
}

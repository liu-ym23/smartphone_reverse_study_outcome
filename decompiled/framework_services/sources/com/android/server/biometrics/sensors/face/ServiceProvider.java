package com.android.server.biometrics.sensors.face;

import android.hardware.biometrics.IInvalidationCallback;
import android.hardware.biometrics.ITestSession;
import android.hardware.biometrics.ITestSessionCallback;
import android.hardware.face.Face;
import android.hardware.face.FaceAuthenticateOptions;
import android.hardware.face.FaceEnrollOptions;
import android.hardware.face.FaceSensorPropertiesInternal;
import android.hardware.face.IFaceServiceReceiver;
import android.os.IBinder;
import android.view.Surface;
import com.android.server.biometrics.sensors.BiometricServiceProvider;
import com.android.server.biometrics.sensors.ClientMonitorCallback;
import com.android.server.biometrics.sensors.ClientMonitorCallbackConverter;
import java.io.FileDescriptor;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ServiceProvider extends BiometricServiceProvider<FaceSensorPropertiesInternal> {
    void cancelAuthentication(int r1, IBinder r2, long r3);

    void cancelEnrollment(int r1, IBinder r2, long r3);

    void cancelFaceDetect(int r1, IBinder r2, long r3);

    ITestSession createTestSession(int r1, ITestSessionCallback r2, String r3);

    void dumpHal(int r1, FileDescriptor r2, String[] r3);

    List<Face> getEnrolledFaces(int r1, int r2);

    long scheduleAuthenticate(IBinder r1, long r2, int r4, ClientMonitorCallbackConverter r5, FaceAuthenticateOptions r6, boolean r7, int r8, boolean r9);

    void scheduleAuthenticate(IBinder r1, long r2, int r4, ClientMonitorCallbackConverter r5, FaceAuthenticateOptions r6, long r7, boolean r9, int r10, boolean r11);

    long scheduleEnroll(int r1, IBinder r2, byte[] r3, int r4, IFaceServiceReceiver r5, String r6, int[] r7, Surface r8, boolean r9, FaceEnrollOptions r10);

    long scheduleFaceDetect(IBinder r1, ClientMonitorCallbackConverter r2, FaceAuthenticateOptions r3, int r4);

    void scheduleGenerateChallenge(int r1, int r2, IBinder r3, IFaceServiceReceiver r4, String r5);

    void scheduleGetFeature(int r1, IBinder r2, int r3, int r4, ClientMonitorCallbackConverter r5, String r6);

    void scheduleInternalCleanup(int r1, int r2, ClientMonitorCallback r3);

    void scheduleInternalCleanup(int r1, int r2, ClientMonitorCallback r3, boolean r4);

    void scheduleRemove(int r1, IBinder r2, int r3, int r4, IFaceServiceReceiver r5, String r6);

    void scheduleRemoveAll(int r1, IBinder r2, int r3, IFaceServiceReceiver r4, String r5);

    void scheduleResetLockout(int r1, int r2, byte[] r3);

    void scheduleRevokeChallenge(int r1, int r2, IBinder r3, String r4, long r5);

    void scheduleSetFeature(int r1, IBinder r2, int r3, int r4, boolean r5, byte[] r6, IFaceServiceReceiver r7, String r8);

    void startPreparedClient(int r1, int r2);

    default void scheduleInvalidateAuthenticatorId(int sensorId, int userId, IInvalidationCallback callback) {
        throw new IllegalStateException("Providers that support invalidation must override this method");
    }

    default void scheduleWatchdog(int sensorId) {
    }
}

package com.android.server.biometrics.sensors.face.aidl;

import android.content.Context;
import android.hardware.keymaster.HardwareAuthToken;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.HardwareAuthTokenUtils;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.sensors.ClientMonitorCallback;
import com.android.server.biometrics.sensors.ClientMonitorCallbackConverter;
import com.android.server.biometrics.sensors.ErrorConsumer;
import com.android.server.biometrics.sensors.HalClientMonitor;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FaceSetFeatureClient extends HalClientMonitor<AidlSession> implements ErrorConsumer {
    private static final String TAG = "FaceSetFeatureClient";
    private final boolean mEnabled;
    private final int mFeature;
    private final HardwareAuthToken mHardwareAuthToken;

    public FaceSetFeatureClient(Context context, Supplier<AidlSession> lazyDaemon, IBinder token, ClientMonitorCallbackConverter listener, int userId, String owner, int sensorId, BiometricLogger logger, BiometricContext biometricContext, int feature, boolean enabled, byte[] hardwareAuthToken) {
        super(context, lazyDaemon, token, listener, userId, owner, 0, sensorId, logger, biometricContext, false);
        this.mFeature = feature;
        this.mEnabled = enabled;
        this.mHardwareAuthToken = HardwareAuthTokenUtils.toHardwareAuthToken(hardwareAuthToken);
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    public void unableToStart() {
        getListener().onFeatureSet(false, this.mFeature);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Unable to send error", e);
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        startHalOperation();
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    protected void startHalOperation() {
        getFreshDaemon().getSession().setFeature(this.mHardwareAuthToken, AidlConversionUtils.convertFrameworkToAidlFeature(this.mFeature), this.mEnabled);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Unable to set feature: " + this.mFeature + " to enabled: " + this.mEnabled, e);
        this.mCallback.onClientFinished(this, false);
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public int getProtoEnum() {
        return 8;
    }

    public void onFeatureSet(boolean success) {
        getListener().onFeatureSet(success, this.mFeature);     // Catch: RemoteException -> L4
    L6:
        this.mCallback.onClientFinished(this, true);
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        goto L6
    }

    @Override // com.android.server.biometrics.sensors.ErrorConsumer
    public void onError(int errorCode, int vendorCode) {
        getListener().onFeatureSet(false, this.mFeature);     // Catch: RemoteException -> L5
    L7:
        this.mCallback.onClientFinished(this, false);
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        goto L7
    }
}

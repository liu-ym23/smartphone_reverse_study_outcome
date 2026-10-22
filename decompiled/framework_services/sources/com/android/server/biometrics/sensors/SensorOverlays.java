package com.android.server.biometrics.sensors;

import android.hardware.fingerprint.IUdfpsOverlayController;
import android.hardware.fingerprint.IUdfpsOverlayControllerCallback;
import android.os.RemoteException;
import android.util.Slog;
import java.util.Optional;

/* JADX INFO: loaded from: classes.dex */
public final class SensorOverlays {
    private static final String TAG = "SensorOverlays";
    private final Optional<IUdfpsOverlayController> mUdfpsOverlayController;

    @FunctionalInterface
    public interface OverlayControllerConsumer<T> {
        void accept(T r1) throws RemoteException;
    }

    public SensorOverlays(IUdfpsOverlayController udfpsOverlayController) {
        this.mUdfpsOverlayController = Optional.ofNullable(udfpsOverlayController);
    }

    public void show(int sensorId, int reason, final AcquisitionClient<?> client) {
        if (this.mUdfpsOverlayController.isPresent() == false) goto L15;
        IUdfpsOverlayControllerCallback.Stub r0 = new AnonymousClass1(this, client);
        this.mUdfpsOverlayController.get().showUdfpsOverlay(client.getRequestId(), sensorId, reason, r0);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        RemoteException e = e;
    L13:
        Slog.e(TAG, "Remote exception when showing the UDFPS overlay", e);
        return;
    L11:
        e = move-exception;
        e = e;
        goto L13
    }

    public void hide(int sensorId) {
        if (this.mUdfpsOverlayController.isPresent() == false) goto L11;
        this.mUdfpsOverlayController.get().hideUdfpsOverlay(sensorId);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Remote exception when hiding the UDFPS overlay", e);
        return;
    }

    public void ifUdfps(OverlayControllerConsumer<IUdfpsOverlayController> consumer) {
        if (this.mUdfpsOverlayController.isPresent() == false) goto L11;
        consumer.accept(this.mUdfpsOverlayController.get());     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Remote exception using overlay controller", e);
        return;
    }
}

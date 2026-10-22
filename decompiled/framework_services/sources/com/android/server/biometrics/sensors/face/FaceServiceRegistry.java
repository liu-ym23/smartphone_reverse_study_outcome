package com.android.server.biometrics.sensors.face;

import android.hardware.biometrics.IBiometricService;
import android.hardware.biometrics.SensorPropertiesInternal;
import android.hardware.face.FaceSensorPropertiesInternal;
import android.hardware.face.IFaceAuthenticatorsRegisteredCallback;
import android.hardware.face.IFaceService;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.Utils;
import com.android.server.biometrics.sensors.BiometricServiceRegistry;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FaceServiceRegistry extends BiometricServiceRegistry<ServiceProvider, FaceSensorPropertiesInternal, IFaceAuthenticatorsRegisteredCallback> {
    private static final String TAG = "FaceServiceRegistry";
    private final IFaceService mService;

    @Override // com.android.server.biometrics.sensors.BiometricServiceRegistry
    protected /* bridge */ /* synthetic */ void invokeRegisteredCallback(IInterface r1, List r2) throws RemoteException {
        invokeRegisteredCallback((IFaceAuthenticatorsRegisteredCallback) r1, r2);
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceRegistry
    protected /* bridge */ /* synthetic */ void registerService(IBiometricService r1, SensorPropertiesInternal r2) {
        registerService(r1, (FaceSensorPropertiesInternal) r2);
    }

    public FaceServiceRegistry(IFaceService service, Supplier<IBiometricService> biometricSupplier) {
        super(biometricSupplier);
        this.mService = service;
    }

    protected void registerService(IBiometricService service, FaceSensorPropertiesInternal props) {
        int strength = Utils.propertyStrengthToAuthenticatorStrength(props.sensorStrength);
        service.registerAuthenticator(props.sensorId, 8, strength, new FaceAuthenticator(this.mService, props.sensorId));     // Catch: RemoteException -> L5
        return;
    L6:
        Slog.e(TAG, "Remote exception when registering sensorId: " + props.sensorId);
    }

    protected void invokeRegisteredCallback(IFaceAuthenticatorsRegisteredCallback callback, List<FaceSensorPropertiesInternal> allProps) throws RemoteException {
        callback.onAllAuthenticatorsRegistered(allProps);
    }
}

package com.android.server.biometrics.sensors.fingerprint;

import android.hardware.biometrics.IBiometricService;
import android.hardware.biometrics.SensorPropertiesInternal;
import android.hardware.fingerprint.FingerprintSensorPropertiesInternal;
import android.hardware.fingerprint.IFingerprintAuthenticatorsRegisteredCallback;
import android.hardware.fingerprint.IFingerprintService;
import android.os.IInterface;
import android.os.RemoteException;
import android.pico.utils.ExtImplFactory;
import android.util.Slog;
import com.android.server.biometrics.Utils;
import com.android.server.biometrics.sensors.BiometricServiceRegistry;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintServiceRegistry extends BiometricServiceRegistry<ServiceProvider, FingerprintSensorPropertiesInternal, IFingerprintAuthenticatorsRegisteredCallback> {
    private static final String TAG = "FingerprintServiceRegistry";
    private IExtFingerprintServiceRegistry mExt;
    private final IFingerprintService mService;

    @Override // com.android.server.biometrics.sensors.BiometricServiceRegistry
    protected /* bridge */ /* synthetic */ void invokeRegisteredCallback(IInterface r1, List r2) throws RemoteException {
        invokeRegisteredCallback((IFingerprintAuthenticatorsRegisteredCallback) r1, r2);
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceRegistry
    protected /* bridge */ /* synthetic */ void registerService(IBiometricService r1, SensorPropertiesInternal r2) {
        registerService(r1, (FingerprintSensorPropertiesInternal) r2);
    }

    public FingerprintServiceRegistry(IFingerprintService service, Supplier<IBiometricService> biometricSupplier) {
        super(biometricSupplier);
        this.mExt = (IExtFingerprintServiceRegistry) ExtImplFactory.getImpl(IExtFingerprintServiceRegistry.class, new Object[]{this});
        this.mService = service;
    }

    protected void registerService(IBiometricService service, FingerprintSensorPropertiesInternal props) {
        int strength = Utils.propertyStrengthToAuthenticatorStrength(props.sensorStrength);
        service.registerAuthenticator(props.sensorId, 2, strength, new FingerprintAuthenticator(this.mService, props.sensorId));     // Catch: RemoteException -> L5
        return;
    L6:
        Slog.e(TAG, "Remote exception when registering sensorId: " + props.sensorId);
    }

    protected void invokeRegisteredCallback(IFingerprintAuthenticatorsRegisteredCallback callback, List<FingerprintSensorPropertiesInternal> allProps) throws RemoteException {
        Slog.d(TAG, "invokeRegisteredCallback mAllProps = " + this.mAllProps + " allProps=" + allProps);
        callback.onAllAuthenticatorsRegistered(allProps);
    }

    public IExtFingerprintServiceRegistry getExt() {
        return this.mExt;
    }
}

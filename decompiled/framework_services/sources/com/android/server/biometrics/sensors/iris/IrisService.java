package com.android.server.biometrics.sensors.iris;

import android.content.Context;
import android.hardware.biometrics.IBiometricService;
import android.hardware.biometrics.SensorPropertiesInternal;
import android.hardware.iris.IIrisService;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;
import com.android.server.ServiceThread;
import com.android.server.SystemService;
import com.android.server.biometrics.Utils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class IrisService extends SystemService {
    private static final String TAG = "IrisService";
    private final IrisServiceWrapper mServiceWrapper;

    private final class IrisServiceWrapper extends IIrisService.Stub {
        final /* synthetic */ IrisService this$0;

        public static /* synthetic */ void $r8$lambda$AhWuzcJztNc7Ub7QKvzOT_kiMEM(IrisServiceWrapper r0, List r1) {
            r0.lambda$registerAuthenticators$0(r1);
        }

        /* synthetic */ IrisServiceWrapper(IrisService r1, IrisServiceIA r2) {
            this(r1);
        }

        private IrisServiceWrapper(IrisService r1) {
            this.this$0 = r1;
        }

        public void registerAuthenticators(final List<SensorPropertiesInternal> hidlSensors) {
            super.registerAuthenticators_enforcePermission();
            ServiceThread thread = new ServiceThread(IrisService.TAG, 10, true);
            thread.start();
            Handler handler = new Handler(thread.getLooper());
            handler.post(new IrisService$IrisServiceWrapper$$ExternalSyntheticLambda0(this, hidlSensors));
        }

        private /* synthetic */ void lambda$registerAuthenticators$0(List hidlSensors) {
            IBiometricService biometricService = IBiometricService.Stub.asInterface(ServiceManager.getService("biometric"));
            Iterator r1 = hidlSensors.iterator();
        L4:
            if (r1.hasNext() == false) goto L11;
            SensorPropertiesInternal hidlSensor = (SensorPropertiesInternal) r1.next();
            int sensorId = hidlSensor.sensorId;
            int strength = Utils.propertyStrengthToAuthenticatorStrength(hidlSensor.sensorStrength);
            IrisAuthenticator authenticator = new IrisAuthenticator(IrisService.m2756$$Nest$fgetmServiceWrapper(this.this$0), sensorId);
            biometricService.registerAuthenticator(sensorId, 4, strength, authenticator);     // Catch: RemoteException -> L8
        L9:
            Slog.e(IrisService.TAG, "Remote exception when registering sensorId: " + sensorId);
            goto L4
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceWrapper, reason: not valid java name */
    static /* bridge */ /* synthetic */ IrisServiceWrapper m2756$$Nest$fgetmServiceWrapper(IrisService r0) {
        return r0.mServiceWrapper;
    }

    public IrisService(Context context) {
        super(context);
        this.mServiceWrapper = new IrisServiceWrapper(this, null);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("iris", this.mServiceWrapper);
    }
}

package android.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.IStepOSFingerprintService;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.util.List;

/* loaded from: classes.dex */
public final class StepOSFingerprintManager {
    private static final String TAG = "StepOSFingerprintManager";
    private static StepOSFingerprintManager sInstance;
    private final Context mContext;
    private final IStepOSFingerprintService mService;

    public static StepOSFingerprintManager getInstance(Context context) {
        StepOSFingerprintManager stepOSFingerprintManager;
        synchronized (StepOSFingerprintManager.class) {
            if (sInstance == null) {
                sInstance = new StepOSFingerprintManager(context);
            }
            stepOSFingerprintManager = sInstance;
        }
        return stepOSFingerprintManager;
    }

    private StepOSFingerprintManager(Context context) {
        IStepOSFingerprintService service = null;
        IBinder fp = ServiceManager.getService("fingerprint");
        if (fp != null) {
            try {
                IBinder ext = fp.getExtension();
                if (ext != null) {
                    service = IStepOSFingerprintService.Stub.asInterface(ext);
                }
            } catch (RemoteException ignored) {
                Log.e(TAG, "getLockoutTimestamp: get service failed", ignored);
            }
        }
        this.mService = service;
        this.mContext = context;
    }

    public long getLockoutTimestamp(int userId) {
        if (this.mContext == null) {
            Log.e(TAG, "getLockoutTimestamp: context is null");
            return 0L;
        }
        FingerprintManager fm = (FingerprintManager) this.mContext.getSystemService(FingerprintManager.class);
        if (fm == null) {
            Log.e(TAG, "getLockoutTimestamp: fingerprint manager is null");
            return 0L;
        }
        List<FingerprintSensorPropertiesInternal> props = fm.getSensorPropertiesInternal();
        if (props.isEmpty()) {
            Log.e(TAG, "getLockoutTimestamp: sensor properties is empty");
            return 0L;
        }
        return getLockoutTimestamp(userId, props.get(0).sensorId);
    }

    public long getLockoutTimestamp(int userId, int sensorId) {
        if (this.mService == null) {
            Log.e(TAG, "getLockoutTimestamp: service is null");
            return 0L;
        }
        try {
            return this.mService.getLockoutTimestamp(userId, sensorId);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean hasClient() {
        if (this.mService == null) {
            Log.e(TAG, "hasClient: service is null");
            return false;
        }
        try {
            return this.mService.hasClient();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }
}

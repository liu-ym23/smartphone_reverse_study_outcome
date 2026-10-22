package android.hardware.display;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes.dex */
public class StepOSDeviceControlManager {
    private static final String TAG = "StepOSDeviceControlManager";
    private final IStepOSDeviceControlService mService;

    public StepOSDeviceControlManager(Context context, IStepOSDeviceControlService service) {
        this.mService = service;
    }

    public boolean isForceKeptAwake() {
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.isForceKeptAwake();
        } catch (RemoteException e) {
            Log.e(TAG, "isForceKeptAwake failed", e);
            return false;
        }
    }

    public void setPowerModeForCast(int displayId) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setPowerModeForCast(displayId);
        } catch (RemoteException e) {
            Log.e(TAG, "setPowerModeForCast failed", e);
        }
    }
}

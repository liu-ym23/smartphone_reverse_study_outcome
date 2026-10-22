package android.hardware.input;

import android.graphics.Rect;
import android.hardware.display.BackScreenAnimationInfo;
import android.hardware.input.IStepOSInputManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.util.Objects;

/* loaded from: classes.dex */
public final class StepOSInputManager {
    private static final String TAG = "StepOSInputManager";
    private volatile IStepOSInputManager mService;

    private static final class InstanceHolder {
        private static final StepOSInputManager INSTANCE = new StepOSInputManager();

        private InstanceHolder() {
        }
    }

    private StepOSInputManager() {
    }

    public static StepOSInputManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void updateInputMonitorTouchRegionWithCrop(IBinder inputChannelToken, Rect region) {
        Objects.requireNonNull(inputChannelToken, "inputChannelToken");
        IStepOSInputManager service = getService();
        if (service == null) {
            return;
        }
        try {
            service.updateInputMonitorTouchRegionWithCrop(inputChannelToken, region);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    private IStepOSInputManager getService() {
        IStepOSInputManager service = this.mService;
        if (service != null) {
            return service;
        }
        IBinder inputBinder = ServiceManager.getService(BackScreenAnimationInfo.TYPE_INPUT);
        if (inputBinder == null) {
            Log.w(TAG, "Input service is not ready");
            return null;
        }
        try {
            IBinder extension = inputBinder.getExtension();
            if (extension == null) {
                Log.w(TAG, "Input service extension is not ready");
                return null;
            }
            IStepOSInputManager service2 = IStepOSInputManager.Stub.asInterface(extension);
            this.mService = service2;
            return service2;
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }
}

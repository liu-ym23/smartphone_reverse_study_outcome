package stepos.os;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.util.Log;
import stepos.os.IDeviceStateService;

/* loaded from: classes.dex */
public class DeviceStateManager {
    private static final int ERROR_SERVICE_UNAVAILABLE = -3;
    private static final String SERVICE_NAME = "device_states";
    private static final String TAG = "DeviceStateManager";

    public enum RemoteHandle {
        None(0),
        Root(1),
        Unroot(2),
        Lock(3),
        Lock_Report_Loss(4),
        Unlock(5),
        Screen_Password(6);

        private final int mValue;

        RemoteHandle(int value) {
            this.mValue = value;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    private DeviceStateManager() {
    }

    public static boolean isCtsRunningStatic() {
        return SystemProperties.getBoolean("persist.sys.cts_state", false);
    }

    public static int doCheckState(int handle) {
        try {
            IDeviceStateService service = getService();
            if (service != null) {
                return service.doCheckState(handle);
            }
            return ERROR_SERVICE_UNAVAILABLE;
        } catch (RemoteException e) {
            Log.e(TAG, "doCheckState failed for handle=" + handle, e);
            return ERROR_SERVICE_UNAVAILABLE;
        }
    }

    public static int doCommand(int handle, byte[] rsaData) {
        try {
            IDeviceStateService service = getService();
            if (service != null) {
                return service.doCommand(handle, rsaData);
            }
            return ERROR_SERVICE_UNAVAILABLE;
        } catch (RemoteException e) {
            Log.e(TAG, "doCommand failed for handle=" + handle, e);
            return ERROR_SERVICE_UNAVAILABLE;
        }
    }

    public static int lockRecoveryUncheckedByHandle(int handle) {
        try {
            IDeviceStateService service = getService();
            if (service != null) {
                return service.lockRecoveryUncheckedByHandle(handle);
            }
            return ERROR_SERVICE_UNAVAILABLE;
        } catch (RemoteException e) {
            Log.e(TAG, "lockRecoveryUncheckedByHandle failed for handle=" + handle, e);
            return ERROR_SERVICE_UNAVAILABLE;
        }
    }

    private static IDeviceStateService getService() {
        IBinder binder = ServiceManager.getService("device_states");
        if (binder == null) {
            Log.w(TAG, "device_states service not available");
            return null;
        }
        return IDeviceStateService.Stub.asInterface(binder);
    }

    public static void setWipeAuthorized(boolean authorized) {
        IDeviceStateService svc = getService();
        if (svc == null) {
            Log.e(TAG, "setWipeAuthorized: device_states service not available");
            return;
        }
        try {
            svc.setWipeAuthorized(authorized);
        } catch (RemoteException e) {
            Log.e(TAG, "setWipeAuthorized RemoteException", e);
        }
    }
}

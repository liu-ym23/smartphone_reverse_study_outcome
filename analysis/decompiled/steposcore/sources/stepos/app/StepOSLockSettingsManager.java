package stepos.app;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import stepos.app.IStepOSLockSettings;

/* loaded from: classes.dex */
public class StepOSLockSettingsManager extends StepOSCommonManager {
    public static final int MAX_TIMES_OF_CHECK_PASSWORD = 15;
    private static final String TAG = "StepOSLockSettingsManager";
    public static final int TYPE_APP_LOCK = 0;
    public static final int TYPE_DOCUMENT = 1;
    public static final int TYPE_MINOR_MODE = 5;
    public static final int TYPE_NOTES = 4;
    public static final int TYPE_PRIVATE_MODE = 2;
    public static final int TYPE_SCREEN_PASSWORD_FRONT_FOUR = 3;
    private final IStepOSLockSettings mService;

    private static final class InstanceHolder {
        private static final StepOSLockSettingsManager INSTANCE = new StepOSLockSettingsManager();

        private InstanceHolder() {
        }
    }

    public static StepOSLockSettingsManager get() {
        return InstanceHolder.INSTANCE;
    }

    private StepOSLockSettingsManager() {
        super("lock_settings");
        IStepOSLockSettings stub = null;
        try {
            if (this.mRemote != null) {
                IBinder extension = this.mRemote.getExtension();
                stub = IStepOSLockSettings.Stub.asInterface(extension);
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to init stepos lock-settings manager", e);
        }
        this.mService = stub;
    }

    public boolean setStepOSPassword(int type, String password, int userId) {
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.setStepOSPassword(type, password, userId);
        } catch (RemoteException e) {
            Log.e(TAG, "setStepOSPassword failed", e);
            return false;
        }
    }

    public boolean checkStepOSPassword(int type, String password, int userId) {
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.checkStepOSPassword(type, password, userId);
        } catch (RemoteException e) {
            Log.e(TAG, "checkStepOSPassword failed", e);
            return false;
        }
    }

    public boolean hasStepOSPassword(int type, int userId) {
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.hasStepOSPassword(type, userId);
        } catch (RemoteException e) {
            Log.e(TAG, "hasStepOSPassword failed", e);
            return false;
        }
    }

    public boolean clearStepOSPassword(int type, int userId) {
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.clearStepOSPassword(type, userId);
        } catch (RemoteException e) {
            Log.e(TAG, "clearStepOSPassword failed", e);
            return false;
        }
    }

    public void writePasswordHash(byte[] hash, int type, int userId) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.writePasswordHash(hash, type, userId);
        } catch (RemoteException e) {
            Log.e(TAG, "writePasswordHash failed", e);
        }
    }

    public int stepOSProcessLeftTimes(boolean reset) {
        if (this.mService == null) {
            return 15;
        }
        try {
            return this.mService.stepOSProcessLeftTimes(reset);
        } catch (RemoteException e) {
            Log.e(TAG, "stepOSProcessLeftTimes failed", e);
            return 15;
        }
    }
}

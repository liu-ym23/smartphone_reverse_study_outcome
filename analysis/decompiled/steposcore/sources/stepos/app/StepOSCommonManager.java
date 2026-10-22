package stepos.app;

import android.os.IBinder;
import android.os.ServiceManager;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class StepOSCommonManager {
    private static final String TAG = "StepOSCommonManager";
    protected final IBinder mRemote;

    public StepOSCommonManager(String name) {
        IBinder service = ServiceManager.getService(name);
        this.mRemote = service;
        if (service == null) {
            Log.w(TAG, "Failed to resolve service with name " + name);
        }
    }
}

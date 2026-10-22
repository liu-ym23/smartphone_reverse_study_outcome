package android.app;

import android.annotation.SystemApi;
import android.content.Context;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.util.Log;
import com.stepos.preload.IPreloadService;

@SystemApi
/* loaded from: classes.dex */
public class PreloadManager {
    public static final String SERVICE_NAME = "preload";
    private static final String TAG = "PreloadManager";
    private final Context mContext;
    private final IPreloadService mService;

    public PreloadManager(Context context) {
        this(context, IPreloadService.Stub.asInterface(ServiceManager.getService(SERVICE_NAME)));
    }

    public PreloadManager(Context context, IPreloadService service) {
        this.mContext = context;
        this.mService = service;
    }

    public void requestPreloadOnTouchDown(String packageName, UserHandle user) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.requestPreloadOnTouchDown(packageName, user);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to request preload on touch down", e);
        }
    }

    public void requestPreloadOnTouchUp(String packageName, UserHandle user) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.requestPreloadOnTouchUp(packageName, user);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to request preload on touch up", e);
        }
    }

    public void cancelPreload(String packageName, UserHandle user) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.cancelPreload(packageName, user);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to cancel preload", e);
        }
    }
}

package android.hardware.face;

import android.content.Context;
import android.hardware.face.IStepOSFaceService;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes.dex */
public final class StepOSFaceManager {
    private static final String TAG = "StepOSFaceManager";
    private static StepOSFaceManager sInstance;
    private final Context mContext;
    private final IStepOSFaceService mService;

    public static StepOSFaceManager getInstance(Context context) {
        StepOSFaceManager stepOSFaceManager;
        synchronized (StepOSFaceManager.class) {
            if (sInstance == null) {
                sInstance = new StepOSFaceManager(context);
            }
            stepOSFaceManager = sInstance;
        }
        return stepOSFaceManager;
    }

    private StepOSFaceManager(Context context) {
        IStepOSFaceService service = null;
        IBinder face = ServiceManager.getService("face");
        if (face != null) {
            try {
                IBinder ext = face.getExtension();
                if (ext != null) {
                    service = IStepOSFaceService.Stub.asInterface(ext);
                }
            } catch (RemoteException e) {
                Log.e(TAG, "getInstance: get extension failed", e);
            }
        }
        this.mService = service;
        this.mContext = context.getApplicationContext();
    }

    public void rename(int faceId, int userId, String newName) {
        if (TextUtils.isEmpty(newName)) {
            Log.w(TAG, "rename: empty name");
        } else {
            if (this.mService == null) {
                Log.e(TAG, "rename: service is null");
                return;
            }
            try {
                this.mService.renameFace(faceId, userId, newName);
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }
}

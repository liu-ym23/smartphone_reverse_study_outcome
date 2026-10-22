package stepos.app;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public final class StepOSGestureManager {
    public static final String SERVICE_NAME = "stepos_gesture";
    private static final String TAG = "StepOSGestureManager";
    private final Context mContext;
    private final IStepOSGestureManager mService;

    public StepOSGestureManager(Context context, IStepOSGestureManager service) {
        this.mContext = context;
        this.mService = service;
    }

    public void registerCallback(IStepOSGestureCallback callback, String tag) {
        if (this.mService == null) {
            Log.w(TAG, "service is null, registerCallback dropped");
            return;
        }
        try {
            this.mService.registerCallback(callback, tag);
        } catch (RemoteException e) {
            Log.w(TAG, "registerCallback failed", e);
        }
    }

    public void unregisterCallback(IStepOSGestureCallback callback) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.unregisterCallback(callback);
        } catch (RemoteException e) {
            Log.w(TAG, "unregisterCallback failed", e);
        }
    }

    public void triggerGesture(KeyEvent gesture, MotionEvent motionEvent) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.triggerGesture(gesture, motionEvent);
        } catch (RemoteException e) {
            Log.w(TAG, "triggerGesture failed", e);
        }
    }

    public void setPressureAreaEnabled(int areaCode, boolean enabled) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setPressureAreaEnabled(areaCode, enabled);
        } catch (RemoteException e) {
            Log.w(TAG, "setPressureAreaEnabled failed", e);
        }
    }
}

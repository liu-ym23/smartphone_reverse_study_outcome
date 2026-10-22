package stepos.inputmethod;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.Log;
import stepos.app.IStepOSWindowManager;
import stepos.app.StepOSWindowManager;
import stepos.inputmethod.ISecureInputManager;
import stepos.inputmethod.ISecureInputModeListener;

/* loaded from: classes.dex */
public class SecureInputManager {
    private static final String SERVICE_NAME = "secure_input";
    private static final String TAG = "SecureInputManager";
    private static volatile SecureInputManager sInstance;
    private final ArrayMap<SecureInputModeListener, ListenerWrapper> mListenerMap = new ArrayMap<>();
    private ISecureInputManager mService;

    private SecureInputManager() {
    }

    public static SecureInputManager getInstance() {
        if (sInstance == null) {
            synchronized (SecureInputManager.class) {
                if (sInstance == null) {
                    sInstance = new SecureInputManager();
                }
            }
        }
        return sInstance;
    }

    private synchronized ISecureInputManager getService() {
        IStepOSWindowManager wm;
        if (this.mService != null && this.mService.asBinder().isBinderAlive()) {
            return this.mService;
        }
        this.mService = null;
        try {
            try {
            } catch (RemoteException e) {
                e = e;
            }
        } catch (Throwable t) {
            Log.w(TAG, "getService: StepOSWindowManager not available", t);
        }
        try {
            wm = StepOSWindowManager.getInstance().getService();
        } catch (RemoteException e2) {
            e = e2;
            Log.w(TAG, "getService", e);
            return this.mService;
        }
        if (wm == null) {
            return null;
        }
        IBinder binder = wm.getSubService(SERVICE_NAME);
        if (binder == null) {
            return null;
        }
        this.mService = ISecureInputManager.Stub.asInterface(binder);
        return this.mService;
    }

    public void exitSecureMode() {
        ISecureInputManager svc = getService();
        if (svc == null) {
            return;
        }
        try {
            svc.exitSecureMode();
        } catch (RemoteException e) {
            Log.w(TAG, "exitSecureMode", e);
            this.mService = null;
        }
    }

    public boolean isSecureModeActive() {
        ISecureInputManager svc = getService();
        if (svc == null) {
            return false;
        }
        try {
            return svc.isSecureModeActive();
        } catch (RemoteException e) {
            Log.w(TAG, "isSecureModeActive", e);
            this.mService = null;
            return false;
        }
    }

    public void registerSecureModeListener(SecureInputModeListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener must not be null");
        }
        ISecureInputManager svc = getService();
        if (svc == null) {
            return;
        }
        synchronized (this.mListenerMap) {
            if (this.mListenerMap.containsKey(listener)) {
                return;
            }
            ListenerWrapper wrapper = new ListenerWrapper(listener);
            try {
                svc.registerSecureModeListener(wrapper);
                this.mListenerMap.put(listener, wrapper);
            } catch (RemoteException e) {
                Log.w(TAG, "registerSecureModeListener", e);
                this.mService = null;
            }
        }
    }

    public void unregisterSecureModeListener(SecureInputModeListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener must not be null");
        }
        ISecureInputManager svc = getService();
        if (svc == null) {
            return;
        }
        synchronized (this.mListenerMap) {
            ListenerWrapper wrapper = this.mListenerMap.remove(listener);
            if (wrapper == null) {
                return;
            }
            try {
                svc.unregisterSecureModeListener(wrapper);
            } catch (RemoteException e) {
                Log.w(TAG, "unregisterSecureModeListener", e);
                this.mService = null;
            }
        }
    }

    private static class ListenerWrapper extends ISecureInputModeListener.Stub {
        private final SecureInputModeListener mDelegate;

        ListenerWrapper(SecureInputModeListener delegate) {
            this.mDelegate = delegate;
        }

        @Override // stepos.inputmethod.ISecureInputModeListener
        public void onSecureModeChanged(boolean active) {
            this.mDelegate.onSecureModeChanged(active);
        }
    }
}

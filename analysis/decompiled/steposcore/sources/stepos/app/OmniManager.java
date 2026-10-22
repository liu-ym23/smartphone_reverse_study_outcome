package stepos.app;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Slog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import stepos.app.IOmniDisplayCallback;

/* loaded from: classes.dex */
public class OmniManager {
    private static final String KEY_RESTARTING = "key_restarting";
    private static final String KEY_SET_REDIRECT_ACTIVITY = "setRedirectActivity";
    private static final String PARAM_COMPONENT = "component";
    private static final String TAG = "OmniManager";
    private static final Object mLock = new Object();
    private static final ArrayList<CallbackPair> sCallbacks = new ArrayList<>();
    private static IOmniDisplayCallback mOmniDisplayCallback = null;

    private OmniManager() {
    }

    public static Bundle omniCall(String key, Bundle params) {
        try {
            IStepOSWindowManager service = StepOSWindowManager.getInstance().getService();
            if (service != null) {
                return service.omniCall(key, params);
            }
            return null;
        } catch (RemoteException e) {
            Slog.e(TAG, "omniCall failed for key=" + key, e);
            return null;
        }
    }

    public static void setRedirectActivity(ComponentName component) {
        Bundle params = new Bundle();
        if (component != null) {
            params.putString(PARAM_COMPONENT, component.flattenToString());
        }
        omniCall(KEY_SET_REDIRECT_ACTIVITY, params);
    }

    public static void addOmniDisplayCallback(Handler handler, int message) {
        if (handler == null) {
            Slog.w(TAG, "addOmniDisplayCallback: handler is null");
            return;
        }
        CallbackPair newPair = new CallbackPair(handler, message);
        boolean shouldRegisterGlobal = false;
        synchronized (mLock) {
            if (sCallbacks.contains(newPair)) {
                return;
            }
            if (sCallbacks.isEmpty()) {
                shouldRegisterGlobal = true;
            }
            sCallbacks.add(newPair);
            if (shouldRegisterGlobal) {
                registerGlobalListener();
            }
        }
    }

    public static void removeOmniDisplayCallback(Handler handler, int message) {
        if (handler == null) {
            return;
        }
        CallbackPair targetPair = new CallbackPair(handler, message);
        boolean shouldUnregisterGlobal = false;
        synchronized (mLock) {
            Iterator<CallbackPair> iterator = sCallbacks.iterator();
            boolean removed = false;
            while (true) {
                if (!iterator.hasNext()) {
                    break;
                }
                if (iterator.next().equals(targetPair)) {
                    iterator.remove();
                    removed = true;
                    break;
                }
            }
            if (removed) {
                if (sCallbacks.isEmpty()) {
                    shouldUnregisterGlobal = true;
                }
                if (shouldUnregisterGlobal) {
                    unregisterGlobalListener();
                }
            }
        }
    }

    private static void registerGlobalListener() {
        synchronized (mLock) {
            if (mOmniDisplayCallback != null) {
                return;
            }
            mOmniDisplayCallback = new OmniDisplayListener();
            try {
                IStepOSWindowManager service = StepOSWindowManager.getInstance().getService();
                if (service != null) {
                    service.registerOmniDisplayCallback(mOmniDisplayCallback);
                } else {
                    Slog.e(TAG, "Cannot register listener: service unavailable");
                    synchronized (mLock) {
                        mOmniDisplayCallback = null;
                    }
                }
            } catch (RemoteException e) {
                Slog.e(TAG, "Failed to register OmniDisplayCallback", e);
                synchronized (mLock) {
                    mOmniDisplayCallback = null;
                }
            }
        }
    }

    private static void unregisterGlobalListener() {
        IOmniDisplayCallback callback;
        synchronized (mLock) {
            callback = mOmniDisplayCallback;
            mOmniDisplayCallback = null;
        }
        if (callback == null) {
            return;
        }
        try {
            IStepOSWindowManager service = StepOSWindowManager.getInstance().getService();
            if (service != null) {
                service.unregisterOmniDisplayCallback(callback);
            }
        } catch (RemoteException e) {
            Slog.e(TAG, "Failed to unregister OmniDisplayCallback", e);
        }
    }

    static class OmniDisplayListener extends IOmniDisplayCallback.Stub {
        OmniDisplayListener() {
        }

        @Override // stepos.app.IOmniDisplayCallback
        public void handleAppDied(int uid, String packageName, int displayId, boolean restarting) {
            synchronized (OmniManager.mLock) {
                if (OmniManager.sCallbacks.isEmpty()) {
                    return;
                }
                ArrayList<CallbackPair> callbacksToNotify = new ArrayList<>(OmniManager.sCallbacks);
                Iterator<CallbackPair> it = callbacksToNotify.iterator();
                while (it.hasNext()) {
                    CallbackPair pair = it.next();
                    try {
                        Message msg = Message.obtain(pair.mHandler, pair.mMessage);
                        msg.arg1 = uid;
                        msg.obj = packageName;
                        msg.arg2 = displayId;
                        Bundle data = new Bundle();
                        data.putBoolean("key_restarting", restarting);
                        msg.setData(data);
                        pair.mHandler.sendMessage(msg);
                    } catch (Exception e) {
                        Slog.e(OmniManager.TAG, "Error dispatching handleAppDied", e);
                    }
                }
            }
        }
    }

    static class CallbackPair {
        public final Handler mHandler;
        public final int mMessage;

        public CallbackPair(Handler h, int m) {
            this.mHandler = h;
            this.mMessage = m;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CallbackPair that = (CallbackPair) o;
            if (this.mMessage == that.mMessage && Objects.equals(this.mHandler, that.mHandler)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.mHandler, Integer.valueOf(this.mMessage));
        }
    }
}

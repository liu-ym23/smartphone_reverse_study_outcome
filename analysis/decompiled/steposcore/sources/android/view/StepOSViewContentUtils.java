package android.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import stepos.app.IOmniDisplayCallback;
import stepos.app.IStepOSActivityManager;
import stepos.app.StepOSWindowManager;

/* loaded from: classes.dex */
public class StepOSViewContentUtils {
    public static final String KEY_RESTARTING = "key_restarting";
    private static final String TAG = "StepOSViewContentUtils";
    private static final Object sCallbackLock = new Object();
    private static final ArrayList<CallbackPair> sCallbacks = new ArrayList<>();
    private static IOmniDisplayCallback sOmniDisplayCallback = null;

    private StepOSViewContentUtils() {
    }

    private static IStepOSActivityManager getStepOSActivityManagerLocked() {
        IBinder service = ServiceManager.getService("activity");
        if (service == null) {
            Log.w(TAG, "getStepOSActivityManagerLocked: activity service is null");
            return null;
        }
        try {
            IBinder extension = service.getExtension();
            return IStepOSActivityManager.Stub.asInterface(extension);
        } catch (Exception e) {
            Log.e(TAG, "getStepOSActivityManagerLocked: failed", e);
            return null;
        }
    }

    private static IStepOSActivityManager requireStepOSAm(String caller) {
        IStepOSActivityManager am = getStepOSActivityManagerLocked();
        if (am == null) {
            Log.e(TAG, caller + ": IStepOSActivityManager is null");
        }
        return am;
    }

    public static void setApexService(Intent intent) {
        IStepOSActivityManager am = requireStepOSAm("setApexService");
        if (am == null) {
            return;
        }
        try {
            am.setApexService(intent);
        } catch (RemoteException ex) {
            Log.e(TAG, "setApexService: error " + ex.getMessage());
        }
    }

    public static void apexRequest(Intent intent) {
        IStepOSActivityManager am = requireStepOSAm("apexRequest");
        if (am == null) {
            return;
        }
        try {
            am.apexRequest(intent);
        } catch (RemoteException ex) {
            Log.e(TAG, "apexRequest: error " + ex.getMessage());
        }
    }

    private static final class CallbackPair {
        final Handler mHandler;
        final int mMessage;

        CallbackPair(Handler h, int m) {
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

    private static final class OmniDisplayListener extends IOmniDisplayCallback.Stub {
        private OmniDisplayListener() {
        }

        @Override // stepos.app.IOmniDisplayCallback
        public void handleAppDied(int uid, String packageName, int displayId, boolean restarting) {
            synchronized (StepOSViewContentUtils.sCallbackLock) {
                if (StepOSViewContentUtils.sCallbacks.isEmpty()) {
                    return;
                }
                ArrayList<CallbackPair> snapshot = new ArrayList<>(StepOSViewContentUtils.sCallbacks);
                Iterator<CallbackPair> it = snapshot.iterator();
                while (it.hasNext()) {
                    CallbackPair pair = it.next();
                    try {
                        Message msg = Message.obtain(pair.mHandler, pair.mMessage);
                        msg.arg1 = uid;
                        msg.arg2 = displayId;
                        msg.obj = packageName;
                        Bundle data = new Bundle();
                        data.putBoolean(StepOSViewContentUtils.KEY_RESTARTING, restarting);
                        msg.setData(data);
                        if (!pair.mHandler.sendMessage(msg)) {
                            Log.w(StepOSViewContentUtils.TAG, "Failed to send message to handler: " + pair.mHandler);
                        }
                    } catch (Exception e) {
                        Log.e(StepOSViewContentUtils.TAG, "OmniDisplayListener dispatch error", e);
                    }
                }
            }
        }
    }

    public static void addOmniDisplayCallback(Handler handler, int message) {
        if (handler == null) {
            Log.w(TAG, "addOmniDisplayCallback: handler is null");
            return;
        }
        CallbackPair pair = new CallbackPair(handler, message);
        boolean shouldRegisterGlobal = false;
        synchronized (sCallbackLock) {
            if (sCallbacks.contains(pair)) {
                return;
            }
            if (sCallbacks.isEmpty()) {
                shouldRegisterGlobal = true;
            }
            sCallbacks.add(pair);
            if (shouldRegisterGlobal) {
                registerGlobalListener();
            }
        }
    }

    public static void removeOmniDisplayCallback(Handler handler, int message) {
        if (handler == null) {
            return;
        }
        CallbackPair target = new CallbackPair(handler, message);
        boolean shouldUnregisterGlobal = false;
        synchronized (sCallbackLock) {
            if (sCallbacks.remove(target)) {
                if (sCallbacks.isEmpty()) {
                    shouldUnregisterGlobal = true;
                }
                if (shouldUnregisterGlobal) {
                    unregisterGlobalListener();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void registerGlobalListener() {
        synchronized (sCallbackLock) {
            if (sOmniDisplayCallback != null) {
                return;
            }
            IOmniDisplayCallback iOmniDisplayCallback = null;
            sOmniDisplayCallback = new OmniDisplayListener();
            try {
                StepOSWindowManager.getInstance().registerOmniDisplayCallback(sOmniDisplayCallback);
            } finally {
            }
        }
    }

    private static void unregisterGlobalListener() {
        IOmniDisplayCallback toUnregister;
        synchronized (sCallbackLock) {
            toUnregister = sOmniDisplayCallback;
            sOmniDisplayCallback = null;
        }
        if (toUnregister == null) {
            return;
        }
        try {
            StepOSWindowManager.getInstance().unregisterOmniDisplayCallback(toUnregister);
        } catch (Throwable ex) {
            Log.e(TAG, "unregisterOmniDisplayCallback: error " + ex.getMessage());
        }
    }
}

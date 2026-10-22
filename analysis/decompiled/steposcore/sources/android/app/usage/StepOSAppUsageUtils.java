package android.app.usage;

import android.app.usage.IStepOSUsageEventListener;
import android.app.usage.StepOSAppUsageUtils;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;
import stepos.app.IStepOSActivityManager;

/* loaded from: classes.dex */
public class StepOSAppUsageUtils {
    private static final String TAG = "StepOSAppUsageUtils";
    public static final int TYPE_ACTIVITY_MOVE_TO_BACKGROUND = -2147483646;
    public static final int TYPE_ACTIVITY_MOVE_TO_FOREGROUND = -2147483647;
    public static final int TYPE_APP_MOVE_TO_FOREGROUND = -2147483632;
    public static final int TYPE_WINDOW_HIDE = -2147483640;
    public static final int TYPE_WINDOW_SHOW = -2147483644;
    private static final Object mLock = new Object();
    private static final ArrayList<ListenPair> sCallbacks = new ArrayList<>();
    private static UsageEventListener mUsageEventListener = null;

    private StepOSAppUsageUtils() {
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

    static class UsageEventListener extends IStepOSUsageEventListener.Stub {
        private UsageEventListener() {
        }

        @Override // android.app.usage.IStepOSUsageEventListener
        public void onEvent(UsageEvents usageEvents, final int eventType) throws RemoteException {
            synchronized (StepOSAppUsageUtils.mLock) {
                if (StepOSAppUsageUtils.sCallbacks.isEmpty()) {
                    return;
                }
                final Parcel info = Parcel.obtain();
                try {
                    usageEvents.writeToParcel(info, 0);
                    StepOSAppUsageUtils.sCallbacks.forEach(new Consumer() { // from class: android.app.usage.StepOSAppUsageUtils$UsageEventListener$$ExternalSyntheticLambda0
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            StepOSAppUsageUtils.UsageEventListener.lambda$onEvent$0(eventType, info, (StepOSAppUsageUtils.ListenPair) obj);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    info.recycle();
                }
            }
        }

        static /* synthetic */ void lambda$onEvent$0(int eventType, Parcel info, ListenPair listenPair) {
            if ((listenPair.mEventType & eventType) == eventType) {
                info.setDataPosition(0);
                UsageEvents data = (UsageEvents) UsageEvents.CREATOR.createFromParcel(info);
                data.resetToStart();
                listenPair.mHandler.sendMessage(Message.obtain(listenPair.mHandler, listenPair.mMessage, data));
            }
        }
    }

    static class ListenPair {
        public int mEventType;
        public final Handler mHandler;
        public final int mMessage;

        public ListenPair(Handler h, int m) {
            this(h, m, StepOSAppUsageUtils.TYPE_APP_MOVE_TO_FOREGROUND);
        }

        public ListenPair(Handler h, int m, int type) {
            this.mHandler = h;
            this.mMessage = m;
            this.mEventType = type;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            ListenPair that = (ListenPair) object;
            if (this.mMessage == that.mMessage && Objects.equals(this.mHandler, that.mHandler)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(super.hashCode()), this.mHandler, Integer.valueOf(this.mMessage));
        }

        public String toString() {
            return "ListenPair [ message =: " + this.mMessage + ",eventType =:" + Integer.toHexString(this.mEventType) + " ]";
        }
    }

    public static void addEventListener(Handler handler, int message) {
        addEventListener(handler, message, TYPE_APP_MOVE_TO_FOREGROUND);
    }

    public static void addEventListener(Handler handler, int message, int eventType) {
        ListenPair listenPair = new ListenPair(handler, message, eventType);
        synchronized (mLock) {
            if (sCallbacks.contains(listenPair)) {
                Log.d(TAG, "addEventListener: already register listener for handler =" + handler + ",message =:" + message);
                return;
            }
            if (mUsageEventListener == null) {
                mUsageEventListener = new UsageEventListener();
                IStepOSActivityManager steposAm = getStepOSActivityManagerLocked();
                if (steposAm == null) {
                    Log.e(TAG, "addEventListener: IStepOSActivityManager is null");
                } else {
                    try {
                        steposAm.registerEventListener(mUsageEventListener);
                    } catch (RemoteException ex) {
                        Log.e(TAG, "addEventListener: error" + ex.getMessage());
                    }
                }
            }
            sCallbacks.add(listenPair);
        }
    }

    public static void removeEventListener(Handler handler, int message) {
        removeEventListener(handler, message, TYPE_APP_MOVE_TO_FOREGROUND);
    }

    public static void removeEventListener(Handler handler, int message, int eventType) {
        ListenPair listenPair = new ListenPair(handler, message, eventType);
        synchronized (mLock) {
            sCallbacks.remove(listenPair);
            if (sCallbacks.isEmpty()) {
                IStepOSActivityManager steposAm = getStepOSActivityManagerLocked();
                if (steposAm == null) {
                    Log.e(TAG, "removeEventListener: IStepOSActivityManager is null");
                } else {
                    try {
                        steposAm.removeEventListener(mUsageEventListener);
                    } catch (RemoteException ex) {
                        Log.e(TAG, "removeEventListener: error" + ex.getMessage());
                    }
                }
                mUsageEventListener = null;
            }
        }
    }
}

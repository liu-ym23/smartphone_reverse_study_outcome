package com.mdisdk.capability.framework;

import android.app.usage.UsageEvents;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import androidx.constraintlayout.core.dsl.a;
import com.mdisdk.capability.model.ActivityRecord;
import com.mdisdk.capability.model.WindowStateInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class FrameworkRegister {
    private static final int ACTIVITY_EVENT_TYPE = -2147483645;
    private static final int MESSAGE_ACTIVITY_EVENT = 1001;
    private static final int MESSAGE_APP_DIED_EVENT = 1003;
    private static final int MESSAGE_WINDOW_EVENT = 1002;
    private static final String TAG = "FrameworkRegister";
    public static final int TYPE_ACTIVITY_MOVE_TO_BACKGROUND = -2147483646;
    public static final int TYPE_ACTIVITY_MOVE_TO_FOREGROUND = -2147483647;
    public static final int TYPE_APP_MOVE_TO_FOREGROUND = -2147483632;
    public static final int TYPE_WINDOW_HIDE = -2147483640;
    public static final int TYPE_WINDOW_SHOW = -2147483644;
    private static final int WINDOW_EVENT_TYPE = -2147483636;
    private Handler activityHandler;
    private boolean activityListenerRegistered;
    private final List<OnActivityChangeListener> activityListeners;
    private Handler appDiedHandler;
    private boolean appDiedListenerRegistered;
    private final List<OnAppDiedListener> appDiedListeners;
    private HandlerThread handlerThread;
    private Handler windowHandler;
    private boolean windowListenerRegistered;
    private final List<OnWindowChangeListener> windowListeners;

    public static class Holder {
        private static final FrameworkRegister INSTANCE = new FrameworkRegister();

        private Holder() {
        }
    }

    public interface OnActivityChangeListener {
        void onActivityBackground(ActivityRecord activityRecord);

        void onActivityForeground(ActivityRecord activityRecord);
    }

    public interface OnAppDiedListener {
        void onAppDied(int i, String str, int i6, boolean z10);
    }

    public interface OnWindowChangeListener {
        void onWindowHide(WindowStateInfo windowStateInfo);

        void onWindowShow(WindowStateInfo windowStateInfo);
    }

    private String eventTypeToString(int i) {
        switch (i) {
            case TYPE_ACTIVITY_MOVE_TO_FOREGROUND /* -2147483647 */:
                return "ACTIVITY_FOREGROUND";
            case TYPE_ACTIVITY_MOVE_TO_BACKGROUND /* -2147483646 */:
                return "ACTIVITY_BACKGROUND";
            case TYPE_WINDOW_SHOW /* -2147483644 */:
                return "WINDOW_SHOW";
            case TYPE_WINDOW_HIDE /* -2147483640 */:
                return "WINDOW_HIDE";
            case TYPE_APP_MOVE_TO_FOREGROUND /* -2147483632 */:
                return "APP_FOREGROUND";
            default:
                return String.valueOf(i);
        }
    }

    private Bundle getExtraInfo(UsageEvents.Event event) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = event.getClass().getDeclaredField("mExtraInfo");
            declaredField.setAccessible(true);
            return (Bundle) declaredField.get(event);
        } catch (Exception e) {
            Log.e(TAG, "Failed to get extraInfo", e);
            return null;
        }
    }

    public static FrameworkRegister getInstance() {
        return Holder.INSTANCE;
    }

    private void handleActivityChange(String str, String str2, Bundle bundle, boolean z10) {
        ActivityRecord activityRecord = new ActivityRecord(str, str2, bundle);
        synchronized (this.activityListeners) {
            try {
                for (OnActivityChangeListener onActivityChangeListener : this.activityListeners) {
                    if (z10) {
                        try {
                            onActivityChangeListener.onActivityForeground(activityRecord);
                        } catch (Exception e) {
                            Log.e(TAG, "Error in activity listener", e);
                        }
                    } else {
                        onActivityChangeListener.onActivityBackground(activityRecord);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleActivityEvent(Message message) throws NoSuchFieldException, SecurityException {
        UsageEvents usageEvents = (UsageEvents) message.obj;
        UsageEvents.Event event = new UsageEvents.Event();
        if (usageEvents.getNextEvent(event)) {
            int eventType = event.getEventType();
            String packageName = event.getPackageName();
            String className = event.getClassName();
            Bundle extraInfo = getExtraInfo(event);
            if (extraInfo != null) {
                handleActivityChange(packageName, className, extraInfo, eventType == -2147483647);
                return;
            }
            Log.d(TAG, "Activity event extraInfo is null: " + eventTypeToString(eventType));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAppDiedEvent(Message message) {
        int i = message.arg1;
        String str = (String) message.obj;
        int i6 = message.arg2;
        boolean z10 = message.getData().getBoolean("key_restarting");
        StringBuilder sbK = a.k(i, "App Died Event: uid=", ", packageName=", str, ", displayId=");
        sbK.append(i6);
        sbK.append(", restarting:");
        sbK.append(z10);
        Log.d(TAG, sbK.toString());
        synchronized (this.appDiedListeners) {
            Iterator<OnAppDiedListener> it = this.appDiedListeners.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onAppDied(i, str, i6, z10);
                } catch (Exception e) {
                    Log.e(TAG, "Error in app died listener", e);
                }
            }
        }
    }

    private void handleWindowChange(String str, String str2, Bundle bundle, boolean z10) {
        WindowStateInfo windowStateInfoFromBundle = WindowStateInfo.fromBundle(str, str2, bundle);
        synchronized (this.windowListeners) {
            try {
                for (OnWindowChangeListener onWindowChangeListener : this.windowListeners) {
                    if (z10) {
                        try {
                            onWindowChangeListener.onWindowShow(windowStateInfoFromBundle);
                        } catch (Exception e) {
                            Log.e(TAG, "Error in window listener", e);
                        }
                    } else {
                        onWindowChangeListener.onWindowHide(windowStateInfoFromBundle);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWindowEvent(Message message) throws NoSuchFieldException, SecurityException {
        UsageEvents usageEvents = (UsageEvents) message.obj;
        UsageEvents.Event event = new UsageEvents.Event();
        if (usageEvents.getNextEvent(event)) {
            int eventType = event.getEventType();
            String packageName = event.getPackageName();
            String className = event.getClassName();
            Bundle extraInfo = getExtraInfo(event);
            if (extraInfo != null) {
                handleWindowChange(packageName, className, extraInfo, eventType == -2147483644);
                return;
            }
            Log.d(TAG, "Window event extraInfo is null: " + eventTypeToString(eventType));
        }
    }

    public void addActivityListener(OnActivityChangeListener onActivityChangeListener) {
        synchronized (this.activityListeners) {
            try {
                if (!this.activityListeners.contains(onActivityChangeListener)) {
                    this.activityListeners.add(onActivityChangeListener);
                    if (!this.activityListenerRegistered && this.activityHandler != null) {
                        FrameworkBridgeFactory.get().addEventListener(this.activityHandler, 1001, ACTIVITY_EVENT_TYPE);
                        this.activityListenerRegistered = true;
                        Log.i(TAG, "Activity listener registered to Framework");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addAppDiedListener(OnAppDiedListener onAppDiedListener) {
        synchronized (this.appDiedListeners) {
            try {
                if (!this.appDiedListeners.contains(onAppDiedListener)) {
                    this.appDiedListeners.add(onAppDiedListener);
                    if (!this.appDiedListenerRegistered && this.appDiedHandler != null) {
                        FrameworkBridgeFactory.get().addOmniDisplayCallback(this.appDiedHandler, 1003);
                        this.appDiedListenerRegistered = true;
                        Log.i(TAG, "App died listener registered to Framework (OmniDisplay)");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addWindowListener(OnWindowChangeListener onWindowChangeListener) {
        synchronized (this.windowListeners) {
            try {
                if (!this.windowListeners.contains(onWindowChangeListener)) {
                    this.windowListeners.add(onWindowChangeListener);
                    if (!this.windowListenerRegistered && this.windowHandler != null) {
                        FrameworkBridgeFactory.get().addEventListener(this.windowHandler, 1002, WINDOW_EVENT_TYPE);
                        this.windowListenerRegistered = true;
                        Log.i(TAG, "Window listener registered to Framework");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void init() {
        if (this.handlerThread != null) {
            Log.w(TAG, "Already initialized");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("framework_register");
        this.handlerThread = handlerThread;
        handlerThread.start();
        this.activityHandler = new Handler(this.handlerThread.getLooper()) { // from class: com.mdisdk.capability.framework.FrameworkRegister.1
            @Override // android.os.Handler
            public void handleMessage(Message message) throws NoSuchFieldException, SecurityException {
                if (message.what == 1001) {
                    FrameworkRegister.this.handleActivityEvent(message);
                }
            }
        };
        this.windowHandler = new Handler(this.handlerThread.getLooper()) { // from class: com.mdisdk.capability.framework.FrameworkRegister.2
            @Override // android.os.Handler
            public void handleMessage(Message message) throws NoSuchFieldException, SecurityException {
                if (message.what == 1002) {
                    FrameworkRegister.this.handleWindowEvent(message);
                }
            }
        };
        this.appDiedHandler = new Handler(this.handlerThread.getLooper()) { // from class: com.mdisdk.capability.framework.FrameworkRegister.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1003) {
                    FrameworkRegister.this.handleAppDiedEvent(message);
                }
            }
        };
        Log.i(TAG, "Initialized (lazy registration enabled)");
    }

    public void release() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        IFrameworkBridge iFrameworkBridge = FrameworkBridgeFactory.get();
        if (this.activityListenerRegistered && (handler3 = this.activityHandler) != null) {
            iFrameworkBridge.removeEventListener(handler3, 1001, ACTIVITY_EVENT_TYPE);
            this.activityListenerRegistered = false;
        }
        if (this.windowListenerRegistered && (handler2 = this.windowHandler) != null) {
            iFrameworkBridge.removeEventListener(handler2, 1002, WINDOW_EVENT_TYPE);
            this.windowListenerRegistered = false;
        }
        if (this.appDiedListenerRegistered && (handler = this.appDiedHandler) != null) {
            iFrameworkBridge.removeOmniDisplayCallback(handler, 1003);
            this.appDiedListenerRegistered = false;
        }
        HandlerThread handlerThread = this.handlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.handlerThread = null;
        }
        this.activityHandler = null;
        this.windowHandler = null;
        this.appDiedHandler = null;
        synchronized (this.activityListeners) {
            this.activityListeners.clear();
        }
        synchronized (this.windowListeners) {
            this.windowListeners.clear();
        }
        synchronized (this.appDiedListeners) {
            this.appDiedListeners.clear();
        }
        Log.i(TAG, "Released");
    }

    public void removeActivityListener(OnActivityChangeListener onActivityChangeListener) {
        synchronized (this.activityListeners) {
            try {
                this.activityListeners.remove(onActivityChangeListener);
                if (this.activityListeners.isEmpty() && this.activityListenerRegistered && this.activityHandler != null) {
                    FrameworkBridgeFactory.get().removeEventListener(this.activityHandler, 1001, ACTIVITY_EVENT_TYPE);
                    this.activityListenerRegistered = false;
                    Log.i(TAG, "Activity listener unregistered from Framework");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeAppDiedListener(OnAppDiedListener onAppDiedListener) {
        synchronized (this.appDiedListeners) {
            try {
                this.appDiedListeners.remove(onAppDiedListener);
                if (this.appDiedListeners.isEmpty() && this.appDiedListenerRegistered && this.appDiedHandler != null) {
                    FrameworkBridgeFactory.get().removeOmniDisplayCallback(this.appDiedHandler, 1003);
                    this.appDiedListenerRegistered = false;
                    Log.i(TAG, "App died listener unregistered from Framework (OmniDisplay)");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeWindowListener(OnWindowChangeListener onWindowChangeListener) {
        synchronized (this.windowListeners) {
            try {
                this.windowListeners.remove(onWindowChangeListener);
                if (this.windowListeners.isEmpty() && this.windowListenerRegistered && this.windowHandler != null) {
                    FrameworkBridgeFactory.get().removeEventListener(this.windowHandler, 1002, WINDOW_EVENT_TYPE);
                    this.windowListenerRegistered = false;
                    Log.i(TAG, "Window listener unregistered from Framework");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private FrameworkRegister() {
        this.activityListenerRegistered = false;
        this.windowListenerRegistered = false;
        this.appDiedListenerRegistered = false;
        this.activityListeners = new ArrayList();
        this.windowListeners = new ArrayList();
        this.appDiedListeners = new ArrayList();
    }
}

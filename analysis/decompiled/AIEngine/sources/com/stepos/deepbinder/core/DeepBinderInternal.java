package com.stepos.deepbinder.core;

import android.app.ActivityThread;
import android.app.Application;
import android.content.pm.ApplicationInfo;
import com.stepos.deepbinder.core.log.IPCLog;
import f.a;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class DeepBinderInternal {
    public static final DeepBinderInternal INSTANCE = new DeepBinderInternal();
    private static final String TAG = "DeepBinder";
    private static volatile Application application;

    private DeepBinderInternal() {
    }

    private final Application getApplicationInstance() {
        Application application2;
        try {
            application2 = ActivityThread.currentApplication();
        } catch (Throwable th) {
            IPCLog.INSTANCE.w(TAG, "[getContext()$1]", "exception", th);
            application2 = null;
        }
        if (application2 == null) {
            try {
                ActivityThread activityThreadCurrentActivityThread = ActivityThread.currentActivityThread();
                application2 = activityThreadCurrentActivityThread != null ? activityThreadCurrentActivityThread.getApplication() : null;
            } catch (Throwable th2) {
                IPCLog.INSTANCE.w(TAG, "[getContext()$2]", "exception", th2);
            }
        }
        if (application2 == null) {
            try {
                Object objInvoke = ActivityThread.class.getDeclaredMethod("getApplication", null).invoke(ActivityThread.class.getDeclaredMethod("currentActivityThread", null).invoke(null, null), null);
                application2 = objInvoke instanceof Application ? (Application) objInvoke : null;
            } catch (Throwable th3) {
                IPCLog.INSTANCE.w(TAG, "[getContext()$3]", "exception", th3);
            }
        }
        if (application2 != null) {
            return application2;
        }
        throw new IllegalStateException("Cannot get Application instance");
    }

    public static final Application getContext() {
        Application applicationInstance;
        Application application2 = application;
        if (application2 != null) {
            return application2;
        }
        DeepBinderInternal deepBinderInternal = INSTANCE;
        synchronized (deepBinderInternal) {
            applicationInstance = application;
            if (applicationInstance == null) {
                applicationInstance = deepBinderInternal.getApplicationInstance();
                application = applicationInstance;
                deepBinderInternal.setDebugMode();
            }
        }
        return applicationInstance;
    }

    public static final void init(Application app) {
        g.f(app, "app");
        if (application == null) {
            application = app;
            INSTANCE.setDebugMode();
        }
    }

    private final void setDebugMode() {
        ApplicationInfo applicationInfo;
        try {
            Application application2 = application;
            debug((((application2 == null || (applicationInfo = application2.getApplicationInfo()) == null) ? 0 : applicationInfo.flags) & 2) != 0);
        } catch (Exception e10) {
            IPCLog.INSTANCE.w(TAG, "[setDebugMode]", "exception", e10);
        }
    }

    public static final void debug(boolean z) {
    }
}

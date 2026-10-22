package com.stepos.deepbinder.core;

import android.app.ActivityThread;
import android.app.Application;
import android.content.pm.ApplicationInfo;
import androidx.annotation.Keep;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BuildConfig;
import com.stepos.deepbinder.core.log.IPCLog;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/deepbinder/core/DeepBinderInternal;", "", AppAgent.CONSTRUCT, "()V", "Landroid/app/Application;", "app", "LC7/r;", "init", "(Landroid/app/Application;)V", "getContext", "()Landroid/app/Application;", "", "isDebug", BuildConfig.BUILD_TYPE, "(Z)V", "getApplicationInstance", "setDebugMode", "", "TAG", "Ljava/lang/String;", "application", "Landroid/app/Application;", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeepBinderInternal {
    public static final DeepBinderInternal INSTANCE = new DeepBinderInternal();
    private static final String TAG = "DeepBinder";
    private static volatile Application application;

    private DeepBinderInternal() {
    }

    public static final void debug(boolean isDebug) {
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
        k.f(app, "app");
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
        } catch (Exception e) {
            IPCLog.INSTANCE.w(TAG, "[setDebugMode]", "exception", e);
        }
    }
}

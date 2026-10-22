package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class ActivityRecreator {
    private static final String LOG_TAG = "ActivityRecreator";
    protected static final Class<?> activityThreadClass = null;
    private static final Handler mainHandler = null;
    protected static final Field mainThreadField = null;
    protected static final Method performStopActivity2ParamsMethod = null;
    protected static final Method performStopActivity3ParamsMethod = null;
    protected static final Method requestRelaunchActivityMethod = null;
    protected static final Field tokenField = null;

    /* JADX INFO: renamed from: androidx.core.app.ActivityRecreator$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ LifecycleCheckCallbacks val$callbacks;
        final /* synthetic */ Object val$token;

        AnonymousClass1(LifecycleCheckCallbacks r1, Object r2) {
            this.val$callbacks = r1;
            this.val$token = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            LifecycleCheckCallbacks r0 = this.val$callbacks;
            r0.currentlyRecreatingToken = this.val$token;
        }
    }

    /* JADX INFO: renamed from: androidx.core.app.ActivityRecreator$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Application val$application;
        final /* synthetic */ LifecycleCheckCallbacks val$callbacks;

        AnonymousClass2(Application r1, LifecycleCheckCallbacks r2) {
            this.val$application = r1;
            this.val$callbacks = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$application.unregisterActivityLifecycleCallbacks(this.val$callbacks);
        }
    }

    private static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
        Object currentlyRecreatingToken;
        private Activity mActivity;
        private boolean mDestroyed;
        private final int mRecreatingHashCode;
        private boolean mStarted;
        private boolean mStopQueued;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r1) {
        }

        LifecycleCheckCallbacks(Activity r2) {
            this.mStarted = false;
            this.mDestroyed = false;
            this.mStopQueued = false;
            this.mActivity = r2;
            this.mRecreatingHashCode = r2.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r2) {
            if (this.mActivity != r2) goto L6;
            this.mStarted = true;
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r3) {
            if (this.mDestroyed == true) goto L5;
            return;
        L5:
            if (this.mStopQueued == false) goto L7;
            return;
        L7:
            if (this.mStarted == false) goto L9;
            return;
        L9:
            if (ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, this.mRecreatingHashCode, r3) == false) goto L15;
            this.mStopQueued = true;
            this.currentlyRecreatingToken = null;
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r2) {
            if (this.mActivity != r2) goto L6;
            this.mActivity = null;
            this.mDestroyed = true;
            return;
        }
    }

    private static boolean needsRelaunchCall() {
        return false;
    }

    private ActivityRecreator() {
    }

    static {
        mainHandler = new Handler(Looper.getMainLooper());
        Class<?> r0 = getActivityThreadClass();
        activityThreadClass = r0;
        mainThreadField = getMainThreadField();
        tokenField = getTokenField();
        performStopActivity3ParamsMethod = getPerformStopActivity3Params(r0);
        performStopActivity2ParamsMethod = getPerformStopActivity2Params(r0);
        requestRelaunchActivityMethod = getRequestRelaunchActivityMethod(r0);
    }

    static boolean recreate(Activity r0) {
        r0.recreate();
        return true;
    }

    protected static boolean queueOnStopIfNecessary(Object r2, int r3, Activity r4) {
        final Object r1 = tokenField.get(r4);     // Catch: Throwable -> L12
        if (r1 == r2) goto L6;
    L11:
        return false;
    L6:
        if (r4.hashCode() != r3) goto L11;
        final Object r5 = mainThreadField.get(r4);     // Catch: Throwable -> L12
        mainHandler.postAtFrontOfQueue(new AnonymousClass3(r5, r1));     // Catch: Throwable -> L12
        return true;
    L12:
        th = move-exception;
        Log.e(LOG_TAG, "Exception while fetching field values", th);
        return false;
    }

    private static Method getPerformStopActivity3Params(Class<?> r6) {
        if (r6 != null) goto L8;
        return null;
    L8:
        Method r7 = r6.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});     // Catch: Throwable -> L7
        r7.setAccessible(true);     // Catch: Throwable -> L7
        return r7;
    L7:
        return null;
    }

    private static Method getPerformStopActivity2Params(Class<?> r5) {
        if (r5 != null) goto L8;
        return null;
    L8:
        Method r6 = r5.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});     // Catch: Throwable -> L7
        r6.setAccessible(true);     // Catch: Throwable -> L7
        return r6;
    L7:
        return null;
    }

    private static Method getRequestRelaunchActivityMethod(Class<?> r6) {
        if (needsRelaunchCall() == false) goto L8;
        if (r6 == null) goto L8;
        Method r7 = r6.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE});     // Catch: Throwable -> L9
        r7.setAccessible(true);     // Catch: Throwable -> L9
        return r7;
    L8:
        return null;
    }

    private static Field getMainThreadField() {
        Field r0 = Activity.class.getDeclaredField("mMainThread");     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }

    private static Field getTokenField() {
        Field r0 = Activity.class.getDeclaredField("mToken");     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }

    private static Class<?> getActivityThreadClass() {
        return Class.forName("android.app.ActivityThread");
    L4:
        return null;
    }
}

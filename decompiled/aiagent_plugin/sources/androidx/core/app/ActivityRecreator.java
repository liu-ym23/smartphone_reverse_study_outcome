package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
final class ActivityRecreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Class<?> f1031a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final Field f1032b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final Field f1033c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final Method f1034d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final Method f1035e = null;
    protected static final Method f = null;
    private static final Handler g = null;

    private static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
        Object currentlyRecreatingToken;
        private Activity mActivity;
        private boolean mDestroyed;
        private final int mRecreatingHashCode;
        private boolean mStarted;
        private boolean mStopQueued;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
            Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
            Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        }

        LifecycleCheckCallbacks(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            this.mStarted = false;
            this.mDestroyed = false;
            this.mStopQueued = false;
            Activity r5 = ZeusTransformUtils.wrapperContext2Activity(r4, "com.obric.aiagent.plugin");
            this.mActivity = r5;
            this.mRecreatingHashCode = r5.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            if (this.mActivity != r4) goto L6;
            this.mStarted = true;
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            if (this.mDestroyed == true) goto L5;
            return;
        L5:
            if (this.mStopQueued == false) goto L7;
            return;
        L7:
            if (this.mStarted == false) goto L9;
            return;
        L9:
            if (ActivityRecreator.a(this.currentlyRecreatingToken, this.mRecreatingHashCode, r4) == false) goto L15;
            this.mStopQueued = true;
            this.currentlyRecreatingToken = null;
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            if (this.mActivity != r4) goto L6;
            this.mActivity = ZeusTransformUtils.wrapperContext2Activity(null, "com.obric.aiagent.plugin");
            this.mDestroyed = true;
            return;
        }
    }

    static {
        g = new Handler(Looper.getMainLooper());
        Class<?> r0 = d();
        f1031a = r0;
        f1032b = b();
        f1033c = c();
        f1034d = a(r0);
        f1035e = b(r0);
        f = c(r0);
    }

    static boolean a(Activity r10) {
        Activity r11 = (Activity) ZeusTransformUtils.wrapperContextForParams(r10, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L7;
        r11.recreate();
        return true;
    L7:
        if (a() == false) goto L12;
        if (f != null) goto L12;
        return false;
    L12:
        if (f1035e == null) goto L14;
    L33:
        final Object r0 = f1033c.get(r11);     // Catch: Throwable -> L32
        if (r0 != null) goto L19;
        return false;
    L19:
        Object r4 = f1032b.get(r11);     // Catch: Throwable -> L32
        if (r4 != null) goto L22;
        return false;
    L22:
        final Application r1 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        final LifecycleCheckCallbacks r5 = new LifecycleCheckCallbacks(r11);     // Catch: Throwable -> L32
        r1.registerActivityLifecycleCallbacks(r5);     // Catch: Throwable -> L32
        Handler r6 = g;     // Catch: Throwable -> L32
        r6.post(new AnonymousClass1(r5, r0));     // Catch: Throwable -> L32
    L29:
        th = move-exception;
        g.post(new AnonymousClass2(r1, r5));     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L24:
        if (a() == false) goto L26;
        f.invoke(r4, new Object[]{r0, null, null, 0, false, null, null, false, false});     // Catch: Throwable -> L29
    L27:
        r6.post(new AnonymousClass2(r1, r5));     // Catch: Throwable -> L32
        return true;
    L26:
        r11.recreate();     // Catch: Throwable -> L29
    L32:
        return false;
    L14:
        if (f1034d != null) goto L33;
        return false;
    }

    public static boolean a(Object r2, int r3, Activity r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        final Object r1 = f1033c.get(r5);     // Catch: Throwable -> L12
        if (r1 == r2) goto L6;
    L11:
        return false;
    L6:
        if (r5.hashCode() != r3) goto L11;
        final Object r6 = f1032b.get(r5);     // Catch: Throwable -> L12
        g.postAtFrontOfQueue(new AnonymousClass3(r6, r1));     // Catch: Throwable -> L12
        return true;
    L12:
        th = move-exception;
        a("ActivityRecreator", "Exception while fetching field values", th);
        return false;
    }

    private static Method a(Class<?> r6) {
        if (r6 != null) goto L8;
        return null;
    L8:
        Method r7 = r6.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});     // Catch: Throwable -> L7
        r7.setAccessible(true);     // Catch: Throwable -> L7
        return r7;
    L7:
        return null;
    }

    private static Method b(Class<?> r5) {
        if (r5 != null) goto L8;
        return null;
    L8:
        Method r6 = r5.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});     // Catch: Throwable -> L7
        r6.setAccessible(true);     // Catch: Throwable -> L7
        return r6;
    L7:
        return null;
    }

    private static boolean a() {
        if (Build.VERSION.SDK_INT != 26) goto L5;
    L8:
        return true;
    L5:
        if (Build.VERSION.SDK_INT == 27) goto L8;
        return false;
    }

    private static Method c(Class<?> r6) {
        if (a() == false) goto L8;
        if (r6 == null) goto L8;
        Method r7 = r6.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE});     // Catch: Throwable -> L9
        r7.setAccessible(true);     // Catch: Throwable -> L9
        return r7;
    L8:
        return null;
    }

    private static Field b() {
        Field r0 = Activity.class.getDeclaredField("mMainThread");     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }

    private static Field c() {
        Field r0 = Activity.class.getDeclaredField("mToken");     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }

    private static Class<?> d() {
        return ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.aiagent.plugin");
    L4:
        return null;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}

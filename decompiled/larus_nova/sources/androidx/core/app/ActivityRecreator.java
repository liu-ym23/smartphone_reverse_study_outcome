package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
final class ActivityRecreator {
    private static final String LOG_TAG = "ActivityRecreator";
    protected static final Class<?> activityThreadClass = null;
    private static final Handler mainHandler = null;
    protected static final Field mainThreadField = null;
    protected static final Method performStopActivity2ParamsMethod = null;
    protected static final Method performStopActivity3ParamsMethod = null;
    protected static final Method requestRelaunchActivityMethod = null;
    protected static final Field tokenField = null;

    public static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
        Object currentlyRecreatingToken;
        private Activity mActivity;
        private boolean mDestroyed;
        private final int mRecreatingHashCode;
        private boolean mStarted;
        private boolean mStopQueued;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r100) {
        }

        public LifecycleCheckCallbacks(Activity r100) {
            this.mStarted = false;
            this.mDestroyed = false;
            this.mStopQueued = false;
            this.mActivity = r100;
            this.mRecreatingHashCode = r100.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r100) {
            if (this.mActivity != r100) goto L6;
            this.mActivity = null;
            this.mDestroyed = true;
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r100) {
            if (this.mDestroyed == true) goto L5;
            return;
        L5:
            if (this.mStopQueued == false) goto L7;
            return;
        L7:
            if (this.mStarted == false) goto L9;
            return;
        L9:
            if (ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, this.mRecreatingHashCode, r100) == false) goto L15;
            this.mStopQueued = true;
            this.currentlyRecreatingToken = null;
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r100) {
            if (this.mActivity != r100) goto L6;
            this.mStarted = true;
            return;
        }
    }

    private ActivityRecreator() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        mainHandler = new Handler(Looper.getMainLooper());
        Class<?> r100 = getActivityThreadClass();
        activityThreadClass = r100;
        mainThreadField = getMainThreadField();
        tokenField = getTokenField();
        performStopActivity3ParamsMethod = getPerformStopActivity3Params(r100);
        performStopActivity2ParamsMethod = getPerformStopActivity2Params(r100);
        requestRelaunchActivityMethod = getRequestRelaunchActivityMethod(r100);
    }

    private static Class<?> getActivityThreadClass() {
        return INVOKESTATIC_androidx_core_app_ActivityRecreator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread");
    L4:
        return null;
    }

    private static Field getMainThreadField() {
        Field r100 = Activity.class.getDeclaredField("mMainThread");     // Catch: Throwable -> L4
        r100.setAccessible(true);     // Catch: Throwable -> L4
        return r100;
    L4:
        return null;
    }

    private static Field getTokenField() {
        Field r100 = Activity.class.getDeclaredField("mToken");     // Catch: Throwable -> L4
        r100.setAccessible(true);     // Catch: Throwable -> L4
        return r100;
    L4:
        return null;
    }

    private static boolean needsRelaunchCall() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 != 26) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 27) goto L8;
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_core_app_ActivityRecreator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private static Method getPerformStopActivity2Params(Class<?> r100) {
        if (r100 != null) goto L8;
        return null;
    L8:
        Method r101 = r100.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});     // Catch: Throwable -> L7
        r101.setAccessible(true);     // Catch: Throwable -> L7
        return r101;
    L7:
        return null;
    }

    private static Method getPerformStopActivity3Params(Class<?> r100) {
        if (r100 != null) goto L8;
        return null;
    L8:
        Method r101 = r100.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});     // Catch: Throwable -> L7
        r101.setAccessible(true);     // Catch: Throwable -> L7
        return r101;
    L7:
        return null;
    }

    private static Method getRequestRelaunchActivityMethod(Class<?> r100) {
        if (needsRelaunchCall() == false) goto L8;
        if (r100 == null) goto L8;
        Class<?> r101 = Boolean.TYPE;     // Catch: Throwable -> L9
        Method r102 = r100.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, r101, Configuration.class, Configuration.class, r101, r101});     // Catch: Throwable -> L9
        r102.setAccessible(true);     // Catch: Throwable -> L9
        return r102;
    L8:
        return null;
    }

    public static boolean recreate(Activity r110) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        r110.recreate();
        return true;
    L7:
        if (needsRelaunchCall() == false) goto L12;
        if (requestRelaunchActivityMethod != null) goto L12;
        return false;
    L12:
        if (performStopActivity2ParamsMethod == null) goto L14;
    L33:
        final Object r100 = tokenField.get(r110);     // Catch: Throwable -> L32
        if (r100 != null) goto L19;
        return false;
    L19:
        Object r101 = mainThreadField.get(r110);     // Catch: Throwable -> L32
        if (r101 != null) goto L22;
        return false;
    L22:
        final Application r102 = r110.getApplication();     // Catch: Throwable -> L32
        final LifecycleCheckCallbacks r103 = new LifecycleCheckCallbacks(r110);     // Catch: Throwable -> L32
        r102.registerActivityLifecycleCallbacks(r103);     // Catch: Throwable -> L32
        Handler r104 = mainHandler;     // Catch: Throwable -> L32
        r104.post(new AnonymousClass1(r103, r100));     // Catch: Throwable -> L32
    L29:
        th = move-exception;
        mainHandler.post(new AnonymousClass2(r102, r103));     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L24:
        if (needsRelaunchCall() == false) goto L26;
        Method r111 = requestRelaunchActivityMethod;     // Catch: Throwable -> L29
        Boolean r105 = Boolean.FALSE;     // Catch: Throwable -> L29
        r111.invoke(r101, new Object[]{r100, null, null, 0, r105, null, null, r105, r105});     // Catch: Throwable -> L29
    L27:
        r104.post(new AnonymousClass2(r102, r103));     // Catch: Throwable -> L32
        return true;
    L26:
        r110.recreate();     // Catch: Throwable -> L29
    L32:
        return false;
    L14:
        if (performStopActivity3ParamsMethod != null) goto L33;
        return false;
    }

    public static boolean queueOnStopIfNecessary(Object r100, int r101, Activity r102) {
        final Object r103 = tokenField.get(r102);     // Catch: Throwable -> L12
        if (r103 != r100) goto L11;
        if (r102.hashCode() != r101) goto L11;
        final Object r104 = mainThreadField.get(r102);     // Catch: Throwable -> L12
        mainHandler.postAtFrontOfQueue(new AnonymousClass3(r104, r103));     // Catch: Throwable -> L12
        return true;
    L11:
        return false;
    }
}

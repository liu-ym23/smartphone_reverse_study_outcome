package android.app;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TaskUtils {

    /* renamed from: b, reason: collision with root package name */
    private static Method f7334b;

    /* renamed from: a, reason: collision with root package name */
    private static final Map<a, MyTaskStackListener> f7333a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final ComponentName f7335c = new ComponentName("com.stepos.launcher", "com.android.launcher3.uioverrides.QuickstepLauncher");

    private static class MyTaskStackListener extends TaskStackListener {
        private final ComponentName baseActivity;
        private final a listener;

        public MyTaskStackListener(ComponentName componentName, a aVar) {
            this.baseActivity = componentName;
            this.listener = aVar;
        }

        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        public int hashCode() {
            return this.baseActivity.hashCode() + this.listener.hashCode();
        }

        public void onTaskMovedToFront(ActivityManager.RunningTaskInfo runningTaskInfo) {
            ComponentName componentName;
            a aVar;
            Log.d("TaskUtils", "onTaskMovedFront " + runningTaskInfo);
            if (runningTaskInfo == null || (componentName = runningTaskInfo.baseActivity) == null) {
                return;
            }
            if (componentName.equals(this.baseActivity)) {
                a aVar2 = this.listener;
                if (aVar2 != null) {
                    aVar2.b(runningTaskInfo);
                    return;
                }
                return;
            }
            if (!runningTaskInfo.baseActivity.equals(TaskUtils.f7335c) || (aVar = this.listener) == null) {
                return;
            }
            aVar.a(runningTaskInfo);
        }
    }

    public interface a {
        void a(ActivityManager.RunningTaskInfo runningTaskInfo);

        void b(ActivityManager.RunningTaskInfo runningTaskInfo);
    }

    private static Object a() {
        return ActivityTaskManager.class.getMethod("getInstance", null).invoke(null, null);
    }

    public static void b(ComponentName componentName, a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Log.d("TaskUtils", "registerTaskStackListener() called with: baseActivity = [" + componentName + "], listener = [" + aVar + "]");
        try {
            Object objA = a();
            if (f7334b == null) {
                f7334b = ActivityTaskManager.class.getMethod("registerTaskStackListener", TaskStackListener.class);
            }
            Map<a, MyTaskStackListener> map = f7333a;
            MyTaskStackListener myTaskStackListener = map.get(aVar);
            if (myTaskStackListener == null) {
                myTaskStackListener = new MyTaskStackListener(componentName, aVar);
                map.put(aVar, myTaskStackListener);
            }
            try {
                f7334b.invoke(objA, myTaskStackListener);
            } catch (InvocationTargetException e6) {
                Throwable cause = e6.getCause();
                if (!(cause instanceof SecurityException)) {
                    Log.e("TaskUtils", Log.getStackTraceString(e6));
                    return;
                }
                Log.e("TaskUtils", "registerTaskStackListener: permission denied, ignore listener registration. " + cause);
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e7) {
            Log.e("TaskUtils", Log.getStackTraceString(e7));
        }
    }
}

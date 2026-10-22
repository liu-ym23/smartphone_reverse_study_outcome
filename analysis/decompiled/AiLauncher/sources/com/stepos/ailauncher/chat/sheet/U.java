package com.stepos.ailauncher.chat.sheet;

import Z8.C1173v;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import h8.C4148a;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/U;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "desktopTaskId", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;I)V", "Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "activity", "c", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;)V", "Landroid/app/ActivityManager;", "am", "taskId", "", Const.INTENT_KEY_PKGNAME, "(Landroid/app/ActivityManager;I)Z", "", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class U {
    public static final U INSTANCE = new U();
    private static final String TAG = "DesktopExternalUiHome";

    public final void a(Context context, int desktopTaskId) {
        Object objB;
        Object objB2;
        Object objB3;
        ComponentName component;
        kotlin.jvm.internal.p.i(context, "context");
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
        if (activityManager == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(activityManager.getAppTasks());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        List<ActivityManager.AppTask> listM = (List) objB;
        if (listM == null) {
            listM = C1173v.m();
        }
        for (ActivityManager.AppTask appTask : listM) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(appTask.getTaskInfo());
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            if (Result.g(objB2)) {
                objB2 = null;
            }
            ActivityManager.RecentTaskInfo recentTaskInfo = (ActivityManager.RecentTaskInfo) objB2;
            if (recentTaskInfo != null && recentTaskInfo.id != desktopTaskId) {
                ComponentName componentName = recentTaskInfo.baseActivity;
                String className = componentName != null ? componentName.getClassName() : null;
                Intent intent = recentTaskInfo.baseIntent;
                if (T.INSTANCE.f(desktopTaskId, recentTaskInfo.id, className, (intent == null || (component = intent.getComponent()) == null) ? null : component.getClassName())) {
                    C4148a.k(TAG, "finishAndRemoveTask owned relay id=" + recentTaskInfo.id + " base=" + className, false, 4, null);
                    try {
                        appTask.finishAndRemoveTask();
                        objB3 = Result.b(Y8.t.f7040a);
                    } catch (Throwable th3) {
                        Result.Companion companion5 = Result.INSTANCE;
                        objB3 = Result.b(C4849c.a(th3));
                    }
                    Throwable thE = Result.e(objB3);
                    if (thE != null) {
                        C4148a.u(TAG, "finishAndRemoveTask failed id=" + recentTaskInfo.id + ": " + thE.getMessage(), false, 4, null);
                    }
                }
            }
        }
    }

    public final boolean b(ActivityManager am, int taskId) {
        Object objB;
        Object objB2;
        Object objInvoke;
        Method method;
        Method method2;
        Object objInvoke2;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method[] methods = ActivityManager.class.getMethods();
            kotlin.jvm.internal.p.h(methods, "getMethods(...)");
            int length = methods.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i10];
                if (kotlin.jvm.internal.p.d(method2.getName(), "removeTask") && method2.getParameterTypes().length == 1) {
                    break;
                }
                i10++;
            }
            if (method2 == null) {
                objInvoke2 = null;
            } else {
                method2.setAccessible(true);
                objInvoke2 = method2.invoke(am, Integer.valueOf(taskId));
            }
            objB = Result.b(objInvoke2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        boolean zG = Result.g(objB);
        Object obj = objB;
        if (zG) {
            obj = null;
        }
        if (obj != null) {
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityTaskManager").getDeclaredMethod("getService", null);
            declaredMethod.setAccessible(true);
            objInvoke = declaredMethod.invoke(null, null);
            Method[] methods2 = objInvoke.getClass().getMethods();
            kotlin.jvm.internal.p.h(methods2, "getMethods(...)");
            int length2 = methods2.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length2) {
                    method = null;
                    break;
                }
                method = methods2[i11];
                if (kotlin.jvm.internal.p.d(method.getName(), "removeTask") && method.getParameterTypes().length == 1) {
                    break;
                }
                i11++;
            }
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (method == null) {
            throw new IllegalStateException("ActivityTaskManager.removeTask missing");
        }
        Object objInvoke3 = method.invoke(objInvoke, Integer.valueOf(taskId));
        objB2 = Result.b(Boolean.valueOf(objInvoke3 instanceof Boolean ? ((Boolean) objInvoke3).booleanValue() : true));
        Throwable thE = Result.e(objB2);
        if (thE != null) {
            C4148a.u(TAG, "removeTask(" + taskId + ") failed: " + thE.getMessage(), false, 4, null);
        }
        Boolean bool2 = Boolean.FALSE;
        if (Result.g(objB2)) {
            objB2 = bool2;
        }
        return ((Boolean) objB2).booleanValue();
    }

    public final void c(ChatActivity activity) {
        Object objB;
        kotlin.jvm.internal.p.i(activity, "activity");
        ActivityManager activityManager = (ActivityManager) activity.getSystemService(ActivityManager.class);
        if (activityManager == null) {
            return;
        }
        String packageName = activity.getPackageName();
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(activityManager.getRunningTasks(8));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        List<ActivityManager.RunningTaskInfo> listM = (List) objB;
        if (listM == null) {
            listM = C1173v.m();
        }
        for (ActivityManager.RunningTaskInfo runningTaskInfo : listM) {
            ComponentName componentName = runningTaskInfo.topActivity;
            String packageName2 = componentName != null ? componentName.getPackageName() : null;
            T t10 = T.INSTANCE;
            kotlin.jvm.internal.p.f(packageName);
            if (t10.h(packageName2, packageName)) {
                int i10 = runningTaskInfo.id;
                int taskId = activity.getTaskId();
                ComponentName componentName2 = runningTaskInfo.baseActivity;
                if (!t10.i(i10, taskId, componentName2 != null ? componentName2.getPackageName() : null, packageName)) {
                    C4148a.k(TAG, "removeTask cover pkg=" + packageName2 + " id=" + runningTaskInfo.id, false, 4, null);
                    if (!b(activityManager, runningTaskInfo.id)) {
                        C4148a.u(TAG, "removeTask skipped/failed id=" + runningTaskInfo.id + " pkg=" + packageName2, false, 4, null);
                    }
                }
            }
        }
    }
}

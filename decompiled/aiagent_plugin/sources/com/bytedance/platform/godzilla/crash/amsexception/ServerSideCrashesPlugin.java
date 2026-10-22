package com.bytedance.platform.godzilla.crash.amsexception;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.platform.godzilla.a.a;
import com.bytedance.platform.godzilla.common.c;
import com.bytedance.platform.godzilla.common.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ServerSideCrashesPlugin extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Activity f9088a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f9089b = false;

    public static class CrashCatchLifecycleCallback implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
            Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        }

        public CrashCatchLifecycleCallback() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r2, Bundle r3) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            if (Build.VERSION.SDK_INT >= 18) goto L5;
            return;
        L5:
            if (Build.VERSION.SDK_INT > 28) goto L10;
            Activity r4 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ServerSideCrashesPlugin.b(r1), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
            ServerSideCrashesPlugin.a(true);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r3) {
            Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            if (Build.VERSION.SDK_INT >= 18) goto L5;
            return;
        L5:
            if (Build.VERSION.SDK_INT > 28) goto L10;
            Activity r4 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ServerSideCrashesPlugin.b(r2), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
            ServerSideCrashesPlugin.a(r2);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            if (Build.VERSION.SDK_INT >= 18) goto L5;
            return;
        L5:
            if (Build.VERSION.SDK_INT > 28) goto L10;
            Activity r3 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ServerSideCrashesPlugin.b(null), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            if (Build.VERSION.SDK_INT >= 18) goto L5;
            return;
        L5:
            if (Build.VERSION.SDK_INT > 28) goto L10;
            Activity r3 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ServerSideCrashesPlugin.b(null), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
            return;
        }
    }

    static {
    }

    static /* synthetic */ Activity a() {
        return f9088a;
    }

    static /* synthetic */ Throwable a(Throwable r0) {
        return b(r0);
    }

    static /* synthetic */ Activity b(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        f9088a = r3;
        return r3;
    }

    public static Field a(Object r2, String r3) {
        if (r2 != null) goto L5;
    L14:
        return null;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L14;
        Class<?> r4 = r2.getClass();
    L9:
        if (r4 == Object.class) goto L14;
        Field r1 = c.a(r4, r3);
        if (r1 != null) goto L12;
        r4 = r4.getSuperclass();
        goto L9
    L12:
        return r1;
    }

    public static void a(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        Field r0 = a(r3, "mStartedActivity");
        if (r0 != null) goto L10;
        return;
    L10:
        r0.setAccessible(true);     // Catch: Exception -> L7
        r0.set(r3, true);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        g.b("ServerBugFixer", "setStartedActivity fail " + e);
    }

    public static void a(boolean r8) {
        if (f9089b == false) goto L5;
        return;
    L5:
        f9089b = true;
        if (Build.VERSION.SDK_INT >= 18) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT > 28) goto L37;
    L29:
        e = move-exception;
        g.b("ServerBugFixer", "Fix fail " + e);
        return;
    L25:
        e = move-exception;
        g.b("ServerBugFixer", "Fix fail " + e);
        return;
    L27:
        e = move-exception;
        g.b("ServerBugFixer", "Fix fail " + e);
        return;
    L12:
        if (Build.VERSION.SDK_INT >= 26) goto L14;
        Field r3 = ZeusTransformUtils.forName("android.app.ActivityManagerNative", "com.obric.aiagent.plugin").getDeclaredField("gDefault");     // Catch: IllegalAccessException -> L25 NoSuchFieldException -> L27 ClassNotFoundException -> L29
    L15:
        r3.setAccessible(true);     // Catch: IllegalAccessException -> L25 NoSuchFieldException -> L27 ClassNotFoundException -> L29
        Object r4 = r3.get(null);     // Catch: IllegalAccessException -> L25 NoSuchFieldException -> L27 ClassNotFoundException -> L29
        Field r5 = ZeusTransformUtils.forName("android.util.Singleton", "com.obric.aiagent.plugin").getDeclaredField("mInstance");     // Catch: IllegalAccessException -> L25 NoSuchFieldException -> L27 ClassNotFoundException -> L29
        r5.setAccessible(true);     // Catch: IllegalAccessException -> L25 NoSuchFieldException -> L27 ClassNotFoundException -> L29
        final Object r6 = r5.get(r4);     // Catch: IllegalAccessException -> L25 NoSuchFieldException -> L27 ClassNotFoundException -> L29
        if (r6 != null) goto L18;
        return;
    L18:
        if (r8 == false) goto L23;
        Class r9 = ZeusTransformUtils.forName("android.app.IActivityManager", "com.obric.aiagent.plugin");     // Catch: IllegalAccessException -> L25 NoSuchFieldException -> L27 ClassNotFoundException -> L29
        if (r9 != null) goto L22;
        return;
    L22:
        r5.set(r4, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{r9}, new AnonymousClass1(r6)));     // Catch: IllegalAccessException -> L25 NoSuchFieldException -> L27 ClassNotFoundException -> L29
        return;
    L23:
        r5.set(r4, r4);     // Catch: IllegalAccessException -> L25 NoSuchFieldException -> L27 ClassNotFoundException -> L29
        return;
    L14:
        r3 = ZeusTransformUtils.forName("android.app.ActivityManager", "com.obric.aiagent.plugin").getDeclaredField("IActivityManagerSingleton");     // Catch: IllegalAccessException -> L25 NoSuchFieldException -> L27 ClassNotFoundException -> L29
        goto L15
    }

    private static Throwable b(Throwable r8) {
        StackTraceElement[] r0 = r8.getStackTrace();     // Catch: Throwable -> L41
        if (ZeusTransformUtils.instanceOf(r8, InvocationTargetException.class) == false) goto L10;
        InvocationTargetException r1 = (InvocationTargetException) ZeusTransformUtils.preCheckCast(r8, InvocationTargetException.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        if (r1.getTargetException() == null) goto L8;
        r8 = r1.getTargetException();     // Catch: Throwable -> L41
        r0 = r8.getStackTrace();     // Catch: Throwable -> L41
    L16:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L41
        int r3 = 0;
        int r4 = 0;
    L18:
        if (r4 >= r0.length) goto L34;
        StackTraceElement r5 = r0[r4];     // Catch: Throwable -> L41
        if (r5 == null) goto L32;
        String r6 = r5.getClassName();     // Catch: Throwable -> L41
        if (TextUtils.isEmpty(r6) == false) goto L25;
    L31:
        r2.add(r5);     // Catch: Throwable -> L41
        goto L32
    L25:
        if (r6.contains("com.bytedance.platform.godzilla.crash.amsexception.ServerSideCrashesPlugin") == true) goto L32;
        if (r6.equals(Proxy.class.getName()) == true) goto L32;
        if (r6.equals(Method.class.getName()) == false) goto L31;
    L32:
        r4 = r4 + 1;     // Catch: Throwable -> L41
        goto L18
    L34:
        if (r2.isEmpty() == false) goto L36;
        return r8;
    L36:
        int r7 = r2.size();     // Catch: Throwable -> L41
        StackTraceElement[] r9 = new StackTraceElement[r7];     // Catch: Throwable -> L41
    L37:
        if (r3 >= r7) goto L39;
        r9[r3] = (StackTraceElement) ZeusTransformUtils.preCheckCast(r2.get(r3), StackTraceElement.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        r3 = r3 + 1;     // Catch: Throwable -> L41
        goto L37
    L39:
        r8.setStackTrace(r9);     // Catch: Throwable -> L41
        goto L40
    L8:
        RuntimeException r10 = new RuntimeException();     // Catch: Throwable -> L41
    L15:
        r8 = r10;
        goto L16
    L10:
        if (ZeusTransformUtils.instanceOf(r8, UndeclaredThrowableException.class) == false) goto L16;
        UndeclaredThrowableException r11 = (UndeclaredThrowableException) ZeusTransformUtils.preCheckCast(r8, UndeclaredThrowableException.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        if (r11.getUndeclaredThrowable() == null) goto L14;
        r8 = r11.getUndeclaredThrowable();     // Catch: Throwable -> L41
        r0 = r8.getStackTrace();     // Catch: Throwable -> L41
        goto L16
    L14:
        r10 = new RuntimeException();     // Catch: Throwable -> L41
    L40:
        return r8;
    }
}

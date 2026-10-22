package com.android.server.wm;

import android.app.ActivityThread;
import android.os.Environment;
import android.provider.Settings;
import dalvik.system.PathClassLoader;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityPluginDelegate {
    private static final String FOREGROUND_ACTIVITY_TRIGGER = "foreground_activity_trigger";
    private static final boolean LOGV = false;
    private static final int MAX_CONNECT_RETRIES = 15;
    private static final String TAG = "ActivityPluginDelegate";
    private static Class activityServiceClass;
    private static Object activityServiceObj;
    private static boolean extJarAvail;
    static boolean isEnabled;
    static int mGetFeatureEnableRetryCount;

    public ActivityPluginDelegate() {
    }

    static {
        activityServiceClass = null;
        activityServiceObj = null;
        extJarAvail = true;
        mGetFeatureEnableRetryCount = 15;
        isEnabled = false;
    }

    public static void activityInvokeNotification(String appName, boolean isFullScreen) {
        if (getFeatureFlag() == true) goto L5;
        return;
    L5:
        if (extJarAvail == true) goto L7;
        return;
    L7:
        if (loadActivityExtJar() == false) goto L22;
        activityServiceClass.getMethod("sendActivityInvokeNotification", new Class[]{String.class, Boolean.TYPE}).invoke(activityServiceObj, new Object[]{appName, Boolean.valueOf(isFullScreen)});     // Catch: Exception -> L11 Throwable -> L13
        return;
    L20:
        return;
    L19:
        return;
    }

    public static void activitySuspendNotification(String appName, boolean isFullScreen, boolean isBg) {
        if (getFeatureFlag() == true) goto L5;
        return;
    L5:
        if (extJarAvail == true) goto L7;
        return;
    L7:
        if (loadActivityExtJar() == false) goto L22;
        activityServiceClass.getMethod("sendActivitySuspendNotification", new Class[]{String.class, Boolean.TYPE, Boolean.TYPE}).invoke(activityServiceObj, new Object[]{appName, Boolean.valueOf(isFullScreen), Boolean.valueOf(isBg)});     // Catch: Exception -> L11 Throwable -> L13
        return;
    L20:
        return;
    L19:
        return;
    }

    private static synchronized boolean loadActivityExtJar() {
        monitor-enter(ActivityPluginDelegate.class);
        String realProviderPath = Environment.getSystemExtDirectory().getAbsolutePath() + "/framework/ActivityExt.jar";     // Catch: Throwable -> L10
        if (activityServiceClass != null) goto L7;
    L12:
        boolean r3 = new File(realProviderPath).exists();     // Catch: Throwable -> L10
        extJarAvail = r3;     // Catch: Throwable -> L10
        if (r3 == true) goto L18;
        boolean r4 = extJarAvail;     // Catch: Throwable -> L10
        monitor-exit(ActivityPluginDelegate.class);
        return r4;
    L18:
        if (activityServiceClass == null) goto L20;
    L36:
        monitor-exit(ActivityPluginDelegate.class);
        return true;
    L20:
        if (activityServiceObj != null) goto L36;
        PathClassLoader classLoader = new PathClassLoader(realProviderPath, ClassLoader.getSystemClassLoader());     // Catch: Throwable -> L10 Exception -> L24 Throwable -> L26
        activityServiceClass = classLoader.loadClass("com.qualcomm.qti.activityextension.ActivityNotifier");     // Catch: Throwable -> L10 Exception -> L24 Throwable -> L26
        activityServiceObj = activityServiceClass.newInstance();     // Catch: Throwable -> L10 Exception -> L24 Throwable -> L26
    L33:
        extJarAvail = false;     // Catch: Throwable -> L10
        return false;
    L29:
        extJarAvail = false;     // Catch: Throwable -> L10
        return false;
    L7:
        if (activityServiceObj == null) goto L12;
        monitor-exit(ActivityPluginDelegate.class);
        return true;
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean getFeatureFlag() {
        monitor-enter(ActivityPluginDelegate.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (isEnabled == true) goto L18;
        if (mGetFeatureEnableRetryCount == 0) goto L18;
        if (Settings.Global.getInt(ActivityThread.currentApplication().getApplicationContext().getContentResolver(), FOREGROUND_ACTIVITY_TRIGGER, 1) != 1) goto L12;
        boolean r1 = true;
    L13:
        isEnabled = r1;     // Catch: Throwable -> L16
        mGetFeatureEnableRetryCount--;     // Catch: Throwable -> L16
        boolean r2 = isEnabled;     // Catch: Throwable -> L16
        monitor-exit(ActivityPluginDelegate.class);
        return r2;
    L12:
        r1 = false;
    L18:
        boolean r3 = isEnabled;     // Catch: Throwable -> L16
        monitor-exit(ActivityPluginDelegate.class);
        return r3;
    }
}

package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.agent.monitor.MonitorTool;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class AppInstrumentation {
    private static final String TAG = "AppInstrumentation";
    private static long attachBaseContextEndTime;
    private static long attachBaseContextStartTime;
    private static long constructorEndTime;
    private static long constructorStartTime;
    private static boolean isValid;
    private static long launcherActivityCreateEndTime;
    private static long launcherActivityCreateStartTime;
    private static String launcherActivityName;
    private static long launcherActivityOnWindowFocusChangedTime;
    private static long launcherActivityResumeEndTime;
    private static long launcherActivityResumeStartTime;
    private static long onCreateEndTime;
    private static long onCreateStartTime;

    public AppInstrumentation() {
    }

    public static void launcherActivityOnWindowFocusChangedEnd() {
    }

    public static void attachBaseContextEnd() {
        if (attachBaseContextEndTime != 0) goto L6;
        attachBaseContextEndTime = System.currentTimeMillis();
        return;
    }

    public static void attachBaseContextStart() {
        if (attachBaseContextStartTime != 0) goto L6;
        attachBaseContextStartTime = System.currentTimeMillis();
        return;
    }

    public static void initEnd() {
        if (constructorEndTime != 0) goto L6;
        constructorEndTime = System.currentTimeMillis();
        return;
    }

    public static void initStart() {
        if (constructorStartTime != 0) goto L6;
        constructorStartTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnCreateEnd() {
        if (launcherActivityCreateEndTime == 0) goto L5;
        return;
    L5:
        if (isValid == false) goto L9;
        launcherActivityCreateEndTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnResumeEnd() {
        if (launcherActivityResumeEndTime == 0) goto L5;
        return;
    L5:
        if (isValid == false) goto L9;
        launcherActivityResumeEndTime = System.currentTimeMillis();
        return;
    }

    public static void onCreateEnd() {
        if (onCreateEndTime != 0) goto L6;
        onCreateEndTime = System.currentTimeMillis();
        return;
    }

    public static void onCreateStart() {
        if (onCreateStartTime != 0) goto L6;
        onCreateStartTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnCreateStart(String r100) {
        if (launcherActivityCreateStartTime != 0) goto L8;
        long r101 = System.currentTimeMillis();
        launcherActivityCreateStartTime = r101;
        if ((r101 - onCreateEndTime) >= 800) goto L9;
        isValid = true;
        launcherActivityName = r100;
        return;
    L9:
        return;
    }

    public static void launcherActivityOnResumeStart(String r100) {
        if (launcherActivityResumeStartTime == 0) goto L5;
        return;
    L5:
        if (isValid == false) goto L9;
        launcherActivityResumeStartTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnWindowFocusChangedStart(String r110) {
        if (launcherActivityOnWindowFocusChangedTime == 0) goto L5;
        return;
    L5:
        if (onCreateStartTime > 0) goto L7;
        return;
    L7:
        if (isValid == false) goto L20;
        long r100 = System.currentTimeMillis();
        launcherActivityOnWindowFocusChangedTime = r100;
        long r101 = r100 - constructorStartTime;
        if (r101 > 0) goto L11;
        return;
    L11:
        if (r101 >= 15000) goto L22;
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L15
        r102.put("application_constructor", constructorEndTime - constructorStartTime);     // Catch: Exception -> L15
        r102.put("application_attachBaseContext", attachBaseContextEndTime - attachBaseContextStartTime);     // Catch: Exception -> L15
        r102.put("application_onCreate", onCreateEndTime - onCreateStartTime);     // Catch: Exception -> L15
        r102.put("launcher_activity_onCreate", launcherActivityCreateEndTime - launcherActivityCreateStartTime);     // Catch: Exception -> L15
        r102.put("launcher_activity_onResume", launcherActivityResumeEndTime - launcherActivityResumeStartTime);     // Catch: Exception -> L15
        r102.put("app_to_first_activity_windowfocus", r101);     // Catch: Exception -> L15
        r102.put("app_to_first_activity_windowfocus#" + launcherActivityName, r101);     // Catch: Exception -> L15
        r102.put("launcher_activity_onCreate#" + launcherActivityName, launcherActivityCreateEndTime - launcherActivityCreateStartTime);     // Catch: Exception -> L15
        r102.put("launcher_activity_onResume#" + launcherActivityName, launcherActivityResumeEndTime - launcherActivityResumeStartTime);     // Catch: Exception -> L15
        MonitorTool.monitorStart(r102, constructorStartTime, launcherActivityResumeEndTime);     // Catch: Exception -> L15
    L13:
        onCreateStartTime = 0;
        isValid = false;
        return;
    L22:
        return;
    }
}

package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.agent.b.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AppInstrumentation {
    private static final String TAG = "AppInstrumentation";
    private static long attachBaseContextEndTime = 0;
    private static long attachBaseContextStartTime = 0;
    private static long constructorEndTime = 0;
    private static long constructorStartTime = 0;
    private static boolean isValid = false;
    private static long launcherActivityCreateEndTime;
    private static long launcherActivityCreateStartTime;
    private static String launcherActivityName;
    private static long launcherActivityOnWindowFocusChangedTime;
    private static long launcherActivityResumeEndTime;
    private static long launcherActivityResumeStartTime;
    private static long onCreateEndTime;
    private static long onCreateStartTime;

    static {
    }

    public static void launcherActivityOnWindowFocusChangedEnd() {
    }

    public AppInstrumentation() {
    }

    public static void initStart() {
        if (constructorStartTime != 0) goto L6;
        constructorStartTime = System.currentTimeMillis();
        return;
    }

    public static void initEnd() {
        if (constructorEndTime != 0) goto L6;
        constructorEndTime = System.currentTimeMillis();
        return;
    }

    public static void attachBaseContextStart() {
        if (attachBaseContextStartTime != 0) goto L6;
        attachBaseContextStartTime = System.currentTimeMillis();
        return;
    }

    public static void attachBaseContextEnd() {
        if (attachBaseContextEndTime != 0) goto L6;
        attachBaseContextEndTime = System.currentTimeMillis();
        return;
    }

    public static void onCreateStart() {
        if (onCreateStartTime != 0) goto L6;
        onCreateStartTime = System.currentTimeMillis();
        return;
    }

    public static void onCreateEnd() {
        if (onCreateEndTime != 0) goto L6;
        onCreateEndTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnCreateStart(String r4) {
        if (launcherActivityCreateStartTime != 0) goto L8;
        long r0 = System.currentTimeMillis();
        launcherActivityCreateStartTime = r0;
        if ((r0 - onCreateEndTime) >= 800) goto L9;
        isValid = true;
        launcherActivityName = r4;
        return;
    L9:
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

    public static void launcherActivityOnResumeStart(String r4) {
        if (launcherActivityResumeStartTime == 0) goto L5;
        return;
    L5:
        if (isValid == false) goto L9;
        launcherActivityResumeStartTime = System.currentTimeMillis();
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

    public static void launcherActivityOnWindowFocusChangedStart(String r9) {
        if (launcherActivityOnWindowFocusChangedTime == 0) goto L5;
        return;
    L5:
        if (onCreateStartTime > 0) goto L7;
        return;
    L7:
        if (isValid == false) goto L20;
        long r0 = System.currentTimeMillis();
        launcherActivityOnWindowFocusChangedTime = r0;
        long r1 = r0 - constructorStartTime;
        if (r1 > 0) goto L11;
        return;
    L11:
        if (r1 >= 15000) goto L22;
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L15
        r10.put("application_constructor", constructorEndTime - constructorStartTime);     // Catch: Exception -> L15
        r10.put("application_attachBaseContext", attachBaseContextEndTime - attachBaseContextStartTime);     // Catch: Exception -> L15
        r10.put("application_onCreate", onCreateEndTime - onCreateStartTime);     // Catch: Exception -> L15
        r10.put("launcher_activity_onCreate", launcherActivityCreateEndTime - launcherActivityCreateStartTime);     // Catch: Exception -> L15
        r10.put("launcher_activity_onResume", launcherActivityResumeEndTime - launcherActivityResumeStartTime);     // Catch: Exception -> L15
        r10.put("app_to_first_activity_windowfocus", r1);     // Catch: Exception -> L15
        r10.put("app_to_first_activity_windowfocus#" + launcherActivityName, r1);     // Catch: Exception -> L15
        r10.put("launcher_activity_onCreate#" + launcherActivityName, launcherActivityCreateEndTime - launcherActivityCreateStartTime);     // Catch: Exception -> L15
        r10.put("launcher_activity_onResume#" + launcherActivityName, launcherActivityResumeEndTime - launcherActivityResumeStartTime);     // Catch: Exception -> L15
        a.a(r10, constructorStartTime, launcherActivityResumeEndTime);     // Catch: Exception -> L15
    L13:
        onCreateStartTime = 0;
        isValid = false;
        return;
    L22:
        return;
    }
}

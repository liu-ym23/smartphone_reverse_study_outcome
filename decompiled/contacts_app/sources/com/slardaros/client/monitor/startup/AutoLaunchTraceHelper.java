package com.slardaros.client.monitor.startup;

import android.util.Log;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.slardaros.client.SlardarAgent;
import com.slardaros.client.monitor.Util;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class AutoLaunchTraceHelper {
    private static long sAttachBaseContextEndTime;
    private static long sAttachBaseContextStartTime;
    private static long sConstructorEndTime;
    private static long sConstructorStartTime;
    private static boolean sIsValid;
    private static long sLauncherActivityCreateEndTime;
    private static long sLauncherActivityCreateStartTime;
    public static String sLauncherActivityName;
    private static long sLauncherActivityOnWindowFocusChangedTime;
    private static long sLauncherActivityResumeEndTime;
    private static long sLauncherActivityResumeStartTime;
    private static long sLauncherActivityStartEndTime;
    private static long sLauncherActivityStartStartTime;
    private static long sOnCreateEndTime;
    private static long sOnCreateStartTime;

    public AutoLaunchTraceHelper() {
    }

    public static void assignAppTime(long r0, long r2, long r4, long r6, long r8, long r10) {
        sConstructorStartTime = r0;
        sConstructorEndTime = r2;
        sAttachBaseContextStartTime = r4;
        sAttachBaseContextEndTime = r6;
        sOnCreateStartTime = r8;
        sOnCreateEndTime = r10;
    }

    public static void launcherActivityOnCreateStart(String r4) {
        Log.d("monitor plugin", "launcherActivityOnCreateStart");
        if (sLauncherActivityCreateStartTime != 0) goto L8;
        long r0 = System.currentTimeMillis();
        sLauncherActivityCreateStartTime = r0;
        if ((r0 - sOnCreateEndTime) >= 800) goto L9;
        sIsValid = true;
        sLauncherActivityName = r4;
        return;
    L9:
        return;
    }

    public static void launcherActivityOnCreateEnd() {
        Log.d("monitor plugin", "launcherActivityOnCreateEnd");
        if (sLauncherActivityCreateEndTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityCreateEndTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnStartStart(String r4) {
        Log.d("monitor plugin", "launcherActivityOnStartStart");
        if (sLauncherActivityStartStartTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityStartStartTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnStartEnd(String r4) {
        Log.d("monitor plugin", "launcherActivityOnStartStart");
        if (sLauncherActivityStartEndTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityStartEndTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnResumeStart(String r4) {
        if (sLauncherActivityResumeStartTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityResumeStartTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnResumeEnd() {
        if (sLauncherActivityResumeEndTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityResumeEndTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnWindowFocusChangedStart(String r4) {
        if (sLauncherActivityOnWindowFocusChangedTime == 0) goto L5;
    L9:
        new Thread(new AnonymousClass1()).start();
        return;
    L5:
        if (sOnCreateStartTime <= 0) goto L9;
        if (sIsValid == false) goto L9;
        sLauncherActivityOnWindowFocusChangedTime = System.currentTimeMillis();
        sLauncherActivityName = r4;
        sIsValid = false;
        goto L9
    }

    public static void reportStats() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("is_first_start", SlardarAgent.isFirstInstall());     // Catch: JSONException -> L4
        r0.put("activity_name", sLauncherActivityName);     // Catch: JSONException -> L4
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L4
        r1.put("app_construct_time", sConstructorEndTime - sConstructorStartTime);     // Catch: JSONException -> L4
        r1.put("app_attach_base_context_time", sAttachBaseContextEndTime - sAttachBaseContextStartTime);     // Catch: JSONException -> L4
        r1.put("app_create_time", sOnCreateEndTime - sOnCreateStartTime);     // Catch: JSONException -> L4
        r1.put("activity_create_time", sLauncherActivityCreateEndTime - sLauncherActivityCreateStartTime);     // Catch: JSONException -> L4
        r1.put("activity_start_time", sLauncherActivityStartEndTime - sLauncherActivityStartStartTime);     // Catch: JSONException -> L4
        r1.put("activity_resume_time", sLauncherActivityResumeEndTime - sLauncherActivityResumeStartTime);     // Catch: JSONException -> L4
        r1.put("activity_window_focus_changed", sLauncherActivityOnWindowFocusChangedTime - sLauncherActivityResumeEndTime);     // Catch: JSONException -> L4
        r1.put(ICronetClient.KEY_TOTAL_TIME, sLauncherActivityOnWindowFocusChangedTime - sConstructorStartTime);     // Catch: JSONException -> L4
        Util.sendMetricEvent(com.slardaros.client.Constants.METRIC_EVENT_STARTUP, r0, r1, null);     // Catch: JSONException -> L4
        return;
    }
}

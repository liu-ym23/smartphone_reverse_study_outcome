package com.bytedance.apm.agent.tracing;

import androidx.annotation.WorkerThread;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.thread.AsyncEventManager;
import m1.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r1.a;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public class AutoLaunchTraceHelper {
    private static long sAttachBaseContextEndTime = 0;
    private static long sAttachBaseContextStartTime = 0;
    private static long sConstructorEndTime = 0;
    private static long sConstructorStartTime = 0;
    private static boolean sIsValid = false;
    private static long sLauncherActivityCreateEndTime = 0;
    private static long sLauncherActivityCreateStartTime = 0;
    public static String sLauncherActivityName = null;
    private static long sLauncherActivityOnWindowFocusChangedTime = 0;
    private static long sLauncherActivityResumeEndTime = 0;
    private static long sLauncherActivityResumeStartTime = 0;
    private static long sLauncherActivityStartEndTime = 0;
    private static long sLauncherActivityStartStartTime = 0;
    private static long sMaxValidTimeMs = 15000;
    private static long sOnCreateEndTime;
    private static long sOnCreateStartTime;

    static {
    }

    public AutoLaunchTraceHelper() {
    }

    public static JSONArray assemblySpan() throws JSONException {
        JSONArray r10 = new JSONArray();
        JSONObject r11 = new JSONObject();
        r11.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        r11.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "app_constructor");
        r11.put("start", sConstructorStartTime);
        r11.put("end", sConstructorEndTime);
        JSONObject r12 = new JSONObject();
        r12.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        r12.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "app_attachBaseContext");
        r12.put("start", sAttachBaseContextStartTime);
        r12.put("end", sAttachBaseContextEndTime);
        JSONObject r13 = new JSONObject();
        r13.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        r13.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "app_onCreate");
        r13.put("start", sOnCreateStartTime);
        r13.put("end", sOnCreateEndTime);
        JSONObject r14 = new JSONObject();
        r14.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        r14.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "activity_onCreate");
        r14.put("start", sLauncherActivityCreateStartTime);
        r14.put("end", sLauncherActivityCreateEndTime);
        JSONObject r15 = new JSONObject();
        r15.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        r15.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "activity_onResume");
        r15.put("start", sLauncherActivityResumeStartTime);
        r15.put("end", sLauncherActivityResumeEndTime);
        JSONObject r16 = new JSONObject();
        r16.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        r16.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "activity_onStart");
        r16.put("start", sLauncherActivityStartStartTime);
        r16.put("end", sLauncherActivityStartEndTime);
        if (sLauncherActivityOnWindowFocusChangedTime <= 0) goto L5;
        JSONObject r17 = new JSONObject();
        r17.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        r17.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "activity_onWindowFocusChanged");
        r17.put("start", sLauncherActivityOnWindowFocusChangedTime);
        r10.put(r17);
    L5:
        r10.put(r11);
        r10.put(r12);
        r10.put(r13);
        r10.put(r14);
        r10.put(r15);
        r10.put(r16);
        return r10;
    }

    public static void assignAppTime(long r10, long r11, long r12, long r13, long r14, long r15) {
        a.b().d("assignAppTime: " + sOnCreateEndTime);
        sConstructorStartTime = r10;
        sConstructorEndTime = r11;
        sAttachBaseContextStartTime = r12;
        sAttachBaseContextEndTime = r13;
        sOnCreateStartTime = r14;
        sOnCreateEndTime = r15;
        c.K(r10);
    }

    public static void launcherActivityOnCreateEnd() {
        a.b().d("onCreateEnd " + sLauncherActivityCreateStartTime + " " + sLauncherActivityCreateEndTime);
        if (sLauncherActivityCreateEndTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityCreateEndTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnCreateStart(String r11) {
        a r10 = a.b();
        StringBuilder r12 = new StringBuilder();
        r12.append(r11);
        r12.append(" onCreateStart ");
        r12.append(sLauncherActivityCreateStartTime);
        r12.append(" ");
        boolean r13 = false;
        if ((sLauncherActivityCreateStartTime - sOnCreateEndTime) >= 800) goto L5;
        boolean r14 = true;
    L6:
        r12.append(r14);
        r10.d(r12.toString());
        if (sLauncherActivityCreateStartTime != 0) goto L15;
        sLauncherActivityCreateStartTime = System.currentTimeMillis();
        a r15 = a.b();
        StringBuilder r16 = new StringBuilder();
        r16.append(r11);
        r16.append(" onCreateStart ");
        r16.append(sLauncherActivityCreateStartTime);
        r16.append("  ");
        r16.append(sOnCreateEndTime);
        r16.append(" ");
        if ((sLauncherActivityCreateStartTime - sOnCreateEndTime) >= 800) goto L11;
        r13 = true;
    L11:
        r16.append(r13);
        r15.d(r16.toString());
        if ((sLauncherActivityCreateStartTime - sOnCreateEndTime) >= 800) goto L16;
        sIsValid = true;
        sLauncherActivityName = r11;
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r14 = false;
        goto L6
    }

    public static void launcherActivityOnResumeEnd() {
        a.b().d("onResumeEnd " + sLauncherActivityResumeStartTime + " " + sLauncherActivityResumeEndTime);
        if (sLauncherActivityResumeEndTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityResumeEndTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnResumeStart(String r10) {
        a.b().d(r10 + " onResume " + sLauncherActivityResumeStartTime);
        if (sLauncherActivityResumeStartTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityResumeStartTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnStartEnd(String r10) {
        a.b().d("onStartEnd " + sLauncherActivityStartStartTime + " " + sLauncherActivityStartEndTime);
        if (sLauncherActivityStartEndTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityStartEndTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnStartStart(String r10) {
        a.b().d(r10 + " onStart " + sLauncherActivityStartStartTime);
        if (sLauncherActivityStartStartTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityStartStartTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnWindowFocusChangedStart(String r10) {
        a.b().d("OnWindowFocusChanged " + r10 + " " + sLauncherActivityOnWindowFocusChangedTime + " " + sOnCreateStartTime + " " + sIsValid);
        if (sLauncherActivityOnWindowFocusChangedTime == 0) goto L5;
    L9:
        AsyncEventManager.e().h(new AnonymousClass1());
        return;
    L5:
        if (sOnCreateStartTime <= 0) goto L9;
        if (sIsValid == false) goto L9;
        sLauncherActivityOnWindowFocusChangedTime = System.currentTimeMillis();
        sLauncherActivityName = r10;
        sIsValid = false;
        goto L9
    }

    @WorkerThread
    public static void reportStats() {
        if (c.t() != (-1)) goto L6;
        a.b().d("auto launch mode not init");     // Catch: JSONException -> L16
        return;
    L6:
        long r10 = sLauncherActivityOnWindowFocusChangedTime - sConstructorStartTime;     // Catch: JSONException -> L16
        if (r10 > 0) goto L9;
        return;
    L9:
        if (r10 > sMaxValidTimeMs) goto L19;
        JSONArray r11 = assemblySpan();     // Catch: JSONException -> L16
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L16
        r12.put("name", TraceStatsConsts.START_STATS_NAME);     // Catch: JSONException -> L16
        r12.put("start", sConstructorStartTime);     // Catch: JSONException -> L16
        r12.put("end", sLauncherActivityOnWindowFocusChangedTime);     // Catch: JSONException -> L16
        r12.put(TraceStatsConsts.STATS_KEY_SPANS, r11);     // Catch: JSONException -> L16
        r12.put(TraceStatsConsts.START_STATS_KEY_COLLECT_FROM, 1);     // Catch: JSONException -> L16
        r12.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, sLauncherActivityName);     // Catch: JSONException -> L16
        r12.put(TraceStatsConsts.STATS_KEY_LAUNCH_MODE, c.t());     // Catch: JSONException -> L16
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L16
        r13.put(TraceStatsConsts.STATS_KEY_TRACE, r12);     // Catch: JSONException -> L16
        if (c.B() == false) goto L14;
        a.b().d("auto span: " + r12);     // Catch: JSONException -> L16
    L14:
        l1.a.p().e(new e("start_trace", "", null, null, r13));     // Catch: JSONException -> L16
        return;
    L19:
        return;
    }

    public static void setMaxValidTimeMs(long r10) {
        sMaxValidTimeMs = r10;
    }
}

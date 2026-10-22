package com.bytedance.apm.agent.tracing;

import android.content.Context;
import bt3.b;
import com.bytedance.apm.d;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import js3.e;
import ns3.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
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

    public AutoLaunchTraceHelper() {
    }

    public static JSONArray assemblySpan() throws JSONException {
        JSONArray r100 = new JSONArray();
        JSONObject r101 = new JSONObject();
        r101.put("module_name", "base");
        r101.put("span_name", "app_constructor");
        r101.put("start", sConstructorStartTime);
        r101.put("end", sConstructorEndTime);
        JSONObject r102 = new JSONObject();
        r102.put("module_name", "base");
        r102.put("span_name", "app_attachBaseContext");
        r102.put("start", sAttachBaseContextStartTime);
        r102.put("end", sAttachBaseContextEndTime);
        JSONObject r103 = new JSONObject();
        r103.put("module_name", "base");
        r103.put("span_name", "app_onCreate");
        r103.put("start", sOnCreateStartTime);
        r103.put("end", sOnCreateEndTime);
        JSONObject r104 = new JSONObject();
        r104.put("module_name", "base");
        r104.put("span_name", "activity_onCreate");
        r104.put("start", sLauncherActivityCreateStartTime);
        r104.put("end", sLauncherActivityCreateEndTime);
        JSONObject r110 = new JSONObject();
        r110.put("module_name", "base");
        r110.put("span_name", "activity_onResume");
        r110.put("start", sLauncherActivityResumeStartTime);
        r110.put("end", sLauncherActivityResumeEndTime);
        JSONObject r111 = new JSONObject();
        r111.put("module_name", "base");
        r111.put("span_name", "activity_onStart");
        r111.put("start", sLauncherActivityStartStartTime);
        r111.put("end", sLauncherActivityStartEndTime);
        if (sLauncherActivityOnWindowFocusChangedTime <= 0) goto L5;
        JSONObject r105 = new JSONObject();
        r105.put("module_name", "base");
        r105.put("span_name", "activity_onWindowFocusChanged");
        r105.put("start", sLauncherActivityOnWindowFocusChangedTime);
        r100.put(r105);
    L5:
        r100.put(r101);
        r100.put(r102);
        r100.put(r103);
        r100.put(r104);
        r100.put(r110);
        r100.put(r111);
        return r100;
    }

    public static void launcherActivityOnCreateEnd() {
        a r100 = a.C6968a.f520287a;
        d.j();
        if (sLauncherActivityCreateEndTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityCreateEndTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnResumeEnd() {
        a r100 = a.C6968a.f520287a;
        d.j();
        if (sLauncherActivityResumeEndTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityResumeEndTime = System.currentTimeMillis();
        return;
    }

    public static void reportStats() {
        if (d.f190525m != (-1)) goto L6;
        a r100 = a.C6968a.f520287a;     // Catch: JSONException -> L16
        d.j();     // Catch: JSONException -> L16
        return;
    L6:
        long r101 = sLauncherActivityOnWindowFocusChangedTime - sConstructorStartTime;     // Catch: JSONException -> L16
        if (r101 > 0) goto L9;
        return;
    L9:
        if (r101 > sMaxValidTimeMs) goto L19;
        JSONArray r102 = assemblySpan();     // Catch: JSONException -> L16
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L16
        r103.put("name", "launch_stats");     // Catch: JSONException -> L16
        r103.put("start", sConstructorStartTime);     // Catch: JSONException -> L16
        r103.put("end", sLauncherActivityOnWindowFocusChangedTime);     // Catch: JSONException -> L16
        r103.put("spans", r102);     // Catch: JSONException -> L16
        r103.put("collect_from", 1);     // Catch: JSONException -> L16
        r103.put("page_name", sLauncherActivityName);     // Catch: JSONException -> L16
        r103.put(AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD, d.f190525m);     // Catch: JSONException -> L16
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L16
        r104.put("trace", r103);     // Catch: JSONException -> L16
        if (d.j() == false) goto L14;
        a r105 = a.C6968a.f520287a;     // Catch: JSONException -> L16
        r103.toString();     // Catch: JSONException -> L16
        d.j();     // Catch: JSONException -> L16
    L14:
        e r106 = new e("start_trace", "", null, null, r104);     // Catch: JSONException -> L16
        is3.a.h().b(r106);     // Catch: JSONException -> L16
        return;
    L19:
        return;
    }

    public static void launcherActivityOnCreateStart(String r100) {
        a r101 = a.C6968a.f520287a;
        d.j();
        if (sLauncherActivityCreateStartTime != 0) goto L8;
        sLauncherActivityCreateStartTime = System.currentTimeMillis();
        d.j();
        if ((sLauncherActivityCreateStartTime - sOnCreateEndTime) >= 800) goto L9;
        sIsValid = true;
        sLauncherActivityName = r100;
        return;
    L9:
        return;
    }

    public static void launcherActivityOnResumeStart(String r100) {
        a r101 = a.C6968a.f520287a;
        d.j();
        if (sLauncherActivityResumeStartTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityResumeStartTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnStartEnd(String r100) {
        a r101 = a.C6968a.f520287a;
        d.j();
        if (sLauncherActivityStartEndTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityStartEndTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnStartStart(String r100) {
        a r101 = a.C6968a.f520287a;
        d.j();
        if (sLauncherActivityStartStartTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityStartStartTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnWindowFocusChangedStart(String r100) {
        a r101 = a.C6968a.f520287a;
        d.j();
        if (sLauncherActivityOnWindowFocusChangedTime == 0) goto L5;
    L9:
        b.d.f20539a.e(new AnonymousClass1());
        return;
    L5:
        if (sOnCreateStartTime <= 0) goto L9;
        if (sIsValid == false) goto L9;
        sLauncherActivityOnWindowFocusChangedTime = System.currentTimeMillis();
        sLauncherActivityName = r100;
        sIsValid = false;
        goto L9
    }

    public static void setMaxValidTimeMs(long r100) {
        sMaxValidTimeMs = r100;
    }

    public static void assignAppTime(long r100, long r101, long r102, long r103, long r104, long r110) {
        a r105 = a.C6968a.f520287a;
        Context r106 = d.f190513a;
        sConstructorStartTime = r100;
        sConstructorEndTime = r101;
        sAttachBaseContextStartTime = r102;
        sAttachBaseContextEndTime = r103;
        sOnCreateStartTime = r104;
        sOnCreateEndTime = r110;
        if (r100 <= 0) goto L12;
        long r107 = d.f190527o;
        if (r107 != 0) goto L8;
    L9:
        d.f190527o = r100;
        return;
    L8:
        if (r100 < r107) goto L9;
        return;
    }
}

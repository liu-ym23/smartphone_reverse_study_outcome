package com.bytedance.framwork.core.monitor;

import android.util.Log;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.internal.ApmDelegate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class MonitorUtils {
    public static final String MSG_TIP_NOTHING_TO_DO_PLEASE_NOT_USE = "nothing to do, implementation code has been removed in version 5+";
    public static final String TAG_DEPRECATED = "Deprecated";

    @Deprecated
    public static void setIsBackGround(boolean r0) {
    }

    public MonitorUtils() {
    }

    @Deprecated
    public static void setDebugMode() {
        ApmContext.setDebugMode(true);
    }

    public static void monitorPerformance(String r0, JSONObject r1, JSONObject r2, JSONObject r3) {
        ApmAgent.monitorPerformance(r0, r1, r2, r3);
    }

    public static void monitorPerformance(String r0, String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
        ApmAgent.monitorPerformance(r0, r1, r2, r3, r4);
    }

    public static void monitorUIAction(String r0, String r1, JSONObject r2) {
        ApmAgent.monitorUIAction(r0, r1, r2);
    }

    @Deprecated
    public static void monitorSLA(long r0, long r2, String r4, String r5, String r6, int r7, JSONObject r8) {
        ApmAgent.monitorSLA(r0, r2, r4, r5, r6, r7, r8);
    }

    @Deprecated
    public static void monitorApiError(long r0, long r2, String r4, String r5, String r6, int r7, JSONObject r8) {
        ApmAgent.monitorApiError(r0, r2, r4, r5, r6, r7, r8);
    }

    public static void monitorEvent(String r0, JSONObject r1, JSONObject r2, JSONObject r3) {
        ApmAgent.monitorEvent(r0, r1, r2, r3);
    }

    @Deprecated
    public static void monitorStatusRate(String r0, int r1, JSONObject r2) {
        ApmAgent.monitorStatusRate(r0, r1, r2);
    }

    @Deprecated
    public static void monitorStatusAndDuration(String r0, int r1, JSONObject r2, JSONObject r3) {
        ApmAgent.monitorStatusAndDuration(r0, r1, r2, r3);
    }

    @Deprecated
    public static void monitorDuration(String r0, JSONObject r1, JSONObject r2) {
        ApmAgent.monitorDuration(r0, r1, r2);
    }

    @Deprecated
    public static void monitorDuration(String r0, JSONObject r1, JSONObject r2, long r3) {
        ApmAgent.monitorDuration(r0, r1, r2, r3);
    }

    @Deprecated
    public static void monitorDirectOnTimer(String r0, String r1, float r2) {
        ApmAgent.monitorDirectOnTimer(r0, r1, r2);
    }

    @Deprecated
    public static void monitorOnTimer(String r0, String r1, float r2) {
        Log.e("Deprecated", "nothing to do, implementation code has been removed in version 5+");
    }

    @Deprecated
    public static void monitorOnCount(String r0, String r1, float r2) {
        Log.e("Deprecated", "nothing to do, implementation code has been removed in version 5+");
    }

    @Deprecated
    public static void monitorOnCount(String r0, String r1) {
        Log.e("Deprecated", "nothing to do, implementation code has been removed in version 5+");
    }

    @Deprecated
    public static void monitorDirectOnCount(String r0, String r1, float r2) {
        Log.e("Deprecated", "nothing to do, implementation code has been removed in version 5+");
    }

    public static void monitorCommonLog(String r0, JSONObject r1) {
        ApmAgent.monitorCommonLog(r0, r1);
    }

    public static void monitorCommonLog(String r0, JSONObject r1, boolean r2) {
        ApmAgent.monitorCommonLog(r0, r1, r2);
    }

    public static void monitorStartTime(String r3, float r4) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put(r3, r4);     // Catch: Exception -> L4
        monitorPerformance("start", r3, r0, null, null);     // Catch: Exception -> L4
        return;
    }

    @Deprecated
    public static void monitorOnStore(String r0, String r1, float r2) {
        Log.e("Deprecated", "nothing to do, implementation code has been removed in version 5+");
    }

    @Deprecated
    public static void monitorDebugReal(String r0, String r1) {
        Log.e("Deprecated", "nothing to do, implementation code has been removed in version 5+");
    }

    @Deprecated
    public static void monitorDebugReal(String r1) {
        Log.e("Deprecated", "nothing to do, implementation code has been removed in version 5+");
    }

    public static boolean getLogTypeSwitch(String r1) {
        return ApmDelegate.getInstance().getLogTypeSwitch(r1);
    }

    public static boolean getServiceNameSwitch(String r1) {
        return ApmDelegate.getInstance().getServiceNameSwitch(r1);
    }

    public static boolean getMetricsTypeSwitch(String r1) {
        return ApmDelegate.getInstance().getMetricsTypeSwitch(r1);
    }
}

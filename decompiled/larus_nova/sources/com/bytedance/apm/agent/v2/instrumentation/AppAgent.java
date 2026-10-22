package com.bytedance.apm.agent.v2.instrumentation;

import android.text.TextUtils;
import com.bytedance.apm.agent.tracing.AutoLaunchTraceHelper;

/* JADX INFO: loaded from: classes14.dex */
public class AppAgent {
    private static final String ATTACH_BASE_CONTEXT = "attachBaseContext";
    private static final String CONSTRUCT = "<init>";
    private static final String ON_CREATE = "onCreate";
    private static long attachBaseContextEndTime;
    private static long attachBaseContextStartTime;
    private static long constructorEndTime;
    private static long constructorStartTime;
    private static long onCreateEndTime;
    private static long onCreateStartTime;

    public AppAgent() {
    }

    public static void onTrace(String r110, boolean r111) {
        if (TextUtils.equals(r110, CONSTRUCT) == false) goto L8;
        if (r111 == false) goto L6;
        constructorStartTime = System.currentTimeMillis();
        return;
    L6:
        constructorEndTime = System.currentTimeMillis();
        return;
    L8:
        if (TextUtils.equals(r110, ATTACH_BASE_CONTEXT) == false) goto L13;
        if (r111 == false) goto L11;
        attachBaseContextStartTime = System.currentTimeMillis();
        return;
    L11:
        attachBaseContextEndTime = System.currentTimeMillis();
        return;
    L13:
        if (TextUtils.equals(r110, "onCreate") == false) goto L22;
        if (r111 == false) goto L16;
        onCreateStartTime = System.currentTimeMillis();
        return;
    L16:
        long r112 = System.currentTimeMillis();
        onCreateEndTime = r112;
        AutoLaunchTraceHelper.assignAppTime(constructorStartTime, constructorEndTime, attachBaseContextStartTime, attachBaseContextEndTime, onCreateStartTime, r112);
        return;
    }
}

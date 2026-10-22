package com.bytedance.vmsdk.monitor;

import android.util.Log;
import com.bytedance.framwork.core.sdkmonitor.h;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class VmSdkMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f11770a = "VmSdkMonitor";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile h f11771b;

    static class a {
        private static String a(Object... r5) {
            StringBuilder r0 = new StringBuilder();
            int r1 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L10;
            Object r3 = r5[r2];
            r0.append(" ");
            if (r3 == null) goto L7;
            r0.append(r3);
        L8:
            r2 = r2 + 1;
            goto L3
        L7:
            r0.append("null");
            goto L8
        L10:
            return r0.toString();
        }

        public static void a(String r0, Object... r1) {
            a(r0, a(r1));
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }
    }

    static {
    }

    public VmSdkMonitor() {
    }

    public static void a(String r5, JSONObject r6, JSONObject r7, JSONObject r8) {
        if (f11771b == null) goto L5;
        f11771b.a(r5, r6, r7, r8);
    L6:
        a.a(f11770a, new Object[]{r5, r6, r7, r8});
        return;
    L5:
        a.a(f11770a, new Object[]{"VmSdkMonitor is null"});
        goto L6
    }

    private static void monitorEvent(String r3, String r4, String r5, String r6) {
        a(f11770a, "monitorEvent from native, moduleName:" + r3 + " bizName:" + r4 + " dataKey:" + r5 + " dataValue:" + r6);
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L5
        r0.put("biz_name", r4);     // Catch: Throwable -> L5
        r0.put(r5, r6);     // Catch: Throwable -> L5
        a(r3, r0, null, null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        b(f11770a, "VmSdkMonitor upload error: " + th.getMessage());
    }

    private static boolean getSettings(String r4) {
        boolean r0 = com.bytedance.vmsdk.c.a.a().a(r4);
        a(f11770a, "VmSdkMonitor getSettings from native, key:" + r4 + " value: " + r0);
        return r0;
    }

    private static int getSettingsFlag() {
        int r0 = com.bytedance.vmsdk.c.a.a().b();
        a(f11770a, "VmSdkMonitor getSettingsFlag from native value: " + r0);
        return r0;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }
}

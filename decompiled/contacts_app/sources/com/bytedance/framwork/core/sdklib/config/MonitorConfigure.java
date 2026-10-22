package com.bytedance.framwork.core.sdklib.config;

import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MonitorConfigure {
    private static ConcurrentHashMap<String, IMonitorConfigure> sAid2MonitorCogfigMap;
    private static IMonitorConfigure sDefCommonConfig;

    public MonitorConfigure() {
    }

    static {
        sDefCommonConfig = new DefaultMonitorConfigure();
        ConcurrentHashMap<String, IMonitorConfigure> r0 = new ConcurrentHashMap();
        sAid2MonitorCogfigMap = r0;
        r0.put("default", sDefCommonConfig);
    }

    public static void setCommonConfig(IMonitorConfigure r1) {
        sDefCommonConfig = r1;
        setCommonConfig("default", r1);
    }

    public static void setCommonConfig(String r1, IMonitorConfigure r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        sAid2MonitorCogfigMap.put(r1, r2);
    }

    public static int getReportInterval(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L9;
        if (sAid2MonitorCogfigMap.get(r1) == null) goto L9;
        return sAid2MonitorCogfigMap.get(r1).reportInterval();
    L9:
        return sDefCommonConfig.reportInterval();
    }

    public static int getReportCount(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L9;
        if (sAid2MonitorCogfigMap.get(r1) == null) goto L9;
        return sAid2MonitorCogfigMap.get(r1).reportCount();
    L9:
        return sDefCommonConfig.reportCount();
    }

    public static List<String> getReportUrl(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == true) goto L9;
        if (sAid2MonitorCogfigMap.get(r1) == null) goto L9;
        return sAid2MonitorCogfigMap.get(r1).reportUrl(r2);
    L9:
        return sDefCommonConfig.reportUrl(r2);
    }

    public static JSONObject getReportJsonHeaderInfo(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L9;
        if (sAid2MonitorCogfigMap.get(r1) == null) goto L9;
        return sAid2MonitorCogfigMap.get(r1).reportJsonHeaderInfo();
    L9:
        return sDefCommonConfig.reportJsonHeaderInfo();
    }

    public static int getReportFailRepeatCount(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L9;
        if (sAid2MonitorCogfigMap.get(r1) == null) goto L9;
        return sAid2MonitorCogfigMap.get(r1).reportFailRepeatCount();
    L9:
        return sDefCommonConfig.reportFailRepeatCount();
    }

    public static int getReportFailBaseTime(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L9:
        int r2 = sDefCommonConfig.reportFailRepeatBaseTime();
    L8:
        return r2 * 1000;
    L5:
        if (sAid2MonitorCogfigMap.get(r1) == null) goto L9;
        r2 = sAid2MonitorCogfigMap.get(r1).reportFailRepeatBaseTime();
        goto L8
    }

    public static long getStopMoreChannelInterval(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        if (sAid2MonitorCogfigMap.get(r2) == null) goto L9;
        return sAid2MonitorCogfigMap.get(r2).stopMoreChannelInterval();
    L9:
        return sDefCommonConfig.stopMoreChannelInterval();
    }

    public static boolean getLogRemoveSwitch(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L9;
        if (sAid2MonitorCogfigMap.get(r1) == null) goto L9;
        return sAid2MonitorCogfigMap.get(r1).getRemoveSwitch();
    L9:
        return sDefCommonConfig.getRemoveSwitch();
    }

    public static long getMaxMonitorLogSaveCount(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        if (sAid2MonitorCogfigMap.get(r2) == null) goto L9;
        return sAid2MonitorCogfigMap.get(r2).getMonitorLogMaxSaveCount();
    L9:
        return sDefCommonConfig.getMonitorLogMaxSaveCount();
    }
}

package com.bytedance.amap.depend;

import android.text.TextUtils;
import com.bytedance.map.api.MapGlobalConfig;
import com.bytedance.map.api.monitor.IMonitorDepend;
import com.ss.android.common.applog.AppLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public class MonitorDependImpl implements IMonitorDepend {
    private static final String OVERSEA_DEFAULT_APP_ID = "1128";
    private static final String OVERSEA_DEFAULT_CONFIG_URL = "https://mon.snssdk.com/monitor/appmonitor/v2/settings";
    private static final String OVERSEA_DEFAULT_REPORT_URL = "https://mon.snssdk.com/monitor/collect/";
    private static volatile MonitorDependImpl sInstance;

    public MonitorDependImpl() {
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public Map<String, String> getCommonParams() {
        return null;
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public String getSessionId() {
        return null;
    }

    public static MonitorDependImpl getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(MonitorDependImpl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new MonitorDependImpl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MonitorDependImpl.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public List<String> getConfigUrls() {
        ArrayList r100 = new ArrayList();
        r100.add(OVERSEA_DEFAULT_CONFIG_URL);
        return r100;
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public List<String> getReportUrls() {
        ArrayList r100 = new ArrayList();
        r100.add("https://mon.snssdk.com/monitor/collect/");
        return r100;
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public String getAppId() {
        if (TextUtils.isEmpty(MapGlobalConfig.getAppId()) == false) goto L5;
        return "1128";
    L5:
        return MapGlobalConfig.getAppId();
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public String getAppVersion() {
        return MapGlobalConfig.getAppVersion();
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public String getChannel() {
        return MapGlobalConfig.getChannel();
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public String getDeviceId() {
        if (TextUtils.isEmpty(MapGlobalConfig.getDeviceId()) == true) goto L7;
        return MapGlobalConfig.getDeviceId();
    L7:
        return AppLog.v();
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public String getPackageName() {
        return MapGlobalConfig.getPackageName();
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public String getUpdateVersion() {
        return MapGlobalConfig.getUpdateVersion();
    }
}

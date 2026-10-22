package com.bytedance.android.live.saas.middleware.applog;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public interface IAppLog {
    String addCommonParams(String r100, boolean r101);

    void addCustomHeader(String r100, String r101);

    String getAbSdkVersion();

    String getCurrentSessionId();

    String getDid();

    String getInstallId();

    boolean isTob();

    void log(String r100, Map<String, String> r101);

    void observeIdChanged(IdChangedCallback r100);

    void onEventV3(String r100, JSONObject r101);

    void putCommonParams(Map<String, String> r100, boolean r101);

    void tryWaitDeviceInit();
}

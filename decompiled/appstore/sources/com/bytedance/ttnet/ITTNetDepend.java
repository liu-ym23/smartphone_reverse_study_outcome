package com.bytedance.ttnet;

import android.content.Context;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface ITTNetDepend {
    @Deprecated
    int checkHttpRequestException(Throwable r10, String[] r11);

    @Deprecated
    String executeGet(int r10, String r11) throws Exception;

    @Deprecated
    String getApiIHostPrefix();

    int getAppId();

    @Deprecated
    String getCdnHostSuffix();

    String[] getConfigServers();

    Context getContext();

    ArrayList<String> getCookieFlushPathList();

    @Deprecated
    Map<String, String> getHostReverseMap();

    String getHostSuffix();

    int getProviderInt(Context r10, String r11, int r12);

    String getProviderString(Context r10, String r11, String r12);

    String getShareCookieMainDomain();

    Map<String, String> getTTNetServiceDomainMap();

    boolean isCronetPluginInstalled();

    boolean isPrivateApiAccessEnabled();

    void mobOnEvent(Context r10, String r11, String r12, JSONObject r13);

    void monitorLogSend(String r10, JSONObject r11);

    @Deprecated
    void onAppConfigUpdated(Context r10, JSONObject r11);

    void onColdStartFinish();

    @Deprecated
    void onNetConfigUpdate(JSONObject r10, boolean r11);

    void onShareCookieConfigUpdated(String r10);

    void saveMapToProvider(Context r10, Map<String, ?> r11);
}

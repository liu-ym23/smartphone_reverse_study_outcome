package com.bytedance.services.slardar.config;

import androidx.annotation.Nullable;
import com.bytedance.news.common.service.manager.IService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IConfigManager extends IService {
    void fetchConfig();

    int getConfigInt(String r10, int r11);

    @Nullable
    JSONObject getConfigJSON(String r10);

    boolean getLogTypeSwitch(String r10);

    boolean getMetricTypeSwitch(String r10);

    boolean getServiceSwitch(String r10);

    boolean getSwitch(String r10);

    boolean isConfigReady();

    String queryConfig();

    void registerConfigListener(IConfigListener r10);

    void registerResponseConfigListener(IResponseConfigListener r10);

    JSONObject retrieveSettingsParams();

    void unregisterConfigListener(IConfigListener r10);

    void unregisterResponseConfigListener(IResponseConfigListener r10);

    boolean updateWithSpecificAidResult(JSONObject r10);
}
